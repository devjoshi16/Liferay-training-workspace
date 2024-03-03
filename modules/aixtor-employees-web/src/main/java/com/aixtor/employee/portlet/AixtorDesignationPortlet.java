package com.aixtor.employee.portlet;


import com.aixtor.employee.constants.AixtorEmployeePortletKeys;
import com.aixtor.employee.model.Designation;
import com.aixtor.employee.service.DesignationLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
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
		"javax.portlet.display-name="+AixtorEmployeePortletKeys.DESIGNATION, 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+AixtorEmployeePortletKeys.DESIGNATION_VIEW_JSP,
		"javax.portlet.name="+AixtorEmployeePortletKeys.DESIGNATION ,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, 
service = Portlet.class)

public class AixtorDesignationPortlet extends MVCPortlet {
	
	@Reference
	DesignationLocalService designationLocalService;
	
	private static final Log log = LogFactoryUtil.getLog(AixtorDesignationPortlet.class);

	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {


//
//DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Designation.class, PortalClassLoaderUtil.getClassLoader());
//dynamicQuery.add(PropertyFactoryUtil.forName("name").like("%r%y%"));
//List<Designation> designationList = designationLocalService.dynamicQuery(dynamicQuery);
		log.info(":::Render called of Designation :::");
		renderRequest.setAttribute("designationList", designationLocalService.getDesignations(-1, -1));
//		System.out.println(designationList+"_________+_+_+_+_+");
//		renderRequest.setAttribute("designationList",designationList );

		super.render(renderRequest, renderResponse);
	}
	

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		log.info(":::Action called of Designation :::");
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);		
		Designation designation = designationLocalService.createDesignation(
						CounterLocalServiceUtil.increment(Designation.class.getName()));

		designation.setName(ParamUtil.getString(actionRequest, "name"));
		designation.setGroupId(themeDisplay.getSiteGroupId());
		designation.setCompanyId(themeDisplay.getCompanyId());
		designation.setUserId(themeDisplay.getUserId());
		designation.setUserName(themeDisplay.getUser().getFullName());
		designationLocalService.addDesignation(designation);

		

	}
}
