import java.util.Scanner;


class InvalidUsernameException extends Exception {
    InvalidUsernameException(String message) {
        super(message);
    }
}


class InvalidPasswordException extends Exception {
    InvalidPasswordException(String message) {
        super(message);
    }
}


class Authenticator {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "java@123";

    static void authenticate(String username, String password)
            throws InvalidUsernameException, InvalidPasswordException {

        if (!username.equals(VALID_USERNAME)) {
            throw new InvalidUsernameException(
                "Invalid Username: '" + username + "' does not exist.");
        }

        if (!password.equals(VALID_PASSWORD)) {
            throw new InvalidPasswordException(
                "Invalid Password for user: '" + username + "'.");
        }

        System.out.println("Authentication Successful! Welcome, " + username + "!");
    }
}


public class AuthenticationDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int attempts    = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            attempts++;
            System.out.println("\n--- Login Attempt " + attempts + " of " + maxAttempts + " ---");

            System.out.print("Enter Username : ");
            String username = sc.nextLine();
            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            try {
                Authenticator.authenticate(username, password);
                System.out.println("Access Granted.");
                sc.close();
                return;

            } catch (InvalidUsernameException e) {
                System.out.println("USERNAME ERROR : " + e.getMessage());

            } catch (InvalidPasswordException e) {
                System.out.println("PASSWORD ERROR : " + e.getMessage());

            } finally {
                System.out.println("[finally] Attempt " + attempts + " completed.");
            }

            if (attempts < maxAttempts) {
                System.out.println("Please try again...");
            }
        }

        System.out.println("\nMaximum login attempts reached. Account locked.");
        sc.close();
    }
}
