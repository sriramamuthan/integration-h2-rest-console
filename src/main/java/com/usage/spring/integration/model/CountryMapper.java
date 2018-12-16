package com.usage.spring.integration.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<Country> {
    @Override
    public Country mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Country(resultSet.getInt(1),resultSet.getString("name"), resultSet.getString(3), resultSet.getLong(4));
    }
}
