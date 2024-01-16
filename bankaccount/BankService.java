package bankaccount;
import java.math.BigDecimal;
import java.util.Hashtable;


// Step 3: Create the façade class and wrap the classes that implement the interface
class BankService {
    private Hashtable<Integer, IAccount> bankAccounts;

    BankService() {
        this.bankAccounts = new Hashtable<>();
    }

    public int createNewAccount(String type, BigDecimal initAmount) {
        IAccount newAccount = null;
        switch (type) {
            case "chequing":
                newAccount = new Chequing(initAmount);
                break;
            case "saving":
                newAccount = new Saving(initAmount);
                break;
            case "investment":
                newAccount = new Investment(initAmount);
                break;
            default:
                System.out.println("Invalid account type");
                break;
        }
        if (newAccount != null) {
            this.bankAccounts.put(newAccount.getAccountNumber(), newAccount);
            return newAccount.getAccountNumber();
        }
        return -1;
    }

    public void transferMoney(int to, int from, BigDecimal amount) {
        IAccount toAccount = this.bankAccounts.get(to);
        IAccount fromAccount = this.bankAccounts.get(from);
        if (toAccount != null && fromAccount != null) {
            fromAccount.transfer(toAccount, amount);
        } else {
            System.out.println("Invalid account numbers");
        }
    }
}