package FarmModel;

import java.util.HashMap;

public class InformationNeededInGame {
    private static InformationNeededInGame informationNeededInGame = new InformationNeededInGame();
    private static HashMap<String, Integer> informationAndNumber = new HashMap<>();

    private InformationNeededInGame() {
        informationAndNumber.put("ActivationPriceForUpgradeWareHouse", );
        informationAndNumber.put("ActivationPriceForUpgradeWorkShop", );
        informationAndNumber.put("ActivationPriceForHelicopter", );
        informationAndNumber.put("ActivationPriceForTruck", );
        informationAndNumber.put("ActivationPriceForHelicopter", );
        informationAndNumber.put("ActivationPriceForHelicopter", );
        informationAndNumber.put("ActivationPriceForHelicopter", );
        informationAndNumber.put("ActivationPriceForCustomWorkShop", );
        //SpaceNeededInWareHouseForObject
        informationAndNumber.put("SpaceNeededInWareHouseForCage", );
        informationAndNumber.put("SpaceNeededInWareHouseForEgg", );
        informationAndNumber.put("SpaceNeededInWareHouseForWool", );
        informationAndNumber.put("SpaceNeededInWareHouseForMilk", );
        informationAndNumber.put("SpaceNeededInWareHouseForCake", );
        //PriceForSellAnimalProduct
        informationAndNumber.put("PriceForSellEgg", );
        informationAndNumber.put("PriceForSellMilk", );
        informationAndNumber.put("PriceForSellWool", );
        //PriceToBuyAnimal
        informationAndNumber.put("PriceToBuyChicken", );
        informationAndNumber.put("PriceToBuyShip", );
        informationAndNumber.put("PriceToBuyCow", );
        informationAndNumber.put("PriceToBuyCat", );
        informationAndNumber.put("PriceToBuyDog", );
        //PriceToUpgradeCat
        informationAndNumber.put("PriceToUpgradeCat", );
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

    public static InformationNeededInGame getDataNeededInGameInstance() {
        return informationNeededInGame;
    }

    public static int GetData(String strDataName) {
        return informationAndNumber.get(strDataName);
    }
}
