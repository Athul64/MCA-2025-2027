package graphics;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public void display() {
        System.out.printf("  Circle    -> radius = %.2f  |  Area = %.4f%n",
                           radius, area());
    }
}
