package com.parakhcomputer.util.pdf;

import java.awt.Color;
import java.io.FileOutputStream;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

public class ITextExample {



    public static void main (String[] args)
    {

        // creation of the document with a certain size and certain margins
        // (you can use PageSize.Letter instead of PageSize.A4)
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try
        {
            // creation of the different writers
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("iTextExample.pdf"));

            // various fonts
            BaseFont bf_helv = BaseFont.createFont(BaseFont.HELVETICA, "Cp1252", false);
            BaseFont bf_times = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1252", false);
            BaseFont bf_courier = BaseFont.createFont(BaseFont.COURIER, "Cp1252", false);
            BaseFont bf_symbol = BaseFont.createFont(BaseFont.SYMBOL, "Cp1252", false);

            // headers and footers must be added before the document is opened
            HeaderFooter footer = new HeaderFooter(
                        new Phrase("This is page: ", new Font(bf_courier)), true);
            footer.setBorder(Rectangle.NO_BORDER);
            footer.setAlignment(Element.ALIGN_CENTER);
            document.setFooter(footer);

            HeaderFooter header = new HeaderFooter(
                        new Phrase("This is a header without a page number", new Font(bf_symbol)), false);
            header.setAlignment(Element.ALIGN_CENTER);
            document.setHeader(header);

            document.open();

            int y_line1 = 650;
            int y_line2 = y_line1 - 50;
            int y_line3 = y_line2 - 50;

            // draw a few lines ...
            PdfContentByte cb = writer.getDirectContent();
            cb.setLineWidth(0f);
            cb.moveTo(250, y_line3 - 100);
            cb.lineTo(250, y_line1 + 100);
            cb.moveTo(50, y_line1);
            cb.lineTo(400, y_line1);
            cb.moveTo(50, y_line2);
            cb.lineTo(400, y_line2);
            cb.moveTo(50, y_line3);
            cb.lineTo(400, y_line3);
            cb.stroke();
            // ... and some text that is aligned in various ways
            cb.beginText();
            cb.setFontAndSize(bf_helv, 12);
            String text = "Sample text for alignment";
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, text + " Center", 250, y_line1, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, text + " Right", 250, y_line2, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, text + " Left", 250, y_line3, 0);
            cb.endText();

            // start second page
            document.newPage();

            // add text in three paragraphs from top to bottom with various font styles
            Paragraph par = new Paragraph("bold paragraph");
            par.getFont().setStyle(Font.BOLD);
            document.add(par);
            par = new Paragraph("italic paragraph");
            par.getFont().setStyle(Font.ITALIC);
            document.add(par);
            par = new Paragraph("underlined and strike-through paragraph");
            par.getFont().setStyle(Font.UNDERLINE | Font.STRIKETHRU);
            document.add(par);

            // demonstrate some table features
            Table table = new Table(3);
                // 2 pixel wide blue border
            table.setBorderWidth(2);
            table.setBorderColor(new Color(0, 0, 255));
            table.setPadding(5);
            table.setSpacing(5);
            Cell c = new Cell("header");
            c.setHeader(true);
            c.setColspan(3);
            table.addCell(c);
            table.endHeaders();
            c = new Cell("example cell with rowspan 2 and red border");
            c.setRowspan(2);
            c.setBorderColor(new Color(255, 0, 0));
            table.addCell(c);
            table.addCell("1.1");
            table.addCell("2.1");
            table.addCell("1.2");
            table.addCell("2.2");
            c = new Cell("align center");
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c);
            c = new Cell("big cell");
            c.setRowspan(2);
            table.addCell(c);
            c = new Cell("align right");
            c.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(c);
            document.add(table);

            // add text at an absolute position
            cb.beginText();
            cb.setFontAndSize(bf_times, 14);
            cb.setTextMatrix(100, 300);
            cb.showText("Text at position 100, 300.");
            cb.endText();

            // rotated text at an absolute position
            PdfTemplate template = cb.createTemplate(300, 300);                
            template.beginText();
            template.setFontAndSize(bf_times, 14);
            template.showText("Rotated text at position 400, 200.");
            template.endText();

            float rotate = 90;
            float x = 400;
            float y = 200;
            float angle  = (float) (-rotate * (Math.PI / 180));
            float xScale = (float) Math.cos(angle);
            float yScale = (float) Math.cos(angle);
            float xRot   = (float) -Math.sin(angle);
            float yRot   = (float) Math.sin(angle);

            cb.addTemplate(template, xScale, xRot, yRot, yScale, x, y);

            // we're done!
            document.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
