package com.lew.eventtimeline.event.adapter.api;

import com.lew.eventtimeline.common.PathUtil;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import com.lew.eventtimeline.event.domain.port.api.FindEventsPageUseCase;
import com.lew.eventtimeline.event.domain.port.api.GetEventUseCase;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FindEventController {

    FindEventsPageUseCase findEventsPageUseCase;
    GetEventUseCase getEventUseCase;

    @GetMapping(PathUtil.EVENT)
    public ResponseEntity<Page<EventDto>> find(final Pageable pageable) {

        return ResponseEntity.ok(findEventsPageUseCase.find(pageable));
    }

    @GetMapping(PathUtil.EVENT_ID)
    public ResponseEntity<EventDto> get(@PathVariable Long id) {

        return ResponseEntity.ok(getEventUseCase.get(id));
    }
}
