package com.kailera.isolated.enuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AddressType {

    RUA("street"),
    AVENIDA ("avenue"),
    VIELA("alley");
    
    private String description;
}
