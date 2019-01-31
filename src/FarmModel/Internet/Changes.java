package FarmModel.Internet;

import java.util.ArrayList;

public class Changes {
    private static boolean NewContact =false;
    private static boolean NewMassage =false;
    private static ArrayList<String> massageShouldSendToServerForOtherUsersOrServerItSelf=new ArrayList<>();
    private static boolean weHaveUserNameError=false;

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
