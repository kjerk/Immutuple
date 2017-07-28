package io.github.kjerk.tuple;

/**
 * This class is of course ridiculous, but for completeness sake as well as the sanity of future code which
 * might be instantiating tuple classes dynamically via utility or otherwise, this should exist as a 
 * safety measure and sanity keeper.
 */
public class Tuple0<T> implements BaseTuple {
	
	@Override
	public int getArity() {
		return 0;
	}
	
	@Override
	public Object[] toArray() {
		return new Object[0];
	}
	
}
