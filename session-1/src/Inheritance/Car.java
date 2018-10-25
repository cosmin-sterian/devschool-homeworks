package Inheritance;

public class Car extends Vehicle {
    protected int gear;
    protected int minGear, maxGear;
    protected float speedModifier = 1f;

    public Car() {
        gear = 0;
        minGear = 0;
        maxGear = 5;
    }

    public Car(int maxGear) {
        this();
        this.maxGear = maxGear;
    }

    public int getGear() {
        return gear;
    }

    public void incGear() {
        //Sanity check
        if (!sanityCheckGear()) {
            System.out.println("Error increasing gear due to sanity check");
            return;
        }
        if (gear == maxGear) {
            System.out.println("Max gear reached(" + maxGear + "), can't increase further.");
            return;
        }
        gear ++;
        if (speed < 0.1f)
            speed = 1f;
        updateVelocity();
    }

    public void decGear() {
        //Sanity check
        if (!sanityCheckGear()) {
            System.out.println("Error decreasing gear due to sanity check");
            return;
        }
        if (gear == minGear) {
            System.out.println("Min gear reached(" + minGear + "), can't decrease further.");
            return;
        }
        gear --;
        if (gear == 0)
            speed = 0f;
        updateVelocity();
    }

    /*
    public void setGear(int gear) {
        this.gear = gear;
    }
    */

    public int getMinGear() {
        return minGear;
    }

    public void setMinGear(int minGear) {
        if (minGear > maxGear) {
            System.out.println("Cannot set the minGear (" + minGear +") higher than" +
                    " the maxGear (" + maxGear + ")!");
            return;
        }
        this.minGear = minGear;
        if (gear < minGear) {
            gear = minGear;
            updateVelocity();
        }
    }

    public int getMaxGear() {
        return maxGear;
    }

    public void setMaxGear(int maxGear) {
        if (maxGear < minGear) {
            System.out.println("Cannot set the maxGear (" + maxGear + ") lower than" +
                    " the minGear (" + minGear + ")!");
            return;
        }
        this.maxGear = maxGear;
        if (maxGear < gear) {
            gear = maxGear;
            updateVelocity();
        }
    }

    public float getSpeedModifier() {
        return speedModifier;
    }

    public void setSpeedModifier(float speedModifier) {
        this.speedModifier = speedModifier;
        updateVelocity();
    }

    @Override
    public void updateVelocity() {
        /*
         * For cars, we also have to consider
         * the current gear and speedModifier
         * when computing velocity
         */
        velocity = speed * speedModifier * gear;
    }

    @Override
    public String toString() {
        return "[Car] Steering " + steering + " with " + velocity + " velocity in " +
                "gear " + gear + " with speedModifier = " + speedModifier +
                " and speed = " + speed;
    }

    protected boolean sanityCheckGear() {
        // Sanity check for gear value
        boolean safe = true;
        final String sanityCheckPrefix = "Sanity Check failed: ";

        if (gear > maxGear) {
            System.out.println(sanityCheckPrefix + "gear = " + gear + " is higher than " +
                    "maxGear = " + maxGear);
            safe = false;
        }
        if (gear < minGear) {
            System.out.println(sanityCheckPrefix + "gear = " + gear + "is lower than " +
                    "minGear = " + minGear);
            safe = false;
        }
        if (minGear > maxGear) {
            System.out.println(sanityCheckPrefix + "minGear = " + minGear + "is higher than " +
                    "maxGear = " + maxGear);
            safe = false;
        }

        return safe;
    }
}
