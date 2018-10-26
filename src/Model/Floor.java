package Model;

import java.util.ArrayList;

public class Floor {
   public static ArrayList<Unit> ArrayListunits=new ArrayList<>();

   public static void setArrayListunits(ArrayList<Unit> arrayListunits) {
      ArrayListunits = arrayListunits;
   }

   public static ArrayList<Unit> getArrayListunits() {
      return ArrayListunits;
   }

   public void AddUnitArrayList(Unit unit){
      ArrayListunits.add(unit);
   }

   public void RemoveArrayList(Unit unit){
      ArrayListunits.remove(unit);
   }
}
