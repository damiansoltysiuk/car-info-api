package pl.dsoltysiuk.carinfoapi.website;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class OtoMotoCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idAdvert;
    private String brand;
    private String model;
    private String variant;
    private Short yearProduction;
    private Short capacity;
    private String fuel;
    private Short power;
    private Short price;
    private String registerNumber;



    @Override
    public String toString() {
        return "OtoMotoCar{" +
                "id=" + id +
                ", idAdvert=" + idAdvert +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", variant='" + variant + '\'' +
                ", yearProduction=" + yearProduction +
                ", capacity=" + capacity +
                ", fuel='" + fuel + '\'' +
                ", power=" + power +
                ", price=" + price +
                ", registerNumber='" + registerNumber + '\'' +
                '}';
    }


}
