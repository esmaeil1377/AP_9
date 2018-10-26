package Model;

public class Done extends Requests {
    private static Done done=new Done();
    public static usertotal User;
    public static User1 user1=new User1();
    public static User2 user2=new User2();
    public static int Day=0;
    private Done(){}

    public static Done getDoneInstance(){
        return done;
    }

    public static int getDay() {
        return Day;
    }

    public static void setDay(int day) {
        Day = day;
    }

    public void NextDay(){
        done.Day++;
    }
}
