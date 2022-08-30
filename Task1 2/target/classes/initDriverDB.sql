CREATE TABLE IF NOT EXISTS driver
(
    driver_id    UUID PRIMARY KEY NOT NULL,
    driver_name  VARCHAR(200) NOT NULL,
    driver_category VARCHAR(20) NOT NULL,
    driver_age INTEGER NOT NULL,
    driver_registration DATE
);