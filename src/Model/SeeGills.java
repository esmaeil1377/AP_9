package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class SeeGills extends Requests {


    public static int getGills() {
        if (User.equals(user1)) {
            return user1.AfterDayGills;
        } else {
            return user2.AfterDayGills;
        }
    }
}

