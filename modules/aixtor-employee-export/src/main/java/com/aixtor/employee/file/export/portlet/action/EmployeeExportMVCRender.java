package com.aixtor.employee.file.export.portlet.action;
//
//import com.aixtor.employee.file.export.constants.EmployeeExportPortletKeys;
//import com.aixtor.employee.model.*;
//import com.aixtor.employee.service.BranchLocalService;
//import com.aixtor.employee.service.DepartmentLocalService;
//import com.aixtor.employee.service.DesignationLocalService;
//import com.aixtor.employee.service.EmployeeLocalService;
//import com.liferay.portal.kernel.dao.orm.DynamicQuery;
//import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//@Component(immediate = true, property = {
//        "javax.portlet.name=" + EmployeeExportPortletKeys.EMPLOYEEEXPORT,
//        "mvc.command.name=/"
//}, service = MVCRenderCommand.class)
public class EmployeeExportMVCRender {}
//    @Reference
//    DepartmentLocalService departmentLocalService;
//    @Reference
//    BranchLocalService branchLocalService;
//    @Reference
//    DesignationLocalService designationLocalService;
//    @Reference
//    EmployeeLocalService employeeLocalService;
//
//    private static final Log log = LogFactoryUtil.getLog(EmployeeExportMVCRender.class);
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
//
//        log.info(":::Render call for mvc Command");
//
//        String fromDate = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.FROMDATE);
//        String toDate = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.TODATE);
//        String seachName = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.NAME);
//        String command = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.COMMAND);
//
//        renderRequest.setAttribute(EmployeeExportPortletKeys.SEARCH_HOLDER, seachName);
//        renderRequest.setAttribute(EmployeeExportPortletKeys.FROMDATE, fromDate);
//        renderRequest.setAttribute(EmployeeExportPortletKeys.TODATE, toDate);
//
//        List<Branch> branchList = branchLocalService.getBranches(-1, -1);
//        List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
//        List<Designation> designationList = designationLocalService.getDesignations(-1, -1);
//
//        Map<Long, String> departmentMap = new HashMap<>();
//        Map<Long, String> designationMap = new HashMap<>();
//        Map<Long, String> branchMap = new HashMap<>();
//
//        for (Designation designation : designationList) {
//            designationMap.put(designation.getDesignationId(), designation.getName());
//        }
//        for (Branch branch : branchList) {
//            branchMap.put(branch.getBranchId(), branch.getName());
//        }
//        for (Department department : departmentList) {
//            departmentMap.put(department.getDepartmentId(), department.getName());
//        }
//
//        // Seach Custom-SQL quary
//        if (seachName != EmployeeExportPortletKeys.EMPTY_STRING) {
//            log.info("in Name ");
//            List<EmployeeCustom> employeeList = employeeLocalService.searchInEmployees(seachName);
//
//            renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE_LIST, employeeList);
//
//            // From Date - To Date Dynamic Quary
//        } else if (fromDate != EmployeeExportPortletKeys.EMPTY_STRING
//                && toDate != EmployeeExportPortletKeys.EMPTY_STRING) {
//
//            toDate = toDate + EmployeeExportPortletKeys.DATE_FORMAT;
//            fromDate = fromDate + EmployeeExportPortletKeys.DATE_FORMAT;
//            DateFormat outputFormat = new SimpleDateFormat(EmployeeExportPortletKeys.DATE_SAMPLE_FORMAT);
//            try {
//
//                Date date = outputFormat.parse(fromDate);
//                Date date2 = outputFormat.parse(toDate);
//
//                DynamicQuery dynamicQuery = employeeLocalService.dynamicQuery();
//                dynamicQuery
//                        .add(RestrictionsFactoryUtil.between(EmployeeExportPortletKeys.CREATE_DATE, date, date2));
//
//                List<Employee> employeeList;
//                employeeList = employeeLocalService.dynamicQuery(dynamicQuery);
//                List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
//                for (Employee employee : employeeList) {
//                    EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap,
//                            designationMap);
//                    employeeNewList.add(employeeCustom);
//                }
//                renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE_LIST, employeeNewList);
//
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//
//            // Render For Employee Update Prefill
//        } else if (command.equals(EmployeeExportPortletKeys.EDIT)) {
//            long employeeId = ParamUtil.getLong(renderRequest, EmployeeExportPortletKeys.EMPLOYEE_ID);
//            try {
//                Employee employee = employeeLocalService.getEmployee(employeeId);
//                renderRequest.setAttribute(EmployeeExportPortletKeys.DEPARTMENT_LIST,
//                        departmentLocalService.getDepartments(-1, -1));
//                // Branch
//                renderRequest.setAttribute(EmployeeExportPortletKeys.BRANCH_LIST,
//                        branchLocalService.getBranches(-1, -1));
//                // Designation
//                renderRequest.setAttribute(EmployeeExportPortletKeys.DESIGNATION_LIST,
//                        designationLocalService.getDesignations(-1, -1));
//
//                renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE, employee);
//                renderRequest.setAttribute(EmployeeExportPortletKeys.CMD, EmployeeExportPortletKeys.EDIT);
//                return EmployeeExportPortletKeys.EMPLOYEE_FORM_JSP;
//            } catch (PortalException e) {
//                e.printStackTrace();
//            }
//            // Initial View Render
//        } else if (command.equals(EmployeeExportPortletKeys.ADD_EMPLOYEE_FORM)) {
//
//            log.info(":::In AddEmployee form load:::");
//
//            renderRequest.setAttribute(EmployeeExportPortletKeys.DEPARTMENT_LIST,
//                    departmentLocalService.getDepartments(-1, -1));
//            // Branch
//            renderRequest.setAttribute(EmployeeExportPortletKeys.BRANCH_LIST,
//                    branchLocalService.getBranches(-1, -1));
//            // Designation
//            renderRequest.setAttribute(EmployeeExportPortletKeys.DESIGNATION_LIST,
//                    designationLocalService.getDesignations(-1, -1));
//            return EmployeeExportPortletKeys.EMPLOYEE_FORM_JSP;
//
//        } else {
//            log.info("in Else ");
//
//            // Department
//            renderRequest.setAttribute(EmployeeExportPortletKeys.DEPARTMENT_LIST,
//                    departmentLocalService.getDepartments(-1, -1));
//            // Branch
//            renderRequest.setAttribute(EmployeeExportPortletKeys.BRANCH_LIST,
//                    branchLocalService.getBranches(-1, -1));
//            // Designation
//            renderRequest.setAttribute(EmployeeExportPortletKeys.DESIGNATION_LIST,
//                    designationLocalService.getDesignations(-1, -1));
//
//            List<Employee> employeeOldList = employeeLocalService.getEmployees(-1, -1);
//            List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
//            for (Employee employee : employeeOldList) {
//                EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap, designationMap);
//
//                employeeNewList.add(employeeCustom);
//            }
//            renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE_LIST, employeeNewList);
//
//        }
//        return EmployeeExportPortletKeys.EMPLOYEE_VIEW_JSP;
//    }
//
//
//}
