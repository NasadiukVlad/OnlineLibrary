<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 14.11.2015
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<a href="/AvailiableBooksController" class="top_menu_a">Availiable books</a>
<c:if test="${userStatus == 'user'}">
<a href="/DownloadPageController" class="top_menu_a">Download book</a>
</c:if>
<c:if test="${userStatus == 'user'}">
<a href="/UploadPageController" class="top_menu_a">Upload book</a>
</c:if>
<a href="/ArchivePageController" class="top_menu_a">Selected books</a>
<c:if test="${empty username}">
<a href="/LoginController" class="top_menu_a">Login</a>
<a href="RegistrationController" class="top_menu_a">Registration</a>
</c:if>



