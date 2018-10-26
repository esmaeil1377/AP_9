package Model;

import java.util.ArrayList;

import static Model.Done.user1;
import static Model.Done.user2;

public class City {
    public static  ArrayList<Block> ArrayListblocks=new ArrayList<>();
    private Army army;
    public static NextblockId NextBlockId=new NextblockId();


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
        if(Done.getDay()%2==0){
        user1.city1.ArrayListblocks.add(block);
    }else{
            user2.city2.ArrayListblocks.add(block);
        }
    }

    public void RemoveBlockArrayList(Block block){
        ArrayListblocks.remove(block);
    }
}
