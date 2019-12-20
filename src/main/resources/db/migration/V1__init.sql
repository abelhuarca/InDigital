CREATE TABLE client (
  id UUID PRIMARY KEY,
  first_name VARCHAR(250),
  last_name VARCHAR(250),
  birth_date TIMESTAMP,
  status VARCHAR(30)
);