package com.bosonit.ConfigurationProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.util.unit.DataSize;

import java.time.Duration;
import java.time.Period;

@ConfigurationProperties(prefix= "converted")
@ConstructorBinding
public class ConvertedProperties {
    private Duration duration;
    private Period period;
    private DataSize datasize;

    private CustomProperty customProperty;


    public ConvertedProperties(Duration duration, Period period, DataSize datasize, CustomProperty customProperty) {
        this.duration = duration;
        this.period = period;
        this.datasize = datasize;
        this.customProperty = customProperty;
    }

    public Duration getDuration() {
        return duration;
    }

    public Period getPeriod() {
        return period;
    }

    public DataSize getDatasize() {
        return datasize;
    }

    public CustomProperty getCustomProperty() {
        return customProperty;
    }

    @Override
    public String toString() {
        return "ConvertedProperties{" +
                "duration=" + duration +
                ", period=" + period +
                ", datasize=" + datasize +
                '}';
    }
}
