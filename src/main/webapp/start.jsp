<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>The-quest-game</title>
    <link href="static/main.css" rel="stylesheet">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<h1><b>������</b></h1>
<div class="text-block">
    �� ������ � ����������� ����� � ����� ��������� �� ����
    ������ �������. ����� �� �� �� ���� ������? ����� ���������
    �������������� ����� � ��������, ������� ����� ���������
    ������� ��� ����� �������������.
    ��� ��� ������!
</div>

<h1><b>���������� � ��������</b></h1>
<div class="text-block">
    ����� �� �������� �� ���� �������, ���� ���������������� ������� � ������ ������ � �����:
    - ������������, ��������! � ������� - ���� ���������. ������? ��� � ���� ���� ����
    ��� ������� - ������� ���������� �����, ��� ��������� ���� ��� ����������� - ������ ������,
    � ������������� ��� ������ �������� ����� - ��� ���������.
    � ��� ���������� � ���?
</div><br>
<input id="NameId" type="text" placeholder="���� ���">
<button onclick="start()">�������������</button>

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
