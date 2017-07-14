package io.github.kjerk.tuple;

import lombok.Data;

@Data
public class Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> implements BaseTuple {
	public final T1 Item1;
	public final T2 Item2;
	public final T3 Item3;
	public final T4 Item4;
	public final T5 Item5;
	public final T6 Item6;
	public final T7 Item7;
	public final T8 Item8;
	public final T9 Item9;
	public final T10 Item10;
	public final T11 Item11;
	public final T12 Item12;
	public final T13 Item13;
	public final T14 Item14;
	public final T15 Item15;
	public final T16 Item16;
	
	@Override
	public int getArity() {
		return 16;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[]{
			Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10, Item11, Item12, Item13, Item14, Item15, Item16
		};
	}
	
}
