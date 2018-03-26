package io.github.kjerk.tuple;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.type.TypeBindings;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TupleDeserializer extends StdDeserializer<BaseTuple> implements ContextualDeserializer {
	
	final TypeBindings bindings;
	private JavaType contextType;
	private int arity = -1;
	
	public TupleDeserializer() {
		super(BaseTuple.class);
		this.bindings = null;
	}
	
	public TupleDeserializer(int arity) {
		super(BaseTuple.class);
		this.arity = arity;
		this.bindings = null;
	}
	
	public TupleDeserializer(JavaType contextType) {
		super(contextType);
		this.contextType = contextType;
		this.bindings = this.contextType.getBindings();
		if(this.arity == -1) {
			this.arity = determineArity(this.contextType);
		}
	}
	
	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty prop) throws JsonMappingException {
		return new TupleDeserializer(context.getContextualType());
	}
	
	@Override
	public BaseTuple deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		Object[] resultValues = new Object[arity];
		int foundProperties = 0;
		
		while(jsonParser.hasCurrentToken() || foundProperties < arity) {
			if(jsonParser.currentToken() == JsonToken.FIELD_NAME) {
				if(jsonParser.currentName().startsWith("Item")) {
					int pos = Integer.valueOf(jsonParser.currentName().substring(4)) - 1;
					jsonParser.nextValue();
					resultValues[pos] = jsonParser.getCodec().readValue(jsonParser, bindings.getBoundType(pos));
					foundProperties++;
				}
			}
			jsonParser.nextToken();
			if(jsonParser.currentToken() == JsonToken.END_OBJECT) {
				break;
			}
		}
		return createTupleOfArity(arity, resultValues);
	}
	
	private static Map<Class<?>, Integer> arityMap = new HashMap<>();
	
	static {
		arityMap.put(Tuple0.class, 0);
		arityMap.put(Tuple1.class, 1);
		arityMap.put(Tuple2.class, 2);
		arityMap.put(Tuple3.class, 3);
		arityMap.put(Tuple4.class, 4);
		arityMap.put(Tuple5.class, 5);
		arityMap.put(Tuple6.class, 6);
		arityMap.put(Tuple7.class, 7);
		arityMap.put(Tuple8.class, 8);
		arityMap.put(Tuple9.class, 9);
		arityMap.put(Tuple10.class, 10);
		arityMap.put(Tuple11.class, 11);
		arityMap.put(Tuple12.class, 12);
		arityMap.put(Tuple13.class, 13);
		arityMap.put(Tuple14.class, 14);
		arityMap.put(Tuple15.class, 15);
		arityMap.put(Tuple16.class, 16);
	}
	
	public int determineArity(JavaType fromType) {
		return arityMap.getOrDefault(fromType.getRawClass(), -1);
	}
	
	public BaseTuple createTupleOfArity(int arity, Object[] values) {
		BaseTuple result;
		switch(arity) {
			case 0:
				result = Tuples.of();
				break;
			case 1:
				result = Tuples.of(values[0]);
				break;
			case 2:
				result = Tuples.of(values[0], values[1]);
				break;
			case 3:
				result = Tuples.of(values[0], values[1], values[2]);
				break;
			case 4:
				result = Tuples.of(values[0], values[1], values[2], values[3]);
				break;
			case 5:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4]);
				break;
			case 6:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5]);
				break;
			case 7:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6]);
				break;
			case 8:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7]);
				break;
			case 9:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8]);
				break;
			case 10:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9]);
				break;
			case 11:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10]);
				break;
			case 12:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11]);
				break;
			case 13:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12]);
				break;
			case 14:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13]);
				break;
			case 15:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14]);
				break;
			case 16:
				result = Tuples.of(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14], values[15]);
				break;
			default:
				throw new IllegalArgumentException(String.format("No tuples of arity %s exist", arity));
		}
		return result;
	}
	
}
