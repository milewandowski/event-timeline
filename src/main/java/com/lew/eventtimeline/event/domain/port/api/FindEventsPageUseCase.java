package com.lew.eventtimeline.event.domain.port.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindEventsPageUseCase {

    Page<EventDto> find(Pageable pageable);
}
