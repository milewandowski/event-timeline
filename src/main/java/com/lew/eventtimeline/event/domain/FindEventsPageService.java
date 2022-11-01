package com.lew.eventtimeline.event.domain;

import com.lew.eventtimeline.event.domain.mapper.EventMapper;
import com.lew.eventtimeline.event.domain.port.api.EventResponse;
import com.lew.eventtimeline.event.domain.port.api.FindEventsPageUseCase;
import com.lew.eventtimeline.event.domain.port.db.EventRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class FindEventsPageService implements FindEventsPageUseCase {

    EventRepository eventRepository;

    @Override
    public Page<EventResponse> find(Pageable pageable) {
        return eventRepository.findAll(pageable)
                .map(EventMapper.INSTANCE::eventToEventResponse);
    }
}
