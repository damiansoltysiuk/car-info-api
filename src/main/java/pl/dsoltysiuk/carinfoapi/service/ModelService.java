package pl.dsoltysiuk.carinfoapi.service;

import pl.dsoltysiuk.carinfoapi.model.Model;

import java.util.List;

public interface ModelService {
    List<Model> getModels();
    List<Model> getModelsByBrandName(String brandName);
}
