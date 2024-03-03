package com.aixtor.employee.portlet;


import com.aixtor.employee.constants.AixtorEmployeePortletKeys;
import com.aixtor.employee.model.Branch;
import com.aixtor.employee.model.City;
import com.aixtor.employee.model.State;
import com.aixtor.employee.service.BranchLocalService;
import com.aixtor.employee.service.CityLocalService;
import com.aixtor.employee.service.StateLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name="+AixtorEmployeePortletKeys.BRANCH, 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+AixtorEmployeePortletKeys.BRANCH_VIEW_JSP,
		"javax.portlet.name="+AixtorEmployeePortletKeys.BRANCH ,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, 
service = Portlet.class)

public class AixtorBranchPortlet extends MVCPortlet {
	
	@Reference
	BranchLocalService branchLocalService;
	
	@Reference
	StateLocalService stateLocalService;
	
	@Reference
	CityLocalService cityLocalService;
	
	@Reference
	CountryLocalService countryLocalService;
	
	private static final Log log = LogFactoryUtil.getLog(AixtorBranchPortlet.class);

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
//		view
		List<Country> countryList = countryLocalService.getCountries(-1,-1);		
		HashMap<Long, String> countryMap = new HashMap<Long, String>();
		for (Country country : countryList) {
			countryMap.put(country.getPrimaryKey(), country.getName());
		}
		List<State> stateList = stateLocalService.getStates(-1,-1);		
		HashMap<Long, String> stateMap = new HashMap<Long, String>();
		for (State state : stateList) {
			stateMap.put(state.getPrimaryKey(), state.getStateName());
		}
		List<City> cityList = cityLocalService.getCities(-1,-1);		
		HashMap<Long, String> cityMap = new HashMap<Long, String>();
		for (City city : cityList) {
			cityMap.put(city.getPrimaryKey(), city.getCityName());
		}
		
		renderRequest.setAttribute("branchList", branchLocalService.getBranches(-1, -1));
		renderRequest.setAttribute("countryMap", countryMap);
		renderRequest.setAttribute("stateMap", stateMap);
		renderRequest.setAttribute("cityMap", cityMap);
		
//		for form
		
		if (countryList.size()> 0) {
			long favourableId = countryList.get(0).getUserId();
			List<Country> finalCountryList = new ArrayList<Country>();
			
			for (Country country: countryList) {
				if (country.getUserId() == favourableId)
					finalCountryList.add(country);
			}
			
			renderRequest.setAttribute("countries",finalCountryList);
		}
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
			long country = ParamUtil.getLong(resourceRequest, "country");
			long state = ParamUtil.getLong(resourceRequest, "state");

			JSONObject responseObj = JSONFactoryUtil.createJSONObject();

			PrintWriter writer = null;
			try {
				writer = resourceResponse.getWriter();
				List<City> cityList = new ArrayList<City>();
				List<State> stateList = new ArrayList<State>();

				if (state != 1 && state != 0) {
					cityList = cityLocalService.findBystateId(state);
				}
				else if(country != 1 && country != 0){
					stateList = stateLocalService.findBycountryId(country);
				}

//				City
				List<String> cityNameList = new ArrayList<String>();
				List<Long> cityIdList = new ArrayList<Long>();
				for(City element : cityList)
				{
					cityNameList.add(element.getCityName());
					cityIdList.add(element.getPrimaryKey());
				}
				
				responseObj.put("citystatus", "success");
				responseObj.put("cityIdList", cityIdList);
				responseObj.put("cityNameList",cityNameList);
				
//				State
				List<String> stateNameList = new ArrayList<String>();
				List<Long> stateIdList = new ArrayList<Long>();
				
				for(State element : stateList)
				{
					stateNameList.add(element.getStateName());
					stateIdList.add(element.getPrimaryKey());
				}
				responseObj.put("stateNameList",stateNameList);
				responseObj.put("stateIdList", stateIdList);
				responseObj.put("statestatus", "success");
	
				log.info("retrieved successfully");
			} catch (IOException e) {
				log.error("Error occured while fetching states from country -> " + e.getMessage());
				responseObj.put("status", "error");
				responseObj.put("error", "Error occured while fetching states from country.");
			} finally {
				writer.write(responseObj.toString());
				writer.close();
			}
			super.serveResource(resourceRequest, resourceResponse);
		}
	

	@Override
	public void processAction(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {

		log.info(":::Action called of Branch :::");
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		
		Branch branch = branchLocalService
				.createBranch(CounterLocalServiceUtil.increment(Branch.class.getName()));

		branch.setName(ParamUtil.getString(actionRequest, "branchName"));
		branch.setCountryId(ParamUtil.getLong(actionRequest, "country"));
		branch.setStateId(ParamUtil.getLong(actionRequest, "state"));
		branch.setCityId(ParamUtil.getLong(actionRequest, "city"));
		branch.setGroupId(themeDisplay.getSiteGroupId());
		branch.setCompanyId(themeDisplay.getCompanyId());
		branch.setUserId(themeDisplay.getUserId());
		branch.setUserName(themeDisplay.getUser().getFullName());
		branchLocalService.addBranch(branch);		

	}	
}
