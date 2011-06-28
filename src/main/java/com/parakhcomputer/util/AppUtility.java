package com.parakhcomputer.util;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;

import com.parakhcomputer.web.dao.CasteDao;
import com.parakhcomputer.web.dao.ExamDao;
import com.parakhcomputer.web.dao.PersonDao;
import com.parakhcomputer.web.dao.SchoolDao;
import com.parakhcomputer.web.dao.StudentMarksDao;
import com.parakhcomputer.web.dao.SubjectDao;
import com.parakhcomputer.web.model.Caste;
import com.parakhcomputer.web.model.Person;
import com.parakhcomputer.web.model.School;
import com.parakhcomputer.web.model.StudentMarks;

//@ContextConfiguration
//@Repository
//@Controller
//@Configurable
//@Component
public class AppUtility implements AppConstant{

    @Autowired
    protected PersonDao personDao = null;
    @Autowired
    protected SubjectDao subjectDao = null;
    @Autowired
    protected ExamDao examDao = null;
    @Autowired
    protected StudentMarksDao studentMarksDao = null;
    @Autowired
    protected SchoolDao schoolDao = null;
    @Autowired
    protected CasteDao casteDao = null;
    
    
    public static String getClassNameInHindi(int classId){
    	String ret ="";
    	switch (classId) {
	        case 1:  ret ="1yh";       break;
	        case 2:  ret ="2jh";       break;
	        case 3:  ret ="3jh";       break;
	        case 4:  ret ="4Fkh";       break;
	        case 5:  ret ="5oha";       break;
	        case 6:  ret ="6Bh";       break;
	        case 7:  ret ="7oha";       break;
	        case 8:  ret ="8oha";       break;
        }
    	return ret;
    }
    
    
	public Map<String,String> populateGenderList() {	
    	Map<String,String> ret = new LinkedHashMap<String,String>();
    	ret.put("M", "Male");
    	ret.put("F", "Female");
    	return ret;
	}  
	
	public Map<String,String> populateCWSNList() {	
    	Map<String,String> ret = new LinkedHashMap<String,String>();
    	ret.put("NA", "---NA---");  //TODO Update person set cwsn="NA" where cwsn=" ";
    	ret.put("HI", "Hearing Impaired");
    	ret.put("LV", "Low Vision");
    	ret.put("VI", "Visual Impaired");
    	ret.put("OH", "Orthopaedically Handicap");
    	ret.put("MR", "Mentally Disabled");
    	ret.put("LD", "Larning Disabled");
    	ret.put("MD", "Multiple Disabilities");
    	ret.put("CP", "Cerebral Palsy");
    	ret.put("OT", "Other");
    	return ret;
	}  

	public Map<String,String> populateCWSNHindiList() {	
    	Map<String,String> ret = new LinkedHashMap<String,String>();
    	ret.put("NA", t26_2);
    	ret.put("HI", t18_2);
    	ret.put("LV", t19_2);
    	ret.put("VI", t20_2);
    	ret.put("OH", t21_2);
    	ret.put("MR", t22_2);
    	ret.put("LD", t23_2);
    	ret.put("MD", t24_2);
    	ret.put("CP", t25_2);
    	ret.put("OT", t27_2);
    	ret.put(" ", t26_2);   //after update remove line  Update person set cwsn="NA" where cwsn=" ";
    	return ret;
	}  
	
	public Map<Integer,String> populateCasteList() {
		Collection<Caste> castes = casteDao.findAllCastes();		
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();    	
    	String value;
    	for(Caste caste : castes){
    		value = caste.getName()+"&&"+caste.getDescription();
    		ret.put(caste.getCasteId(), value);
    	}
    	return ret;
	} 
	public Map<Integer,String> populateSchoolList() {	
    	Collection<School> schools = schoolDao.findAllSchools();
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();
    	String value;
    	for(School school : schools){
    		value = school.getCode()+"&&"+school.getName();
    		ret.put(school.getSchoolId(), value);
    	}
    	return ret;
	} 		

