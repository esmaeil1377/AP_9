package Model;

public class Done extends Requests {
    public static usertotal User;
    public static User1 user1=new User1();
    public static User2 user2=new User2();
    public static int Day=0;

    public void Done(){
        Day++;
    }

    public static int getDay() {
        return Day;
    }
}
