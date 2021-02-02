CREATE TABLE brand (
  id SMALLINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(16) NOT NULL
);

CREATE TABLE model (
 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 brand_id SMALLINT NOT NULL,
 name VARCHAR(25) NOT NULL
);

ALTER TABLE model
 ADD CONSTRAINT model_brand_id
 FOREIGN KEY (brand_id) REFERENCES brand(id);

CREATE TABLE user (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(250) NOT NULL
  );

CREATE TABLE engine (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  fuel ENUM('BENZINE', 'DIESEL', 'HYBRID', 'ELECTRIC') NOT NULL,
  codename VARCHAR(10),
  capacity SMALLINT NOT NULL,
  horse_power SMALLINT,
  torque SMALLINT,
  diagram_url VARCHAR(250),
  description VARCHAR(1000),
  CONSTRAINT check_capacity CHECK (capacity > 300 AND capacity < 10000),
  CONSTRAINT check_horse_power CHECK (horse_power > 3 AND horse_power < 2500),
  CONSTRAINT check_torque CHECK (torque >= 0 AND torque < 3500)
);

CREATE TABLE car (
 id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 model_id INT NOT NULL,
 year SMALLINT,
 variant VARCHAR(20),
 user_id BIGINT NULL,
 engine_id BIGINT NOT NULL,
 register_number VARCHAR(8) NOT NULL UNIQUE,
 description VARCHAR(1000)
);

ALTER TABLE car
 ADD CONSTRAINT car_model_id
 FOREIGN KEY (model_id) REFERENCES model(id);

ALTER TABLE car
ADD CONSTRAINT car_user_id
 FOREIGN KEY (user_id) REFERENCES user(id);

ALTER TABLE car
ADD CONSTRAINT car_engine_id
 FOREIGN KEY (engine_id) REFERENCES engine(id);


CREATE TABLE oto_moto_car (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_advert BIGINT,
  brand VARCHAR(16),
  model VARCHAR(25),
  variant VARCHAR(40),
  year_production SMALLINT,
  capacity SMALLINT,
  fuel VARCHAR(15),
  power SMALLINT,
  price SMALLINT,
  register_number VARCHAR(10)
);