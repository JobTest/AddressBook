<!--Header Block-->
<%@include file="includes/header.jsp" %>

<!--Menu Block-->
<%@include file="includes/menu.jsp" %>

<!--Edit Page-->
<h2><spring:message code="label.edit" /></h2>

<form:form method="post" action="/AddressBook/update" commandName="contact" name="edit_form" id="edit_form">
<form:hidden path="username" />
<table class="data-form" BORDER="0" WIDTH="600" CELLPADDING="3" CELLSPACING="0">
    <tr>
        <td align="right">
            <form:label path="fio">
                <spring:message code="label.fio" />
            </form:label>
        </td>
        <td><form:input path="fio" /></td>
    </tr>
    <tr>
        <td align="right">
            <form:label path="email">
                <spring:message code="label.email" />
            </form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td align="right" valign="top">
            <form:label path="address">
                <spring:message code="label.address" />
            </form:label>
        </td>
        <td><form:textarea path="address" cols="28" rows="5"></form:textarea></td>
    </tr>
    <tr>
        <td align="right">
            <form:label path="telephone">
                <spring:message code="label.telephone" />
            </form:label></td>
        <td><form:input path="telephone" /></td>
    </tr>
    <tr>
        <td align="right">
            <form:label path="organization">
                <spring:message code="label.organization" />
            </form:label></td>
        <td><form:input path="organization" /></td>
    </tr>
    <tr>
        <td align="right">
            <form:label path="position">
                <spring:message code="label.position" />
            </form:label></td>
        <td>
            <form:select path="position">
                <form:option value=""></form:option>
                <c:forEach items="${positions}" var="position">
                    <form:option value="${position}">${position}</form:option>
                </c:forEach>
            </form:select>
        </td>
    </tr>
    <tr>
        <td align="right">
            <spring:message code="label.oldpassword" />
        </td>
        <td>
            <input name="oldpassword" id="oldpassword" type="password" />
        </td>
    </tr>
    <tr>
        <td align="right">
            <form:label path="password">
                <spring:message code="label.password" />
            </form:label></td>
        <td>
            <form:hidden path="password" />
            <input name="unprotectedpassword" id="unprotectedpassword" type="password" />
        </td>
    </tr>
    <tr>
        <td align="right">
            <spring:message code="label.confirmpassword" />
        </td>
        <td>
            <input name="confirmpassword" id="confirmpassword" type="password" />
        </td>
    </tr>
    <tr>
        <td align="center" colspan="2">
            <hr />
            <input type="button" value="<spring:message code="label.contacts"/>" onclick="location.href='/AddressBook/list?sort='" />
            <input type="button" value="<spring:message code="label.view"/>" onclick="location.href='/AddressBook/view/${contactUsername}'" />
            <input type="submit" value="<spring:message code="label.changescontact"/>" onclick="encrypt_password(this.form);" class="edit" <c:if test="${ActiveUser ne contact.username}"> disabled="disabled" </c:if> />
            <input type="reset" value="Reset" />
        </td>
    </tr>
</table>
</form:form>

<!--Footer Block-->
<%@include file="includes/footer.jsp" %>