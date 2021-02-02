package pl.dsoltysiuk.carinfoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dsoltysiuk.carinfoapi.model.Engine;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {
}
