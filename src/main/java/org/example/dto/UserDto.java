package org.example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    int id;
    String name;
    String password;
}
