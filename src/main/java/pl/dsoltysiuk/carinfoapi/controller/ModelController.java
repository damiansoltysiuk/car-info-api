package pl.dsoltysiuk.carinfoapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dsoltysiuk.carinfoapi.model.Model;
import pl.dsoltysiuk.carinfoapi.service.ModelService;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@RequiredArgsConstructor
public class ModelController {
    private final ModelService modelService;

    @GetMapping
    public List<Model> getModels() {
        return modelService.getModels();
    }

    @GetMapping("/{name}")
    public List<Model> getModelsByBrand(@PathVariable(name = "name") String brandName) {
        return modelService.getModelsByBrandName(brandName);
    }

}
