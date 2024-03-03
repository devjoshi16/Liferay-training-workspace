<%@ include file="init.jsp" %>
<%@ page import="com.aixtor.employee.model.Designation" %>
<portlet:renderURL var="addDesignationRenderURL">
    <portlet:param name="mvcPath" value="/designation/designationForm.jsp"/>
</portlet:renderURL>


<h3>Designation List</h3>
   
     <table class="table table-bordered">
        <thead class="thead-dark">
            <tr>
                <th>Name</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="designation" items="${designationList}">
				<tr>
	                <td>${designation.getName()}</td>
	            </tr>
			</c:forEach>    	
        </tbody>
    </table>
<a class="btn btn-primary" href="${addDesignationRenderURL}">Add Designation</a>

