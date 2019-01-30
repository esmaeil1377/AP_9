package FarmModel.Internet.ServerAndClientRunnable;

import View.ScenesAndMainGroupView.PVView;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class SocketRunnable implements Runnable {
    private HashMap<Socket,PVView> connectedSockets=new HashMap<>();

    public void AddNewSocketToConnectedSocketsAndPVView(Socket socket,String contactName){
        connectedSockets.put(socket,new PVView(contactName));
    }
    public void AddNewSocketToConnectedSocketsAndPVViewOrReloadItPV(String contactName, String money, String contactLevel){
        for (Map.Entry<Socket,PVView> entry:connectedSockets.entrySet()){
            if (entry.getValue().getContactName().equals(contactName)){
                entry.getValue().setContactMoneyInGame(money);
                entry.getValue().setContactLevelInMission(contactLevel);
                return;
            }
        }
        PVView pvView=new PVView(contactName);
        pvView.setContactLevelInMission(contactLevel);
        pvView.setContactMoneyInGame(money);
        connectedSockets.put(new Socket(),pvView);
    }

    public HashMap<Socket, PVView> getConnectedSockets() {
        return connectedSockets;
    }

    public void setConnectedSockets(HashMap<Socket, PVView> connectedSockets) {
        this.connectedSockets = connectedSockets;
    }

    @Override
    public void run() {

    }
}
