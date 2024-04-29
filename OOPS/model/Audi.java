package Model;
/*
    • Encapsulation is one of the core concepts of OOP.
    • Encapsulation is the technique whereby the object state is hidden from the outer world and a set of public methods for accessing this state are exposed.
    • Encapsulation is achieved when each object keeps its state private, inside a class.
    • Encapsulation is known as the data-hiding mechanism.
    • Encapsulation has a number of important advantages associated with it, such as loosely coupled, reusable, secure, and easy-to-test code.
    • In Java, encapsulation is implemented via the access modifiers – public, private, and protected.
*/
public class Audi implements Car {
    private final String carName;
    private int tank;

    public Audi() {
        this.carName = "Audi";
        this.tank = 5;
    }
    @Override
    public void speedUp() {
        if (checkTank()) {
            System.out.println("Audi goes broom broom");
            tank--;
        } else {
            System.out.println("refill required");
        }
    }

    @Override
    public void speedDown() {
        if (checkTank()) {
            System.out.println("Audi goes ehhh ehh");
            tank--;
        } else {
            System.out.println("refill required");
        }
    }

    @Override
    public void turnRight() {
        if (checkTank()) {
            System.out.println("Audi goes right");
            tank--;
        } else {
            System.out.println("refill required");
        }
    }

    @Override
    public void turnLeft() {
        if (checkTank()) {
            System.out.println("Audi goes left");
            tank--;
        } else {
            System.out.println("refill required");
        }
    }

    @Override
    public void carName() {
        System.out.println(carName);
    }

    public void refill() {
        tank++;
    }

    private boolean checkTank(){
        return tank > 0;
    }
}
