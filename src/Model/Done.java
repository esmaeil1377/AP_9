package Model;

public class Done extends Requests {
    public static usertotal User;
    public static User1 user1=new User1();
    public static User2 user2=new User2();

    public void Done(){
        if(User.equals(user1)){
            user1.setAfterDayGills();
            User=user2;
        }
        else{
            user2.setAfterDayGills();
            User=user1;
        }
    }
}
