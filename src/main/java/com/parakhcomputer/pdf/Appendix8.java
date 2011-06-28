package com.parakhcomputer.pdf;


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
import com.parakhcomputer.util.AppConstant;
import com.parakhcomputer.util.pdf.AppUtilityPdf;
import com.parakhcomputer.web.dao.PersonDao;
import com.parakhcomputer.web.dao.StudentMarksDao;
import com.parakhcomputer.web.model.School;

public class Appendix8 extends AppUtilityPdf implements AppConstant{

//	String classFromToTo = "";
	String[][] appendix8 = new String[26][12];
	
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

	
    public String[][] appendix8Matrix(int schoolId, StudentMarksDao studentMarksDao, String appendix8Type){
    	String[][] appendix8 = new String[25][12];
    	
    	
//		List totalStudentPerSchool = studentMarksDao.finalTotalStudentPerSchool(schoolId, appendix8Type);
//
//	      Iterator iterator=totalStudentPerSchool.iterator();
//
//    	  Object[] row;
//    	  int index = 0;
//	      while(iterator.hasNext()){
//	    	  	row = (Object[]) iterator.next();	    	  
//	    	  	
//	    	  	appendix8[index][0]= ""+row[1];
//	    	  	appendix8[index][1]= ""+row[6];	    	  	
//
//	    	  	index++;
//
//	    	  	appendix8[index][0]= ""+row[2];
//	    	  	appendix8[index][1]= ""+row[7];
//	    	  	
//	    	  	index++;
//
//	    	  	appendix8[index][0]= ""+row[3];
//	    	  	appendix8[index][1]= ""+row[8];
//	    	  	
//	    	  	index++;
//
//	    	  	appendix8[index][0]= ""+row[4];
//	    	  	appendix8[index][1]= ""+row[9];
//	    	  	
//	    	  	index++;
//
//	    	  	appendix8[index][0]= ""+row[5];
//	    	  	appendix8[index][1]= ""+row[10];
//	    	  	
//	    	  	index++;
//	      }
//	      

    	  Object[] row;
      	  int index = 0;
      	  int class_ = 0, classIndex = -1;

      	  List totalStudentPerSchool1 = studentMarksDao.finalTotalStudentPerSchool1(schoolId, appendix8Type);
	      Iterator iterator1=totalStudentPerSchool1.iterator();
	      while(iterator1.hasNext()){
	    	  	row = (Object[]) iterator1.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 0;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 0;
	    	  	}
//	    	  	System.out.println("finalTotalStudentPerSchool1 Student"+index+" : "+row[1]);
	    	  	appendix8[index][0]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool2 = studentMarksDao.finalTotalStudentPerSchool2(schoolId, appendix8Type);
	      Iterator iterator2=totalStudentPerSchool2.iterator();
	      while(iterator2.hasNext()){
	    	  	row = (Object[]) iterator2.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 1;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 1;
	    	  	}
	    	  	appendix8[index][0]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool3 = studentMarksDao.finalTotalStudentPerSchool3(schoolId, appendix8Type);
	      Iterator iterator3=totalStudentPerSchool3.iterator();
	      while(iterator3.hasNext()){
	    	  	row = (Object[]) iterator3.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 2;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 2;
	    	  	}
	    	  	appendix8[index][0]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool4 = studentMarksDao.finalTotalStudentPerSchool4(schoolId, appendix8Type);
	      Iterator iterator4=totalStudentPerSchool4.iterator();
	      while(iterator4.hasNext()){
	    	  	row = (Object[]) iterator4.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 3;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 3;
	    	  	}
	    	  	appendix8[index][0]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool5 = studentMarksDao.finalTotalStudentPerSchool5(schoolId, appendix8Type);
	      Iterator iterator5=totalStudentPerSchool5.iterator();
	      while(iterator5.hasNext()){
	    	  	row = (Object[]) iterator5.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 4;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 4;
	    	  	}
	    	  	appendix8[index][0]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool6 = studentMarksDao.finalTotalStudentPerSchool6(schoolId, appendix8Type);
	      Iterator iterator6=totalStudentPerSchool6.iterator();
	      while(iterator6.hasNext()){
	    	  	row = (Object[]) iterator6.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 0;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 0;
	    	  	}
	    	  	appendix8[index][1]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool7 = studentMarksDao.finalTotalStudentPerSchool7(schoolId, appendix8Type);
	      Iterator iterator7=totalStudentPerSchool7.iterator();
	      while(iterator7.hasNext()){
	    	  	row = (Object[]) iterator7.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 1;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 1;
	    	  	}
	    	  	appendix8[index][1]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool8 = studentMarksDao.finalTotalStudentPerSchool8(schoolId, appendix8Type);
	      Iterator iterator8=totalStudentPerSchool8.iterator();
	      while(iterator8.hasNext()){
	    	  	row = (Object[]) iterator8.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 2;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 2;
	    	  	}
	    	  	appendix8[index][1]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool9 = studentMarksDao.finalTotalStudentPerSchool9(schoolId, appendix8Type);
	      Iterator iterator9=totalStudentPerSchool9.iterator();
	      while(iterator9.hasNext()){
	    	  	row = (Object[]) iterator9.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 3;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 3;
	    	  	}
	    	  	appendix8[index][1]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }
	    	
