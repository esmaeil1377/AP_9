package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;

public class Writer implements Runnable {
    private Socket socket;

    public Writer(Socket socket){
       this.socket=socket;
    }
    @Override
    public void run() {
        String inputString;
        OutputStream outputStream= null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Formatter formatter=new Formatter(outputStream);
        while (true) {
            try {
                PVView pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                ArrayList<String> strs = pvView.getDataToSendThatWeDidntSendThem();
                if (strs.size() != 0) {
                    for (String str : strs) {
                        System.out.println("we are sending this data:" + str);
                        formatter.format(str + "\n");
                        formatter.flush();
                        Changes.WeHaveNewMassageToShow();
                        pvView.setDataToSendThatWeDidntSendThem(new ArrayList<>());
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
