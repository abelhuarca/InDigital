package com.indigital.client.api.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @NotBlank(message = "El nombre es requerido")
    private String name;

    @NotBlank(message = "El apellido es requerido")
    private String lastName;

    @NotBlank(message = "La fecha de nacimiento es requerida")

    private String birthDate;

    private String attemptDeathDate;

}
