package Day6_Inheritance;

class Animal {
    private String name;
    private int age;

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void makeSound(){
        System.out.println("Animal sound is");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Dog says bhow-bhow");
    }
}

class Cat extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Cat says meow-meow");
    }
}

public class Main{
    public static void main(String[] args){
        Dog d=new Dog();
        d.setName("Dog1");
        d.setAge(1);
        System.out.println("Dog name is "+d.getName()+" and age is "+d.getAge());
        d.makeSound();
        Cat c=new Cat();
        c.setName("Cat1");
        c.setAge(1);
        System.out.println("Cat name is "+c.getName()+" and age is "+c.getAge());
        c.makeSound();
    }
}


