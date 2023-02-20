package org.example.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.dto.UserDto;
import org.springframework.stereotype.Component;

import java.io.Closeable;

/**
 * Имитурем подключение к бд
 */
@Component
@Data
public class ConnectionTest implements Closeable {
    String url;
    String user;
    String password;
    String bdName;

    public ConnectionTest(ConnectionConfig config) {
        this.url = config.getUrl();
        this.user = config.getUser();
        this.password = config.getPassword();
        this.bdName = config.getBdName();
    }

    @Override
    public void close() {
        System.out.println("Соединение разорвано");
    }

    public UserDto sendCommand(String command) {
        return UserDto.builder()
                .id(3)
                .name("Test Name")
                .password("123435")
                .build();
    }
}
