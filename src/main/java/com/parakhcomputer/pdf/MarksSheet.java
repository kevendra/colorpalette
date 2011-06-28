package com.parakhcomputer.pdf;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.parakhcomputer.util.AppUtility;
import com.parakhcomputer.util.pdf.AppUtilityPdf;
import com.parakhcomputer.web.model.Person;
import com.parakhcomputer.web.model.School;
import com.parakhcomputer.web.model.StudentMarks;

public class MarksSheet extends AppUtilityPdf {
	
	String[][] grade = new String[26][14];
	
	String personId = "";
	String titleStudent = "";
	String nameStudent = "";		
	String nameFather = "";		
	String nameMother = "";
	String doBInNumber = "";
	String doBInWord = "";
	String caste = "";
	String block = "";
	String district = "";
	String scholarNo = "";
	String serialNo = "";
	String rollNo = "";
	String class_ = "";
	String section = "";
	String schoolName = "";		
	String schoolDISECode = "";		
	String session = "";		
	String finalGrade = "";		
	String finalClass = "";		
	String teacherComment ="";
	String level = "";//purva madhyamik and prathamik  t70 and t70a
	String sCWSN = "";
	
	public void createMarksSheet(Person person, Collection<StudentMarks> studentMarks, School school, String caste, Document documentPage1,Document documentPage2a,Document documentPage2b ){
		String[][] grade = studentMarksToGrade(studentMarks, person);
		personId = "" +person.getPersonId();
		nameStudent = ""+person.getFirstName();
		nameFather = ""+person.getFatherFirstName();
		nameMother = ""+person.getMotherFirstName();
		
		scholarNo = ""+person.getScholarId();
		serialNo = ""+person.getSrId();
		rollNo = ""+person.getRollId();
		class_ = ""+ AppUtility.getClassNameInHindi(person.getClass_());
		section = ""+person.getSection();
		session  = ""+person.getSession();
		teacherComment = ""+person.getTeacherComment();
		Date dob =  person.getDoB()==null?new java.util.Date():person.getDoB();
		doBInNumber =  new SimpleDateFormat("dd/MM/yyyy").format(dob);
		doBInWord =  ""+dateInWord(dob);
		
		this.caste = ""+caste;//new AppendixControllerUtil().getCaste(person.getCasteId());
//		School school = new AppendixControllerUtil().getSchool(person.getSchoolId());
		block =  school.getBlock();
		district = school.getDistrict();
		if(person.getGender().equalsIgnoreCase("M")){
			titleStudent= t84b;
		}else if(person.getGender().equalsIgnoreCase("F")){
			titleStudent= t84g;			
		}else{
			titleStudent= t84;
		}
		schoolName = school.getName();
		schoolDISECode = ""+school.getCode();
		level = "¼"+school.getLevel()+"½";
		
		this.grade = grade; 
		finalGrade = ""+ findGrade(findGradeBand(person.getClass_()), totalMarksForFinalGrade(studentMarks));
		finalClass = ""+ AppUtility.getClassNameInHindi(person.getClass_()+1);
		sCWSN = ""+ populateCWSNHindiList().get(person.getCwsnId());
		
		try{
			page1(documentPage1);
			if(person.getClass_()<=5){
				page2(person.getClass_(),documentPage2a);
			}else{
				page2(person.getClass_(),documentPage2b);
			}
		}catch(Exception e){
			System.out.println("error in pdf creation");
			e.printStackTrace();
		}
	}
		
