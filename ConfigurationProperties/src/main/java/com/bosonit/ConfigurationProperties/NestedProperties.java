package com.bosonit.ConfigurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix="nested")
@ConstructorBinding
public class NestedProperties {
    private final List<String> strings;
    private final Map<String,String> dictionary;
    private final Item item;

    public NestedProperties(List<String> strings, Map<String, String> dictionary, Item item) {
        this.strings = strings;
        this.dictionary = dictionary;
        this.item = item;
    }

    @Override
    public String toString() {
        return "NestedProperties{" +
                "strings=" + strings +
                ", dictionary=" + dictionary +
                ", item=" + item +
                '}';
    }
}
