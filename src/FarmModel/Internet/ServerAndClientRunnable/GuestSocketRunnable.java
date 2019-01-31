package FarmModel.Internet.ServerAndClientRunnable;

import FarmController.Exceptions.ThereIsAUserWithThisName;
import FarmModel.Game;
import FarmModel.Internet.Changes;
import FarmModel.Internet.ReaderAndWriterRunnable.ReaderForGuest;
import FarmModel.Internet.ReaderAndWriterRunnable.WriterForGuest;
import FarmModel.User;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

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
        Socket socket = null;
        try {
            socket=new Socket(IP,Integer.valueOf(getPort()));
            try {
                SendServerAccountNameToCheckAndWaitUntilServerAnswerOurRequest(socket);
                System.out.println("connected to server.");
                Changes.WeHaveNewContact();
                SendInformation(socket);

                Thread reader=new Thread(new ReaderForGuest(socket));
                reader.start();
                Thread writer=new Thread(new WriterForGuest(socket));
                writer.start();
            }catch (ThereIsAUserWithThisName e){}

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (NullPointerException e2) {
            e2.printStackTrace();
        }
    }
    static void SendInformation(Socket socket) throws IOException {
        OutputStream outputStream=socket.getOutputStream();
        Formatter formatter=new Formatter(outputStream);
        User user= Game.getGameInstance().getCurrentUserAccount();
        formatter.format("C@"+user.getAccountName()+" "+user.getMoney()+" "+user.getUserLevel()+"\n");
        formatter.flush();
    }
    private void SendServerAccountNameToCheckAndWaitUntilServerAnswerOurRequest(Socket socket) throws IOException, ThereIsAUserWithThisName {
        OutputStream outputStream=socket.getOutputStream();
        Formatter formatter=new Formatter(outputStream);
        String userName=Game.getGameInstance().getCurrentUserAccount().getAccountName();
        formatter.format(userName+"\n");
        formatter.flush();
        Scanner scanner=new Scanner(socket.getInputStream());
        String serverAnswer=scanner.nextLine();
        if (serverAnswer.equals("!!!Go")){
            Changes.WeHaveUsernameError();
            throw new ThereIsAUserWithThisName();
        }else if (serverAnswer.equals("ComeToUs")){
        }

    }


}
