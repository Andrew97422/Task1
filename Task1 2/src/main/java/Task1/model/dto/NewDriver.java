package Task1.model.dto;

import Task1.model.entity.DriverEntity;
import Task1.model.enumerations.DriverCategory;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class NewDriver {
    @NotNull
    private String name;

    @NotNull
    private String category;

    @NotNull
    private Integer age;
    public DriverEntity mapToEntity() {
        return DriverEntity.builder()
                .name(getName())
                .category(DriverCategory.valueOf(getCategory()))
                .age(getAge())
                .dateOfRegistration(new Date())
                .build();
    }
}
