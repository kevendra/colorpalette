package com.parakhcomputer.util.pdf;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Anchor;
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.html.HtmlWriter;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.rtf.RtfWriter2;

public class A4PDF {

	public static void main(String arg[]) throws Exception {

		headerFooter();
	}
	
	    public static void headerFooter(){
	    

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
	            c.setColspan(2);
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
	public static void anchor()throws Exception{
		
		Document document = new Document();
		PdfWriter writer = 
			PdfWriter.getInstance(document, 
				new FileOutputStream("anchor.pdf"));
		document.open();
		
		// Code 1
		Font font = new Font();
		font.setColor(Color.BLUE);
		font.setStyle(Font.UNDERLINE);		
		
		document.add(new Chunk("Chapter 1"));			
		
		document.add(
		new Paragraph(
		new Chunk("Press here to go chapter 2", font)
		.setLocalGoto("2")));// Code 2
		
		document.newPage();		
				
		document.add(new Chunk("Chapter 2")
			.setLocalDestination("2"));
		document.add(
		new Paragraph(
		new Chunk("http://www.geek-tutorials.com", font)
		.setAnchor("http://www.geek-tutorials.com")));//Code 3
		
		document.add(
		new Paragraph(
		new Chunk("Open outline.pdf chapter 3", font)
		.setRemoteGoto("outline.pdf", "3")));//Code 4
		
		document.close();
		
	}
		
	public static void list()throws Exception {
		
		      System.out.println("Create List object");
		      Document document = new Document();
		            PdfWriter.getInstance(document, new FileOutputStream("lists.pdf"));
		            document.open();
		            List list = new List(true, 20);
		            list.add(new ListItem("First line"));
		            list.add(new ListItem("The second "));
		            list.add(new ListItem("Third line"));
		            document.add(list);
		            document.add(new Paragraph("Tutorials Provided By Roseindia.net"));
		            ListItem listItem;
		            list = new List(true, 15);
		            listItem = new ListItem("Core Java", FontFactory.getFont(FontFactory
		.TIMES_ROMAN, 13));
		            listItem.add(new Chunk(" by rose india", FontFactory.getFont(
		FontFactory.TIMES_ROMAN, 13, Font.ITALIC)));
		            list.add(listItem);
		            listItem = new ListItem("J2EE", FontFactory.getFont(FontFactory.
		TIMES_ROMAN, 12));
		            listItem.add(new Chunk(" by rose india", FontFactory.getFont(
		FontFactory.TIMES_ROMAN, 13, Font.ITALIC)));
		            list.add(listItem);
		            listItem = new ListItem("JSP", FontFactory.getFont(FontFactory.
		TIMES_ROMAN, 12));
		            listItem.add(new Chunk(" by rose india", FontFactory.getFont(
		FontFactory.TIMES_ROMAN, 13, Font.ITALIC)));
		            list.add(listItem);
		            document.add(list);
		            Paragraph paragraph = new Paragraph("Some open source project");
		            list = new List(false, 10);
		            list.add("chat server");
		            list.add("pie chart");
		            list.add("online shopping");
		            paragraph.add(list);
		            document.add(paragraph);
		            document.add(new Paragraph("Some iText Example"));
		            list = new List(false, 20);
		            list.setListSymbol(new Chunk("\u2021", FontFactory.getFont(
		FontFactory.HELVETICA, 21, Font.BOLD)));
		            listItem = new ListItem("Generates a simple 'Hello World' PDF file");
		            list.add(listItem);
		            List sublist;
		            sublist = new List(false, true, 10);
		            sublist.setListSymbol(new Chunk("", FontFactory.getFont(
		FontFactory.HELVETICA, 7)));
		            sublist.add("Creating Paragraph using iText");
		            sublist.add("Creating Section using iText");
		            sublist.add("Creating A4 PDF using iText.");
		            sublist.add("Create size(509,50,50,50) A4 PDF Using iText");
		            list.add(sublist);
		            listItem = new ListItem("Craeting  table object using iText");
		            list.add(listItem);
		            sublist = new List(false, true, 10);
		            sublist.setFirst('a');
		            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory
		.HELVETICA, 7)));
		            sublist.add("Creating  list object using iText ");
		            sublist.add("Hotel New Hampshire");
		            sublist.add("Creating  list object using iText ");
		            sublist.add("Creating  list object using iText ");
		            list.add(sublist);
		            listItem = new ListItem("Creating  list object using iText ");
		            list.add(listItem);
		            sublist = new List(false, true, 10);
		            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory
		.HELVETICA, 7)));
		            sublist.add("Creating  list object using iText ");
		            sublist.add("Creating  list object using iText ");
		            sublist.add("Creating  list object using iText ");
		            sublist.add("Creating  list object using iText ");
		            list.add(sublist);
		            document.add(list);    
		      document.close();
		  
	}
	public static void exampleOfDifferentFonts() throws Exception {
		Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("differentfontspdf.pdf"));
		document.open();
		Paragraph p = new Paragraph();
		p.add(new Chunk("This text is in Times Roman. ", new Font(
				Font.TIMES_ROMAN, 12)));
		p.add(new Chunk("This is ZapfDingbats: ", new Font(Font.ZAPFDINGBATS,
				12)));
		p.add(new Chunk(". This is font Symbol: ", new Font(Font.TIMES_ROMAN,
				12)));
		p.add(new Chunk("This text is in Times Roman.", new Font(Font.SYMBOL,
				12)));
		document.add(new Paragraph(p));
		
		
		String[][] FONTS = {
				{ "src/main/webapp/fonts/MFDEV014.TTF", BaseFont.WINANSI },
				{ "src/main/webapp/fonts/MFDEV140.TTF", BaseFont.WINANSI },
				{ "src/main/webapp/fonts/MFDEV100.TTF", BaseFont.WINANSI },
				{ BaseFont.HELVETICA, BaseFont.WINANSI } };
		/*
		 * {"resources/fonts/cmr10.pfm", BaseFont.WINANSI},
		 * {"c:/windows/fonts/ARBLI__.TTF", BaseFont.WINANSI},
		 * {"c:/windows/fonts/arial.ttf", BaseFont.WINANSI},
		 * {"c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H},
		 * {"resources/fonts/Puritan2.otf", BaseFont.WINANSI},
		 * {"c:/windows/fonts/msgothic.ttc,0", BaseFont.IDENTITY_H},
		 * {"KozMinPro-Regular", "UniJIS-UCS2-H"}
		 */
		String TEXT = "quick brown fox jumps over the lazy dog\nQUICK BROWN FOX JUMPS OVER THE LAZY DOG";
		BaseFont bf;
		Font font;
		
		bf = BaseFont.createFont(FONTS[0][0], FONTS[0][1], BaseFont.EMBEDDED);

		document.add(new Paragraph(String.format(
				"Font file: %s with encoding %s", FONTS[0][0], FONTS[0][1])));
		document.add(new Paragraph(String.format("iText class: %s", bf
				.getClass().getName())));

		font = new Font(bf, 12);
		document.add(new Paragraph(TEXT, font));
		bf = BaseFont.createFont(FONTS[1][0], FONTS[1][1], BaseFont.EMBEDDED);
		font = new Font(bf, 12);
		document.add(new Paragraph(TEXT, font));
		bf = BaseFont.createFont(FONTS[2][0], FONTS[2][1], BaseFont.EMBEDDED);
		font = new Font(bf, 12);
		document.add(new Paragraph(TEXT, font));


		document.close();
	}

	public static void differentWritersMultiple() throws Exception {

		System.out.println("Hello World in PDF, RTF and HTML");

		Document document = new Document();
		try {

			PdfWriter pdf = PdfWriter.getInstance(document,
					new FileOutputStream("differentWritersdPdf.pdf"));
			RtfWriter2 rtf = RtfWriter2.getInstance(document,
					new FileOutputStream("differentWritersRtf.rtf"));
			HtmlWriter html = HtmlWriter.getInstance(document,
					new FileOutputStream("differentWritersdHtml.html"));

			document.open();

			document.add(new Paragraph("Hello World"));

			Anchor pdfRef = new Anchor("see Hello World in PDF.");
			pdfRef.setReference("./HelloWorldPdf.pdf");
			Anchor rtfRef = new Anchor("see Hello World in RTF.");
			rtfRef.setReference("./HelloWorldRtf.rtf");

			pdf.pause();
			rtf.pause();
			document.add(pdfRef);
			document.add(Chunk.NEWLINE);
			document.add(rtfRef);
			pdf.resume();
			rtf.resume();

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}

		document.close();
	}

	public static void sectionPDF() throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("sectionPDF.pdf"));
		document.open();
		Chapter chapter = new Chapter(new Paragraph("Chapter1"), 1);
		Section section1 = chapter.addSection(new Paragraph("Section1"));
		section1.add(new Paragraph("Rose India"));
		Section section2 = chapter.addSection(new Paragraph("section2"));
		section2.add(new Paragraph("roseinia.net"));
		document.add(chapter);
		document.close();
	}

	public static void a4PDF() throws Exception {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream("a4PDF.pdf"));
		document.open();

		document.add(new Paragraph("Parakh"));
		document.close();
	}

	public static void imagesPDF() {
		try {
			Document document = new Document(PageSize.A4.rotate(), 10, 10, 10,
					10);
			PdfWriter.getInstance(document, new FileOutputStream(
					"imagesPDF2.pdf"));
			document.open();
/*			Image image = Image.getInstance("src/main/webapp/images/Sarva-Shiksha-Abhiyan-300x95.jpg");
			document.add(new Paragraph("MarksSheet"));
			document.add(image);
*/
			PdfPTable table0 = new PdfPTable(1);
			table0.addCell("Name");
			table0.addCell("Place");
			

			PdfPTable table1 = new PdfPTable(2);
			table1.setTotalWidth(10f);
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCell.setPhrase(new Phrase("1."));	
			table1.addCell(table0);
			pdfPCell.setPhrase(new Phrase("21."));	
			table1.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase("31."));	
			table1.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase("41."));	
			table1.addCell(pdfPCell);
			
			PdfPTable table = new PdfPTable(2);
			table.addCell("Name");
			table.addCell("Place");
			table.addCell("RoseIndia");
			table.addCell("Delhi");
			document.add(table);
			document.add(table1);

			document.close();
		} catch (Exception e) {

		}
	}

	public static void landscapeportraitPDF() throws Exception {
		Document document = new Document(PageSize.A4.rotate());
		PdfWriter.getInstance(document, new FileOutputStream(
				"landscapeportraitPDF.pdf"));
		document.open();
		document.add(new Paragraph(
				"landscape format, just 	make the height smaller than the width."));
		document.setPageSize(PageSize.A4);
		document.newPage();
		document.add(new Paragraph("This is portrait again"));

		document.close();
	}

	public static void chunkPDF() throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("chunkPDF.pdf"));
		document.open();
		Chunk chunk = new Chunk("Welecome To RoseIndia.");
		chunk.setUnderline(+1f, -2f);
		Chunk chunk1 = new Chunk("RoseIndia.net");
		chunk1.setUnderline(+4f, -2f);
		chunk1.setBackground(Color.red);
		document.add(chunk);
		document.add(chunk1);
		document.close();
	}

}