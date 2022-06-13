package knapsack;
//not written by me, but used as a 'dependency'
import java.util.HashSet;
import java.util.Set;

public class Knapsack {
    /**
     * Stores the contents of the knapsack. Order is not maintained.
     */
    private final Set<Item> contents;

    /**
     * The maximum weight capacity of the knapsack.
     */
    private final int capacity;

    /**
     * The current load of the knapsack - the combined weight of all items
     * currently packed.
     */
    private int load;

    /**
     * The total value of all items currently packed into the knapsack.
     */
    private int totalValue;

    /**
     * Makes a new knapsack with the specified capacity.
     * 
     * @param capacity The max weight capacity for the knapsack.
     */
    public Knapsack(int capacity) {
        this.capacity = capacity;
        this.contents = new HashSet<>();
        this.load = 0;
        this.totalValue = 0;
    }

    /**
     * Returns the total capacity of the knapsack.
     * 
     * @return The maximum weight that the knapsack can hold.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns the current load in the knapsack.
     * 
     * @return The combined weight of all of the items currently packed in
     * the knapsack.
     */
    public int getLoad() {
        return load;
    }

    /**
     * Returns the total value of all of the items currently packed in the
     * knapsack.
     * 
     * @return The total value of all of the items currently packed in the 
     * knapsack.
     */
    public int getTotalValue() {
        return totalValue;
    }

    /**
     * Attempts to pack an item into the knapsack. If the item is successfully
     * packed, its weight and value are added to the knapsack. If the item's 
     * weight exceeds the knapsack's capacity, it will not be packed.
     *  
     * @param item The item to pack into th eknapsack.
     * 
     * @return True if the item was packed, and false otherwise.
     */
    public boolean pack(Item item) {
        int packed = item.getWeight() + load;
        if(packed > capacity) {
            return false;
        } else {
            load = packed;
            contents.add(item);
            totalValue += item.getValue();
            return true;
        }
    }

    /**
     * Removes the item from the knapsack (if it is packed). The item's weight
     * and value are subtracked from the knapsack.
     * 
     * @param item The item to unpack.
     */
    public void unpack(Item item) {
        if(contents.contains(item)) {
            contents.remove(item);
            load -= item.getWeight();
            totalValue -= item.getValue();
        }
    }

    /**
     * Empties the knapsack. All items are removed and the current load and
     * value are set to 0.
     */
    public void empty() {
        contents.clear();
        this.load = 0;
        this.totalValue = 0;
    }

    @Override
    public String toString() {
        return "Knapsack{" 
            + "capcity=" + this.capacity
            + ", load=" + this.load
            + ", totalValue=" + this.totalValue
            + ", contents=" + this.contents
            + "}";
    }
    
}
