package FarmModel.Internet.ServerAndClientRunnable;

import FarmModel.Game;
import FarmModel.Internet.Changes;
import View.GameView;
import View.ScenesAndMainGroupView.PVView;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SocketRunnable implements Runnable {
    private HashMap<Socket,PVView> connectedSockets=new HashMap<>();

    public void AddNewSocketToConnectedSocketsAndPVView(Socket socket,String contactName){
        connectedSockets.put(socket,new PVView(contactName));
    }
    public void ReloadContactsAndContactDataThenScoreBoard(String[] contactDatas){
        GameView.getGameView().getHostAndGuestView().ReloadCurrentPLayerSortedByMoneyAndViewWhenScoreBoardIsShowing();
        ArrayList<String> currnetContactNames=new ArrayList<>();
        for (String contactData:contactDatas){
            currnetContactNames.add(contactData.split(",")[0]);
        }
        Iterator<PVView> iterator = connectedSockets.values().iterator();
        while (iterator.hasNext()){
            if (!currnetContactNames.contains(iterator.next().getContactName())){
                iterator.remove();
            }
        }
        loop:for (String contactData:contactDatas) {
            String contactName=contactData.split(",")[0];
            String contactMoney=contactData.split(",")[1];
            String contactLevel=contactData.split(",")[2];
            for (Map.Entry<Socket, PVView> entry : connectedSockets.entrySet()) {
                if (entry.getValue().getContactName().equals(contactName)) {
                    entry.getValue().setContactMoneyInGame(contactMoney);
                    entry.getValue().setContactLevelInMission(contactLevel);
                    break loop;
                }
            }
            if (!contactName.equals(Game.getGameInstance().getCurrentUserAccount().getAccountName())) {
                PVView pvView = new PVView(contactName);
                pvView.setContactLevelInMission(contactLevel);
                pvView.setContactMoneyInGame(contactMoney);
                connectedSockets.put(new Socket(), pvView);
            }
        }
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
