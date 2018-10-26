package Model;

import java.util.ArrayList;

public class NextId {
    private static int NextId= 0;
    private static ArrayList<Integer> IdsList;

    public static int NextId(){
        NextId++;
        System.out.println(NextId);
        if(!(IdsList.contains(NextId))) {
            IdsList.add(NextId);
            return NextId;
        }
        else{
            NextId();
        }
        System.out.println("NextIdProblem");
        return(-1);
    }

    public static void setNextId(int nextId) {
        NextId = nextId;
    }

    public static int getNextId() {
        return NextId;
    }
}
