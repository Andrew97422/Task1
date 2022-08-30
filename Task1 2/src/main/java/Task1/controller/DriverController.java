package Task1.controller;

import Task1.model.dto.Driver;
import Task1.model.dto.DriverShort;
import Task1.model.dto.NewDriver;
import Task1.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @GetMapping("/list")
    public List<DriverShort> listDriverShort() { return driverService.getAll(); }

    @GetMapping("/{id}")
    public Driver getDriverById(@PathVariable(value = "id") UUID id) {
        return driverService.findDriverById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID addNewDriver(@RequestBody @Valid NewDriver driver) {
        return driverService.addNewDriver(driver);
    }
}