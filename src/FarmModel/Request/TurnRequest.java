package FarmModel.Request;

import FarmModel.Cell;
import FarmModel.Farm;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.LiveAnimals.*;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;
import FarmModel.ObjectInMap15_15.Product.Product;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Helicopter;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Vehicle.Truck;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.Well;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;
import FarmModel.User;

import java.util.ArrayList;

public class TurnRequest extends Request {
    private int n;

    public TurnRequest(String requestLine) {
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

    private void DoWorkByPassingTime(int turn) {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        for (int t = 0; t < turn; t++) {
            AddWildAnimalsToMapAfterOneMinute();
            MoveObject(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            KillAnimalsThatAreVeryHungeryOrMakeThemHungrierOrEat(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeProductDisapearOrDecreaseRemainTurnToDisapear(farm.getCurrentProductInMap());
            MakeAnimalProduce(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeWorkShopProduce(farm.getWorkShops());
            MakeGrassDisapear(farm.getCurrentGrassInMap());
            FillTheBucketOfTheWellOrDecreaseRemainTurnToFillTheBucket();
            MakeTruckPassTheWayToCityOrGiveObjectToCity();
            MakeHelicopterPassTheWayToCityOrGiveWareHouseWhatItWanted();
            MakeCatTakeProduct(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeDogKillWildAnimal(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            MakeWildAnimalDestroy(farm.getCurrentAnimalInTheMapAndSetMaxNumberOfEachAnimal());
            StopMissionIfItIsFinishedAndIncreaseMoneyUserOrIncreaseTimeForPlayerToFinishTheMission();
            //and so on
        }
    }

    private void AddWildAnimalsToMapAfterOneMinute() {
        Farm farm = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        int randomX = ((int) (Math.random() * 16));
        int randomY = ((int) (Math.random() * 16));
        Cell randomCell = farm.getMap()[randomX][randomY];
        if (farm.getRemainTurnToRandomlyAddWildAnimalToMap() == 0) {
            randomCell.AddCellAMapObject(new Lion());
            farm.setRemainTurnToRandomlyAddWildAnimalToMap(60);
        } else {
            int remainTrurnNeededToAddNewWildAnimal =farm.getRemainTurnToRandomlyAddWildAnimalToMap();
            farm.setRemainTurnToRandomlyAddWildAnimalToMap(remainTrurnNeededToAddNewWildAnimal - 1);
        }
        //When we should add bear to map.
    }

    private void MoveObject(ArrayList<Animals> currentAnimalsInMap) {
        for (Animals animals : currentAnimalsInMap) {
            Animals.Walk(animals);
        }
    }

    private void KillAnimalsThatAreVeryHungeryOrMakeThemHungrierOrEat(ArrayList<Animals> currentAnimalInMap) {
        for (Animals animals : currentAnimalInMap) {
            if (animals instanceof AnimalProducer) {
                int x = animals.getX();
                int y = animals.getY();
                Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y];
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

    private void MakeDogKillWildAnimal(ArrayList<Animals> currentAnimalInMap) {
        for (Animals animals : currentAnimalInMap) {
            if (animals instanceof Dog) {
                int x = animals.getX();
                int y = animals.getY();
                Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y];
                if (cell.HasWildAnimal()) {
                    cell.RemoveCellAMapObject(animals);
                    for (ObjectInMap15_15 objectInMap15_15 : cell.getCellObjectInMap1515()) {
                        if (objectInMap15_15 instanceof WildAnimals) {
                            cell.RemoveCellAMapObject(objectInMap15_15);
                            break;
                        }
                    }
                }
            }
        }

    }

    private void MakeCatTakeProduct(ArrayList<Animals> currentAnimalInMap) {
        for (Animals animals : currentAnimalInMap) {
            if (animals instanceof Cat) {
                int x = animals.getX();
                int y = animals.getY();
                Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y];
                if (cell.HasProduct()) {
                    for (ObjectInMap15_15 objectInMap15_15 : cell.getCellObjectInMap1515()) {
                        if (objectInMap15_15 instanceof Product) {
                            cell.RemoveCellAMapObject(objectInMap15_15);
                            ((Cat) animals).setProduct((Product) objectInMap15_15);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void MakeProductDisapearOrDecreaseRemainTurnToDisapear(ArrayList<Product> currentProductInMap) {
        for (Product product : currentProductInMap) {
            if (product.getRemainTurnToDisapear() == 0) {
                int x = product.getX();
                int y = product.getY();
                Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].RemoveCellAMapObject(product);
            } else {
                product.setRemainTurnToDisapear(product.getRemainTurnToDisapear() - 1);
            }
        }
    }

    private void MakeWorkShopProduce(ArrayList<WorkShop> currentWorkShopInMap) {
        for (WorkShop workShop : currentWorkShopInMap) {
            if (workShop.getRemainTurnToProduce() == 0 && workShop.IsWorkshopActivatedToMakeProduct()) {
                workShop.MakeAProductAndPutItInMap();
                workShop.setWorkShopActivatedToMakeProduct(false);
            } else if (workShop.getRemainTurnToProduce() != 0 && workShop.IsWorkshopActivatedToMakeProduct()) {
                workShop.setRemainTurnToProduce(workShop.getRemainTurnToProduce() - 1);
            }
        }
    }

    private void MakeAnimalProduce(ArrayList<Animals> currentAnimalsInMap) {
        for (Animals animals : currentAnimalsInMap) {
            if (animals instanceof AnimalProducer) {
                if (((AnimalProducer) animals).getRemainTurnToProduce() == 0) {
                    ((AnimalProducer) animals).Produce();
                } else {
                    ((AnimalProducer) animals).setRemainTurnToProduce(((AnimalProducer) animals).getRemainTurnToProduce() - 1);
                }
            }
        }

    }

    private void MakeGrassDisapear(ArrayList<Grass> currentGrassInMap) {
        for (Grass grass : currentGrassInMap) {
            if (grass.getRemainTurnToDisApear() == 0) {
                int x = grass.getX();
                int y = grass.getY();
                Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].RemoveCellAMapObject(grass);
            } else {
                grass.setRemainTurnToDisApear(grass.getRemainTurnToDisApear() - 1);
            }
        }
    }

    private void FillTheBucketOfTheWellOrDecreaseRemainTurnToFillTheBucket() {
        Well well = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getWell();
        if (well.getRemainTurnToFillTheBucket() == 0 && well.isWellActivatedToFillTheBucket()) {
            well.FillTheBucket();
            well.setWellActivatedToFillTheBucket(false);
        } else if (well.getRemainTurnToFillTheBucket() != 0 && well.isWellActivatedToFillTheBucket()) {
            well.setRemainTurnToFillTheBucket(well.getRemainTurnToFillTheBucket() - 1);
        }
    }


    private void MakeWildAnimalDestroy(ArrayList<Animals> currnetAnimlInMap) {
        for (Animals animals : currnetAnimlInMap) {
            if (animals instanceof WildAnimals) {
                int x = animals.getX();
                int y = animals.getY();
                Cell cell = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y];
                ArrayList<ObjectInMap15_15> copyOfObjectInCell = new ArrayList<>(cell.getCellObjectInMap1515());
                for (ObjectInMap15_15 objectInMap15_15 : copyOfObjectInCell) {
                    if (!(objectInMap15_15 instanceof Grass) && !(objectInMap15_15 instanceof WildAnimals)) {
                        cell.RemoveCellAMapObject(objectInMap15_15);
                    }
                }
            }
        }
    }

    private void MakeTruckPassTheWayToCityOrGiveObjectToCity() {
        Truck truck = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getTruck();
        if (truck.getRemainTurnToMoveObjectToCityAndComeBack() == 0 && truck.IsVehicleActivated()) {
            truck.SellObjectToCityAndGetMoneyToUser();
        } else if (truck.IsVehicleActivated()) {
            truck.setRemainTurnToMoveObjectToCityAndComeBack(truck.getRemainTurnToMoveObjectToCityAndComeBack() - 1);
        }
    }

    private void MakeHelicopterPassTheWayToCityOrGiveWareHouseWhatItWanted() {
        Helicopter helicopter = Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getHelicopter();
        if (helicopter.getRemainTurnToMoveObjectToCityAndComeBack() == 0 && helicopter.IsVehicleActivated()) {
            helicopter.PutObjectInMapRandomly();
        } else if (helicopter.IsVehicleActivated()) {
            helicopter.setRemainTurnToMoveObjectToCityAndComeBack(helicopter.getRemainTurnToMoveObjectToCityAndComeBack() - 1);
        }
    }


    private void StopMissionIfItIsFinishedAndIncreaseMoneyUserOrIncreaseTimeForPlayerToFinishTheMission() {
        User user = Game.getGameInstance().getCurrentUserAcount();
        if (user.getCurrentPlayingMission().CheckIfMissionIsFinished()) {
            user.getCurrentPlayingMission().setMissionCompletion(true);
            user.AddMoney(user.getCurrentPlayingMission().CalcualteMoneyToGiveUserAfterCompletingTheMission());
            Game.getGameInstance().getCurrentUserAcount().setCurrentPlayingMission(null);
            //Now It should go out of the mission don't know how.
        } else {
            user.getCurrentPlayingMission().setTimeTakeForPlayerToFinishTheMap(user.getCurrentPlayingMission().getTimeTakeForPlayerToFinishTheMap() + 1);
        }
    }



}