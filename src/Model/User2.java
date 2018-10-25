package Model;

public class User2 extends usertotal {
    private static int Score;
    private static int Gills = 30000;
    private int UserId;
    public City city2=new City();


    public static int getScore() {
        return Score;
    }

    public static void setScore(int score) {
        Score = score;
    }

    public static int getGills() {
        return Gills;
    }

    public static void setGills(int gills) {
        Gills = gills;
    }
}
