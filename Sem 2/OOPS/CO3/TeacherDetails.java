import java.util.Scanner;
class Person {
    String name;
    int    age;

    Person(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    void displayPerson() {
        System.out.println("  Name          : " + name);
        System.out.println("  Age           : " + age);
    }
}

class Employee extends Person {
    int    empId;
    double salary;

    Employee(String name, int age, int empId, double salary) {
        super(name, age); // calls Person constructor — MUST be first
        this.empId  = empId;
        this.salary = salary;
    }

    void displayEmployee() {
        displayPerson();
        System.out.println("  Employee ID   : " + empId);
        System.out.println("  Salary        : Rs." + salary);
    }
}

class Teacher extends Employee {
    String subject;
    String department;

    Teacher(String name, int age, int empId,
            double salary, String subject, String department) {
        super(name, age, empId, salary); // calls Employee constructor
        this.subject    = subject;
        this.department = department;
    }

    void displayTeacher() {
        displayEmployee();
        System.out.println("  Subject       : " + subject);
        System.out.println("  Department    : " + department);
        System.out.println("  " + "-".repeat(32));
    }
}

public class TeacherDetails {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine();

        Teacher[] teachers = new Teacher[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for Teacher " + (i + 1) + " ---");
            System.out.print("  Name        : "); String name = sc.nextLine();
            System.out.print("  Age         : "); int age = sc.nextInt(); sc.nextLine();
            System.out.print("  Employee ID : "); int id = sc.nextInt();  sc.nextLine();
            System.out.print("  Salary      : "); double sal = sc.nextDouble(); sc.nextLine();
            System.out.print("  Subject     : "); String sub  = sc.nextLine();
            System.out.print("  Department  : "); String dept = sc.nextLine();

            teachers[i] = new Teacher(name, age, id, sal, sub, dept);
        }

        System.out.println("\n========== Teacher Details ==========");
        for (Teacher t : teachers) {
            t.displayTeacher();
        }

        sc.close();
    }
}
