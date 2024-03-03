<%@ include file="init.jsp" %>


    <portlet:renderURL var="addEmployeeRenderURL">
        <portlet:param name="command" value="addEmployeeForm"/>
        <%-- <portlet:param name="mvcPath" value="/employeeForm.jsp" /> --%>
    </portlet:renderURL>

    <portlet:renderURL var="searchRenderURL">
        <portlet:param name="mvcPath" value="/employeeView.jsp" />
    </portlet:renderURL>
    <portlet:renderURL var="searchJoineesDateURL">
        <portlet:param name="mvcPath" value="/employeeView.jsp" />
    </portlet:renderURL>
    <portlet:actionURL var="deleteEmployeeActionURL" name="/deleteEmployeeAction">
        <portlet:param name="command" value="deleteDataURL" />
        <portlet:param name="employeeId" value="EMPLOYEE_ID" />
    </portlet:actionURL>

    <liferay-portlet:renderURL varImpl="iteratorURL">
        <portlet:param name="mvcPath" value="/employeeView.jsp" />
    </liferay-portlet:renderURL>

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

                        <a href="" onclick="deleteAction(${employee.getEmployeeId()})"
                            class="btn btn-danger">Delete</a>

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br>



    <a class="btn btn-primary" href="${addEmployeeRenderURL}">Add Employee</a>
    <portlet:renderURL var="searchEmployeeRenderURL">
        <portlet:param name="mvcPath" value="/employee/employeeSearchView.jsp" />
    </portlet:renderURL>
    <%-- <a class="btn btn-primary" href="${searchEmployeeRenderURL}">Search Container</a> --%>

    <script>
        function clearForm() {
            document.getElementById("searchForm").reset();
            location.reload();
        }

        function deleteAction(employeeId) {
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

                    setInterval(() => {
                        window.location.href = url;
                    }, 3000);

                    Swal.fire({
                        title: "Deleted!",
                        text: "Your file has been deleted.",
                        icon: "success",
                        timer: 3000
                    });
                }
            });
        }

		function liferayMessage() {
			var notification = document.getElementById('logoutNotification');

			// Display the notification
			notification.style.display = 'block';

			// Set a timeout to hide the notification after 2 seconds
			setTimeout(function() {
				notification.style.display = 'none';
				window.location.href = 'employeeView.jsp';
			}, 2000);
		}
	
    </script>