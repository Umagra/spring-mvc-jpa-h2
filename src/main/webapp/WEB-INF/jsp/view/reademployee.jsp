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
<h1  align="center">All Employees</h1>
<table border="2" width="70%" cellpadding="2"  align="center">
    <tr>
        <th>id</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Dob</th>
        <th>Departments</th>
        <th>Salary</th>
        <th>Manager</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.dob}</td>
            <td>${employee.departments}</td>
            <td>${employee.salary}</td>
            <td>${employee.manager}</td>
            <td><a href="/update-employee/${employee.id}">Update</a></td>
            <td><a href="/delete-employee/${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<h4 align="center"><a href="/create-employee">Create Employee</a></h4>
</body>
<br>
<br>
<br>
<br>