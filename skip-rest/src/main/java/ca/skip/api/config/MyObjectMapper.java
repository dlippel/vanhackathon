package ca.skip.api.config;

import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class MyObjectMapper extends ObjectMapper {

	public static final MyObjectMapper SINGLETON = new MyObjectMapper();

	private MyObjectMapper() { // registerModule(new Jdk8Module()); //
		// registerModule(new JavaTimeModule());
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		setSerializationInclusion(JsonInclude.Include.NON_NULL);
		setTimeZone(TimeZone.getDefault());

		final SimpleModule sm = new SimpleModule();
		registerModule(sm);
	}

}
