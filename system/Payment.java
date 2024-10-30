package hotel.system;

public class Payment {
    public static boolean processPayment(String customerName, double amount) {
        System.out.println("Processing payment of $" + amount + " for " + customerName + "...");
        return true; // Simulates a successful payment
    }
}
