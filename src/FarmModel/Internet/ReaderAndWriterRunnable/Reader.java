package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Reader implements Runnable {
    private Socket socket;

    public Reader(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        String inputString;
        Scanner scanner= null;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
                inputString = scanner.nextLine();
                System.out.println("We Are Reading this:" + inputString);
                if (inputString.substring(0,1).equals("@")){
                    GameView.getGameView().getHostAndGuestView().AddMassageToMassageNotWrittenAndHistory(inputString);
                    Changes.WeHaveNewMassageToShow();
                }else if (inputString.substring(1,2).equals("@")){
                    //it means it is sending the information of account
                    if (inputString.substring(0,1).equals("N")){
                        String userName=inputString.substring(2);
                        GameView.getGameView().getStartMenuView().getServerOrGuest().AddNewSocketToConnectedSocketsAndPVView(socket,userName);
                    }else if (inputString.substring(0,1).equals("M")){
                        String userMoney=inputString.substring(2);
                        GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactMoneyInGame(userMoney);
                    }else if (inputString.substring(0,1).equals("L")){
                        String userLastMission=inputString.substring(2);
                        GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket).setContactLevelInMission(userLastMission);
                    }
                }
                else{
                    PVView pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                    pvView.AddDataToDataNotWritten(inputString, 10);
                    Changes.WeHaveNewMassageToShow();
                }
        }
    }
}
