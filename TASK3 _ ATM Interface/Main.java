public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new Account("user1", "1234", 5000));
        bank.addAccount(new Account("user2", "4321", 3000));
        bank.addAccount(new Account("user3", "1111", 10000));

        ATM atm = new ATM(bank);
        atm.start();
    }
}