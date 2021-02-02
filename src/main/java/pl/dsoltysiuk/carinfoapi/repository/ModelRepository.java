package pl.dsoltysiuk.carinfoapi.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dsoltysiuk.carinfoapi.model.Model;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    @Query("SELECT DISTINCT m FROM Model m " +
            "LEFT JOIN FETCH m.cars")
    List<Model> findAllModel();

    @EntityGraph(attributePaths = "cars")
    List<Model> findAll();

    Model findByName(String modelName);
}
