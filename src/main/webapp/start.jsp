<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>The-quest-game</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<h1><b>Пролог</b></h1>
<div class="text-block">
    Ты стоишь в космическом порту и готов подняться на борт
    своего карабля. Разве ты не об этом мечтал? Стать капитаном
    галактического судна с экипажем, который будет совершать
    подвиги под твоим командованием.
    Так что вперед!
</div>

<h1><b>Знакомство с экипажем</b></h1>
<div class="text-block">
    Когда ты поднялся на борт корабля, тебя поприветствовала девушка с черной папкой в руках:
    - Здравствуйте, командир! Я Зинаида - ваша помощница. Видите? Там в углу пьет кофе
    наш штурман - сержант Перегарный Шлейф, под штурвалом спит наш бортмеханик - Черный Богдан,
    а фотографирует его Сергей Стальная Пятка - наш навигатор.
    А как обращаться к вам?
</div><br>
<input id="NameId" type="text" placeholder="Ваше имя">
<button onclick="start()">Представиться</button>

</body>
<script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
<script>
    function start() {
        let text = document.getElementById("NameId").value;
        $.ajax({
            url: '/start',
            type: 'POST',
            contentType: 'application/json;charset=UTF-',
            async: false,
            data: text,
            success: function () {
                location.replace("game.jsp");
            }
        });
    }
</script>
</html>
