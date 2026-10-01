import java.util.ArrayList;

public class Account {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transaction> history;

    public Account(String userId, String pin, double balance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public boolean checkPin(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public void deposit(double amount) {
        balance += amount;
        history.add(new Transaction("Deposit", amount, "Cash deposited"));
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        history.add(new Transaction("Withdraw", amount, "Cash withdrawn"));
        return true;
    }

    public boolean sendMoney(double amount, String toId) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        history.add(new Transaction("Transfer Out", amount, "Sent to " + toId));
        return true;
    }

    public void receiveMoney(double amount, String fromId) {
        balance += amount;
        history.add(new Transaction("Transfer In", amount, "Received from " + fromId));
    }
}