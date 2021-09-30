package Maktab58_HW3_ElhamAmini.three.differenceAggCom;

final class Car {
    private final Engine engine; // Composition
    //private Engine engine;     // Aggregation

    Car(Engine engine) {
        this.engine = engine;
    }

    // car start moving by starting engine
    public void move() {

        //if(engine != null)
        {
            engine.work();
            System.out.println("Car is moving ");
        }
    }
}
