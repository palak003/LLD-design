package Day3_ATM;

public class PinValidator {

    private String pin;

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    /**
     * Ensure the PIN is exactly 4 digits.
     */
    public boolean validateFormat() {
        return pin != null && pin.matches("\\d{4}");
    }
}
