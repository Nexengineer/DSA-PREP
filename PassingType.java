/*
* Java generally uses pass by value but the behaviour changes
*
* - When ever using primitive type it functions like `pass by value`
* - In case of object, as object is nothing but a pointer to a memory location then it becomes
* `pass by reference`.
* - Below is the sample for pass by reference
* */


class PassingType {
    /*
    * Static method can talk to only static method and access static variable.
    * It can be called without object.
    * Static method can't use this and super keywords
    * */

    public static void main(String[] args) {
        A obj1 = new A();
        obj1.increment();
        obj1.printA();

        A obj2 = new A();
        obj2.increment(obj1);
        obj1.printA();
        obj2.printA();
    }
}

class A {
    private int a;

    public A(){
        /*
        * Why does constructor don't return any values?
        * - Constructor is not a part of code instead it is part of runtime.
        * - Runtime decides using type data generated to understand space allocation irr. of stack or heap
        * - constructor is called as an internal part of the instantiation
        *  and initialization process to initialize the contents of the fields.
        * */
        this.a = 20;
    }

    public void increment(){
        this.a++;
    }

    public void increment(A obj){
        obj.increment();
    }

    public void printA(){
        System.out.println("Print A: "+ this.a);
    }
}
