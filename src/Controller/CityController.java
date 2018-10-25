package Controller;

import Model.AddDefense;
import Model.Requests;

import static Controller.RequestAnalyzer.getRequest;
import static View.View.getCommand;

public class CityController {


    public void lookingForCommand(){
        while(getCommand()!="Yield"){
            Requests request=getRequest(getCommand());

        }
    }

}
