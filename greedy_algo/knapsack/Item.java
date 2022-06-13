package knapsack;
//NOT written by me, but used as a 'dependency'
public class Item implements Comparable<Item> {
    private final String name;
    private final int weight;
    private final int value;

    /**
     * Creates a new item.
     * 
     * @param name The name of the new item.
     * @param weight The weight of the new item.
     * @param value The value of the new item.
     */
    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    /**
     * Compares two items based on weight. Items with a lower weight are
     * considered to come first in natural order.
     * 
     * @param other The item to which this item is being compared.
     * @return An integer that is <0 if this item comes first in natural order,
     * 0 if both items are equal, and >0 if this item comes last.
     */
    @Override
    public int compareTo(Item other) {
        return this.weight - other.weight;
    }

    @Override
    public String toString() {
        return name + "(" + weight + "lbs, $" + value + ")";
    }

}
