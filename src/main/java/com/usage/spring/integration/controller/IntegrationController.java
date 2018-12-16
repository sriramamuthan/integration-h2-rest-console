package com.usage.spring.integration.controller;

import com.usage.spring.integration.integration.CountryOutBoundGateway;
import com.usage.spring.integration.model.Country;
import com.usage.spring.integration.repository.CountryRepository;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntegrationController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryOutBoundGateway countryOutBoundGateway;

    @GetMapping("/countries")
    public List<Country> countries(){
        return IteratorUtils.toList(countryRepository.findAll().iterator());
    }

    @GetMapping("/countries/{id}")
    public Country country(@PathVariable("id") Integer countryId){
        return countryRepository.findById(countryId).get();
    }

    @PutMapping("country")
    public Country put(@RequestParam("name") String name, @RequestParam("isoCode") String isoCode, @RequestParam("population") Long population){
        return countryRepository.save(new Country(name, isoCode, population));
    }
}
