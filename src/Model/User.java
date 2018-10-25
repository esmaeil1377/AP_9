package Model;

public class User {
    private int Score;
    private int Gills = 30000;
    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getGills() {
        return Gills;
    }

    public void setGills(int gills) {
        Gills = gills;
    }
}
