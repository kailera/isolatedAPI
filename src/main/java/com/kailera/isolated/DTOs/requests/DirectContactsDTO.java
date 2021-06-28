package com.kailera.isolated.DTOs.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DirectContactsDTO {


    private Long id;

    @Size(min = 1, max = 100)
    private String fullName;

}
