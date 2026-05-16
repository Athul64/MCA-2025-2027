
package graphics;

public class Triangle {
    private double base, height;

    public Triangle(double base, double height) {
        this.base   = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }

    public void display() {
        System.out.printf("  Triangle  -> base=%.2f, height=%.2f  |  Area = %.4f%n",
                           base, height, area());
    }
}
