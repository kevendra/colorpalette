package com.parakhcomputer.util.pdf;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PositionPdf {
	private static String FILE = "PositionPdf.pdf";

	public static void main(String[] args) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			// Left
			Paragraph paragraph = new Paragraph("This is right aligned text");
			paragraph.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragraph);
			// Centered
			paragraph = new Paragraph("This is centered text");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph);
			// Left
			paragraph = new Paragraph("This is left aligned text");
			paragraph.setAlignment(Element.ALIGN_LEFT);
			document.add(paragraph);
			// Left with indentation
			paragraph = new Paragraph(
					"This is left aligned text with indentation");
			paragraph.setAlignment(Element.ALIGN_LEFT);
			paragraph.setIndentationLeft(50);
			document.add(paragraph);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
