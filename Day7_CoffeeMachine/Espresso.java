package Day7_CoffeeMachine;

public class Espresso extends Coffee {
    public Espresso() {
        this.water = 50;
        this.milk = 0;
        this.beans = 18;
        this.price = 5;
    }

    @Override
    public String getName() {
        return "Espresso";
    }
}
