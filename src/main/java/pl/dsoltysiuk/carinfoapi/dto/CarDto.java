package pl.dsoltysiuk.carinfoapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private String brand;
    private String model;
    private Short yearProduction;
    private String variant;
    private String registerNumber;
    private EngineDto engineDto;
}
