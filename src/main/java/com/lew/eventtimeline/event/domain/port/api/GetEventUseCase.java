package com.lew.eventtimeline.event.domain.port.api;

public interface GetEventUseCase {

    EventDto get(Long id);
}
