import java.util.Scanner;

public class ComplexNumber {

    double real;
    double imaginary;

    ComplexNumber(double real, double imaginary) {
        this.real      = real;
        this.imaginary = imaginary;
    }

    ComplexNumber add(ComplexNumber other) {
        double newReal      = this.real      + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    void display() {
        if (imaginary >= 0) {
            System.out.println(real + " + " + imaginary + "i");
        } else {
            System.out.println(real + " - " + Math.abs(imaginary) + "i");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first complex number:");
        System.out.print("  Real part      : ");
        double r1 = sc.nextDouble();
        System.out.print("  Imaginary part : ");
        double i1 = sc.nextDouble();

        System.out.println("Enter second complex number:");
        System.out.print("  Real part      : ");
        double r2 = sc.nextDouble();
        System.out.print("  Imaginary part : ");
        double i2 = sc.nextDouble();

        ComplexNumber c1 = new ComplexNumber(r1, i1);
        ComplexNumber c2 = new ComplexNumber(r2, i2);

        System.out.print("\nFirst  : "); c1.display();
        System.out.print("Second : "); c2.display();

        ComplexNumber sum = c1.add(c2);
        System.out.print("Sum    : "); sum.display();

        sc.close();
    }
}
