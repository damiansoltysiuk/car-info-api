package pl.dsoltysiuk.carinfoapi.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import pl.dsoltysiuk.carinfoapi.dto.EngineDto;
import pl.dsoltysiuk.carinfoapi.dto.EngineDto.EngineDtoBuilder;
import pl.dsoltysiuk.carinfoapi.model.Engine;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.9.1 (AdoptOpenJDK)"
)
public class EngineMapperImpl implements EngineMapper {

    @Override
    public EngineDto engineToEngineDto(Engine engine) {
        if ( engine == null ) {
            return null;
        }

        EngineDtoBuilder engineDto = EngineDto.builder();

        engineDto.codename( engine.getCodename() );
        if ( engine.getFuel() != null ) {
            engineDto.fuel( engine.getFuel().name() );
        }
        engineDto.capacity( engine.getCapacity() );
        engineDto.horsePower( engine.getHorsePower() );
        engineDto.torque( engine.getTorque() );

        return engineDto.build();
    }

    @Override
    public List<EngineDto> engineListToEngineDtoList(List<Engine> engines) {
        if ( engines == null ) {
            return null;
        }

        List<EngineDto> list = new ArrayList<EngineDto>( engines.size() );
        for ( Engine engine : engines ) {
            list.add( engineToEngineDto( engine ) );
        }

        return list;
    }
}
