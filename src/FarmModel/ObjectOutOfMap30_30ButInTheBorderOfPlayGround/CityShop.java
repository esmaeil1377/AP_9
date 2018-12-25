package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround;

import FarmModel.ObjectInMap30_30.ObjectInMap30_30;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.*;

import java.util.ArrayList;

public class CityShop {
    private ArrayList<ObjectInMap30_30> cityOfferingProduct =new ArrayList<>();

    public CityShop(ArrayList<ObjectInMap30_30> cityOfferingProduct){
        this.cityOfferingProduct=cityOfferingProduct;
    }

    public ObjectInMap30_30 getObjectTypeFromCityShop(String className){
        for(ObjectInMap30_30 objectInMap15_15: cityOfferingProduct){
            if(objectInMap15_15.toString().equals(className)){
                if(className.equals("Cake")){
                    return new Cake();
                }
                else if(className.equals("CarnivalDress")){
                    return new CarnivalDress();
                }
                else if(className.equals("Cookie")){
                    return new Cookie();
                }
                else if(className.equals("Decoration")){
                    return new Decoration();
                }
                else if(className.equals("Fabric")){
                    return new Fabric();
                }
                else if(className.equals("Flour")){
                    return new Flour();
                }
                else if(className.equals("Powder")){
                    return new Powder();
                }
                else if(className.equals("Sewing")){
                    return new Sewing();
                }
            }
        }
        return null;
    }

}
