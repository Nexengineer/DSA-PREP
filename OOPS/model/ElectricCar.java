package Model;
/*
    • Inheritance is one of the core concepts of OOP.
    • Inheritance allows an object to be based on another object.
    • Inheritance sustains code reusability by allowing an object to reuse the code of another object and adds its own logic as well.
    • Inheritance is known as an IS-A relationship, also referenced as a parent-child relationship.
    • In Java, inheritance is achieved via the extends keyword.
    • The inherited object is referenced as the superclass, and the object that inherits the
    superclass is referenced as the subclass.
    • In Java, multiple classes cannot be inherited.
*/
public class ElectricCar {
    private int charge;

    public ElectricCar(){
        charge = 30;
    }

    public void recharge(){
        charge+=10;
    }

    public void reduceCharge(){
        charge-=10;
    }

    public boolean checkCharge(){
        return charge>=0;
    }
}
