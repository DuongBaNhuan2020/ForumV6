DROP TABLE IF EXISTS USERv2;
CREATE TABLE userv2 (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  EMAIL VARCHAR(250),
  JOIN_DATE datetime,
  PASSWORD VARCHAR(250),
  USER_NAME VARCHAR(250)
);