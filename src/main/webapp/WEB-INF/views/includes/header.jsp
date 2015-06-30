<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /> &raquo; <c:if test="${!empty pagename}"><spring:message code="label.${pagename}" /></c:if><c:if test="${empty pagename}"><spring:message code="label.login" /></c:if></title>

    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .security-contact {
        <c:choose>
            <c:when test="${ActiveUser eq 'admin'}">color: red;</c:when>
            <c:otherwise>color: #E0E0E0;</c:otherwise>
        </c:choose>
        }
        .security-new {
        <c:choose>
            <c:when test="${ActiveUser eq 'guest'}">color: #00BB00;</c:when>
            <c:otherwise>color: #E0E0E0;</c:otherwise>
        </c:choose>
        }
    </style>

    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.7.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/resources/js/script.js" type="text/javascript"></script>
    <script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/aes.js"></script>
    <script src="http://crypto-js.googlecode.com/svn/tags/3.1.2/build/rollups/pbkdf2.js"></script>
    <script>
        function encrypt_password(obj)
        {
            var unprotectedpassword = document.getElementById("unprotectedpassword").value;
            var            username = document.getElementById("username").value;

            var                    salt = CryptoJS.lib.WordArray.random(128/8);
            var key256Bits500Iterations = CryptoJS.PBKDF2(username, salt, { keySize: 256/32, iterations: 500 });
            var                     iv  = CryptoJS.enc.Hex.parse('101112131415161718191a1b1c1d1e1f');

            var encrypted = CryptoJS.AES.encrypt(unprotectedpassword+"_Messsage", key256Bits500Iterations, { iv: iv });
            var iv_base64 = encrypted.iv.toString(CryptoJS.enc.Base64);
            document.getElementById("password").value = iv_base64;
        }
    </script>
</head>

<body>
    <center>