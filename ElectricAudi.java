package Model;

public class ElectricAudi extends ElectricCar implements Car{
    private String carName;

    public ElectricAudi(){
        super();
        carName = "ElectricAudi";
    }

    @Override
    public void speedUp() {
        if (checkCharge()) {
            System.out.println("Audi goes broom broom");
            reduceCharge();
        } else {
            System.out.println("refill required");
        }
    }

    @Override
    public void speedDown() {
        if (checkCharge()) {
            System.out.println("Audi goes ehhh ehh");
            reduceCharge();
        } else {
            System.out.println("refill required");
        }
    }

    @Override
    public void turnRight() {
        if (checkCharge()) {
            System.out.println("Audi goes right");
            reduceCharge();
        } else {
            System.out.println("refill required");
        }
    }

    @Override
    public void turnLeft() {
        if (checkCharge()) {
            System.out.println("Audi goes left");
            reduceCharge();
        } else {
            System.out.println("refill required");
        }
    }

    public void refill(){
        super.recharge();
    }

    @Override
    public void carName() {
        System.out.println(carName);
    }
}
