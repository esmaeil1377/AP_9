package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.Internet.Changes;
import FarmModel.ObjectInMap15_15.LiveAnimals.Lion;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

import static View.ScenesAndMainGroupView.HostAndGuestView.findPvViewByUserName;

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
                    GetDataNotMassageFromClient(inputString, socket);
//                        socket.notifyAll();
                } else {
                    if (inputString.substring(0, 1).equals("#")) {
                        //it means it is sending the massage for other user via server
                        String destinationContactName = inputString.split("#")[1];
                        String senderContactName=GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).getContactName();
                        String massage = inputString.split("#")[2];
                        PVView pvView = findPvViewByUserName(destinationContactName);
//                        pvView.getMassagesNotWrittenInPVView().put(massage, 100);
                        pvView.AddDataToMassageToSendThatWeDidntSendThem("#"+senderContactName+"#"+massage);
//                        Changes.WeHaveNewMassageToShow();

                    } else {
                        //this means that user send server a massage and we should show in pvView
                        PVView pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                        pvView.AddDataToDataNotWritten(inputString, 100);
                        Changes.WeHaveNewMassageToShow();
                    }
                }
            } catch (Exception e) {
                PVView pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                GameView.getGameView().getHostAndGuestView().AddMassageToHistoryAndMassageNotWrittenInGroup(pvView.getContactName() + " disconnected");
                for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
                    entry.getValue().getDataToSendThatWeDidntSendThem().add("@" + pvView.getContactName() + " disconnected");
                }
                GameView.getGameView().getHostAndGuestView().SendConnectedClientDataToOther();
//                GameView.getGameView().getHostAndGuestView().getMassagedidntsent().add("@" + pvView.getContactName() + " disconnected");
                Changes.WeHaveNewMassageToShow();
                GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().remove(socket);
                Changes.WeHaveNewContact();
                threadHasToContinue = false;
            }
        }
    }



    private void SendMassageThatIsRecivedFromOneUserForGroupToOthers(Socket socket, String massage) throws IOException {
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            if (!entry.getKey().equals(socket)) {
                entry.getValue().getDataToSendThatWeDidntSendThem().add(massage);
            }

        }
    }

    private static void GetDataNotMassageFromClient(String inputString, Socket socket) throws MissionNotLoaded {
        if (inputString.substring(0, 1).equals("C")) {
            //it means client is sending the client Data.
            String data = inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().AddNewSocketToConnectedSocketsAndPVView(socket, data.split(" ")[0]);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactMoneyInGame(data.split(" ")[1]);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactLevelInMission(data.split(" ")[2]);
            GameView.getGameView().getHostAndGuestView().SendConnectedClientDataToOther();
            Changes.WeHaveNewContact();
            SendOldMassageForNewUsers(GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket));
            SendJoinMassageForEveryOneInGroup(data.split(" ")[0]);

        }else if (inputString.substring(0,1).equals("P")){
            boolean isPlayingNow;
            //it means one of the guests are playing a mission.
            if (inputString.split("@")[2].equals("Playing")){
                isPlayingNow=true;
            }else{
                isPlayingNow=false;
            }
            Changes.UpdatePlayingUsersArray(inputString.split("@")[1],isPlayingNow);
            NotifyingOtherUsersOfUserStateInMission(inputString);
        }else if (inputString.substring(0,1).equals("B")){
            String data=inputString.substring(2);
            Changes.setDataForMaxNumberOfProductExistInOnlineShop(data);
            Changes.WeShouldReloadTheOnlineShop();
        }else if (inputString.substring(0,1).equals("W")){
            String contactName=inputString.substring(2);
            if (contactName.length()>7){
                if (contactName.substring(0,7).equals("Server:")){
                    //it means we should release a wild animal in server farm.
                    AddLionInFarmRandomLy();
                }else{
                    PVView pvView=findPvViewByUserName(contactName);
                    pvView.AddDataToMassageToSendThatWeDidntSendThem("W@");
                }
            }else{
                PVView pvView=findPvViewByUserName(contactName);
                pvView.AddDataToMassageToSendThatWeDidntSendThem("W@");


            }
        }

    }

    private static void NotifyingOtherUsersOfUserStateInMission(String state){
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            entry.getValue().getDataToSendThatWeDidntSendThem().add(state);
        }
    }

    private static void SendJoinMassageForEveryOneInGroup(String newGuestName) {
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            entry.getValue().getDataToSendThatWeDidntSendThem().add("@" + newGuestName + " joined us.");
        }
        GameView.getGameView().getHostAndGuestView().AddMassageToHistoryAndMassageNotWrittenInGroup(newGuestName + " joined us.");
    }

    private static void SendOldMassageForNewUsers(PVView pvView) {
        for (String massage : GameView.getGameView().getHostAndGuestView().getHistoryMassage()) {
            pvView.getDataToSendThatWeDidntSendThem().add("@" + massage);
        }
    }

    public static void AddLionInFarmRandomLy() throws MissionNotLoaded {
        Farm farm= Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        int randomX = ((int) (Math.random() * 15));
        int randomY = ((int) (Math.random() * 15));
        Cell randomCell = farm.getMap()[randomX][randomY];
        Lion lion=new Lion();
        lion.setX(randomX);
        lion.setY(randomY);
        randomCell.AddCellAMapObject(lion);
    }

}
