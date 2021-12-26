package parser.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

public class MapValue implements Value {
    private static final Val ZERO = new Val(0.0);

    private Map<Integer, Val> map = new HashMap<>();

    public MapValue() {
        map.put(0, ZERO);
    }

    public MapValue(double num) {
        Val val = new Val(num);
        map.put(0, val);
    }

    public MapValue(String name) {
        map.put(1, new Val(name));
    }

    public MapValue(String name, double num) {
        map.put(1, new Val(name, num));
    }

    public MapValue(String name, double num, int pow) {
        map.put(pow, new Val(name, num, pow));
    }

    public MapValue(MapValue map2) {
        for (Val val : map2.map.values()) {
            map.put(val.getPow(), new Val(val.getName(), val.getNum(), val.getPow()));
        }
    }

    public void put(Val value, BiFunction<Val, Val, Val> func) {
        if (!map.containsKey(value.getPow())) {
            map.put(value.getPow(), value);
        } else {
            Val tmp = map.get(value.getPow());
            map.put(value.getPow(), func.apply(tmp, value));
        }
    }

    public MapValue neg() {
        MapValue mapValue = new MapValue();
        for (Val val : map.values()) {
            mapValue.put(val, Val::sub);
        }
        return mapValue;
    }

    public MapValue add(MapValue value) {
        for (Val val : map.values()) {
            put(val, Val::add);
        }
        return this;
    }

    public MapValue sub(MapValue value) {
        for (Val val : map.values()) {
            put(val, Val::sub);
        }
        return this;
    }

    public MapValue mult(MapValue value) {
        MapValue mapValue = new MapValue();
        for (Val v1 : map.values()) {
            for (Val v2 : value.map.values()) {
                mapValue.put(v1.mult(v2), Val::add);
            }
        }
        return mapValue;
    }

    public MapValue div(MapValue value) {
        if (value.map.size() != 1) throw new RuntimeException("Слишком сложное деление!!!");

        MapValue mapValue = new MapValue();
        for (Val val : map.values()) {
            mapValue.put(val, Val::div);
        }
        return this;
    }

    public MapValue pow(MapValue value) {
        if (value.map.size() != 1 || !value.map.containsKey(0)) throw new RuntimeException("Слишком сложное возведение в степень!!!");

        int power = (int) value.map.get(0).getNum();
        if (power == 0) return new MapValue();
        MapValue tmp = this;
        for (int i = 0; i < power; i++) {
            tmp = tmp.mult(this);
        }
        return this;
    }

    public double asNumber() {
        return map.getOrDefault(0, ZERO).getNum();
    }

    public String asString() {
        return toString();
    }

    public String toString() {
        if (!map.containsKey(0)) return "0";

        StringBuilder sb = new StringBuilder(map.get(0).toString());
        Set<Integer> set = map.keySet();
        set.remove(0);
        for (Integer i : set) {
            if (map.get(i).getNum() > 0) sb.append(" +");
            sb.append(map.get(i).toString());
        }
        return sb.toString();
    }


}

