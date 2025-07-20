package Day7_CoffeeMachine;

public class Americano extends Coffee {
    public Americano() {
        this.water = 100;
        this.milk = 0;
        this.beans = 20;
        this.price = 6;
    }

    @Override
    public String getName() {
        return "Americano";
    }
}
