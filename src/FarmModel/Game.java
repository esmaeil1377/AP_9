package FarmModel;

import java.util.ArrayList;

public class Game {
    private static Game game = new Game();
    //just for the first user account:Mosio
    private User currentUserAcount=new User("Mosio");
    ArrayList<User> userAcount = new ArrayList<>();

    private Game() { }

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
