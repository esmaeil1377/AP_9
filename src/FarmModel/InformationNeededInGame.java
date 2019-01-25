package FarmModel;

import FarmController.Exceptions.UnknownObjectException;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;
import FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop.WorkShop;

public class InformationNeededInGame {

    //well information
    public static int CapacityOfTheBucket = 5;
    public static int PriceToFillTheBucket = 19;


    //ActivationPrices
    // random price
//    private static int ActivationPriceForUpgradeWareHouse = 100;
//    private static int intActivationPriceForUpgradeWorkShop = 100;
//    private static int ActivationPriceForHelicopter = 100;
//    private static int ActivationPriceForTruck = 100;
//    private static int ActivationPriceForCustomWorkShop = 100;

//    public void IncraesePriceForUpgrade(String str) {
//        if (str.equals("CakeBakery")) {
//            PriceToUpgradeCakeBakery +=;
//        } else if (str.equals("EggPowderPlant")) {
//            PriceToUpgradeEggPowderPlant +=;
//        } else if (str.equals("CookieBakery")) {
//            PriceToUpgradeCookieBakery +=;
//        } else if (str.equals("SewingFactory")) {
//            PriceToUpgradeSewingFactory +=;
//        } else if (str.equals("Spinnery")) {
//            PriceToUpgradeSpinnery +=;
//        } else if (str.equals("WeavingFactory")) {
//            PriceToUpgradeWeavingFactory +=;
//        } else if (str.equals("Well")) {
//            PriceToUpgradeWell +=;
//        } else if (str.equals("WareHouse")) {
//            PriceToUpgradeWareHouse +=;
//        } else if (str.equals("CustomWorkShop")) {
//            PriceToUpgradeUnknownWorkShop +=;
//        }
//        throw new NotDefinedPriceForUpgrade();
//    }


    //SpaceNeededInWareHouseForObject
    private final static int SpaceNeededInWareHouseForCageThatLionIsInIt = 20;
    private final static int SpaceNeededInWareHouseForCageThatBearIsInIt = 20;
    private final static int SpaceNeededInWareHouseForEgg = 1;
    private final static int SpaceNeededInWareHouseForWool = 5;
    private final static int SpaceNeededInWareHouseForMilk = 10;
    private final static int SpaceNeededInWareHouseForFlouryCake = 5;
    private final static int SpaceNeededInWareHouseForPowder = 4; // random
    private final static int SpaceNeededInWareHouseForFlour = 2;
    private final static int SpaceNeededInWareHouseForFabric = 6;
    private final static int SpaceNeededInWareHouseForSewing = 3;
    private final static int SpaceNeededInWareHouseForDecoration = 2; // random
    private final static int SpaceNeededInWareHouseForCloth = 3; // random
    private final static int SpaceNeededInWareHouseForCake = 2; // random

    //PriceToUpgradeCat
    //PriceToBuyWorkShop

    public int getSpaceNeededInWareHouse(Object object) {
        if (object.toString().substring(0,3).equals("Cag")) {
            WildAnimals wildAnimals = ((Cage) object).getWildAnimals();
            if (wildAnimals.toString().equals("Lion"))
                return SpaceNeededInWareHouseForCageThatLionIsInIt;
            if (wildAnimals.toString().equals("Bear"))
                return SpaceNeededInWareHouseForCageThatBearIsInIt;
        }
        if (object.toString().equals("Egg"))
            return SpaceNeededInWareHouseForEgg;
        else if (object.toString().equals("Milk"))
            return SpaceNeededInWareHouseForMilk;
        else if (object.toString().equals("Wool"))
            return SpaceNeededInWareHouseForWool;
        else if (object.toString().equals("FlouryCake"))
            return SpaceNeededInWareHouseForFlouryCake;
        else if (object.toString().equals("Powder"))
            return SpaceNeededInWareHouseForPowder;
        else if (object.toString().equals("Flour"))
            return SpaceNeededInWareHouseForFlour;
        else if (object.toString().equals("Fiber"))
            return SpaceNeededInWareHouseForFabric;
        else if (object.toString().equals("Sewing"))
            return SpaceNeededInWareHouseForSewing;
        else if (object.toString().equals("Decoration"))
            return SpaceNeededInWareHouseForDecoration;
        else if (object.toString().equals("CarnivalDress"))
            return SpaceNeededInWareHouseForCloth;
        else if (object.toString().equals("Cake"))
            return SpaceNeededInWareHouseForCake;
//        throw new NotDefinedSpaceForObject();
        //don't forget.
        return -1;
    }


