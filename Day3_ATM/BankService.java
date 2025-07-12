package Day3_ATM;

import java.util.HashMap;
import java.util.Map;

public class BankService {

    // maps cardNumber → PIN
    private Map<String, String> pinDb = new HashMap<>();
    // maps cardNumber → balance
    private Map<String, Double> balDb = new HashMap<>();

    public BankService() {
        // no hard-coded accounts here
    }

    /**
     * Populate the in-memory “bank” before testing.
     */
    public void addAccount(String cardNumber, String pin, double initialBalance) {
        pinDb.put(cardNumber, pin);
        balDb.put(cardNumber, initialBalance);
    }

    /**
     * Check that the card exists and the PIN matches.
     */
    public boolean authorize(String cardNumber, String pin) {
        if (!pinDb.containsKey(cardNumber)) {
            System.out.println("Unknown card.");
            return false;
        }
        if (!pinDb.get(cardNumber).equals(pin)) {
            System.out.println("Incorrect PIN.");
            return false;
        }
        return true;
    }

    public double getBalance(String cardNumber) {
        return balDb.getOrDefault(cardNumber, 0.0);
    }

    public void updateBalance(String cardNumber, double newBalance) {
        balDb.put(cardNumber, newBalance);
    }
}
