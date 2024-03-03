package com.aixtor.employee.portlet;

import com.aixtor.employee.constants.AixtorEmployeePortletKeys;
import com.aixtor.employee.model.Branch;
import com.aixtor.employee.model.Department;
import com.aixtor.employee.model.Designation;
import com.aixtor.employee.model.Employee;
import com.aixtor.employee.model.EmployeeCustom;
import com.aixtor.employee.service.BranchLocalService;
import com.aixtor.employee.service.DepartmentLocalService;
import com.aixtor.employee.service.DesignationLocalService;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author dev.joshi
 */
@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name="+ AixtorEmployeePortletKeys.EMPLOYEE, 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+AixtorEmployeePortletKeys.EMPLOYEE_VIEW_JSP,
		"javax.portlet.name=" + AixtorEmployeePortletKeys.EMPLOYEE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, 
service = Portlet.class)
public class AixtorEmployeePortlet extends MVCPortlet {
	@Reference
	DepartmentLocalService departmentLocalService;
	@Reference
	BranchLocalService branchLocalService;
	@Reference
	DesignationLocalService designationLocalService;
	@Reference
	EmployeeLocalService employeeLocalService;

	private static final Log log = LogFactoryUtil.getLog(AixtorEmployeePortlet.class);
	List<Employee> employeeList;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		String fromDate = ParamUtil.getString(renderRequest, "fromDate");
		String toDate = ParamUtil.getString(renderRequest, "toDate");
		String seachName = ParamUtil.getString(renderRequest, "name");
		String command = ParamUtil.getString(renderRequest, "command");
		
		renderRequest.setAttribute("searchHolder", seachName);
		renderRequest.setAttribute("fromDate", fromDate);
		renderRequest.setAttribute("toDate", toDate);

		Map<Long, String> departmentMap = new HashMap<>();
		Map<Long, String> designationMap = new HashMap<>();
		Map<Long, String> branchMap = new HashMap<>();

		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);

		for (Designation designation : designationList) {
			designationMap.put(designation.getDesignationId(), designation.getName());
		}
		for (Branch branch : branchList) {
			branchMap.put(branch.getBranchId(), branch.getName());
		}
		for (Department department : departmentList) {
			departmentMap.put(department.getDepartmentId(), department.getName());
		}

		//Seach Custom-SQL quary
		if (seachName != AixtorEmployeePortletKeys.EMPTY_STRING) {
			log.info("in Name ");
			List<EmployeeCustom> employeeList = employeeLocalService.searchInEmployees(seachName);

			renderRequest.setAttribute(AixtorEmployeePortletKeys.EMPLOYEE_LIST, employeeList);

			
//		From Date - To Date Dynamic Quary 	
		} else if (fromDate != AixtorEmployeePortletKeys.EMPTY_STRING
				&& toDate != AixtorEmployeePortletKeys.EMPTY_STRING) {

			toDate = toDate + AixtorEmployeePortletKeys.DATE_FORMAT;
			fromDate = fromDate + AixtorEmployeePortletKeys.DATE_FORMAT;
			DateFormat outputFormat = new SimpleDateFormat(AixtorEmployeePortletKeys.DATE_SAMPLE_FORMAT);
			try {

				Date date = outputFormat.parse(fromDate);
				Date date2 = outputFormat.parse(toDate);

				DynamicQuery dynamicQuery = employeeLocalService.dynamicQuery();
				dynamicQuery.add(RestrictionsFactoryUtil.between("createDate", date, date2));

				employeeList = employeeLocalService.dynamicQuery(dynamicQuery);
				List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
				for (Employee employee : employeeList) {
					EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap,
							designationMap);
					employeeNewList.add(employeeCustom);
				}
				renderRequest.setAttribute(AixtorEmployeePortletKeys.EMPLOYEE_LIST, employeeNewList);

			} catch (Exception e) {

				e.printStackTrace();
			}

