package org.example.dao;

import lombok.Value;
import org.example.config.ConnectionTest;
import org.example.config.DataSource;
import org.example.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
@Value
public class UserDao {

    DataSource dataSource;

    public UserDto findById(Integer id) {
        try (ConnectionTest connectionTest = dataSource.getConnection()) {
            return connectionTest.sendCommand("GET USER BY " + id);
        }
    }

    public UserDto findAll() {
        try (ConnectionTest connectionTest = dataSource.getConnection()) {
            return connectionTest.sendCommand("GET ALL USER BY ");
        }
    }

}
