package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.Main;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ReaderForGuest implements Runnable{
    private Socket socket;
    private boolean isServerConnected=true;


    public ReaderForGuest(Socket socket){
        this.socket=socket;
    }


    @Override
    public void run() {
        String inputString=null;
        Scanner scanner= null;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().remove(socket);
            Changes.WeHaveNewContact();
        }
        while (isServerConnected) {
            try {
                try {
                    inputString = scanner.nextLine();
                }catch (Exception e){
                    GameView.getGameView().getHostAndGuestView().AddMassageToHistoryAndMassageNotWrittenInGroup("Server is disconnected.");
                    Changes.WeHaveNewMassageToShow();
                    isServerConnected=false;
                }
                System.out.println("We Are Reading this:" + inputString);
                if (inputString.substring(0, 1).equals("@")) {
                    GameView.getGameView().getHostAndGuestView().AddMassageToHistoryAndMassageNotWrittenInGroup(inputString.substring(1));
                    Changes.WeHaveNewMassageToShow();
                } else if (inputString.substring(1, 2).equals("@")) {
                    //it means it is sending the information of account
                    GetDataNotMassageFromSocket(inputString, socket);
                } else {
                    PVView pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                    pvView.AddDataToDataNotWritten(inputString, 10);
                    Changes.WeHaveNewMassageToShow();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void GetDataNotMassageFromSocket(String inputString, Socket socket) {
        if (inputString.substring(0,1).equals("N")){
            String userName=inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().AddNewSocketToConnectedSocketsAndPVView(socket,userName);
            Changes.WeHaveNewContact();
        }else if (inputString.substring(0,1).equals("M")){
            String userMoney=inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactMoneyInGame(userMoney);
        }else if (inputString.substring(0,1).equals("L")){
            String userLastMission=inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactLevelInMission(userLastMission);
        }
    }
}
