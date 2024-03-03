<%@page import="com.aixtor.employee.service.EmployeeLocalService"%>
<%@ include file="init.jsp" %>
<%@ page import="com.aixtor.employee.portlet.AixtorEmployeePortlet" %>
<%@ page import="com.aixtor.employee.model.EmployeeCustom" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>

<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="command" value="addEmployeeForm"/>
    <portlet:param name="mvcPath" value="/employee/employeeForm.jsp"/>
 </portlet:renderURL>

<portlet:renderURL var="searchRenderURL">
    <portlet:param name="mvcPath" value="/employee/employeeView.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="searchJoineesDateURL">
    <portlet:param name="mvcPath" value="/employee/employeeView.jsp"/>
</portlet:renderURL>
<portlet:actionURL var="deleteEmployeeActionURL" name="deleteEmployeeAction">
	<portlet:param name="command" value="deleteDataURL" />
	<portlet:param name="employeeId" value="EMPLOYEE_ID" />
</portlet:actionURL>

<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/employee/employeeView.jsp" />
</liferay-portlet:renderURL>
<h2>New Employee</h2>

<div class="container">
    <h3>Enter Date to Retrieve Joinees</h3>
    <form action="${searchJoineesDateURL}" method="post" id="searchForm">
        <%-- Create a Date object --%>
        <% Date fromDate = new Date(); %>
        <%-- Format the Date object using SimpleDateFormat --%>
        <% DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS"); %>
        <% String formattedFromDate = dateFormat.format(fromDate); %>
        <%-- Set the formatted date as the value of the date input field --%>
        <div class="form-group">
            <label for="fromDate">From Date:</label>
            <input type="date" class="form-control" id="fromDate" name='<portlet:namespace/>fromDate' value="${fromDate}" required>
        </div>
        <div class="form-group">
            <label for="toDate">To Date:</label>
            <input type="date" class="form-control" id="toDate" name='<portlet:namespace/>toDate' value="${toDate}" required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-primary" onclick="clearForm()">Clear</button>
    </form>
</div>

<div class="container">
    <div class="row justify-content-center ">
        <div class="">
            <form action="${searchRenderURL}" method="POST" class="form-inline">
                <div class="input-group">
                    <input type="search" class="form-control" name='<portlet:namespace/>name' placeholder="Search..." value='${searchHolder}'>
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

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
                <td>${employee.departmentName}</td>
                <td>${employee.designationName}</td>
                <td>${employee.branchName}</td>
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



<a class="btn btn-primary" href="${addEmployeeRenderURL}">Add Employee</a>
<portlet:renderURL var="searchEmployeeRenderURL">
    <portlet:param name="mvcPath" value="/employee/employeeSearchView.jsp"/>
</portlet:renderURL>
<a class="btn btn-primary" href="${searchEmployeeRenderURL}">Search Container</a>

<script>
    function clearForm() {
        document.getElementById("searchForm").reset();
        location.reload();
    }
    
    function deleteAction(employeeId){
    	let url = '${deleteEmployeeActionURL}';
    	console.log(employeeId);
    	url = url.replace('EMPLOYEE_ID', employeeId);
    	Swal.fire({
    		  title: "Are you sure?",
    		  text: "This process is irreversible!",
    		  icon: "warning",
    		  showCancelButton: true,
    		  confirmButtonColor: "#3085d6",
    		  cancelButtonColor: "#d33",
    		  confirmButtonText: "Yes, delete it!"
    		}).then((result) => {
    		  if (result.isConfirmed) {
    		
    		    setInterval(() =>{
    		    	window.location.href = url;
    		    },3000);
    		    
    		    Swal.fire({
    			      title: "Deleted!",
    			      text: "Your file has been deleted.",
    			      icon: "success",
    			      timer: 3000
    			    });
    		  }
    		});
    }
</script>
