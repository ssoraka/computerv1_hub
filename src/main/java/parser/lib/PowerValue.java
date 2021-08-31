package parser.lib;

public class PowerValue {
    private int power = 0;
    private int value = 1;
    private String name = "X";

    public PowerValue(int power, int value, String name) {
        this.power = power;
        this.value = value;
        this.name = name;

        if (power < 0 || power > 2) {
            throw new NumberFormatException("степень не может быть " + power);
        }
    }

    public PowerValue(int value) {
        this.value = value;
    }

    public int getPower() {
        return power;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        if (power == 0) {
            return value + "";
        } else if (value == 0) {
            return "0";
        } else {
            return value + " * " + name + " ^ " + power;
        }
    }
}
