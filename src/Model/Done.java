package Model;

public class Done extends Requests {
    public static usertotal User;
    public static User1 user1=new User1();
    public static User2 user2=new User2();

    public void Done(){
        if(User.equals(user1)){
            User=user2;
        }
        else{
            User=user1;
        }

    }

    public static void changeUser(){
        if(User.equals(user1)){
            User=user2;
        }else{
            User=user1;
        }
    }
}
