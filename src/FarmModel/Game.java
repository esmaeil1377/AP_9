package FarmModel;

import java.util.ArrayList;

public class Game {
    private static Game game = new Game();
    private User currentUserAcount=new User("Mosio");
    ArrayList<User> userAcount = new ArrayList<>();

    private Game() {
    }

    public static Game getGameInstance() {
        return game;
    }

    public ArrayList<User> getUserAcount() {
        return userAcount;
    }

    public void setCurrentUserAcount(User currentUserAcount) {
        this.currentUserAcount = currentUserAcount;
    }

    public User getCurrentUserAcount() {
        if(currentUserAcount!=null) {
            return currentUserAcount;
        }else {
//            throw new
        }
        return null;
    }

    public void setUserAcount(ArrayList<User> userAcount) {
        this.userAcount = userAcount;
    }
}
