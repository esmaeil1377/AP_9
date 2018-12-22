package FarmModel.Request;

import FarmController.Exceptions.NotEnoughMoney;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.InformationNeededInGame;
import FarmModel.ObjectInMap15_15.LiveAnimals.*;

public class BuyRequest extends Request {
    private String animalName;

    public BuyRequest(String requestLine) {
        AnalyzeRequestLine(animalName);

    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void Buy(String request) {
        AnalyzeRequestLine(request);
        int currentMoney= Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getStartMoneyInMission();
        InformationNeededInGame priceToBuyObject = InformationNeededInGame.getInformationNeededInGame();
        if(getAnimalName().equals("Cat")){
            if(currentMoney >= priceToBuyObject.getPriceToBuy(new Cat())){
                Game.getGameInstance().getCurrentUserAcount().AddMoney(priceToBuyObject.getPriceToBuy(new Cat()));
                Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
                int x = (int) (Math.random() * 30) + 1;
                int y = (int) (Math.random() * 30) + 1;
                farm.getMap()[x][y].AddCellAMapObject(new Cat());
            }
            else
                throw new NotEnoughMoney();
        }
        if(getAnimalName().equals("Dog")){
            if(currentMoney >= priceToBuyObject.getPriceToBuy(new Dog())){
                Game.getGameInstance().getCurrentUserAcount().AddMoney(priceToBuyObject.getPriceToBuy(new Dog()));
                Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
                int x = (int) (Math.random() * 30) + 1;
                int y = (int) (Math.random() * 30) + 1;
                farm.getMap()[x][y].AddCellAMapObject(new Dog());
            }
            else
                throw new NotEnoughMoney();
        }
        if(getAnimalName().equals("Chicken")){
            if(currentMoney >= priceToBuyObject.getPriceToBuy(new Chicken())){
                Game.getGameInstance().getCurrentUserAcount().AddMoney(priceToBuyObject.getPriceToBuy(new Chicken()));
                Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
                int x = (int) (Math.random() * 30) + 1;
                int y = (int) (Math.random() * 30) + 1;
                farm.getMap()[x][y].AddCellAMapObject(new Chicken());
            }
            else
                throw new NotEnoughMoney();
        }
        if(getAnimalName().equals("Sheep")){
            if(currentMoney >= priceToBuyObject.getPriceToBuy(new Sheep())){
                Game.getGameInstance().getCurrentUserAcount().AddMoney(priceToBuyObject.getPriceToBuy(new Sheep()));
                Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
                int x = (int) (Math.random() * 30) + 1;
                int y = (int) (Math.random() * 30) + 1;
                farm.getMap()[x][y].AddCellAMapObject(new Sheep());
            }
            else
                throw new NotEnoughMoney();
        }
        if(getAnimalName().equals("Cow")){
            if(currentMoney >= priceToBuyObject.getPriceToBuy(new Cow())){
                Game.getGameInstance().getCurrentUserAcount().AddMoney(priceToBuyObject.getPriceToBuy(new Cow()));
                Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
                int x = (int) (Math.random() * 30) + 1;
                int y = (int) (Math.random() * 30) + 1;
                farm.getMap()[x][y].AddCellAMapObject(new Cow());
            }
            else
                throw new NotEnoughMoney();
        }

    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] params = requestLine.split(" ");
        setAnimalName(params[1].substring(1, params[1].length() - 1));
    }
}
