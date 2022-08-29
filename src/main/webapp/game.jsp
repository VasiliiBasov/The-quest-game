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
<form class="question_form" id="question_select"></form>
<button id="answerButton" onclick="btnClick()">Ответить</button>
<section class="feedback_form" style="bottom: 10px;left: 10px; width: 400px;position: absolute">
</section>
</body>
<script src="<c:url value="/static/jquery-3.6.0.min.js"/>"></script>
<script>
    function getQuestion() {
        $.get("/logic", function (data) {
            $( ".question_form" ).html( data );
        });
    }
    getQuestion();
</script>
<script>
    function getStatistics() {
        $.get("/statistics", function (data) {
            $( ".feedback_form" ).html( data );
            console.log(data);
        });
    }
    getStatistics();
</script>
<script>
function btnClick()
{
    $.ajax({
        type: "POST",
        url: "/logic",
        data: document.querySelector('input[name="Answer"]:checked').value,
        success: function(data, textstatus, xhr){
            if (xhr.status === 250) {
                document.getElementById( "answerButton" ).setAttribute( "onClick", "javascript: restart();" );
                document.getElementById( "answerButton" ).innerText = "Начать сначала";
            }
            $( ".question_form" ).html( data );
        }
    });
}
</script>
<script>
    function restart() {
        console.log("restart");
    }
</script>
</html>
