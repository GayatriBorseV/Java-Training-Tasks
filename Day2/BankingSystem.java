package BankingSystem;

// Parent class Account
class Account {
    protected String holderName;
    protected String accountID;
    protected double currentBalance;

    // Constructor
    public Account(String holderName, String accountID, double initialBalance) {
        this.holderName = holderName;
        this.accountID = accountID;
        this.currentBalance = initialBalance;
    }

    // Method to add funds
    public void addFunds(double amount) {
        if (amount > 0) {
            currentBalance += amount;
            System.out.println("Amount added successfully: $" + amount);
        } else {
            System.out.println("Invalid amount. Please enter an amount greater than zero.");
        }
    }

    // Method to deduct funds
    public void deductFunds(double amount) {
        if (amount > 0 && amount <= currentBalance) {
            currentBalance -= amount;
            System.out.println("Amount withdrawn: $" + amount);
        } else {
            System.out.println("Withdrawal failed. Either insufficient balance or invalid amount.");
        }
    }

    // Method to display balance
    public void displayBalance() {
        System.out.println("Available balance: $" + currentBalance);
    }

    // Getter for account ID
    public String fetchAccountID() {
        return accountID;
    }
}

// Derived class PersonalAccount
class PersonalAccount extends Account {
    private static final double MINIMUM_BALANCE = 500.0; // Required minimum balance

    // Constructor
    public PersonalAccount(String holderName, String accountID, double initialBalance) {
        super(holderName, accountID, initialBalance);
    }

    // Override deductFunds to ensure minimum balance
    @Override
    public void deductFunds(double amount) {
        if (currentBalance - amount >= MINIMUM_BALANCE) {
            super.deductFunds(amount);
        } else {
            System.out.println("Withdrawal denied. Maintain a minimum balance of $" + MINIMUM_BALANCE);
        }
    }
}

// Derived class BusinessAccount
class BusinessAccount extends Account {
    private static final double MAX_OVERDRAFT = 1000.0; // Allowed overdraft limit

    // Constructor
    public BusinessAccount(String holderName, String accountID, double initialBalance) {
        super(holderName, accountID, initialBalance);
    }

    // Override deductFunds to allow overdraft within limit
    @Override
    public void deductFunds(double amount) {
        if (amount > 0 && (currentBalance - amount) >= -MAX_OVERDRAFT) {
            super.deductFunds(amount);
        } else {
            System.out.println("Transaction failed. Exceeds overdraft limit or invalid amount.");
        }
    }
}

// Main class to execute the program
public class BankingApp {
    public static void main(String[] args) {
        // Create PersonalAccount and BusinessAccount instances
        PersonalAccount personalAcc = new PersonalAccount("Alice Brown", "P123456", 1000);
        BusinessAccount businessAcc = new BusinessAccount("Bob Green", "B987654", 2000);

        // Perform operations on PersonalAccount
        System.out.println("Transactions for PersonalAccount:");
        personalAcc.addFunds(300); // Adding funds
        personalAcc.displayBalance(); // Display balance
        personalAcc.deductFunds(400); // Withdrawing funds
        personalAcc.displayBalance(); // Display balance after withdrawal
        personalAcc.deductFunds(1200); // Attempt withdrawal below minimum balance

        // Perform operations on BusinessAccount
        System.out.println("\nTransactions for BusinessAccount:");
        businessAcc.addFunds(800); // Adding funds
        businessAcc.displayBalance(); // Display balance
        businessAcc.deductFunds(2500); // Overdraft within limit
        businessAcc.displayBalance(); // Display balance after withdrawal
        businessAcc.deductFunds(5000); // Exceeding overdraft limit
    }
}
