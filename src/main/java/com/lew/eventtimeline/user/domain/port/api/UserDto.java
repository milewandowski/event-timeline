package com.lew.eventtimeline.user.domain.port.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class UserDto {

    Long id;

    @NotBlank
    String username;

    @NotBlank
    String password;

    String role;
    String[] authorities;
    boolean isActive;
    boolean isNotLocked;
}
