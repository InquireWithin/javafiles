package knapsack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//NOT written by me, but used as a 'dependency'
public class ItemSets {

    public static List<Item> sportsSet() {
        // optimal: Baseball, Softball, Tennis Racquet, Golf Clubs ($10)
        List<Item> items = new LinkedList<>();    
        items.add(new Item("Baseball", 1, 1));
        items.add(new Item("Bowling Pin", 2, 2));
        items.add(new Item("Tennis Racquet", 3, 3));
        items.add(new Item("Golf Clubs", 4, 4));
        items.add(new Item("Bowling Ball", 9, 8));
        Collections.shuffle(items);
        return items;
    }

    public static List<Item> electronicsSet() {
        // optimal: Macbook ($5)
        List<Item> items = new LinkedList<>();    
        items.add(new Item("Phone", 2, 1));
        items.add(new Item("Laptop", 2, 1));
        items.add(new Item("Tablet", 2, 1));
        items.add(new Item("Charger", 2, 1));
        items.add(new Item("Macbook", 9, 5));
        Collections.shuffle(items);
        return items;
    }

    public static List<Item> toySet() {
        // optimal: Robot, RC Car ($20)
        List<Item> items = new LinkedList<>();    
        items.add(new Item("Doll", 5, 8));
        items.add(new Item("Robot", 5, 10));
        items.add(new Item("RC Car", 5, 10));
        items.add(new Item("Action Figure", 5, 7));
        items.add(new Item("Potato Head", 5, 9));
        Collections.shuffle(items);
        return items;
    }

    public static List<Item> metalSet() {
        // optimal: Silver Rock, Silver Brick ($90)
        List<Item> items = new LinkedList<>();    
        items.add(new Item("Gold Brick", 7, 70));
        items.add(new Item("Silver Rock", 5, 45));
        items.add(new Item("Silver Brick", 5, 45));
        items.add(new Item("Gold Rock", 6, 59));
        items.add(new Item("Tin", 1, 2));
        Collections.shuffle(items);
        return items;
    }
}
