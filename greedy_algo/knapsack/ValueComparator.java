package knapsack;

import java.util.Comparator;
//Not written by me, but used as a 'dependency'
public class ValueComparator implements Comparator<Item> {
    /**
     * Defines a sort ordering for items based on value; items with a higher
     * value come first. If both items are the same value, they are compared
     * by weight instead - lighter items come first.
     * 
     * @return An integer that is <0 if this item comes first in, 0 if both 
     * items are equal, and >0 if this item comes last.
     */
    @Override
    public int compare(Item o1, Item o2) {
        // note the comparison is done in reverse. If o2=$100 and o1=$50, we
        // want to return a positive number (100 - 50 = 50) so that o1 comes
        // second.
        //
        // if we did it in the other order it would be 50 - 100 = -50, which 
        // would indicate that o1 should come first even though it has the
        // lower value.
        int diff = o2.getValue() - o1.getValue();

        // if the items are worth the same...
        if(diff == 0) {
            // ...choose the lighter of the two; avoid returning 0
            diff = o1.getWeight() <= o2.getWeight() ? -1 : 1;
        }
        return diff;
    }
}
