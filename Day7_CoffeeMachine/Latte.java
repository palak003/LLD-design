package Day7_CoffeeMachine;

public class Latte extends Coffee {
    public Latte() {
        this.water = 50;
        this.milk = 50;
        this.beans = 18;
        this.price = 7;
    }

    @Override
    public String getName() {
        return "Latte";
    }
}
