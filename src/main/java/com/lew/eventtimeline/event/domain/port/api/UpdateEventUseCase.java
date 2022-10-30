package com.lew.eventtimeline.event.domain.port.api;

public interface UpdateEventUseCase {

    EventDto update(EventDto eventDto, Long id);
}