    private final static int PriceToUpgradeCatLevel1 = 500;
    //PriceToUpgradeWorkShop
    private final static int PriceToUpgradeCakeBakery = 300;
    private final static int PriceToUpgradeCookieBakery = 200;
    private final static int PriceToUpgradeEggPowderPlant = 100;
    private final static int PriceToUpgradeSewingFactory = 2000;
    private final static int PriceToUpgradeSpinnery = 1000;
    private final static int PriceToUpgradeUnknownWorkShop = 1000;
    private final static int PriceToUpgradeWeavingFactory = 1500;
    //PriceToUpgradeWell
    private final static int PriceToUpgradeWell = 1000; // random
    //PriceToUpgradeWareHouse
    private final static int PriceToUpgradeWareHouse = 1500; // random

    public int getPriceForUpgrade(Object object) throws UnknownObjectException {
        if (object.toString().equals("Well")) {
            return PriceToUpgradeWell;
        } else if (object.toString().equals("Cat")) {
            return PriceToUpgradeCatLevel1;
        } else if (object.toString().equals("WareHouse")) {
            return PriceToUpgradeWareHouse;
        } else {
            int level = ((WorkShop) object).getLevel();
            if (object.toString().equals("CakeBakery")) {
                return PriceToUpgradeCakeBakery + 100 * (level);
            } else if (object.toString().equals("EggPowderPlant")) {
                return PriceToUpgradeEggPowderPlant + 100 * level;
            } else if (object.toString().equals("CookieBakery")) {
                return PriceToUpgradeCookieBakery + 100 * level;
            } else if (object.toString().equals("SewingFactory")) {
                return PriceToUpgradeSewingFactory + 100 * level;
            } else if (object.toString().equals("Spinnery")) {
                return PriceToUpgradeSpinnery + 100 * level;
            } else if (object.toString().equals("WeavingFactory")) {
                return PriceToUpgradeWeavingFactory + 100 * level;
            } else if (object.toString().equals("CustomWorkShop")) {
                return PriceToUpgradeUnknownWorkShop + 100 * level;
            } else
                throw new UnknownObjectException();
        }
    }


    private final static int PriceToBuyChicken = 100;
    private final static int PriceToBuyShip = 1000;
    private final static int PriceToBuyCow = 10000;

    private final static int PriceToBuyCat = 2500;
    private final static int PriceToBuyDog = 2600;

    private final static int PriceToBuyEggPowderPlantLevel0 = 150;
    private final static int PriceToBuySewingFactoryLevel0 = 2500;
    private final static int PriceToBuySpinneryLevel0 = 2000;
    private final static int PriceToBuyUnknownWorkShopLevel0 = 2000; // random
    private final static int PriceToBuyWeavingFactoryLevel0 = 2000;
    private final static int PriceToBuyCakeBakeryLevel0 = 300;
    private final static int PriceToBuyCookieBakeryLevel0 = 200;

    private final static int PriceTOBuyWool = 200;
    private final static int PriceToBuyEgg = 20;
    private final static int PriceToBuyMilk = 2000;

    private final static int PriceToBuyCake=200;
    private final static int PriceToBuyCarnivalDress=1400;
    //cookie and decoration toye file dade shode naboud khodam dadam
    private final static int PriceToBuyCookie=200;
    private final static int PriceToBuyDecoration=800;
    private final static int PriceToBuyFabric=400;
    private final static int PriceToBuyFlour=100;
    private final static int PriceToBuyPowder=300;
    private final static int PriceToBuySewing=200;

