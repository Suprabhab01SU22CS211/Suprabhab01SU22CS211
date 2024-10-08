import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMInterface {
    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    checkBalance(scanner);
                    break;
                case 5:
                    System.out.println("Exiting ATM. Thank you!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createAccount(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        accounts.put(name, initialBalance);
        System.out.println("Account created successfully!");
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        if (accounts.containsKey(name)) {
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();

            double currentBalance = accounts.get(name);
            accounts.put(name, currentBalance + depositAmount);

            System.out.println("Deposit successful. New balance: " + accounts.get(name));
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        if (accounts.containsKey(name)) {
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();

            double currentBalance = accounts.get(name);

            if (withdrawalAmount <= currentBalance) {
                accounts.put(name, currentBalance - withdrawalAmount);
                System.out.println("Withdrawal successful. New balance: " + accounts.get(name));
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.next();

        if (accounts.containsKey(name)) {
            System.out.println("Your current balance is: " + accounts.get(name));
        } else {
            System.out.println("Account not found. Please create an account first.");
        }
    }
}
