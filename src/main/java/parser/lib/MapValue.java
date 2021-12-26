package parser.lib;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapValue {

    private Map<Integer, Val> map = new HashMap<>();

    public MapValue() {
    }

    public void put(Val value, BiFunction<Val, Val, Val> func) {
        if (!map.containsKey(value.getPow())) {
            map.put(value.getPow(), value);
        } else {
            Val tmp = map.get(value.getPow());
            map.put(value.getPow(), func.apply(tmp, value));
        }
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
}

