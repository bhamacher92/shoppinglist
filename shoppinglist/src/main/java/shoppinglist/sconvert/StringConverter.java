package shoppinglist.sconvert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import shoppinglist.lmerge.ListElement;
import shoppinglist.lmerge.Quantity;
import shoppinglist.lmerge.UnitFactory;

public class StringConverter {

    static public ListElement string2ListElement(String text) {

        try {
            String knownUnits = "kg|mg|g|ml|L";
            Pattern pattern = Pattern.compile("([0-9]*[.,]{0,1}[0-9]*)\\s*("+knownUnits+"){0,1}\\s*(.*)");
            Matcher matcher = pattern.matcher(text);
            Boolean found = matcher.find();
            if (found) {
                String quantityStr = matcher.group(1);
                String unitStr = matcher.group(2);
                String name = matcher.group(3);
                ListElement result = new ListElement(name);
                if (quantityStr != "") {
                    result.Quantity = new Quantity(Double.parseDouble(quantityStr));
                    if (unitStr != null) {
                        UnitFactory unitFactory = new UnitFactory();
                        result.Quantity.mUnit = unitFactory.createFromString(unitStr);
                    }
                }
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ListElement(text);
        }
        return new ListElement(text);
    }

    static public String listELement2String(ListElement element){

        String quantityStr;
        if(element.Quantity.Value % 1 == 0){
            quantityStr = ((int)element.Quantity.Value)+"";
        }else{
            quantityStr = element.Quantity.Value+"";
        }

        
        String unitStr = element.Quantity.mUnit.Name;
        String name = element.Name;
        String result=new String();
        if(quantityStr != ""){
            result=result+quantityStr+" ";
        }
        if(unitStr != ""){
            result=result+unitStr+" ";
        }
        if(name != ""){
            result=result+name;
        }
        return result;
    }

}
