package io.github.kjerk.tuple;

public interface Tuples {
	
	static <T> Tuple0<T> of() {
		return new Tuple0<>();
	}
	
	static <T> Tuple1<T> of(T item1) {
		return new Tuple1<>(item1);
	}
	
	static <T1, T2> Tuple2<T1, T2> of(T1 item1, T2 item2) {
		return new Tuple2<>(item1, item2);
	}
	
	static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 item1, T2 item2, T3 item3) {
		return new Tuple3<>(item1, item2, item3);
	}
	
	static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 item1, T2 item2, T3 item3, T4 item4) {
		return new Tuple4<>(item1, item2, item3, item4);
	}
	
	static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5) {
		return new Tuple5<>(item1, item2, item3, item4, item5);
	}
	
	static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6) {
		return new Tuple6<>(item1, item2, item3, item4, item5, item6);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7) {
		return new Tuple7<>(item1, item2, item3, item4, item5, item6, item7);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8> Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8) {
		return new Tuple8<>(item1, item2, item3, item4, item5, item6, item7, item8);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9) {
		return new Tuple9<>(item1, item2, item3, item4, item5, item6, item7, item8, item9);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9, T10 item10) {
		return new Tuple10<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9, T10 item10, T11 item11) {
		return new Tuple11<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9, T10 item10, T11 item11, T12 item12) {
		return new Tuple12<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9, T10 item10, T11 item11, T12 item12, T13 item13) {
		return new Tuple13<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9, T10 item10, T11 item11, T12 item12, T13 item13, T14 item14) {
		return new Tuple14<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9, T10 item10, T11 item11, T12 item12, T13 item13, T14 item14, T15 item15) {
		return new Tuple15<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15);
	}
	
	static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> of(T1 item1, T2 item2, T3 item3, T4 item4, T5 item5, T6 item6, T7 item7, T8 item8, T9 item9, T10 item10, T11 item11, T12 item12, T13 item13, T14 item14, T15 item15, T16 item16) {
		return new Tuple16<>(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15, item16);
	}
	
}
