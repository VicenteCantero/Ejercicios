package com.bosonit.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("javaguides")
                //.partitions(10)
                .build();
    }
}

//https://www.youtube.com/watch?v=INLg-VHFvcY&list=PLGRDMO4rOGcNLwoack4ZiTyewUcF6y6BU&index=7
