package io.github.kjerk.tuple;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.kjerk.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class DeserializerTest {
	
	private final String testData = "{" +
		"\"Item1\": \"Hello World\"," +
		"\"Item2\": 5.5" +
		"}";
	
	private final String testData2 = "{" +
		"\"Item1\": \"Hello World\"," +
		"\"Item2\": [ 1, 2, 3, 4 ]" +
		"}";
	
	private ObjectMapper objectMapper;
	
	@BeforeEach
	public void initObjectMapper() {
		objectMapper = new ObjectMapper();
	}
	
	@Test
	public void testAddModule() {
		final Tuple2<String, Double> testTuple = Tuples.of("Hello", 5.0d);
		
		final JavaType tupleType = objectMapper.getTypeFactory().constructParametricType(Tuple2.class, String.class, Double.class);
		
		Assertions.assertFalse(objectMapper.canDeserialize(tupleType));
		
		objectMapper.registerModule(new JacksonImmutupleModule());
		
		Assertions.assertTrue(objectMapper.canDeserialize(tupleType));
	}
	
	@Test
	public void testDeserializetestData() throws IOException {
		objectMapper.registerModule(new JacksonImmutupleModule());
		TypeReference<Tuple2<String, Double>> tupleRef = new TypeReference<Tuple2<String, Double>>() {};
		final Tuple2<String, Double> testTuple2 = objectMapper.readValue(testData, tupleRef);
		System.out.println(testTuple2);
	}
	
	@Test
	public void testDeserializetestData2() throws IOException {
		objectMapper.registerModule(new JacksonImmutupleModule());
		TypeReference<Tuple2<String, Double[]>> tupleRef = new TypeReference<Tuple2<String, Double[]>>() {};
		final Tuple2<String, Double> testTuple2 = objectMapper.readValue(testData2, tupleRef);
		System.out.println(testTuple2);
	}
	
	@Test
	public void tuple3_TestDeserializeComplex() throws IOException {
		objectMapper.registerModule(new JacksonImmutupleModule());
		String inputJson = TestUtils.readResourceAsString("testjson/Tuple3_Complex.json");
		
		TypeReference<Tuple3<Double[], List<Tuple1<String>>, Tuple3<String[], String[], BigInteger[]>>> tupleRef = new TypeReference<Tuple3<Double[], List<Tuple1<String>>, Tuple3<String[], String[], BigInteger[]>>>() {};
		
		// Dear god, what has science done.
		Tuple3<Double[], List<Tuple1<String>>, Tuple3<String[], String[], BigInteger[]>> complexTuple = objectMapper.readValue(inputJson, tupleRef);
		
		Assertions.assertNotNull(complexTuple);
		
		Assertions.assertNotNull(complexTuple.Item1);
		Assertions.assertEquals(complexTuple.Item1.length, 5);
		Assertions.assertEquals(complexTuple.Item1[0], Double.valueOf(1));
		Assertions.assertEquals(complexTuple.Item1[4], Double.valueOf(5));
		
		Assertions.assertNotNull(complexTuple.Item2);
		Assertions.assertEquals(complexTuple.Item2.size(), 2);
		Assertions.assertEquals(complexTuple.Item2.get(1).Item1, "TestValue2");
		
		Assertions.assertNotNull(complexTuple.Item3);
		Assertions.assertNotNull(complexTuple.Item3.Item1);
		Assertions.assertNotNull(complexTuple.Item3.Item2);
		Assertions.assertNotNull(complexTuple.Item3.Item3);
		Assertions.assertEquals(complexTuple.Item3.Item1.length, 2);
		Assertions.assertEquals(complexTuple.Item3.Item2.length, 2);
		Assertions.assertEquals(complexTuple.Item3.Item3.length, 5);
		Assertions.assertEquals(complexTuple.Item3.Item1[1], "Values");
		Assertions.assertEquals(complexTuple.Item3.Item2[0], "Please");
		Assertions.assertEquals(complexTuple.Item3.Item3[2], BigInteger.valueOf(3L));
	}
	
}
