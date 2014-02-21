package net.cbeyond.service.provider.custom;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class CustomJacksonJSONProvider extends JacksonJaxbJsonProvider {

	@SuppressWarnings("deprecation")
	public CustomJacksonJSONProvider() throws JsonMappingException {
		configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		configure(DeserializationConfig.Feature.AUTO_DETECT_FIELDS, true);
		configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    configure(SerializationConfig.Feature.USE_ANNOTATIONS, true);
	    configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false);
	    configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, false);
	    /**
	     * The proper way to do this is as follows to avoid issues with depreciation:
	     * 
	     * SerializationConfig.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL)
	     * 
	     * In the interest of functionality, the depreciate feature will be used until this is updated
	     */
	    configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);


	    _mapperConfig.getConfiguredMapper().setAnnotationIntrospector(new JaxbAnnotationIntrospector());
	}	
}
