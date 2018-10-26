package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class SeeScore extends Requests {

    public static void getScore() {
        if(User.equals(user1)) {
            View.View.AddtoOutPut(String.valueOf(user1.Score));
        }
        else{
            View.View.AddtoOutPut(String.valueOf(user2.Score));
        }
    }
}
