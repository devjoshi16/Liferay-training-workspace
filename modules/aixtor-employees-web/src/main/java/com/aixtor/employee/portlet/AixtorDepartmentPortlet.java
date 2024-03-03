package com.aixtor.employee.portlet;


import com.aixtor.employee.constants.AixtorEmployeePortletKeys;
import com.aixtor.employee.model.Department;
import com.aixtor.employee.service.DepartmentLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name="+AixtorEmployeePortletKeys.DEPARTMENT, 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+AixtorEmployeePortletKeys.DEPARTMENT_VIEW_JSP,
		"javax.portlet.name="+AixtorEmployeePortletKeys.DEPARTMENT ,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, 
service = Portlet.class)

public class AixtorDepartmentPortlet extends MVCPortlet {
	
	@Reference
	DepartmentLocalService departmentLocalService;
	
	
	private static final Log log = LogFactoryUtil.getLog(AixtorDepartmentPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		log.info(":::Render called of Department :::");
		
		
		List<User> userList= UserLocalServiceUtil.getUsers(-1, -1);
		renderRequest.setAttribute("userList",userList);

		HashMap<String, String> userMap = new HashMap<String, String>();
		for (User user : userList) {
			userMap.put(""+user.getPrimaryKey(), user.getFullName());
		}
				
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);

		for (Department element:departmentList) {
			String elementId = element.getDepartmentHead();
			String elementName = userMap.getOrDefault(elementId,"default head");
			element.setDepartmentHead(elementName);
		}
		renderRequest.setAttribute("DepartmentList", departmentList);
		
		super.render(renderRequest, renderResponse);
	}
	


	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		log.info(":::Action called of Department :::");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Department department = departmentLocalService.createDepartment(
						CounterLocalServiceUtil.increment(Department.class.getName()));

		department.setName(ParamUtil.getString(actionRequest, "departmentName"));
		department.setDepartmentHead(ParamUtil.getString(actionRequest, "hod"));
		department.setGroupId(themeDisplay.getSiteGroupId());
		department.setCompanyId(themeDisplay.getCompanyId());
		department.setUserId(themeDisplay.getUserId());
		department.setUserName(themeDisplay.getUser().getFullName());
		departmentLocalService.addDepartment(department);

		

	}
}
