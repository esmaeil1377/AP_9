package FarmModel.Request;

import FarmController.Exceptions.FullWareHouse;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.WellIsNotEmpty;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.LiveAnimals.*;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;
import FarmModel.User;
import View.GameView;

import java.util.ArrayList;

public class TurnRequest extends Request {
    private int n;

    public TurnRequest(String requestLine) throws UnknownObjectException, MissionNotLoaded, FullWareHouse, WellIsNotEmpty {
        AnalyzeRequestLine(requestLine);
        DoWorkByPassingTime(getN());
    }

    private int getN() {
        return n;
    }

    private void setN(int n) {
        this.n = n;
    }

    public void AnalyzeRequestLine(String requestLIne) {
        setN(Integer.valueOf(requestLIne.substring(5)));
    }

    private void DoWorkByPassingTime(int turn) throws UnknownObjectException, MissionNotLoaded, FullWareHouse, WellIsNotEmpty {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        for (int t = 0; t < turn; t++) {
            KillAnimalsThatAreVeryHungryOrMakeThemHungrierOrEat(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeWildAnimalDestroy(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MoveObject(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeProductDisappearOrDecreaseRemainTurnToDisappear(farm.getCurrentProductInMap());
            MakeAnimalProduce(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
//            MakeWorkShopProduce(farm.getWorkShops());
            MakeGrassDisappear(farm.getCurrentGrassInMap());
//            FillTheBucketOfTheWellOrDecreaseRemainTurnToFillTheBucket();
            MakeTruckPassTheWayToCityOrGiveObjectToCity();
            MakeHelicopterPassTheWayToCityOrPutThemOnMap();
            MakeCatTakeProductOrPutProductToWareHouseIfItWasNearWareHouse(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeDogKillWildAnimal(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            AddWildAnimalsToMapAfterOneMinute();
            StopMissionIfItIsFinishedAndIncreaseMoneyUserOrIncreaseTimeForPlayerToFinishTheMission();
            //and so on
        }
    }

    private void AddWildAnimalsToMapAfterOneMinute() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        if (farm.getRemainTurnToRandomlyAddWildAnimalToMap() == 0) {
            int randomX = ((int) (Math.random() * 15));
            int randomY = ((int) (Math.random() * 15));
            Cell randomCell = farm.getMap()[randomX][randomY];
            Lion lion=new Lion();
            lion.setX(randomX);
            lion.setY(randomY);
            randomCell.AddCellAMapObject(lion);
            farm.setRemainTurnToRandomlyAddWildAnimalToMap(60);
        } else {
            int remainTurnNeededToAddNewWildAnimal =farm.getRemainTurnToRandomlyAddWildAnimalToMap();
            farm.setRemainTurnToRandomlyAddWildAnimalToMap(remainTurnNeededToAddNewWildAnimal - 1);
        }
        //When we should add bear to map.
    }

    private void MoveObject(ArrayList<Animals> currentAnimalsInMap) throws MissionNotLoaded {
        for (Animals animals : currentAnimalsInMap) {
            Animals.Walk(animals);
        }
    }

    private void KillAnimalsThatAreVeryHungryOrMakeThemHungrierOrEat(ArrayList<Animals> currentAnimalInMap) throws MissionNotLoaded {
        if(currentAnimalInMap!=null) {
            for (Animals animals : currentAnimalInMap) {
                if (animals instanceof AnimalProducer) {
                    int x = animals.getX();
                    int y = animals.getY();
                    Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[x][y];
                    if (((AnimalProducer) animals).getAnimalAmountOfHunger() == 0) {
                        ((AnimalProducer) animals).setWantToEatGrass(true);
                        if (cell.HasGrass()) {
                            ((AnimalProducer) animals).EatGrass();
                        } else {
                            cell.RemoveCellAMapObject(animals);
                            GameView.getGameView().getFarmView().ShowDingAnimal(animals,x,y);
                        }
                    } else if (((AnimalProducer) animals).getAnimalAmountOfHunger() <= ((AnimalProducer) animals).getMinOfHungerToGoToFindTheGrass()) {
                        ((AnimalProducer) animals).setWantToEatGrass(true);
                        if (cell.HasGrass()) {
                            ((AnimalProducer) animals).EatGrass();
                        } else {
                            ((AnimalProducer) animals).setAnimalAmountOfHunger(((AnimalProducer) animals).getAnimalAmountOfHunger() - 1);
                        }
                    } else if (((AnimalProducer) animals).getAnimalAmountOfHunger() < ((AnimalProducer) animals).getHealthyAnimalAmountOfHunger()) {
                        if (((AnimalProducer) animals).WantToEat()) {
                            ((AnimalProducer) animals).EatGrass();
                        } else {
                            ((AnimalProducer) animals).setAnimalAmountOfHunger(((AnimalProducer) animals).getAnimalAmountOfHunger() - 1);
                        }
                    } else {
                        ((AnimalProducer) animals).setAnimalAmountOfHunger(((AnimalProducer) animals).getAnimalAmountOfHunger() - 1);
                    }
                }
            }
        }
    }

    private void MakeDogKillWildAnimal(ArrayList<Animals> currentAnimalInMap) throws MissionNotLoaded {
        if(currentAnimalInMap!=null) {
            for (Animals animals : currentAnimalInMap) {
                if (animals instanceof Dog) {
                    int x = animals.getX();
                    int y = animals.getY();
                    Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[x][y];
                    if (cell.HasWildAnimal()) {
                        GameView.getGameView().getFarmView().ShowFightBetweenDogAndWildAnimal(x,y);
                        cell.RemoveCellAMapObject(animals);
                        for (ObjectInMap15_15 objectInMap15_15 : cell.getCellObjectInMap15_15()) {
                            if (objectInMap15_15 instanceof WildAnimals) {
                                cell.RemoveCellAMapObject(objectInMap15_15);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private void MakeCatTakeProductOrPutProductToWareHouseIfItWasNearWareHouse(ArrayList<Animals> currentAnimalInMap) throws MissionNotLoaded, FullWareHouse {
        if(currentAnimalInMap!=null) {
            for (Animals animals : currentAnimalInMap) {
                if (animals instanceof Cat) {
                    if (animals.getX() == 7 && animals.getY() == 0 && ((Cat) animals).getProduct() != null) {
                        ((Cat) animals).PutProductInStore();
                    } else {
                        ((Cat) animals).TakeProduct();
                    }
                }
            }
        }
    }

    private void MakeProductDisappearOrDecreaseRemainTurnToDisappear(ArrayList<Product> currentProductInMap) throws MissionNotLoaded {
        if(currentProductInMap!=null) {
            for (Product product : currentProductInMap) {
                if (product.getRemainTurnToDisapear() == 0) {
                    int x = product.getX();
                    int y = product.getY();
                    Farm.getCellByPosition(x, y).RemoveCellAMapObject(product);
                    GameView.getGameView().getFarmView().RemoveGrassAndProductFromMap(product.toString(),x,y);
                } else {
                    product.setRemainTurnToDisapear(product.getRemainTurnToDisapear() - 1);
                }
            }
        }
    }

//    private void MakeWorkShopProduce(ArrayList<WorkShop> currentWorkShopInMap) throws MissionNotLoaded {
//        if(currentWorkShopInMap!=null) {
//            for (WorkShop workShop : currentWorkShopInMap) {
//                if (workShop.getRemainTurnToProduce() == 0 && workShop.IsWorkshopActivatedToMakeProduct()) {
//                    workShop.MakeAProductAndPutItInMap();
//                    workShop.setWorkShopActivatedToMakeProduct(false);
//                } else if (workShop.getRemainTurnToProduce() != 0 && workShop.IsWorkshopActivatedToMakeProduct()) {
//                    workShop.setRemainTurnToProduce(workShop.getRemainTurnToProduce() - 1);
//                }
//            }
//        }
//    }

    private void MakeAnimalProduce(ArrayList<Animals> currentAnimalsInMap) throws MissionNotLoaded {
        if(currentAnimalsInMap!=null) {
            for (Animals animals : currentAnimalsInMap) {
                if (animals instanceof AnimalProducer) {
                    if (((AnimalProducer) animals).getRemainTurnToProduce() == 0) {
                        try {
                            ((AnimalProducer) animals).Produce();
                        }catch (Exception e){}
                        ((AnimalProducer) animals).setRemainTurnToProduce(((AnimalProducer) animals).getTurnToProduce());
                    } else {
                        ((AnimalProducer) animals).setRemainTurnToProduce(((AnimalProducer) animals).getRemainTurnToProduce() - 1);
                    }
                }
            }
        }
    }

    private void MakeGrassDisappear(ArrayList<Grass> currentGrassInMap) throws MissionNotLoaded {
        if(currentGrassInMap!=null) {
            for (Grass grass : currentGrassInMap) {
                if (grass.getRemainTurnToDisAppear() == 0) {
                    int x = grass.getX();
                    int y = grass.getY();
                    Farm.getCellByPosition(x, y).RemoveCellAMapObject(grass);
                    GameView.getGameView().getFarmView().RemoveGrassAndProductFromMap("Grass",x,y);
                } else {
                    grass.setRemainTurnToDisAppear(grass.getRemainTurnToDisAppear() - 1);
                }
            }
        }
    }

//    private void FillTheBucketOfTheWellOrDecreaseRemainTurnToFillTheBucket() throws MissionNotLoaded, WellIsNotEmpty {
//        Well well = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWell();
//        if (well.getRemainTurnToFillTheBucket() == 0 && well.isWellActivatedToFillTheBucket()) {
//            well.FillTheBucket();
//            well.setWellActivatedToFillTheBucket(false);
//        } else if (well.getRemainTurnToFillTheBucket() != 0 && well.isWellActivatedToFillTheBucket()) {
//            well.setRemainTurnToFillTheBucket(well.getRemainTurnToFillTheBucket() - 1);
//        }
//    }

    private void MakeWildAnimalDestroy(ArrayList<Animals> currentAnimlInMap) throws MissionNotLoaded {
        if(currentAnimlInMap!=null) {
            for (Animals animals : currentAnimlInMap) {
                if (animals instanceof WildAnimals) {
                    int x = animals.getX();
                    int y = animals.getY();
                    Cell cell = Farm.getCellByPosition(x, y);
                    ArrayList<ObjectInMap15_15> copyOfObjectInCell = new ArrayList<>(cell.getCellObjectInMap15_15());
                    for (ObjectInMap15_15 objectInMap15_15 : copyOfObjectInCell) {
                        if (!(objectInMap15_15 instanceof Grass) && !(objectInMap15_15 instanceof WildAnimals)) {
                            cell.RemoveCellAMapObject(objectInMap15_15);
                            if (!objectInMap15_15.toString().equals("Cat") & !objectInMap15_15.toString().equals("Cow") & !objectInMap15_15.toString().equals("Chicken") & !objectInMap15_15.toString().equals("Sheep")) {
                                GameView.getGameView().getFarmView().RemoveGrassAndProductFromMap(objectInMap15_15.toString(), x, y);
                            }
                        }
                    }
                }
            }
        }
    }

    private void MakeTruckPassTheWayToCityOrGiveObjectToCity() throws UnknownObjectException, MissionNotLoaded {
        Truck truck = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getTruck();
        if(truck!=null) {
            if (truck.getRemainTurnToMoveObjectToCityAndComeBack() == 0 && truck.IsVehicleActivated()) {
                truck.SellObjectToCityAndGetMoneyToUser();
                truck.setVehicleActivated(false);
            } else if (truck.IsVehicleActivated()) {
                truck.setRemainTurnToMoveObjectToCityAndComeBack(truck.getRemainTurnToMoveObjectToCityAndComeBack() - 1);
            }
        }
    }

    private void MakeHelicopterPassTheWayToCityOrPutThemOnMap() throws MissionNotLoaded {
        Helicopter helicopter = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getHelicopter();
        if(helicopter!=null) {
            if (helicopter.getRemainTurnToMoveObjectToCityAndComeBack() == 0 && helicopter.IsVehicleActivated()) {
                try {
                    helicopter.PutObjectInMapRandomly();
                }catch (NullPointerException e){}
                finally {
                    helicopter.setVehicleActivated(false);
                }
            } else if (helicopter.IsVehicleActivated()) {
                helicopter.setRemainTurnToMoveObjectToCityAndComeBack(helicopter.getRemainTurnToMoveObjectToCityAndComeBack() - 1);
            }
        }
    }


    private void StopMissionIfItIsFinishedAndIncreaseMoneyUserOrIncreaseTimeForPlayerToFinishTheMission() throws MissionNotLoaded {
        User user = Game.getGameInstance().getCurrentUserAccount();
        user.getCurrentPlayingMission().setTimeTakeForPlayerToFinishTheMap(user.getCurrentPlayingMission().getTimeTakeForPlayerToFinishTheMap() + 1);
        if (user.getCurrentPlayingMission().CheckIfMissionIsFinished()) {
            user.getCurrentPlayingMission().setMissionCompletion(true);
            user.AddMoney(user.getCurrentPlayingMission().CalculateMoneyToGiveUserAfterCompletingTheMission());
            System.out.println(user.getCurrentPlayingMission().getMissionName()+" ended.");
            Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(null);
            //Now It should go out of the mission don't know how.
        }
    }
}