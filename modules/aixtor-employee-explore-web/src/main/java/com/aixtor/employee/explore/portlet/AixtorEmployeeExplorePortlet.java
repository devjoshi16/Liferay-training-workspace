package com.aixtor.employee.explore.portlet;

import com.aixtor.employee.explore.constants.AixtorEmployeeExplorePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author dev.joshi
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AixtorEmployeeExplore",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/employeeView.jsp",
		"javax.portlet.name=" + AixtorEmployeeExplorePortletKeys.AIXTOR_EMPLOYEE_EXPLORE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AixtorEmployeeExplorePortlet extends MVCPortlet {
}