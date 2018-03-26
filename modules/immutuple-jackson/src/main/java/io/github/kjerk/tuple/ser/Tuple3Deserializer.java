package io.github.kjerk.tuple.ser;

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
import io.github.kjerk.tuple.Tuple3;

import java.io.IOException;

public class Tuple3Deserializer extends StdDeserializer<Tuple3<?, ?, ?>> implements ContextualDeserializer {
	private JavaType contextType;
	private JavaType[] boundTypes;
	
	public Tuple3Deserializer() {
		super(Tuple3.class);
	}
	
	public Tuple3Deserializer(JavaType contextType) {
		super(contextType);
		this.contextType = contextType;
		final TypeBindings bindings = this.contextType.getBindings();
		if(bindings != null && bindings.size() == 3) {
			boundTypes = new JavaType[3];
			boundTypes[0] = bindings.getBoundType(0);
			boundTypes[1] = bindings.getBoundType(1);
			boundTypes[2] = bindings.getBoundType(2);
		}
	}
	
	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty prop) throws JsonMappingException {
		return new Tuple3Deserializer(context.getContextualType());
	}
	
	@Override
	public Tuple3<?, ?, ?> deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		final Object[] resultValues = new Object[3];
		
		while(jsonParser.hasCurrentToken()) {
			if(jsonParser.currentToken() == JsonToken.FIELD_NAME) {
				switch(jsonParser.currentName()) {
					case "Item1":
						jsonParser.nextValue();
						resultValues[0] = jsonParser.getCodec().readValue(jsonParser, boundTypes[0]);
					break;
					case "Item2":
						jsonParser.nextValue();
						resultValues[1] = jsonParser.getCodec().readValue(jsonParser, boundTypes[1]);
					break;
					case "Item3":
						jsonParser.nextValue();
						resultValues[2] = jsonParser.getCodec().readValue(jsonParser, boundTypes[2]);
					break;
				}
			}
			jsonParser.nextToken();
			if(jsonParser.currentToken() == JsonToken.END_OBJECT) {
				break;
			}
		}
		return new Tuple3<>(resultValues[0], resultValues[1], resultValues[2]);
	}
	
}
