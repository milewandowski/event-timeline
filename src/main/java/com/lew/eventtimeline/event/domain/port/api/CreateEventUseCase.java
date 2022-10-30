package com.lew.eventtimeline.event.domain.port.api;

public interface CreateEventUseCase {

    EventDto create(EventDto eventRequest);
}
