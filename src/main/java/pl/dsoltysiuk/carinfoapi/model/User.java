package pl.dsoltysiuk.carinfoapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;

    @OneToMany
    @JoinColumn(name = "userId", updatable = false, insertable = false)
    private List<Car> cars;
}
