package pl.dsoltysiuk.carinfoapi.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer modelId;
    private Short year;
    private String variant;
    private Long userId;
    private String description;
    private String registerNumber;
    //TODO n+1 problems
    @OneToOne
    @JoinColumn(name = "engineId")
    private Engine engine;
}
