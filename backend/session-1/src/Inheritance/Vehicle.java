package Inheritance;

public class Vehicle {
    enum Steering { LEFT, STRAIGHT, RIGHT }
    protected float speed;
    protected float velocity;
    protected Steering steering = Steering.STRAIGHT;

    public void incSpeed() {
        speed++;
        updateVelocity();
    }

    public void decSpeed() {
        speed--;
        updateVelocity();
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getVelocity() {
        return velocity;
    }

    public void updateVelocity() {
        velocity = speed;
    }

    public Steering getSteering() {
        return steering;
    }

    public void setSteering(Steering steering) {
        this.steering = steering;
    }

    @Override
    public String toString() {
        return "[Vehicle] Steering " + steering + " with " + velocity + " velocity.";
    }
}