      	  List totalStudentPerSchool10 = studentMarksDao.finalTotalStudentPerSchool10(schoolId, appendix8Type);
	      Iterator iterator10=totalStudentPerSchool10.iterator();
	      while(iterator10.hasNext()){
	    	  	row = (Object[]) iterator10.next();	    	  
	    	  	class_ = Integer.parseInt(""+row[0]);
	    	  	if(class_ >=1 && class_ <=5){
		    	  	index = ((class_ -1) * 5) + 4;
	    	  	}else{
		    	  	index = ((class_ -6) * 5) + 4;
	    	  	}
	    	  	appendix8[index][1]= (""+row[1]).equals("")?"-":(""+row[1]);
	      }

	      index = 0;

			/*
			 * class = 1 & 6 	gradeCountClass[0][][]
			 * class = 2 & 7 	gradeCountClass[1][][]
			 * class = 3 & 8 	gradeCountClass[2][][]
			 * class = 4     	gradeCountClass[3][][]
			 * class = 5     	gradeCountClass[4][][]
			 * 
			 * Gender =M		gradeCountClass[][0][]
			 * Gender =F		gradeCountClass[][1][]
			 * All Student		gradeCountClass[][3][]
			 * Caste =SC aaja	gradeCountClass[][4][]
			 * Caste =ST aajja	gradeCountClass[][5][]
			 * 
			 * Grade = A 		gradeCountClass[][][0]
			 * Grade = B 		gradeCountClass[][][1]
			 * Grade = C 		gradeCountClass[][][2]
			 * Grade = D 		gradeCountClass[][][3]
			 */
			int[][][] gradeCountClass ={
						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } },	//class 1	row1{A,B,C,D}, row2{A,B,C,D} ... row5{A,B,C,D}
						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } },	//class 2
						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } },	//class 3
						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } },	//class 4
						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } }		//class 5
//						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } },	//class 6
//						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } },	//class 7
//						{ { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 }, { 0,0,0,0 } }		//class 8
					};
			

			List totalMarksPerClassPerSchool = studentMarksDao.finalTotalMarksPerClassPerSchool(schoolId, appendix8Type);

		    Iterator iteratorTotalMarksPerClassPerSchool=totalMarksPerClassPerSchool.iterator();
		    
		    //a.class_,  a.casteId, a.gender, b.personId, sum(b.obtain)
		    
		    String grade="";
		    class_ = 0;
		    classIndex = -1;
		    int column = 0;
			while(iteratorTotalMarksPerClassPerSchool.hasNext()){
				row = (Object[]) iteratorTotalMarksPerClassPerSchool.next();
				class_ = Integer.parseInt(("")+row[0]);

				grade = findGrade(findGradeBand(class_), Double.parseDouble(""+row[4]));

				if(!grade.equals("E")){
					
					if(class_ >=1 && class_ <=5){
						classIndex = class_ -1;		//class = 1 to 5
					}else {
						classIndex = class_ -6;
					}
										
					if(grade.equals("A")){
						column = 0;				
					} else if(grade.equals("B")){
						column = 1;
					} else if(grade.equals("C")){
						column = 2;
					} else if(grade.equals("D")){
						column = 3;
					}
					gradeCountClass[classIndex][2][column] ++;
					if((""+row[2]).equals("M")){
						gradeCountClass[classIndex][0][column] ++;
					}else{
						gradeCountClass[classIndex][1][column] ++;
					}
					if((""+row[1]).equals("3")){ //SC
						gradeCountClass[classIndex][3][column] ++;
					}else if((""+row[1]).equals("2")){ //ST
						gradeCountClass[classIndex][4][column] ++;
					}										
				}

			}  //end while


