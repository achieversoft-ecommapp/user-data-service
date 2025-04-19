package com.achieversoft.ecommapp.userdata.config;

import brave.baggage.BaggageFields;
import brave.baggage.CorrelationScopeConfig;
import brave.baggage.CorrelationScopeCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BraveConfig {
    @Bean
    public CorrelationScopeCustomizer parentIdCustomizer() {
        return builder -> builder.add(
                CorrelationScopeConfig.SingleCorrelationField.newBuilder(BaggageFields.PARENT_ID)
                        .name("parentId")
                        .build()
        );
    }
}

