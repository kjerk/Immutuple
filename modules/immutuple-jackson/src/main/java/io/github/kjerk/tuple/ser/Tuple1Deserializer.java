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
import io.github.kjerk.tuple.Tuple1;

import java.io.IOException;

public class Tuple1Deserializer extends StdDeserializer<Tuple1<?>> implements ContextualDeserializer {
	
	private JavaType contextType;
	private JavaType boundType;
	
	public Tuple1Deserializer() {
		super(Tuple1.class);
	}
	
	public Tuple1Deserializer(JavaType contextType) {
		super(contextType);
		this.contextType = contextType;
		final TypeBindings bindings = this.contextType.getBindings();
		if(bindings != null && bindings.size() == 1) {
			boundType = bindings.getBoundType(0);
		}
	}
	
	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty prop) throws JsonMappingException {
		return new Tuple1Deserializer(context.getContextualType());
	}
	
	@Override
	public Tuple1<?> deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		Object resultValue = null;
		
		while(jsonParser.hasCurrentToken()) {
			if(jsonParser.currentToken() == JsonToken.FIELD_NAME) {
				if(jsonParser.currentName().equals("Item1")) {
					jsonParser.nextValue();
					resultValue = jsonParser.getCodec().readValue(jsonParser, boundType);
				}
			}
			jsonParser.nextToken();
			if(jsonParser.currentToken() == JsonToken.END_OBJECT) {
				break;
			}
		}
		return new Tuple1<>(resultValue);
	}
}
