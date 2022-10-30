package com.lew.eventtimeline.common;

public class TypeNotFoundException extends RuntimeException {

    public TypeNotFoundException(Long id) {
        super(String.format("Type with id: %s not found", id));
    }
}
