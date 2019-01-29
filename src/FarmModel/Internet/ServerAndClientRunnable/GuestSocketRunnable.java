package FarmModel.Internet.ServerAndClientRunnable;

import FarmModel.Game;
import FarmModel.Internet.Changes;
import FarmModel.Internet.ReaderAndWriterRunnable.Reader;
import FarmModel.Internet.ReaderAndWriterRunnable.Writer;
import FarmModel.User;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Formatter;
import java.util.HashMap;

public class GuestSocketRunnable extends SocketRunnable implements Runnable {

    private String port;
    private String IP;

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public GuestSocketRunnable(String port, String IP){
        this.port=port;
        this.IP=IP;
    }
    @Override
    public void run() {
//        Socket socket = null;
//        try {
//            socket=new Socket(IP,Integer.valueOf(getPort()));
//            System.out.println("connected to server.");
//            Changes.WeHaveNewContact();
//            SendInformation(socket);
//
//            Thread reader=new Thread(new Reader(socket));
//            reader.start();
//            Thread writer=new Thread(new Writer(socket));
//            writer.start();
//
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        } catch (NullPointerException e2) {
//            e2.printStackTrace();
//        }
    }
    private void SendInformation(Socket socket) throws IOException {
        OutputStream outputStream=socket.getOutputStream();
        Formatter formatter=new Formatter(outputStream);
        User user= Game.getGameInstance().getCurrentUserAccount();
        formatter.format("N@"+user.getAccountName()+"\n");
        formatter.flush();
        formatter.format("M@"+user.getMoney()+"\n");
        formatter.flush();
        formatter.close();
        //and here we have to send the mission user level.
    }
}
