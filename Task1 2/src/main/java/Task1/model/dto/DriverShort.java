package Task1.model.dto;

import Task1.model.entity.DriverEntity;
import Task1.model.enumerations.DriverCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class DriverShort {
    UUID id;
    String name;
    DriverCategory category;

    public DriverShort mapEntityToShort() {
        DriverEntity driverEntity = new DriverEntity();
        return DriverShort.builder()
                .id(driverEntity.getId())
                .name(driverEntity.getName())
                .category(driverEntity.getCategory())
                .build();
    }
}
