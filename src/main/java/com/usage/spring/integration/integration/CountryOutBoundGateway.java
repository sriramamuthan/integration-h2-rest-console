package com.usage.spring.integration.integration;

import com.usage.spring.integration.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.http.outbound.HttpRequestExecutingMessageHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryOutBoundGateway {

    @Autowired
    @Qualifier("responseChannel")
    private MessageChannel messageChannel;

    @ServiceActivator(inputChannel = "inputChannel")
    public void getCountries(Message<?> message) {
        List<Country> countryList =(List)message.getPayload();
        for(Country country : countryList) {
         HttpRequestExecutingMessageHandler handler = new HttpRequestExecutingMessageHandler("http://localhost:8080/countries/"+country.getId());
            handler.setHttpMethod(HttpMethod.GET);
            handler.setExpectedResponseType(Country.class);
            handler.setOutputChannel(messageChannel);
            handler.handleMessage(MessageBuilder.withPayload(country).build());
        }
    }

}
