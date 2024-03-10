CREATE TABLE time_off
(
    id  INT AUTO_INCREMENT PRIMARY KEY,
    employerId        VARCHAR(20),
    employeeId    VARCHAR(20),
    vacation_days      VARCHAR(20),
    reason      VARCHAR(255),
    dayOff      VARCHAR(255)
);