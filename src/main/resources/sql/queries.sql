-- Выбор отзывов
SELECT MARK, COMMENT
FROM FEEDBACK;

-- Сумма заказа
SELECT O.ID, SUM(D.PRICE * OD.COUNT)
FROM "order" O
         JOIN ORDER_DISH OD ON O.ID = OD.ID_ORDER
         JOIN DISH D ON D.ID = OD.ID_DISH
GROUP BY O.ID;

-- Выбор всех блюд конкретной группы
SELECT *
FROM DISH
         JOIN GROUPS_DISH GD ON GD.ID = DISH.ID_GROUP
WHERE GD.NAME = ${groupName};

-- Число заказов
SELECT D.NAME, SUM(OD.COUNT)
FROM DISH D
         JOIN ORDER_DISH OD ON D.ID = OD.ID_DISH
GROUP BY D.ID
LIMIT 3;

-- Средний рейтинг заказов для каждого блюда
SELECT D.NAME, AVG(MARK)
FROM DISH D
         JOIN ORDER_DISH OD ON D.ID = OD.ID_DISH
         JOIN "order" O ON O.ID = OD.ID_ORDER
         JOIN FEEDBACK F ON O.ID = F.ID_ORDER
GROUP BY D.ID;

-- Адреса точек
SELECT P.ADRESS FROM POINT P;