	public Map<Double,String> populateGradeList() {	
    	Map<Double,String> ret = new LinkedHashMap<Double,String>();
    	ret.put(0.0000001, " ");
    	ret.put(2.0, "1.A");
    	ret.put(1.5, "2.B");
    	ret.put(1.0, "3.C");
    	ret.put(0.5, "4.D");
    	ret.put(0.0, "5.E");
    	return ret;
	}

	public Map<Integer,String> populateClassList() {
	
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();
    	ret.put(1, "1yh");
    	ret.put(2, "2jh");
    	ret.put(3, "3jh");
    	ret.put(4, "4Fkh");
    	ret.put(5, "5oha");
    	ret.put(6, "6Bh");
    	ret.put(7, "7oha");
    	ret.put(8, "8oha");
    	return ret;
	}	
	
	public Map<Integer,String> populateClassListA() {
		
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();
    	ret.put(1, "1yh");
    	ret.put(2, "2jh");
    	ret.put(3, "3jh");
    	ret.put(4, "4Fkh");
    	ret.put(5, "5oha");
    	return ret;
	}	
	
	public Map<Integer,String> populateClassListB() {
		
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();
    	ret.put(6, "6Bh");
    	ret.put(7, "7oha");
    	ret.put(8, "8oha");
    	return ret;
	}	
		
	
//********************************************************
	double roundTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}

    public double totalMarksForFinalGrade(Collection<StudentMarks> studentMarks){
		double totalMarksForFinalGrade = 0;
		for(StudentMarks marks : studentMarks){
			if(!(marks.getSubjectId() == 21 ||marks.getSubjectId() == 22 ||marks.getSubjectId() == 46 ||marks.getSubjectId() == 47 )){
				totalMarksForFinalGrade = totalMarksForFinalGrade + marks.getObtain();				
			}
		}
		return totalMarksForFinalGrade;
    }
    public String[][] studentMarksToGrade(Collection<StudentMarks> studentMarks, Person person){
    	
    	int personId = person.getPersonId();
    	int classId = person.getClass_();
    	
    	String[][] grade = new String[26][14];

    	StudentMarks marks;
    	
    	double marksObtain = 0.0;
   		
    	int subjectId = 0;
    	int examId = 0;
   		
		if(classId >=1 && classId <=5){
			subjectId = 1;
		}else if(classId >=6 && classId <=8){
			subjectId = 24;
		}

   		
    	for(int i=0; i<=23; i++){
    		
    		if(classId >=1 && classId <=5){    			
        		if(classId >=1 && classId <=2){
        			//class 1-2 does not require Parayavaran //-----and Extra(atirict Subject) 
            		if(i==3 || i==4){	
            			subjectId++;
            			continue;
            		}
        		}else if(classId >=3 && classId <=5){
  
        			if(i==4){//Extra Subject(atirict vishay)
            			//TODO cheque extra subject marks exist
            			subjectId++;
            			continue;
            		}        			
        		}
        		
        		if(i==5 || i==6){// class 1-5 has only 5 subjects and class 6-8 has 7 subject
        			continue;
        		}    			
    		}else if(classId >=6 && classId <=8){
    			//TODO max value for i is 23 it will never going to touch i=30
     			if(i==6){//Extra Subject(atirict vishay)
        			//TODO cheque extra subject marks exist
        			subjectId++;
        			continue;
        		}
    		}
    		
		    		
    		examId = 1;
//    		int j1 = 0;

    		double totalMarksPerSubject = 0;//varshik parinam column
    		
    		for(int j=0; j<=11; j++){
    			
    			if(examId==14){//varshik parinam
    				if(findGroupId(subjectId)==1){
        				grade[i][j] = findGrade(230, totalMarksPerSubject);    				    				
    				}else if(findGroupId(subjectId)==2 || findGroupId(subjectId) ==3 ){
        				grade[i][j] = findGrade(20, totalMarksPerSubject);    				    				    					
    				}else if(findGroupId(subjectId)==4){
        				grade[i][j] = findGrade(0, totalMarksPerSubject);;    				    				    					
    				}
    			}else{
    				marksObtain = 0;
	    			if(examId==6 || examId==11){//Half yearly and final exam
//	    				System.out.println("********** marksObtainFromStudentMarks *********** :"+personId+" : "+i+" : "+j);
	    				marks = marksObtainFromStudentMarks(studentMarks, personId, subjectId, examId);
	    				if(null != marks){
	    					marksObtain = marks.getObtain();
	    				}	    					
	    				examId++;
//	    				System.out.println("********** marksObtainFromStudentMarks *********** :"+personId+" : "+i+" : "+j);
	    				marks = marksObtainFromStudentMarks(studentMarks, personId, subjectId, examId);
	    				if(null != marks){
	    					marksObtain = marksObtain + marks.getObtain();
	    				}	    					
	    				
	    				grade[i][j] = findGrade(findGradeBand(findGroupId(subjectId), examId), marksObtain);    				
	    			}else{
//	    				System.out.println("********** marksObtainFromStudentMarks *********** :"+personId+" : "+i+" : "+j);
	    				marks = marksObtainFromStudentMarks(studentMarks, personId, subjectId, examId);
	    				if(null != marks){
	    					marksObtain = marks.getObtain();
	    				}	    					
	    				grade[i][j] = findGrade(findGradeBand(findGroupId(subjectId), examId), marksObtain);
	    			}
	    			totalMarksPerSubject = totalMarksPerSubject + marksObtain;
    			}
    			examId++;
    		}
    		subjectId++;
    	}
    	
    	return grade;
    }
    
    public StudentMarks marksObtainFromStudentMarks(Collection<StudentMarks> studentMarks, int personId, int subjectId, int examId ){
//        LinkedList<StudentMarks> list = new LinkedList<StudentMarks>();
        for (StudentMarks marks : studentMarks) {
//            if (marks.match(personId, subjectId, examId))
        	if (marks.getPersonId() == personId && marks.getSubjectId() == subjectId && marks.getExamId() == examId){
//        	if (marks.getPersonId() == personId && marks.getSubjectId() == subjectId ){
//             	System.out.println("*******StudentMarks marks : studentMarks1*******"+personId+" : "+subjectId+" : "+examId);
//             	System.out.println("*******StudentMarks marks : studentMarks2*******"+marks.getPersonId()+" : "+marks.getSubjectId()+" : "+marks.getExamId());
                 return marks;
             }
        }        
    	return null;
    }
    
    public int findGroupId(int subjectId){
    	int groupId =0;
    	if(subjectId >= 1 && subjectId <= 5){
    		groupId = 1;
    	}else if(subjectId >= 6 && subjectId <= 10){
    		groupId = 2;
    	}else if(subjectId >= 11 && subjectId <= 20){
    		groupId = 3;
    	}else if(subjectId >= 21 && subjectId <= 22){
    		groupId = 4;
    	}else if(subjectId >= 24 && subjectId <= 30){
    		groupId = 1;
    	}else if(subjectId >= 31 && subjectId <= 35){
    		groupId = 2;
    	}else if(subjectId >= 36 && subjectId <= 45){
    		groupId = 3;
    	}else if(subjectId >= 46 && subjectId <= 47){
    		groupId = 4;
    	}
    	
    	return groupId;
    }

    public int findGradeBand(int classId){
    	int gradeBand =0;
    	if(classId>=1 && classId<=2){
    		return 990;
    	}else if(classId>=3 && classId<=5){
    		return 1220;
    	}else if(classId>=6 && classId<=8){
    		return 1800;
    	}
    	return gradeBand;
    }
    public int findGradeBand(Integer groupId, Integer examId){
    	int gradeBand =0;
    	if(groupId!=1 && groupId!=4){
    		return 2;
    	}else if(groupId ==1){
    		if(examId == 13){
    			return 20;//project
    		}else if(examId == 6 || examId == 7){
    			return 50;//Half yearly
    		}else if(examId == 11 || examId == 12){
    			return 100;//Half yearly
    		}
    		return 10;
    	}else if(groupId ==4){
    		return 0;//Attendance
    	}
    	return gradeBand;
    }
    public String findGrade(int gradeBand, double marksObtain){
    	switch(gradeBand){
    	case 0 :{
    		if(marksObtain == (int)marksObtain){
    			return ""+(int)marksObtain;
    		}else{
    			return ""+marksObtain;    			
    		}
    	}
//    	break;
    	case 2 :{
    		if(marksObtain >=2){
    			return "A";
    		}else if(marksObtain >= 1.5){
    			return "B";
    		}else if(marksObtain >= 1){
    			return "C";
    		}else if(marksObtain >=0.5){
    			return "D";
    		}
    	}
    	break;
    	case 10 :{
    		if(marksObtain >=7.5){
    			return "A";
    		}else if(marksObtain >= 6){
    			return "B";
    		}else if(marksObtain >= 4){
    			return "C";
    		}else if(marksObtain >=3.3){
    			return "D";
    		}
    	}
    	break;
    	case 20 :{
    		if(marksObtain >=15){
    			return "A";
    		}else if(marksObtain >=12){
    			return "B";
    		}else if(marksObtain >=9){
    			return "C";
    		}else if(marksObtain >=7){
    			return "D";
    		}
    	}
    	break;
    	case 50 :{
    		if(marksObtain >=37){
    			return "A";
    		}else if(marksObtain >=30){
    			return "B";
    		}else if(marksObtain >=23){
    			return "C";
    		}else if(marksObtain >=17){
    			return "D";
    		}
    	}
    	break;
    	case 100 :{
    		if(marksObtain >=75){
    			return "A";
    		}else if(marksObtain >=60){
    			return "B";
    		}else if(marksObtain >=45){
    			return "C";
    		}else if(marksObtain >=33){
    			return "D";
    		}
    	}
    	break;
    	case 230 :{
    		if(marksObtain >=173){
    			return "A";
    		}else if(marksObtain >=138){
    			return "B";
    		}else if(marksObtain >=104){
    			return "C";
    		}else if(marksObtain >=76){
    			return "D";
    		}
    	}
    	break;
    	case 250 :{
    		if(marksObtain >=188){
    			return "A";
    		}else if(marksObtain >=150){
    			return "B";
    		}else if(marksObtain >=113){
    			return "C";
    		}else if(marksObtain >=83){
    			return "D";
    		}
    	}
    	break;    	
    	case 690 :{
    		if(marksObtain >=518){
    			return "A";
    		}else if(marksObtain >=414){
    			return "B";
    		}else if(marksObtain >=311){
    			return "C";
    		}else if(marksObtain >=228){
    			return "D";
    		}
    	}
    	break;     	
    	case 920 :{
    		if(marksObtain >=690){
    			return "A";
    		}else if(marksObtain >=552){
    			return "B";
    		}else if(marksObtain >=414){
    			return "C";
    		}else if(marksObtain >=304){
    			return "D";
    		}
    	}
    	break;  
    	case 990 :{
    		if(marksObtain >=743){
    			return "A";
    		}else if(marksObtain >=594){
    			return "B";
    		}else if(marksObtain >=446){
    			return "C";
    		}else if(marksObtain >=327){
    			return "D";
    		}
    	}
    	break;      	
    	case 1150 :{
    		if(marksObtain >=863){
    			return "A";
    		}else if(marksObtain >=690){
    			return "B";
    		}else if(marksObtain >=518){
    			return "C";
    		}else if(marksObtain >=380){
    			return "D";
    		}
    	}
    	break;      	
    	case 1220 :{
    		if(marksObtain >=915){
    			return "A";
    		}else if(marksObtain >=732){
    			return "B";
    		}else if(marksObtain >=549){
    			return "C";
    		}else if(marksObtain >=403){
    			return "D";
    		}
    	}
    	break;      	
    	case 1450 :{
    		if(marksObtain >=1088){
    			return "A";
    		}else if(marksObtain >=870){
    			return "B";
    		}else if(marksObtain >=653){
    			return "C";
    		}else if(marksObtain >=479){
    			return "D";
    		}
    	}
    	break;      	
    	case 1500 :{
    		if(marksObtain >=1125){
    			return "A";
    		}else if(marksObtain >=900){
    			return "B";
    		}else if(marksObtain >=675){
    			return "C";
    		}else if(marksObtain >=495){
    			return "D";
    		}
    	}
    	break;      	
    	case 1750 :{
    		if(marksObtain >=1313){
    			return "A";
    		}else if(marksObtain >=1050){
    			return "B";
    		}else if(marksObtain >=788){
    			return "C";
    		}else if(marksObtain >=578){
    			return "D";
    		}
    	}
    	break;      	
    	case 1800 :{
    		if(marksObtain >=1350){
    			return "A";
    		}else if(marksObtain >=1080){
    			return "B";
    		}else if(marksObtain >=810){
    			return "C";
    		}else if(marksObtain >=594){
    			return "D";
    		}
    	}
    	break;      	
    	case 2050 :{
    		if(marksObtain >=1538){
    			return "A";
    		}else if(marksObtain >=1230){
    			return "B";
    		}else if(marksObtain >=923){
    			return "C";
    		}else if(marksObtain >=677){
    			return "D";
    		}
    	}
    	break;      	  	
    	}
    	
    	return "E";
    }
 	
    
	public String dateInWord(java.util.Date date){
    	
   	 Calendar calendar = new GregorianCalendar();
	 calendar.setTime(date);
 	
    	return
    		dayInWord(calendar.get(Calendar.DATE)) + " " +
    		monthInWord(calendar.get(Calendar.MONTH)+1)+ " " +		
    		yearInWord(calendar.get(Calendar.YEAR));
    }
	
    public String dayInWord(int day){
    	String dayInWord="";
    	switch(day){
    	case 	1	: dayInWord = day1;	break;
    	case 	2	: dayInWord = day2;	break;
    	case 	3	: dayInWord = day3;	break;
    	case 	4	: dayInWord = day4;	break;
    	case 	5	: dayInWord = day5;	break;
    	case 	6	: dayInWord = day6;	break;
    	case 	7	: dayInWord = day7;	break;
    	case 	8	: dayInWord = day8;	break;
    	case 	9	: dayInWord = day9;	break;
    	case 	10	: dayInWord = day10;	break;
    	case 	11	: dayInWord = day11;	break;
    	case 	12	: dayInWord = day12;	break;
    	case 	13	: dayInWord = day13;	break;
    	case 	14	: dayInWord = day14;	break;
    	case 	15	: dayInWord = day15;	break;
    	case 	16	: dayInWord = day16;	break;
    	case 	17	: dayInWord = day17;	break;
    	case 	18	: dayInWord = day18;	break;
    	case 	19	: dayInWord = day19;	break;
    	case 	20	: dayInWord = day20;	break;
    	case 	21	: dayInWord = day21;	break;
    	case 	22	: dayInWord = day22;	break;
    	case 	23	: dayInWord = day23;	break;
    	case 	24	: dayInWord = day24;	break;
    	case 	25	: dayInWord = day25;	break;
    	case 	26	: dayInWord = day26;	break;
    	case 	27	: dayInWord = day27;	break;
    	case 	28	: dayInWord = day28;	break;
    	case 	29	: dayInWord = day29;	break;
    	case 	30	: dayInWord = day30;	break;
    	case 	31	: dayInWord = day31;	break;    	
    	}    	
    	return dayInWord;    	
    }
    
    public String monthInWord(int month){
    	String monthInWord="";
    	switch(month){
    	case 	1	: monthInWord = month1;	break;
    	case 	2	: monthInWord = month2;	break;
    	case 	3	: monthInWord = month3;	break;
    	case 	4	: monthInWord = month4;	break;
    	case 	5	: monthInWord = month5;	break;
    	case 	6	: monthInWord = month6;	break;
    	case 	7	: monthInWord = month7;	break;
    	case 	8	: monthInWord = month8;	break;
    	case 	9	: monthInWord = month9;	break;
    	case 	10	: monthInWord = month10;	break;
    	case 	11	: monthInWord = month11;	break;
    	case 	12	: monthInWord = month12;	break;  	
    	}       	
    	return monthInWord;    	
    }
    public String yearInWord(int year){
    	String yearInWord="";
    	switch(year){
    	case 	1980:	yearInWord = year1980;	 break;
    	case 	1981:	yearInWord = year1981;	 break;
    	case 	1982:	yearInWord = year1982;	 break;
    	case 	1983:	yearInWord = year1983;	 break;
    	case 	1984:	yearInWord = year1984;	 break;
    	case 	1985:	yearInWord = year1985;	 break;
    	case 	1986:	yearInWord = year1986;	 break;
    	case 	1987:	yearInWord = year1987;	 break;
    	case 	1988:	yearInWord = year1988;	 break;
    	case 	1989:	yearInWord = year1989;	 break;
    	case 	1990:	yearInWord = year1990;	 break;
    	case 	1991:	yearInWord = year1991;	 break;
    	case 	1992:	yearInWord = year1992;	 break;
    	case 	1993:	yearInWord = year1993;	 break;
    	case 	1994:	yearInWord = year1994;	 break;
    	case 	1995:	yearInWord = year1995;	 break;
    	case 	1996:	yearInWord = year1996;	 break;
    	case 	1997:	yearInWord = year1997;	 break;
    	case 	1998:	yearInWord = year1998;	 break;
    	case 	1999:	yearInWord = year1999;	 break;
    	case 	2000:	yearInWord = year2000;	 break;
    	case 	2001:	yearInWord = year2001;	 break;
    	case 	2002:	yearInWord = year2002;	 break;
    	case 	2003:	yearInWord = year2003;	 break;
    	case 	2004:	yearInWord = year2004;	 break;
    	case 	2005:	yearInWord = year2005;	 break;
    	case 	2006:	yearInWord = year2006;	 break;
    	case 	2007:	yearInWord = year2007;	 break;
    	case 	2008:	yearInWord = year2008;	 break;
    	case 	2009:	yearInWord = year2009;	 break;
    	case 	2010:	yearInWord = year2010;	 break;
    	case 	2011:	yearInWord = year2011;	 break;    	
    	}    	
    	return yearInWord;    	
    }     
    
    public void calender(){
    	 // get the supported ids for GMT-08:00 (Pacific Standard Time)
    	 String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
    	 // if no ids were returned, something is wrong. get out.
    	 if (ids.length == 0)
    	     System.exit(0);

    	  // begin output
    	 System.out.println("Current Time");

    	 // create a Pacific Standard Time time zone
    	 SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);

    	 // set up rules for daylight savings time
    	 pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
    	 pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

    	 // create a GregorianCalendar with the Pacific Daylight time zone
    	 // and the current date and time
    	 Calendar calendar = new GregorianCalendar(pdt);
    	 Date trialTime = new Date();
    	 calendar.setTime(trialTime);

    	 // print out a bunch of interesting things
    	 System.out.println("ERA: " + calendar.get(Calendar.ERA));
    	 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
    	 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
    	 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
    	 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
    	 System.out.println("DATE: " + calendar.get(Calendar.DATE));
    	 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
    	 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
    	 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
    	 System.out.println("DAY_OF_WEEK_IN_MONTH: "
    	                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    	 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
    	 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
    	 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
    	 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
    	 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
    	 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
    	 System.out.println("ZONE_OFFSET: "
    	                    + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
    	 System.out.println("DST_OFFSET: "
    	                    + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));

    	 System.out.println("Current Time, with hour reset to 3");
    	 calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
    	 calendar.set(Calendar.HOUR, 3);
    	 System.out.println("ERA: " + calendar.get(Calendar.ERA));
    	 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
    	 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
    	 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
    	 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
    	 System.out.println("DATE: " + calendar.get(Calendar.DATE));
    	 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
    	 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
    	 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
    	 System.out.println("DAY_OF_WEEK_IN_MONTH: "
    	                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
    	 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
    	 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
    	 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
    	 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
    	 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
    	 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
    	 System.out.println("ZONE_OFFSET: "
    	        + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // in hours
    	 System.out.println("DST_OFFSET: "
    	        + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000))); // in hours    	
    }
}
