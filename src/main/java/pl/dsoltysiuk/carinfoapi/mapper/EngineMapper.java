package pl.dsoltysiuk.carinfoapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.dsoltysiuk.carinfoapi.dto.EngineDto;
import pl.dsoltysiuk.carinfoapi.model.Engine;

import java.util.List;

@Mapper
public interface EngineMapper {

    EngineMapper INSTANCE = Mappers.getMapper(EngineMapper.class);

    EngineDto engineToEngineDto(Engine engine);
    List<EngineDto> engineListToEngineDtoList(List<Engine> engines);
}
