package pl.dsoltysiuk.carinfoapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dsoltysiuk.carinfoapi.model.Engine;
import pl.dsoltysiuk.carinfoapi.repository.EngineRepository;
import pl.dsoltysiuk.carinfoapi.service.EngineService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineServiceImpl implements EngineService {
    private final EngineRepository engineRepository;

    public List<Engine> getEngines() {
        return engineRepository.findAll();
    }

    public Engine getEngineById(Long id) {
        return engineRepository.findById(id).orElseThrow();
    }
}
