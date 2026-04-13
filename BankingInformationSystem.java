import java.util.*;

class BankAccount {
    String name;
    int accountNumber;
    double balance;

    BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully!");
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class BankingInformationSystem {
    static Scanner sc = new Scanner(System.in);
    static List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Banking System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    displayAccount();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }

    static void createAccount() {
        System.out.print("Enter Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        accounts.add(new BankAccount(name, accNo, balance));
        System.out.println("Account Created Successfully!");
    }

    static BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.accountNumber == accNo) {
                return acc;
            }
        }
        return null;
    }

    static void deposit() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.deposit(amt);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void withdraw() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            acc.withdraw(amt);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void displayAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            acc.display();
        } else {
            System.out.println("Account Not Found!");
        }
    }
}
