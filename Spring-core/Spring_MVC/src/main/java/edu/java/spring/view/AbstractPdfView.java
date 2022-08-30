package edu.java.spring.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.java.spring.model.JavaClazz;
import edu.java.spring.model.Student;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

abstract class AbstractPdfView extends AbstractView {
    public AbstractPdfView() {
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return false;
    }
    protected Document newDocument(){
        return new Document(PageSize.A4);
    }
    protected PdfWriter newWriter(Document document, OutputStream os) throws DocumentException {
        return PdfWriter.getInstance(document,os);
    }
    protected void prepareWriter(Map<String,Object> model, PdfWriter writer, HttpServletRequest request){
        writer.setViewerPreferences(getViewerPreferences());
    }
    protected int getViewerPreferences(){
        return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ByteArrayOutputStream byteOutput = createTemporaryOutputStream();
        Document document = new Document();
        PdfWriter writer = newWriter(document, byteOutput);
        prepareWriter(map,document,httpServletRequest);
        buildPdfMetadata(map,document,httpServletRequest);
        document.open();
        buildPdfDocument(map,document,writer,httpServletRequest,httpServletResponse);
        document.close();
        writeToResponse(httpServletResponse,byteOutput);
    }

    private void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws DocumentException {
        JavaClazz clazz = (JavaClazz) map.get("clazzObj");
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{2.0f,3.0f,1.5f});
        table.setSpacingBefore(10);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.CYAN);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("ID",font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name",font));
        table.addCell(cell);

        table.completeRow();

        for(Student student: clazz.getStudents()){
            table.addCell(String.valueOf(student.getId()));
            table.completeRow();
        }
        document.add(table);
    }

    private void buildPdfMetadata(Map<String, Object> map, Document document, HttpServletRequest httpServletRequest) {
    }

    private void prepareWriter(Map<String, Object> map, Document document, HttpServletRequest httpServletRequest) {
    }
}