/*
 * 
 * And this is the code for iText 5. Headers and footers are added through page events, 
 * the package names have changed, and the Table/Cell classes have been removed in favor 
 * of PdfPTable/PdfPCell.


import java.awt.Color;
import java.io.FileOutputStream;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;


    public static void demo(){

        // creation of the document with a certain size and certain margins
        // may want to use PageSize.LETTER instead
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {
            // creation of the different writers
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("demo.pdf"));
            writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));

            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);

            // various fonts
            BaseFont bf_helv = BaseFont.createFont(BaseFont.HELVETICA, "Cp1252", false);
            BaseFont bf_times = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1252", false);
            BaseFont bf_courier = BaseFont.createFont(BaseFont.COURIER, "Cp1252", false);
            BaseFont bf_symbol = BaseFont.createFont(BaseFont.SYMBOL, "Cp1252", false);

            int y_line1 = 650;
            int y_line2 = y_line1 - 50;
            int y_line3 = y_line2 - 50;

            document.open();

            PdfContentByte cb = writer.getDirectContent();
            cb.setLineWidth(0f);
            cb.moveTo(250, y_line3 - 100);
            cb.lineTo(250, y_line1 + 100);
            cb.moveTo(50, y_line1);
            cb.lineTo(400, y_line1);
            cb.moveTo(50, y_line2);
            cb.lineTo(400, y_line2);
            cb.moveTo(50, y_line3);
            cb.lineTo(400, y_line3);
            cb.stroke();
            cb.beginText();
            cb.setFontAndSize(bf_helv, 12);
            String text = "Sample text for alignment";
            cb.showTextAligned(PdfContentByte.ALIGN_CENTER, text + " Center", 250, y_line1, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, text + " Right", 250, y_line2, 0);
            cb.showTextAligned(PdfContentByte.ALIGN_LEFT, text + " Left", 250, y_line3, 0);
            cb.endText();

            document.newPage();

            // add text in two paragraphs from top to bottom
            Paragraph par = new Paragraph("bold paragraph");
            par.getFont().setStyle(Font.BOLD);
            document.add(par);
            par = new Paragraph("italic paragraph");
            par.getFont().setStyle(Font.ITALIC);
            document.add(par);
            par = new Paragraph("underlined and strike-through paragraph");
            par.getFont().setStyle(Font.UNDERLINE | Font.STRIKETHRU);
            document.add(par);

            // demonstrate some table features
            PdfPTable table = new PdfPTable(3);
            table.setSpacingBefore(20);
            table.getDefaultCell().setPadding(5);

            PdfPCell cell = new PdfPCell(new Phrase("header"));
            cell.setPadding(5);
            cell.setColspan(3);
            table.addCell(cell);
            table.setHeaderRows(1);
            cell = new PdfPCell(new Phrase("example cell with rowspan 2 and red border"));
            cell.setPadding(5);
            cell.setRowspan(2);
            cell.setBorderColor(new BaseColor(new Color(255, 0, 0)));
            table.addCell(cell);
            table.addCell("1.1");
            table.addCell("2.1");
            table.addCell("1.2");
            table.addCell("2.2");
            cell = new PdfPCell(new Phrase("align center"));
            cell.setPadding(5);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("rotated cell"));
            cell.setPadding(5);
            cell.setRowspan(2);
            cell.setColspan(2);
            // PdfPCell content can be rotated
            cell.setRotation(90);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("align right"));
            cell.setPadding(5);
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
            document.add(table);

            // add text at an absolute position
            cb.beginText();
            cb.setFontAndSize(bf_times, 14);
            cb.setTextMatrix(100, 300);
            cb.showText("Text at position 100, 300.");
            cb.endText();

            // rotated text at an absolute position
            PdfTemplate template = cb.createTemplate(300, 300);                
            template.beginText();
            template.setFontAndSize(bf_times, 14);
            template.showText("Rotated text at position 400, 200.");
            template.endText();

            float rotate = 90;
            float x = 400;
            float y = 200;
            float angle  = (float) (-rotate * (Math.PI / 180));
            float xScale = (float) Math.cos(angle);
            float yScale = (float) Math.cos(angle);
            float xRot   = (float) -Math.sin(angle);
            float yRot   = (float) Math.sin(angle);

            cb.addTemplate(template, xScale, xRot, yRot, yScale, x, y);

            document.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    // Inner class to add a header and a footer. 
    static class HeaderFooter extends PdfPageEventHelper {

        public void onEndPage (PdfWriter writer, Document document) {
            Rectangle rect = writer.getBoxSize("art");
            switch(writer.getPageNumber() % 2) {
            case 0:
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_RIGHT, new Phrase("even header"),
                        rect.getRight(), rect.getTop(), 0);
                break;
            case 1:
                ColumnText.showTextAligned(writer.getDirectContent(),
                        Element.ALIGN_LEFT, new Phrase("odd header"),
                        rect.getLeft(), rect.getTop(), 0);
                break;
            }
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_CENTER, new Phrase(String.format("page %d", writer.getPageNumber())),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 18, 0);
        }
    }
    
    */
}
