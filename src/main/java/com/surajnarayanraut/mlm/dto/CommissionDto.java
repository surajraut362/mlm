package com.surajnarayanraut.mlm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommissionDto {
    private float percentage;
    private String name;
    private Long id;
}