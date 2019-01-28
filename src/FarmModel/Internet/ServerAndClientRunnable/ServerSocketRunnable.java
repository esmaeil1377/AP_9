package FarmModel.Internet.ServerAndClientRunnable;

import FarmModel.Internet.Changes;
import FarmModel.Internet.ReaderAndWriterRunnable.Reader;
import FarmModel.Internet.ReaderAndWriterRunnable.Writer;
import View.ScenesAndMainGroupView.PVView;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerSocketRunnable implements Runnable{
    private HashMap<Socket,PVView> connectedSockets=new HashMap<>();
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
                socket = serverSocket.accept();
                System.out.println("One User Connected...");
                AddNewSocketToConnectedSocketsAndPVView(socket);
                Changes.WeHaveNewContact();

                Thread reader=new Thread(new Reader(socket));
                reader.start();
                Thread writer=new Thread(new Writer(socket));
                writer.start();

            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void AddNewSocketToConnectedSocketsAndPVView(Socket socket){
        connectedSockets.put(socket,new PVView(socket.toString()));
    }

    public HashMap<Socket, PVView> getConnectedSockets() {
        return connectedSockets;
    }
}
