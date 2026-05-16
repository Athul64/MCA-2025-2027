import java.util.Scanner;

public class EmployeeSearch {

    int    eNo;
    String eName;
    double eSalary;

    EmployeeSearch(int eNo, String eName, double eSalary) {
        this.eNo     = eNo;
        this.eName   = eName;
        this.eSalary = eSalary;
    }

    void display() {
        System.out.println("  Employee No   : " + eNo);
        System.out.println("  Employee Name : " + eName);
        System.out.println("  Salary        : Rs." + eSalary);
        System.out.println("  " + "-".repeat(30));
    }

    static int linearSearch(EmployeeSearch[] emp, int searchNo) {
        for (int i = 0; i < emp.length; i++) {
            if (emp[i].eNo == searchNo) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        EmployeeSearch[] employees = new EmployeeSearch[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("  Employee No   : ");
            int no = sc.nextInt();
            sc.nextLine();
            System.out.print("  Employee Name : ");
            String name = sc.nextLine();
            System.out.print("  Salary        : ");
            double sal = sc.nextDouble();
            employees[i] = new EmployeeSearch(no, name, sal);
        }

        System.out.println("\n===== All Employees =====");
        for (EmployeeSearch e : employees) {
            e.display();
        }

        while (true) {
            System.out.print("\nEnter Employee Number to search (0 to exit): ");
            int searchNo = sc.nextInt();

            if (searchNo == 0) {
                System.out.println("Exiting search.");
                break;
            }

            int index = linearSearch(employees, searchNo);

            if (index != -1) {
                System.out.println("\nEmployee Found:");
                employees[index].display();
            } else {
                System.out.println("Employee with No " + searchNo + " not found.");
            }
        }

        sc.close();
    }
}
