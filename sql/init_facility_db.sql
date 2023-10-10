CREATE DATABASE csci927;

CREATE TABLE csci927.facility (
  id int AUTO_INCREMENT,
  name varchar(64),
  location varchar(256),
  startDate varchar(16),
  status char(1),
  created DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE csci927.facAppointment (
  id int AUTO_INCREMENT,
  facilityId int,
  userType varchar(16),
  userId int,
  applyStartTime varchar(32),
  applyEndTime varchar(32),
  status char(1),
  approveManagerName varchar(64),
  approveDate varchar(10),
  created DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);
