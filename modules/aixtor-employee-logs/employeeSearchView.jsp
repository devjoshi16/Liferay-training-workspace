
<%@ include file="init.jsp"%>
<%@page import="com.aixtor.employee.model.EmployeeCustom"%>
<%@page import="com.aixtor.employee.service.EmployeeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.aixtor.employee.model.Employee"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>




<liferay-portlet:renderURL varImpl="iteratorURL">
       <portlet:param name="mvcPath" value="/employee/employeeSearchView.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:actionURL var="deleteEmployeeActionURL" name="deleteEmployeeAction">
<%--        <portlet:param name="employeeId" value="" />
 --%>
 <portlet:param name="employeeId" value="<%=currentObjectEmployeeCustom.employeeId%>" />

</liferay-portlet:actionURL>
	

<liferay-ui:success key="deleteSuccess" message="Data deleted successfully!!" />
<liferay-ui:error key="deleteFail" message="Data delete Failed!!" />



<liferay-ui:search-container 
	emptyResultsMessage="there-are-no-autodetails"
	headerNames="
			FirstName,
            LastName,
            Email,
            Mobile,
            Department,
            Branch,
            Designation,
            Address,
            Actions"
	iteratorURL="<%=iteratorURL%>" delta="10" deltaConfigurable="true" 
	total="<%=EmployeeLocalServiceUtil.getEmployeesCount()%>"
	>
	
	<liferay-ui:search-container-results>
		<%
		
			List<EmployeeCustom> employeeDetailsList = EmployeeLocalServiceUtil.searchInEmployees("");
					results = ListUtil.subList(employeeDetailsList, searchContainer.getStart(), searchContainer.getEnd());
					searchContainer.setResultsAndTotal(results);
		%>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row className="EmployeeCustom"
		keyProperty="employeeId" modelVar="currentObjectEmployeeCustom"  >
		<liferay-ui:search-container-column-text name="FirstName"
			property="firstName" />
		<liferay-ui:search-container-column-text name="LastName"
			property="lastName" />
		<liferay-ui:search-container-column-text name="Email"
			property="email" />
			<liferay-ui:search-container-column-text name="Mobile"
			property="mobileNumber" />
		<liferay-ui:search-container-column-text name="Department"
			property="departmentName" />		
		<liferay-ui:search-container-column-text name="Branch"
			property="branchName" />		
		<liferay-ui:search-container-column-text name="Designation"
			property="designationName" />		
		<liferay-ui:search-container-column-text name="Address"
			property="address" />	
			
		<%-- <liferay-ui:search-container-column name="Actions">
		    <aui:button value="Delete" onClick="javascript:deleteAction(<%=currentObjectEmployeeCustom.getEmployeeId()%>)" />
		</liferay-ui:search-container-column> --%>
		
<%-- 		<liferay-ui:search-container-column-button  onClick="javascript:deleteAction(<%=currentObjectEmployeeCustom.getEmployeeId()%>)"  name="delete" />
 --%> 				
		<%-- <liferay-ui:search-container-column-icon icon="trash"
        href="deleteAction('<%=currentObjectEmployeeCustom.getEmployeeId()%>')"></liferay-ui:search-container-column-icon> --%>

		<liferay-ui:search-container-column-icon icon="trash"
        href=${deleteEmployeeActionURL}></liferay-ui:search-container-column-icon>
	</liferay-ui:search-container-row>
	
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<script>
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