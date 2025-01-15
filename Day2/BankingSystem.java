import java.util.Scanner;

// Base Class
class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    protected double balance;

    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display account details
    public void displayDetails() {
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double minimumBalance;

    public SavingsAccount(String accountHolderName, String accountNumber, double initialBalance, double minimumBalance) {
        super(accountHolderName, accountNumber, initialBalance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= minimumBalance) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw! Minimum balance requirement of " + minimumBalance + " must be maintained.");
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Minimum Balance: " + minimumBalance);
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BankAccount {
    private double overdraftLimit;

    public CurrentAccount(String accountHolderName, String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountHolderName, accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw! Overdraft limit of " + overdraftLimit + " exceeded.");
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit);
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create account
        System.out.println("Welcome to the Banking System");
        System.out.print("Enter account type (1 for Savings, 2 for Current): ");
        int accountType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account = null;

        if (accountType == 1) {
            System.out.print("Enter Minimum Balance for Savings Account: ");
            double minBalance = scanner.nextDouble();
            account = new SavingsAccount(name, accountNumber, initialBalance, minBalance);
        } else if (accountType == 2) {
            System.out.print("Enter Overdraft Limit for Current Account: ");
            double overdraftLimit = scanner.nextDouble();
            account = new CurrentAccount(name, accountNumber, initialBalance, overdraftLimit);
        } else {
            System.out.println("Invalid account type. Exiting...");
            System.exit(0);
        }

        // Menu for operations
        while (true) {
            System.out.println("\nBanking Operations:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using the Banking System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
