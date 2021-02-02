package pl.dsoltysiuk.carinfoapi.dto;

import pl.dsoltysiuk.carinfoapi.model.Engine;

public class EngineDto {
    private Long engineID;
    private String engineCodename;
    private Engine.Fuel fuel;
    private Short capacity;
    private Short horsePower;
    private Short torque;
}
