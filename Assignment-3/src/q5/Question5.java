package q5;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) { super(msg); }
}

class InvalidAmountException extends Exception {
    public InvalidAmountException(String msg) { super(msg); }
}

class AccountNotFoundException extends Exception {
    public AccountNotFoundException(String msg) { super(msg); }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be greater than zero.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Available: " + balance);
        }
        balance -= amount;
    }
}

class BankService {
    private BankAccount account;

    public BankService(BankAccount account) {
        this.account = account;
    }

    public void processDeposit(String accNo, double amount) throws AccountNotFoundException, InvalidAmountException {
        if (!account.getAccountNumber().equals(accNo)) {
            throw new AccountNotFoundException("Account number " + accNo + " not found.");
        }
        account.deposit(amount);
    }

    public void processWithdrawal(String accNo, double amount) throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        if (!account.getAccountNumber().equals(accNo)) {
            throw new AccountNotFoundException("Account number " + accNo + " not found.");
        }
        account.withdraw(amount);
    }
}

public class Question5 {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC123", 500.0);
        BankService service = new BankService(acc);

        try {
            service.processDeposit("ACC123", 200.0);
            System.out.println("Deposit successful. Balance: " + acc.getBalance());

            service.processWithdrawal("ACC123", 100.0);
            System.out.println("Withdrawal successful. Balance: " + acc.getBalance());

            service.processWithdrawal("ACC999", 50.0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            service.processWithdrawal("ACC123", 1000.0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
