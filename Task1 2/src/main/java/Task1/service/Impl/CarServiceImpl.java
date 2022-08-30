package Task1.service.Impl;

import Task1.model.dto.Car;
import Task1.model.dto.CarShort;
import Task1.model.dto.NewCar;
import Task1.model.entity.CarEntity;
import Task1.model.enumerations.CarStatus;
import Task1.repositories.CarRepository;
import Task1.service.CarService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    @Override
    @Transactional(readOnly = true)
    public List<CarShort> getAll() {
        return carRepository.findAll()
                .stream().map(carEntity -> new CarShort().mapEntityToShort())
                .collect(Collectors.toList());
    }
    @Override
    @Transactional(readOnly = true)
    public Car findCarById(UUID id) {
        return carRepository.findById(id).stream()
                .map(carEntity -> new Car().mapEntityToDto())
                .findAny().orElseThrow();
    }
    @Override
    @Transactional
    public UUID addNewCar(NewCar car) {
        CarEntity carEntity = car.mapToEntity();
        carRepository.save(carEntity);
        return carEntity.getId();
    }
    @Override
    @Transactional
    public void update(UUID id, CarStatus status) {
        CarEntity car = carRepository.findById(id).orElseThrow();
        if (car.getStatus() != null && car.getStatus().equals(status)) {
            throw new ResponseStatusException(HttpStatus.ALREADY_REPORTED);
        } else {
            car.setStatus(status);
            carRepository.save(car);
        }
    }
}
