package Task1.model.dto;

import Task1.model.entity.CarEntity;
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
public class CarShort {
    private UUID id;
    private String model;
    private String vin;

    public CarShort mapEntityToShort() {
        CarEntity carEntity = new CarEntity();
        return CarShort.builder()
                .id(carEntity.getId())
                .model(carEntity.getModel())
                .vin(carEntity.getVin())
                .build();
    }
}
