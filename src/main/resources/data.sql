SET FOREIGN_KEY_CHECKS=0;

INSERT INTO customers (name, email, age)
VALUES ('Vlad',
        'rvy@ukr.net',
        40
        ),
       ('Sergey',
        'sergo@ukr.net',
        42
        ),
       ('Max',
        'Max@ukr.net',
        38
        ),
       ('Evgeny',
        'evgen-20@ukr.net',
        20
        ),
       ('Petro',
        'petya@ukr.net',
        30
        );


INSERT INTO employers (name, address, street)
VALUES ('RogaIKopyta', 'Kiev', 'Bratislavska 9A'),
       ('KievInvestStroy', 'gorod Kiev', 'Zhukova'),
       ('IT - world', 'Odessa', 'Privoz'),
       ('Venture IT Creations', 'New-York', 'Brooklyn'),
       ('Self-Employed', 'Kiev city', 'Gaydara');


INSERT INTO accounts (number, currency, balance, customer_id)
VALUES ('number1', 1, 15.05, 1),
       ('number1', 2, 13.05, 1),
       ('number1', 3, 25.05, 1),
       ('number1', 1, 35.05, 2),
       ('number1', 2, 15.05, 2),
       ('number1', 3, 55.05, 3),
       ('number1', 1, 44.05, 4),
       ('number1', 2, 43.05, 5),
       ('number1', 3, 33.05, 5);