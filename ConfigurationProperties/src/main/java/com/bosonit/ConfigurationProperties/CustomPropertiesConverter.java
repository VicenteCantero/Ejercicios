package com.bosonit.ConfigurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class CustomPropertiesConverter implements Converter<String, CustomProperty> {

    @Override
    public CustomProperty convert(String source) {
        final String[] fields= source.split(",");
        return new CustomProperty(fields[0], Boolean.valueOf(fields[1]));
    }
}
