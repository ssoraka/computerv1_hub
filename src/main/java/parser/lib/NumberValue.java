//package parser.lib;
//
//import java.lang.Math;
//
//public class NumberValue implements Value {
//    public static final NumberValue ZERO = new NumberValue(0.0);
//    final private double value;
//
//    public NumberValue(boolean value) {
//        this.value = (value) ? 1.0 : 0.0;
//    }
//
//    public NumberValue(double value) {
//        this.value = value;
//    }
//
//    @Override
//    public double asNumber() {
//        return value;
//    }
//
//    @Override
//    public String asString() {
//        return Double.toString(value);
//    }
//
//    @Override
//    public Value mult(Value value) {
//        return new NumberValue(this.value * value.asNumber());
//    }
//
//    @Override
//    public Value div(Value value) {
//        return new NumberValue(this.value / value.asNumber());
//    }
//
//    @Override
//    public Value sub(Value value) {
//        return new NumberValue(this.value - value.asNumber());
//    }
//
//    @Override
//    public Value pow(Value value) {
//        return new NumberValue(Math.pow(this.value, value.asNumber()));
//    }
//
//    @Override
//    public Value add(Value value) {
//        return new NumberValue(this.value + value.asNumber());
//    }
//
//    @Override
//    public Value neg() {
//        return new NumberValue(-value);
//    }
//
//    @Override
//    public String toString() {
//        return asString();
//    }
//}
