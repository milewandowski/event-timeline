package com.lew.eventtimeline.event.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.CreateEventUseCase;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreateEventController {

    CreateEventUseCase createEventUseCase;

    @PostMapping(PathUtil.EVENT)
    public ResponseEntity<EventDto> create(@RequestBody @Valid EventDto eventRequest) {

        return ResponseEntity.ok(createEventUseCase.create(eventRequest));
    }
}
