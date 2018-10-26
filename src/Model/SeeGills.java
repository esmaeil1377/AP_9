package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class SeeGills extends Requests {


    public static void getGills() {
        if (Done.getDay()%2==0) {
            View.View.AddtoOutPut(String.valueOf(user1.AfterDayGills));
        } else {
            View.View.AddtoOutPut(String.valueOf(user2.AfterDayGills));
        }
    }
}

