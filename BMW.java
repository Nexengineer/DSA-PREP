package Model;
/*
    • Abstraction is one of the core concepts of OOP.
    • Abstraction is the concept of exposing to the user only those things that are relevant to them and hiding the remainder of the details.
    • Abstraction allows the user to focus on what the application does instead of how it does it.
    • Abstraction is achieved in Java via abstract classes and interfaces.
* */
public class BMW  implements Car {
    String name;
    public BMW(String name){
        this.name = name;
    }

    public void speedUp(){
        System.out.println(name + " speeding up");
    }
    public void speedDown(){
        System.out.println(name + " speeding down");
    }
    public void turnRight(){
        System.out.println(name + " turning right");
    }
    public void turnLeft(){
        System.out.println(name + " turning left");
    }
    public void carName(){
        System.out.println(name + " car");
    }
}
