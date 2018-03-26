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
import io.github.kjerk.tuple.Tuple2;

import java.io.IOException;

public class Tuple2Deserializer extends StdDeserializer<Tuple2<?, ?>> implements ContextualDeserializer {
	
	private JavaType contextType;
	private JavaType[] boundTypes;
	
	public Tuple2Deserializer() {
		super(Tuple2.class);
	}
	
	public Tuple2Deserializer(JavaType contextType) {
		super(contextType);
		this.contextType = contextType;
		final TypeBindings bindings = this.contextType.getBindings();
		if(bindings != null && bindings.size() == 2) {
			boundTypes = new JavaType[2];
			boundTypes[0] = bindings.getBoundType(0);
			boundTypes[1] = bindings.getBoundType(1);
		}
	}
	
	@Override
	public JsonDeserializer<?> createContextual(DeserializationContext context, BeanProperty prop) throws JsonMappingException {
		return new Tuple2Deserializer(context.getContextualType());
	}
	
	@Override
	public Tuple2<?, ?> deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException, JsonProcessingException {
		final Object[] resultValues = new Object[2];
		
		while(jsonParser.hasCurrentToken()) {
			if(jsonParser.currentToken() == JsonToken.FIELD_NAME) {
				if(jsonParser.currentName().equals("Item1")) {
					jsonParser.nextValue();
					resultValues[0] = jsonParser.getCodec().readValue(jsonParser, boundTypes[0]);
				} else if(jsonParser.currentName().equals("Item2")) {
					jsonParser.nextValue();
					resultValues[1] = jsonParser.getCodec().readValue(jsonParser, boundTypes[1]);
				}
			}
			jsonParser.nextToken();
			if(jsonParser.currentToken() == JsonToken.END_OBJECT) {
				break;
			}
		}
		return new Tuple2<>(resultValues[0], resultValues[1]);
	}
}
