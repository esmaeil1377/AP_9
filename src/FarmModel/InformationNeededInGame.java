package FarmModel;

import java.util.HashMap;

public class InformationNeededInGame {
    private static InformationNeededInGame informationNeededInGame = new InformationNeededInGame();
    private static HashMap<String, Integer> informationAndNumber = new HashMap<>();

    private InformationNeededInGame() {
        //ActivationPrices
        informationAndNumber.put("ActivationPriceForUpgradeWareHouse", );
        informationAndNumber.put("ActivationPriceForUpgradeWorkShop", );
        informationAndNumber.put("ActivationPriceForHelicopter", );
        informationAndNumber.put("ActivationPriceForTruck", );
        informationAndNumber.put("ActivationPriceForCustomWorkShop", );
        //SpaceNeededInWareHouseForObject
        informationAndNumber.put("SpaceNeededInWareHouseForCageThatLionIsInIt", 20);
        informationAndNumber.put("SpaceNeededInWareHouseForCageThatBearIsInIt", 20);
        informationAndNumber.put("SpaceNeededInWareHouseForEgg", 1);
        informationAndNumber.put("SpaceNeededInWareHouseForWool", 5);
        informationAndNumber.put("SpaceNeededInWareHouseForMilk", 10);
        informationAndNumber.put("SpaceNeededInWareHouseForCake", 5);
        informationAndNumber.put("SpaceNeededInWareHouseForPowder", );
        //PriceToBuyProduct
        informationAndNumber.put("PriceTOBuyWool", 200);
        informationAndNumber.put("PriceToBuyEgg", 20);
        informationAndNumber.put("PriceToBuyMilk", 2000);
        informationAndNumber.put("PriceTOBuyCake", 200);
        informationAndNumber.put("PriceToBuySewing", 300);
        //PriceForSellAnimalProduct
        informationAndNumber.put("PriceForSellEgg", 10);
        informationAndNumber.put("PriceForSellMilk", 1000);
        informationAndNumber.put("PriceForSellWool", 100);
        informationAndNumber.put("PriceForSellCake", 100);
        informationAndNumber.put("PriceForSellSewing", 150);
        //PriceToBuyAnimal
        informationAndNumber.put("PriceToBuyChicken", 100);
        informationAndNumber.put("PriceToBuyShip", 1000);
        informationAndNumber.put("PriceToBuyCow", 10000);
        informationAndNumber.put("PriceToBuyCat", 2500);
        informationAndNumber.put("PriceToBuyDog", 2600);
        //PriceToUpgradeCat
        informationAndNumber.put("PriceToUpgradeCatLevel1", );
        informationAndNumber.put("PriceToUpgradeCatLevel2", );
        informationAndNumber.put("PriceToUpgradeCatLevel3", );
        //PriceToBuyWorkShop
        informationAndNumber.put("PriceToBuyCakeBakery", );
        informationAndNumber.put("PriceToBuyCookieBakery", );
        informationAndNumber.put("PriceToBuyEggPowderPlant", );
        informationAndNumber.put("PriceToBuySewingFactory", );
        informationAndNumber.put("PriceToBuySpinnery", );
        informationAndNumber.put("PriceToBuyUnkownWorkShop", );
        informationAndNumber.put("PriceToBuyWeavingFactory", );
        //PriceToUpgradeWorkShop
        informationAndNumber.put("PriceToUpgradeCakeBakery", );
        informationAndNumber.put("PriceToUpgradeCookieBakery", );
        informationAndNumber.put("PriceToUpgradeEggPowderPlant", );
        informationAndNumber.put("PriceToUpgradeSewingFactory", );
        informationAndNumber.put("PriceToUpgradeSpinnery", );
        informationAndNumber.put("PriceToUpgradeUnknownWorkShop", );
        informationAndNumber.put("PriceToUpgradeWeavingFactory", );
        //PriceToUpgradeWell
        informationAndNumber.put("PriceToUpgradeWell", );
        //PriceToUpgradeWareHouse
        informationAndNumber.put("PriceToUpgradeWareHouse", );
        //AnimalAmountOfHunger


        //.....
    }

    public static int GetData(String strDataName) {
        return informationAndNumber.get(strDataName);
    }
}
