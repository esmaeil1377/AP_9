package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

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
        try {
            Scanner scanner=new Scanner(socket.getInputStream());
            while (true) {
                inputString = scanner.nextLine();
                System.out.println("We Are Reading this:" + inputString);
                if (inputString.substring(0,1).equals("@")){
                    GameView.getGameView().getHostAndGuestView().AddMassageToMassageNotWrittenAndHistory(inputString);
                    Changes.WeHaveNewMassageToShow();
                }else if (inputString.substring(1,2).equals("@")){
                    PVView pvView=GameView.getGameView().getHostAndGuestView().getServerSocketRunnable().getConnectedSockets().get(socket);
                    //it means it is sending the information of account
                    if (inputString.substring(0,1).equals("N")){
                        String userName=inputString.substring(2);
                        pvView.setContactName(userName);
                    }else if (inputString.substring(0,1).equals("M")){
                        int userMoney=Integer.valueOf(inputString.substring(2));
                    }else if (inputString.substring(0,1).equals("L")){
                        int userLastMission=Integer.valueOf(inputString.substring(2));
                    }
                }
                else{
                    PVView pvView = GameView.getGameView().getHostAndGuestView().getServerSocketRunnable().getConnectedSockets().get(socket);
                    pvView.AddDataToDataNotWritten(inputString, 10);
                    Changes.WeHaveNewMassageToShow();
                }
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }
}
