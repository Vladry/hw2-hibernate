CREATE USER IF NOT EXISTS SA SALT '4cda9d8bf763057b' HASH 'b83fb36ede4907fa64b74da32fb2f1f5127abd6bfb8658445e4571c0505ab578' ADMIN;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_AEE33347_2958_4AB3_8E5B_2326307DE780 START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_53EA113E_038F_4681_964A_AAB7318FF5A1 START WITH 1 BELONGS_TO_TABLE;
CREATE SEQUENCE PUBLIC.SYSTEM_SEQUENCE_8A11F838_DD87_49E0_816D_9E84B526AA3C START WITH 1 BELONGS_TO_TABLE;
CREATE MEMORY TABLE PUBLIC.ACCOUNTS(
    ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_AEE33347_2958_4AB3_8E5B_2326307DE780) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_AEE33347_2958_4AB3_8E5B_2326307DE780,
    BALANCE DOUBLE,
    CURRENCY INTEGER,
    NUMBER VARCHAR(255),
    CUSTOMER_ID BIGINT
);
ALTER TABLE PUBLIC.ACCOUNTS ADD CONSTRAINT PUBLIC.CONSTRAINT_A PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.ACCOUNTS;
CREATE MEMORY TABLE PUBLIC.CUSTOMERS(
    ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_53EA113E_038F_4681_964A_AAB7318FF5A1) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_53EA113E_038F_4681_964A_AAB7318FF5A1,
    AGE INTEGER,
    EMAIL VARCHAR(255),
    NAME VARCHAR(255)
);
ALTER TABLE PUBLIC.CUSTOMERS ADD CONSTRAINT PUBLIC.CONSTRAINT_6 PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CUSTOMERS;
CREATE MEMORY TABLE PUBLIC.CUSTOMERS_EMPLOYERS(
    CUSTOMER_ID BIGINT NOT NULL,
    EMPLOYERS_ID BIGINT NOT NULL
);
ALTER TABLE PUBLIC.CUSTOMERS_EMPLOYERS ADD CONSTRAINT PUBLIC.CONSTRAINT_D PRIMARY KEY(CUSTOMER_ID, EMPLOYERS_ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CUSTOMERS_EMPLOYERS;
CREATE MEMORY TABLE PUBLIC.EMPLOYERS(
    ID BIGINT DEFAULT (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_8A11F838_DD87_49E0_816D_9E84B526AA3C) NOT NULL NULL_TO_DEFAULT SEQUENCE PUBLIC.SYSTEM_SEQUENCE_8A11F838_DD87_49E0_816D_9E84B526AA3C,
    ADDRESS VARCHAR(255),
    NAME VARCHAR(255),
    STREET VARCHAR(255)
);
ALTER TABLE PUBLIC.EMPLOYERS ADD CONSTRAINT PUBLIC.CONSTRAINT_4 PRIMARY KEY(ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.EMPLOYERS;
CREATE MEMORY TABLE PUBLIC.EMPLOYERS_CUSTOMERS(
    EMPLOYER_ID BIGINT NOT NULL,
    CUSTOMERS_ID BIGINT NOT NULL
);
ALTER TABLE PUBLIC.EMPLOYERS_CUSTOMERS ADD CONSTRAINT PUBLIC.CONSTRAINT_AF PRIMARY KEY(EMPLOYER_ID, CUSTOMERS_ID);
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.EMPLOYERS_CUSTOMERS;
ALTER TABLE PUBLIC.ACCOUNTS ADD CONSTRAINT PUBLIC.FKN6X8PDP50OS8BQ5RBB792UPSE FOREIGN KEY(CUSTOMER_ID) REFERENCES PUBLIC.CUSTOMERS(ID) NOCHECK;
ALTER TABLE PUBLIC.CUSTOMERS_EMPLOYERS ADD CONSTRAINT PUBLIC.FK194D933S2BARE5D9I776ITCU5 FOREIGN KEY(CUSTOMER_ID) REFERENCES PUBLIC.CUSTOMERS(ID) NOCHECK;
ALTER TABLE PUBLIC.EMPLOYERS_CUSTOMERS ADD CONSTRAINT PUBLIC.FK9B7NKLCQXFO2OA02C7FMQAR37 FOREIGN KEY(CUSTOMERS_ID) REFERENCES PUBLIC.CUSTOMERS(ID) NOCHECK;
ALTER TABLE PUBLIC.EMPLOYERS_CUSTOMERS ADD CONSTRAINT PUBLIC.FK1U2SIKBW03YFSVF1URY9P90PE FOREIGN KEY(EMPLOYER_ID) REFERENCES PUBLIC.EMPLOYERS(ID) NOCHECK;
ALTER TABLE PUBLIC.CUSTOMERS_EMPLOYERS ADD CONSTRAINT PUBLIC.FKB68PBWC1YBQ5TJEETFUEV4FJ1 FOREIGN KEY(EMPLOYERS_ID) REFERENCES PUBLIC.EMPLOYERS(ID) NOCHECK;