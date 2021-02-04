package pl.dsoltysiuk.carinfoapi.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import pl.dsoltysiuk.carinfoapi.dto.EngineDto;
import pl.dsoltysiuk.carinfoapi.model.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EngineMapperTest {

    @Test
    void engineToEngineDto() {
        Engine engine = Engine.builder()
                .id(1L)
                .codename("RFN")
                .description("Tuning engine - add supercharger EATON m45")
                .capacity((short) 2000)
                .horsePower((short) 222)
                .torque((short) 250)
                .fuel(Engine.Fuel.BENZINE)
                .diagramUrl("none")
                .build();

        EngineDto engineDto = EngineMapper.INSTANCE.engineToEngineDto(engine);

        assertNotNull(engineDto);
        assertEquals("RFN", engineDto.getCodename());
        assertEquals("BENZINE", engineDto.getFuel());
        assertEquals((short) 2000, engineDto.getCapacity());
        assertEquals((short) 250, engineDto.getTorque());
        assertEquals((short) 222, engineDto.getHorsePower());
    }

    @Test
    void engineListToEngineDtoList() {
        Engine rfn = Engine.builder()
                .id(1L)
                .codename("RFN")
                .description("Tuning engine - add supercharger EATON m45")
                .capacity((short) 2000)
                .horsePower((short) 222)
                .torque((short) 250)
                .fuel(Engine.Fuel.BENZINE)
                .diagramUrl("none")
                .build();

        Engine bam = Engine.builder()
                .id(2L)
                .codename("BAM")
                .description("Serial engine in Audi S3 8L")
                .capacity((short) 1781)
                .horsePower((short) 222)
                .torque((short) 280)
                .fuel(Engine.Fuel.BENZINE)
                .diagramUrl("none")
                .build();

        List<Engine> engines = Arrays.asList(rfn, bam);

        List<EngineDto> engineDtos = EngineMapper.INSTANCE.engineListToEngineDtoList(engines);

        assertNotNull(engineDtos);
        assertEquals(2, engineDtos.size());
    }
}