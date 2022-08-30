package Task1.model.entity;

import Task1.model.enumerations.CarStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "car")
public class CarEntity {
    @Id
    @Column(name="car_id", columnDefinition = "UUID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_vin")
    private String vin;

    @Column(name = "car_number")
    private String number;

    @Column(name = "car_mileage")
    private Integer mileage;

    @Column(name = "car_status")
    private CarStatus status;

    @Column(name = "car_driver_id")
    private UUID ownerId;

    @JoinColumn(name = "car_driver_id"
            ,insertable = false
            ,updatable = false)
    @ManyToOne
    @JsonBackReference
    private DriverEntity driver;

    @Column(name = "car_reg")
    private Date dateOfRegistration;
}
