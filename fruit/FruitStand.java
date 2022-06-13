package fruit;

import java.util.ArrayList;
import java.util.List;
/**
 * Expected Ouput (Your formatting may differ):
 * Banana: 0.49 x 5                         $   2.45
 * Grapes: 2.99 x 1.5lbs                    $   4.49
 * Honey Crisp: 1.49 x 4                    $   5.96
 * Sliced Pineapple: 3.25 x 2.0lbs          $   6.50
 * Total =                                  $  19.40
 */
public class FruitStand {
    public static void main (String[] args) {
        List<Cost> basket = new ArrayList<>(); 
        basket.add (new PerUnitFruit (0.49, "Banana", 5));
        basket.add (new PerPoundFruit (2.99, "Grapes", 1.5));
        basket.add (new PerUnitFruit (1.49, "Honey Crisp", 4));
        basket.add (new PerPoundFruit (3.25, "Sliced Pineapple", 2.0));

        Double total = 0.0;
        for (Cost item : basket) {
            System.out.println (item);
            total += item.price ();
        }
        System.out.println (String.format ("Total = \t\t\t\t $%7.2f", total));
        

    }
}
