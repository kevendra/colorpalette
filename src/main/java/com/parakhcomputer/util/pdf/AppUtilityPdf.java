package com.parakhcomputer.util.pdf;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.parakhcomputer.util.AppConstant;
import com.parakhcomputer.util.AppUtility;

public class AppUtilityPdf extends AppUtility implements AppConstant{

	private String realPath;
	
	
	
	
	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	
	public void addPDFProperties(Document document){
		document.addTitle(AppConstant.PDF_TITLE);
		document.addAuthor(AppConstant.AUTHOR);
		document.addCreator(AppConstant.ORGANIZATION);
		document.addKeywords(AppConstant.ORGANIZATION);
		document.addSubject(AppConstant.PDF_SUBJECT);		
	}

	public Document createPdfDocumentA4Landscape(String fileName) throws Exception{
		//util();
		fileName = PDF_DIRECTORY + fileName;
		Document document = new Document(PageSize.A4.rotate(), 20, 20, 20, 20);
				 
		PdfWriter.getInstance(document,	new FileOutputStream(fileName));
		
		document.open();
		addPDFProperties(document);
		
		return document;		
	}
	public Document createPdfDocumentA4LandscapeLessMargin(String fileName) throws Exception{
		//util();
		fileName = PDF_DIRECTORY + fileName;
		Document document = new Document(PageSize.A4.rotate(), 20, 20, 10, 10);
				 
		PdfWriter.getInstance(document,	new FileOutputStream(fileName));

		document.open();
		addPDFProperties(document);
		
		return document;		
	}

	public Document createPdfDocumentLegalLandscape(String fileName) throws Exception{
		//util();
		fileName = PDF_DIRECTORY + fileName;
		Document document = new Document(PageSize.A3.rotate(), 20, 20, 20, 15);
				 
		PdfWriter.getInstance(document,	new FileOutputStream(fileName));
		
		HeaderFooter footer = new HeaderFooter(new Phrase("Page no: "), true);
		footer.setBorder(Rectangle.NO_BORDER);
		footer.setAlignment(Element.ALIGN_CENTER);
		
		//document.setFooter(footer);
		
		document.open();
		addPDFProperties(document);
		
		return document;		
	}
	public Document createPdfDocumentA4Portrait(String fileName) throws Exception{
		fileName = PDF_DIRECTORY + fileName;
		Document document = new Document(PageSize.A4, 20, 20, 20, 20);
				 
		PdfWriter.getInstance(document,	new FileOutputStream(fileName));
		
		document.open();
		addPDFProperties(document);
		
		return document;		
	}
	
	
//	public String[][] FONTS = {
//				{ "src/main/webapp/fonts/MFDEV014.TTF", BaseFont.WINANSI },
//				{ "src/main/webapp/fonts/MFDEV140.TTF", BaseFont.WINANSI },
//				{ "src/main/webapp/fonts/MFDEV100.TTF", BaseFont.WINANSI },
//				{ "src/main/webapp/fonts/arial.ttf", BaseFont.WINANSI },			
//				{ BaseFont.HELVETICA, BaseFont.WINANSI } };
	public String[][] FONTS = {
			{ "fonts/MFDEV014.TTF", BaseFont.WINANSI },
			{ "fonts/MFDEV140.TTF", BaseFont.WINANSI },
			{ "fonts/MFDEV100.TTF", BaseFont.WINANSI },
			{ "fonts/arial.ttf", BaseFont.WINANSI },			
			{ BaseFont.HELVETICA, BaseFont.WINANSI } };

//	public String[][] FONTS = new String[5][2];
	
//	public String[][] FONTS = new String[4][2];
	  public BaseFont bsaeFontDev010 = null;
	  public BaseFont bsaeFontDev140 = null;
	  public BaseFont bsaeFontDev100 = null;
	  public BaseFont bsaeFontArial = null;

	  public Font fontDev010s9;
	  public Font fontDev010s10;
	  public Font fontDev010;
	  public Font fontDev010s13;

	  public Font fontDev140;
	  public Font fontDev140s12;
	  public Font fontDev140s13;
			
	  public Font fontDev100s8;
	  public Font fontDev100s9;
	  public Font fontDev100s10;
	  public Font fontDev100;
	  public Font fontDev100s12;
	  public Font fontDev100s13;

	  public Font fontArials6;
	  public Font fontArials7;
	  public Font fontArials8;
	  public Font fontArial;
	  public Font fontArials12;	
		 
			public  void util(){
				FONTS[0][0] = getRealPath()+"/fonts/MFDEV014.TTF";
				FONTS[1][0] = getRealPath()+"/fonts/MFDEV140.TTF";
				FONTS[2][0] = getRealPath()+"/fonts/MFDEV100.TTF";
				FONTS[3][0] = getRealPath()+"/fonts/ARIAL.TTF";
				
				
				try{
					bsaeFontDev010 = BaseFont.createFont(FONTS[0][0], FONTS[0][1], BaseFont.EMBEDDED);
					
					fontDev010s10 = new Font(bsaeFontDev010, 10);
					fontDev010s9 = new Font(bsaeFontDev010, 9);
					fontDev010 = new Font(bsaeFontDev010, 11);
					fontDev010s13 = new Font(bsaeFontDev010, 13);
					
					bsaeFontDev140 = BaseFont.createFont(FONTS[1][0], FONTS[1][1], BaseFont.EMBEDDED);
					fontDev140 = new Font(bsaeFontDev140, 9);
					fontDev140s12 = new Font(bsaeFontDev140, 10);
					fontDev140s13 = new Font(bsaeFontDev140, 11);

					bsaeFontDev100 = BaseFont.createFont(FONTS[2][0], FONTS[2][1], BaseFont.EMBEDDED);
					fontDev100s8 = new Font(bsaeFontDev100, 8);
					fontDev100s9 = new Font(bsaeFontDev100, 9);
					fontDev100 = new Font(bsaeFontDev100, 11);
					fontDev100s10 = new Font(bsaeFontDev100, 10);
					fontDev100s12 = new Font(bsaeFontDev100, 12);
					fontDev100s13 = new Font(bsaeFontDev100, 13);
					
					bsaeFontArial = BaseFont.createFont(FONTS[3][0], FONTS[3][1], BaseFont.EMBEDDED);
					fontArial = new Font(bsaeFontArial, 11);
					fontArials6 = new Font(bsaeFontArial, 6);
					fontArials7 = new Font(bsaeFontArial, 7);
					fontArials8 = new Font(bsaeFontArial, 8);
					fontArials12 = new Font(bsaeFontArial, 12);
					
					//fontDev010s13.setStyle(Font.BOLD);
					
				}catch(DocumentException e){
					System.err.println("Error 1");
					e.printStackTrace();
				}catch(IOException ioe){
					System.err.println("Error 2");
					ioe.printStackTrace();
				}
			}
	
	
	//TODO move to AppConstant			
					
}
