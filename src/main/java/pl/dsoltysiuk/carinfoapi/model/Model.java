package pl.dsoltysiuk.carinfoapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Model {
    private Short brandId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany
    @JoinColumn(name = "modelId", updatable = false, insertable = false)
    private List<Car> cars;
}
