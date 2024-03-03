<%@ include file="init.jsp" %>

<portlet:renderURL var="addDepartmentRenderURL">
    <portlet:param name="mvcPath" value="/department/departmentForm.jsp"/>
</portlet:renderURL>


<h2>Department List</h2>
    
    <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>Name</th>
                <th>Head of Department</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach var="department" items="${DepartmentList}">
				<tr>
	                <td>${department.getName()}</td>
	                <td>${department.getDepartmentHead()}</td>
	            </tr>
			</c:forEach>        
        </tbody>
    </table>
<a class="btn btn-primary" href="${addDepartmentRenderURL}">Add Department</a>
