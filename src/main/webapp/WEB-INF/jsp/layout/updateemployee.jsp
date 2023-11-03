<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<br>
<br>
<br>
<br>
<body   align="center">
<h1 >Update Employee</h1>
<form:form   align="center" method="post" action="/updateemployee/${id}">
    <table align="center">
        <tr>
            <td>FirstName: </td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>LastName: </td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td>Dob: </td>
            <td><form:input path="dob"/></td>
        </tr>
        <tr>
            <td>Department: </td>
            <td>
            <select style="width: 100px;" name="departments">
                <c:forEach items="${departments}" var="departments">
                    <option value="${departments}">${departments}</option>
                </c:forEach>
            </select>
            </td>
            <td>
        </tr>
        <tr>
            <td>Salary: </td>
            <td><form:input path="salary"/></td>
        </tr>
       <tr>
           <td>Manager: </td>
           <td>
           <select style="width: 100px;" name="manager">
               <option value=""></option>
               <c:forEach items="${manager}" var="category">
                   <option value="${category}">${category}</option>
               </c:forEach>
           </select>
           </td>
           <td>
       </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Update" /></td>
        </tr>
    </table>
</form:form>
</body>
<br>
<br>
<br>
<br>