package com.aixtor.employee.explore.portlet.action;

import com.aixtor.employee.explore.constants.AixtorEmployeeExplorePortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
@Component(immediate = true, property = {
        "javax.portlet.name=" + AixtorEmployeeExplorePortletKeys.AIXTOR_EMPLOYEE_EXPLORE,
        "mvc.command.name=/"
}, service = MVCRenderCommand.class)
public class AixtorEmployeeExploreMVCRender implements MVCRenderCommand {
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/employeeView.jsp";
    }
}
