/*
    • Polymorphism is one of the core concepts of OOP.
    • Polymorphism means many forms in Greek.
    • Polymorphism allows an object to behave differently in certain cases.
    • Polymorphism can be shaped via method overloading (known as Compile-Time Polymorphism) or
     via method overriding in the case of an IS-A relationship (known as Runtime Polymorphism).
*/
public class Polymorphism {
    public static void main(String[] args) {
        // --
        A obj1 = new A();
        obj1.printName();
        obj1.printHello();
        System.out.println();

        // --
        A obj2 = new B();
        obj2.printName();
        obj2.printHello();
        System.out.println();

        // --
        B obj3 = new B();
        obj3.printName("obj");
        obj3.printHello();
        obj3.diffMethod();
    }
}

class A {
    public void printName(){
        System.out.println("Anonymous");
    }

    public void printHello(){
        System.out.println("Hello from A");
    }
}

class B extends A {
    /*
    * If there are overridden methods,
    * which method is to be executed depends on the type of object ;
    * that is decided at RUNTIME by the JVM
    */
    @Override // Run time polymorphism
    public void printName(){
        System.out.println("B is my Name");
    }

    public void diffMethod(){
        System.out.println("I am a diff method");
    }

    /*
    * With overloading you have a function with different sets of parameters.
    * The function that is executed is determined using the number and type of the parameters you provide.
    * As these are known at compile time, the compiler already determines the function to use.
    */
    public void printName(String name){ //Overloading compile time polymorphism
        System.out.println(name + " I am in B class");
    }
}
