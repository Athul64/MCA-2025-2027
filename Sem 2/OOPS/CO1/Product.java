import java.util.Scanner;

public class Product {

    int    pcode;
    String pname;
    double price;

    Product(int pcode, String pname, double price) {
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
    }

    void display() {
        System.out.println("  Product Code : " + pcode);
        System.out.println("  Product Name : " + pname);
        System.out.println("  Price        : Rs." + price);
        System.out.println("  " + "-".repeat(30));
    }

    static Product findLowest(Product[] products) {
        Product lowest = products[0];
        for (int i = 1; i < products.length; i++) {
            if (products[i].price < lowest.price) {
                lowest = products[i];
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Product " + (i + 1) + ":");
            System.out.print("  Product Code  : ");
            int code = sc.nextInt();
            sc.nextLine();
            System.out.print("  Product Name  : ");
            String name = sc.nextLine();
            System.out.print("  Price         : ");
            double pr = sc.nextDouble();
            products[i] = new Product(code, name, pr);
        }

        System.out.println("\n===== All Products =====");
        for (Product p : products) {
            p.display();
        }

        Product lowest = findLowest(products);
        System.out.println("===== Product with Lowest Price =====");
        lowest.display();

        sc.close();
    }
}
