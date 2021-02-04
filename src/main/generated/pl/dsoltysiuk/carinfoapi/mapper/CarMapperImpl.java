package pl.dsoltysiuk.carinfoapi.mapper;

import javax.annotation.processing.Generated;
import pl.dsoltysiuk.carinfoapi.dto.CarDto;
import pl.dsoltysiuk.carinfoapi.model.Car;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9.1 (AdoptOpenJDK)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setVariant( car.getVariant() );
        carDto.setRegisterNumber( car.getRegisterNumber() );

        return carDto;
    }
}
