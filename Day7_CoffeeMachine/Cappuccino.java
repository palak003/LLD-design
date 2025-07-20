package Day7_CoffeeMachine;

public class Cappuccino extends Coffee {
    public Cappuccino() {
        this.water = 50;
        this.milk = 60;
        this.beans = 15;
        this.price = 8;
    }

    @Override
    public String getName() {
        return "Cappuccino";
    }
}
