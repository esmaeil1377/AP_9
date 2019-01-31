package FarmModel.Internet.ReaderAndWriterRunnable;

import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;

public class WriterForServer implements Runnable {
    private Socket socket;

    public WriterForServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().remove(socket);
            Changes.WeHaveNewContact();
        }
        Formatter formatter = new Formatter(outputStream);
        while (true) {
            try {
                PVView pvView = null;
                try {
                    pvView = GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().get(socket);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ArrayList<String> pvStrings = pvView.getDataToSendThatWeDidntSendThem();
                if (pvStrings.size() != 0) {
                    SendMassageForGuest(formatter, pvStrings);
                    pvView.setDataToSendThatWeDidntSendThem(new ArrayList<>());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void SendMassageForGuest(Formatter formatter, ArrayList<String> groupMassage) {
        for (String str : groupMassage) {
            System.out.println("we are sending this data:" + str);
            formatter.format(str + "\n");
            formatter.flush();
            Changes.WeHaveNewMassageToShow();
        }
    }
}
