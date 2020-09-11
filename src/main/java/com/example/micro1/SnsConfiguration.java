package com.example.micro1;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnsConfiguration {

    private final String AWS_REGION="us-east-1";

    @Value("${sns.endpoint}")
    private String snsEndpoint;

    @Bean
    public AmazonSNS AmazonSns() {
        return AmazonSNSAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(snsEndpoint, AWS_REGION))
                .build();
    }
}
