package ru.ds.education.currency.core.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CursDto {
    @ApiModelProperty("Id запись")
    private Long id;

    @ApiModelProperty("Валюта")
    private CursEnum currency;

    @ApiModelProperty("Курс")
    private Double cursNumber;

    @ApiModelProperty("Дата")
    private Date curs_date;
}