    public int getPriceToBuy(Object object) {
        if (object.toString().equals("Chicken")) {
            return PriceToBuyChicken;
        } else if (object.toString().equals("Cow")) {
            return PriceToBuyCow;
        } else if (object.toString().equals("Sheep")) {
            return PriceToBuyShip;
        } else if (object.toString().equals("Cat")) {
            return PriceToBuyCat;
        } else if (object.toString().equals("Dog")) {
            return PriceToBuyDog;
        } else if (object.toString().equals("CookieBakery")) {
            return PriceToBuyCookieBakeryLevel0;
        } else if (object.toString().equals("Egg")) {
            return PriceToBuyEgg;
        } else if (object.toString().equals("Wool")) {
            return PriceTOBuyWool;
        } else if (object.toString().equals("Milk")) {
            return PriceToBuyMilk;
        }else if(object.toString().equals("FlouryCake")){
            return PriceToBuyCake;
        }else if(object.toString().equals("Cake")){
            return PriceToBuyCookie;
        } else if(object.toString().equals("Sewing")){
            return PriceToBuySewing;
        }else if(object.toString().equals("Powder")){
            return PriceToBuyPowder;
        }else if(object.toString().equals("Decoration")){
            return PriceToBuyDecoration;
        }else if(object.toString().equals("Flour")){
            return PriceToBuyFlour;
        }else if(object.toString().equals("Fabric")){
            return PriceToBuyFabric;
        }else if (object.toString().equals("CarnivalDress")){
            return PriceToBuyCarnivalDress;
        }else {
            if (object.toString().equals("EggPowderPlant")) {
                return PriceToBuyEggPowderPlantLevel0 + 100 * (((WorkShop) object).getLevel());
            } else if (object.toString().equals("SewingFactory")) {
                return PriceToBuySewingFactoryLevel0 + 500 * (((WorkShop) object).getLevel());
            } else if (object.toString().equals("Spinnery")) {
                return PriceToBuySpinneryLevel0 + 500 * (((WorkShop) object).getLevel());
            } else if (object.toString().equals("UnknownWorkShop")) {
                return PriceToBuyUnknownWorkShopLevel0;
            } else if (object.toString().equals("WeavingFactory")) {
                return PriceToBuyWeavingFactoryLevel0 + 500 * (((WorkShop) object).getLevel());
            } else if (object.toString().equals("CakeBakery")) {
                return PriceToBuyCakeBakeryLevel0 + 100 * (((WorkShop) object).getLevel());
            } else if (object.toString().equals("CookieBakery")) {
                return PriceToBuyCookieBakeryLevel0 + 100 * (((WorkShop) object).getLevel());
            }
        }
        return -1;
    }


    //PriceForSellAnimalProduct
    private final static int PriceForSellEgg = 10;
    private final static int PriceForSellMilk = 1000;
    private final static int PriceForSellWool = 100;
    //PriceForSellWorkShopProduct
    private final static int PriceForSellCake = 100;
    private final static int PriceForSellCookie = 100; // random
    private final static int PriceForSellPowder = 150; // random
    private final static int PriceForSellSewing = 150;
    private final static int PriceForSellFlour = 10;
    private final static int PriceForSellCloth = 50; // random
    private final static int PriceForSellDecoration = 40; // random
    private final static int PriceForSellFabric = 300;
    //priceForSellCage
    private final static int PriceForSellCageLion = 150;
    private final static int PriceForSellCageBear = 100;


    public int getPriceForSell(Object object) throws UnknownObjectException {
        if (object.toString().equals("Wool")) {
            return PriceForSellWool;
        } else if (object.toString().equals("Milk")) {
            return PriceForSellMilk;
        } else if (object.toString().equals("Egg")) {
            return PriceForSellEgg;
        } else if (object.toString().equals("FlouryCake")) {
            return PriceForSellCake;
        } else if (object.toString().equals("Cake")) {
            return PriceForSellCookie;
        } else if (object.toString().equals("Flour")) {
            return PriceForSellFlour;
        } else if (object.toString().equals("Powder")) {
            return PriceForSellPowder;
        } else if (object.toString().equals("CarnivalDress")) {
            return PriceForSellCloth;
        } else if (object.toString().equals("Decoration")) {
            return PriceForSellDecoration;
        } else if (object.toString().equals("Fabric")) {
            return PriceForSellFabric;
        } else if (object.toString().equals("Sewing")) {
            return PriceForSellSewing;
        } else if (object.toString().equals("Cage")) {
            WildAnimals wildAnimals = ((Cage) object).getWildAnimals();
            if (wildAnimals.toString().equals("Lion")) {
                return PriceForSellCageLion;
            } else if (wildAnimals.toString().equals("Bear")) {
                return PriceForSellCageBear;
            }
        }
        throw new UnknownObjectException();
    }


}
