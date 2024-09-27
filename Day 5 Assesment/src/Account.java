/***import java.util.Scanner;

public class Account {
    private int id;
    private String accountType;
    private double balance;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(){}

    public Account(int id, String accountType, double balance) {
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
    }
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        else {
            return false;
        }
    }
    public String GetAccountType() {
        return "Account Id: " + id + "\nAccount Type:" + accountType + "\nBalance:" + balance;
    }
    public static class Program {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter account id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter account type: ");
            String accountType = scanner.next();

            System.out.println("Enter account balance: ");
            double balance = scanner.nextDouble();

            Account account= new Account(id,accountType,balance);
            System.out.println(account.GetDetails());
            System.out.println("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("New Balance: " + account.getBalance());
            }
            else {
                System.out.println("Insufficient Balance");
            }
            scanner.close();
        }
    }
} ***/
