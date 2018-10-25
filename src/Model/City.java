package Model;

import java.util.ArrayList;
import Model.Block.*;

public class City {
    public static  ArrayList<Block> ArrayListblocks;
    private Army army;

    public void setArrayListblocks(ArrayList<Block> arrayListblocks) {
        ArrayListblocks = arrayListblocks;
    }

//    public static int getBlockScore(){
//        int Score=0;
//        for(Block i:ArrayListblocks){
//            Score+=i.getScore();
//        }
//        return(Score);
//    }

    public static ArrayList<Block> getArrayListblocks() {
        return ArrayListblocks;
    }

    public void AddBlockArrayList(Block block){
        ArrayListblocks.add(block);
    }

    public void RemoveBlockArrayList(Block block){
        ArrayListblocks.remove(block);
    }
}
