package FarmModel;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;

import java.util.ArrayList;

public class Game {
    private static Game game;

    static {
        try {
            game = new Game();
        } catch (UnknownObjectException e) {
            e.printStackTrace();
        } catch (NotEnoughMoney notEnoughMoney) {
            notEnoughMoney.printStackTrace();
        } catch (MissionNotLoaded missionNotLoaded) {
            missionNotLoaded.printStackTrace();
        }
    }

    //just for the first user account:Mosio
    private User currentUserAcount=new User("Mosio");
    ArrayList<User> userAcount = new ArrayList<>();

    private Game() throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded { }

    public static Game getGameInstance() {
        return game;
    }

    public ArrayList<User> getUserAcount() {
        return userAcount;
    }

    public void setCurrentUserAcount(User currentUserAccount) {
        this.currentUserAcount = currentUserAccount;
    }

    public User getCurrentUserAccount() {
        if(currentUserAcount!=null) {
            return currentUserAcount;
        }else {
//            throw new
        }
        return null;
    }

    public void setUserAcount(ArrayList<User> userAccount) {
        this.userAcount = userAccount;
    }
}
