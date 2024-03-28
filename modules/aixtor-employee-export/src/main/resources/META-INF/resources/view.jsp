<%@ include file="init.jsp" %>


<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="command" value="addEmployeeForm"/>
    <%-- <portlet:param name="mvcPath" value="/employeeForm.jsp" /> --%>
</portlet:renderURL>

<portlet:renderURL var="searchRenderURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="searchJoineesDateURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<portlet:actionURL var="deleteEmployeeActionURL" name="/deleteEmployeeAction">
    <portlet:param name="command" value="deleteDataURL"/>
    <portlet:param name="employeeId" value="EMPLOYEE_ID"/>
</portlet:actionURL>
<portlet:renderURL var="searchJoineesDateURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="searchRenderURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</portlet:renderURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
    <portlet:param name="mvcPath" value="/view.jsp"/>
</liferay-portlet:renderURL>

<%--<div class="container">--%>
<%--    <h3>Enter Date to Retrieve Joinees</h3>--%>
<%--    <form action="${searchJoineesDateURL}" method="post" id="searchForm">--%>
<%--        &lt;%&ndash; Create a Date object &ndash;%&gt;--%>
<%--        <% Date fromDate = new Date(); %>--%>
<%--        &lt;%&ndash; Format the Date object using SimpleDateFormat &ndash;%&gt;--%>
<%--        <% DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS"); %>--%>
<%--        <% String formattedFromDate = dateFormat.format(fromDate); %>--%>
<%--        &lt;%&ndash; Set the formatted date as the value of the date input field &ndash;%&gt;--%>
<%--        <div class="form-group">--%>
<%--            <label for="fromDate">From Date:</label>--%>
<%--            <input type="date" class="form-control" id="fromDate" name='<portlet:namespace/>fromDate'--%>
<%--                   value="${fromDate}" required>--%>
<%--        </div>--%>
<%--        <div class="form-group">--%>
<%--            <label for="toDate">To Date:</label>--%>
<%--            <input type="date" class="form-control m-2 p-2" id="toDate" name='<portlet:namespace/>toDate' value="${toDate}"--%>
<%--                   required>--%>
<%--        </div>--%>
<%--        <button type="submit" class="btn btn-primary m-2 p-2">Submit</button>--%>
<%--        <button type="reset" class="btn btn-primary m-2 p-2" onclick="clearForm()">Clear</button>--%>
<%--    </form>--%>
<%--</div>--%>

<div class="container">
    <div class="row justify-content-center ">
        <div class="">
            <form action="${searchRenderURL}" method="POST" id="myForm" class="form-inline">
                <div class="input-group">
                    <input type="text" class="form-control" id="inputSearch" name='<portlet:namespace/>name'
                           placeholder="Search..."
                           value="${searchHolder}">
                    <div class="input-group-append">
                        <button class="btn btn-primary" type="submit">Search</button>
                    </div>
                    <div>
                        <portlet:resourceURL var="exportEmployeeAsExcel" id="/exportEmployeeAsExcel">
                            <portlet:param name="mvcPath" value="/view.jsp"/>
                            <portlet:param name="export" value="exportCSV"/>
                            <portlet:param name="cmd" value="excel"/>
                        </portlet:resourceURL>
                        <button class="btn btn-primary" id="exportXLSX">Export Excel</button>
                    </div>
                    <div>
                        <portlet:resourceURL var="exportEmployeeAsPDF" id="/exportEmployeeAsExcel">
                            <portlet:param name="mvcPath" value="/view.jsp"/>
                            <portlet:param name="export" value="exportCSV"/>
                            <portlet:param name="cmd" value="pdf"/>
                        </portlet:resourceURL>
                        <button class="btn btn-primary" id="exportPDF">Export pdf</button>
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
                    <portlet:param name="command" value="edit"/>
                    <portlet:param name="employeeId" value="${employee.getEmployeeId()}"/>
                </portlet:renderURL>
                <a href="${updateDataURL}" class="btn btn-success">Update</a><br>
            </td>
            <td>
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
    <portlet:param name="mvcPath" value="/employee/employeeSearchView.jsp"/>
</portlet:renderURL>
<%-- <a class="btn btn-primary" href="${searchEmployeeRenderURL}">Search Container</a> --%>

<script>
    function downloadFileFromBlob(blob, fileName) {
        const aElement = document.createElement('a');
        aElement.setAttribute('download', fileName);
        const href = URL.createObjectURL(blob);
        aElement.href = href;
        aElement.setAttribute('target', '_blank');
        aElement.click();
        URL.revokeObjectURL(href);
    }

    $(document).ready(function () {
        console.log("ready");
        var fullNameInput = document.getElementById('inputSearch');
        var exportButton = document.getElementById('exportXLSX');
        var exportpdf = document.getElementById('exportPDF');
        if (fullNameInput.value.trim().length > 0) {
            exportButton.disabled = false;
            exportpdf.disabled = false;
        } else {
            exportButton.disabled = true;
            exportpdf.disabled = true;
        }
        $('#exportXLSX').on('click', function () {
            $.ajax({
                url: '${exportEmployeeAsExcel}',
                type: 'POST',
                data: {
                    '<portlet:namespace/>name': $(this).val()
                },
                xhrFields: {
                    responseType: 'blob' // Set the response type to 'blob' to handle binary data
                },
                success: function (data, textStatus, jqXHR) {
                    const fileName = 'employee.xlsx';
                    downloadFileFromBlob(data, fileName);
                },
                error: function (xhr, status, error) {
                    console.log('Error making AJAX request:', error);
                }
            });
        })


        $('#exportPDF').on('click', function () {
            console.log("ajax called for pdf");
            $.ajax({
                url: '${exportEmployeeAsPDF}',
                type: 'POST',
                data: {
                    '<portlet:namespace/>name': $(this).val()
                },
                xhrFields: {
                    responseType: 'blob' // Set the response type to 'blob' to handle binary data
                },
                success: function (data, textStatus, jqXHR) {
                    const fileName = 'employee.pdf';
                    console.log("ajax successfully");
                    downloadFileFromBlob(data, fileName);
                },
                error: function (xhr, status, error) {
                    console.log('Error making AJAX request:', error);
                }
            });
        });
    });

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
</script>
