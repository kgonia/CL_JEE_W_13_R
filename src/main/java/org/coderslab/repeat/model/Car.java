package org.coderslab.repeat.model;

public class Car {

    public Car(double radius) {
        this.radius = radius;
    }

    private double speed;

    // jak zamodelować to lepiej?
    private Integer gear;

    // jak zamodelować to lepiej?
    // promień
    // 19 cali – 48,26 cm. 20 cali – 50,80 cm. 21 cali – 53,34 cm.
    private double radius = 48.26;

    private int f = 0;

    // wzór na predkość liniowią okręgu o promieniu (radius) i częstotliwości, liczba pełnych obrotów wykonanych w czasie jednej sekundy ( f )
    public double getSpeed() {
        this.speed = 2 * Math.PI * radius * f;
        return speed;
    }

    public void startEngine() {
        if (gear == null) {
            throw new UnsupportedOperationException("you must set gear before you start engine");
        }
        f = 1000;
    }

    public void setGear(Integer gear) {
        this.gear = gear;
    }

    public void accelerate(int acceleration) {
        this.f = this.f + acceleration;
    }

    public void slowDown(int acceleration) {
        this.f = this.f - acceleration;
    }
}
