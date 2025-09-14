

package ATMSimulation;

import java.util.Scanner;

public class ATMSimulation {
    static final int PIN = 1234;
    static int balance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean authenticated = false;

     
        for (int attempts = 3; attempts > 0; attempts--) {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == PIN) {
                System.out.println("Login successful!\n");
                authenticated = true;
                break;
            } else {
                System.out.println("Wrong PIN! Attempts left: " + (attempts - 1));
            }
        }

        if (!authenticated) {
            System.out.println("Account locked due to 3 incorrect attempts.");
            return;
        }

      
        while (true) {
            System.out.println("\n==== ATM Menu ====");
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Check Balance");
            System.out.println("4) Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount! Try again.");
                        continue;
                    }
                    deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount! Try again.");
                        continue;
                    }
                    if (!withdraw(withdrawAmount)) {
                        System.out.println("Insufficient balance!");
                    } else {
                        System.out.println("Withdrawal successful.");
                    }
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
                    continue;
            }

            if (choice == 4) break;
        }

        scanner.close();
    }

 
    public static void deposit(int amount) {
        balance += amount;
    }

  
    public static boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }
}
