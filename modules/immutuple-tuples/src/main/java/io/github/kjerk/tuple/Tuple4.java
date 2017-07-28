package io.github.kjerk.tuple;

import lombok.Data;

@Data
public class Tuple4<T1, T2, T3, T4> implements BaseTuple {
	public final T1 Item1;
	public final T2 Item2;
	public final T3 Item3;
	public final T4 Item4;
	
	@Override
	public int getArity() {
		return 4;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{Item1, Item2, Item3, Item4};
	}
	
}
