package FarmModel.Internet;

import java.util.ArrayList;
import java.util.HashMap;

public class Changes {
    private static boolean NewContact =false;
    private static boolean NewMassage =false;
    private static ArrayList<String> massageShouldSendToServerForOtherUsersOrServerItSelf=new ArrayList<>();
    private static boolean weHaveUserNameError=false;
    private static ArrayList<String> userThatArePlayingMissionNow=new ArrayList<>();
    private static boolean weShouldReloadTheOnlineShop=false;
    private static String dataForMaxNumberOfProductExistInOnlineShop="";

    public static String getDataForMaxNumberOfProductExistInOnlineShop() {
        return dataForMaxNumberOfProductExistInOnlineShop;
    }

    public static void setDataForMaxNumberOfProductExistInOnlineShop(String dataForMaxNumberOfProductExistInOnlineShop) {
        Changes.dataForMaxNumberOfProductExistInOnlineShop = dataForMaxNumberOfProductExistInOnlineShop;
    }

    public static void WeShouldReloadTheOnlineShop(){
        weHaveUserNameError=true;
    }


    public static void UpdatePlayingUsersArray(String userName,boolean isPlayingAMissionNow){
        if (isPlayingAMissionNow){
            if (!userThatArePlayingMissionNow.contains(userName)){
                userThatArePlayingMissionNow.add(userName);
            }
        }else{
            if (userThatArePlayingMissionNow.contains(userName)){
                userThatArePlayingMissionNow.remove(userName);
            }
        }
    }

    public static ArrayList<String> getUserThatArePlayingMissionNow() {
        return userThatArePlayingMissionNow;
    }

    public static boolean DoWeHaveUserNameError(){
        return weHaveUserNameError;
    }
    public static void setWeHaveUserNameErrorfalse(){
        weHaveUserNameError=false;
    }
    public static void WeHaveUsernameError(){
        weHaveUserNameError=true;
    }

    public static ArrayList<String> getMassageShouldSendToServerForOtherUsersOrServerItSelf() {
        return massageShouldSendToServerForOtherUsersOrServerItSelf;
    }

    public static void setMassageShouldSendToServerForOtherUsersOrServerItSelf(ArrayList<String> massageShouldSendToServerForOtherUsersOrServerItSelf) {
        Changes.massageShouldSendToServerForOtherUsersOrServerItSelf = massageShouldSendToServerForOtherUsersOrServerItSelf;
    }

    public static boolean isThereAnyNewContact(){
        return NewContact;
    }

    public static boolean isThereAnyNewMassage(){
        return NewMassage;
    }

    public static void ContactViewReloaded(){
        NewContact =false;
    }

    public static void MassagesAdded(){
        NewMassage=false;
    }

    public static void WeHaveNewContact(){
        NewContact =true;
    }

    public static void WeHaveNewMassageToShow(){
        NewMassage=true;
    }

    public static void AddMassageToMassageThatShouldSend(String str){
        massageShouldSendToServerForOtherUsersOrServerItSelf.add(str);
    }
}
