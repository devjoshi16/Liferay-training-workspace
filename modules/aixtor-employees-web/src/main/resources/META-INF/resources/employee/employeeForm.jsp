<%@ include file="init.jsp"%>

<%@page import="com.aixtor.employee.model.Department" %>

<portlet:actionURL name="addEmployee" var="addEmployeeURL" />
<portlet:actionURL name="updateEmployee" var="updateEmployeeURL" />
<portlet:defineObjects />
<p>Employee Form</p>

<aui:form action="${employee!=null?updateEmployeeURL:addEmployeeURL}" method="post">
    <aui:input name="employeeId" label="Employee ID" type="hidden" value='${cmd.equals("edit")?employee.employeeId:0}'/>

    <aui:input name="firstName" label="First Name" placeholder="Enter First Name" value='${cmd.equals("edit")?employee.firstName:""}' />

    <aui:input name="lastName" label="Last Name" placeholder="Enter Last Name" value='${cmd.equals("edit")?employee.lastName:""}'/>

    <aui:input name="email" label="Email" placeholder="Enter Email" value='${cmd.equals("edit")?employee.email:""}' />

    <aui:input name="mobile" label="Mobile" placeholder="Enter Mobile" type="number" value='${cmd.equals("edit")?employee.mobileNumber:""}' />

    <aui:select name="department" label="Department">
        <aui:option value="">Select Department</aui:option>
        <c:forEach var="department" items="${departmentList}">
            <aui:option value="${department.getPrimaryKey()}" selected='${department.departmentId == employee.departmentId}'>${department.getName()}</aui:option>
        </c:forEach>
    </aui:select>

    <aui:select name="branch" label="Branch">
        <aui:option value="">Select Branch</aui:option>
        <c:forEach var="branch" items="${branchList}">
            <aui:option value="${branch.getPrimaryKey()}" selected="${branch.branchId == employee.branchId}">${branch.getName()}</aui:option>
        </c:forEach>
    </aui:select>

    <aui:select name="designation" label="Designation">
        <aui:option value="">Select Designation</aui:option>
        <c:forEach var="designation" items="${designationList}">
            <aui:option value="${designation.getPrimaryKey()}" selected="${designation.designationId == employee.designationId}">${designation.getName()}</aui:option>
        </c:forEach>
    </aui:select>

    <aui:input name="address" label="Address" placeholder="Enter Address" value='${cmd.equals("edit")?employee.address:""}' />

    <aui:button type="submit" value="Submit" />
</aui:form>


























<%-- <%@ include file="init.jsp"%>

<%@page import="com.aixtor.employee.model.Department" %>

<portlet:actionURL name="addEmployee" var="addEmployeeURL" />
<portlet:actionURL name="updateEmployee" var="updateEmployeeURL" />
<portlet:defineObjects />
<p>Employee Form</p>


<form action="${employee!=null?updateEmployeeURL:addEmployeeURL}" method="post">
	<div class="form-group">
		<input id="4"class="form-control" type="hidden" name="<portlet:namespace/>employeeId" 
		value='${cmd.equals("edit")?employee.employeeId:0}'>
	</div>
	<div class="form-group">
		<label class="" for="0">First name</label> <input id="0"
			placeholder="Enter firstName" class="form-control" type="text"
			name="<portlet:namespace/>firstName" value='${cmd.equals("edit")?employee.firstName:""}'>
	</div>
	<div class="form-group">
		<label class="" for="1">Lastname</label> <input id="1"
			placeholder="Enter Lastname" class="form-control" type="text"
			name="<portlet:namespace/>lastName" value='${cmd.equals("edit")?employee.lastName:""}'>
	</div>
	<div class="form-group">
		<label class="" for="2">Email</label> <input id="2"
			placeholder="Enter Email" class="form-control" type="text"
			name="<portlet:namespace/>email" value='${cmd.equals("edit")?employee.email:""}'>
	</div>
	
	<div class="form-group">
		<label class="" for="3">Mobile</label> <input id="3"
			placeholder="Enter Mobile" class="form-control" type="number"
			name="<portlet:namespace/>mobile" value='${cmd.equals("edit")?employee.mobileNumber:""}'>
	</div>
	
	
	<div class="form-group">
		<label class="" for="department">Department</label> <select aria-label="Label"
			id="department" name="<portlet:namespace/>department" class="form-control">
			<option value="">Select Department</option>
			<c:forEach var="department" items="${departmentList}">
				<option ${ department.departmentId == employee.departmentId ? 'selected' : ''}  value="${department.getPrimaryKey()}">${department.getName()}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label class="" for="branch">Branch</label> <select aria-label="Label"
			id="branch" name="<portlet:namespace/>branch" class="form-control">
			<option value="">Select Branch</option>
			<c:forEach var="branch" items="${branchList}">
				<option  ${ branch.branchId == employee.branchId ? 'selected' : ''}  value="${branch.getPrimaryKey()}">${branch.getName()}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="form-group">
		<label class="" for="designation">Designation</label> <select aria-label="Label"
			id="designation" name="<portlet:namespace/>designation" class="form-control">
			<option value="">Select Designation</option>
			<c:forEach var="designation" items="${designationList}">
				<option ${ designation.designationId == employee.designationId ? 'selected' : ''} value="${designation.getPrimaryKey()}">${designation.getName()}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="form-group">
		<label class="" for="4">Address</label> <input id="4"
			placeholder="Enter Address" class="form-control" type="text"
			name="<portlet:namespace/>address" value='${cmd.equals("edit")?employee.address:""}'>
	</div>	
	
	
	<div class="form-group">
		<button class="btn btn-primary" type="submit">Submit</button>
	</div>
</form>

 --%>