package Day3_ATM;

import java.util.Scanner;

public class CardReader {

    private String cardNumber;
    private String expiryDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Prompt the user to “insert” their card by typing in details.
     */
    public CardReader readCard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert card — enter card number: ");
        String number = scanner.nextLine().trim();
        System.out.print("Enter expiry date (MM/yy): ");
        String expiry = scanner.nextLine().trim();

        CardReader card = new CardReader();
        card.setCardNumber(number);
        card.setExpiryDate(expiry);
        return card;
    }

    public void ejectCard() {
        System.out.println("Card ejected.\n");
    }
}
