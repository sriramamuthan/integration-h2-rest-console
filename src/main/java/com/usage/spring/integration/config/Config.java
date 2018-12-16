package com.usage.spring.integration.config;

import com.usage.spring.integration.model.Country;
import com.usage.spring.integration.model.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.jdbc.JdbcPollingChannelAdapter;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DirectChannel inputChannel(){
        return new DirectChannel();
    }

    @Bean
    public DirectChannel restChannel(){
        return new DirectChannel();
    }

    @Bean
    public DirectChannel responseChannel(){
        return new DirectChannel();
    }

    @Autowired
    private DataSource datasource;

    @InboundChannelAdapter(value = "inputChannel",
            poller = @Poller(fixedDelay = "200000"))
    @Bean
    public MessageSource<Object> source(){
        JdbcPollingChannelAdapter jdbcPollingChannelAdapter = new JdbcPollingChannelAdapter(datasource , "select * from country");
        jdbcPollingChannelAdapter.setRowMapper(new CountryMapper());
        return jdbcPollingChannelAdapter;
    }

}


