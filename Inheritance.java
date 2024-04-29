import Model.ElectricAudi;

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
public class Inheritance {
    public static void main(String[] args) {
        ElectricAudi electricAudi = new ElectricAudi();
        electricAudi.carName();
        electricAudi.turnLeft();
        electricAudi.turnRight();
        electricAudi.speedDown();
        electricAudi.speedUp();
        electricAudi.speedUp();
        electricAudi.speedUp();
        electricAudi.refill();
        electricAudi.turnRight();
    }
}
