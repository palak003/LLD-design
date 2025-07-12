package Day3_ATM;

import java.util.Scanner;

public class AtmController {

    private CardReader    cardReader    = new CardReader();
    private PinValidator  pinValidator  = new PinValidator();
    private BankService   bankService   = new BankService();
    private CashDispenser cashDispenser = new CashDispenser();
    private Printer       printer       = new Printer();

    public BankService getBankService() {
        return bankService;
    }
    private Scanner scanner = new Scanner(System.in);

    /**
     * Entry point for the ATM flow.
     * Reads card, prompts for PIN, then shows menu.
     */
    public void start() {
        System.out.println("=== Welcome to the ATM ===");
        CardReader userCard = insertCard();

        System.out.print("Enter PIN: ");
        pinValidator.setPin(scanner.nextLine().trim());

        if (!pinValidator.validateFormat() ||
                !bankService.authorize(userCard.getCardNumber(), pinValidator.getPin())) {
            System.out.println("Authentication failed.");
            endSession();
            return;
        }

        showMenu(userCard.getCardNumber());
    }

    /** Delegate reading to CardReader. */
    public CardReader insertCard() {
        return cardReader.readCard();
    }

    /** Loop until user exits. */
    public void showMenu(String cardNumber) {
        while (true) {
            System.out.println("Select: (W)ithdraw | (D)eposit | (B)alance | (E)xit");
            String choice = scanner.nextLine().trim().toUpperCase();
            if ("E".equals(choice)) {
                System.out.println("Exiting...");
                break;
            }
            selectTransaction(choice, cardNumber);
        }
        endSession();
    }

    /**
     * Prompt for amount when needed, then execute.
     */
    public void selectTransaction(String type, String cardNumber) {
        switch (type) {
            case "W":
                System.out.print("Amount to withdraw: ");
                double wAmt = Double.parseDouble(scanner.nextLine().trim());
                executeTransaction("Withdraw", cardNumber, wAmt);
                break;
            case "D":
                System.out.print("Amount to deposit: ");
                double dAmt = Double.parseDouble(scanner.nextLine().trim());
                executeTransaction("Deposit", cardNumber, dAmt);
                break;
            case "B":
                double bal = bankService.getBalance(cardNumber);
                System.out.println("Current Balance: ₹" + bal + "\n");
                break;
            default:
                System.out.println("Invalid option.\n");
        }
    }

    /**
     * Core withdrawal/deposit logic, then print a receipt.
     */
    public void executeTransaction(String txType, String cardNumber, double amount) {
        double bal = bankService.getBalance(cardNumber);

        if ("Withdraw".equals(txType)) {
            if (bal < amount) {
                System.out.println("Insufficient funds.\n");
                return;
            }
            bankService.updateBalance(cardNumber, bal - amount);
        } else if ("Deposit".equals(txType)) {
            bankService.updateBalance(cardNumber, bal + amount);
        }

        double newBal = bankService.getBalance(cardNumber);
        if ("Withdraw".equals(txType)) {
            cashDispenser.dispense(amount);
        }
        printer.printReceipt(cardNumber, txType, amount, newBal);
    }

    /** Eject the card and say goodbye. */
    public void endSession() {
        cardReader.ejectCard();
        System.out.println("Thank you for using the ATM.\n");
    }
}
