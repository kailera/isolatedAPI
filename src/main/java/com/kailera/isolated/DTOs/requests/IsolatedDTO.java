package com.kailera.isolated.DTOs.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IsolatedDTO {

    @NotEmpty
    @Size(min = 1, max = 100)
    private String firstNameIsol;

    @NotEmpty
    @Size(min = 1, max = 100)
    private String lastNameIsol;

    @Valid
    private AddressDTO address;

    @Valid
    private List<PhonesDTO> phones;

    @NotEmpty
    private String initialIsolationDate;

    @NotEmpty
    private String finalIsolationDate;

    @Valid
    private List<DirectContactsDTO> directContacts;


}
