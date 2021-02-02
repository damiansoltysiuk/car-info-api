package pl.dsoltysiuk.carinfoapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codename;
    @Enumerated(value = EnumType.STRING)
    private Fuel fuel;
    private Short capacity;
    private Short horsePower;
    private Short torque;
    private String diagramUrl;
    private String description;

    public enum Fuel {
        BENZINE, DIESEL, HYBRID, ELECTRIC
    }

}
