package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;

public class WriterForGuest implements Runnable {
    private Socket socket;

    public WriterForGuest(Socket socket){
        this.socket=socket;
    }


    @Override
    public void run() {
        OutputStream outputStream= null;
        Formatter formatter=null;
        try {
            outputStream = socket.getOutputStream();
            formatter=new Formatter(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().remove(socket);
            Changes.WeHaveNewContact();
        }
        while (true) {
            System.out.println("writer for guest is working.");
            try {
                ArrayList<String> serverPvAndOtherPVsViaServerStrings = Changes.getMassageShouldSendToServerForOtherUsersOrServerItSelf();
                if (serverPvAndOtherPVsViaServerStrings.size() != 0) {
                    for (String str : serverPvAndOtherPVsViaServerStrings) {
                        System.out.println("we are sending this data to server:" + str);
                        formatter.format(str + "\n");
                        formatter.flush();
                    }
                    Changes.setMassageShouldSendToServerForOtherUsersOrServerItSelf(new ArrayList<>());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
