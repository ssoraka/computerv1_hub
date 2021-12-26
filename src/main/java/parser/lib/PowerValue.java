//package parser.lib;
//
//public class PowerValue {
//    private int power = 1;
//    private int value = 0;
//    private String name = "";
//
//    public PowerValue(int power, int value, String name) {
//        if (value != 0) {
//            if (power == 0) {
//                value = 1;
//                name = "";
//            } else if (power == 2 && name.equals("")){
//                value = value * value;
//                power = 1;
//            }
//            this.power = power;
//            this.value = value;
//            this.name = name;
//        }
//    }
//
//    public PowerValue(int value) {
//        this.value = value;
//    }
//
//    public int getPower() {
//        return power;
//    }
//
//    public int getValue() {
//        return value;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void validate() {
//        if (power < 0 || power > 2) {
//            throw new NumberFormatException("степень не может быть " + power);
//        }
//    }
//
//    public PowerValue add(PowerValue elem2) {
//        if (power != elem2.power || !name.equal(elem2.name)) {
//            throw new RuntimeException("");
//        }
//        return new PowerValue(power, value + elem2.value, name);
//    }
//
//    public PowerValue sub(PowerValue elem2) {
//        if (power != elem2.power || !name.equal(elem2.name)) {
//            throw new RuntimeException("");
//        }
//        return new PowerValue(power, value - elem2.value, name);
//    }
//
//    public PowerValue mult(PowerValue elem2) {
//        if (power != elem2.power || !name.equal(elem2.name)) {
//            throw new RuntimeException("");
//        }
//        return new PowerValue(power, value * elem2.value, name);
//    }
//
//    public PowerValue div(PowerValue elem2) {
//        if (power != elem2.power || !name.equal(elem2.name) || elem2.value == 0) {
//            throw new RuntimeException("");
//        }
//        return new PowerValue(power, value / elem2.value, name);
//    }
//
//    public PowerValue pow(PowerValue elem2) {
//        if (!name.equal(elem2.name)) {
//            throw new RuntimeException("");
//        }
//        return new PowerValue(power + elem2.power, value * elem2.value, name);
//    }
//
//    @Override
//    public String toString() {
//        if (power == 0) {
//            return value + "";
//        } else if (value == 0) {
//            return "0";
//        } else {
//            return value + " * " + name + " ^ " + power;
//        }
//    }
//}
