package Day3_ATM;

public class ATM {
    public static void main(String[] args) {
        AtmController atm = new AtmController();

        // seed accounts via BankService before starting the ATM
        atm.getBankService().addAccount("1234-5678-9876-5432", "4321", 10000.0);
        atm.getBankService().addAccount("9876-5432-1234-5678", "0000", 5000.0);

        atm.start();
    }
}
