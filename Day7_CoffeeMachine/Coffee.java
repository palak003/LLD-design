package Day7_CoffeeMachine;

public abstract class Coffee {
    protected int water;
    protected int milk;
    protected int beans;
    protected int price;

    public abstract String getName();

    public int getWater() { return water; }
    public int getMilk() { return milk; }
    public int getBeans() { return beans; }
    public int getPrice() { return price; }
}