	public  void page1(Document document) throws Exception{
		
		util();
//		String fileName = personId+"Marks_Sheet_page1.pdf";		
//		Document document = createPdfDocumentA4Landscape(fileName);
		float [] cellFloat = null;
		PdfPCell pdfPCell = null;			
				
				cellFloat = new float []             {2.4f,1.5f,1.6f};
				PdfPTable table2 = new PdfPTable(cellFloat); 
				pdfPCell = new PdfPCell();
				pdfPCell.setPadding(5f);
				pdfPCell.setPhrase(new Phrase(t2,fontDev010)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t7,fontDev100)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t12,fontDev100)); 			table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t3,fontDev010)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t8,fontDev100)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t13,fontDev100)); 			table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t4,fontDev010)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t9,fontDev100)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t14,fontDev100)); 			table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t5,fontDev010)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t10,fontDev100)); 			table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t15,fontDev100)); 			table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t6,fontDev010)); 				table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t11,fontDev100)); 			table2.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t16,fontDev100)); 			table2.addCell(pdfPCell);
				
				cellFloat = new float []             {0.8f,2f,3.8f};
				PdfPTable table3 = new PdfPTable(cellFloat);
				pdfPCell = new PdfPCell();

				pdfPCell.setColspan(3);
				
				Font fontPage1LeftDev100 = new Font(bsaeFontDev100, 11);
				Font fontPage1LeftArial = new Font(bsaeFontArial, 11);

				fontPage1LeftDev100.setSize(9f);
				fontPage1LeftArial.setSize(9f);
				pdfPCell.setPhrase(new Phrase(t17_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setColspan(1);
//				pdfPCell.setPhrase(new Phrase(t17_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t18_1 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t18_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t18_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t19_1 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t19_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t19_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t20_1 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t20_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t20_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t21_1 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t21_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t21_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t22_1 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t22_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t22_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t23_1 ,fontPage1LeftArial));	 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t23_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t23_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t24_1 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t24_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t24_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t25_1 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t25_2 ,fontPage1LeftDev100)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t25_3 ,fontPage1LeftArial)); 				table3.addCell(pdfPCell);
				
				cellFloat = new float []             {0.5f,1f,5f};
				PdfPTable table4 = new PdfPTable(cellFloat);
				pdfPCell = new PdfPCell();
				pdfPCell.setPadding(4f);
				
				pdfPCell.setPhrase(new Phrase(t100,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t26,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t32,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("1.",fontPage1LeftArial)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t27,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t33,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("2.",fontPage1LeftArial)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t28,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t34,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("3.",fontPage1LeftArial)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t29,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t35,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("4.",fontPage1LeftArial)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t30,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t36,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("5.",fontPage1LeftArial)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t31,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t37,fontPage1LeftDev100)); 			table4.addCell(pdfPCell);

				cellFloat = new float []             {0.5f,1f,5f};
				PdfPTable table5 = new PdfPTable(cellFloat);
				pdfPCell = new PdfPCell();
				pdfPCell.setPadding(4f);
				
				pdfPCell.setPhrase(new Phrase(t100,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t38,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t49,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("1.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t39,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t50,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("2.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t40,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t51,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("3.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t41,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t52,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("4.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t42,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t53,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("5.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t43,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t54,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("6.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t44,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t55,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("7.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t45,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t56,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("8.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t46,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t57,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("9.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t47,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t58,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("10.",fontPage1LeftArial)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t48,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t59,fontPage1LeftDev100)); 			table5.addCell(pdfPCell);


				cellFloat = new float []             {0.4f,0.6f};
				PdfPTable table6 = new PdfPTable(cellFloat);	
				table6.setWidthPercentage(100);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(table2);
				table6.addCell(pdfPCell);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(table3);
				table6.addCell(pdfPCell);
				

				PdfPTable table0LeftPage = new PdfPTable(1);
				pdfPCell = new PdfPCell();
				pdfPCell.setPadding(5f);
				
				pdfPCell.setPhrase(new Phrase(t1,fontPage1LeftDev100)); 			
				pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfPCell.setBorderWidth(0);
				table0LeftPage.addCell(pdfPCell);
				pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(table6);
				table0LeftPage.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(t67 ,fontPage1LeftDev100)); 			table0LeftPage.addCell(pdfPCell);

				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(table4);
				table0LeftPage.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(t68 ,fontPage1LeftDev100)); 			table0LeftPage.addCell(pdfPCell);

				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(table5);
				table0LeftPage.addCell(pdfPCell);

				
// ***************************************** Page1 Right side*****************************************

			
				Font fontPage1RightDev100 = new Font(bsaeFontDev100, 11);
				Font fontPage1RightDev010 = new Font(bsaeFontDev010, 11);
				Font fontPage1RightArial = new Font(bsaeFontArial, 11);
				
				PdfPTable tableRightPage1 = new PdfPTable(1);
				pdfPCell = new PdfPCell();
//				pdfPCell.setPadding(4f);
				pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfPCell.setBorderWidth(0);
				
				Font f1 = new Font(bsaeFontDev100, 25);
				f1.setStyle(Font.BOLD);
				
				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 			tableRightPage1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 			tableRightPage1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t69,f1)); 			
				tableRightPage1.addCell(pdfPCell);
				
				f1=new Font(bsaeFontDev100, 17);
				fontPage1RightDev100.setSize(13f);
				pdfPCell.setPhrase(new Phrase(level,f1)); 			
				tableRightPage1.addCell(pdfPCell);
				
				f1 = new Font(bsaeFontDev010, 21);
				f1.setStyle(Font.BOLD);
				pdfPCell.setPhrase(new Phrase(t71,f1)); 			
				tableRightPage1.addCell(pdfPCell);
				
				
//				Image image = Image.getInstance("src/main/webapp/images/Sarva-Shiksha-Abhiyan-300x95.jpg");
//				Image image = Image.getInstance(getRealPath()+"/images/Sarva-Shiksha-Abhiyan-300x95.jpg");
				//image.scalePercent (10.0f);
				//image.setWidthPercentage(12);
				//document.add(image);
				cellFloat = new float []             {1f,1.5f,1f};
				PdfPTable tableRightPage2 = new PdfPTable(cellFloat);
				tableRightPage2.setWidthPercentage(100);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.setPhrase(new Phrase("" ,fontDev100));
				tableRightPage2.addCell(pdfPCell);
				pdfPCell.addElement(Image.getInstance(getRealPath()+"/images/Sarva-Shiksha-Abhiyan-300x95.jpg"));
				tableRightPage2.addCell(pdfPCell);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.setPhrase(new Phrase(" " ,fontDev100));				tableRightPage2.addCell(pdfPCell);


				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(tableRightPage2);
				tableRightPage1.addCell(pdfPCell);
				//pdfPCell = new PdfPCell();
				
				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 			tableRightPage1.addCell(pdfPCell);
//				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 			tableRightPage1.addCell(pdfPCell);
//				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 			tableRightPage1.addCell(pdfPCell);
				
				//fontPage1RightDev100.setSize(12f);
				//fontDev100.setStyle(Font.NORMAL);
				
				cellFloat = new float []             {1f,1f,1f,1f};
				PdfPTable tableRightPage3 = new PdfPTable(cellFloat);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);				
				pdfPCell.setPaddingTop(6f);
				pdfPCell.setPaddingBottom(5f);
				Font fontArial10 = new Font(bsaeFontArial, 10);
				
				pdfPCell.setPhrase(new Phrase(t72 ,fontDev100)); 						tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(2);
				pdfPCell.setPhrase(new Phrase("% "+schoolName ,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(1);
				pdfPCell.setPhrase(new Phrase("  ("+schoolDISECode+")" ,fontArial10)); 	tableRightPage3.addCell(pdfPCell);
//				pdfPCell.setPhrase(new Phrase("" ,fontDev100));							tableRightPage3.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(t73 ,fontDev100)); 						tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("% "+block,fontDev100)); 					tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t74 ,fontDev100)); 						tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("% "+district,fontDev100)); 				tableRightPage3.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(t75 ,fontDev100)); 						tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(":  "+serialNo,fontArial10)); 				tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t76 ,fontDev100)); 						tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(":  "+rollNo,fontArial10)); 				tableRightPage3.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(t78 ,fontDev100)); 						tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("%  "+class_,fontPage1RightDev010)); 		tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t77 ,fontDev100)); 						tableRightPage3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(":  "+scholarNo,fontArial10)); 			tableRightPage3.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(t79 ,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(3);
				pdfPCell.setPhrase(new Phrase("% "+titleStudent+" "+nameStudent,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(1);
				
				pdfPCell.setPhrase(new Phrase(t80 ,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(3);
				pdfPCell.setPhrase(new Phrase("% "+t85+" "+nameMother,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(1);
				
				pdfPCell.setPhrase(new Phrase(t81 ,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(3);
				pdfPCell.setPhrase(new Phrase("% "+t86+" "+nameFather,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(1);
				
				pdfPCell.setPhrase(new Phrase(t82a ,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(3);
				pdfPCell.setPhrase(new Phrase(":  "+doBInNumber,fontArial10)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(1);

				pdfPCell.setPhrase(new Phrase(t82b ,fontDev100));				tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(3);
				pdfPCell.setPhrase(new Phrase("% "+doBInWord,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(1);

				pdfPCell.setPhrase(new Phrase(t83 ,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(3);
				pdfPCell.setPhrase(new Phrase("% "+caste,fontDev100)); 			tableRightPage3.addCell(pdfPCell);
				pdfPCell.setColspan(1);
				

				tableRightPage3.setWidthPercentage(100);

				pdfPCell.addElement(tableRightPage3);
				tableRightPage1.addCell(pdfPCell);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);

				pdfPCell.setPhrase(new Phrase(t90,fontDev100)); 			tableRightPage1.addCell(pdfPCell);
				
				cellFloat = new float []             {1.2f,0.8f,1.2f,0.8f,1.4f,0.8f,1f,0.8f};
				PdfPTable tableRightPage4 = new PdfPTable(cellFloat);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);				
				//pdfPCell.setPadding(6f);
				pdfPCell.setPhrase(new Phrase(t91 ,fontDev100)); 						tableRightPage4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("% -----------" ,fontDev100)); 			tableRightPage4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t92 ,fontDev100)); 						tableRightPage4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("% -----------" ,fontDev100)); 			tableRightPage4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t93 ,fontDev100)); 						tableRightPage4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("% -----------" ,fontDev100)); 			tableRightPage4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(t94 ,fontDev100)); 						tableRightPage4.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("% -----------" ,fontDev100)); 			tableRightPage4.addCell(pdfPCell);
				
				tableRightPage4.setWidthPercentage(100);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(tableRightPage4);
				tableRightPage1.addCell(pdfPCell);

				cellFloat = new float []             {1f,1f,1f,1f};
				PdfPTable tableRightPage5 = new PdfPTable(cellFloat);
				tableRightPage5.setWidthPercentage(100);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);				
				pdfPCell.setPaddingTop(4f);

				if(null!=sCWSN && sCWSN.equals("")){
					pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 							tableRightPage5.addCell(pdfPCell);
					pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 							tableRightPage5.addCell(pdfPCell);
				}else{
					pdfPCell.setPhrase(new Phrase(t95,fontDev100)); 									tableRightPage5.addCell(pdfPCell);
					pdfPCell.setPhrase(new Phrase("% "+sCWSN,fontDev100)); 									tableRightPage5.addCell(pdfPCell);					
				}
				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 							tableRightPage5.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 							tableRightPage5.addCell(pdfPCell);



				pdfPCell.addElement(tableRightPage5);
				tableRightPage1.addCell(pdfPCell);
				pdfPCell.setBorderWidth(0);
				
//				pdfPCell = new PdfPCell();
//				pdfPCell.setBorderWidth(0);
//				pdfPCell.setPaddingTop(6f);
//				pdfPCell.setPhrase(new Phrase(t95,fontDev100)); 									tableRightPage1.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 							tableRightPage1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(" ",fontPage1RightDev100)); 							tableRightPage1.addCell(pdfPCell);

				
				
				PdfPTable tableRightPage6 = new PdfPTable(3);
				pdfPCell = new PdfPCell();
				pdfPCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
				pdfPCell.setBorderWidth(0);
				
				pdfPCell.setPhrase(new Phrase(" " ,fontDev100));								
				tableRightPage6.addCell(pdfPCell);
//				pdfPCell.setPhrase(new Phrase(" " ,fontDev100));								
//				tableRightPage5.addCell(pdfPCell);
//				Image image2 = Image.getInstance(getRealPath()+"/images/parakhComputer.gif");
				pdfPCell.addElement(Image.getInstance(getRealPath()+"/images/parakhComputer.gif"));
				tableRightPage6.addCell(pdfPCell);
				pdfPCell = new PdfPCell();
				pdfPCell.setPhrase(new Phrase("" ,fontDev100));
				pdfPCell.setBorderWidth(0);
				tableRightPage6.addCell(pdfPCell);


				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(tableRightPage6);
				tableRightPage1.addCell(pdfPCell);				
									
				
				PdfPTable table0RightPage = new PdfPTable(1);
				
				tableRightPage1.setWidthPercentage(95);
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);
				pdfPCell.addElement(tableRightPage1);
				table0RightPage.addCell(pdfPCell);						
				
				cellFloat = new float []             {10f,1f,10f};
				PdfPTable table0 = new PdfPTable(cellFloat);
				pdfPCell = new PdfPCell();

				table0.addCell(table0LeftPage);
				pdfPCell.setPhrase(new Phrase("" ,fontDev100));
				pdfPCell.setBorderWidthTop(0);
				pdfPCell.setBorderWidthBottom(0);
				table0.addCell(pdfPCell);//middle cell/page
				table0.addCell(table0RightPage);
				
		
				table0.setWidthPercentage(100);
				table2.setWidthPercentage(100);
				table3.setWidthPercentage(100);
				table4.setWidthPercentage(100);
				table5.setWidthPercentage(100);

				table0.setSpacingBefore(10f);
				document.add(table0);
	
		
//			document.close();						
	}
	
	
// ******************************** Page 2 ******************************
	
	public  void page2(int iClass, Document document) throws Exception{
		util();
		
//		String fileName = personId+ "Marks_Sheet_page2.pdf";		
//		Document document;
//		if(iClass<=5){
//			document = new AppUtilityPdf().createPdfDocumentA4Landscape(fileName);			
//		}else{
//			document = new AppUtilityPdf().createPdfDocumentA4LandscapeLessMargin(fileName);			
//		}
		
		float [] cellFloat = new float []{1.25f,1.75f,2f,3f,1f,1f,1f,3f,1f,1f};
		PdfPTable table = new PdfPTable(cellFloat);
		table.setWidthPercentage(100);

		PdfPCell pdfPCell = new PdfPCell();
		PdfPCell pdfPCellHoriAlignRight = new PdfPCell();
		
		pdfPCellHoriAlignRight.setHorizontalAlignment(Element.ALIGN_RIGHT);
		pdfPCellHoriAlignRight.setBorderWidth(0);
		pdfPCell.setBorderWidth(0);
		
		pdfPCell.setPhrase(new Phrase(new Chunk ("Ldkyj Ø- %", fontDev100s13)));	table.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(new Chunk (scholarNo, fontArials12)));	table.addCell(pdfPCell);
		pdfPCellHoriAlignRight.setPhrase(new Phrase(new Chunk ("fo|kFkhZ dk uke %", fontDev100s13))); table.addCell(pdfPCellHoriAlignRight);
		pdfPCell.setPhrase(new Phrase(new Chunk (nameStudent, fontDev100s12)));	table.addCell(pdfPCell);
		pdfPCellHoriAlignRight.setPhrase(new Phrase(new Chunk ("d{kk %", fontDev100s13))); table.addCell(pdfPCellHoriAlignRight);
		pdfPCell.setPhrase(new Phrase(new Chunk (class_, fontDev010s13)));	table.addCell(pdfPCell);
		pdfPCellHoriAlignRight.setPhrase(new Phrase(new Chunk ("'kkyk %", fontDev100s13))); table.addCell(pdfPCellHoriAlignRight);
		pdfPCell.setPhrase(new Phrase(new Chunk (schoolName, fontDev100s12)));	table.addCell(pdfPCell);
		pdfPCellHoriAlignRight.setPhrase(new Phrase(new Chunk ("l= %", fontDev100s13))); table.addCell(pdfPCellHoriAlignRight);
		pdfPCell.setPhrase(new Phrase(new Chunk (session+"  ", fontArials12)));	table.addCell(pdfPCell);

		document.add(new Paragraph());		 
		document.add(table);

		PdfPTable table1; 
		
		PdfPTable table2;
		
		PdfPTable table3;

		PdfPTable table4;;

		if(iClass <=5){
			table1 = marksSheetPage2Table1(grade);
			
			table2 = marksSheetPage2Table2(grade);
			
			table3 = marksSheetPage2Table3(grade);

			table4 = marksSheetPage2Table4(grade);			
			
		}else{
			table1 = marksSheetPage4Table1(grade);
			
			table2 = marksSheetPage4Table2(grade);
			
			table3 = marksSheetPage4Table3(grade);

			table4 = marksSheetPage4Table4(grade);			
		}

		table1.setWidthPercentage(100);
		table1.setSpacingBefore(10f);
	    table1.setSpacingAfter(1f);	      

		table2.setWidthPercentage(100);
		table2.setSpacingBefore(4f);
	    table2.setSpacingAfter(1f);	      
	      
		table3.setWidthPercentage(100);
		table3.setSpacingBefore(4f);
	    table3.setSpacingAfter(1f);	      
	 
		table4.setWidthPercentage(100);
		table4.setSpacingBefore(4f);
	    table4.setSpacingAfter(1f);	 
	    
	    
	    document.add(new Paragraph());
		document.add(table1);
		document.add(table2);
		document.add(table3);
		document.add(table4);
		
		document.add(new Paragraph());
		
		   document.add (new Chunk ("f'k{kd dk vfHker % ", fontDev100s12));
		   if(null==teacherComment||teacherComment.isEmpty()){
		   document.add (new Chunk ("- - - - - - - - - - - - - - - - - - - - - - - - - - ", fontDev100s12));
		   document.add (new Chunk ("- - - - - - - - - - - - - - - - - - - - - - - - - - ", fontDev100s12));
		   }else{
			   document.add (new Chunk (teacherComment, fontDev100));
		   }
		   document.add (Chunk.NEWLINE);		 
		   if(iClass<=5){
			   document.add (Chunk.NEWLINE);		 			   
		   }
		   document.add (new Chunk ("okf\"kZd ifj.kke xszM % ", fontDev100s12));			 
		   document.add (new Chunk (finalGrade, fontArials12));
		   document.add (new Chunk ("       ", fontDev100s12));			 
		   document.add (new Chunk ("mDr fo|kFkhZ dks d{kk", fontDev100s12));			 
		   document.add (new Chunk ("  "+finalClass+"  ", fontDev010s13));			 
		   document.add (new Chunk ("es d{kksUufr nh tkrh gS A", fontDev100s12));			 

		   document.add (new Chunk ("             ", fontDev100s12));			 
		   document.add (new Chunk ("             ", fontDev100s12));			 

		   document.add (new Chunk ("d{kk/;kid ds gLrk{kj", fontDev100s12));			 
		   document.add (new Chunk ("        ", fontDev100s12));			 
		   document.add (new Chunk ("        ", fontDev100s12));			 
		   document.add (new Chunk ("iz/kkuk/;kid ds gLrk{kj o ineqnzk", fontDev100s12));			 
		   
//		document.close();				
	}
	
	
	

	// ************************************************** Page 2 ********************************************
		
		public  PdfPTable marksSheetPage2Table1(String[][] grade){
			float [] cellFloat = new float []
			                        {0.5f,3f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
			PdfPTable table1 = new PdfPTable(cellFloat);

			PdfPCell pdfPCellHoriAlignBC = new PdfPCell();
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCellBC = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellHoriAlignBC.setBackgroundColor (new Color (238,238,224));//238,238,224 //245,245,245
			pdfPCellHoriAlignBC.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellBC.setBackgroundColor (new Color (205,201,201));//238,238,224//205-201-201 //245,245,245 //220-220-220
			pdfPCellBC.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPTable table0 = new PdfPTable(1);
			pdfPCellBC.setPhrase(new Phrase("'kSf{kd {kS=ks dk ewY;kadu ¼xszM½",fontDev100)); 			table0.addCell(pdfPCellBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fo\"k;",fontDev100));		table0.addCell(pdfPCellHoriAlignBC);
					
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Ø-",fontDev100)); 			table1.addCell(pdfPCellHoriAlignBC);
			table1.addCell(table0);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vizsy",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);	
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tqykbZ",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vxLr",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("flrEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vDVqEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("v}Zokf\"kZd eqY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fnlEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tuojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Qjojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ewY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ifj.kke",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlign.setPhrase(new Phrase("1.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("izFke Hkk\"kk¼fgUnh½",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("2.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("f}rh; Hkk\"kk¼vaxzsth½",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("3.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("xf.kr",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("4.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("Ik;kZoj.k v?;;u",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("5.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("vfrfjDr fo\"k;",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		
			
			return table1;
			
		}
		
		public  PdfPTable marksSheetPage2Table2(String[][] grade){
			float [] cellFloat = new float []
			                        {0.5f,3f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
			PdfPTable table1 = new PdfPTable(cellFloat);
			//table1.setTotalWidth(10f);
			PdfPCell pdfPCellHoriAlignBC = new PdfPCell();
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellHoriAlignBC.setBackgroundColor (new Color (238,238,224));//238,238,224 //245,245,245
			pdfPCellHoriAlignBC.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell pdfPCellBC = new PdfPCell();
			pdfPCellBC.setBackgroundColor (new Color (205,201,201));//238,238,224//205-201-201 //245,245,245 //220-220-220
			pdfPCellBC.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPTable table0 = new PdfPTable(1);
			pdfPCellBC.setPhrase(new Phrase("lg'kSf{kd {kS=ks dk ewY;kadu ¼xszM½",fontDev100)); 			table0.addCell(pdfPCellBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("{kS=",fontDev100));		table0.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlignBC.setPhrase(new Phrase("Ø-",fontDev100)); 			table1.addCell(pdfPCellHoriAlignBC);
//			pdfPCellHoriAlignBC.setPhrase(new Phrase("{kS=",fontDev100));		table1.addCell(pdfPCellHoriAlignBC);
			table1.addCell(table0);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vizsy",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);	
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tqykbZ",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vxLr",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("flrEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vDVqEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("v}Zokf\"kZd eqY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fnlEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tuojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Qjojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ewY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ifj.kke",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlign.setPhrase(new Phrase("1.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lkfgfR;d",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("2.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lkaLd`frd",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("3.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("oSKkfud",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("4.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("l`tukRed",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("5.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("[ksydwy];ksx]LdkmV@jsMdzkl",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		
			
			return table1;
			
		}
		public  PdfPTable marksSheetPage2Table3(String[][] grade){
			float [] cellFloat = new float []
			                        {0.5f,3f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
			PdfPTable table1 = new PdfPTable(cellFloat);

			PdfPCell pdfPCellHoriAlignBC = new PdfPCell();
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellHoriAlignBC.setBackgroundColor (new Color (238,238,224));//238,238,224 //245,245,245
			pdfPCellHoriAlignBC.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell pdfPCellBC = new PdfPCell();
			pdfPCellBC.setBackgroundColor (new Color (205,201,201));//238,238,224//205-201-201 //245,245,245 //220-220-220
			pdfPCellBC.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPTable table0 = new PdfPTable(1);
			pdfPCellBC.setPhrase(new Phrase("O;fDrxr&lkekftd xq.kks dk eqY;kadu¼xzsM½",fontDev100)); 			table0.addCell(pdfPCellBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("xq.k",fontDev100));		table0.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlignBC.setPhrase(new Phrase("Ø-",fontDev100)); 			table1.addCell(pdfPCellHoriAlignBC);
//			pdfPCellHoriAlignBC.setPhrase(new Phrase("xq.k",fontDev100));		table1.addCell(pdfPCellHoriAlignBC);
			table1.addCell(table0);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vizsy",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);	
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tqykbZ",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vxLr",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("flrEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vDVqEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("v}Zokf\"kZd eqY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fnlEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tuojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Qjojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ewY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ifj.kke",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlign.setPhrase(new Phrase("1.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("fu;ferrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("2.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("le;c)rk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("3.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("LoPNrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("4.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("vuq'kklu@ drZO;fu\"Brk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("5.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lg;ksx dh Hkkouk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		


			pdfPCellHoriAlign.setPhrase(new Phrase("6.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("Ik;kZoj.k ds izfr laosnu'khyrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("7.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("usr`Ro dh {kerk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("8.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lR;okfnrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("9.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("bZekunkjh",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("10.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("vfHko`fRr",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		
				
			return table1;
			
		}		
		public  PdfPTable marksSheetPage2Table4(String[][] grade){
			float [] cellFloat = new float []
			                        {3.5f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
//									{0.5f,3f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
			PdfPTable table1 = new PdfPTable(cellFloat);
			//table1.setTotalWidth(10f);
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCell.setPhrase(new Phrase("dqy f'k{k.k fnol",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCell.setPhrase(new Phrase("fo|kFkhZ mifLFkfr",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCell.setPhrase(new Phrase("gLrk{kj d{kk?;kid",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCell.setPhrase(new Phrase("gLrk{kj vfHkHkkod",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			
			return table1;
			
		}
		
	// ************************************************** Page 4 ********************************************
		
		
		public  PdfPTable marksSheetPage4Table1(String[][] grade){
			float [] cellFloat = new float []
			                        {0.5f,3.0f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.8f,0.6f,0.9f};
			PdfPTable table1 = new PdfPTable(cellFloat);

			PdfPCell pdfPCellHoriAlignBC = new PdfPCell();
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCellBC = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellHoriAlignBC.setBackgroundColor (new Color (238,238,224));//238,238,224 //245,245,245
			pdfPCellHoriAlignBC.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellBC.setBackgroundColor (new Color (205,201,201));//238,238,224//205-201-201 //245,245,245 //220-220-220
			pdfPCellBC.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPTable table0 = new PdfPTable(1);
			pdfPCellBC.setPhrase(new Phrase("'kSf{kd {kS=ks dk ewY;kadu ¼xszM½",fontDev100)); 			table0.addCell(pdfPCellBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fo\"k;",fontDev100));		table0.addCell(pdfPCellHoriAlignBC);
					
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Ø-",fontDev100)); 			table1.addCell(pdfPCellHoriAlignBC);
			table1.addCell(table0);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vizsy",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);	
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tqykbZ",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vxLr",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("flrEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vDVqEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("v}Zokf\"kZd eqY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fnlEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tuojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Qjojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ewY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("izkstsDV dk;Z",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ifj.kke",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlign.setPhrase(new Phrase("1.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("izFke Hkk\"kk¼fgUnh½",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[0][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("2.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("f}rh; Hkk\"kk¼vaxzsth½",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[1][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("3.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("r`rh; Hkk\"kk¼laLd`r½",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[2][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("4.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("xf.kr",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[3][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("5.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("foKku",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[4][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		
			
			pdfPCellHoriAlign.setPhrase(new Phrase("6.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lkekftd foKku",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[5][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		

			pdfPCellHoriAlign.setPhrase(new Phrase("7.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("vfrfjDr fo\"k;",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[6][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		
			
			return table1;
			
		}

		public  PdfPTable marksSheetPage4Table2(String[][] grade){
			float [] cellFloat = new float []
					                        {0.5f,3.0f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.8f,0.6f,0.9f};
			PdfPTable table1 = new PdfPTable(cellFloat);

			PdfPCell pdfPCellHoriAlignBC = new PdfPCell();
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellHoriAlignBC.setBackgroundColor (new Color (238,238,224));//238,238,224 //245,245,245
			pdfPCellHoriAlignBC.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell pdfPCellBC = new PdfPCell();
			pdfPCellBC.setBackgroundColor (new Color (205,201,201));//238,238,224//205-201-201 //245,245,245 //220-220-220
			pdfPCellBC.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPTable table0 = new PdfPTable(1);
			pdfPCellBC.setPhrase(new Phrase("lg'kSf{kd {kS=ks dk ewY;kadu ¼xszM½",fontDev100)); 			table0.addCell(pdfPCellBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("{kS=",fontDev100));		table0.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlignBC.setPhrase(new Phrase("Ø-",fontDev100)); 			table1.addCell(pdfPCellHoriAlignBC);
			table1.addCell(table0);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vizsy",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);	
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tqykbZ",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vxLr",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("flrEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vDVqEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("v}Zokf\"kZd eqY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fnlEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tuojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Qjojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setColspan (2);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ewY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setColspan (1);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ifj.kke",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlign.setPhrase(new Phrase("1.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lkfgfR;d",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[7][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("2.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lkaLd`frd",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[8][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("3.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("oSKkfud",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[9][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("4.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("l`tukRed",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[10][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("5.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("[ksydwy];ksx]LdkmV@jsMdzkl",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[11][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		
			
			return table1;
			
		}
		public  PdfPTable marksSheetPage4Table3(String[][] grade){
			float [] cellFloat = new float []
					                        {0.5f,3.0f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.8f,0.6f,0.9f};
			PdfPTable table1 = new PdfPTable(cellFloat);

			PdfPCell pdfPCellHoriAlignBC = new PdfPCell();
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCellHoriAlignBC.setBackgroundColor (new Color (238,238,224));//238,238,224 //245,245,245
			pdfPCellHoriAlignBC.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			PdfPCell pdfPCellBC = new PdfPCell();
			pdfPCellBC.setBackgroundColor (new Color (205,201,201));//238,238,224//205-201-201 //245,245,245 //220-220-220
			pdfPCellBC.setHorizontalAlignment(Element.ALIGN_CENTER);

			PdfPTable table0 = new PdfPTable(1);
			pdfPCellBC.setPhrase(new Phrase("O;fDrxr&lkekftd xq.kks dk eqY;kadu¼xzsM½",fontDev100)); 			table0.addCell(pdfPCellBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("xq.k",fontDev100));		table0.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlignBC.setPhrase(new Phrase("Ø-",fontDev100)); 			table1.addCell(pdfPCellHoriAlignBC);
//			pdfPCellHoriAlignBC.setPhrase(new Phrase("xq.k",fontDev100));		table1.addCell(pdfPCellHoriAlignBC);
			table1.addCell(table0);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vizsy",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);	
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tqykbZ",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vxLr",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("flrEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("vDVqEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("v}Zokf\"kZd eqY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("fnlEcj",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("tuojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("Qjojh",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setColspan (2);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ewY;kadu",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);
			pdfPCellHoriAlignBC.setColspan (1);
			pdfPCellHoriAlignBC.setPhrase(new Phrase("okf\"kZd ifj.kke",fontDev100));	table1.addCell(pdfPCellHoriAlignBC);

			pdfPCellHoriAlign.setPhrase(new Phrase("1.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("fu;ferrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[12][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("2.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("le;c)rk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[13][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("3.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("LoPNrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[14][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("4.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("vuq'kklu@ drZO;fu\"Brk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[15][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("5.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lg;ksx dh Hkkouk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[16][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		


			pdfPCellHoriAlign.setPhrase(new Phrase("6.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("Ik;kZoj.k ds izfr laosnu'khyrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[17][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("7.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("usr`Ro dh {kerk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[18][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("8.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("lR;okfnrk",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[19][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("9.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("bZekunkjh",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[20][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCellHoriAlign.setPhrase(new Phrase("10.",fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCell.setPhrase(new Phrase("vfHko`fRr",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[21][11],fontArial));	table1.addCell(pdfPCellHoriAlign);		
				
			return table1;
			
		}	
		public  PdfPTable marksSheetPage4Table4(String[][] grade){
			float [] cellFloat = new float []
					                        {3.5f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.9f,0.8f,0.6f,0.9f};
//									{0.5f,3f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
			PdfPTable table1 = new PdfPTable(cellFloat);
			//table1.setTotalWidth(10f);
			PdfPCell pdfPCellHoriAlign = new PdfPCell();
			PdfPCell pdfPCell = new PdfPCell();
			
			pdfPCellHoriAlign.setHorizontalAlignment(Element.ALIGN_CENTER);
			
			pdfPCell.setPhrase(new Phrase("dqy f'k{k.k fnol",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[22][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCell.setPhrase(new Phrase("fo|kFkhZ mifLFkfr",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[23][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCell.setPhrase(new Phrase("gLrk{kj d{kk?;kid",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[24][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			

			pdfPCell.setPhrase(new Phrase("gLrk{kj vfHkHkkod",fontDev100));	table1.addCell(pdfPCell);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][0],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][1],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][2],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][3],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][4],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][5],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][6],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][7],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][8],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (2);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][9],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setColspan (1);
//			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][10],fontArial));	table1.addCell(pdfPCellHoriAlign);
			pdfPCellHoriAlign.setPhrase(new Phrase(grade[25][11],fontArial));	table1.addCell(pdfPCellHoriAlign);
			
			return table1;
			
		}
		
	
}
