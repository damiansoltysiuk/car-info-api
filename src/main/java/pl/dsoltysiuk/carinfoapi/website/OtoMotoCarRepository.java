package pl.dsoltysiuk.carinfoapi.website;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtoMotoCarRepository extends JpaRepository<OtoMotoCar, Long> {
}
