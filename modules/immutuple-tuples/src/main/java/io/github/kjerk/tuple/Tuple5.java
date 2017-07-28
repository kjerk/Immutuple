package io.github.kjerk.tuple;

import lombok.Data;

@Data
public class Tuple5<T1, T2, T3, T4, T5> implements BaseTuple {
	public final T1 Item1;
	public final T2 Item2;
	public final T3 Item3;
	public final T4 Item4;
	public final T5 Item5;
	
	@Override
	public int getArity() {
		return 5;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{Item1, Item2, Item3, Item4, Item5};
	}
	
}
