CREATE DATABASE csci927;

CREATE TABLE csci927.EMPLOYEE (
  id int AUTO_INCREMENT,
  firstName varchar(64),
  lastName varchar(64),
  phoneNumber varchar(16),
  email varchar(64),
  salary DECIMAL(7,2) default 0,
  department varchar(64),
  created DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE csci927.eventlog (
  id int AUTO_INCREMENT,
  serviceProvider varchar(32),
  serviceName varchar(32),
  serviceFunction varchar(32),
  status varchar(16),
  startTime bigint,
  endTime bigint,
  PRIMARY KEY (id)
);
