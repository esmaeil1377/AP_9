package FarmModel.Internet;

public class Changes {
    private static boolean NewContact =false;
    private static boolean NewMassage =false;

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
}
