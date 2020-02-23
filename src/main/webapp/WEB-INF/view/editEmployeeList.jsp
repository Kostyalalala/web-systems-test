<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
 
<h2>Employee Management Screen</h2>
 
<form:form method="post" action="add" commandName="employee">
 
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
        <td><form:label path="determinant"><spring:message code="label.determinant"/></form:label></td>
        <td><form:input path="determinant" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.add"/>"/>
        </td>
    </tr>
</table> 
</form:form>
 
     
<h3>Employees</h3>
<c:if  test="${!empty employeeList}">
<table class="data">
<tr>
    <th>a</th>
    <th>b</th>
    <th>c</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${employeeList}" var="emp">
    <tr>
        <td>${emp.a}, ${emp.b} </td>
        <td>${emp.c}</td>
        <td>${emp.determinant}</td>
        <td><a href="delete/${emp.id}">delete</a></td>
    </tr>
</c:forEach>
</table>
</c:if>
 
</body>
</html>