//			int classInxPlus =0;
			int rMain =0, r1=0;//,r2,r3,r4,r5;
			for(int classInx = 0; classInx<=4; classInx++){
//				classInxPlus = classInx + 1;
				for(int r=0;r<=4; r++){

					if(classInx >=0 && classInx <=4){
						rMain = classInx * 5; 			//class = 1 to 5
					}else {
						rMain = (classInx -5) * 5;
					}
					r1 = rMain + r;

					appendix8[r1][2] = ""+(gradeCountClass[classInx][r][0]==0? "-":gradeCountClass[classInx][r][0]); //grade A	
					appendix8[r1][3] = ""+(gradeCountClass[classInx][r][1]==0? "-":gradeCountClass[classInx][r][1]); //grade B
					appendix8[r1][4] = ""+(gradeCountClass[classInx][r][2]==0? "-":gradeCountClass[classInx][r][2]); //grade C
					appendix8[r1][5] = ""+(gradeCountClass[classInx][r][3]==0? "-":gradeCountClass[classInx][r][3]); //grade D
				}
			
			}

			/*
			 * class = 1 & 6 	gradeECountPerSubject[0][][]
			 * class = 2 & 7 	gradeECountPerSubject[1][][]
			 * class = 3 & 8 	gradeECountPerSubject[2][][]
			 * class = 4     	gradeECountPerSubject[3][][]
			 * class = 5     	gradeECountPerSubject[4][][]
			 * 
			 * Gender =M		gradeECountPerSubject[][0][]
			 * Gender =F		gradeECountPerSubject[][1][]
			 * All Student		gradeECountPerSubject[][3][]
			 * Caste =SC aaja	gradeECountPerSubject[][4][]
			 * Caste =ST aajja	gradeECountPerSubject[][5][]
			 * 
			 * Subject = 1 & 24	gradeECountPerSubject[][][0]
			 * Subject = 2 & 25	gradeECountPerSubject[][][1]
			 * Subject = 3 & 26	gradeECountPerSubject[][][2]
			 * Subject = 4 & 27	gradeECountPerSubject[][][3]
			 * Subject =   & 28	gradeECountPerSubject[][][4]
			 * Subject =   & 29	gradeECountPerSubject[][][5]
			 * 
			 */
			int[][][] gradeECountPerSubject ={
						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } },
						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } },
						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } },
						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } },
						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } }
