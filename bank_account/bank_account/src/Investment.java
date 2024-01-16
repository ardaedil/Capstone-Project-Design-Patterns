
import java.math.BigDecimal;
import java.util.Hashtable;

class Investment implements IAccount {
    private int accountNumber;
    private BigDecimal balance;

    Investment(BigDecimal initAmount) {
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.balance = initAmount;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println("Investment Account #" + accountNumber + " - Deposited: $" + amount);
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            System.out.println("Investment Account #" + accountNumber + " - Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds in Investment Account #" + accountNumber);
        }
    }

    public void transfer(IAccount toAccount, BigDecimal amount) {
        withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transferred $" + amount + " from Investment Account #" + accountNumber +
                " to " + toAccount.getAccountNumber());
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}