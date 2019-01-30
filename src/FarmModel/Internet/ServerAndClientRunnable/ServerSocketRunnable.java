package FarmModel.Internet.ServerAndClientRunnable;

import FarmModel.Internet.Changes;
import FarmModel.Internet.ReaderAndWriterRunnable.ReaderForServer;
import FarmModel.Internet.ReaderAndWriterRunnable.WriterForServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketRunnable extends SocketRunnable implements Runnable{

    private String port;
    private ServerSocket serverSocket = null;
    private String IP;

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
                System.out.println("One User Connected...");
                Changes.WeHaveNewContact();
                GuestSocketRunnable.SendInformation(socket);

                Thread reader=new Thread(new ReaderForServer(socket));
                reader.start();
                Thread writer=new Thread(new WriterForServer(socket));
                writer.start();

            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
        }
    }



}
