package info.javateam.kaffee.model;

import java.util.*;

public class KaffeeExperte {

    public List<String> getTypes(String taste) {
        List<String> result = new ArrayList<String>();
        if (taste.equals("milky")) {
            result.add("Latte Macciato");
            result.add("Cappuccino");
        } else if (taste.equals("froffy")) {
            result.add("Latte Macciato");
            result.add("Cappuccino");
            result.add("Frappuccino");
        } else if (taste.equals("normal")) {
        	result.add("Kaffee Lungo");
        } else if (taste.equals("boring")) {
        	result.add("Koffeinfreier Kaffee");        
        } else if (taste.equals("icey")) {
            result.add("Frappuccino");
        } else if (taste.equals("strong")) {
            result.add("Espresso");
            result.add("Doppelter Espresso");
        } else {
            result.add("Kaufen Sie sich eine Kaffeemaschine !");
        }
        return (result);
    }
	
	
}
