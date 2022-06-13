package fruit;

public class PerPoundFruit extends Fruit{
    private double weight;
    public PerPoundFruit(double price, String name, double weight) {
        super(price, name);
        this.weight = weight;
    }
    @Override
    public double price() {
        return price * weight;
    }
    @Override
    public String toString() {
        return name + ": "+price + " * " + weight + " = " + price();
    }

    

}