//		Render For Employee Update Prefill
		} else if (command.equals("edit")) {
			long employeeId = ParamUtil.getLong(renderRequest, "employeeId");
			try {
				Employee employee = employeeLocalService.getEmployee(employeeId);
				renderRequest.setAttribute(AixtorEmployeePortletKeys.DEPARTMENT_LIST,
						departmentLocalService.getDepartments(-1, -1));
				// Branch
				renderRequest.setAttribute(AixtorEmployeePortletKeys.BRANCH_LIST,
						branchLocalService.getBranches(-1, -1));
				// Designation
				renderRequest.setAttribute(AixtorEmployeePortletKeys.DESIGNATION_LIST,
						designationLocalService.getDesignations(-1, -1));

				renderRequest.setAttribute("employee", employee);
				renderRequest.setAttribute("cmd", "edit");
				include("/employee/employeeForm.jsp", renderRequest, renderResponse);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		Initial View Render
		} else {
			log.info("in Else ");

			// Department
			renderRequest.setAttribute(AixtorEmployeePortletKeys.DEPARTMENT_LIST,
					departmentLocalService.getDepartments(-1, -1));
			// Branch
			renderRequest.setAttribute(AixtorEmployeePortletKeys.BRANCH_LIST, branchLocalService.getBranches(-1, -1));
			// Designation
			renderRequest.setAttribute(AixtorEmployeePortletKeys.DESIGNATION_LIST,
					designationLocalService.getDesignations(-1, -1));

			List<Employee> employeeOldList = employeeLocalService.getEmployees(-1, -1);
			List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
			for (Employee employee : employeeOldList) {
				EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap, designationMap);

				employeeNewList.add(employeeCustom);
			}
			renderRequest.setAttribute(AixtorEmployeePortletKeys.EMPLOYEE_LIST, employeeNewList);
		}

		super.render(renderRequest, renderResponse);
	}

	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
	
		Employee employee=
				employeeLocalService.createEmployee(
						CounterLocalServiceUtil.increment(Employee.class.getName()));
		ThemeDisplay themeDisplay =
				(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		employee.setFirstName(ParamUtil.getString(actionRequest,"firstName"));
		employee.setLastName(ParamUtil.getString(actionRequest,"lastName"));
		employee.setEmail(ParamUtil.getString(actionRequest,"email"));
		employee.setMobileNumber(ParamUtil.getLong(actionRequest,"mobile"));
		employee.setDepartmentId(ParamUtil.getLong(actionRequest,"department"));
		employee.setBranchId(ParamUtil.getLong(actionRequest,"branch"));
		employee.setDesignationId(ParamUtil.getLong(actionRequest,"designation"));
		employee.setAddress(ParamUtil.getString(actionRequest, "address"));
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setGroupId(themeDisplay.getSiteGroupId());
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setUserId(themeDisplay.getUserId());
		employee.setUserName(themeDisplay.getUser().getFullName());
		employeeLocalService.addEmployee(employee);
		actionResponse.setRenderParameter("mvcPath", "/employee/employeeSearchView.jsp");

//		actionResponse.sendRedirect("http://localhost:8080/axlts_backend");

	}
	
//	Delete Employee Action
	public void deleteEmployeeAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		Long employeeId=ParamUtil.getLong(actionRequest, "employeeId");
		try {
			employeeLocalService.deleteEmployee(employeeId);
			actionResponse.sendRedirect("http://localhost:8080/axlts_backend");
		} catch (PortalException e) {
			log.info("exception in catch");
			e.printStackTrace();
		}
	}
	
	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		log.info(":::In Update Action:::");
		long employeeId=ParamUtil.getLong(actionRequest, "employeeId");
		Employee employee;
		try {
			employee = employeeLocalService.getEmployee(employeeId);
			employee.setFirstName(ParamUtil.getString(actionRequest,"firstName"));
			employee.setLastName(ParamUtil.getString(actionRequest,"lastName"));
			employee.setEmail(ParamUtil.getString(actionRequest,"email"));
			employee.setMobileNumber(ParamUtil.getLong(actionRequest,"mobile"));
			employee.setDepartmentId(ParamUtil.getLong(actionRequest,"department"));
			employee.setBranchId(ParamUtil.getLong(actionRequest,"branch"));
			employee.setDesignationId(ParamUtil.getLong(actionRequest,"designation"));
			employee.setAddress(ParamUtil.getString(actionRequest, "address"));
			employeeLocalService.updateEmployee(employee);
			actionResponse.sendRedirect("http://localhost:8080/axlts_backend");
		} catch (PortalException e) {
			log.info("Exception in catch:::");
			e.printStackTrace();
		}

	}
 
	}