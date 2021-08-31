package parser.lib;

package parser.lib;

import java.util.HashMap;
import java.util.Map;

public class MapValue {
    private Map<Integer, PowerValue> map = new HashMap<>();

    public MapValue(Map<Integer, PowerValue> map) {
        this.map = map;
    }

    public MapValue(MapValue map) {

    }

    public Map<Integer, PowerValue> getMap() {
        return map;
    }

    public void add(PowerValue value) {
        if (!map.containsKey(value.getPower())) {
            map.put(value.getPower(), value);
        } else {
            PowerValue tmp = map.get(value.getPower());
            if (tmp.getName().equal(value.getName())) {
                map.put(value.getPower(), new PowerValue(value.getPower(), value.getValue() + tmp.getValue(), value.getName()));
            } else {
                throw new RuntimeException("сложение разных неизвестных");
            }
        }
    }

    public MapValue add(MapValue value) {

    }

    public MapValue sub(MapValue value) {

    }

    public MapValue mult(MapValue value) {

    }

    public MapValue div(MapValue value) {

    }
}

