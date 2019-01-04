package FarmModel.Request;

import FarmController.Exceptions.MaxLevelExceeded;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.*;
import FarmModel.ObjectInMap30_30.LiveAnimals.*;


public class BuyRequest extends Request {
    private String animalName;

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public BuyRequest(String request) throws MissionNotLoaded, NotEnoughMoney, UnknownObjectException, MaxLevelExceeded {
        AnalyzeRequestLine(request);
        User user=Game.getGameInstance().getCurrentUserAccount();
        Mission mission=user.getCurrentPlayingMission();
        Farm farm = mission.getFarm();
        InformationNeededInGame informationNeededInGame=user.getInformationNeededInGame();
        int currentMoney= mission.getMissionMoney();
        int x = (int) (Math.random() * 30);
        int y = (int) (Math.random() * 30);
        if(getAnimalName().equals("Cat")){
            Cat cat=new Cat(Game.getGameInstance().getCurrentUserAccount().getCatLevel());
            int price=informationNeededInGame.getPriceToBuy(cat);
            if(currentMoney >= price){
                cat.setX(x);
                cat.setY(y);
                mission.ChangeMissionMoney(-price);
                farm.getMap()[x][y].AddCellAMapObject(cat);
            }
            else
                throw new NotEnoughMoney();
        }
        else if(getAnimalName().equals("Dog")){
            Dog dog=new Dog();
            int price=informationNeededInGame.getPriceToBuy(dog);
            if(currentMoney >= price){
                dog.setX(x);
                dog.setY(y);
                mission.ChangeMissionMoney(-price);
                farm.getMap()[x][y].AddCellAMapObject(dog);
            }
            else
                throw new NotEnoughMoney();
        }
        else if(getAnimalName().equals("Chicken")){
            Chicken chicken=new Chicken();
            int price=informationNeededInGame.getPriceToBuy(chicken);
            if(currentMoney >= price){
                chicken.setX(x);
                chicken.setY(y);
                mission.ChangeMissionMoney(-price);
                farm.getMap()[x][y].AddCellAMapObject(chicken);
            }
            else
                throw new NotEnoughMoney();
        }
        else if(getAnimalName().equals("Sheep")){
            Sheep sheep=new Sheep();
            int price=informationNeededInGame.getPriceToBuy(sheep);
            if(currentMoney >= price){
                sheep.setX(x);
                sheep.setY(y);
                mission.ChangeMissionMoney(-price);
                farm.getMap()[x][y].AddCellAMapObject(sheep);
            }
            else
                throw new NotEnoughMoney();
        }
        if(getAnimalName().equals("Cow")){
            Cow cow=new Cow();
            int price=informationNeededInGame.getPriceToBuy(cow);
            if(currentMoney >= price){
                cow.setX(x);
                cow.setY(y);
                mission.ChangeMissionMoney(-price);
                farm.getMap()[x][y].AddCellAMapObject(cow);
            }
            else
                throw new NotEnoughMoney();
        }

    }

    public void AnalyzeRequestLine(String requestLine) {
        String[] params = requestLine.split(" ");
        setAnimalName(params[1]);
    }
}
