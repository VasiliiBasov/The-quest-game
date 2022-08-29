<%--
  Created by IntelliJ IDEA.
  User: vasek
  Date: 26.08.2022
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Game</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<h1><b>Поехали!</b></h1>
<div class="text-block">
    Тут начинается захватывающая игра
</div>

</body>
<input id="NameId" type="text" placeholder="Ваше имя">
<button onclick="getStatistics()">Представиться</button>
<br>
<br>
<br>
<section class="feedback_form" style="width: 400px; align: 500">
    <form>
        <fieldset>
            <legend>Статистика:</legend>
            <p><label for="IPadress" id="ipAdress">IP adress: </label><></p>
            <p><label for="name" id="name">Имя в игре: </label></p>
            <p><label for="GameCount" id="gameCount">Игр сыграно: </label></p>
        </fieldset>
        <p><input type="submit" value="Отправить"></p>
    </form>
</section>
</body>
<script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
<script>
    function start() {
        $.ajax({
            url: '/logic',
            type: 'POST',
            contentType: 'application/json;charset=UTF-',
            async: false,
            success: function () {
                location.replace("start.jsp");
            }
        });
    }
</script>
<script>
    function getStatistics() {
        $.get("/statistics", function (data) {
            $.each(data, function (i, item) {
                console.log(item);
            });
        });
    }
</script>
</html>
