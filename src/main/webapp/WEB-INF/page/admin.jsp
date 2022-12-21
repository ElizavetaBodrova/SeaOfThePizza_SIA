<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="WINDOWS-1251">
    <link rel="icon" type="image/png" sizes="16x16"
          href="${pageContext.request.contextPath}/img/pizza.png">
    <title>🍕Море пиццы🍕</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
          crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <link href="<c:url value="/css/rating.css" />" rel="stylesheet">
    <link href="<c:url value="/css/main.css" />" rel="stylesheet">
    <script type="text/javascript">
        <%@include file="/js/order.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/CustomerAjaxRequests.js"%>
    </script>
    <script>
        <%@include file="/js/PointAjaxRequest.js"%>
    </script>
    <script>
        <%@include file="/js/FeedbackAjaxRequest.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/AdminCustomersAjaxRequest.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/init.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/admin.js"%>
    </script>

</head>
<body>
<div id="headerMain">

    <div id="header">
        <div class="row" id="phone">
            <div style="width: 100px; height: 30px"></div>
            <div><p>88005553535</p></div>
            <div style="width: 200px; height: 30px"></div>
            <div id="admin"><%--<input class="buttonOrder" type="button" value="Пользователи"
                                           onclick="location.href='admin'"/>--%>
            </div>
            <div style="width: 50px; height: 30px"></div>
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

            <div class="col-md-2.5">
                <div style="width: 100px; height: 15px"></div>
            </div>

            <div class="col-md-5.5"><input class="buttonOrder" type="button" value="Корзина"
                                           onclick="location.href='cart'"/>

            </div>
        </div>

    </div>

</div>

<div class="container-fluid">
    <div style="height: 50px"></div>
    <table>
        <tr>
            <th colspan="2"><h2 style="background: #1959d1;color: white">РОЛЬ
                ПОЛЬЗОВАТЕЛЯ:</h2>
            </th>
            <th colspan="2" style="background: #1959d1"></th>
            <th colspan="2"><h2 style="background: #1959d1;color: white">ТЕЛЕФОН:
            </h2>
            </th>
            <th colspan="2" style="background: #1959d1"></th>
            <th colspan="2"><h2
                                style="background: #1959d1;color: white">КОЛИЧЕСТВО ЗАКАЗОВ:
            </h2>
            </th>
            <th colspan="2" style="background: #1959d1"></th>
            <th colspan="2"><h2  style="background: #1959d1;color: white">ОБЩАЯ
                СУММА ЗАКАЗОВ:
            </h2>
            </th>

        </tr>
        <tr>
            <td colspan="2">
                <div id="customers.role">

                    <ul class="list-group">
                    </ul>
                </div>
            </td>
            <td colspan="2" style="background: #1959d1"></td>
            <td colspan="2">
                <div id="customers.phone">

                    <ul class="list-group">
                    </ul>
                </div>
            </td>
            <td colspan="2" style="background: #1959d1"></td>
            <td colspan="2">
                <div id="customers.count">

                    <ul class="list-group">
                    </ul>
                </div>
            </td>
            <td colspan="2" style="background: #1959d1"></td>
            <td colspan="2">
                <div id="customers.sum">

                    <ul class="list-group">
                    </ul>
                </div>
            </td>
        </tr>
    </table>
    <div style="height: 50px"></div>
</div>


<table>
    <tr>
        <th colspan="2"><div style="width:300px"></div></th>
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
    <br></br>2022
</div>
</body>
</html>

