package ohm.softa.a09.model.Factory;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
	private Map<String, Flyweight> flyweights = new HashMap<>();

	Flyweight getFlyweight(String path) {
		if (flyweights.containsKey(path))
			return flyweights.get(path);

		// allocate new flyweight
		Flyweight fw = new Flyweight(path);
		flyweights.put(path, fw);

		return fw;
	}
}
