package greedy_algo;

import java.util.ArrayList;
import java.util.List;

import knapsack.Item;
import knapsack.ItemSets;
import knapsack.Knapsack;
import knapsack.ValueComparator;

public class Greedy {
    public static List<Currency> makeChange(double price, double payment) {
        //make initial double of payment
        //declare double price set to 0.
        //ensure the dollar amount paid is equal to or higher than the price

        //if the price is higher than amount paid, reprompt
        //if its equal return the currency used
        //if its above use an alg to make change
            //change = payment - price;
            //while change > 0:
            //count = change / DOLLAR
            //add count DOLLARS to change_list
                //change = change - count * DOLLAR
                //repeat for each successive denomination
        //return change_list
        List<Currency> change_list = new ArrayList<>();
        int count = 0;
        double change = payment - price;
        Currency[] money = {Currency.DOLLAR, Currency.QUARTER, Currency.DIME, Currency.NICKEL, Currency.PENNY};
        int index = 0;
        while(change>0) {
            //0.005 comes from being half of a penny, or half of the lowest integer.
            //this will correct nautral rounding errors that occur with casting doubles to ints.
            count = (int)(change / money[index].getValue()+ 0.005); //0.005 will correct rounding errors,would also
            //work with a tenth, or a hundredth, etc
            for(int i =0; i<count;i++) {
                change_list.add(money[index]);
                change = change - money[index].getValue();
            }
            index++;
        }

        return change_list;
    }

    public static void packItems(Knapsack sack, List<Item> items) {
        
        //sort list by value
        // loop over the list
        //if item will fit in the knapsack:
        //  add to knapsack
        // remove item from list

        items.sort(new ValueComparator());
        while(!(items.isEmpty())){
            sack.pack(items.get(0));
            items.remove(0);

        }
        
    }
    public static void main(String[] args) {
        System.out.println(makeChange(2.74, 5.00));
        Knapsack knapsack = new Knapsack(10);
        packItems(knapsack, ItemSets.sportsSet());
        System.out.println(knapsack);
    }
}
