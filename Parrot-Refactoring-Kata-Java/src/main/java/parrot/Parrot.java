package parrot;

public class Parrot {

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        double speed = 0.0;
        switch (type) {
            case EUROPEAN:
                speed = getBaseSpeed();
                break;
            case AFRICAN:
                speed = Math.max(0, getBaseSpeed() - getLoadFactor() * numberOfCoconuts);
                break;
            case NORWEGIAN_BLUE:
                speed = (isNailed) ? 0 : getBaseSpeed(voltage);
                break;
        }
        return speed;
    }

    private double getBaseSpeed(double voltage) {
        return Math.min(24.0, voltage * getBaseSpeed());
    }

    private double getLoadFactor() {
        return 9.0;
    }

    private double getBaseSpeed() {
        return 12.0;
    }

}
