package Task1.model.dto;

import Task1.model.entity.CarEntity;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NewCar {
    @NotNull
    private UUID ownerId;

    @NotNull
    private String model;

    @NotNull
    private String vin;

    @NotNull
    private String number;

    @NotNull
    private Integer mileage;
    public CarEntity mapToEntity() {
        return CarEntity.builder()
                .ownerId(getOwnerId())
                .model(getModel())
                .vin(getVin())
                .number(getNumber())
                .mileage(getMileage())
                .dateOfRegistration(new Date())
                .build();
    }
}