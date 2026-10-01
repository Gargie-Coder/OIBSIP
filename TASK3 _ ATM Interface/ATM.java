import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner sc;

    public ATM(Bank bank) {
        this.bank = bank;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("===== Welcome to the ATM =====");
        Account user = loginUser();

        if (user == null) {
            System.out.println("Too many wrong attempts. Access denied.");
            return;
        }
        showMenu(user);
    }

    private Account loginUser() {
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Enter User ID: ");
            String id = sc.nextLine().trim();
            System.out.print("Enter PIN: ");
            String pin = sc.nextLine().trim();

            Account acc = bank.login(id, pin);
            if (acc != null) {
                System.out.println("Login successful!");
                return acc;
            }
            attempts++;
            System.out.println("Wrong ID or PIN. Attempts left: " + (3 - attempts));
        }
        return null;
    }

    private void showMenu(Account user) {
        boolean running = true;

        while (running) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    showHistory(user);
                    break;
                case "2":
                    double w = readAmount();
                    if (user.withdraw(w)) {
                        System.out.println("Please collect your cash. Balance: Rs." + user.getBalance());
                    } else {
                        System.out.println("Insufficient Funds");
                    }
                    break;
                case "3":
                    double d = readAmount();
                    user.deposit(d);
                    System.out.println("Deposit done. Balance: Rs." + user.getBalance());
                    break;
                case "4":
                    System.out.print("Enter recipient User ID: ");
                    String toId = sc.nextLine().trim();
                    double t = readAmount();
                    System.out.println(bank.transfer(user, toId, t));
                    break;
                case "5":
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    private void showHistory(Account user) {
        if (user.getHistory().isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("\n--- Transaction History ---");
        for (Transaction t : user.getHistory()) {
            System.out.println(t);
        }
    }

    private double readAmount() {
        while (true) {
            System.out.print("Enter amount: ");
            try {
                double amt = Double.parseDouble(sc.nextLine().trim());
                if (amt > 0) {
                    return amt;
                }
                System.out.println("Amount must be more than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}