//						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } },
//						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } },
//						{ { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 }, { 0,0,0,0,0,0 } }	
					};
						
			List totalMarksPerSubjectPerClassPerSchool = studentMarksDao.finalTotalMarksPerSubjectPerClassPerSchool(schoolId, appendix8Type);

			iterator3=totalMarksPerSubjectPerClassPerSchool.iterator();
	   //a.class_,  a.casteId, a.gender, b.personId, b.subjectId, sum(b.obtain)
		    //String grade="";
		    //int class_ = 0, classIndex = -1;

			while(iterator3.hasNext()){
				row = (Object[]) iterator3.next();
				class_ = Integer.parseInt(("")+row[0]);
				
//					grade = findGrade(findGradeBand(class_), Double.parseDouble(""+row[5]));
					if(class_ >=1 && class_ <=5){
						grade = findGrade(230, Double.parseDouble(""+row[5]));
						classIndex = class_ -1;
					}else{
						grade = findGrade(250, Double.parseDouble(""+row[5]));
						classIndex = class_ -6;
					}				
					//Extra Subject(atirict vishay)
					if(grade.equals("E")&&!(Integer.parseInt(""+row[4])==5 || Integer.parseInt(""+row[4])==30)){
						
						if(!((class_==1 ||class_==2) && Integer.parseInt(""+row[4])==4)){//class 1-2 does not require Parayavaran and Extra(atirict Subject)

						
							if(Integer.parseInt(""+row[4])==1 || Integer.parseInt(""+row[4])==24 ){
								column = 0;
							} else	if(Integer.parseInt(""+row[4])==2 || Integer.parseInt(""+row[4])==25 ){
								column = 1;
							} else if(Integer.parseInt(""+row[4])==3 || Integer.parseInt(""+row[4])==26 ){
								column = 2;
							} else if(Integer.parseInt(""+row[4])==4 || Integer.parseInt(""+row[4])==27 ){
								column = 3;
							} else if(Integer.parseInt(""+row[4])==28 ){
								column = 4;
							} else if(Integer.parseInt(""+row[4])==29 ){
								column = 5;
							}
	
							gradeECountPerSubject[classIndex][2][column] ++;
							if((""+row[2]).equals("M")){
								gradeECountPerSubject[classIndex][0][column] ++;
							}else{
								gradeECountPerSubject[classIndex][1][column] ++;
							}
							if((""+row[1]).equals("3")){ //SC
								gradeECountPerSubject[classIndex][3][column] ++;
							}else if((""+row[1]).equals("2")){ //ST
								gradeECountPerSubject[classIndex][4][column] ++;
							}						
						}
					}							
			}// end while
			
			for(int classInx = 0; classInx<=4; classInx++){
				for(int r=0;r<=4; r++){

					if(classInx >=0 && classInx <=4){
						rMain = classInx * 5; 			//class = 1 to 5
					}else {
						rMain = (classInx -5) * 5;
					}
					r1 = rMain + r;
					
					appendix8[r1][6] = ""+(gradeECountPerSubject[classInx][r][0]==0? "-":gradeECountPerSubject[classInx][r][0]); //sub id 1 and 24
					appendix8[r1][7] = ""+(gradeECountPerSubject[classInx][r][1]==0? "-":gradeECountPerSubject[classInx][r][1]); //sub id 2 and 25
					appendix8[r1][8] = ""+(gradeECountPerSubject[classInx][r][2]==0? "-":gradeECountPerSubject[classInx][r][2]); //sub id 3 and 26
					appendix8[r1][9] = ""+(gradeECountPerSubject[classInx][r][3]==0? "-":gradeECountPerSubject[classInx][r][3]); //sub id 4 and 27
					appendix8[r1][10] = ""+(gradeECountPerSubject[classInx][r][4]==0? "-":gradeECountPerSubject[classInx][r][4]); //sub id 28
					appendix8[r1][11] = ""+(gradeECountPerSubject[classInx][r][5]==0? "-":gradeECountPerSubject[classInx][r][5]); //sub id 29
				}
			}
			
    	return appendix8;
    }
        	//TODO PersonDao personDao not in use
	public void createAppendix8(School school, PersonDao personDao, StudentMarksDao studentMarksDao, String appendix8Type){
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
		
		appendix8 = appendix8Matrix(schoolId, studentMarksDao, appendix8Type);
//		System.out.println("*************:"+appendix8[0][1]);
		int class_ = 0;
//		if(school.getLevel().equalsIgnoreCase("izkFkfed")){
		if(appendix8Type.equals("A")){
			class_ = 1;
		}else{
			class_ = 6;
		}
		try{
			appendix8(schoolId, class_);
		}catch(Exception e){
			
		}
	}
	

			public  void appendix8(int schoolId, int classId) throws Exception{
				util();
				Document document = null; 
				String fileName =schoolId +"_"+ "Appendix8";
				if(classId >= 1 && classId <=5){
					fileName  = fileName+"a.pdf";		
				}else{
					fileName  = fileName+"b.pdf";		
				}
				document = new AppUtilityPdf().createPdfDocumentA4Portrait(fileName);

		//************ Input from user 

				float [] cellFloat = null;
				PdfPCell pdfPCell = null;
				PdfPCell pdfPCellLeftAlign = null;
				Chunk chunk;
				
				
				PdfPTable table0 = new PdfPTable(1);
				table0.setSpacingAfter(2f);
//				table0.setSpacingBefore(2f);
				table0.setWidthPercentage(100);	
				pdfPCell = new PdfPCell();
				pdfPCell.setBorderWidth(0);		
				
				pdfPCell.setHorizontalAlignment(Element.ALIGN_RIGHT);						
				if(classId >= 1 && classId <=5){
					pdfPCell.setPhrase(new Phrase(appendix8a,fontDev010)); 			table0.addCell(pdfPCell);
					pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//					fontDev100.setStyle(Font.BOLD);
					pdfPCell.setPhrase(new Phrase(appendix8t1a,fontDev100)); 			table0.addCell(pdfPCell);
				}else{
					pdfPCell.setPhrase(new Phrase(appendix8b,fontDev010)); 			table0.addCell(pdfPCell);
					pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//					fontDev100.setStyle(Font.BOLD);
					pdfPCell.setPhrase(new Phrase(appendix8t1b,fontDev100)); 			table0.addCell(pdfPCell);
				}
				
				document.add(table0);			
				
				document.add(Chunk.NEWLINE);
				
				pdfPCell = new PdfPCell();
				
//				document.add(new Paragraph());
//				if(classId >= 1 && classId <=5){
//					chunk = new Chunk (appendix8a, fontDev100);			
//				}else{
//					chunk = new Chunk (appendix8b, fontDev100);			
//				}
//				document.add(chunk);
//				document.add(Chunk.NEWLINE);
//				
//				chunk = new Chunk (appendix8t1, fontDev100);
//				document.add(chunk);

	
				
				
				cellFloat = new float []             {1f,1f,1f,1f};
				PdfPTable table1 = new PdfPTable(cellFloat);
				table1.setWidthPercentage(100);		
				pdfPCell = new PdfPCell();

		//		fontDev100.setStyle(Font.NORMAL);
				pdfPCell.setPhrase(new Phrase(at2,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(district,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(at7,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(assemblyName,fontDev100)); 			table1.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(at3,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(block,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(at8,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(assemblyId,fontArial)); 			table1.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(at4,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(publicEducationCenter,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(at9,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(panchayatMunicipal,fontDev100)); 			table1.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(at5,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(villageWard,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(at10,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(basahat,fontDev100)); 			table1.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase(at6,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(schoolLevel,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(at11,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(schoolName,fontDev100)); 			table1.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase("",fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase("",fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(at12,fontDev100)); 			table1.addCell(pdfPCell);
				pdfPCell.setPhrase(new Phrase(codeDISE,fontArial)); 			table1.addCell(pdfPCell);
				
				document.add(table1);
				
				document.add(new Paragraph());
				
				chunk = new Chunk (at13,fontDev010);
				document.add(chunk);
//class from to to				
				if(classId >= 1 && classId <=5){
					chunk = new Chunk (at14, fontDev010);			
				}else{
					chunk = new Chunk (at14a, fontDev010);			
				}
				document.add(chunk);
				chunk = new Chunk (at15,fontDev010);
				document.add(chunk);
				
				document.add(Chunk.NEWLINE);
				chunk = new Chunk (at16,fontDev010);
				document.add(chunk);
				
				if(classId >= 1 && classId <=5){
					cellFloat = new float []             {0.8f,1.2f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
				}else{
					cellFloat = new float []             {0.8f,1.2f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f,1f};
				}
				PdfPTable table2 = new PdfPTable(cellFloat);
				table2.setWidthPercentage(100);		
				pdfPCell = new PdfPCell();
				pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
				pdfPCell.setPhrase(new Phrase(at17,fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(at18,fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(at19,fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(at20,fontDev100)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(at21,fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(at22,fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(at23,fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(at24,fontDev100)); 			table2.addCell(pdfPCell);		
				
				if(classId >= 1 && classId <=5){
					pdfPCell.setColspan(4);
				}else{
					pdfPCell.setColspan(6);
				}
				pdfPCell.setPhrase(new Phrase(at25,fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setColspan(1);

//				pdfPCell.setr(4);
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(" ",fontDev100)); 			table2.addCell(pdfPCell);
				
				if(classId >= 1 && classId <=5){
					pdfPCell.setPhrase(new Phrase(at26,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at27,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at28,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at29,fontDev100)); 			table2.addCell(pdfPCell);		
				}else{
					pdfPCell.setPhrase(new Phrase(at26,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at27,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at36,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at28,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at37,fontDev100)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(at38,fontDev100)); 			table2.addCell(pdfPCell);		
				}
				pdfPCellLeftAlign = new PdfPCell();
				if(classId >= 1 && classId <=5){
				pdfPCell.setPhrase(new Phrase("1",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][1],fontArial)); 			table2.addCell(pdfPCell);		
					System.out.println("appendix8[0][2]"+appendix8[0][2]);
				pdfPCell.setPhrase(new Phrase(appendix8[0][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[0][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[0][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[1][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[1][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[1][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[2][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[2][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[2][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[3][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[3][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[3][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[4][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[4][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[4][9],fontArial)); 			table2.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase("2",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[5][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[5][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[5][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[6][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[6][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[6][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[7][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[7][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[7][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[8][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[8][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[8][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[9][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[9][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[9][9],fontArial)); 			table2.addCell(pdfPCell);
				
				
				pdfPCell.setPhrase(new Phrase("3",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[10][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[10][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[10][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[11][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[11][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[11][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[12][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[12][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[12][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[13][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[13][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[13][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[14][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[14][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[14][9],fontArial)); 			table2.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase("4",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[15][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[15][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[15][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[16][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[16][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[16][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[17][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[17][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[17][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[18][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[18][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[18][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[19][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[19][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[19][9],fontArial)); 			table2.addCell(pdfPCell);
				
				pdfPCell.setPhrase(new Phrase("5",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[20][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[20][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[20][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[21][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[21][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[21][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[22][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[22][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[22][9],fontArial)); 			table2.addCell(pdfPCell);		
				
				
				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[23][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[23][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[23][9],fontArial)); 			table2.addCell(pdfPCell);

				pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][0],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][1],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[24][2],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][3],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][4],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][5],fontArial)); 			table2.addCell(pdfPCell);		

				pdfPCell.setPhrase(new Phrase(appendix8[24][6],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][7],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][8],fontArial)); 			table2.addCell(pdfPCell);		
				pdfPCell.setPhrase(new Phrase(appendix8[24][9],fontArial)); 			table2.addCell(pdfPCell);
				}else{
					pdfPCell.setPhrase(new Phrase("6",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[0][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[0][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[0][11],fontArial)); 			table2.addCell(pdfPCell);
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[1][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[1][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[1][11],fontArial)); 			table2.addCell(pdfPCell);
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[2][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[2][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[2][11],fontArial)); 			table2.addCell(pdfPCell);
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[3][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[3][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[3][11],fontArial)); 			table2.addCell(pdfPCell);
					
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[4][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[4][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][9],fontArial)); 			table2.addCell(pdfPCell);
					pdfPCell.setPhrase(new Phrase(appendix8[4][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[4][11],fontArial)); 			table2.addCell(pdfPCell);
					
					pdfPCell.setPhrase(new Phrase("7",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[5][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[5][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[5][11],fontArial)); 			table2.addCell(pdfPCell);
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[6][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[6][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[6][11],fontArial)); 			table2.addCell(pdfPCell);
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[7][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[7][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[7][11],fontArial)); 			table2.addCell(pdfPCell);
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[8][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[8][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[8][11],fontArial)); 			table2.addCell(pdfPCell);
					
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[9][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[9][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][9],fontArial)); 			table2.addCell(pdfPCell);
					pdfPCell.setPhrase(new Phrase(appendix8[9][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[9][11],fontArial)); 			table2.addCell(pdfPCell);
					
					
					pdfPCell.setPhrase(new Phrase("8",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at30,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[10][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[10][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[10][11],fontArial)); 			table2.addCell(pdfPCell);		
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at31,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[11][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[11][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[11][11],fontArial)); 			table2.addCell(pdfPCell);		
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at32,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[12][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[12][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[12][11],fontArial)); 			table2.addCell(pdfPCell);		
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at33,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[13][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[13][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][9],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[13][11],fontArial)); 			table2.addCell(pdfPCell);		
					
					
					pdfPCell.setPhrase(new Phrase("",fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCellLeftAlign.setPhrase(new Phrase(at34,fontDev100)); 			table2.addCell(pdfPCellLeftAlign);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][0],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][1],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[14][2],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][3],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][4],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][5],fontArial)); 			table2.addCell(pdfPCell);		

					pdfPCell.setPhrase(new Phrase(appendix8[14][6],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][7],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][8],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][9],fontArial)); 			table2.addCell(pdfPCell);
					pdfPCell.setPhrase(new Phrase(appendix8[14][10],fontArial)); 			table2.addCell(pdfPCell);		
					pdfPCell.setPhrase(new Phrase(appendix8[14][11],fontArial)); 			table2.addCell(pdfPCell);
					
					
				}
				
				document.add(table2);
				
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				
				chunk = new Chunk (at50 + "             ", fontDev100);			

				Paragraph p = new Paragraph(chunk);
		 //       p.add(at50);
//		        p.setFirstLineIndent(50f);
		        p.setAlignment(Element.ALIGN_RIGHT);
		        document.add(p);

				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
//copyright
				PdfPTable tableRightPage6 = new PdfPTable(1);
				tableRightPage6.setWidthPercentage(15f);
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

			
			
}
