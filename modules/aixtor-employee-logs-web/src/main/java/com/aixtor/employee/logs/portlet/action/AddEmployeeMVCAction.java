package com.aixtor.employee.logs.portlet.action;

import com.aixtor.common.api.AixtorCommonApi;
import com.aixtor.employee.logs.constants.AixtorEmployeeLogsPortletKeys;
import com.aixtor.employee.model.Employee;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + AixtorEmployeeLogsPortletKeys.AIXTOR_EMPLOYEE_LOGS,
		"mvc.command.name=/addEmployee"
}, service = MVCActionCommand.class)
public class AddEmployeeMVCAction extends BaseMVCActionCommand {
	@Reference
	EmployeeLocalService employeeLocalService;
	@Reference
	AixtorCommonApi aixtorCommonApi;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Employee employee = employeeLocalService.createEmployee(
				CounterLocalServiceUtil.increment(Employee.class.getName()));
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		employee.setFirstName(ParamUtil.getString(actionRequest, AixtorEmployeeLogsPortletKeys.FIRSTNAME));
		employee.setLastName(ParamUtil.getString(actionRequest, AixtorEmployeeLogsPortletKeys.LASRNAME));
		employee.setEmail(ParamUtil.getString(actionRequest, AixtorEmployeeLogsPortletKeys.EMAIL));
		employee.setMobileNumber(ParamUtil.getLong(actionRequest, AixtorEmployeeLogsPortletKeys.MOBILE));
		employee.setDepartmentId(ParamUtil.getLong(actionRequest, AixtorEmployeeLogsPortletKeys.DEPARTMENT_SMALL));
		employee.setBranchId(ParamUtil.getLong(actionRequest, AixtorEmployeeLogsPortletKeys.BRANCH_SMALL));
		employee.setDesignationId(ParamUtil.getLong(actionRequest, AixtorEmployeeLogsPortletKeys.DESIGNATION_SMALL));
		employee.setAddress(ParamUtil.getString(actionRequest, AixtorEmployeeLogsPortletKeys.ADDRESS));
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setGroupId(themeDisplay.getSiteGroupId());
		employee.setCompanyId(themeDisplay.getCompanyId());
		employee.setUserId(themeDisplay.getUserId());
		employee.setUserName(themeDisplay.getUser().getFullName());
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute("javax.portlet.config");
		String portletName = portletConfig.getPortletName();
		aixtorCommonApi.addEmployeeWithLogs(employee, themeDisplay, portletName, themeDisplay.getUserId(),
				themeDisplay.getUserId());
		// employeeLocalService.addEmployee(employee);
	}

}
