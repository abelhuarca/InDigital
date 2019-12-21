package com.indigital.client.api.model;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
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
public class ClientRequest {

    @NotBlank(message = "The name is required")
    private String name;

    @NotBlank(message = "The last name is required")
    private String lastName;

    @NotBlank(message = "The birthday is required")

    @ApiModelProperty (
            required = true, 
            example = "13/02/1902"
        )
    private String birthDate;


}
