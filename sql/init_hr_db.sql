CREATE DATABASE csci927;

CREATE TABLE csci927.EMPLOYEE (
  id int AUTO_INCREMENT,
  firstName varchar(255),
  lastName varchar(255),
  phoneNumber varchar(255),
  email varchar(255),
  salary DECIMAL(5,2) default 0,
  department varchar(255),
  created DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

insert into csci927.employee (firstName, lastName, phoneNumber, email, salary, department)
values('qinghong', 'dai', '413978667', 'qd651@uow.edu.com', 0, 'CSCI');
