package Model;

import java.util.ArrayList;
import java.util.List;
/*
    • Aggregation is one of the core concepts of OOP.
    • Aggregation is a special case of unidirectional association.
    • Aggregation represents a HAS-A relationship.
    • Two aggregated objects have their own life cycle, but one of the objects is the owner of the HAS-A relationship.
*/
public class Actor {
    private String name;
    private List<Car> carList;

    public Actor(String name){
        this.name = name;
        carList = new ArrayList<>();
    }

    public void appendCar(Car car){
        carList.add(car);
    }

    public void printAllCall(){
        System.out.println(name + " has below cars");
        carList.forEach(Car::carName);
    }

}
