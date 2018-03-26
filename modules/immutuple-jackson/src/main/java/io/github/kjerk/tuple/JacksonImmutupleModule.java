package io.github.kjerk.tuple;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleSerializers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JacksonImmutupleModule extends Module {
	
	@Override
	public String getModuleName() {
		return "Immutuple Module";
	}
	
	@Override
	public Version version() {
		return new Version(
			1,
			1,
			1,
			"idk",
			"io.github.kjerk",
			"immutuple-jackson"
		);
	}
	
	@Override
	public void setupModule(SetupContext context) {
		addDeserializers(context);
		addMixins(context);
		addSerializers(context);
	}
	
	private void addSerializers(SetupContext context) {
		List<JsonSerializer<?>> jsonSerializers = new ArrayList<>();
		// TODO: Add serializers
		context.addSerializers(new SimpleSerializers(jsonSerializers));
	}
	
	private void addDeserializers(SetupContext context) {
		Map<Class<?>, JsonDeserializer<?>> deserializerMap = new HashMap<>();
		
		deserializerMap.put(BaseTuple.class, new TupleDeserializer());
		
		deserializerMap.put(Tuple0.class, new TupleDeserializer(0));
		deserializerMap.put(Tuple1.class, new TupleDeserializer(1));
		deserializerMap.put(Tuple2.class, new TupleDeserializer(2));
		deserializerMap.put(Tuple3.class, new TupleDeserializer(3));
		deserializerMap.put(Tuple4.class, new TupleDeserializer(4));
		deserializerMap.put(Tuple5.class, new TupleDeserializer(5));
		deserializerMap.put(Tuple6.class, new TupleDeserializer(6));
		deserializerMap.put(Tuple7.class, new TupleDeserializer(7));
		deserializerMap.put(Tuple8.class, new TupleDeserializer(8));
		deserializerMap.put(Tuple9.class, new TupleDeserializer(9));
		deserializerMap.put(Tuple10.class, new TupleDeserializer(10));
		deserializerMap.put(Tuple11.class, new TupleDeserializer(11));
		deserializerMap.put(Tuple12.class, new TupleDeserializer(12));
		deserializerMap.put(Tuple13.class, new TupleDeserializer(13));
		deserializerMap.put(Tuple14.class, new TupleDeserializer(14));
		deserializerMap.put(Tuple15.class, new TupleDeserializer(15));
		deserializerMap.put(Tuple16.class, new TupleDeserializer(16));
		
		// TODO: Add deserializers
		context.addDeserializers(new SimpleDeserializers(deserializerMap));
	}
	
	private void addMixins(SetupContext context) {
		// TODO: Not sure if you can add mixins at the module level. I want to add PROVIDED mixins
		// that are used until you write your own mixin, right?
	}
	
}
