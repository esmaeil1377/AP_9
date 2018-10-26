package Model;

import java.util.ArrayList;

public class NextitemId {
    private static int NextId = 0;
    private static ArrayList<Integer> IdArrayList=new ArrayList<>();

    public static int NextId() {
        NextId++;
        if (IdArrayList.size() != 0) {
            if (!(IdArrayList.contains(NextId))) {
                IdArrayList.add(NextId);
                return NextId;
            } else {
                NextId();
            }
        } else {
            return (NextId);
        }
        System.out.println("in next id it do't go to if and else");
        return(-1);
    }

    public static void setNextId(int nextId) {
        NextId = nextId;
    }

    public static int getNextId() {
        return NextId;
    }
}
