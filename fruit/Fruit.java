package fruit;

public abstract class Fruit implements Cost{
    double price;
    String name;
    public Fruit(double price,String name ){
        this.price = price;
        this.name =name;
    }
    @Override
    public double price() {
        return price;
    }
}
