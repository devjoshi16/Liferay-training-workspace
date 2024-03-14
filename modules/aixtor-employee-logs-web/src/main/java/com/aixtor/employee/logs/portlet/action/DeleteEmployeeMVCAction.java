package com.aixtor.employee.logs.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import com.aixtor.common.api.AixtorCommonApi;
import com.aixtor.employee.logs.constants.AixtorEmployeeLogsPortletKeys;
import com.aixtor.employee.logs.service.AuditlogsLocalService;
import com.aixtor.employee.service.EmployeeLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AixtorEmployeeLogsPortletKeys.AIXTOR_EMPLOYEE_LOGS,
        "mvc.command.name=/deleteEmployeeAction"
}, service = MVCActionCommand.class)
public class DeleteEmployeeMVCAction extends BaseMVCActionCommand {
    @Reference
    EmployeeLocalService employeeLocalService;
    @Reference
    AuditlogsLocalService auditlogsLocalService;
    @Reference
    AixtorCommonApi aixtorCommonApi;
    private static final Log log = LogFactoryUtil.getLog(DeleteEmployeeMVCAction.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute("javax.portlet.config");
        String portletName = portletConfig.getPortletName();

        log.info(portletName + ":::Portlet Name");

        Long employeeId = ParamUtil.getLong(actionRequest, AixtorEmployeeLogsPortletKeys.EMPLOYEE_ID);
        aixtorCommonApi.deleteEmployeeWithLogs(employeeId, portletName, themeDisplay.getUserId(),
                themeDisplay.getUserId(), themeDisplay);

        log.info("Emplyee deleted successfully with logs");
        // actionResponse.sendRedirect(AixtorEmployeeLogsPortletKeys.AIXTOR_EMPLOYEE_LOGS,
        // portletName);

        // include("/employeeView.jsp",actionRequest,actionResponse);

        actionResponse.sendRedirect("http://localhost:8080/axlts_backend");

    }

}
