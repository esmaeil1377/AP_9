package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

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
        try {
            OutputStream outputStream=socket.getOutputStream();
            Formatter formatter=new Formatter(outputStream);
            while (true) {
                PVView pvView = GameView.getGameView().getHostAndGuestView().getServerSocketRunnable().getConnectedSockets().get(socket);
                ArrayList<String> strs= pvView.getDataToSendThatWeDidntSendThem();
                if ( strs.size()!= 0) {
                    for (String str : strs) {
                        System.out.println("we are sending this data:"+str);
                        formatter.format(str+"\n");
                        formatter.flush();
                        Changes.WeHaveNewMassageToShow();
//                        pvView.setDataToSendThatWeDidntSendThem(new ArrayList<>());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
