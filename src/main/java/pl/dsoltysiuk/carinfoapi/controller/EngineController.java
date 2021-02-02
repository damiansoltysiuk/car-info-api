package pl.dsoltysiuk.carinfoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dsoltysiuk.carinfoapi.model.Engine;
import pl.dsoltysiuk.carinfoapi.service.EngineService;

import java.util.List;

@RestController
@RequestMapping("/api/engines")
@RequiredArgsConstructor
public class EngineController {
    private final EngineService engineService;

    @GetMapping
    public List<Engine> getEngines() {
        return engineService.getEngines();
    }

    @GetMapping("/{id}")
    public Engine getEngineById(@PathVariable(name = "id") Long id) {
        return engineService.getEngineById(id);
    }
}
