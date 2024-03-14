<%@ include file="init.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <form id="myForm" name="myform" method="post">
                <div class="form-group">
                    <label for="branchId">Branch ID</label>
                    <input type="number" class="form-control" id="branchId" name="branchId">
                </div>
                <div class="form-group">
                    <label for="branchName">Branch Name</label>
                    <input type="text" class="form-control" id="branchName" name="branchName">
                </div>
                <button type="submit" onsubmit="submitForm()" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


<table id="employeeTable">
    <thead>
    <tr>
        <th>Employee ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Designation</th>
    </tr>
    </thead>
    <tbody id="employeeTableBody">
    <!-- Employee data will be dynamically added here -->
    </tbody>
</table>

<script>

    $('#myForm').on('submit', e => {
        e.preventDefault();
        console.log("ajax Called");
        const branchId = $("#branchId").val();
        const branchName = $("#branchName").val();
// Construct the data object for the AJAX request
        const requestData = {
            branchId: branchId,
            branchName: branchName
        }
// Convert the data object to JSON format
        const jsonData = JSON.stringify(requestData);
        console.log(jsonData);

        $.ajax({
            url: "http://localhost:8080/o/aixtor-employee-headless/v1.0/getEmployeesByBranch",
            type: 'POST',
            contentType: 'application/json',
            dataType: 'json', // data type
            data: jsonData,
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa("test@liferay.com" + ":" + "test"));
            },
            success: function (response) {
// Handle success response
                console.log(response);
                const  data=response;
                setDataInTable(data);
            },
            error: function (xhr, status, error) {
// Handle error
                console.error(xhr.responseText);
            }
        });
    });

    function setDataInTable(data) {
        const employeeData=data.valueOf("employees");
        console.log(employeeData);

        const employeeData3=data.employees;
        console.log(employeeData3);
        const employeeTableBody = document.getElementById("employeeTableBody");

// Iterate over each employee and create table rows
        employeeData3.forEach(employee => {
            const row = document.createElement("tr");
            row.innerHTML = `
<td>${employee.employeeId}</td>
<td>${employee.firstName}</td>
<td>${employee.lastName}</td>
<td>${employee.email}</td>
<td>${employee.mobile}</td>
<td>${employee.designationName}</td>
`;
            employeeTableBody.appendChild(row);
        });
    }
</script>