package com.usage.spring.integration;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration("classpath:http-outbound-gateway.xml")
public class HttpOutboundGatewayTests {

        @Autowired
        @Qualifier("quakeinfo.channel")
        PollableChannel quakeinfoChannel;

        @Test
        public void testHttpOutbound() {
            Message<?> message = quakeinfoChannel.receive();
            assertThat(message.getPayload(), is(notNullValue()));
        }

}
