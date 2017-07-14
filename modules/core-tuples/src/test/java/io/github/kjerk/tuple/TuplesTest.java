package io.github.kjerk.tuple;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TuplesTest {
	
	private interface TestData {
		String testString1 = "Hello World";
		String testString2 = "Goodbye World";
		String testString3 = "My god, it's full of stars.";
		// It's a difficult question as to whether these should be equality or reference compared as a stored var.
		byte[] testArray1 = new byte[]{0x15, 0x35, 0x55, 0x22};
		byte[] testArray2 = new byte[]{0x35, 0x55, 0x15, 0x22};
	}
	
	private Tuple2<String, String> getTestTuple2() {
		return Tuples.of(TestData.testString1, TestData.testString2);
	}
	
	@Test
	public void tuple1_Equality() {
		final String testString = "Hello World!";
		final Tuple1<String> testMonad = Tuples.of(testString);
		
		Assertions.assertEquals(testMonad, Tuples.of(testString));
		Assertions.assertEquals(testMonad.Item1, testString);
	}
	
	@Test
	public void tuple3_Equality() {
		final Tuple3<String, String, String> nameTuple1 = Tuples.of("John", "Missing", "Doe");
		final Tuple3<String, String, String> nameTuple2 = Tuples.of("Jane", "Absent", "Doe");
		
		Assertions.assertNotEquals(nameTuple1, nameTuple2);
		Assertions.assertEquals(nameTuple1.Item3, nameTuple2.Item3);
	}
	
	@Test
	public void tuple3_Variadic_Equality() {
		final String strValue = "Hello World!";
		final Integer intValue = 0xDEADBEEF;
		final LocalDate dateValue = LocalDate.parse("2015-01-01");
		final LocalDate dateValue2 = LocalDate.parse("2015-01-02").minusDays(1); // Same as above in equality but not reference.
		
		final Tuple3<String, Integer, LocalDate> testTuple = Tuples.of(strValue, intValue, dateValue);
		final Tuple3<String, Integer, LocalDate> testTupleSame = Tuples.of(strValue, intValue, dateValue2);
		final Tuple3<Integer, LocalDate, String> testTupleDiff = Tuples.of(intValue, dateValue, strValue);
		
		Assertions.assertEquals(testTuple, testTupleSame);
		Assertions.assertNotEquals(testTuple, testTupleDiff);
	}
	
	@Test
	public void tuple4_Complex_Variadic_Equality() {
		@Data
		class Person {
			public final String Name;
			public final Double Age;
		}
		final Person testPersonA = new Person("Friedrich Nietzsche", 45.0d);
		final Person testPersonB = new Person("Martin Heidegger", 0.1d); // 1889
		
		final List<Person> testPersons = Arrays.asList(testPersonA, testPersonB);
		
		Tuple4<String, List<Person>, byte[], Person> testTuple = Tuples.of(TestData.testString3, testPersons, TestData.testArray1, testPersonA);
		Tuple4<String, List<Person>, byte[], Person> testTupleSame = Tuples.of(TestData.testString3, testPersons, TestData.testArray1, testPersonA);
		Tuple4<String, List<Person>, byte[], Person> testTupleDiff = Tuples.of(TestData.testString3, testPersons, TestData.testArray2, testPersonA);
		
		Assertions.assertEquals(testTuple, testTupleSame);
		Assertions.assertNotEquals(testTuple, testTupleDiff);
	}
	
	@Test
	public void tuple2_toList() {
		final Tuple2<String, String> testTuple = getTestTuple2();
		
		List<Object> values = testTuple.toList();
		
		Assertions.assertEquals(values.size(), 2);
		Assertions.assertEquals(TestData.testString1, values.get(0));
		Assertions.assertEquals(TestData.testString2, values.get(1));
	}
	
	@Test
	public void tuple2_toMap() {
		final Tuple2<String, String> testTuple = getTestTuple2();
		
		Map<String, Object> values = testTuple.toMap();
		
		Assertions.assertEquals(values.size(), 2);
		
		Assertions.assertTrue(values.containsKey("First"));
		Assertions.assertTrue(values.containsKey("Second"));
		
		Assertions.assertEquals(values.get("First"), TestData.testString1);
		Assertions.assertEquals(values.get("Second"), TestData.testString2);
	}
	
}
