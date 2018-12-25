package FarmModel.Request;

import FarmController.Exceptions.FullWareHouse;
import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEmptyWell;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Grass;
import FarmModel.ObjectInMap30_30.LiveAnimals.*;
import FarmModel.ObjectInMap30_30.ObjectInMap30_30;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop.WorkShop;
import FarmModel.User;

import java.util.ArrayList;

public class TurnRequest extends Request {
    private int n;

    public TurnRequest(String requestLine) throws UnknownObjectException, MissionNotLoaded, FullWareHouse, NotEmptyWell {
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

    private void DoWorkByPassingTime(int turn) throws UnknownObjectException, MissionNotLoaded, FullWareHouse, NotEmptyWell {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        for (int t = 0; t < turn; t++) {
            AddWildAnimalsToMapAfterOneMinute();
            KillAnimalsThatAreVeryHungryOrMakeThemHungrierOrEat(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MoveObject(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeProductDisappearOrDecreaseRemainTurnToDisappear(farm.getCurrentProductInMap());
            MakeAnimalProduce(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeWorkShopProduce(farm.getWorkShops());
            MakeGrassDisapear(farm.getCurrentGrassInMap());
            FillTheBucketOfTheWellOrDecreaseRemainTurnToFillTheBucket();
            MakeTruckPassTheWayToCityOrGiveObjectToCity();
            MakeHelicopterPassTheWayToCityOrPutThemOnMap();
            MakeCatTakeProductOrPutProductToWareHouseIfItWasNearWareHouse(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeDogKillWildAnimal(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeWildAnimalDestroy(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            StopMissionIfItIsFinishedAndIncreaseMoneyUserOrIncreaseTimeForPlayerToFinishTheMission();
            //and so on
        }
    }

    private void AddWildAnimalsToMapAfterOneMinute() throws MissionNotLoaded {
        Farm farm = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm();
        if (farm.getRemainTurnToRandomlyAddWildAnimalToMap() == 0) {
            int randomX = ((int) (Math.random() * 30));
            int randomY = ((int) (Math.random() * 30));
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
                        cell.RemoveCellAMapObject(animals);
                        for (ObjectInMap30_30 objectInMap30_30 : cell.getCellObjectInMap30_30()) {
                            if (objectInMap30_30 instanceof WildAnimals) {
                                cell.RemoveCellAMapObject(objectInMap30_30);
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
                    if (animals.getX() == 15 && animals.getY() == 0 && ((Cat) animals).getProduct() != null) {
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
                } else {
                    product.setRemainTurnToDisapear(product.getRemainTurnToDisapear() - 1);
                }
            }
        }
    }

    private void MakeWorkShopProduce(ArrayList<WorkShop> currentWorkShopInMap) throws MissionNotLoaded {
        if(currentWorkShopInMap!=null) {
            for (WorkShop workShop : currentWorkShopInMap) {
                if (workShop.getRemainTurnToProduce() == 0 && workShop.IsWorkshopActivatedToMakeProduct()) {
                    workShop.MakeAProductAndPutItInMap();
                    workShop.setWorkShopActivatedToMakeProduct(false);
                } else if (workShop.getRemainTurnToProduce() != 0 && workShop.IsWorkshopActivatedToMakeProduct()) {
                    workShop.setRemainTurnToProduce(workShop.getRemainTurnToProduce() - 1);
                }
            }
        }
    }

    private void MakeAnimalProduce(ArrayList<Animals> currentAnimalsInMap) throws MissionNotLoaded {
        if(currentAnimalsInMap!=null) {
            for (Animals animals : currentAnimalsInMap) {
                if (animals instanceof AnimalProducer) {
                    if (((AnimalProducer) animals).getRemainTurnToProduce() == 0) {
                        ((AnimalProducer) animals).Produce();
                        ((AnimalProducer) animals).setRemainTurnToProduce(((AnimalProducer) animals).getTurnToProduce());
                    } else {
                        ((AnimalProducer) animals).setRemainTurnToProduce(((AnimalProducer) animals).getRemainTurnToProduce() - 1);
                    }
                }
            }
        }
    }

    private void MakeGrassDisapear(ArrayList<Grass> currentGrassInMap) throws MissionNotLoaded {
        if(currentGrassInMap!=null) {
            for (Grass grass : currentGrassInMap) {
                if (grass.getRemainTurnToDisAppear() == 0) {
                    int x = grass.getX();
                    int y = grass.getY();
                    Farm.getCellByPosition(x, y).RemoveCellAMapObject(grass);
                } else {
                    grass.setRemainTurnToDisAppear(grass.getRemainTurnToDisAppear() - 1);
                }
            }
        }
    }

    private void FillTheBucketOfTheWellOrDecreaseRemainTurnToFillTheBucket() throws MissionNotLoaded, NotEmptyWell {
        Well well = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getWell();
        if (well.getRemainTurnToFillTheBucket() == 0 && well.isWellActivatedToFillTheBucket()) {
            well.FillTheBucket();
            well.setWellActivatedToFillTheBucket(false);
        } else if (well.getRemainTurnToFillTheBucket() != 0 && well.isWellActivatedToFillTheBucket()) {
            well.setRemainTurnToFillTheBucket(well.getRemainTurnToFillTheBucket() - 1);
        }
    }


    private void MakeWildAnimalDestroy(ArrayList<Animals> currentAnimlInMap) throws MissionNotLoaded {
        if(currentAnimlInMap!=null) {
            for (Animals animals : currentAnimlInMap) {
                if (animals instanceof WildAnimals) {
                    int x = animals.getX();
                    int y = animals.getY();
                    Cell cell = Farm.getCellByPosition(x, y);
                    ArrayList<ObjectInMap30_30> copyOfObjectInCell = new ArrayList<>(cell.getCellObjectInMap30_30());
                    for (ObjectInMap30_30 objectInMap30_30 : copyOfObjectInCell) {
                        if (!(objectInMap30_30 instanceof Grass) && !(objectInMap30_30 instanceof WildAnimals)) {
                            cell.RemoveCellAMapObject(objectInMap30_30);
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