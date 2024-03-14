package com.aixtor.employee.headless.internal.resource.v1_0;

import com.aixtor.employee.headless.dto.v1_0.Employee;
import com.aixtor.employee.headless.dto.v1_0.EmployeeByDepartmentRequest;
import com.aixtor.employee.headless.dto.v1_0.EmployeeByDepartmentResponse;
import com.aixtor.employee.headless.dto.v1_0.Status;
import com.aixtor.employee.headless.resource.v1_0.GetEmployeesByDepartmentResource;
import com.aixtor.employee.model.Department;
import com.aixtor.employee.model.EmployeeCustom;
import com.aixtor.employee.service.DepartmentLocalService;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dev.joshi
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/get-employees-by-department.properties", scope = ServiceScope.PROTOTYPE, service = GetEmployeesByDepartmentResource.class)
public class GetEmployeesByDepartmentResourceImpl
        extends BaseGetEmployeesByDepartmentResourceImpl {
    @Reference
    EmployeeLocalService employeeLocalService;
    @Reference
    DepartmentLocalService departmentLocalService;
    @Reference
    UserLocalService userLocalService;
    private static final Log log = LogFactoryUtil.getLog(EmployeeByDepartmentResponse.class);

    @Override
    public EmployeeByDepartmentResponse postGetEmployeesByDepartment(
            EmployeeByDepartmentRequest employeeByDepartmentRequest)
            throws Exception {

        EmployeeByDepartmentResponse employeeByDepartmentResponse = new EmployeeByDepartmentResponse();
        String departmentName = "default";
        long departmentId = -1;
        try {
            if(employeeByDepartmentRequest.getDepartmentName()!=null)
                departmentName = employeeByDepartmentRequest.getDepartmentName();
            if (departmentName.isEmpty()  || departmentName.equals("default"))
                departmentName = "default";
            departmentId = employeeByDepartmentRequest.getDepartmentId();
        } catch (Exception ignored) {
        }
        if (!departmentName.equals("default") && departmentId >= 0) {
            //both
            try {
                List<Department> customDepartmentList = new ArrayList<>();
                customDepartmentList.add(departmentLocalService.getDepartment(departmentId));
                if (customDepartmentList.size() > 0) {

                    if (customDepartmentList.get(0).getName().equals(departmentName)) {
                        List<EmployeeCustom> customEmployeeList = employeeLocalService
                                .searchInEmployeesByDepartmentName(customDepartmentList.get(0).getName());

                        employeeByDepartmentResponse.setEmployees(convertEmployeeToObj(customEmployeeList));
                        employeeByDepartmentResponse.setTotalEmployee((long) customEmployeeList.size());
                        employeeByDepartmentResponse.setStatus(setStatus("Successful", "Data Retrieved successfully"));
                        employeeByDepartmentResponse.setDepartments(convertDepartmentToObj(customDepartmentList));

                    } else {
                        // ID and name are not matching Handle it
                        employeeByDepartmentResponse.setStatus(setStatus("Failure", "Id and Name does not match"));
                        return employeeByDepartmentResponse;
                    }
                } else {
                    employeeByDepartmentResponse.setStatus(setStatus("Failure", "No department found on Corresponding Id"));
                }
            }catch (Exception ignore)
            {
                employeeByDepartmentResponse.setStatus(setStatus("Failure", "No department found on Corresponding Id and Name"));

            }
        } else if (departmentId >= 0) {
            //only id available
            List<Department> customDepartmentListById = new ArrayList<>();
            try{
            customDepartmentListById
                    .add(departmentLocalService.getDepartment(employeeByDepartmentRequest.getDepartmentId()));
            if (!customDepartmentListById.isEmpty()) {
                List<EmployeeCustom> customEmployeeList = employeeLocalService
                        .searchInEmployeesByDepartmentName(customDepartmentListById.get(0).getName());
                employeeByDepartmentResponse.setEmployees(convertEmployeeToObj(customEmployeeList));
                employeeByDepartmentResponse.setTotalEmployee((long) customEmployeeList.size());
                employeeByDepartmentResponse.setStatus(setStatus("Success", "Data Retrieved successfully"));
                employeeByDepartmentResponse.setDepartments(convertDepartmentToObj(customDepartmentListById));
            } else {
                // no data on corresponding id
                employeeByDepartmentResponse.setStatus(setStatus("Success", "No data on corresponding id"));
            }}
            catch (Exception e){
                employeeByDepartmentResponse.setStatus(setStatus("failure", "No Department on corresponding id "));

            }

        } else if (!departmentName.equals("default")) {
            //only name available
            List<EmployeeCustom> customEmployeeList = employeeLocalService
                    .searchInEmployeesByDepartmentName(departmentName);
            List<Department> departmentList = new ArrayList<>();
            if (!customEmployeeList.isEmpty()) {
                departmentList
                        .add(departmentLocalService.getDepartment(customEmployeeList.get(0).departmentId.longValue()));
                employeeByDepartmentResponse.setEmployees(convertEmployeeToObj(customEmployeeList));
                employeeByDepartmentResponse.setTotalEmployee((long) customEmployeeList.size());
                employeeByDepartmentResponse.setStatus(setStatus("Success", "Data Retrieved successfully"));

                employeeByDepartmentResponse.setDepartments(convertDepartmentToObj(departmentList));
            } else {
                employeeByDepartmentResponse.setStatus(setStatus("Failure", "No data Found on Following Name"));
            }
        } else {
            //nothing Provide
            employeeByDepartmentResponse.setStatus(setStatus("Failure", "Provide at least one Parameter"));

        }


        return employeeByDepartmentResponse;
    }

    //convert service builder object to api builder object
    public Employee[] convertEmployeeToObj(List<EmployeeCustom> customEmployeeList) {
        com.aixtor.employee.headless.dto.v1_0.Employee[] employees = new com.aixtor.employee.headless.dto.v1_0.Employee[customEmployeeList
                .size()];

        int i = 0;
        for (EmployeeCustom e : customEmployeeList) {
            com.aixtor.employee.headless.dto.v1_0.Employee employee = new com.aixtor.employee.headless.dto.v1_0.Employee();
            employee.setEmployeeId(e.getEmployeeId().longValue());
            employee.setFirstName(e.getFirstName());
            employee.setLastName(e.getLastName());
            employee.setDepartmentName(e.getDepartmentName());
            employee.setDesignationName(e.getDesignationName());
            employee.setBranchName(e.getBranchName());
            employee.setEmail(e.getEmail());
            employee.setMobile(e.getMobileNumber() + "");

            employees[i++] = employee;

        }
        return employees;
    }

    public Status setStatus(String code, String message) {
        Status status = new Status();
        status.setCode(code);
        status.setMessage(message);
        return status;
    }

    //convert service builder object to api builder object
    public com.aixtor.employee.headless.dto.v1_0.Department[] convertDepartmentToObj(
            List<Department> customDepartmentList) {
        com.aixtor.employee.headless.dto.v1_0.Department[] departments = new com.aixtor.employee.headless.dto.v1_0.Department[customDepartmentList
                .size()];

        int i = 0;
        for (Department e : customDepartmentList) {
            com.aixtor.employee.headless.dto.v1_0.Department department = new com.aixtor.employee.headless.dto.v1_0.Department();
            department.setDepartmentId(e.getDepartmentId());
            department.setDepartmentName(e.getName());
            try {
                department.setDepartmentHead(userLocalService.getUserById(Long.parseLong(e.getDepartmentHead())).getFullName());
            }catch (Exception ignore)
            {
            }
            departments[i++] = department;

        }
        return departments;
    }
}