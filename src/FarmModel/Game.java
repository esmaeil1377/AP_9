package FarmModel;

import FarmController.Exceptions.MaxLevelExceeded;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Request.LoadGameRequest;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Game {
    private static Game game;
    private User currentUserAcount=new User("Mosio");
    ArrayList<User> userAcounts = new ArrayList<>();


    static {
        try {
            game = new Game();
        } catch (UnknownObjectException e) {
            e.printStackTrace();
        } catch (NotEnoughMoney notEnoughMoney) {
            notEnoughMoney.printStackTrace();
        } catch (MissionNotLoaded missionNotLoaded) {
            missionNotLoaded.printStackTrace();
        } catch (MaxLevelExceeded maxLevelExceeded) {
            maxLevelExceeded.printStackTrace();
        }
    }
    //just for the first user account:Mosio

    private Game() throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded, MaxLevelExceeded { }

    public static Game getGameInstance() {
        return game;
    }

    public ArrayList<User> getUserAccounts() {
        return userAcounts;
    }

    public void setCurrentUserAccount(User currentUserAccount) {
        this.currentUserAcount = currentUserAccount;
    }

    public User getCurrentUserAccount() {
        return currentUserAcount;
    }

    public void setUserAcounts(ArrayList<User> userAccount) {
        this.userAcounts = userAccount;
    }

    public void NewUserStringWantToStartTheGame(String userString) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded, MaxLevelExceeded {
        boolean isUserLoaded=false;
        File userAccountFolder;
        try{
            userAccountFolder=new File("UsersAccount");
            File[] contentDirectory=userAccountFolder.listFiles();
            for(File file:contentDirectory){
                if (file.getName().equals(userString+".txt")){
                    LoadGameRequest loadGameRequest=new LoadGameRequest("load game UsersAccount\\"+userString+".txt");
                    isUserLoaded=true;
                }
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        if(!isUserLoaded){
            User user=new User(userString);
            userAcounts.add(user);
            setCurrentUserAccount(user);
        }
    }
}
