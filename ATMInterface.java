import java.util.*;

class Transaction {
    private String accountType;
    private double Amount;

    public Transaction(String accountType, double Amount) {
        this.accountType = accountType;
        this.Amount = Amount;
    }
    public String toString() {
        return accountType + ": " + Amount;
    }
}

class Account {
    private double balance;
    private ArrayList<Transaction> transactionHistory;

    public Account() {
        balance = 0;
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double Amount) {
        if  (Amount > 0) {
            balance += Amount;
            transactionHistory.add(new Transaction("Deposit", Amount));
            System.out.println("Deposit successful.");
        } else {
            System.out.println("please enter amount");
        }
    }

    public void withdraw(double Amount) {
        if  (Amount > 0 && Amount <= balance) {
            balance -= Amount;
            transactionHistory.add(new Transaction("Withdrawal",  Amount));
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("insufficient balance.");
        }
    }

    public void transfer(Account recipient, double Amount) {
        if  (Amount > 0 && Amount <= balance) {
            balance -= Amount;
            recipient.deposit(Amount);
            transactionHistory.add(new Transaction("Transfer to " + recipient.hashCode(),  Amount));
            System.out.println("Transfer successful.");
        } else {
            System.out.println("some error occoured during this process.");
        }
    }

    public void printTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        while (true) {
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. deposit");
            System.out.println("4. Transfer ");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                   account.printTransactionHistory();
                    break;
                    
                case 2:
                    System.out.print("Enter withdrawal Amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                  
                    System.out.print("Enter deposit Amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 4:
                 
                     System.out.print("Enter recipient's account ID: ");

                    Account recipient = getRecipientAccount(scanner.nextInt());
                    if (recipient != null) {
                        System.out.print("Enter transfer Amount: ");
                        double transferAmount = scanner.nextDouble();
                        account.transfer(recipient, transferAmount);
                    } else {
                        System.out.println("Recipient account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
    private static Account getRecipientAccount(int accountID) {
    
        return null;
    }
}
