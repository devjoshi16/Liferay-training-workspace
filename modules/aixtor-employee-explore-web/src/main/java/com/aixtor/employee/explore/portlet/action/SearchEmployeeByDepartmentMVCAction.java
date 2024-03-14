package com.aixtor.employee.explore.portlet.action;

import com.aixtor.employee.explore.constants.AixtorEmployeeExplorePortletKeys;
import com.aixtor.employee.headless.dto.v1_0.EmployeeByDepartmentResponse;
import com.aixtor.employee.headless.resource.v1_0.GetEmployeesByDepartmentResource;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AixtorEmployeeExplorePortletKeys.AIXTOR_EMPLOYEE_EXPLORE,
        "mvc.command.name=/searchDepartmentAction"
}, service = MVCActionCommand.class)
public class SearchEmployeeByDepartmentMVCAction extends BaseMVCActionCommand {
    @Reference
    GetEmployeesByDepartmentResource getEmployeesByDepartmentResource;

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//        getEmployeesByDepartmentResource.postGetEmployeesByDepartment()

    }
}
