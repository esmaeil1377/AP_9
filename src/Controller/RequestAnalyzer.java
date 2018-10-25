package Controller;

import Model.*;

public class RequestAnalyzer {


    public static final String EXIT = "exit";
    private static RequestAnalyzer commandAnalyzer = new RequestAnalyzer();


    //regex of commands
    private static final String SeeScorestr = "See score";
    private static final String SeeGillsstr = "See gills";
    private static final String AddArmystr = "Add army [\\d+]";
    private static final String AddBazarstr = "Add bazar [\\d+]";
    private static final String AddBlockstr = "Add block";
    private static final String AddHomestr = "Add home [\\d+] [\\d=] [\\d+]";
    private static final String UpgradeItem = "UpgradeBlock [\\d+] [\\d+]";
    private static final String UpgradeBlock = "Upgrade [\\d+]";
    private static final String RemoveUnit = "Upgrade [\\d+] [\\d+]";
    private static final String RemoveBlock = "Upgrade [\\d+]";
    private static final String Yield = "Yield";
    private static final String Done = "Done";


    public Requests getRequest(String command){
        if(command.matches(SeeScorestr)){
            return(new SeeScore());
        }
        else if(command.matches(SeeGillsstr)){
            String[] params = command.split(" ");
            return(new SeeGills());
        }
        else if(command.matches(AddArmystr)){
            String[] params = command.split(" ");
            return(new AddArmy(Integer.valueOf(params[2])));
        }
        else if(command.matches(AddBazarstr)){
            String[] params = command.split(" ");
            return(new AddBazar(Integer.valueOf(params[2])));
        }
        else if(command.matches(AddBlockstr)){
            String[] params = command.split(" ");
            return(new AddBlock());
        }
        else if(command.matches(AddHomestr)){
            String[] params = command.split(" ");
            return(new AddHome(Integer.valueOf(params[2]),Integer.valueOf(params[3]),Integer.valueOf(params[4])));
        }
        else if(command.matches(UpgradeBlock)){
            String[] params = command.split(" ");
            return(new UpgradeBlock(Integer.valueOf(params[1])));
        }
        else if(command.matches(UpgradeItem)){
            String[] params = command.split(" ");
            return(new UpgradeItem(Integer.valueOf(params[1]),Integer.valueOf(params[2])));
        }
        else if(command.matches(RemoveBlock)){
            String[] params = command.split(" ");
            return(new RemoveBlock(Integer.valueOf(params[1])));
        }
        else if(command.matches(RemoveUnit)){
            String[] params = command.split(" ");
            return(new RemoveUnit(Integer.valueOf(params[1]),Integer.valueOf(params[2])));
        }
        else if(command.matches(Yield)){
            String[] params = command.split(" ");
            return(new Yield());
        }
        else if(command.matches(Done)){
            String[] params = command.split(" ");
            return(new Done());
        }
        else{
            return(new InvalidInput());
        }
    }

}
