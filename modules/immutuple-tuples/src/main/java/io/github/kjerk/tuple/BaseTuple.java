package io.github.kjerk.tuple;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

interface BaseTuple {
	
	String[] defaultNames = {
		"First", "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth",
		"Ninth", "Tenth", "Eleventh", "Twelfth", "Thirteenth", "Fourteenth", "Fifteenth", "Sixteenth"
	};
	
	int getArity();
	
	Object[] toArray();
	
	default List<Object> toList() {
		return Arrays.asList(this.toArray());
	}
	
	default Map<String, Object> toMap() {
		Map<String, Object> valueMap = new HashMap<>();
		Object[] valueArray = this.toArray();
		for(int i = 0; i < valueArray.length; i++) {
			valueMap.put(defaultNames[i], valueArray[i]);
		}
		return valueMap;
	}
	
	default Set<Object> toSet() {
		Set<Object> valueSet = new HashSet<>();
		Collections.addAll(valueSet, this.toArray());
		return valueSet;
	}
	
}
