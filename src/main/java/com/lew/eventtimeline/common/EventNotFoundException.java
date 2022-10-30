package com.lew.eventtimeline.common;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(Long id) {
        super(String.format("Event with id: %s not found", id));
    }
}
