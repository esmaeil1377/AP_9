package FarmModel.Internet.ServerAndClientRunnable;

import View.ScenesAndMainGroupView.PVView;

import java.net.Socket;
import java.util.HashMap;

public class SocketRunnable implements Runnable {
    private HashMap<Socket,PVView> connectedSockets=new HashMap<>();

    public void AddNewSocketToConnectedSocketsAndPVView(Socket socket,String contactName){
        connectedSockets.put(socket,new PVView(contactName));
    }

    public HashMap<Socket, PVView> getConnectedSockets() {
        return connectedSockets;
    }

    @Override
    public void run() {

    }
}
