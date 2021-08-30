DROP TABLE IF EXISTS Exchange_Value;

CREATE TABLE Exchange_Value (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  currency_from VARCHAR(250) NOT NULL,
  currency_to VARCHAR(250) NOT NULL,
  conversion_multiple INT DEFAULT NULL,
  port VARCHAR(20)
);