import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

// Step 4: Use the façade class to access the subsystem
public class Customer {

    private BankService myBankService;

    public Customer() {
        this.myBankService = new BankService();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Customer().initializeGUI();
            }
        });
    }

    private void initializeGUI() {
        // Set up the JFrame
        JFrame frame = new JFrame("Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(4, 1));

        // Create buttons
        JButton createAccountButton = new JButton("Create New Account");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton transferButton = new JButton("Transfer");

        // Add action listeners to the buttons
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewAccount();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transfer();
            }
        });

        // Add buttons to the JFrame
        frame.add(createAccountButton);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(transferButton);

        // Set JFrame visibility
        frame.setVisible(true);
    }

    private void createNewAccount() {
        String accountType = JOptionPane.showInputDialog("Enter account type (chequing, saving, investment):");
        BigDecimal initialAmount = new BigDecimal(JOptionPane.showInputDialog("Enter initial amount:"));

        int accountNumber = myBankService.createNewAccount(accountType, initialAmount);

        JOptionPane.showMessageDialog(null, "Account created successfully! Account Number: " + accountNumber);
    }

    private void deposit() {
        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter account number:"));
        BigDecimal amount = new BigDecimal(JOptionPane.showInputDialog("Enter deposit amount:"));

        IAccount account = myBankService.getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            JOptionPane.showMessageDialog(null, "Deposit successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid account number");
        }
    }

    private void withdraw() {
        int accountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter account number:"));
        BigDecimal amount = new BigDecimal(JOptionPane.showInputDialog("Enter withdrawal amount:"));

        IAccount account = myBankService.getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            JOptionPane.showMessageDialog(null, "Withdrawal successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid account number");
        }
    }

    private void transfer() {
        int fromAccountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter source account number:"));
        int toAccountNumber = Integer.parseInt(JOptionPane.showInputDialog("Enter destination account number:"));
        BigDecimal amount = new BigDecimal(JOptionPane.showInputDialog("Enter transfer amount:"));

        IAccount fromAccount = myBankService.getAccount(fromAccountNumber);
        IAccount toAccount = myBankService.getAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(toAccount, amount);
            JOptionPane.showMessageDialog(null, "Transfer successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid account number(s)");
        }
    }
}

