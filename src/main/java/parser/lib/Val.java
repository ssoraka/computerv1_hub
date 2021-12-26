package parser.lib;

public class Val {
    private String name;
    private double num;
    private int pow;

    public Val(String value) {
        this.name = value;
        this.num = 1.0;
        this.pow = 1;
    }

    public Val(String value, double num) {
        this.name = value;
        this.num = num;
        this.pow = 1;
    }

    public Val(String value, double num, int pow) {
        this.name = value;
        this.num = num;
        this.pow = pow;
    }

    public Val(double num) {
        this.name = null;
        this.num = num;
        this.pow = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public int getPow() {
        return pow;
    }

    public void setPow(int pow) {
        this.pow = pow;
    }

    public Val neg() {
        return new Val(name, -num, pow);
    }

    public Val add(Val val) {
        return new Val(name, num + val.num, pow);
    }

    public Val sub(Val val) {
        return new Val(name, num - val.num, pow);
    }

    public Val mult(Val val) {
        String tmp = "".equals(name) ? val.name : name;
        return new Val(tmp, num * val.num, pow + val.pow);
    }

    public Val div(Val val) {
        String tmp = "".equals(name) ? val.name : name;
        return new Val(tmp, num / val.num, pow - val.pow);
    }
}
