package pl.dsoltysiuk.carinfoapi.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EngineDto {
    private String codename;
    private String fuel;
    private Short capacity;
    private Short horsePower;
    private Short torque;
}
