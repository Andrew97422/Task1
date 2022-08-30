create table car (
                                  id uuid not null,
                                  car_model   VARCHAR(200),
                                  car_vin     VARCHAR(254),
                                  car_number  VARCHAR(20),
                                  car_mileage INTEGER,
                                  car_status  VARCHAR(20),
                                  car_driver_id UUID,
                                  primary key (id)
);

create table driver (
                          id uuid not null,
                          driver_name  VARCHAR(200) NOT NULL,
                          driver_category VARCHAR(20) NOT NULL,
                          driver_age INTEGER NOT NULL,
                          driver_registration DATE,
                          primary key(id)
);

alter table car
    add constraint FK54uo82jnot7ye32pyc8dcj2eh
        foreign key (car_driver_id)
            references driver (id)