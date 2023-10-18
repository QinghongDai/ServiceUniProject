CREATE DATABASE csci927;

CREATE TABLE csci927.EXAM (
  id int AUTO_INCREMENT,
  type varchar(1),
  subjectCode varchar(12),
  subjectName varchar(255),
  location varchar(255),
  startTime varchar(32),
  takeMins int(3),
  created DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

CREATE TABLE csci927.EXAMPARTICIPANTS (
  id int AUTO_INCREMENT,
  examId int(12),
  userId int(12),
  score DECIMAL(5,2) default 0,
  status varchar(1),
  created DATETIME DEFAULT CURRENT_TIMESTAMP,
  updated DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);