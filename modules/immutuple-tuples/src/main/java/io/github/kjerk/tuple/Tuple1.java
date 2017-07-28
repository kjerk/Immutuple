package io.github.kjerk.tuple;

import lombok.Data;

@Data
public class Tuple1<T> implements BaseTuple {
	public final T Item1;
	
	@Override
	public int getArity() {
		return 1;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{Item1};
	}
	
}
