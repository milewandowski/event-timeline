package com.lew.eventtimeline.type.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import com.lew.eventtimeline.event.domain.port.api.UpdateEventUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateTypeController {

    UpdateEventUseCase updateEventUseCase;

    @PutMapping(PathUtil.TYPE_ID)
    public ResponseEntity<EventDto> update(@Valid @RequestBody EventDto eventDto, @PathVariable Long id) {

        return ResponseEntity.ok(updateEventUseCase.update(eventDto, id));
    }
}
