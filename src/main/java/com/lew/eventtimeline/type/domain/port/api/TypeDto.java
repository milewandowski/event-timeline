package com.lew.eventtimeline.type.domain.port.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeDto {

    Long id;

    @NotBlank
    String name;

    @NotBlank
    String color;
}
