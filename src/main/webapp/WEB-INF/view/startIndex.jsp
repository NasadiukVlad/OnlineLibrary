<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>

<head>
    <title>Online library</title>
    <meta charset="utf-8">
    <link href="css/main_pg.css" rel="stylesheet" type="text/css">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jsCounter.js"></script>
    <script type="text/javascript" src="js/scrollOnTop.js"></script>
    <%--<link rel="icon" href="favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />--%>
    <link rel="shortcut icon" href="images/favicon.png" />
</head>

<body>
<div id="page_align" class="page_align">

    <div id="sidebar" class="sidebar">

        <a href="IndexPageController">

            <div id="logo_side_bar" class="logo_side_bar">
                <img src="images/logo.jpg">
            </div>

        </a>

        <c:if test="${not empty username}">
            <div id="user_login" class="user_login">
                Welcome, ${username}! You can <a href="LogoutController" class="top_menu_logout_a">logout</a>
            </div>
        </c:if>

        <form action="SearchPageController" method="get" class="search_form">
            <br>
            <h1>Search</h1>

            <p class="login_p">What book are you looking for?: </p>
            <br>
            <input type="text" name="searchingTitle" class="search_form_input">
            <br>
            <input type="submit" value="Send" name="button" class="button">

        </form>

        <div id="left_navigation" class="left_navigation">
            <jsp:include page="includeLeftNavigation.jsp"/>
        </div>

        <div id="left_content2" class="left_content2">
            <jsp:include page="includeWeatherForecast.jsp"/>

        </div>

    </div>

    <div id="top_menu" class="top_menu">
        <jsp:include page="includeTopMenu.jsp"/>
    </div>

    <div id="content" class="content">

        <h1>Welcome to Online Library</h1>
        <center><img src="images/main_picture.jpg" style="text-align: center; height: 100%"></center>

    </div>

    <a href="#" id="toTop" class="toTop">TOP!</a>

</div>

<div id="clr"></div>
</div>
</body>

</html>