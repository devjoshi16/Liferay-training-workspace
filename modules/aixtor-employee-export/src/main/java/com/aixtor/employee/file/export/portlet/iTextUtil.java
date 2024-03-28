package com.aixtor.employee.file.export.portlet;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import com.aixtor.employee.model.EmployeeCustom;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.text.*;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class iTextUtil {


    public static byte[] createHelloWorld() {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            Document document = getDocument(stream);

            Paragraph p = new Paragraph();
            p.add("This is my paragraph 1");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            Paragraph p2 = new Paragraph();
            p2.add("This is my paragraph 2"); //no alignment
            document.add(p2);
            Font f = new Font();
            f.setStyle(Font.BOLD);
            f.setSize(8);
            document.add(new Paragraph("This is my paragraph 3", f));
            document.close();
            System.out.println("Done creating PDF");
        } catch (Exception e) {
            System.out.println("Exception creating PDF");
            e.printStackTrace();
        }
        return stream.toByteArray();


    }


    public static byte[] createPDFfromHTML(String html) {
        //String html = "<html><body> This is my Project </body></html>";
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            Document document = getDocument(stream);
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(html));
            document.close();
            System.out.println("Done creating PDF from HTML");
        } catch (Exception e) {
            System.out.println("Exception creating PDF from HTML");
            e.printStackTrace();
        }
        return stream.toByteArray();
    }

    public static byte[] createTablefrom(List<EmployeeCustom> employeeList) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            Document document = getDocument(stream);
//        PdfWriter.getInstance(document, new FileOutputStream(dest));
            document.open();
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
            PdfPTable table = new PdfPTable(cols.size());
            for (int i = 0; i < cols.size(); i++) {
                table.addCell(cols.get(i));
            }
            for (EmployeeCustom employeeCustom : employeeList) {
                table.addCell(employeeCustom.employeeId.toString());
                table.addCell(employeeCustom.firstName);
                table.addCell(employeeCustom.lastName);
                table.addCell(employeeCustom.email);
                table.addCell(employeeCustom.mobileNumber.toString());
                table.addCell(employeeCustom.departmentName);
                table.addCell(employeeCustom.branchName);
                table.addCell(employeeCustom.designationName);
                table.addCell(employeeCustom.address);
            }

            String imFile = "META-INF/resources/header.png";
            ImageData data = ImageDataFactory.create(imFile);

            Image image = Image.getInstance(imFile);
            document.add(image);
            document.add(table);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stream.toByteArray();
    }


    private static Document getDocument(ByteArrayOutputStream byteArrayOutputStream) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream);  // Do this BEFORE document.open()
        document.open();
        return document;
    }


}
