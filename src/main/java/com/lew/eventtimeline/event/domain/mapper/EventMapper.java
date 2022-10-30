package com.lew.eventtimeline.event.domain.mapper;

import com.lew.eventtimeline.event.domain.Event;
import com.lew.eventtimeline.event.domain.port.api.EventDto;
import com.lew.eventtimeline.type.domain.Type;
import com.lew.eventtimeline.type.domain.port.api.TypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDto eventToEventDto(Event event);

    @Mapping(target = "id", ignore = true)
    Event eventDtoToEvent(EventDto eventDto);

    TypeDto typeToTypeDto(Type type);

    Type typeDtoToType(TypeDto typeDto);
}
