<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="ru-RU">
<head>

    <meta charset="WINDOWS-1251">
    <%--<meta charset="utf-8 with BOM">--%>
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/img/pizza.png">
    <title>🍕Море пиццы🍕</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <link href="<c:url value="/css/main.css" />" rel="stylesheet">
    <script type="text/javascript">
        <%@include file="/js/CustomerAjaxRequests.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/FeedbackAjaxRequest.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/PointAjaxRequest.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/OrderAjaxRequest.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/order.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/init.js"%>
    </script>
</head>

<body>
<div id="headerMain">

    <div id="header">
        <div class="row" id="phone">
            <div style="width: 100px; height: 30px"></div>
            <div><p>88005553535</p></div>
            <div style="width: 400px; height: 30px"></div>
            <div id="identification">
                <input autocomplete="username" data-mask="(999) 999-9999" type="text"
                       placeholder="Введите ваш телефон" id="_phone" required="required">
                <input autocomplete="current-password" type="password"
                       id="_password" placeholder="Введите пароль" required="required">
                <button style="height: 20px"
                        onclick="sendCustomer()" class="buttonOrder">
                    <i class="icon-enter position-left"></i> Войти
                </button>
            </div>
        </div>
        <div class="row" style="width: 100px; height: 3px"></div>
        <div class="row">
            <div style="width: 53px; height: 55px"></div>
            <div class="col-md-3"><h1><a href="<c:url value="/"/>">Море Пиццы</a></h1></div>
            <div class="col-md-1.5"><input class="button" type="button" value="Пицца" onclick="findById('pizza')"></div>
            <!--добавить привязку по тегу/ add tags -->
            <div class="col-md-1.5"><input class="button" type="button" value="Закуски"
                                           onclick="findById('snack')"></div>
            <div class="col-md-1.5"><input class="button" type="button" value="Напитки"
                                           onclick="findById('drink')"></div>
            <div class="col-md-2.5">
                <div style="width: 200px; height: 15px"></div>
            </div>

            <div class="col-md-5.5"><input class="buttonOrder" type="button" value="Корзина"
                                           onclick="location.href='cart'"/></div>

        </div>

    </div>


