package pl.dsoltysiuk.carinfoapi.service;

import pl.dsoltysiuk.carinfoapi.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCars();
    Car getSingleCarById(Long id);
}
