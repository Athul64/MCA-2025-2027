import java.util.Scanner;

public class ShapeArea {

    double area(double radius) {
        return Math.PI * radius * radius;
    }

    double area(double length, double breadth) {
        return length * breadth;
    }

    double area(int side) {
        return side * side;
    }

    double area(double base, double height, String shape) {
        return 0.5 * base * height;
    }

    double area(double a, double b, double c) {
        double s = (a + b + c) / 2.0; // semi-perimeter
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeArea sa = new ShapeArea();

        System.out.println("====== Area Using Method Overloading ======");

        System.out.print("\nEnter radius of Circle     : ");
        double r = sc.nextDouble();
        System.out.printf("Area of Circle             : %.2f%n", sa.area(r));

        System.out.print("Enter length of Rectangle  : ");
        double l = sc.nextDouble();
        System.out.print("Enter breadth of Rectangle : ");
        double b = sc.nextDouble();
        System.out.printf("Area of Rectangle          : %.2f%n", sa.area(l, b));

        System.out.print("Enter side of Square (int) : ");
        int side = sc.nextInt();
        System.out.printf("Area of Square             : %.2f%n", sa.area(side));

        System.out.print("Enter base of Triangle     : ");
        double base = sc.nextDouble();
        System.out.print("Enter height of Triangle   : ");
        double height = sc.nextDouble();
        System.out.printf("Area of Triangle (b,h)     : %.2f%n",
                           sa.area(base, height, "triangle"));

        System.out.print("Enter side1 of Triangle    : ");
        double s1 = sc.nextDouble();
        System.out.print("Enter side2 of Triangle    : ");
        double s2 = sc.nextDouble();
        System.out.print("Enter side3 of Triangle    : ");
        double s3 = sc.nextDouble();
        System.out.printf("Area of Triangle (Heron's) : %.2f%n", sa.area(s1, s2, s3));

        sc.close();
    }
}
