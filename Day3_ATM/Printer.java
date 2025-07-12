package Day3_ATM;

public class Printer {

    /**
     * Print a receipt showing transaction details and new balance.
     */
    public void printReceipt(String cardNumber, String txType, double amount, double newBalance) {
        System.out.println("\n----- Receipt -----");
        System.out.println("Card:    " + cardNumber);
        System.out.println("Type:    " + txType);
        System.out.println("Amount:  ₹" + amount);
        System.out.println("Balance: ₹" + newBalance);
        System.out.println("-------------------\n");
    }
}
