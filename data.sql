SET FOREIGN_KEY_CHECKS=0;

INSERT INTO customers (name, email, age, employer_id, account_id)
VALUES ('Vlad',
        'rvy@ukr.net',
        40,
        1,
        null),
       ('Sergey',
        'sergo@ukr.net',
        42,
        2,
        null),
       ('Max',
        'Max@ukr.net',
        38,
        3,
        null),
       ('Evgeny',
        'evgen-20@ukr.net',
        20,
        4,
        null),
       ('Petro',
        'petya@ukr.net',
        30,
        5,
        null);


INSERT INTO employers (name, address, customer_id)
VALUES ('RogaIKopyta', 'Bratislavska 9A', 1),
       ('KievInvestStroy', 'gorod Kiev', 2),
       ('IT - world', 'Odessa', 3),
       ('Venture IT Creations', 'New-York', 4),
       ('Self-Employed', 'Kiev city', 5);


INSERT INTO accounts
VALUES (null, 'number1', 1, 15.05, 1),
       (null, 'number1', 2, 13.05, 1),
       (null, 'number1', 3, 25.05, 1),
       (null, 'number1', 1, 35.05, 2),
       (null, 'number1', 2, 15.05, 2),
       (null, 'number1', 3, 55.05, 3),
       (null, 'number1', 1, 44.05, 4),
       (null, 'number1', 2, 43.05, 5),
       (null, 'number1', 3, 33.05, 5);