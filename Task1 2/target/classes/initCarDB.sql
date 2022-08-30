create table if not exists car
(
    car_id      UUID
        primary key NOT NULL,
    car_model   VARCHAR(200),
    car_vin     VARCHAR(254),
    car_number  VARCHAR(20),
    car_mileage INTEGER,
    car_status  VARCHAR(20),
    car_driver_id UUID,
    CONSTRAINT fk_driver FOREIGN KEY(car_driver_id) REFERENCES driver(driver_id),
    car_reg     DATE
);