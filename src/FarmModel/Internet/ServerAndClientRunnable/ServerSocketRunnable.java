package FarmModel.Internet.ServerAndClientRunnable;

import FarmController.Exceptions.ThereIsAUserWithThisName;
import FarmModel.Game;
import FarmModel.Internet.Changes;
import FarmModel.Internet.ReaderAndWriterRunnable.ReaderForServer;
import FarmModel.Internet.ReaderAndWriterRunnable.WriterForServer;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;
import javafx.scene.paint.Stop;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ServerSocketRunnable extends SocketRunnable implements Runnable{

    private String port;
    private ServerSocket serverSocket = null;

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public ServerSocketRunnable(String port){
        this.port=port;
    }
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(Integer.valueOf(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket socket = null;
            try {
                System.out.println("Waiting for some one to connect.");
                socket = serverSocket.accept();
                try {
                    StopThreadUntilTheGuestCheck(socket);
                    System.out.println("One User Connected...");
                    Changes.WeHaveNewContact();
                    Thread reader=new Thread(new ReaderForServer(socket));
                    reader.start();
                    Thread writer=new Thread(new WriterForServer(socket));
                    writer.start();

                }catch (ThereIsAUserWithThisName e){}
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void StopThreadUntilTheGuestCheck(Socket socket) throws IOException, ThereIsAUserWithThisName {
        ArrayList<String> currentNamesinServer=new ArrayList<>();
        for (PVView pvView: GameView.getGameView().getStartMenuView().getServerOrGuest().getConnectedSockets().values()){
            currentNamesinServer.add(pvView.getContactName());
        }
        currentNamesinServer.add(Game.getGameInstance().getCurrentUserAccount().getAccountName());
        Scanner scanner=new Scanner(socket.getInputStream());
        String guestUserName=scanner.nextLine();
        Formatter formatter=new Formatter(socket.getOutputStream());
        if (currentNamesinServer.contains(guestUserName)){
            SendGuestYouAreNotAbelToConnectToServer(formatter);
            throw new ThereIsAUserWithThisName();
        }else{
            SendGuestYouAreAbelToConnect(formatter);
        }
    }
    private void SendGuestYouAreNotAbelToConnectToServer(Formatter formatter){
        System.out.println("we are sending this data:" + "!!!Go");
        formatter.format("!!!Go" + "\n");
        formatter.flush();
    }
    private void SendGuestYouAreAbelToConnect(Formatter formatter){
        System.out.println("we are sending this data:" + "ComeToUs");
        formatter.format("ComeToUs" + "\n");
        formatter.flush();
    }
}
