package Inheritance;

public class SuperCar extends Car {
    private float speedModifierStep = 0.2f;

    public SuperCar() {
        this(7);
    }

    public SuperCar(int maxGear) {
        this(maxGear, 2f);
    }

    public SuperCar(int maxGear, float speedModifier) {
        super(maxGear);
        this.speedModifier = speedModifier;
    }

    @Override
    public void incGear() {
        /*
         * Super-cars accelerate faster, so we
         * improvise on the velocity formula by
         * altering the speedModifier depending on
         * the current gear
         */
        super.incGear(); // I should find a way to execute all but the updateVelocity from the parent method
        speedModifier += speedModifierStep * gear;
        updateVelocity();
    }

    @Override
    public void decGear() {
        speedModifier -= speedModifierStep * gear;
        super.decGear(); // I should find a way to execute all but the updateVelocity from the parent method
        updateVelocity();
    }
}
