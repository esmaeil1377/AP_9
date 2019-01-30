package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
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
            //it means server is sending the server name.
            String userName=inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().AddNewSocketToConnectedSocketsAndPVView(socket,"Server: "+userName);
            Changes.WeHaveNewContact();
            SendJoinMassageForEveryOneInGroup(userName);
            SendOldMassageForNewUsers(GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket));
        }else if (inputString.substring(0,1).equals("M")){
            //it means server is sending the server money.
            String userMoney=inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactMoneyInGame(userMoney);
        }else if (inputString.substring(0,1).equals("L")){
            //it means the  server is sending the server level in game.
            String userlevel=inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactLevelInMission(userlevel);
        }else if (inputString.substring(0,1).equals("D")){
            //it means server is sending again the contacts.means the user that are connected to server
            String[] contactsData=inputString.substring(2).split(" ");
            for (String contactData:contactsData) {
                String Name=contactData.split(",")[0];
                String Money=contactData.split(",")[1];
                String Level=contactData.split(",")[2];
                GameView.getGameView().getStartMenuView().getServerOrGuest().AddNewSocketToConnectedSocketsAndPVViewOrReloadItPV(Name,Money,Level);
            }
            Changes.WeHaveNewContact();

        }else if (inputString.substring(0,1).equals("D")){
            String[] connectedContacts=inputString.substring(2).split(" ");
        }
    }
    private static void SendJoinMassageForEveryOneInGroup(String newGuestName){
        for (Map.Entry<Socket,PVView> entry: GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()){
            entry.getValue().getDataToSendThatWeDidntSendThem().add("@"+newGuestName+" joined us.");
        }
        GameView.getGameView().getHostAndGuestView().AddMassageToHistoryAndMassageNotWrittenInGroup(newGuestName+" joined us.");
    }
    private static void SendOldMassageForNewUsers(PVView pvView){
        for (String massage:GameView.getGameView().getHostAndGuestView().getHistoryMassage()){
            pvView.getDataToSendThatWeDidntSendThem().add("@"+massage);
        }
    }
}
