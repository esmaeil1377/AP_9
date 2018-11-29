package FarmModel;

import java.util.ArrayList;

public class Game {
    private static Game game = new Game();
    private User currentUserAcount;
    ArrayList<User> userAcount = new ArrayList<>();
    private InformationNeededInGame informationNeededInGame = InformationNeededInGame.getDataNeededInGameInstance();

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
        return currentUserAcount;
    }

    public void setUserAcount(ArrayList<User> userAcount) {
        this.userAcount = userAcount;
    }
}
