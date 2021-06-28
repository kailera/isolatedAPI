package com.kailera.isolated.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    CASA("Home"),
    COMERCIAL("Commercial");

    private final String description;
}
