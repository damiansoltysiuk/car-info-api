package pl.dsoltysiuk.carinfoapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dsoltysiuk.carinfoapi.dto.CarDto;
import pl.dsoltysiuk.carinfoapi.model.Car;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);


    CarDto carToCarDto(Car car);
}
