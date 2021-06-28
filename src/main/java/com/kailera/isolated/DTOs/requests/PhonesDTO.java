package com.kailera.isolated.DTOs.requests;

import com.kailera.isolated.enuns.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PhonesDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType phoneType;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;

}
