package Day7_CoffeeMachine;

public class InventoryManager {
    private int water=500;
    private int milk=300;
    private int beans=200;

    public boolean hasIngredients(Coffee coffee){
        return water>=coffee.getWater() && milk>=coffee.getMilk() && beans>=coffee.getBeans();
    }

    public void useIngredients(Coffee coffee){
        water-=coffee.getWater();
        milk-=coffee.getMilk();
        beans-=coffee.getBeans();
    }

    public void printInventory(){
        System.out.println("Water is "+water+" ,milk is "+milk+" ,beans is "+beans);
    }
}
