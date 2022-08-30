package Task1.controller;

import Task1.model.dto.Car;
import Task1.model.dto.CarShort;
import Task1.model.dto.NewCar;
import Task1.model.enumerations.CarStatus;
import Task1.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;
    @GetMapping("/list")
    public List<CarShort> listCarShort() { return carService.getAll(); }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable(value = "id") UUID id) {
        return carService.findCarById(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public UUID addNewCar(@RequestBody @Valid NewCar car) {
        return carService.addNewCar(car);
    }

    @PatchMapping("/{id}")
    public void update(@RequestParam(value = "status", required = false) CarStatus status,
                       @PathVariable("id") UUID id) {
        carService.update(id, status);
    }
}
