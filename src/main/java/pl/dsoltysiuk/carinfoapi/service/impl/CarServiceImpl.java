package pl.dsoltysiuk.carinfoapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dsoltysiuk.carinfoapi.model.Car;
import pl.dsoltysiuk.carinfoapi.repository.CarRepository;
import pl.dsoltysiuk.carinfoapi.service.CarService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getSingleCarById(Long id) {
        return carRepository.findById(id).orElseThrow();
    }
}
