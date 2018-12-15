package FarmModel;

import FarmController.Exceptions.NotDefinedPriceForUpgrade;
import FarmController.Exceptions.NotDefinedSpaceForObject;
import FarmController.Exceptions.UnknownObjectToGetSellPrice;
import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;

public class InformationNeededInGame {
    private static InformationNeededInGame informationNeededInGame = new InformationNeededInGame();

    private InformationNeededInGame() {
    }

    public static InformationNeededInGame getInformationNeededInGame() {
        return informationNeededInGame;
    }

    //well information
    public int CapacityOfTheBucket = 5;
    public int PriceToFillTheBucket = 19;


    //ActivationPrices
    public int ActivationPriceForUpgradeWareHouse = ;
    public int intActivationPriceForUpgradeWorkShop = ;
    public int ActivationPriceForHelicopter = ;
    public int ActivationPriceForTruck = ;
    public int ActivationPriceForCustomWorkShop = ;


    public void IncraesePriceForUpgrade(String str) {
        if (str.equals("CakeBakery")) {
            PriceToUpgradeCakeBakery +=;
        } else if (str.equals("EggPowderPlant")) {
            PriceToUpgradeEggPowderPlant +=;
        } else if (str.equals("CookieBakery")) {
            PriceToUpgradeCookieBakery +=;
        } else if (str.equals("SewingFactory")) {
            PriceToUpgradeSewingFactory +=;
        } else if (str.equals("Spinnery")) {
            PriceToUpgradeSpinnery +=;
        } else if (str.equals("WeavingFactory")) {
            PriceToUpgradeWeavingFactory +=;
        } else if (str.equals("Well")) {
            PriceToUpgradeWell +=;
        } else if (str.equals("WareHouse")) {
            PriceToUpgradeWareHouse +=;
        } else if (str.equals("CustomWorkShop")) {
            PriceToUpgradeUnknownWorkShop +=;
        }
        throw new NotDefinedPriceForUpgrade();
    }

    //PriceToBuyProduct

    //SpaceNeededInWareHouseForObject
    public int SpaceNeededInWareHouseForCageThatLionIsInIt = 20;
    public int SpaceNeededInWareHouseForCageThatBearIsInIt = 20;
    public int SpaceNeededInWareHouseForEgg = 1;
    public int SpaceNeededInWareHouseForWool = 5;
    public int SpaceNeededInWareHouseForMilk = 10;
    public int SpaceNeededInWareHouseForCake = 5;
    public int SpaceNeededInWareHouseForPowder = ;
    public int SpaceNeededInWareHouseForFlour = ;
    public int SpaceNeededInWareHouseForFibre = ;
    public int SpaceNeededInWareHouseForSewing = ;
    public int SpaceNeededInWareHouseForDecoration = ;
    public int SpaceNeededInWareHouseForCloth = ;
    public int SpaceNeededInWareHouseForCookie = ;

    //PriceToUpgradeCat
    public int PriceToUpgradeCatLevel1 = ;
    //PriceToBuyWorkShop

    //PriceToUpgradeWorkShop
    public int PriceToUpgradeCakeBakery = ;
    public int PriceToUpgradeCookieBakery = ;
    public int PriceToUpgradeEggPowderPlant = ;
    public int PriceToUpgradeSewingFactory =
    public int PriceToUpgradeSpinnery = ;
    public int PriceToUpgradeUnknownWorkShop = ;
    public int PriceToUpgradeWeavingFactory = ;
    //PriceToUpgradeWell
    public int PriceToUpgradeWell = ;
    //PriceToUpgradeWareHouse
    public int PriceToUpgradeWareHouse = ;

