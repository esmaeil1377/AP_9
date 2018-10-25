package Model;

public class Padafand {
    private int Id;
    private int numofperson=0;
    private int level = 1;


    public void setNumofperson(int numofperson) {
        this.numofperson = numofperson;
    }

    public int getNumofperson() {
        return numofperson;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    public static float LevelOfDefense = 0;


    public static float levelOfDefense(int BlockId) {
        for (Block block : City.ArrayListblocks) {

            if (block.getId() == BlockId) {
        if (block.PadafandArrayList.size() == 1) {
            for (Padafand padafand : block.PadafandArrayList) {
                if (padafand.getLevel() == 1)
                    LevelOfDefense = (float) (padafand.getNumofperson() * (0.2));
                if (padafand.getLevel() == 2)
                    LevelOfDefense = (float) (padafand.getNumofperson() * (0.4));
                if (padafand.getLevel() == 3)
                    LevelOfDefense = (float) (padafand.getNumofperson() * (0.6));
                if (padafand.getLevel() == 4)
                    LevelOfDefense = (float) (padafand.getNumofperson() * (0.8));
                if (padafand.getLevel() == 5)
                    LevelOfDefense = (float) (padafand.getNumofperson() * (1));

            }


        }
        }

    }
        return LevelOfDefense;
}
}
