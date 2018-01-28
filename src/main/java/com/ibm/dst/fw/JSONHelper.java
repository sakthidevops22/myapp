package com.ibm.dst.fw;

import java.util.logging.Level;
import java.util.logging.Logger;


import com.ibm.juno.core.json.JsonParser;
import com.ibm.juno.core.json.JsonSerializer;
import com.ibm.juno.core.parser.ParseException;
import com.ibm.juno.core.serializer.SerializeException;

/**
 * JSON helper utility. This class mainly serializes and de-serialize java
 * objects to JSON and vice versa. The implementation is based on IBM JUNO
 * utilities
 * b
 */
public final class JSONHelper {
	private static final Logger LOGGER = Logger.getLogger(JSONHelper.class.getName());
	private static final JsonSerializer SERIALIZER = JsonSerializer.DEFAULT;
	private static final JsonParser PARSER = JsonParser.DEFAULT;

	/**
	 * Constructor made private to stop object instantiation 
	 */
	private JSONHelper() {
		super();
	}

	/**
	 * This method returns the JSON string for given input object
	 * 
	 * @param object
	 *            Object to serialized to JSON
	 * @return json String null in case of input is null/exception
	 */
	public static String toJSON(final Object object) {
		String jsonString = null;
		try	{
			if (object != null)	{
				jsonString = SERIALIZER.serialize(object);
			}
		} catch (SerializeException ex) {
			LOGGER.log(Level.WARNING, "JSON_UTIL:Error in serializing to json",
					ex);
			jsonString = null;

		}
		return jsonString;
	}

	/**
	 * Converts a JSON string to java object
	 * Usage:
	 * <code>
	 * 	MyBean bean = JSONHelper.parseJSON("<valid json string>",MyBean.class);
	 * </code>
	 * @param jsonString
	 *            Input JSON String
	 * @param type
	 *            Type of the class
	 * @return Java Object , null in case of exception
	 */
	public static <T> T parseJSON(final String jsonString, Class<T> type) {
		T retObject = null;
		try {
			retObject = PARSER.parse(jsonString, type);
		} catch (ParseException ex) {
			LOGGER.log(Level.WARNING, "JSON_UTIL:Error in de-serializing to object", ex);
			retObject = null;
		}
		return retObject;
	}

}
