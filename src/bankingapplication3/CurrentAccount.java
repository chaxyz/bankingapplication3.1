package bankingapplication3;

public class CurrentAccount implements Account {

    private int accountNumber;
    private String accountName;
    private double balance;
    private final String accountType;
    private double minimum;

    public CurrentAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.accountType = "CurrentAccount";
        this.minimum = 0;
    }

    @Override
    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountName() {
        return accountName;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    @Override
    public String getAccountType() {
        return accountType;
    }

    @Override
    public void deposit(double amount) {
        this.balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        this.balance -= amount;
    }

}
