package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class SeeScore extends Requests {

    public static int getScore() {
        if(User.equals(user1)) {
            return user1.getScore();
        }
        else{
            return(user2.getScore());
        }
    }
}
