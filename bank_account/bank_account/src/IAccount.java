
import java.math.BigDecimal;
import java.util.Hashtable;

// Step 1: Design the Interface
interface IAccount {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    void transfer(IAccount toAccount, BigDecimal amount);
    int getAccountNumber();
}











