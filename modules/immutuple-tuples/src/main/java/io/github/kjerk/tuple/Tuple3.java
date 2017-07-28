package io.github.kjerk.tuple;

import lombok.Data;

@Data
public class Tuple3<T1, T2, T3> implements BaseTuple {
	public final T1 Item1;
	public final T2 Item2;
	public final T3 Item3;
	
	@Override
	public int getArity() {
		return 3;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{Item1, Item2, Item3};
	}
	
}
