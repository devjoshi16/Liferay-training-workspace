<%--
  Created by IntelliJ IDEA.
  User: dev.joshi
  Date: 07-Mar-24
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="init.jsp"%>

<%@page import="com.aixtor.employee.model.Department" %>
<%@page import="com.aixtor.employee.spring.mvc.dto.EmployeePojo" %>
<%--<portlet:actionURL var="addEmployeeURL" >--%>
<portlet:actionURL name="addEmployee" var="addEmployeeURL" >
    <portlet:param name="action" value="addEmployee"/>
</portlet:actionURL>
<portlet:actionURL name="updateEmployee" var="updateEmployeeURL" />
<portlet:defineObjects />
<p>Employee Form</p>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<portlet:defineObjects />
<portlet:actionURL var="submitFormURL" name="registerAction"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee</title>
</head>
<body>
<div class="container">
    <c:out value="Hello Java"></c:out>

    <form:form action="${submitFormURL.toString() }" id="${namespace}employeeForm" method="post" class="user-form" modelAttribute="Employeepojo">
        Employee first Name: <input type="text" class="form-control" name="${namespace}firstName" id="${namespace}firstName">
        Employee last Name: <input type="text" class="form-control" name="${namespace}lastName" id="${namespace}lastName">
        Email: <input type="email" class="form-control" name="${namespace}email" id="${namespace}email">
        Mobile Number: <input type="number" class="form-control" name="${namespace}mobileNumber" id="${namespace}mobileNumber">
        Department Id:
        <select class="form-control" name="${namespace}departmentId" id="${namespace}departmentId">
            <c:forEach var="department" items="${departmentList }">
                <option value="${department.departmentId }">${department.getName() }</option>
            </c:forEach>
        </select>
        Designation Id:
        <select class="form-control" name="${namespace}designationId" id="${namespace}designationId">
            <c:forEach var="designation" items="${designationList }">
                <option value="${designation.designationId }">${designation.getName() }</option>
            </c:forEach>
        </select>
        Branch Id:
        <select class="form-control" name="${namespace}branchId" id="${namespace}branchId">
            <c:forEach var="branch" items="${branchList }">
                <option value="${branch.branchId }">${branch.name }</option>
            </c:forEach>
        </select>
        Address: <textarea class="form-control" rows="3" cols="20" name="${namespace}address" id="${namespace}address"></textarea>
        <br>
        <input type="submit" class="btn btn-primary" value="Submit">
    </form:form>
</div>
</body>
</html>

