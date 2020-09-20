<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" sizes="16x16" href="img/pizza.png">
    <title>🍕Море пиццы🍕</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
<div id="headerMain">

    <div id="header" >
        <div class="row" id="phone">
            <div style = "width: 100px; height: 30px"></div>
            <div ><p>88005553535</p></div>
        </div>

        <div class="row">
            <div style = "width: 53px; height: 55px"></div>
            <div class="col-md-3"><h1>Море Пиццы</h1></div>
            <div class="col-md-1.5"><input class="button"type="button" value="Пицца" onclick="location.href='index.html#pizza'"></div>
            <div class="col-md-1.5"><input class="button"type="button" value="Закуски" onclick="location.href='index.html#snack'"></div>
            <div class="col-md-1.5"> <input class="button"type="button" value="Напитки" onclick="location.href='index.html#drink'"></div>
            <div class="col-md-2.5"><div style = "width: 200px; height: 15px"></div> </div>

            <div class="col-md-5.5"> <input class="buttonOrder"type="button" value="Корзина" onclick="location.href='order.jsp'"></div>

        </div>
    </div>


</div>



<div class="footer">  &nbsp;Moре пиццы ©
    <br></br>2020
</div>
</body>
</html>
