package Task1.service.Impl;

import Task1.model.dto.Driver;
import Task1.model.dto.DriverShort;
import Task1.model.dto.NewDriver;
import Task1.model.entity.DriverEntity;
import Task1.repositories.DriverRepository;
import Task1.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    @Override
    @Transactional(readOnly = true)
    public List<DriverShort> getAll() {
        return driverRepository.findAll()
                .stream().map(driverEntity -> new DriverShort().mapEntityToShort())
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public Driver findDriverById(UUID id) {
        return driverRepository.findById(id).stream()
                .map(driverEntity -> new Driver().mapEntityToDto())
                .findAny().orElseThrow();
    }
    @Override
    @Transactional
    public UUID addNewDriver(NewDriver driver) {
        DriverEntity driverEntity = driver.mapToEntity();
        driverRepository.save(driverEntity);
        return driverEntity.getId();
    }
}