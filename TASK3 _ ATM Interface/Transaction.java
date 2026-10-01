import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private String details;
    private String time;

    public Transaction(String type, double amount, String details) {
        this.type = type;
        this.amount = amount;
        this.details = details;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.time = LocalDateTime.now().format(f);
    }

    public String toString() {
        return time + " | " + type + " | Rs." + amount + " | " + details;
    }
}