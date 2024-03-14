<%@ include file="init.jsp" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:renderURL var="addEmployeeRenderURLNew">
    <portlet:param name="mvcPath" value="/greeting.jsp" />
</portlet:renderURL>
<portlet:actionURL var="addEmployeeRenderURL" />

<h2>Employee List</h2>

<table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Department</th>
        <th>Branch</th>
        <th>Designation</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employeeList}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.email}</td>
            <td>${employee.mobileNumber}</td>
            <td>${employee.departmentId}</td>
            <td>${employee.designationId}</td>
            <td>${employee.branchId}</td>
            <td>${employee.address}</td>
            <td>
                <portlet:renderURL var="updateDataURL">
                    <portlet:param name="command" value="edit" />
                    <portlet:param name="employeeId" value="${employee.getEmployeeId()}" />
                </portlet:renderURL>
                <a href="${updateDataURL}" class="btn btn-success">Update</a><br>

                <a href="#" onclick="deleteAction(${employee.getEmployeeId()})" class="btn btn-danger">Delete</a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a class="btn btn-primary" href="${addEmployeeRenderURLNew}">Add Employee</a>
<portlet:renderURL var="searchEmployeeRenderURL">
    <portlet:param name="mvcPath" value="/employee/employeeSearchView.jsp" />
</portlet:renderURL>
<a class="btn btn-primary" href="${addEmployeeRenderURLNew}">Search Container</a>
<portlet:actionURL var="redirectURL" name="redirectAction" />
<a href="${redirectURL}" name="redirect">go to my page via a redirection</a>
