package org.example.config;

import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@Value
public class DataSource {
    ConnectionConfig connectionConfig;

    public ConnectionTest getConnection() {
        return new ConnectionTest(connectionConfig);
    }
}
