package fruit;

public class PerUnitFruit extends Fruit{
    private int count;
    public PerUnitFruit(double price, String name, int count) {
        super(price, name);
        this.count = count;
    }
    @Override
    public double price() {
        return price * count;
    }
    @Override
    public String toString() {
        return name + ": "+price + " * " + count + " = " + price();
    }
}
