package com.usage.spring.integration.repository;

import com.usage.spring.integration.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {


}
