package pl.dsoltysiuk.carinfoapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    private String name;

    @OneToMany
    @JoinColumn(name = "brandId", updatable = false, insertable = false)
    private List<Model> models;
}
