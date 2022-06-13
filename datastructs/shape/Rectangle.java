package shape; 

public class Rectangle implements Shape{
    private String name;private Double height;private Double width;
    public Rectangle(Double height, Double width){
        name = "Rectangle";this.height = height;this.width=width;
    }
    @Override
    public String name() {
        return name;
    }

    @Override
    public Double area() {
        return height * width;
    }

    @Override
    public Double perimeter() {
        return (2*height) + (2*width);
    }
    
}
