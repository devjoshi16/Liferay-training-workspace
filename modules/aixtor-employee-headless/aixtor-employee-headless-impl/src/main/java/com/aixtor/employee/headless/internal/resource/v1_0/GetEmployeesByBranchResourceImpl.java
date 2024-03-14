package com.aixtor.employee.headless.internal.resource.v1_0;

import com.aixtor.employee.headless.dto.v1_0.*;
import com.aixtor.employee.headless.resource.v1_0.GetEmployeesByBranchResource;
import com.aixtor.employee.model.BranchCustom;
import com.aixtor.employee.model.EmployeeCustom;
import com.aixtor.employee.service.BranchLocalService;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dev.joshi
 */
@Component(
		properties = "OSGI-INF/liferay/rest/v1_0/get-employees-by-branch.properties",
		scope = ServiceScope.PROTOTYPE, service = GetEmployeesByBranchResource.class
)
public class GetEmployeesByBranchResourceImpl extends BaseGetEmployeesByBranchResourceImpl {
	@Reference
	EmployeeLocalService employeeLocalService;
	@Reference
	BranchLocalService branchLocalService;

	private static final Log log = LogFactoryUtil.getLog(GetEmployeesByBranchResourceImpl.class);

	@Override
	public EmployeeByBranchResponse postGetEmployeesByBranch(EmployeeByBranchRequest employeeByBranchRequest) throws Exception {
		EmployeeByBranchResponse employeeByBranchResponse = new EmployeeByBranchResponse();

		String branchName = "default";
		long branchId = -1;
		try {
			if(employeeByBranchRequest.getBranchName()!=null)
				branchName = employeeByBranchRequest.getBranchName();
			if (branchName.isEmpty()  || branchName.equals("default"))
				branchName = "default";
			branchId = employeeByBranchRequest.getBranchId();
		} catch (Exception ignored) {
		}
		if (!branchName.equals("default") && branchId >= 0) {
			try{
			List<com.aixtor.employee.model.Branch> customBranchList = new ArrayList<>();
			customBranchList.add(branchLocalService.getBranch(branchId));
			if (customBranchList.size() > 0) {
				if (customBranchList.get(0).getName().equals(branchName)) {
					List<EmployeeCustom> customEmployeeList = employeeLocalService.searchInEmployeesByBranchName(customBranchList.get(0).getName());
					employeeByBranchResponse.setEmployees(convertEmployeeToObj(customEmployeeList));
					employeeByBranchResponse.setTotalEmployee((long) customEmployeeList.size());
					employeeByBranchResponse.setStatus(setStatus("Successful", "Data Retrieved successfully"));
					employeeByBranchResponse.setBranches(convertBranchToObj(convertBranchToCustomBranch(customBranchList.get(0).getName())));
				} else {
					// ID and name are not matching Handle it
					employeeByBranchResponse.setStatus(setStatus("Failure", "Id and Name does not match"));
					return employeeByBranchResponse;
				}
			}else{
				employeeByBranchResponse.setStatus(setStatus("Failure", "No Branch on corresponding Id"));
			}
			}catch(Exception ignore)
			{
				employeeByBranchResponse.setStatus(setStatus("Failure", "No Branch on corresponding Id and Name"));

			}

		} else if (branchId >= 0) {
			try{
			List<com.aixtor.employee.model.Branch> branchListById = new ArrayList<>();
			branchListById.add(branchLocalService.getBranch(branchId));
				if (!branchListById.isEmpty()) {
					List<EmployeeCustom> customEmployeeList = employeeLocalService.searchInEmployeesByBranchName(branchListById.get(0).getName());
					employeeByBranchResponse.setEmployees(convertEmployeeToObj(customEmployeeList));
					employeeByBranchResponse.setTotalEmployee((long) customEmployeeList.size());
					employeeByBranchResponse.setStatus(setStatus("Successful", "Data Retrieved successfully"));
					employeeByBranchResponse.setBranches(convertBranchToObj(convertBranchToCustomBranch(branchListById.get(0).getName())));
				} else {
					// no data on corresponding id
					employeeByBranchResponse.setStatus(setStatus("failure", "No data on corresponding id"));
				}
			}catch (Exception ignored)
			{
				employeeByBranchResponse.setStatus(setStatus("failure", "No data on corresponding id"));

			}
		} else if (!branchName.equals("default")) {
			List<EmployeeCustom> customEmployeeList = employeeLocalService.searchInEmployeesByBranchName(branchName);
			List<com.aixtor.employee.model.Branch> branchList = new ArrayList<>();
			if (!customEmployeeList.isEmpty()) {
				branchList.add(branchLocalService.getBranch(customEmployeeList.get(0).getBranchId().longValue()));
				employeeByBranchResponse.setEmployees(convertEmployeeToObj(customEmployeeList));
				employeeByBranchResponse.setTotalEmployee((long) customEmployeeList.size());
				employeeByBranchResponse.setStatus(setStatus("Successful", "Data Retrieved successfully"));
				employeeByBranchResponse.setBranches(convertBranchToObj(convertBranchToCustomBranch(branchList.get(0).getName())));
			}else{
				employeeByBranchResponse.setStatus(setStatus("failure", "No Branch on corresponding name"));
			}
			// if name and id both not empty
		} else {
			//nothing Provide
			employeeByBranchResponse.setStatus(setStatus("Failure", "Provide at least one Parameter"));

		}


		return employeeByBranchResponse;
	}
	//convert service builder object to api builder object

	public Employee[] convertEmployeeToObj(List<EmployeeCustom> customEmployeeList) {
		com.aixtor.employee.headless.dto.v1_0.Employee[] employees = new com.aixtor.employee.headless.dto.v1_0.Employee[customEmployeeList.size()];
		int i = 0;
		for (EmployeeCustom e : customEmployeeList) {
			com.aixtor.employee.headless.dto.v1_0.Employee employee = new com.aixtor.employee.headless.dto.v1_0.Employee();
			employee.setEmployeeId(e.getEmployeeId().longValue());
			employee.setFirstName(e.getFirstName());
			employee.setLastName(e.getLastName());
			employee.setBranchName(e.getBranchName());
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

	public com.aixtor.employee.headless.dto.v1_0.Branch[] convertBranchToObj(List<BranchCustom> customBranchList) {
		com.aixtor.employee.headless.dto.v1_0.Branch[] branches = new com.aixtor.employee.headless.dto.v1_0.Branch[customBranchList.size()];
		int i = 0;
		for (BranchCustom branchCustom : customBranchList) {
			com.aixtor.employee.headless.dto.v1_0.Branch branch = new com.aixtor.employee.headless.dto.v1_0.Branch();
			branch.setBranchId(branchCustom.getBranchId().longValue());
			branch.setBranchName(branchCustom.getBranchName());
			branch.setAddr1("No Address Define");
			branch.setAddr2("No Address Define");
			branch.setCountry(branchCustom.getCountryName());
			branch.setState(branchCustom.getStateName());
			branch.setCity(branchCustom.getCityName());
			branch.setPincode("No pin code Define");
			branches[i++] = branch;
		}
		return branches;
	}
	//convert service builder object to custom class object

	public List<BranchCustom> convertBranchToCustomBranch(String branchName) {
		return employeeLocalService.CustomBranchByName(branchName);
	}
}
