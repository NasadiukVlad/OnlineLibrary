<%@ page import="java.util.Random" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Online library</title>
    <meta charset="utf-8">
    <link href="css/books_upload.css" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="images/favicon.png"/>
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

        <div id="login" class="login">

            <form action="BookPropertiesController" method="post" class="file_form">
                <br>
                <h1>Add your book</h1>

                <p class="login_p">Enter your book title: </p>
                <br>
                <input type="text" name="title" class="login_form_input">
                <br>
                <p class="login_p">Enter book description: </p>
                <br>
                <input type="text" name="description" class="login_form_input">
                <br>
                <p class="login_p">Enter book author: </p>
                <br>
                <input type="text" name="author" class="login_form_input">

                <br>
                <input type="submit" value="Send" name="button" class="button">

            </form>

        </div>

    </div>

</div>

<div id="clr"></div>
</div>
</body>

</html>