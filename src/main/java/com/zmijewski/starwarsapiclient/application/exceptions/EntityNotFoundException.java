package com.zmijewski.starwarsapiclient.application.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Long id) {
        super(String.format("Could not find entity with id: %d", id));
    }
}
