package graphics;

public class Rectangle {
    private double length, breadth;

    public Rectangle(double length, double breadth) {
        this.length  = length;
        this.breadth = breadth;
    }

    public double area() {
        return length * breadth;
    }

    public void display() {
        System.out.printf("  Rectangle -> l=%.2f, b=%.2f  |  Area = %.4f%n",
                           length, breadth, area());
    }
}
