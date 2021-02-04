package pl.dsoltysiuk.carinfoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dsoltysiuk.carinfoapi.dto.EngineDto;
import pl.dsoltysiuk.carinfoapi.mapper.EngineMapper;
import pl.dsoltysiuk.carinfoapi.model.Engine;
import pl.dsoltysiuk.carinfoapi.service.EngineService;

import java.util.List;

@RestController
@RequestMapping("/api/engines")
@RequiredArgsConstructor
public class EngineController {
    private final EngineService engineService;

    @GetMapping
    public List<EngineDto> getEngines() {
        List<Engine> engines = engineService.getEngines();
        return EngineMapper.INSTANCE.engineListToEngineDtoList(engines);
    }

    @GetMapping("/{id}")
    public EngineDto getEngineById(@PathVariable(name = "id") Long id) {
        Engine engine = engineService.getEngineById(id);
        return EngineMapper.INSTANCE.engineToEngineDto(engine);
    }
}
