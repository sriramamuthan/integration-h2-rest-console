package com.usage.spring.integration.integration;

import com.usage.spring.integration.model.Country;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ResponsePrinter {

    @ServiceActivator(inputChannel = "responseChannel")
    public void responsePrinter(Message<Country> responseEntity){
        System.out.println(responseEntity.getPayload().getName());
    }
}
