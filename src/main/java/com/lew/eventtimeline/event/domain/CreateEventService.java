package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.event.domain.mapper.EventMapper;
import com.lew.eventtimeline.event.domain.port.api.CreateEventUseCase;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import com.lew.eventtimeline.event.domain.port.db.EventRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class CreateEventService implements CreateEventUseCase {

    EventRepository eventRepository;

    @Override
    public EventDto create(EventDto eventRequest) {
        Event newEvent = eventRepository.save(EventMapper.INSTANCE.eventDtoToEvent(eventRequest));

        return EventMapper.INSTANCE.eventToEventDto(newEvent);
    }
}
