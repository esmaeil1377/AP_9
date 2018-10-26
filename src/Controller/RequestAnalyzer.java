package Controller;

import Model.*;
import Model.Done.*;
import View.View;

import static Model.Done.*;

public class RequestAnalyzer {
    private static RequestAnalyzer commandAnalyzer = new RequestAnalyzer();

    public RequestAnalyzer getAnalyzerInstance(){
        return(commandAnalyzer);
    }


    //regex of commands
    private static final String SeeScorestr = "[S|s][E|e][E|e] [S|s][C|c][O|o][R|r][E|e]";
    private static final String SeeGillsstr = "[S|s][E|e][E|e] [G|g][I|i][L|l][L|l][S|s]";
    private static final String AddArmystr = "[A|a][D|d][D|d] [A|a][R|r][M|m][Y|y] \\d+";
    private static final String AddBazarstr = "[A|a][D|d][D|d] [b|B][A|a][Z|z][A|a][R|r] \\d+";
    private static final String AddBlockstr = "[A|a][D|d][D|d] [B|b][L|l][O|o][C|c][K|k]";
    private static final String AddHomestr = "[A|a][D|d][D|d] [H|h][O|o][M|m][E|e] \\d+ \\d+ \\d+";
    private static final String UpgradeItem = "[U|u][P|p][G|g][R|r][A|a][D|d][E|e][B|b][L|l][O|o][C|c][K|k] \\d+ \\d+";
    private static final String UpgradeBlock = "[U|u][P|p][G|g][R|r][A|a][D|d][E|e] \\d+";
    private static final String UpgradeFloorUnit = "[U|u][P|p][G|g][R|r][A|a][D|d][E|e] \\d+ \\d+ [F|f][L|l][O|o][O|o][R|r] [U|u][N|n][I|i][T|t]";
    private static final String RemoveUnit = "[U|u][P|p][G|g][R|r][A|a][D|d][E|e] \\d+ \\d+";
    private static final String RemoveBlock = "[U|u][P|p][G|g][R|r][A|a][D|d][E|e] \\d+";
    private static final String Attack= "[A|a][T|t][T|t][A|a][C|c][K|k] \\d+";
    private static final String loot= "[L|l][O|o][O|o][T|t] \\d+";
    private static final String Yield = "[Y|y][I|i][E|e][L|l][D|d]";
    private static final String Done = "[D|d][O|o][N|n][E|e]";


    public static Requests getRequest(String command){
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
            return(Model.Yield.getYieldInstance());
        }
        else if(command.matches(Done)){
            Model.Done.getDoneInstance().NextDay();
            return(Model.Done.getDoneInstance());
        }else if (command.matches(UpgradeFloorUnit)){
            String[] params = command.split(" ");
            return (new UpgradeFloorUnit(Integer.valueOf(params[1]) , Integer.valueOf(params[2])));
        }
        else if (command.matches(UpgradeFloorUnit)){
            String[] params = command.split(" ");
            return (new UpgradeFloorUnit(Integer.valueOf(params[1]) , Integer.valueOf(params[2])));
        }
        else if (command.matches(UpgradeFloorUnit)){
            String[] params = command.split(" ");
            return (new UpgradeFloorUnit(Integer.valueOf(params[1]) , Integer.valueOf(params[2])));
        }
        else{
            System.out.println("dztjn");
            View.AddtoOutPut("not possible");
            return(new NotPossible());
        }
    }

}
