package pl.dsoltysiuk.carinfoapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dsoltysiuk.carinfoapi.model.Model;
import pl.dsoltysiuk.carinfoapi.repository.ModelRepository;
import pl.dsoltysiuk.carinfoapi.service.ModelService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    public List<Model> getModels() {
        return modelRepository.findAll();
    }

    public List<Model> getModelsByBrandName(String brandName) {
        throw new IllegalArgumentException("Not implements method yet");
    }
}
