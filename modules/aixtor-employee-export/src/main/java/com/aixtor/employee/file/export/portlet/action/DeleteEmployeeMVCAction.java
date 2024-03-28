package com.aixtor.employee.file.export.portlet.action;

import com.aixtor.employee.file.export.constants.EmployeeExportPortletKeys;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

@Component(immediate = true, property = {
        "javax.portlet.name=" + EmployeeExportPortletKeys.EMPLOYEEEXPORT,
        "mvc.command.name=/deleteEmployeeAction"
}, service = MVCActionCommand.class)
public class DeleteEmployeeMVCAction extends BaseMVCActionCommand {
    @Reference
    EmployeeLocalService employeeLocalService;

    private static final Log log = LogFactoryUtil.getLog(DeleteEmployeeMVCAction.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute("javax.portlet.config");
        String portletName = portletConfig.getPortletName();

        log.info(portletName + ":::Portlet Name");

        Long employeeId = ParamUtil.getLong(actionRequest,  EmployeeExportPortletKeys.EMPLOYEE_ID);

        log.info("Emplyee deleted successfully with logs");
        // actionResponse.sendRedirect(AixtorEmployeeLogsPortletKeys.AIXTOR_EMPLOYEE_LOGS,
        // portletName);

        // include("/employeeView.jsp",actionRequest,actionResponse);

        actionResponse.sendRedirect("http://localhost:8080/axlts_backend");

    }

}
