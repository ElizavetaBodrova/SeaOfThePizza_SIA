INSERT INTO GROUPS_DISH(NAME)
VALUES ('Пицца'),
        ('Соус'),
        ('Снек'),
       ('Напиток');


INSERT INTO POINT(ADRESS, PHONE)
VALUES ('Станкевича 3', '8005553535'),
       ('Хользунова 50', '8005553535');

INSERT INTO role(name)
VALUES ('VISITOR'),
       ('CUSTOMER'),
       ('ADMIN');

INSERT INTO TYPE_DELIVERY(NAME)
VALUES ('Самовывоз'),
       ('Курьером'),
       ('Телепортация');

INSERT INTO DISH(NAME, PRICE, ID_GROUP)
VALUES ('Пеперони', 395, 1),
       ('4 сыра', 415, 1),
       ('Барбекю', 415, 1),
       ('Грибная', 395, 1),
       ('Гавайская', 345, 1),

       ('Барбекю', 20, 2),
       ('Сырный', 20, 2),
       ('Кетчуп', 20, 2),
       ('Кисло-сладкий', 20, 2),

       ('Картофель по-деревенски', 99, 3),
       ('Картофель фри', 99, 3),
       ('Крылья BBQ', 290, 3),

       ('Coca-Cola 0,9л',119,4),
       ('Sprite 0,5л',119,4),
       ('BonAqua 0,5л',59,4);


/*INSERT INTO "customer"(PHONE, PASSWORD, ISADMIN)
VALUES ('8003553535',null,false);

INSERT INTO "order"(id_customer, ID_TYPE, ID_POINT)
VALUES (1, 1, 1),
       (1, 2, 1),
       (1, 3, 1),
       (1, 3, 1),
       (1, 3, 1),
       (1, 1, 2),
       (1, 2, 2),
       (1, 3, 2),
       (1, 3, 2),
       (1, 3, 2);

INSERT INTO ORDER_DISH(ID_ORDER, ID_DISH, COUNT)
VALUES (1, 1, 2),
       (2, 1, 1),
       (2, 2, 1),
       (3, 4, 4),
       (3, 1, 4),
       (4, 2, 3),
       (5, 3, 3),
       (5, 2, 3),
       (6, 3, 1),
       (7, 4, 1),
       (8, 2, 2),
       (8, 1, 2),
       (9, 4, 5),
       (9, 3, 2),
       (10, 1, 4),
       (10, 2, 4),
       (10, 3, 4),
       (10, 4, 4);

INSERT INTO FEEDBACK(ID_ORDER, MARK, COMMENT)
VALUES (1, 1, 'Плохо'),
       (2, 2, 'Долгая доставка'),
       (3, 3, 'Нормас'),
       (4, 4, 'Хорошечно'),
       (5, 5, 'Телепортировали прямо на кухню!'),
       (6, 1, 'Плохо'),
       (7, 2, 'Долгая доставка'),
       (8, 3, 'Нормас'),
       (9, 4, 'Хорошечно'),
       (10, 5, 'Телепортировали прямо на кухню!');
*/
