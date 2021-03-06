<!--Header Block-->
<%@include file="WEB-INF/views/includes/header.jsp" %>

<!--Menu Block-->
<%@include file="WEB-INF/views/includes/menu.jsp" %>



<!--Login Page-->
<h2><spring:message code="label.login" /></h2>

<c:if test="${not empty param.error}">
    <font color="red"> <spring:message code="label.loginerror" />
    : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message} </font>
</c:if>
<form method="POST" action="<c:url value="/j_spring_security_check" />" name="login_form" id="login_form">
    <table class="data-login" BORDER="0" WIDTH="450" CELLPADDING="3" CELLSPACING="0">
        <tr>
            <td align="right"><spring:message code="label.username" /></td>
            <td>
                <input type="text" name="username" id="username" />
            </td>
        </tr>
        <tr>
            <td align="right"><spring:message code="label.password" /></td>
            <td>
                <input type="hidden" name="password" id="password" />
                <input name="unprotectedpassword" id="unprotectedpassword" type="password" />
            </td>
        </tr>
        <tr>
            <td align="right"><spring:message code="label.remember" /></td>
            <td><input type="checkbox" name="_spring_security_remember_me" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="<spring:message code="label.login" />" onclick="encrypt_password(this.form);" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="reset" value="Reset" />
            </td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>



<!--Footer Block-->
<%@include file="WEB-INF/views/includes/footer.jsp" %>