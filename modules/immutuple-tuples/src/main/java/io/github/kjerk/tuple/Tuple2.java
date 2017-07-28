package io.github.kjerk.tuple;

import lombok.Data;

@Data
public class Tuple2<T1, T2> implements BaseTuple {
	public final T1 Item1;
	public final T2 Item2;
	
	@Override
	public int getArity() {
		return 2;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{Item1, Item2};
	}
	
}
