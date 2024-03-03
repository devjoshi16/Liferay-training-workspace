package com.aixtor.employee.logs.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aixtor.common.api.AixtorCommonApi;
import com.aixtor.employee.logs.constants.AixtorEmployeeLogsPortletKeys;
import com.aixtor.employee.model.Employee;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AixtorEmployeeLogsPortletKeys.AIXTOR_EMPLOYEE_LOGS,
        "mvc.command.name=/updateEmployee"
}, service = MVCActionCommand.class)
public class UpdateEmployeeMVCAction extends BaseMVCActionCommand {
    @Reference
    EmployeeLocalService employeeLocalService;
    @Reference
    AixtorCommonApi aixtorCommonApi;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long employeeId = ParamUtil.getLong(actionRequest, "employeeId");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Employee employee = employeeLocalService.getEmployee(employeeId);
        employee.setFirstName(ParamUtil.getString(actionRequest, "firstName"));
        employee.setLastName(ParamUtil.getString(actionRequest, "lastName"));
        employee.setEmail(ParamUtil.getString(actionRequest, "email"));
        employee.setMobileNumber(ParamUtil.getLong(actionRequest, "mobile"));
        employee.setDepartmentId(ParamUtil.getLong(actionRequest, "department"));
        employee.setBranchId(ParamUtil.getLong(actionRequest, "branch"));
        employee.setDesignationId(ParamUtil.getLong(actionRequest, "designation"));
        employee.setAddress(ParamUtil.getString(actionRequest, "address"));

        PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute("javax.portlet.config");
        String portletName = portletConfig.getPortletName();

        aixtorCommonApi.updateEmployeeWithLogs(employee, themeDisplay, portletName, themeDisplay.getUserId(),
                themeDisplay.getUserId());

    }

}
