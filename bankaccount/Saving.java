package bankaccount;
import java.math.BigDecimal;
import java.util.Hashtable;

class Saving implements IAccount {
    private int accountNumber;
    private BigDecimal balance;

    Saving(BigDecimal initAmount) {
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.balance = initAmount;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println("Saving Account #" + accountNumber + " - Deposited: $" + amount);
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            System.out.println("Saving Account #" + accountNumber + " - Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds in Saving Account #" + accountNumber);
        }
    }

    public void transfer(IAccount toAccount, BigDecimal amount) {
        withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transferred $" + amount + " from Saving Account #" + accountNumber +
                " to " + toAccount.getAccountNumber());
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}