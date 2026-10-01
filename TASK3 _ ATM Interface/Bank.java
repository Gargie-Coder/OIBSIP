import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public Account findAccount(String userId) {
        for (Account acc : accounts) {
            if (acc.getUserId().equals(userId)) {
                return acc;
            }
        }
        return null;
    }

    public Account login(String userId, String pin) {
        Account acc = findAccount(userId);
        if (acc != null && acc.checkPin(pin)) {
            return acc;
        }
        return null;
    }

    public String transfer(Account from, String toId, double amount) {
        Account to = findAccount(toId);

        if (to == null) {
            return "Recipient account not found.";
        }
        if (to == from) {
            return "You cannot transfer money to your own account.";
        }
        if (!from.sendMoney(amount, toId)) {
            return "Insufficient Funds";
        }
        to.receiveMoney(amount, from.getUserId());
        return "Transfer successful!";
    }
}