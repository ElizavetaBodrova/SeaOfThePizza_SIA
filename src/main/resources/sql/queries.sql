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
SELECT P.ADRESS
FROM POINT P;

SELECT O.id,
       D.name     "dish.name",
       D.price    "dish.price",
       D.id_group "dish.group.id",
       gd.name    "dish.group.name",
       OD.count   "count"
FROM "order" O
         JOIN ORDER_DISH OD ON O.ID = OD.ID_ORDER
         join dish D on OD.id_dish = D.id
         join groups_dish gd on D.id_group = gd.id
where O.id_customer = (select c.id from customer c where c.phone = '88005553534');

select c.id,
       c.phone,
       c.key,
       c.id_role,
       c.id_user "user.id"
from customer c
where c.phone = '0AEA4C6F5ABAC56829F032EE5AA51BCF';

select c.id,
       c.iv,
       c.phone,
       c.key,
       c.id_role "role.id",
       r.name "role.name",
       u.id,
       u.hash
from customer c
        left join "user" u on c.id_user = u.id
         join role r on c.id_role = r.id;
