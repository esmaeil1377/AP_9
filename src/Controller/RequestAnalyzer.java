package Controller;

import Model.InvalidInput;
import Model.Requests;

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
    private static final String UpgradeItem = "Upgrade [\\d+] [\\d+]";
    private static final String UpgradeBlock = "Upgrade [\\d+]";
    private static final String RemoveUnit = "Upgrade [\\d+] [\\d+]";
    private static final String RemoveBlock = "Upgrade [\\d+]";
    private static final String Yield = "Yield";
    private static final String Done = "Done";


    public Requests getRequest(String command){
        if(command.matches(SeeScorestr)){

        }
        else if(command.matches(SeeGillsstr)){
            String[] params = command.split(" ");
        }
        else if(command.matches(AddArmystr)){
            String[] params = command.split(" ");
        }
        else if(command.matches(AddBazarstr)){
            String[] params = command.split(" ");
        }
        else if(command.matches(AddBlockstr)){
            String[] params = command.split(" ");
        }
        else if(command.matches(AddHomestr)){
            String[] params = command.split(" ");
        }
        else if(command.matches(UpgradeBlock)){
            String[] params = command.split(" ");
        }
        else if(command.matches(UpgradeItem)){
            String[] params = command.split(" ");
        }
        else if(command.matches(RemoveUnit)){
            String[] params = command.split(" ");
        }
        else if(command.matches(RemoveBlock)){
            String[] params = command.split(" ");
        }
        else if(command.matches(Yield)){
            String[] params = command.split(" ");
        }
        else if(command.matches(Done)){
            String[] params = command.split(" ");
        }
        else{
            return(new InvalidInput());
        }
        return(null);
    }

}
