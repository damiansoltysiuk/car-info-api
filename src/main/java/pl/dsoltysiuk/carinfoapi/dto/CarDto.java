package pl.dsoltysiuk.carinfoapi.dto;

import lombok.Data;

@Data
public class CarDto {
    private Long carId;
    private String brand;
    private String model;
    private Short yearProduction;
    private String variant;
    private String registerNumber;
    private EngineDto engineDto;
}
