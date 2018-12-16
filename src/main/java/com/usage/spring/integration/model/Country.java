package com.usage.spring.integration.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = {"id"})
public class Country {
    @Id
    private Integer id;
    private String name;
    private String isoCode;

    public Country(Integer id, String name, String isoCode, Long population) {
        this.id = id;
        this.name = name;
        this.isoCode = isoCode;
        this.population = population;
    }

    private Long population;

    public Country(String name, String isoCode, Long population) {
        this.name = name;
        this.isoCode = isoCode;
        this.population = population;
    }




}
