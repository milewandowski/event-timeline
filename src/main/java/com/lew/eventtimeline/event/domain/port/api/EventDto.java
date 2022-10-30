package com.lew.eventtimeline.event.domain.port.api;

import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Validated
public class EventDto {

    Long id;

    @NotBlank
    String name;

    @NotBlank
    String shortDesc;

    @NotBlank
    String longDesc;

    @NotBlank
    String imageUrl;

    @NotNull
    LocalDate startDate;

    @NotNull
    LocalDate endDate;

    @Valid
    TypeDto type;
}
