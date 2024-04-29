/*
    • Aggregation is one of the core concepts of OOP.
    • Aggregation is a special case of unidirectional association.
    • Aggregation represents a HAS-A relationship.
    • Two aggregated objects have their own life cycle, but one of the objects is the owner of the HAS-A relationship.
*/

import Model.Actor;
import Model.Audi;
import Model.BMW;
import Model.ElectricAudi;

public class Aggregation {
    public static void main(String[] args) {
        Actor actor = new Actor("SRK");
        actor.appendCar(new Audi());
        actor.appendCar(new ElectricAudi());
        actor.appendCar(new BMW("720d"));

        actor.printAllCall();
    }
}
