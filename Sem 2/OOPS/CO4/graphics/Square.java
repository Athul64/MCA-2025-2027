
package graphics;

public class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public void display() {
        System.out.printf("  Square    -> side = %.2f  |  Area = %.4f%n",
                           side, area());
    }
}
