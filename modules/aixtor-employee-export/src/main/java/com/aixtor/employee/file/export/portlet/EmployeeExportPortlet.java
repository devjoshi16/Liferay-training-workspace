package com.aixtor.employee.file.export.portlet;

import com.aixtor.employee.file.export.constants.EmployeeExportPortletKeys;
import com.aixtor.employee.file.export.portlet.action.EmployeeExportMVCRender;
import com.aixtor.employee.model.*;
import com.aixtor.employee.service.BranchLocalService;
import com.aixtor.employee.service.DepartmentLocalService;
import com.aixtor.employee.service.DesignationLocalService;
import com.aixtor.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author dev.joshi
 */
@Component(property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Employee Export", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeeExportPortletKeys.EMPLOYEEEXPORT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class EmployeeExportPortlet extends MVCPortlet {
	@Reference
	DepartmentLocalService departmentLocalService;
	@Reference
	BranchLocalService branchLocalService;
	@Reference
	DesignationLocalService designationLocalService;
	@Reference
	EmployeeLocalService employeeLocalService;
	private static final Log log = LogFactoryUtil.getLog(EmployeeExportMVCRender.class);

	public String searchName;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		log.info(":::Render call for mvc Command");

		String fromDate = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.FROMDATE);
		String toDate = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.TODATE);
		log.info(ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.NAME));
		searchName = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.NAME);
		String command = ParamUtil.getString(renderRequest, EmployeeExportPortletKeys.COMMAND);

		renderRequest.setAttribute(EmployeeExportPortletKeys.SEARCH_HOLDER, searchName);
		renderRequest.setAttribute(EmployeeExportPortletKeys.FROMDATE, fromDate);
		renderRequest.setAttribute(EmployeeExportPortletKeys.TODATE, toDate);

		List<Branch> branchList = branchLocalService.getBranches(-1, -1);
		List<Department> departmentList = departmentLocalService.getDepartments(-1, -1);
		List<Designation> designationList = designationLocalService.getDesignations(-1, -1);

		Map<Long, String> departmentMap = new HashMap<>();
		Map<Long, String> designationMap = new HashMap<>();
		Map<Long, String> branchMap = new HashMap<>();

		for (Designation designation : designationList) {
			designationMap.put(designation.getDesignationId(), designation.getName());
		}
		for (Branch branch : branchList) {
			branchMap.put(branch.getBranchId(), branch.getName());
		}
		for (Department department : departmentList) {
			departmentMap.put(department.getDepartmentId(), department.getName());
		}

		// Seach Custom-SQL quary
		if (searchName != null && searchName != EmployeeExportPortletKeys.EMPTY_STRING && !searchName.equals(" ")) {
			log.info("in Name ");
			List<EmployeeCustom> employeeList = employeeLocalService.searchInEmployees(searchName);

			renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE_LIST, employeeList);

			// From Date - To Date Dynamic Quary
		} else if (fromDate != EmployeeExportPortletKeys.EMPTY_STRING
				&& toDate != EmployeeExportPortletKeys.EMPTY_STRING) {

			toDate = toDate + EmployeeExportPortletKeys.DATE_FORMAT;
			fromDate = fromDate + EmployeeExportPortletKeys.DATE_FORMAT;
			DateFormat outputFormat = new SimpleDateFormat(EmployeeExportPortletKeys.DATE_SAMPLE_FORMAT);
			try {

				Date date = outputFormat.parse(fromDate);
				Date date2 = outputFormat.parse(toDate);

				DynamicQuery dynamicQuery = employeeLocalService.dynamicQuery();
				dynamicQuery.add(RestrictionsFactoryUtil.between(EmployeeExportPortletKeys.CREATE_DATE, date, date2));

				List<Employee> employeeList;
				employeeList = employeeLocalService.dynamicQuery(dynamicQuery);
				List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
				for (Employee employee : employeeList) {
					EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap,
							designationMap);
					employeeNewList.add(employeeCustom);
				}
				renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE_LIST, employeeNewList);

			} catch (Exception e) {

				e.printStackTrace();
			}

			// Render For Employee Update Prefill
		} else if (command.equals(EmployeeExportPortletKeys.EDIT)) {
			long employeeId = ParamUtil.getLong(renderRequest, EmployeeExportPortletKeys.EMPLOYEE_ID);
			try {
				Employee employee = employeeLocalService.getEmployee(employeeId);
				renderRequest.setAttribute(EmployeeExportPortletKeys.DEPARTMENT_LIST,
						departmentLocalService.getDepartments(-1, -1));
				// Branch
				renderRequest.setAttribute(EmployeeExportPortletKeys.BRANCH_LIST,
						branchLocalService.getBranches(-1, -1));
				// Designation
				renderRequest.setAttribute(EmployeeExportPortletKeys.DESIGNATION_LIST,
						designationLocalService.getDesignations(-1, -1));

				renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE, employee);
				renderRequest.setAttribute(EmployeeExportPortletKeys.CMD, EmployeeExportPortletKeys.EDIT);
//				return EmployeeExportPortletKeys.EMPLOYEE_FORM_JSP;
			} catch (PortalException e) {
				e.printStackTrace();
			}
			// Initial View Render
		} else if (command.equals(EmployeeExportPortletKeys.ADD_EMPLOYEE_FORM)) {

			log.info(":::In AddEmployee form load:::");

			renderRequest.setAttribute(EmployeeExportPortletKeys.DEPARTMENT_LIST,
					departmentLocalService.getDepartments(-1, -1));
			// Branch
			renderRequest.setAttribute(EmployeeExportPortletKeys.BRANCH_LIST, branchLocalService.getBranches(-1, -1));
			// Designation
			renderRequest.setAttribute(EmployeeExportPortletKeys.DESIGNATION_LIST,
					designationLocalService.getDesignations(-1, -1));
//			return EmployeeExportPortletKeys.EMPLOYEE_FORM_JSP;

		} else {
			log.info("in Else ");

			// Department
			renderRequest.setAttribute(EmployeeExportPortletKeys.DEPARTMENT_LIST,
					departmentLocalService.getDepartments(-1, -1));
			// Branch
			renderRequest.setAttribute(EmployeeExportPortletKeys.BRANCH_LIST, branchLocalService.getBranches(-1, -1));
			// Designation
			renderRequest.setAttribute(EmployeeExportPortletKeys.DESIGNATION_LIST,
					designationLocalService.getDesignations(-1, -1));

			List<Employee> employeeOldList = employeeLocalService.getEmployees(-1, -1);
			List<EmployeeCustom> employeeNewList = new ArrayList<EmployeeCustom>();
			for (Employee employee : employeeOldList) {
				EmployeeCustom employeeCustom = new EmployeeCustom(employee, branchMap, departmentMap, designationMap);

				employeeNewList.add(employeeCustom);
			}
			renderRequest.setAttribute(EmployeeExportPortletKeys.EMPLOYEE_LIST, employeeNewList);

		}
		super.render(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		log.info("cmd----------"+cmd);
		if (cmd.equals("excel")) {
			Workbook workbook = new XSSFWorkbook();

			Sheet sheet = workbook.createSheet("Sheet1");
			List<String> cols = new ArrayList<>();
			cols.add("employeeId");
			cols.add("firstName");
			cols.add("lastName");
			cols.add("email");
			cols.add("mobileNo");
			cols.add("department");
			cols.add("branch");
			cols.add("designation");
			cols.add("address");
			Row rowHead = sheet.createRow(0);
			for (int i = 0; i < cols.size(); i++) {
				rowHead.createCell(i).setCellValue(cols.get(i));
			}

			log.info("head done++++++++");
			List<EmployeeCustom> employeeList = employeeLocalService.searchInEmployees(searchName);
			log.info("debugger");
			int rowCounter = 1;
			for (EmployeeCustom emp : employeeList) {
				Row row = sheet.createRow(rowCounter);
				row.createCell(0).setCellValue(emp.getEmployeeId().doubleValue());
				row.createCell(1).setCellValue(emp.getFirstName());
				row.createCell(2).setCellValue(emp.getLastName());
				row.createCell(3).setCellValue(emp.getEmail());
				row.createCell(4).setCellValue(emp.getMobileNumber().toString());
				row.createCell(5).setCellValue(emp.getDepartmentName());
				row.createCell(6).setCellValue(emp.getBranchName());
				row.createCell(7).setCellValue(emp.getDesignationName());
				row.createCell(8).setCellValue(emp.getAddress());
				rowCounter++;
			}

			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			OutputStream outputStream = null;
			try {
				workbook.write(byteArrayOutputStream);
				byte[] workbookBytes = byteArrayOutputStream.toByteArray();
				resourceResponse.setContentType(ContentTypes.APPLICATION_VND_MS_EXCEL);
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=employee.xlsx");
				log.info("1");
				outputStream = resourceResponse.getPortletOutputStream();
				log.info("2");
				outputStream.write(workbookBytes);
				log.info("3");

				outputStream.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					outputStream.close();
					byteArrayOutputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		} else {
			// pdf
			String html = "<html><body> This is my Project </body></html>";
//			byte[] bytes = iTextUtil.createPDFfromHTML(html);
			byte[] bytes = iTextUtil.createTablefrom(employeeLocalService.searchInEmployees(searchName));
			OutputStream outputStream = null;
			try {
				resourceResponse.setContentType("application/pdf");
				outputStream = resourceResponse.getPortletOutputStream();
				outputStream.write(bytes);
				log.info("pdf write successfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}