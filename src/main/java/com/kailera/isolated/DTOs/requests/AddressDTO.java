package com.kailera.isolated.DTOs.requests;

import com.kailera.isolated.enuns.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private Long id;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @NotEmpty
    @Size(min = 1, max = 50)
    private String publicPlace;


    @Range(min = 0, max = 5000)
    private Integer numberAddress;

    private String district;

}
