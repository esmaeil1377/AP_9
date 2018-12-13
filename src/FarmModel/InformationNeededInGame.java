package FarmModel;

import FarmModel.ObjectInMap15_15.Cage;
import FarmModel.ObjectInMap15_15.LiveAnimals.WildAnimals;

import java.util.HashMap;

public class InformationNeededInGame {
    private static InformationNeededInGame informationNeededInGame = new InformationNeededInGame();
    private static HashMap<String, Integer> informationAndNumber = new HashMap<>();

    //we should change the formation of this class it should be methods.

    //well information
    public int CapacityOfTheBucket= 5;
    public int PriceToFillTheBucket=19;
    //ActivationPrices
    public int ActivationPriceForUpgradeWareHouse=;
    public int intActivationPriceForUpgradeWorkShop= ;
    public int ActivationPriceForHelicopter=;
    public int ActivationPriceForTruck=;
    public int ActivationPriceForCustomWorkShop=;
    //SpaceNeededInWareHouseForObject

    //PriceToBuyProduct
    public int PriceTOBuyWool=200;
    public int PriceToBuyEgg=20;
    public int PriceToBuyMilk=2000;
    public int PriceTOBuyCake=200;
    public int PriceToBuySewing= 300);
    //PriceForSellAnimalProduct
    public int PriceForSellEgg=10;
    public int PriceForSellMilk=1000;
    public int PriceForSellWool = 100;
    public int PriceForSellSewing =150;
    //PriceForSellWorkShopProduct
    public int PriceForSellCake=100;
    public int PriceForSellCookie=;
    public int PriceForSellPowder = ;
    //priceForSellCage
    public int PriceForSellCageLion = 150 ;
    public int PriceForSellCageBear=;
    //PriceToBuyAnimal
    public int PriceToBuyChicken = 100;
    public int PriceToBuyShip = 1000;
    public int  PriceToBuyCow = 10000;
    public int PriceToBuyCat = 2500;
    public int  PriceToBuyDog = 2600;
    //PriceToUpgradeCat
    informationAndNumber.put("PriceToUpgradeCatLevel1", );
    informationAndNumber.put("PriceToUpgradeCatLevel2", );
    informationAndNumber.put("PriceToUpgradeCatLevel3", );
    //PriceToBuyWorkShop
    public int PriceToBuyEggPowderPlant =;
    public int PriceToBuySewingFactory =;
    public int PriceToBuySpinnery = ;
    public int PriceToBuyUnknownWorkShop = ;
    public int PriceToBuyWeavingFactory = ;
    //PriceToUpgradeWorkShop
    public int PriceToUpgradeCakeBakery = ;
    public int PriceToUpgradeCookieBakery =;
    public int PriceToUpgradeEggPowderPlant = ;
    public int PriceToUpgradeSewingFactory =
    public int PriceToUpgradeSpinnery = ;
    public int PriceToUpgradeUnknownWorkShop = ;
    public int PriceToUpgradeWeavingFactory = ;
    //PriceToUpgradeWell
    public int PriceToUpgradeWell = ;
    //PriceToUpgradeWareHouse
    public int PriceToUpgradeWareHouse =;
    //AnimalAmountOfHunger
    public int SpaceNeededInWareHouseForCageThatLionIsInIt= 20;
    public int SpaceNeededInWareHouseForCageThatBearIsInIt=20;
    public int SpaceNeededInWareHouseForEgg=1;
    public int SpaceNeededInWareHouseForWool=5;
    public int SpaceNeededInWareHouseForMilk=10;
    public int SpaceNeededInWareHouseForCake=5;
    public int SpaceNeededInWareHouseForPowder=;
    public int SpaceNeededInWareHouseForFlour=;
    public int SpaceNeededInWareHouseForSewing=;
    public int SpaceNeededInWareHouseForDecoration=;
    public int SpaceNeededInWareHouseForCloth=;
    public int SpaceNeededInWareHouseForFibre=;
    public int SpaceNeededInWareHouseForCookie=;

        //.....
    }

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
public int getPriceForUpgrade(Object object){
    if(object.toString().equals("CakeBakery"))
        return PriceToUpgradeCakeBakery;
    if(object.toString().equals("EggPowderPlant"))
        return PriceToUpgradeEggPowderPlant;
    if(object.toString().equals("CookieBakery"))
        return PriceToUpgradeCookieBakery;
    if(object.toString().equals("SewingFactory"))
        return PriceToUpgradeSewingFactory;
    if(object.toString().equals("Spinnery"))
        return PriceToUpgradeSpinnery;
    if(object.toString().equals("WeavingFactory"))
        return PriceToUpgradeWeavingFactory;
    if(object.toString().equals("Well"))
        return PriceToUpgradeWell;
    if(object.toString().equals("WareHouse"))
        return PriceToUpgradeWareHouse;
    if(object.toString().equals("CustomWorkShop"))
        return PriceToUpgradeUnknownWorkShop;

}
