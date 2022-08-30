package Task1.model.entity;

import Task1.model.enumerations.DriverCategory;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "driver")
public class DriverEntity {
    @Id
    @Column(name="driver_id", columnDefinition = "UUID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @Column(name = "driver_name")
    protected String name;

    @Column(name = "driver_category")
    protected DriverCategory category;

    @Column(name = "driver_age")
    protected Integer age;

    @Column(name = "driver_registration")
    private Date dateOfRegistration;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "driver")
    @JsonManagedReference
    private List<CarEntity> cars = new ArrayList<>();
}
