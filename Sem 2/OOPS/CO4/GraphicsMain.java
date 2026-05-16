import graphics.Circle;
import graphics.Rectangle;
import graphics.Square;
import graphics.Triangle;
import java.util.Scanner;

public class GraphicsMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========= GRAPHICS PACKAGE DEMO =========");

        System.out.print("\nEnter radius of Circle       : ");
        double r = sc.nextDouble();
        Circle circle = new Circle(r);

        System.out.print("Enter length of Rectangle    : ");
        double l = sc.nextDouble();
        System.out.print("Enter breadth of Rectangle   : ");
        double b = sc.nextDouble();
        Rectangle rect = new Rectangle(l, b);

        System.out.print("Enter base of Triangle       : ");
        double base = sc.nextDouble();
        System.out.print("Enter height of Triangle     : ");
        double height = sc.nextDouble();
        Triangle tri = new Triangle(base, height);

        System.out.print("Enter side of Square         : ");
        double side = sc.nextDouble();
        Square sq = new Square(side);

        System.out.println("\n========= AREA OF FIGURES =========");
        circle.display();
        rect.display();
        tri.display();
        sq.display();

        sc.close();
    }
}
