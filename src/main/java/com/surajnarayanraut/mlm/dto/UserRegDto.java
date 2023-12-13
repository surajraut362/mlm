package com.surajnarayanraut.mlm.dto;

import com.surajnarayanraut.mlm.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserRegDto {
    @NotNull
    @NotBlank
    private String name;

    @NotNull @NotBlank
    private String email;

    @NotNull @NotBlank
    private String password;

    private Role role;
}
