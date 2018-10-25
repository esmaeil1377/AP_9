package Model;

public class SeeScore extends Requests {
    private static int Score;

    public static void setScore(int score) {
        Score = score;
    }

    public static int getScore() {

        return Score;
    }
}