</div>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-1.5" style="width: 30px; height: 55px"></div>
        <img class="col-md-1.5" src="${pageContext.request.contextPath}/img/pizzaPattern_cut-photo.ru.png" width="95%">
    </div>
    <div class="row" id="pizza">
        <div style="height: 50px"></div>
    </div>
    <div class="row" style="background: #1959d1"><h1 class="centerh" style="color: white">Пиццы</h1></div>
    <div class="row">
        <div style="height: 50px"></div>
    </div>
    <div class="row" data-group="1">  <!--пицки-->
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Пепперони</h1></div>
                <img src="${pageContext.request.contextPath}/img/pizza/peperoni.jpg" alt="image" style="width: 90%">
                <p class="centerContent">Колбаски Пепперони, сыр Моцарелла, пицца-соус</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">395₽</div>
                    </h1>
                    <div class="add" data-id="1"><input class="buttonOrder" type="button"
                                                        value="В корзину"
                                                        style="margin-left: 15%;">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">4 сыра</h1></div>
                <img src="${pageContext.request.contextPath}/img/pizza/4cheese.jpg" style="width: 90%">
                <p class="centerContent">Сыр Чеддер, сыр Дор блю, сыр Фета, сыр Моцарелла, сырный соус</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">415₽</div>
                    </h1>
                    <div class="add" data-id="2"><input class="buttonOrder" type="button"
                                                        value="В корзину" style="margin-left: 15%;">
                    </div>
                </div>

            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Барбекю</h1></div>
                <img src="${pageContext.request.contextPath}/img/pizza/barbeku.jpg" style="width: 90%">
                <p class="centerContent">Колбаски Пепперони, бекон, говядина, карамелизированный лук, сыр Моцарелла,
                    соус
                    Барбекю</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">415₽</div>
                    </h1>
                    <div class="add" data-id="3"><input class="buttonOrder" type="button"
                                                        value="В корзину"
                                                        style="margin-left: 15%;">
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Грибная</h1></div>
                <img src="${pageContext.request.contextPath}/img/pizza/grib.jpg" style="width: 90%">
                <p class="centerContent">Ветчина, шампиньоны, сыр Моцарелла, соус Бешамель</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">395₽</div>
                    </h1>
                    <div class="add" data-id="4">
                        <input class="buttonOrder"
                               type="button"
                               value="В корзину"
                               style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Гавайская</h1></div>
                <img src="${pageContext.request.contextPath}/img/pizza/gawaii.jpg" style="width:90%">
                <p class="centerContent">Ветчина, ананасы, сыр Моцарелла, пицца-соус</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">345₽</div>
                    </h1>
                    <div class="add" data-id="5"><input class="buttonOrder" type="button" value="В корзину"
                                                        style="margin-left: 15%;">
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!--here-->
    <div class="row">
        <div style="height: 50px"></div>
    </div>
    <div class="row" style="background: #1959d1"><h1 class="centerh" style="color: white">Соусы</h1></div>
    <div class="row">
        <div style="height: 50px"></div>
    </div>
    <div class="row" data-group="2"><!--соусы-->

        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Барбекю</h1></div>
                <img src="${pageContext.request.contextPath}/img/souce/barbeku.jpg" style="width:90%">
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">20₽</div>
                    </h1>
                    <div class="add" data-id="6"><input class="buttonOrder" type="button"
                                                        value="В корзину" onclick=""
                                                        style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Сырный</h1></div>
                <img src="${pageContext.request.contextPath}/img/souce/cheese.jpg" style="width:90%">
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">20₽</div>
                    </h1>
                    <div class="add" data-id="7"><input class="buttonOrder" type="button"
                                                        value="В корзину"
                                                        style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Кетчуп</h1></div>
                <img src="${pageContext.request.contextPath}/img/souce/ketchup.jpg" style="width:90%">
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">20₽</div>
                    </h1>
                    <div class="add" data-id="8"><input class="buttonOrder" type="button" value="В корзину"
                                                        style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Кисло-сладкий соус</h1></div>
                <img src="${pageContext.request.contextPath}/img/souce/saltsweet.jpg" style="width:90%">
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">20₽</div>
                    </h1>
                    <div class="add" data-id="9"><input class="buttonOrder" type="button"
                                                        value="В корзину" onclick=""
                                                        style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>


    </div>

    <div class="row" id="snack">
        <div style="height: 50px"></div>
    </div>
    <div class="row" style="background: #1959d1"><h1 class="centerh" style="color: white">Снеки</h1></div>
    <div class="row">
        <div style="height: 50px"></div>
    </div>
    <div class="row" data-group="3">
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Картофель по-деревенски</h1></div>
                <img src="${pageContext.request.contextPath}/img/snacks/country.jpg" style="width:90%">
                <p class="centerContent">Ароматный запеченый картофель со специями. Вес: 140 г</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">99₽</div>
                    </h1>
                    <div class="add" data-id="10"><input class="buttonOrder" type="button" value="В корзину"
                                                         style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Картофель фри</h1></div>
                <img src="${pageContext.request.contextPath}/img/snacks/fri.jpg" style="width:90%">
                <p class="centerContent">Вкусные, слегка посоленные палочки картофеля с аппетитно хрустящей корочкой.
                    Вес:
                    140 г</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">99₽</div>
                    </h1>
                    <div class="add" data-id="11"><input class="buttonOrder" type="button"
                                                         value="В корзину"
                                                         style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Крылья BBQ</h1></div>
                <img src="${pageContext.request.contextPath}/img/snacks/wingsBBQ.jpg" style="width:90%">
                <p class="centerContent">Запеченные куриные крылья в маринаде из соуса барбекю. 4 шт.</p>
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">290₽</div>
                    </h1>
                    <div class="add" data-id="12"><input class="buttonOrder" type="button"
                                                         value="В корзину"
                                                         style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="row" >
        <div style="height: 50px"></div>
    </div>
    <div class="row" style="background: #1959d1" id="drink"><h1 class="centerh" style="color: white">Напитки</h1></div>
    <div class="row">
        <div style="height: 50px"></div>
    </div>
    <div class="row" data-group="4">
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Coca-Cola 0,9л</h1></div>
                <img src="${pageContext.request.contextPath}/img/drink/cocacola.jpg" style="width:90%">
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">119₽</div>
                    </h1>
                    <div class="add" data-id="13"><input class="buttonOrder" type="button"
                                                         value="В корзину"
                                                         style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">Sprite 0,5л</h1></div>
                <img src="${pageContext.request.contextPath}/img/drink/sprite.jpg" style="width:90%">
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">119₽</div>
                    </h1>
                    <div class="add" data-id="14"><input class="buttonOrder" type="button" value="В корзину"
                                                         style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="item_box">
                <div style="height:50px;"></div>
                <div class="title"><h1 class="centerContent">BonAqua 0,5л</h1></div>
                <img src="${pageContext.request.contextPath}/img/drink/water.jpg" style="width:90%">
                <div class="row">
                    <h1 class="centerContent">
                        <div class="price">59₽</div>
                    </h1>
                    <div class="add" data-id="15"><input class="buttonOrder" type="button"
                                                         value="В корзину" onclick=""
                                                         style="margin-left: 15%;"></div>
                </div>
            </div>
        </div>

    </div>


    <div class="row">
        <div style="height: 50px"></div>
    </div>
</div>
<table>
    <tr>
        <th colspan="2">
            <div style="width:300px"></div>
        </th>
        <th colspan="2"><h1 class="centerh" style="background: #1959d1;color: white">ОТЗЫВЫ:</h1></th>
        <th colspan="2" style="background: #1959d1"></th>
        <th colspan="2"><h1 class="centerh" style="background: #1959d1;color: white">ПИЦЦЕРИИ:</h1></th>

    </tr>
    <tr>
        <td colspan="2"></td>
        <td colspan="2">
            <div id="feedback">

                <ul class="list-group">
                </ul>
            </div>
        </td>
        <td colspan="2" style="background: #1959d1"></td>
        <td colspan="2">
            <div id="point">

                <ul class="list-group">
                </ul>
            </div>
        </td>
    </tr>
</table>


<div class="footer"> &nbsp;Moре пиццы ©
    <br></br>2020
</div>

</body>
</html>