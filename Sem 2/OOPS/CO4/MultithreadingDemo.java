public class MultithreadingDemo {

    static class FibonacciThread implements Runnable {
        private int count;

        FibonacciThread(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            System.out.println("[Fibonacci Thread] Started");
            int a = 0, b = 1;
            System.out.print("[Fibonacci]    : ");
            for (int i = 0; i < count; i++) {
                System.out.print(a + " ");
                int temp = a + b;
                a = b;
                b = temp;
                try {
                    Thread.sleep(200); // pause 200ms
                } catch (InterruptedException e) {
                    System.out.println("\n[Fibonacci] Interrupted!");
                }
            }
            System.out.println("\n[Fibonacci Thread] Finished");
        }
    }

    static class EvenNumberThread implements Runnable {
        private int limit;

        EvenNumberThread(int limit) {
            this.limit = limit;
        }

        @Override
        public void run() {
            System.out.println("[Even Thread] Started");
            System.out.print("[Even Numbers] : ");
            for (int i = 2; i <= limit; i += 2) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(300); // pause 300ms
                } catch (InterruptedException e) {
                    System.out.println("\n[Even Thread] Interrupted!");
                }
            }
            System.out.println("\n[Even Thread] Finished");
        }
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("========= MULTITHREADING DEMO =========");
        System.out.println("Main Thread started.\n");

        // Create Runnable objects
        FibonacciThread  fibRunnable  = new FibonacciThread(10);
        EvenNumberThread evenRunnable = new EvenNumberThread(20);

        // Create Thread objects wrapping Runnable
        Thread fibThread  = new Thread(fibRunnable,  "FibThread");
        Thread evenThread = new Thread(evenRunnable, "EvenThread");

        // Start both threads
        fibThread.start();
        evenThread.start();

        // Main thread waits for both to finish
        fibThread.join();
        evenThread.join();

        System.out.println("\nBoth threads completed.");
        System.out.println("Main Thread finished.");
    }
}
