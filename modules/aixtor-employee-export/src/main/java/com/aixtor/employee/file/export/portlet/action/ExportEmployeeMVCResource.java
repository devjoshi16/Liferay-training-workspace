package com.aixtor.employee.file.export.portlet.action;
//
//import com.aixtor.employee.file.export.constants.EmployeeExportPortletKeys;
//import com.aixtor.employee.model.EmployeeCustom;
//import com.aixtor.employee.service.EmployeeLocalService;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//import com.liferay.portal.kernel.util.ContentTypes;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component(immediate = true, property = {
//        "javax.portlet.name=" + EmployeeExportPortletKeys.EMPLOYEEEXPORT,
//        "mvc.command.name=/exportEmployeeAsExcel"
//}, service = MVCResourceCommand.class)
public class ExportEmployeeMVCResource {}
//    @Reference
//    EmployeeLocalService employeeLocalService;
//    private static final Log log = LogFactoryUtil.getLog(ExportEmployeeMVCResource.class);
//
//    @Override
//    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//        Workbook workbook = new XSSFWorkbook();
//
//        Sheet sheet = workbook.createSheet("Sheet1");
//        List<String> cols = new ArrayList<>();
//        cols.add("employeeId");
//        cols.add("firstName");
//        cols.add("lastName");
//        cols.add("email");
//        cols.add("mobileNo");
//        cols.add("department");
//        cols.add("branch");
//        cols.add("designation");
//        cols.add("address");
//        Row rowHead = sheet.createRow(0);
//        for (int i = 0; i < cols.size(); i++) {
//            rowHead.createCell(i).setCellValue(cols.get(i));
//        }
//
//        log.info("head done++++++++");
//        List<EmployeeCustom> employeeList = employeeLocalService.searchInEmployees("");
//        log.info("debugger");
//        int rowCounter = 1;
//        for (EmployeeCustom emp : employeeList) {
//            Row row = sheet.createRow(rowCounter);
//            row.createCell(0).setCellValue(emp.getEmployeeId().doubleValue());
//            row.createCell(1).setCellValue(emp.getFirstName());
//            row.createCell(2).setCellValue(emp.getLastName());
//            row.createCell(3).setCellValue(emp.getEmail());
//            row.createCell(4).setCellValue(emp.getMobileNumber().toString());
//            row.createCell(5).setCellValue(emp.getDepartmentName());
//            row.createCell(6).setCellValue(emp.getBranchName());
//            row.createCell(7).setCellValue(emp.getDesignationName());
//            row.createCell(8).setCellValue(emp.getAddress());
//            rowCounter++;
//        }
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        OutputStream outputStream = null;
//        try {
//            workbook.write(byteArrayOutputStream);
//            byte[] workbookBytes = byteArrayOutputStream.toByteArray();
//            resourceResponse.setContentType(ContentTypes.APPLICATION_VND_MS_EXCEL);
//            resourceResponse.setProperty("Content-Disposition", "attachment; filename=employee.xlsx");
//            log.info("1");
//            outputStream = resourceResponse.getPortletOutputStream();
//            log.info("2");
//            outputStream.write(workbookBytes);
//            log.info("3");
//
//            outputStream.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                outputStream.close();
//                byteArrayOutputStream.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return false;
//    }
//
//    @Override
//    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
//
//        serveResource(resourceRequest, resourceResponse);
//    }
//
//
//}