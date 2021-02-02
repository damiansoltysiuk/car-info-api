package pl.dsoltysiuk.carinfoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dsoltysiuk.carinfoapi.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

//    @Query(nativeQuery = true, value = "SELECT b.name, m.name, c.variant, c.register_number, e.fuel, e.capacity, e.horse_power, e.torque, e.diagram_url FROM brand AS b LEFT JOIN model AS m ON b.id = m.brand_id  LEFT JOIN car AS c ON m.id = c.model_id LEFT JOIN engine AS e ON e.id = c.engine_id;")
//    List<CarDto> findAllCars();
}
