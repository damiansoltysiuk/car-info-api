package pl.dsoltysiuk.carinfoapi.service;

import pl.dsoltysiuk.carinfoapi.model.Engine;

import java.util.List;

public interface EngineService {
    List<Engine> getEngines();
    Engine getEngineById(Long id);
}
