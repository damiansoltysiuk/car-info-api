package pl.dsoltysiuk.carinfoapi.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dsoltysiuk.carinfoapi.model.Brand;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Short> {

    @Query("SELECT DISTINCT b FROM Brand b " +
            "LEFT JOIN FETCH b.models m ")
    List<Brand> findAllBrand();

    @EntityGraph(attributePaths = {"models"})
    List<Brand> findAll();

    Brand findByName(String name);
}
