package Model;

public class Army {
   private float Level = 0;
   private int Id;
   private int NumberOf=0;

    public void setNumberOf(int numberOf) {
        NumberOf = numberOf;
    }

    public static int getNumberOf() {
        return NumberOf;
    }

    public void setLevel(float level) {
        Level = level;
    }

    public float getLevel() {
        return Level;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }
    public static float levelOfAttak(int BlockId){
        for(Block block: City.ArrayListblocks)
        {
            float LevelOfAttak = 0;
            if(block.ArmyArrayList.size()==1){
                for(Army army:block.ArmyArrayList){
                    if(army.getLevel()==1)
                        LevelOfAttak=(float)(army.getNumberOf() * (0.2));
                    if(army.getLevel()==2)
                        LevelOfAttak=(float)(army.getNumberOf() * (0.4));
                    if(army.getLevel()==3)
                        LevelOfAttak=(float)(army.getNumberOf() * (0.6));
                    if(army.getLevel()==4)
                        LevelOfAttak=(float)(army.getNumberOf() * (0.8));
                    if(army.getLevel()==5)
                        LevelOfAttak=(float)(army.getNumberOf() * (1));
                    return LevelOfAttak;
                }


            }
        }
        public static 



    }
    public void Loot(int BlockId){

    }
}
