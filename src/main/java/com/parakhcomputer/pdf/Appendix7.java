package com.parakhcomputer.pdf;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.parakhcomputer.util.pdf.AppUtilityPdf;
import com.parakhcomputer.web.dao.CasteDao;
import com.parakhcomputer.web.dao.PersonDao;
import com.parakhcomputer.web.dao.StudentMarksDao;
import com.parakhcomputer.web.model.Person;
import com.parakhcomputer.web.model.School;

public class Appendix7 extends AppUtilityPdf {
	
	//************ Input from user 
	String block = "";
	String district = "";
	String assemblyId= "";
	String assemblyName = "";		
	String publicEducationCenter = "";
	String panchayatMunicipal = "";
	String villageWard = "";
	String basahat = "";
	String schoolLevel = "";
	String schoolName = "";		
	String codeDISE = "";		
	String totalMarks ="";
	String totalSchoolDays ="";
	
	public final int MAX_ROW = 150;
	String[][] appendix7 = new String[MAX_ROW][52];
	
	String[] appendix8 = new String[12];

	
	
	public void createSummary(int schoolId, int class_, String[] appendix8, String[][] appendix7, StudentMarksDao studentMarksDao){
		appendix8[0] = ""+ studentMarksDao.studentRegistered(schoolId, class_);
		appendix8[1] = ""+ studentMarksDao.studentAppeared(schoolId, class_);
		
			int aGrade = 0;
			int bGrade = 0;
			int cGrade = 0;
			int dGrade = 0;
			int gradeIndex = 0;
			if(class_ >= 1 && class_ <=5){
				gradeIndex = 32;
			}else{
				gradeIndex = 48;
			}
			for(int i=0; i<MAX_ROW; i++){
				if(null != appendix7[i][gradeIndex] && appendix7[i][gradeIndex].equals("A")){
					aGrade = aGrade + 1;
				}else if(null != appendix7[i][gradeIndex] && appendix7[i][gradeIndex].equals("B")){
					bGrade = bGrade + 1;
				}else if(null != appendix7[i][gradeIndex] && appendix7[i][gradeIndex].equals("C")){
					cGrade = cGrade + 1;
				}else if(null != appendix7[i][gradeIndex] && appendix7[i][gradeIndex].equals("D")){
					dGrade = dGrade + 1;
				}
			}
			appendix8[2] = ""+aGrade;
			appendix8[3] = ""+bGrade;
			appendix8[4] = ""+cGrade;
			appendix8[5] = ""+dGrade;
			
			int eGrade = 0;
			
			if(class_ >= 1 && class_ <=5){
				eGrade = 0;
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][11] && (findGrade(230, Double.parseDouble(appendix7[i][11]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[6] = ""+eGrade;
		
				eGrade = 0;		
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][12] && (findGrade(230, Double.parseDouble(appendix7[i][12]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[7] = ""+eGrade;
		
				eGrade = 0;		
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][13] && (findGrade(230, Double.parseDouble(appendix7[i][13]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[8] = ""+eGrade;
				if(class_==1 ||class_==2){
					appendix8[9] = "-";
				}else{
					eGrade = 0;		
					for(int i=0; i<MAX_ROW; i++){
						if(null != appendix7[i][14] && (findGrade(230, Double.parseDouble(appendix7[i][14]))).equals("E")){
							eGrade = eGrade +1;
						}
					}
					appendix8[9] = ""+eGrade;
				}
			}else {
				eGrade = 0;
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][13] && (findGrade(250, Double.parseDouble(appendix7[i][13]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[6] = ""+eGrade;
		
				eGrade = 0;		
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][16] && (findGrade(250, Double.parseDouble(appendix7[i][16]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[7] = ""+eGrade;
		
				eGrade = 0;		
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][19] && (findGrade(250, Double.parseDouble(appendix7[i][19]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[8] = ""+eGrade;
		
				eGrade = 0;		
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][22] && (findGrade(250, Double.parseDouble(appendix7[i][22]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[9] = ""+eGrade;

				eGrade = 0;		
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][25] && (findGrade(250, Double.parseDouble(appendix7[i][25]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[10] = ""+eGrade;

				eGrade = 0;		
				for(int i=0; i<MAX_ROW; i++){
					if(null != appendix7[i][28] && (findGrade(250, Double.parseDouble(appendix7[i][28]))).equals("E")){
						eGrade = eGrade +1;
					}
				}
				appendix8[11] = ""+eGrade;
			}
	}
	
	public String anuualScore(int class_, int index, String[][] appendix7){
		double sum = 0;
		if(class_ >= 1 && class_ <=5){
			for(int i = 11; i<=30; i++){
				sum = sum + Double.parseDouble(appendix7[index][i]);
			}			
		}else{
			for(int i = 13; i<=31; ){
				sum = sum + Double.parseDouble(appendix7[index][i]);
				i = i+3;
			}			
			for(int i = 32; i<=46; i++){
				sum = sum + Double.parseDouble(appendix7[index][i]);
			}			
		}
		return ""+sum;
	}
	
	public void createAppendix7(int class_, School school, PersonDao personDao, StudentMarksDao studentMarksDao, CasteDao casteDao){
		int schoolId = school.getSchoolId();
		block = "" + school.getBlock();
		district = "" + school.getDistrict();
		assemblyId= "" + school.getAssemblyId();
		assemblyName = "" + school.getAssemblyName() ;		
		publicEducationCenter = "" + school.getPublicEducationCenter();
		panchayatMunicipal = "" + school.getPanchayatMunicipal();
		villageWard = "" + school.getVillageWard();
		basahat = "" + school.getBasahat();
		schoolLevel = "" + school.getLevel();
		schoolName = "" + school.getName();		
		codeDISE = "" + school.getCode();
		totalMarks = ""+ findGradeBand(class_);
//		classFromToTo = "" + ;
		
		Collection<Person> persons = personDao.findPersonsBySchoolIdAndClass(schoolId, class_);
		int i=0;
	   	 Calendar calendar = new GregorianCalendar();
		for(Person person: persons){
			calendar.setTime(person.getDoB()==null?new java.util.Date():person.getDoB());
	    				
			appendix7[i][0]=""+person.getPersonId();			
			appendix7[i][1]=""+person.getSrId();
			appendix7[i][2]=""+person.getRollId();
			appendix7[i][3]=""+person.getScholarId();
			appendix7[i][4]=""+person.getFirstName();
			appendix7[i][5]=""+person.getMotherFirstName();
			appendix7[i][6]=""+person.getFatherFirstName();
			appendix7[i][7]=""+calendar.get(Calendar.DATE);
			appendix7[i][8]=""+(calendar.get(Calendar.MONTH)+1);
			appendix7[i][9]=""+calendar.get(Calendar.YEAR);
			appendix7[i][10]=""+casteDao.findCasteById(person.getCasteId()).getName();

			i++;
			
		}
		
		
		Object[] row;
		List totalMarksPerSubject;
		if(class_ >= 1 && class_ <=5){
			totalMarksPerSubject = studentMarksDao.finalTotalMarksPerSubject(schoolId, class_);
		}else{
			totalMarksPerSubject = studentMarksDao.finalTotalMarksPerSubjectPlusProject(schoolId, class_);
		}

	      Iterator iterator=totalMarksPerSubject.iterator();
	      boolean set = false;
	      while(iterator.hasNext()){
	    	  int index = 0;
	    	  row = (Object[]) iterator.next();
	    	  set = false;
	    	  for(int x = 0 ; x<MAX_ROW; x++){
	    		  if(null != appendix7[x][0] && ((appendix7[x][0]).trim()).equals((""+row[0]).trim())){	//match person id (appendix7[x][0])
	    			  index = x;
	    			  set = true;
	    			  break;
	    		  }
	    	  }
	    	  
    	  if(set){
	  		if(class_ >= 1 && class_ <=5){
	  	      //row[0] = person_ID, 
	  	      //row[1] = Subject_ID
	  	      //row[2] = obtain
	    		  for(int col = 11; col <=30; col++){
			    	  appendix7[index][col]= ""+row[2];
			    	  row = (Object[]) iterator.next();
	    		  }		    	  
		    	  totalSchoolDays = ""+(int)Double.parseDouble(""+row[2]);
		    	  row = (Object[]) iterator.next();
		    	  appendix7[index][33]= ""+row[2];
		    	  
		    	  appendix7[index][31]= anuualScore(class_, index, appendix7);
		    	  appendix7[index][32]= ""+ findGrade(findGradeBand(class_), Double.parseDouble(appendix7[index][31]));
	        
			}else{
			      //row[0] = person_ID, 
			      //row[1] = Subject_ID
			      //row[2] = obtain except project
			      //row[3] = obtain in project
			      //row[4] = total obtain
	    		  for(int col = 11; col <=31; ){
			    	  appendix7[index][col]= ""+row[2];
			    	  col++;
			    	  appendix7[index][col]= ""+row[3];
			    	  col++;
			    	  appendix7[index][col]= ""+row[4];
			    	  col++;
			    	  row = (Object[]) iterator.next();
	    		  }		    	  
	    		  for(int col = 32; col <=46; col++){
			    	  appendix7[index][col]= ""+row[2];
			    	  row = (Object[]) iterator.next();
	    		  }		    	  
		    	  totalSchoolDays = ""+(int)Double.parseDouble(""+row[2]);
		    	  row = (Object[]) iterator.next();
		    	  appendix7[index][49]= ""+row[2];
		    	  
		    	  appendix7[index][47]= anuualScore(class_, index, appendix7);
		    	  appendix7[index][48]= ""+ findGrade(findGradeBand(class_), Double.parseDouble(appendix7[index][47]));
			}
    	  }// if set

	      }//end while
	      
		createSummary(schoolId, class_, appendix8, appendix7, studentMarksDao);
		
//		replaceZeroWithAbsence(appendix7, class_);
		try{
			appendix7(schoolId, class_);			
		}catch(Exception e){
			System.out.println("inside Appendix 7");
			e.printStackTrace();
		}
	}

	public  void replaceZeroWithAbsence(String[][] appendix7, int classId){
		if(classId >= 1 && classId <=5){
	    	  for(int index = 0 ; index<MAX_ROW; index++){
	    		  for(int col = 11; col <=31; ){
			    	  if(appendix7[index][col].equals("0.0")){
			    		  appendix7[index][col] = "AB";
			    	  }	    		  
	    		  }
	    	  }	
		}else{
	    	  for(int index = 0 ; index<MAX_ROW; index++){
	    		  for(int col = 11; col <=47; ){
			    	  if(appendix7[index][col].equals("0.0")){
			    		  appendix7[index][col] = "AB";
			    	  }	    		  
	    		  }
	    	  }				
		}
	}
	public  void appendix7(int schoolId, int classId) throws Exception{
		util(); 
		String fileName = "Appendix7";
		if(classId >= 1 && classId <=5){
			fileName  = schoolId + "_" + classId + "_" + fileName+"a.pdf";		
		}else{
			fileName  = schoolId + "_" + classId + "_" + fileName+"b.pdf";		
		}
		Document document = new AppUtilityPdf().createPdfDocumentLegalLandscape(fileName);

		
		float [] cellFloat = null;
		PdfPCell pdfPCell = null;
		
		
		
		PdfPTable table0 = new PdfPTable(1);
		table0.setSpacingAfter(2f);
//		table0.setSpacingBefore(2f);
		table0.setWidthPercentage(100);	
		pdfPCell = new PdfPCell();
		pdfPCell.setBorderWidth(0);		
		
		pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);						
		if(classId >= 1 && classId <=5){
			pdfPCell.setPhrase(new Phrase(appendix7a,fontDev010)); 			table0.addCell(pdfPCell);
			pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//Font f1 = new Font(bsaeFontDev100, 25);
//			f1.setStyle(Font.BOLD);
			fontDev010s13.setStyle(Font.BOLD);
			pdfPCell.setPhrase(new Phrase(at1a,fontDev010s13)); 			table0.addCell(pdfPCell);
			fontDev010s13.setStyle(Font.NORMAL);
		}else{
			pdfPCell.setPhrase(new Phrase(appendix7b,fontDev010)); 			table0.addCell(pdfPCell);
			pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			fontDev010s13.setStyle(Font.BOLD);
			pdfPCell.setPhrase(new Phrase(at1b,fontDev010s13)); 			table0.addCell(pdfPCell);
			fontDev010s13.setStyle(Font.NORMAL);
		}
		
		document.add(table0);			
		
		pdfPCell = new PdfPCell();
		
		cellFloat = new float []             {1f,1f,1f,1f,1f,1f};
		PdfPTable table1 = new PdfPTable(cellFloat);
		table1.setSpacingAfter(2f);
	//	table1.setSpacingBefore(2f);
		table1.setWidthPercentage(100);		
		pdfPCell = new PdfPCell();


		pdfPCell.setPhrase(new Phrase(at2,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(district,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(at7,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(assemblyName,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(at8,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(assemblyId,fontArial)); 			table1.addCell(pdfPCell);
		
		pdfPCell.setPhrase(new Phrase(at3,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(block,fontDev100)); 			table1.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(at5,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(villageWard,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(at9,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(panchayatMunicipal,fontDev100)); 			table1.addCell(pdfPCell);
		
		
		pdfPCell.setPhrase(new Phrase(at6,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(schoolLevel,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(at11,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(schoolName,fontDev100)); 			table1.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(at12,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(codeDISE,fontArial)); 			table1.addCell(pdfPCell);

		pdfPCell.setPhrase(new Phrase(at4,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(publicEducationCenter,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(at10,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase(basahat,fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase("",fontDev100)); 			table1.addCell(pdfPCell);
		pdfPCell.setPhrase(new Phrase("",fontDev100)); 			table1.addCell(pdfPCell);
		

		document.add(table1);
		
		document.add(new Paragraph());
	
		
	
		
		if(classId >= 1 && classId <=5){
			cellFloat = new float []             {1.8f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};//11 cells
		}else{
			cellFloat = new float []             {1.8f,1f,1f,1f,1f,1f,1f,0.8f,0.8f,0.8f,0.8f,0.8f,2f};//13 cells
		}
		
		PdfPTable table2a = new PdfPTable(cellFloat);
		table2a.setSpacingAfter(2f);
		table2a.setSpacingBefore(2f);
		table2a.setWidthPercentage(100);	
		
		pdfPCell = new PdfPCell();
//		pdfPCell.setRowspan(2);
		pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		pdfPCell.setPhrase(new Phrase(at17+" % "+getClassNameInHindi(classId),fontDev010)); 			table2a.addCell(pdfPCell);		
//		pdfPCell.setPhrase(new Phrase(at18,fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(at19,fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(at20,fontDev100)); 			table2a.addCell(pdfPCell);		

		pdfPCell.setPhrase(new Phrase(at21,fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(at22,fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(at23,fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(at24,fontDev100)); 			table2a.addCell(pdfPCell);		
		
		if(classId >= 1 && classId <=5){
			pdfPCell.setColspan(4);
		}else{
			pdfPCell.setColspan(6);
		}
		pdfPCell.setPhrase(new Phrase(at25,fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setColspan(1);


		pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2a.addCell(pdfPCell);		
		pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2a.addCell(pdfPCell);		
		
		if(classId >= 1 && classId <=5){
			pdfPCell.setPhrase(new Phrase(at26,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at27,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at28,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at29,fontDev100)); 			table2a.addCell(pdfPCell);		
		}else{
			pdfPCell.setPhrase(new Phrase(at26,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at27,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at36,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at28,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at37,fontDev100)); 			table2a.addCell(pdfPCell);		
			pdfPCell.setPhrase(new Phrase(at38,fontDev100)); 			table2a.addCell(pdfPCell);	
					
		}

		pdfPCell.setPhrase(new Phrase(at35,fontDev100)); 			table2a.addCell(pdfPCell);	
		if(classId >= 1 && classId <=5){
			for(int index=0;index<=9;index++){
				pdfPCell.setPhrase(new Phrase(appendix8[index],fontArial)); 			table2a.addCell(pdfPCell);						
			}		
		}else{
			for(int index=0;index<=11;index++){
				pdfPCell.setPhrase(new Phrase(appendix8[index],fontArial)); 			table2a.addCell(pdfPCell);						
			}			
		}
		
		
//-----------------------------------------------------------------------------------------------------------		

		cellFloat = new float []             {1f,1f,1f,1f,1f,1f};
		PdfPTable table2b = new PdfPTable(cellFloat);
		table2b.setWidthPercentage(100);		
		pdfPCell = new PdfPCell();
	
		
		
		
		cellFloat = new float []             {3f,1f,2f};
		PdfPTable table2 = new PdfPTable(cellFloat);
		table2.setSpacingAfter(2f);
		table2.setSpacingBefore(2f);
		table2.setWidthPercentage(100);	
		
		pdfPCell = new PdfPCell();
		pdfPCell.setBorderWidth(0);
		
		
		pdfPCell = new PdfPCell();
		pdfPCell.setBorderWidth(0);
		pdfPCell.addElement(table2a);
		table2.addCell(pdfPCell);
		
		pdfPCell = new PdfPCell();
		pdfPCell.setBorderWidth(0);
		pdfPCell.addElement(table2b);
		table2.addCell(pdfPCell);
		
						
		pdfPCell.setPhrase(new Phrase(nirdesh,fontDev100)); 			table2.addCell(pdfPCell);
		
		document.add(table2);


		if(classId >= 1 && classId <=5){
		
			cellFloat = new float []             
			                       {1f,1.5f,1.5f,3.2f,3f,3f,1f,1f,1f,1f,1f,
									1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,
									1f,1f,1f,1f,1f,1f,1f,1f,1.2f,0.7f,1.5f};
		}else{
				cellFloat = new float []             
				                       {0.7f,1.2f,1.2f,3.2f,2.5f,2.5f,0.7f,0.7f,1.1f,1f,1f,
										1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,
										1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,
										1f,1f,1f,1f,1f,
										1f,1f,1f,1f,1f,1f,1f,1f,1.3f,0.8f,1.5f};
				
		}
			PdfPTable table3 = new PdfPTable(cellFloat);
			table3.setWidthPercentage(100);		
			pdfPCell = new PdfPCell();	
			pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pdfPCell.setColspan (10);		
			pdfPCell.setPhrase(new Phrase(app7aT40,fontDev100)); 			table3.addCell(pdfPCell);	
			
		if(classId >= 1 && classId <=5){			
			//Appendix 7 A 
			pdfPCell.setColspan (5);
		}else{
			//Appendix 7 A 
			pdfPCell.setColspan (21);			
		}
			pdfPCell.setPhrase(new Phrase(app7aT41,fontDev100)); 			table3.addCell(pdfPCell);
			
			pdfPCell.setColspan (5);
			pdfPCell.setPhrase(new Phrase(app7aT42,fontDev100)); 			table3.addCell(pdfPCell);	
			pdfPCell.setColspan (10);
			pdfPCell.setPhrase(new Phrase(app7aT43,fontDev100)); 			table3.addCell(pdfPCell);	
			pdfPCell.setColspan (2);
			pdfPCell.setPhrase(new Phrase(app7aT44 +"% "+totalMarks,fontDev010)); 			table3.addCell(pdfPCell);	
			pdfPCell.setColspan (1);
			pdfPCell.setPhrase(new Phrase(app7aT45,fontDev010)); 			table3.addCell(pdfPCell);	
		
	//		pdfPCell.setPhrase(new Phrase(app7aT46,fontDev100)); 			table3.addCell(pdfPCell);	
	//		pdfPCell.setPhrase(new Phrase(app7aT47,fontDev100)); 			table3.addCell(pdfPCell);	
	//		pdfPCell.setPhrase(new Phrase(app7aT49,fontDev100)); 			table3.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(app7aT50,fontDev010s9)); 			table3.addCell(pdfPCell);	
			pdfPCell.setPhrase(new Phrase(app7aT51,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT52,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT53,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT54,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT55,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT56,fontArials6)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT57,fontArials6)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT58,fontArials6)); 			table3.addCell(pdfPCell);
			
			pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			pdfPCell.setRotation(90);
			pdfPCell.setFixedHeight(80f);
			pdfPCell.setPhrase(new Phrase(app7aT48,fontDev010s9));   			table3.addCell(pdfPCell);
			
			if(classId >= 1 && classId <=5){
				//appendix 7 A
				pdfPCell.setPhrase(new Phrase(app7aT59,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT60,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT61,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT62,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT63,fontDev010s9)); 			table3.addCell(pdfPCell);
			}else{
				//appendix 7 B
				pdfPCell.setPhrase(new Phrase(app7aT59,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT89,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT90,fontDev010s9)); 			table3.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(app7aT60,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT89,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT90,fontDev010s9)); 			table3.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(app7aT84,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT89,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT90,fontDev010s9)); 			table3.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(app7aT85,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT89,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT90,fontDev010s9)); 			table3.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(app7aT86,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT89,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT90,fontDev010s9)); 			table3.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(app7aT87,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT89,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT90,fontDev010s9)); 			table3.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase(app7aT88,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT89,fontDev010s9)); 			table3.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(app7aT90,fontDev010s9)); 			table3.addCell(pdfPCell);
				
			}
			
			pdfPCell.setPhrase(new Phrase(app7aT64,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT65,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT66,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT67,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT68,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT69,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT70,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT71,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT72,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT73,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT74,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT75,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT76,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT77,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT78,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT79,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(app7aT80,fontDev010s9)); 			table3.addCell(pdfPCell);
			pdfPCell.setPhrase(new Phrase(totalSchoolDays+"&"+app7aT81,fontDev010)); 			table3.addCell(pdfPCell);
			pdfPCell.setRotation(0);
			pdfPCell.setFixedHeight(12f);
			//pdfPCell.setf
			
	

		addRecordAppendix7(classId, appendix7, table3, pdfPCell);
		
		document.add(table3);

		
		document.add (Chunk.NEWLINE);
		
		//Chunk tab = new Chunk(new VerticalPositionMark(), 50f, false);
		//document.add(table2);
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("d{kk/;kid ds gLrk{kj", fontDev100s12));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("                          ", fontDev010));			 
		   document.add (new Chunk ("iz/kkuk/;kid ds gLrk{kj o ineqnzk", fontDev100s12));
		   

		   document.add (Chunk.NEWLINE);
		   document.add (Chunk.NEWLINE);
		 //copyright
//		   PdfPTable table = new PdfPTable(1);
//		   PdfPCell pdfPCells[] = table.getRow(table.getRows().size() - 1).getCells();
//		   for (PdfPCell pdfPCell1 : pdfPCells) {
//		       pdfPCell1.setBorder(PdfPCell.BOTTOM);
//		   }
		   
			PdfPTable tableRightPage6 = new PdfPTable(1);
			tableRightPage6.setWidthPercentage(20f);
			pdfPCell = new PdfPCell();
			pdfPCell.setBorderWidth(0);
			pdfPCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
			pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);

			Image image2 = Image.getInstance(getRealPath()+"/images/parakhComputer.gif");
			image2.setAlignment(Element.ALIGN_CENTER);
			pdfPCell.addElement(image2);
			tableRightPage6.addCell(pdfPCell);


			
			PdfPTable tableCopyRight = new PdfPTable(1);
			pdfPCell = new PdfPCell();
			pdfPCell.setFixedHeight(20f);
			pdfPCell.setBorderWidth(0);
			pdfPCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
			pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);

			pdfPCell.addElement(tableRightPage6);
			tableCopyRight.addCell(pdfPCell);	
	        
			document.add(tableCopyRight);
		   
		document.close();
	}		
	
	public  void addRecordAppendix7(int classId, String[][] appendix, PdfPTable table, PdfPCell pdfPCell ){
		//int personId = 0;
		for (int i=-1; i <MAX_ROW; i++){ //total row do while appendix[i][0] is null
			int col =0;
			if(classId >= 1 && classId <=5){
				col = 34;
			}else{
				col = 50;
			}
			if(i!=-1){
				pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
				//personId = Integer.parseInt(appendix[i][0]);
				if(null==appendix[i][0] ||appendix[i][0].equals("")){
					break;
				}
			}else{
				pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			}
			for (int j=1; j <col;j++){
				if(i==-1){
					pdfPCell.setPhrase(new Phrase(""+j,fontArials6)); 
					table.addCell(pdfPCell);
				}else{
					if((j>=4 && j<=6)||j==10){
						pdfPCell.setPhrase(new Phrase(appendix[i][j],fontDev100s8)); 								
					}else{
						pdfPCell.setPhrase(new Phrase(appendix[i][j],fontArials7)); 								
					}
					table.addCell(pdfPCell);
				}
			}
		}
	}
				
}
