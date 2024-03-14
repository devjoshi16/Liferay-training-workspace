package com.aixtor.employee.spring.mvc.controller;

import com.aixtor.employee.model.Branch;
import com.aixtor.employee.model.Employee;
import com.aixtor.employee.service.BranchLocalService;
import com.aixtor.employee.service.DepartmentLocalService;
import com.aixtor.employee.service.DesignationLocalService;
import com.aixtor.employee.service.EmployeeLocalService;
import com.aixtor.employee.spring.mvc.dto.EmployeePojo;
import com.aixtor.employee.spring.mvc.dto.User;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portletmvc4spring.bind.annotation.ActionMapping;
import com.liferay.portletmvc4spring.bind.annotation.RenderMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MutableRenderParameters;
import javax.portlet.ProcessAction;
import java.io.IOException;

/**
 * @author dev.joshi
 */
@Controller
@RequestMapping("VIEW")
public class EmployeeController {

//	private final  EmployeeLocalService employeeLocalService;
//	@Autowired
//	public EmployeeController(EmployeeLocalService employeeLocalService) {
//		this.employeeLocalService = employeeLocalService;
//	}
	@Autowired
	EmployeeLocalService employeeLocalService;
	@Autowired
	DepartmentLocalService departmentLocalService;
	@Autowired
	BranchLocalService branchLocalService;
	@Autowired
	DesignationLocalService designationLocalService;
	@BeanReference
	UserLocalServiceUtil userLocalServiceUtil;

	@ModelAttribute("employee")
	public EmployeePojo getEmployeeModelAttribute() {
		return new EmployeePojo();
	}

	@RenderMapping
	public String prepareView(ModelMap modelMap) {
		try {
			_logger.info("try Started");
			modelMap.put("employeeList",employeeLocalService.getEmployees(-1,-1));
		}catch (Exception e)
		{
			_logger.info("In Catch Block");
			e.printStackTrace();
		}

		return "employeeView";
	}

@RenderMapping(params = "mvcPath")
public String redirectView(ModelMap modelMap){
	System.out.println(":::Inside render:::");

	modelMap.put("cmd","edit");
	modelMap.put("departmentList",departmentLocalService.getDepartments(-1,-1));
	modelMap.put("branchList",branchLocalService.getBranches(-1,-1));
	modelMap.put("designationList",designationLocalService.getDesignations(-1,-1));

	return "greeting";
}
//@ActionMapping(value="addEmployee")
//@ProcessAction(name="addEmployee")
@ActionMapping(value = "employeeView")
public void mainFormActionURL(ActionRequest actionRequest,ActionResponse actionResponse)
{
	_logger.info(":::Inside Action:::");
	String name=ParamUtil.getString(actionRequest,"firstName");
	System.out.println(name);
    try {
        actionResponse.sendRedirect("employeeView");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
	MutableRenderParameters mutableRenderParameters =actionResponse.getRenderParameters();
	mutableRenderParameters.setValue("javax.portlet.action", "redirectAction");

}
	@RenderMapping(value="com.javax.portlet.action=redirectAction")
	public String addEmployeeRedirect(ModelMap modelMap){
		System.out.println(":::Inside render:::");

		modelMap.put("cmd","edit");
		modelMap.put("departmentList",departmentLocalService.getDepartments(-1,-1));
		modelMap.put("branchList",branchLocalService.getBranches(-1,-1));
		modelMap.put("designationList",designationLocalService.getDesignations(-1,-1));

		return "employeeView";
	}
	private static final Logger _logger = LoggerFactory.getLogger(EmployeeController.class);

//	@Autowired
//	private LocalValidatorFactoryBean _localValidatorFactoryBean;

//	@Autowired
//	private MessageSource _messageSource;

}
