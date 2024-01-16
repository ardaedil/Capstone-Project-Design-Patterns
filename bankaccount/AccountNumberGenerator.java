package bankaccount;
import java.math.BigDecimal;
import java.util.Hashtable;


// Utility class to generate unique account numbers
class AccountNumberGenerator {
    private static int accountNumberCounter = 1;

    static int generateAccountNumber() {
        return accountNumberCounter++;
    }
}