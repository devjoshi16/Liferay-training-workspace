<%@ include file="init.jsp"%>
<%@ page import="com.liferay.portal.kernel.model.User" %>

<portlet:actionURL name="/add-department" var="addDepartmentURL" />


<p>Department Form</p>


<form action="${addDepartmentURL}" method="post">
	<div class="form-group">
		<label class="" for="0">Department Name</label> <input id="0"
			placeholder="Enter Department Name" class="form-control" type="text"
			name="<portlet:namespace/>departmentName" value="">
	</div>
	
	<div class="form-group">
		<label class="" for="hod">Head of Deapartment</label> <select aria-label="Label"
			id="hod" name="<portlet:namespace/>hod" class="form-control">
			<option value="">Select Head of Deapartment</option>
			<c:forEach var="user" items="${userList}">
				<option value="${user.getPrimaryKey()}">${user.getFullName()}</option>
			</c:forEach>
		</select>
	</div>
	
	

	<div class="form-group">
		<button class="btn btn-primary" type="submit">Submit</button>
	</div>
</form>
