DROP TABLE IF EXISTS employers;

CREATE TABLE employers
(
    id      INT UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
    name    VARCHAR(30),
    address VARCHAR(100),
#     customer_id int,
    CONSTRAINT pk_employers PRIMARY KEY (id)
);

ALTER TABLE employers ADD COLUMN customer_id int;


DROP TABLE IF EXISTS accounts;

CREATE TABLE accounts
(
    id       INT UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
    number   INT,
    currency VARCHAR(10),
    balance  DOUBLE,
#     customer INT UNSIGNED, -  убрать

    # в конце формирования таблиц свяжем ключём:
#     FOREIGN KEY (customer) REFERENCES customers(id),
    CONSTRAINT pk_accounts PRIMARY KEY (id)
);
ALTER TABLE accounts ADD COLUMN customer_id INT UNSIGNED; # внести это поле внутрь таблицы accounts



DROP TABLE IF EXISTS customers;

CREATE TABLE customers
(
    id    INT UNSIGNED UNIQUE NOT NULL AUTO_INCREMENT,
    name  VARCHAR(100)        NOT NULL,
    email VARCHAR(100)        NOT NULL,
    age   INT UNSIGNED        NOT NULL CHECK (age > 18),

    employer_id INT UNSIGNED,
    account_id INT UNSIGNED,
    # в конце формирования таблиц свяжем ключами:
#     FOREIGN KEY (employer_id) REFERENCES employers(id),
#     FOREIGN KEY (account_id) REFERENCES accounts(id),
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

ALTER TABLE accounts ADD CONSTRAINT fk_accounts FOREIGN KEY (customer) REFERENCES customers(id);# убрать
ALTER TABLE accounts ADD CONSTRAINT fk_customer_id FOREIGN KEY (customer_id) REFERENCES customers(id);

ALTER TABLE customers ADD (
    CONSTRAINT fk_employer FOREIGN KEY (employer_id) REFERENCES employers(id),
    CONSTRAINT fk_account  FOREIGN KEY (account_id)  REFERENCES accounts(id)
    );



# DROP VIEW IF EXISTS hr.emp_details_view;
# CREATE VIEW emp_details_view
# AS
# SELECT e.employee_id,
#        e.job_id,
#        e.manager_id,
#        e.department_id,
#        d.location_id,
#        l.country_id,
#        e.first_name,
#        e.last_name,
#        e.salary,
#        e.commission_pct,
#        d.department_name,
#        j.job_title,
#        l.city,
#        l.state_province,
#        c.country_name,
#        r.region_name
# FROM employees e,
#      departments d,
#      jobs j,
#      locations l,
#      countries c,
#      regions r
# WHERE e.department_id = d.department_id
#   AND d.location_id = l.location_id
#   AND l.country_id = c.country_id
#   AND c.region_id = r.region_id
#   AND j.job_id = e.job_id;
