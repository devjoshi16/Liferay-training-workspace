package com.aixtor.employee.logs.portlet.action;

import com.aixtor.common.api.AixtorCommonApi;
import com.aixtor.employee.logs.constants.AixtorEmployeeLogsPortletKeys;
import com.aixtor.employee.model.Branch;
import com.aixtor.employee.model.Department;
import com.aixtor.employee.model.Designation;
import com.aixtor.employee.model.Employee;
import com.aixtor.employee.model.EmployeeCustom;
import com.aixtor.employee.service.BranchLocalService;
import com.aixtor.employee.service.DepartmentLocalService;
import com.aixtor.employee.service.DesignationLocalService;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AixtorEmployeeLogsPortletKeys.AIXTOR_EMPLOYEE_LOGS,
		"mvc.command.name=/"
}, service = MVCRenderCommand.class)
public class AixtorEmployeeLogsPortletMVCRender implements MVCRenderCommand {
	@Reference
	DepartmentLocalService departmentLocalService;
	@Reference
	BranchLocalService branchLocalService;
	@Reference
	DesignationLocalService designationLocalService;
	@Reference
	EmployeeLocalService employeeLocalService;
	@Reference
	AixtorCommonApi aixtorCommonApi;
	private static final Log log = LogFactoryUtil.getLog(AixtorEmployeeLogsPortletMVCRender.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.info(":::Render call for mvc Command");

		String fromDate = ParamUtil.getString(renderRequest, AixtorEmployeeLogsPortletKeys.FROMDATE);
		String toDate = ParamUtil.getString(renderRequest, AixtorEmployeeLogsPortletKeys.TODATE);
		String seachName = ParamUtil.getString(renderRequest, AixtorEmployeeLogsPortletKeys.NAME);
		String command = ParamUtil.getString(renderRequest, AixtorEmployeeLogsPortletKeys.COMMAND);

		renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.SEARCH_HOLDER, seachName);
		renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.FROMDATE, fromDate);
		renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.TODATE, toDate);

		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);

		Map<Long, String> departmentMap = new HashMap<>();
		Map<Long, String> designationMap = new HashMap<>();
		Map<Long, String> branchMap = new HashMap<>();

		for (Designation designation : designationList) {
			designationMap.put(designation.getDesignationId(), designation.getName());
		}
		for (Branch branch : branchList) {
			branchMap.put(branch.getBranchId(), branch.getName());
		}
		for (Department department : departmentList) {
			departmentMap.put(department.getDepartmentId(), department.getName());
		}

		// Seach Custom-SQL quary
		if (seachName != AixtorEmployeeLogsPortletKeys.EMPTY_STRING) {
			log.info("in Name ");
			List<EmployeeCustom> employeeList = employeeLocalService.searchInEmployees(seachName);

			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.EMPLOYEE_LIST, employeeList);

			// From Date - To Date Dynamic Quary
		} else if (fromDate != AixtorEmployeeLogsPortletKeys.EMPTY_STRING
				&& toDate != AixtorEmployeeLogsPortletKeys.EMPTY_STRING) {

			toDate = toDate + AixtorEmployeeLogsPortletKeys.DATE_FORMAT;
			fromDate = fromDate + AixtorEmployeeLogsPortletKeys.DATE_FORMAT;
			DateFormat outputFormat = new SimpleDateFormat(AixtorEmployeeLogsPortletKeys.DATE_SAMPLE_FORMAT);
			try {

				Date date = outputFormat.parse(fromDate);
				Date date2 = outputFormat.parse(toDate);

				DynamicQuery dynamicQuery = employeeLocalService.dynamicQuery();
				dynamicQuery
						.add(RestrictionsFactoryUtil.between(AixtorEmployeeLogsPortletKeys.CREATE_DATE, date, date2));

				List<Employee> employeeList;
				employeeList = employeeLocalService.dynamicQuery(dynamicQuery);
				List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
				for (Employee employee : employeeList) {
					EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap,
							designationMap);
					employeeNewList.add(employeeCustom);
				}
				renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.EMPLOYEE_LIST, employeeNewList);

			} catch (Exception e) {

				e.printStackTrace();
			}

			// Render For Employee Update Prefill
		} else if (command.equals(AixtorEmployeeLogsPortletKeys.EDIT)) {
			long employeeId = ParamUtil.getLong(renderRequest, AixtorEmployeeLogsPortletKeys.EMPLOYEE_ID);
			try {
				Employee employee = employeeLocalService.getEmployee(employeeId);
				renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.DEPARTMENT_LIST,
						departmentLocalService.getDepartments(-1, -1));
				// Branch
				renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.BRANCH_LIST,
						branchLocalService.getBranches(-1, -1));
				// Designation
				renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.DESIGNATION_LIST,
						designationLocalService.getDesignations(-1, -1));

				renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.EMPLOYEE, employee);
				renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.CMD, AixtorEmployeeLogsPortletKeys.EDIT);
				return AixtorEmployeeLogsPortletKeys.EMPLOYEE_FORM_JSP;
			} catch (PortalException e) {
				e.printStackTrace();
			}
			// Initial View Render
		} else if (command.equals(AixtorEmployeeLogsPortletKeys.ADD_EMPLOYEE_FORM)) {

			log.info(":::In AddEmployee form load:::");

			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.DEPARTMENT_LIST,
					departmentLocalService.getDepartments(-1, -1));
			// Branch
			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.BRANCH_LIST,
					branchLocalService.getBranches(-1, -1));
			// Designation
			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.DESIGNATION_LIST,
					designationLocalService.getDesignations(-1, -1));
			return AixtorEmployeeLogsPortletKeys.EMPLOYEE_FORM_JSP;

		} else {
			log.info("in Else ");

			// Department
			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.DEPARTMENT_LIST,
					departmentLocalService.getDepartments(-1, -1));
			// Branch
			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.BRANCH_LIST,
					branchLocalService.getBranches(-1, -1));
			// Designation
			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.DESIGNATION_LIST,
					designationLocalService.getDesignations(-1, -1));

			List<Employee> employeeOldList = employeeLocalService.getEmployees(-1, -1);
			List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
			for (Employee employee : employeeOldList) {
				EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap, designationMap);

				employeeNewList.add(employeeCustom);
			}
			renderRequest.setAttribute(AixtorEmployeeLogsPortletKeys.EMPLOYEE_LIST, employeeNewList);

		}
		return AixtorEmployeeLogsPortletKeys.EMPLOYEE_VIEW_JSP;
	}

}
