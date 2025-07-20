package Day7_CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private InventoryManager inventory = new InventoryManager();
    private PaymentProcessor payment = new PaymentProcessor();

    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Espresso ($5)");
            System.out.println("2. Americano ($6)");
            System.out.println("3. Latte ($7)");
            System.out.println("4. Cappuccino ($8)");
            System.out.println("5. Exit");
            System.out.print("Select your coffee: ");

            int choice = sc.nextInt();
            Coffee selected = null;

            switch (choice) {
                case 1: selected = new Espresso(); break;
                case 2: selected = new Americano(); break;
                case 3: selected = new Latte(); break;
                case 4: selected = new Cappuccino(); break;
                case 5:
                    System.out.println("Thanks! Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            if (!inventory.hasIngredients(selected)) {
                System.out.println("Not enough ingredients to make " + selected.getName());
                inventory.printInventory();
                continue;
            }

            if (!payment.processPayment(selected.getPrice())) {
                continue;
            }

            inventory.useIngredients(selected);
            System.out.println("Dispensing your " + selected.getName() + " ☕");
            inventory.printInventory();
        }
    }
}
