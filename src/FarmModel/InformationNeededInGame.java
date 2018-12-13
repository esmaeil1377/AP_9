package FarmModel;

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
    public int SpaceNeededInWareHouseForCageThatLionIsInIt= 20;
    public int SpaceNeededInWareHouseForCageThatBearIsInIt=20;
    public int SpaceNeededInWareHouseForEgg=1;
    public int SpaceNeededInWareHouseForWool=5;
    public int SpaceNeededInWareHouseForMilk=10;
    public int SpaceNeededInWareHouseForCake=5;
    public int SpaceNeededInWareHouseForPowder=;
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


        //.....
    }

    public static int GetData(String strDataName) {
        return informationAndNumber.get(strDataName);
    }

    public static void SetData(String strDataName, int newSize) {
        informationAndNumber.put(strDataName, newSize);
    }
}
