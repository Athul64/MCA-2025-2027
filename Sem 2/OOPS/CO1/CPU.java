
public class CPU {

    double price;

    CPU(double price) {
        this.price = price;
    }

    class Processor {
        int    numberOfCores;
        String manufacturer;

        Processor(int numberOfCores, String manufacturer) {
            this.numberOfCores = numberOfCores;
            this.manufacturer  = manufacturer;
        }

        void displayProcessor() {
            System.out.println("--- Processor Info ---");
            System.out.println("  Cores        : " + numberOfCores);
            System.out.println("  Manufacturer : " + manufacturer);
            System.out.println("  CPU Price    : Rs." + price); // outer field
        }
    }

    static class RAM {
        int    memory;       
        String manufacturer;

        RAM(int memory, String manufacturer) {
            this.memory       = memory;
            this.manufacturer = manufacturer;
        }

        void displayRAM() {
            System.out.println("--- RAM Info ---");
            System.out.println("  Memory       : " + memory + " GB");
            System.out.println("  Manufacturer : " + manufacturer);
        }
    }

    public static void main(String[] args) {

        CPU myCPU = new CPU(75000.00);
        System.out.println("CPU Price    : Rs." + myCPU.price);
        System.out.println();

        CPU.Processor proc = myCPU.new Processor(8, "Intel");
        proc.displayProcessor();
        System.out.println();

        CPU.RAM ram = new CPU.RAM(16, "Samsung");
        ram.displayRAM();
    }
}
