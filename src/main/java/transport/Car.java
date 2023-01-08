package main.java.transport;

public class Car extends Transport {
    private long speed;
    private String brand;

    public Car(long speed, String brand) {
        this.speed = speed;
        this.brand = brand;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
