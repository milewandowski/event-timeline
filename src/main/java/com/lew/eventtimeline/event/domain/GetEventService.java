package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.common.EventNotFoundException;
import com.lew.eventtimeline.event.domain.mapper.EventMapper;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import com.lew.eventtimeline.event.domain.port.api.GetEventUseCase;
import com.lew.eventtimeline.event.domain.port.db.EventRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetEventService implements GetEventUseCase {

    EventRepository eventRepository;

    @Override
    public EventDto get(Long id) {
        return eventRepository.findById(id)
                .map(EventMapper.INSTANCE::eventToEventDto)
                .orElseThrow(() -> new EventNotFoundException(id));
    }
}
