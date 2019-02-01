package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

import static View.ScenesAndMainGroupView.HostAndGuestView.findPvViewByUserName;

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
                    GetDataNotMassageFromServer(inputString, socket);
                } else {
                    if (inputString.substring(0, 1).equals("#")) {
                        //it means it is sending the massage for other user via server
                        String senderContactName = inputString.split("#")[1];
                        String massage = inputString.split("#")[2];
                        PVView pvView = findPvViewByUserName(senderContactName);
                        pvView.AddDataToDataNotWritten(massage, 100);
                        Changes.WeHaveNewMassageToShow();
                    } else {
                        //this means that server send you a massage and we should show in server pvView
                        PVView pvView = findServerPvView();
                        pvView.AddDataToDataNotWritten(inputString, 100);
                        Changes.WeHaveNewMassageToShow();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    private PVView findServerPvView() {
        for (Map.Entry<Socket, PVView> entry : GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()) {
            if (entry.getValue().getContactName().length() > 7) {
                if (entry.getValue().getContactName().substring(0,7).equals("Server:")) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    private void GetDataNotMassageFromServer(String inputString, Socket socket) {
        if (inputString.substring(0,1).equals("C")){
            //it means server is sending the server Data.
            String data=inputString.substring(2);
            GameView.getGameView().getStartMenuView().getServerOrGuest().AddNewSocketToConnectedSocketsAndPVView(socket,"Server: "+data.split(" ")[0]);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactMoneyInGame(data.split(" ")[1]);
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactLevelInMission(data.split(" ")[2]);
            GameView.getGameView().getHostAndGuestView().SendConnectedClientDataToOther();
            Changes.WeHaveNewContact();
        }else if (inputString.substring(0,1).equals("D")){
            //it means server is sending again the contacts.means the user that are connected to server
            String[] contactsDatas=inputString.substring(2).split(" ");
            GameView.getGameView().getStartMenuView().getServerOrGuest().ReloadContactsAndContactDataThenScoreBoard(contactsDatas);
            Changes.WeHaveNewContact();
        }else if (inputString.substring(0,1).equals("P")){
            boolean isPlayingNow;
            if (inputString.split("@").length==2){
                // it means server is playing a mission
                if (inputString.split("@")[1].equals("Playing")){
                    isPlayingNow=true;
                }else{
                    isPlayingNow=false;
                }
                Changes.UpdatePlayingUsersArray(ServerUserName(),isPlayingNow);
            }else{
                //it means one of the guests are playing a mission.
                if (inputString.split("@")[2].equals("Playing")){
                    isPlayingNow=true;
                }else{
                    isPlayingNow=false;
                }
                Changes.UpdatePlayingUsersArray(inputString.split("@")[1],isPlayingNow);
            }
        }
    }

    private String ServerUserName(){
        for (Map.Entry<Socket,PVView> entry:GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().entrySet()){
            if (entry.getValue().getContactName().length()>7){
                if (entry.getValue().getContactName().substring(0,7).equals("Server:")){
                    return entry.getValue().getContactName();
                }
            }
        }
        return null;
    }

}
