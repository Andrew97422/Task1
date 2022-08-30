package Task1.model.dto;

import Task1.model.entity.DriverEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Driver extends DriverShort {
    int age;
    List<CarShort> cars;
    Date dateOfRegistration;

    public Driver mapEntityToDto() {
        DriverEntity driverEntity = new DriverEntity();
        return Driver.builder()
                .id(driverEntity.getId())
                .name(driverEntity.getName())
                .category(driverEntity.getCategory())
                .age(driverEntity.getAge())
                .cars(driverEntity.getCars().stream()
                        .map(carEntity -> new CarShort().mapEntityToShort())
                        .collect(Collectors.toList()))
                .dateOfRegistration(driverEntity.getDateOfRegistration())
                .build();
    }
}