    public int getSpaceNeededInWareHouse(Object object) {
        if (object.toString().equals("Cage")) {
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
        else if (object.toString().equals("Cake"))
            return SpaceNeededInWareHouseForCake;
        else if (object.toString().equals("Powder"))
            return SpaceNeededInWareHouseForPowder;
        else if (object.toString().equals("Flour"))
            return SpaceNeededInWareHouseForFlour;
        else if (object.toString().equals("Fiber"))
            return SpaceNeededInWareHouseForFibre;
        else if (object.toString().equals("Sewing"))
            return SpaceNeededInWareHouseForSewing;
        else if (object.toString().equals("Decoration"))
            return SpaceNeededInWareHouseForDecoration;
        else if (object.toString().equals("Cloth"))
            return SpaceNeededInWareHouseForCloth;
        else if (object.toString().equals("Cookie"))
            return SpaceNeededInWareHouseForCookie;
        throw new NotDefinedSpaceForObject();
    }

    public int getPriceForUpgrade(Object object) {
        if (object.toString().equals("CakeBakery"))
            return PriceToUpgradeCakeBakery;
        if (object.toString().equals("EggPowderPlant"))
            return PriceToUpgradeEggPowderPlant;
        if (object.toString().equals("CookieBakery"))
            return PriceToUpgradeCookieBakery;
        if (object.toString().equals("SewingFactory"))
            return PriceToUpgradeSewingFactory;
        if (object.toString().equals("Spinnery"))
            return PriceToUpgradeSpinnery;
        if (object.toString().equals("WeavingFactory"))
            return PriceToUpgradeWeavingFactory;
        if (object.toString().equals("Well"))
            return PriceToUpgradeWell;
        if (object.toString().equals("WareHouse"))
            return PriceToUpgradeWareHouse;
        if (object.toString().equals("CustomWorkShop"))
            return PriceToUpgradeUnknownWorkShop;
        throw new NotDefinedPriceForUpgrade();
    }


    public int PriceToBuyChicken = 100;
    public int PriceToBuyShip = 1000;
    public int PriceToBuyCow = 10000;

    public int PriceToBuyCat = 2500;
    public int PriceToBuyDog = 2600;

    public int PriceToBuyEggPowderPlant = ;
    public int PriceToBuySewingFactory = ;
    public int PriceToBuySpinnery = ;
    public int PriceToBuyUnknownWorkShop = ;
    public int PriceToBuyWeavingFactory = ;
    public int PriceToBuyCakeBakery = ;
    public int PriceToBuyCookieBakery = ;

    public int PriceTOBuyWool = 200;
    public int PriceToBuyEgg = 20;
    public int PriceToBuyMilk = 2000;

    public int getPriceToBuy(Object object) {
        if (object.toString().equals("Chicken")) {
            return PriceToBuyChicken;
        } else if (object.toString().equals("Cow")) {
            return PriceToBuyCow;
        } else if (object.toString().equals("Ship")) {
            return PriceToBuyShip;
        } else if (object.toString().equals("Cat")) {
            return PriceToBuyCat;
        } else if (object.toString().equals("Dog")) {
            return PriceToBuyDog;
        } else if (object.toString().equals("EggPowderPlant")) {
            return PriceToBuyEggPowderPlant;
        } else if (object.toString().equals("SewingFactory")) {
            return PriceToBuySewingFactory;
        } else if (object.toString().equals("Spinnery")) {
            return PriceToBuySpinnery;
        } else if (object.toString().equals("UnknownWorkShop")) {
            return PriceToBuyUnknownWorkShop;
        } else if (object.toString().equals("WeavingFactory")) {
            return PriceToBuyWeavingFactory;
        } else if (object.toString().equals("CakeBakery")) {
            return PriceToBuyCakeBakery;
        } else if (object.toString().equals("CookieBakery")) {
            return PriceToBuyCookieBakery;
        } else if (object.toString().equals("Egg")) {
            return PriceToBuyEgg;
        } else if (object.toString().equals("Wool")) {
            return PriceTOBuyWool;
        } else if (object.toString().equals("Milk")) {
            return PriceToBuyMilk;
        }

    }


    //PriceForSellAnimalProduct
    public int PriceForSellEgg = 10;
    public int PriceForSellMilk = 1000;
    public int PriceForSellWool = 100;
    //PriceForSellWorkShopProduct
    public int PriceForSellCake = 100;
    public int PriceForSellCookie = ;
    public int PriceForSellPowder = ;
    public int PriceForSellSewing = 150;
    //priceForSellCage
    public int PriceForSellCageLion = 150;
    public int PriceForSellCageBear = ;
    public int PriceForSellChicken = ;
    public int PriceForSellCow = ;
    public int PriceForSellShip = ;
    public int PriceForSellFlour = ;
    public int PriceForSellCloth = ;
    public int PriceForSellDecoration = ;
    public int PriceForSellFibre = ;

    public int getPriceForSell(Object object) {
        if (object.toString().equals("Chicken")) {
            return PriceForSellChicken;
        } else if (object.toString().equals("Cow")) {
            return PriceForSellCow;
        } else if (object.toString().equals("Ship")) {
            return PriceForSellShip;
        } else if (object.toString().equals("Wool")) {
            return PriceForSellWool;
        } else if (object.toString().equals("Milk")) {
            return PriceForSellMilk;
        } else if (object.toString().equals("Egg")) {
            return PriceForSellEgg;
        } else if (object.toString().equals("Cake")) {
            return PriceForSellCake;
        } else if (object.toString().equals("Cookie")) {
            return PriceForSellCookie;
        } else if (object.toString().equals("Flour")) {
            return PriceForSellFlour;
        } else if (object.toString().equals("Powder")) {
            return PriceForSellPowder;
        } else if (object.toString().equals("Cloth")) {
            return PriceForSellCloth;
        } else if (object.toString().equals("Decoration")) {
            return PriceForSellDecoration;
        } else if (object.toString().equals("Fibre")) {
            return PriceForSellFibre;
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
        throw new UnknownObjectToGetSellPrice();
    }


}
