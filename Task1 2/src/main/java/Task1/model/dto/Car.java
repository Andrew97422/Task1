package Task1.model.dto;

import Task1.model.entity.CarEntity;
import Task1.model.enumerations.CarStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Car extends CarShort {
    String number;
    Integer mileage;
    CarStatus status;
    UUID ownerId;
    Date dateOfRegistration;
    public Car mapEntityToDto() {
        CarEntity carEntity = new CarEntity();
        return Car.builder()
                .id(carEntity.getId())
                .model(carEntity.getModel())
                .vin(carEntity.getVin())
                .number(carEntity.getNumber())
                .mileage(carEntity.getMileage())
                .status(carEntity.getStatus())
                .ownerId(carEntity.getOwnerId())
                .dateOfRegistration(carEntity.getDateOfRegistration())
                .build();
    }
}
