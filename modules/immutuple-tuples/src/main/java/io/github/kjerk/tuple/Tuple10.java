package io.github.kjerk.tuple;

import lombok.Data;

@Data
public class Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> implements BaseTuple {
	public final T1  Item1;
	public final T2  Item2;
	public final T3  Item3;
	public final T4  Item4;
	public final T5  Item5;
	public final T6  Item6;
	public final T7  Item7;
	public final T8  Item8;
	public final T9  Item9;
	public final T10 Item10;
	
	@Override
	public int getArity() {
		return 10;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10};
	}
	
}
