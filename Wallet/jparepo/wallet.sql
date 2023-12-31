CREATE TABLE user_accounts (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    email VARCHAR(255) UNIQUE NOT NULL,
    date_of_birth DATE,
    wallet DECIMAL(10, 2) DEFAULT 0.00
);

INSERT INTO user_accounts (user_name, account_type, email, date_of_birth, wallet)
VALUES ('Aung Aung', '1', 'aungaung@gmail.com', '1990-01-01', 1000.00);

INSERT INTO user_accounts (user_name, account_type, email, date_of_birth, wallet)
VALUES ('Ma Ma', '1', 'mama@gamil.com', '1995-06-21', 500.00);

INSERT INTO user_accounts (user_name, account_type, email, date_of_birth, wallet)
VALUES ('Hla Hla', '1', 'hlahla@gmail.com', '1998-11-11', 300.00);

select * from user_accounts;

drop table user_accounts;

CREATE TABLE user_accounts (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL);
	
INSERT INTO user_accounts (user_name)
VALUES ('Hla Hla');

