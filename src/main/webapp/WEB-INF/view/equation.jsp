<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 
<h2>Employee Management Screen</h2>
 
<form:form method="post" action="add" commandName="equation">
 
    <table>
    <tr>
        <td><form:label path="a"><spring:message code="label.a"/></form:label></td>
        <td><form:input path="a" /></td>
    </tr>
    <tr>
        <td><form:label path="b"><spring:message code="label.b"/></form:label></td>
        <td><form:input path="b" /></td>
    </tr>
    <tr>
        <td><form:label path="c"><spring:message code="label.c"/></form:label></td>
        <td><form:input path="c" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table> 
</form:form>
 
</body>
</html>