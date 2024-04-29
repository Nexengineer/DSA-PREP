import Model.Audi;

/*
    • Encapsulation is one of the core concepts of OOP.
    • Encapsulation is the technique whereby the object state is hidden from the outer world and a set of public methods for accessing this state are exposed.
    • Encapsulation is achieved when each object keeps its state private, inside a class.
    • Encapsulation is known as the data-hiding mechanism.
    • Encapsulation has a number of important advantages associated with it, such as loosely coupled, reusable, secure, and easy-to-test code.
    • In Java, encapsulation is implemented via the access modifiers – public, private, and protected.
*/
public class Encapsulation {
    public static void main(String[] args) {
        Audi audi = new Audi();
        audi.carName();
        audi.speedUp();
        audi.speedDown();
        audi.turnLeft();
        audi.turnRight();
        audi.speedUp();
        audi.speedDown();
        audi.refill(); // This is example of encapsulation
        audi.speedUp();
    }
}
