package Day7_CoffeeMachine;

import java.util.Scanner;

public class PaymentProcessor {

    public boolean processPayment(int price){
        Scanner sc=new Scanner(System.in);
        int paid=sc.nextInt();
        if(paid>=price){
            int change=paid-price;
            System.out.println("Returning change "+ change);
            return true;
        }
        return false;
    }
}
