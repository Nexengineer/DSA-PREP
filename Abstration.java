/*
    • Abstraction is one of the core concepts of OOP.
    • Abstraction is the concept of exposing to the user only those things that are relevant to them and hiding the remainder of the details.
    • Abstraction allows the user to focus on what the application does instead of how it does it.
    • Abstraction is achieved in Java via abstract classes and interfaces.
* */

import Model.BMW;

class Abstration {
    public static void main(String[] args){
        System.out.println("Hello");

        var obj = new BMW("BMW");
        obj.carName();
        obj.speedUp();
        obj.speedDown();
        obj.turnLeft();
        obj.turnRight();
    }
}

