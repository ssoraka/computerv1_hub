package parser.lib;

import java.lang.Math;

public class UnknownValue implements Value {
    final private String name;
    final private double num;
    final private int pow;

    public UnknownValue(String value) {
        this.name = value;
        this.num = 1.0;
        this.pow = 1;
    }

    public UnknownValue(String value, double num) {
        this.name = value;
        this.num = num;
        this.pow = 1;
    }

    public UnknownValue(double num) {
        this.name = "";
        this.num = num;
        this.pow = 0;
    }

    @Override
    public double asNumber() {
        try {
            return Double.parseDouble(name);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    @Override
    public String asString() {
        if (num == .0) return "0";
        if (pow == 0) return String.valueOf(num);
        return String.format("[%.2f*%s^%d]", num, name, pow);
    }

    @Override
    public String toString() {
        return asString();
    }

    @Override
    public Value mult(Value value) {
        return new UnknownValue(this.name, num * value.asNumber());
    }

    @Override
    public Value div(Value value) {
        return new UnknownValue(this.name, num / value.asNumber());
    }

    @Override
    public Value sub(Value value) {
        return this;
    }

    @Override
    public Value pow(Value value) {
        return new UnknownValue(this.name, Math.pow(num, value.asNumber()));
    }

    @Override
    public Value add(Value value) {
        return new UnknownValue(this.name + value.asString());
    }

    @Override
    public Value neg() {
        return new UnknownValue(this.name, -num);
    }
}
