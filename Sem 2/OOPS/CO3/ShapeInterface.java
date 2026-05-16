import java.util.Scanner;

interface Shape {
    double area();       // public abstract by default
    double perimeter();  // public abstract by default
    double PI = 3.14159265358979; // public static final by default
}

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle [radius = " + radius + "]";
    }
}

class Rectangle implements Shape {
    double length, breadth;

    Rectangle(double length, double breadth) {
        this.length  = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return length * breadth;
    }

    @Override
    public double perimeter() {
        return 2 * (length + breadth);
    }

    @Override
    public String toString() {
        return "Rectangle [length = " + length + ", breadth = " + breadth + "]";
    }
}

public class ShapeInterface {

    static void showMenu() {
        System.out.println("\n======= SHAPE CALCULATOR MENU =======");
        System.out.println("  1. Circle  - Area and Perimeter");
        System.out.println("  2. Rectangle - Area and Perimeter");
        System.out.println("  3. Both Shapes (Polymorphism Demo)");
        System.out.println("  4. Exit");
        System.out.println("=====================================");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();
                    Circle c = new Circle(r);
                    System.out.println("\nShape     : " + c);
                    System.out.printf("Area      : %.4f%n", c.area());
                    System.out.printf("Perimeter : %.4f%n", c.perimeter());
                    break;

                case 2:
                    System.out.print("Enter length : ");
                    double l = sc.nextDouble();
                    System.out.print("Enter breadth: ");
                    double b = sc.nextDouble();
                    Rectangle rect = new Rectangle(l, b);
                    System.out.println("\nShape     : " + rect);
                    System.out.printf("Area      : %.4f%n", rect.area());
                    System.out.printf("Perimeter : %.4f%n", rect.perimeter());
                    break;

                case 3:
                    // Runtime Polymorphism — interface reference array
                    System.out.print("Enter radius         : ");
                    double rad = sc.nextDouble();
                    System.out.print("Enter length         : ");
                    double len = sc.nextDouble();
                    System.out.print("Enter breadth        : ");
                    double bre = sc.nextDouble();

                    Shape[] shapes = new Shape[2];
                    shapes[0] = new Circle(rad);
                    shapes[1] = new Rectangle(len, bre);

                    System.out.println("\n--- Polymorphism Demo ---");
                    for (Shape s : shapes) {
                        System.out.println("\nShape     : " + s);
                        System.out.printf("Area      : %.4f%n", s.area());
                        System.out.printf("Perimeter : %.4f%n", s.perimeter());
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Enter 1-4.");
            }

        } while (choice != 4);

        sc.close();
    }
}
