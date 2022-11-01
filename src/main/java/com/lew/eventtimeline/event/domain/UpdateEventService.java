package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.common.exception.EventNotFoundException;
import com.lew.eventtimeline.event.domain.mapper.EventMapper;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import com.lew.eventtimeline.event.domain.port.api.UpdateEventUseCase;
import com.lew.eventtimeline.event.domain.port.db.EventRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateEventService implements UpdateEventUseCase {

    EventRepository eventRepository;

    @Override
    public EventDto update(EventDto eventDto, Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));

        Event updatedEvent = EventMapper.INSTANCE.eventDtoToEvent(eventDto);
        updatedEvent.setId(event.getId());

        return EventMapper.INSTANCE.eventToEventDto(eventRepository.save(updatedEvent));
    }
}
