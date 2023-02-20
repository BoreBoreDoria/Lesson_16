package org.example.dao;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope(scopeName = "prototype")
@Data
public class PrototypeTest {
        String test;

    public PrototypeTest() {
        test = "Test";
    }
}
