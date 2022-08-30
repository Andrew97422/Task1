package Task1.service;

import Task1.model.dto.Driver;
import Task1.model.dto.DriverShort;
import Task1.model.dto.NewDriver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public interface DriverService {
    List<DriverShort> getAll();
    Driver findDriverById(UUID id);
    UUID addNewDriver(NewDriver driver);
}