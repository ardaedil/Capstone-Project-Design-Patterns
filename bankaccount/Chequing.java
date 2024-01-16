package bankaccount;
import java.math.BigDecimal;
import java.util.Hashtable;


// Step 2: Implement the Interface with one or more classes
class Chequing implements IAccount {
    private int accountNumber;
    private BigDecimal balance;

    Chequing(BigDecimal initAmount) {
        this.accountNumber = AccountNumberGenerator.generateAccountNumber();
        this.balance = initAmount;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        System.out.println("Chequing Account #" + accountNumber + " - Deposited: $" + amount);
    }

    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
            System.out.println("Chequing Account #" + accountNumber + " - Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds in Chequing Account #" + accountNumber);
        }
    }

    public void transfer(IAccount toAccount, BigDecimal amount) {
        withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Transferred $" + amount + " from Chequing Account #" + accountNumber +
                " to " + toAccount.getAccountNumber());
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}