package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Map;
import java.util.Scanner;

public class ReaderForServer implements Runnable {
    private Socket socket;
    private boolean threadHasToContinue = true;

    public ReaderForServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String inputString;
        Scanner scanner = null;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().remove(socket);
            Changes.WeHaveNewContact();
        }
        while (threadHasToContinue) {
            try {
                inputString = scanner.nextLine();
                System.out.println("We Are Reading this:" + inputString);
                if (inputString.substring(0, 1).equals("@")) {
                    GameView.getGameView().getHostAndGuestView().AddMassageToHistoryAndMassageNotWrittenInGroup(inputString.substring(1));
                    Changes.WeHaveNewMassageToShow();
                    SendMassageThatIsRecivedFromOneUserForGroupToOthers(socket, inputString);
                } else if (inputString.substring(1, 2).equals("@")) {
                    //it means it is sending the information of account
                    ReaderForGuest.GetDataNotMassageFromSocket(inputString, socket);
                } else {
                    if (inputString.substring(0, 1).equals("#")) {
                        //it means it is sending the massage for other user via server
                        String destinationContactName = inputString.split("#")[0];
                        String massage = inputString.split("#")[1];
                        PVView pvView = findPvViewByUserName(destinationContactName);
                        pvView.getMassagesNotWrittenInPVView().put(massage, 100);
                        pvView.getDataToSendThatWeDidntSendThem().add(massage);
                        Changes.WeHaveNewMassageToShow();

                    } else {
                        //this means that user send server a massage and we should show in pvView
                        PVView pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                        pvView.AddDataToDataNotWritten(inputString, 10);
                        Changes.WeHaveNewMassageToShow();
                    }
                }
            } catch (Exception e) {
                PVView pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                GameView.getGameView().getHostAndGuestView().AddMassageToHistoryAndMassageNotWrittenInGroup(pvView.getContactName() + " disconnected");
                for (Map.Entry<Socket,PVView> entry:GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()){
                    entry.getValue().getDataToSendThatWeDidntSendThem().add("@" + pvView.getContactName() + " disconnected");
                }
//                GameView.getGameView().getHostAndGuestView().getMassagedidntsent().add("@" + pvView.getContactName() + " disconnected");
                Changes.WeHaveNewMassageToShow();
                GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().remove(socket);
                Changes.WeHaveNewContact();
                threadHasToContinue = false;
            }
        }
    }

    private PVView findPvViewByUserName(String userName) {
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            if (entry.getValue().getContactName().equals(userName)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private void SendMassageThatIsRecivedFromOneUserForGroupToOthers(Socket socket, String massage) throws IOException {
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            if (!entry.getKey().equals(socket)) {
                entry.getValue().getDataToSendThatWeDidntSendThem().add(massage);
            }

        }

    }
}
