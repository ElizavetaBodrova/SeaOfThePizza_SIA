<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="WINDOWS-1251">
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/img/pizza.png">
    <title>๐ะะพัะต ะฟะธััั๐</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <link href="<c:url value="/css/rating.css" />" rel="stylesheet">
    <link href="<c:url value="/css/main.css" />" rel="stylesheet">
    <script type="text/javascript">
        <%@include file="/js/order.js"%>
    </script>
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
        <%@include file="/js/init.js"%>
    </script>
    <script type="text/javascript">
        <%@include file="/js/AdminCustomersAjaxRequest.js"%>
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
            <div id="admin">
            </div>
            <div style="width: 50px; height: 30px"></div>
            <div id="identification">
                <input autocomplete="username" data-mask="(999) 999-9999" type="text"
                       placeholder="ะะฒะตะดะธัะต ะฒะฐั ัะตะปะตัะพะฝ" id="_phone" required="required">
                <input autocomplete="current-password" type="password"
                       id="_password" placeholder="ะะฒะตะดะธัะต ะฟะฐัะพะปั" required="required">
                <button style="height: 20px"
                        onclick="sendCustomer()" class="buttonOrder">
                    <i class="icon-enter position-left"></i> ะะพะนัะธ
                </button>
            </div>
        </div>
        <div class="row" style="width: 100px; height: 3px"></div>
        <div class="row">
            <div style="width: 53px; height: 55px"></div>
            <div class="col-md-3"><h1><a href="<c:url value="/"/>">ะะพัะต ะะธััั</a></h1></div>
            <div class="col-md-1.5"></div>
            <div class="col-md-1.5"></div>
            <div class="col-md-1.5"></div>
            <div class="col-md-2.5">
                <div style="width: 200px; height: 15px"></div>
            </div>

            <div class="col-md-5.5"><input class="buttonOrder" type="button" value="ะะพัะทะธะฝะฐ"
                                           onclick="location.href='cart'"/>
                <button id="clear_cart" class="button">ะัะธััะธัั</button>
            </div>


        </div>

    </div>

</div>

<div class="container-fluid">
    <div style="height: 50px"></div>
    <div id="cart_content"></div>
    <div style="height: 50px"></div>
    <input type="button" class="buttonOrder" value="ะะฐัะฐัั ะพัะพัะผะปััั ะทะฐะบะฐะท" id="order">
    <div id="order_content"></div>
    <div style="height: 50px"></div>
</div>
<div class="container-fluid">
    <div style="height: 50px"></div>
    <div id="lastOrder"></div>
    <div style="height: 50px"></div>
</div>
<div class="container-fluid">
    <div class="row" style="background: #1959d1"><h1 class="centerh" style="color: white">ะะพะฑะฐะฒะธัั ัะฒะพะน ะพัะทัะฒ:</h1>
    </div>
    <div style="height: 50px"></div>
    <div class="row">
        <input autocomplete="username" type="text"
               placeholder="ะะฐะบะฐะทโ" id="_order" required="required" style="margin-left: 30%" size="6">
        <div style="width: 50px"></div>
        <h1> 8</h1><input type="text"
                          id="_phoneOrder" placeholder="ะขะตะปะตัะพะฝ" required="required">
    </div>
    <div class="rating-area">
        <h1 style="margin-left: 30%">ะัะตะฝะบะฐ:</h1>
        <input type="radio" id="star-5" name="rating" value="5">
        <label for="star-5" title="ะัะตะฝะบะฐ ยซ5ยป"></label>
        <input type="radio" id="star-4" name="rating" value="4">
        <label for="star-4" title="ะัะตะฝะบะฐ ยซ4ยป"></label>
        <input type="radio" id="star-3" name="rating" value="3">
        <label for="star-3" title="ะัะตะฝะบะฐ ยซ3ยป"></label>
        <input type="radio" id="star-2" name="rating" value="2">
        <label for="star-2" title="ะัะตะฝะบะฐ ยซ2ยป"></label>
        <input type="radio" id="star-1" name="rating" value="1">
        <label for="star-1" title="ะัะตะฝะบะฐ ยซ1ยป"></label>
    </div>
    <div style="height: 50px"></div>
    <input style="margin-left: 30%" type="text" id="_comment" placeholder="ะะฐะบ ะฒะฐะผ ะฟะธััะฐ?" required="required"
           class="rating-area"/>
    <div style="height: 50px"></div>
    <div style="margin-left: 30%"><input class="buttonOrder" type="button" value="ะัะฟัะฐะฒะธัั"
                                         onclick="setFeedbacks()"/>
    </div>
    <div style="height: 50px"></div>

</div>

<table>
    <tr>
        <th colspan="2">
            <div style="width:300px"></div>
        </th>
        <th colspan="2"><h1 class="centerh" style="background: #1959d1;color: white">ะะขะะซะะซ:</h1></th>
        <th colspan="2" style="background: #1959d1"></th>
        <th colspan="2"><h1 class="centerh" style="background: #1959d1;color: white">ะะะฆะฆะะ?ะะ:</h1></th>

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
<div class="footer"> &nbsp;Moัะต ะฟะธััั ยฉ
    <br></br>2022
</div>
</body>
</html>
