package com.example.itau.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EstatisticaDTO {
    private Integer count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;
}
