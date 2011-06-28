/*
 * Copyright 2007-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.parakhcomputer.web.mvc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.parakhcomputer.util.AppConstant;
import com.parakhcomputer.util.AppUtility;
import com.parakhcomputer.web.bean.Appendix6a;
import com.parakhcomputer.web.bean.Appendix6aExam;
import com.parakhcomputer.web.bean.Appendix6aSubject;
import com.parakhcomputer.web.dao.CasteDao;
import com.parakhcomputer.web.dao.ExamDao;
import com.parakhcomputer.web.dao.PersonDao;
import com.parakhcomputer.web.dao.SchoolDao;
import com.parakhcomputer.web.dao.StudentMarksDao;
import com.parakhcomputer.web.dao.SubjectDao;
import com.parakhcomputer.web.dao.ThemeDao;
import com.parakhcomputer.web.model.Caste;
import com.parakhcomputer.web.model.Exam;
import com.parakhcomputer.web.model.Person;
import com.parakhcomputer.web.model.School;
import com.parakhcomputer.web.model.StudentMarks;
import com.parakhcomputer.web.model.Subject;
import com.parakhcomputer.web.model.Theme;



//@Configurable
@Component
public class AppendixControllerUtil extends AppUtility{

    static final String FROM_VIEW_KEY = "redirect:form.html";
    static final String SEARCH_VIEW_KEY = "redirect:search.html";
    static final String SEARCH_MODEL_KEY = "appendix6as";
    static final Integer CLASS_ID = 1;

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
		
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(AppConstant.DATE_FORMAT);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	public StudentMarks findStudentMarks(Collection<StudentMarks> studentMarksList, int subjectId, int examId){
		if(null!= studentMarksList && !studentMarksList.isEmpty()){
    		StudentMarks studentMarks;
    		for(StudentMarks marks : studentMarksList){    			
    			if(((int)marks.getSubjectId())==subjectId && ((int)marks.getExamId())==examId){
    				studentMarks = new StudentMarks();
    				studentMarks.setPersonId(marks.getPersonId());
    				studentMarks.setStudentMarksId(marks.getStudentMarksId());
    				studentMarks.setSubjectId(marks.getSubjectId());
    				studentMarks.setExamId(marks.getExamId());
    				studentMarks.setObtain(marks.getObtain());
    				return studentMarks;
    			}
    		}
    	}
    	return null;
	}
	public void addStudentMarksToAppendix6a(Appendix6a appendix6a, Collection<StudentMarks> studentMarksList){		
		if(null != studentMarksList && !studentMarksList.isEmpty()){
	    	StudentMarks studentMarks  = null;
	    	Integer personId =0;
	    	if(null!=appendix6a){
	    		personId = appendix6a.getPersonId();
//				System.out.println("*******personId**1********:"+personId);
	    		Collection<Appendix6aSubject> appendix6aSubjects = appendix6a.getAppendix6aSubjects();
	        	if(null != appendix6aSubjects && !appendix6aSubjects.isEmpty()){
//	        	System.out.println("index2***********");	
	        		Iterator<Appendix6aSubject> itrSubject = appendix6aSubjects.iterator();
	        		while(itrSubject.hasNext()){
	        			Appendix6aSubject appendix6aSubject = itrSubject.next();
	        			Collection<Appendix6aExam> appendix6aExams = appendix6aSubject.getAppendix6aExams();
//	    	        	System.out.println("index3***********");	
	                	if(null != appendix6aExams && !appendix6aExams.isEmpty()){
	                		Iterator<Appendix6aExam> itrExam = appendix6aExams.iterator();
	                		while(itrExam.hasNext()){
//	            	        	System.out.println("index4***********");	
	                			Appendix6aExam appendix6aExam = itrExam.next();
                				studentMarks = findStudentMarks(studentMarksList, appendix6aSubject.getSubjectId(), appendix6aExam.getExamId());
	                			if(null!=studentMarks){
	                				//personId = studentMarks.getPersonId();
//	                				System.out.println("*******personId"+personId);
	                				appendix6aExam.setObtain(""+studentMarks.getObtain());
//	                				appendix6aExam.setObtain(convertMarksToGrade(studentMarks.getObtain()));
	                			}	                			
	                		}
	                	}
	        		}
	        		
//	        		for(Appendix6aSubject appendix6aSubject : appendix6aSubjects){
//	            		Collection<Appendix6aExam> appendix6aExams = appendix6aSubject.getAppendix6aExams();
//	                	if(null != appendix6aExams && !appendix6aExams.isEmpty()){
//	                			for(Appendix6aExam appendix6aExam : appendix6aExams){
//	                				studentMarks = findStudentMarks(studentMarksList, appendix6aSubject.getSubjectId(), appendix6aExam.getExamId());
//		                			if(null!=studentMarks){
//		                				personId = studentMarks.getPersonId();
//		                				System.out.println("*******personId"+personId);
//		                				appendix6aExam.setObtain(convertMarksToGrade(studentMarks.getObtain()));
//		                			}
//		                		//	
//		                		//	System.out.println("******getObtain*********"+ studentMarks.getObtain());
//	                			}
//	                		}
//	        			}

	        		}
	        		appendix6a.setPersonId(personId);
	    		}
	    	}
	}
	public Appendix6a getAppendix6aTopToBottom(Integer id, Integer classId){
		Appendix6a appendix6a;
		Person person = personDao.findPersonById(id);
		if(null == person){
			appendix6a = emptyAppendix6aBottomToTop(classId);
		}else{
			appendix6a = emptyAppendix6aBottomToTop(person.getClass_());
			copyPersonToAppendix6a(appendix6a, person);
			Collection<StudentMarks> studentMarks = studentMarksDao.findStudentMarksByPersonId(id);
			if(null != studentMarks && !studentMarks.isEmpty()){
				addStudentMarksToAppendix6a(appendix6a, studentMarks);
			}
		}
		
		return appendix6a;
	}
	
	public Appendix6a setPersonForEdit(Appendix6a appendix6a){
		return getAppendix6aTopToBottom(appendix6a.getPersonId(), 0); //todo class_id = 0
	}
	
	public Appendix6a emptyAppendix6aBottomToTop(int classId){
		if(classId >= 1 && classId <=5){  //subject only available for class 1st and 6th 
			classId = 1;
		}else{
			classId = 6;
		}
    	Collection<Subject> subjects = subjectDao.findAllSubjectsByClassId(classId);
       	
    	Appendix6aSubject appendix6aSubject = null;    	
    	Collection<Appendix6aSubject> appendix6aSubjects = null;
    	if(null != subjects && !subjects.isEmpty()){
    		appendix6aSubjects = new ArrayList<Appendix6aSubject>();

        	Collection<Exam> exams = examDao.findAllExams();    	
  	
        	Appendix6aExam appendix6aExam = null;
        	Collection<Appendix6aExam> appendix6aExams = null;
        	if(null != exams && !exams.isEmpty()){
//            	System.out.println("inside emptyAppendix6aBottomToTop2");
 		
	        	for(Subject subject : subjects){
	            	appendix6aExams = new ArrayList<Appendix6aExam>();
	            	for(Exam exam : exams){
	            		appendix6aExam = new Appendix6aExam();
	            		appendix6aExam.setExamId(exam.getExamId());
	            		appendix6aExams.add(appendix6aExam);
	            	}
	        		
	            	appendix6aSubject = new Appendix6aSubject();
	        		appendix6aSubject.setSubjectId(subject.getSubjectId());
	        		appendix6aSubject.setName(subject.getName());
	        		appendix6aSubject.setGroupId(subject.getGroupId());
	            	appendix6aSubject.setAppendix6aExams(appendix6aExams);
	            	appendix6aSubjects.add(appendix6aSubject);
	        	}
        	}
     	}
    	
//    	System.out.println("inside emptyAppendix6aBottomToTop3");
//    	if(null!=appendix6aSubject ){
//        	System.out.println("inside emptyAppendix6aBottomToTop4");
//
//    	}
    		
    	Appendix6a appendix6a= new Appendix6a();
    	appendix6a.setAppendix6aSubjects(appendix6aSubjects);
    	
    	return appendix6a;
	}


    public Appendix6a copyPersonToAppendix6a(Person person){
    	Appendix6a appendix6a = null;
    	if(null!=person){
    		appendix6a = new Appendix6a();
    		copyPersonToAppendix6a(appendix6a, person);
    	}
    	return appendix6a;
    }
    
    public void copyPersonToAppendix6a(Appendix6a appendix6a, Person person){
    	if(null!=person){
    		appendix6a.setPersonId(person.getPersonId());
    		appendix6a.setSrId(person.getSrId());
    		appendix6a.setRollId(person.getRollId());
    		appendix6a.setScholarId(person.getScholarId());
    		appendix6a.setFirstName(person.getFirstName());
    		appendix6a.setMiddleName(person.getMiddleName());
    		appendix6a.setLastName(person.getLastName());
    		appendix6a.setFatherFirstName(person.getFatherFirstName());
    		appendix6a.setFatherMiddleName(person.getFatherMiddleName());
    		appendix6a.setFatherLastName(person.getFatherLastName());
    		appendix6a.setMotherFirstName(person.getMotherFirstName());
    		appendix6a.setMotherMiddleName(person.getMotherMiddleName());
    		appendix6a.setMotherLastName(person.getMotherLastName());
    		appendix6a.setSession(person.getSession());
    		appendix6a.setClass_(person.getClass_());
    		appendix6a.setSection(person.getSection());
    		appendix6a.setDoB(person.getDoB());
//    		appendix6a.setPoB(person.getPoB());
    		appendix6a.setGender(person.getGender());
    		appendix6a.setTeacherComment(person.getTeacherComment());
//    		appendix6a.setStreet1(person.getStreet1());
//    		appendix6a.setStreet2(person.getStreet2());
//    		appendix6a.setCity(person.getCity());
//    		appendix6a.setZipPin(person.getZipPin());
//    		appendix6a.setState(person.getState());
//    		appendix6a.setCountry(person.getCountry());
//    		appendix6a.setPhone1(person.getPhone1());
//    		appendix6a.setPhone2(person.getPhone2());
//    		appendix6a.setEmailId(person.getEmailId());
    		appendix6a.setSchoolId(person.getSchoolId());
    		appendix6a.setCasteId(person.getCasteId());
    		appendix6a.setCwsnId(person.getCwsnId());    		
    	}
    }
    public Person copyAppendix6aToPerson(Appendix6a appendix6a){
    	Person person  = null;
    	if(null!=appendix6a){
    		person  = new Person();
    		person.setPersonId(appendix6a.getPersonId());
    		person.setSrId(appendix6a.getSrId());
    		person.setRollId(appendix6a.getRollId());
    		person.setScholarId(appendix6a.getScholarId());    		
    		person.setFirstName(appendix6a.getFirstName());
    		person.setMiddleName(appendix6a.getMiddleName());
    		person.setLastName(appendix6a.getLastName());
    		person.setFatherFirstName(appendix6a.getFatherFirstName());
    		person.setFatherMiddleName(appendix6a.getFatherMiddleName());
    		person.setFatherLastName(appendix6a.getFatherLastName());
    		person.setMotherFirstName(appendix6a.getMotherFirstName());
    		person.setMotherMiddleName(appendix6a.getMotherMiddleName());
    		person.setMotherLastName(appendix6a.getMotherLastName());
    		person.setSession(appendix6a.getSession());
    		person.setClass_(appendix6a.getClass_());
    		person.setSection(appendix6a.getSection());
    		person.setDoB(appendix6a.getDoB());
//    		person.setPoB(appendix6a.getPoB());
    		person.setGender(appendix6a.getGender());
    		person.setTeacherComment(appendix6a.getTeacherComment());
//    		person.setStreet1(appendix6a.getStreet1());
//    		person.setStreet2(appendix6a.getStreet2());
//    		person.setCity(appendix6a.getCity());
//    		person.setZipPin(appendix6a.getZipPin());
//    		person.setState(appendix6a.getState());
//    		person.setCountry(appendix6a.getCountry());
//    		person.setPhone1(appendix6a.getPhone1());
//    		person.setPhone2(appendix6a.getPhone2());
//    		person.setEmailId(appendix6a.getEmailId());
    		person.setSchoolId(appendix6a.getSchoolId());
    		person.setCasteId(appendix6a.getCasteId());
    		person.setCwsnId(appendix6a.getCwsnId());
    	}
	
    	return person;
    }
    public String convertMarksToGrade(double marks){
    	String grade;
    	if(marks==2){
    		grade="A";
    	}else if(marks==1.5){
    		grade="B";
    	}else if(marks==1){
    		grade="C";
    	}else if(marks==0.5){
    		grade="D";
    	}else if(marks==0){
    		grade="E";
    	}else {
    		grade=marks+"";
    	}
    	return grade;
    }
    public double convertGradeToMarks(String grade){
    	double marks = 0;
    	if(null!= grade && !grade.isEmpty()){
    		grade.trim();
    		if(grade.equalsIgnoreCase("A")){
    			marks = 2;
    		}else if(grade.equalsIgnoreCase("B")){
    			marks = 1.5;
    		}else if(grade.equalsIgnoreCase("C")){
    			marks = 1;
    		}else if(grade.equalsIgnoreCase("D")){
    			marks = 0.5;
    		}else if(grade.equalsIgnoreCase("E")){
    			marks = 0;
    		}else{
    			try{
    				marks = Double.parseDouble(grade);
    			}catch(NumberFormatException e){
    				return 0.00;
    			}
    		}
    	}
    	return marks;
    }
    public StudentMarks copyAppendix6aToStudentMarksAndSave(Appendix6a appendix6a, Integer personId){
    	StudentMarks studentMarks  = null;
    	if(null!=appendix6a){
    		Collection<Appendix6aSubject> appendix6aSubjects = appendix6a.getAppendix6aSubjects();
        	if(null != appendix6aSubjects && !appendix6aSubjects.isEmpty()){
        		for(Appendix6aSubject appendix6aSubject : appendix6aSubjects){
            		Collection<Appendix6aExam> appendix6aExams = appendix6aSubject.getAppendix6aExams();
                	if(null != appendix6aExams && !appendix6aExams.isEmpty()){
                		for(Appendix6aExam appendix6aExam : appendix6aExams){
                			studentMarks = new StudentMarks();
                			studentMarks.setStudentMarksId(appendix6aExam.getStudentMarksId());
                			studentMarks.setPersonId(personId);
                			studentMarks.setSubjectId(appendix6aSubject.getSubjectId());
                			studentMarks.setExamId(appendix6aExam.getExamId());
                			studentMarks.setObtain(convertGradeToMarks(appendix6aExam.getObtain()));
                			StudentMarks resStudentMarks = studentMarksDao.save(studentMarks);
   //             			System.out.println("************ studentMarksDao.save Ens *********** "+resStudentMarks);
                		}
                	}
        		}

        	}
    	}
    	studentMarks  = new StudentMarks();
    	
    	return studentMarks;
	}

    
    public String getCaste(int casteId){
    	Caste caste = casteDao.findCasteById(casteId);
    	return caste.getName()+" & "+caste.getDescription();
    }
    
    public School getSchool(int schoolId){
    	return  schoolDao.findSchoolById(schoolId);    	
    }
    
    
    
    // ************************** Model Variable

	@ModelAttribute("genderList")
	public Map<String,String> populateGenderList() {	
    	return new AppUtility().populateGenderList();
	}  
	@ModelAttribute("cwsnList")
	public Map<String,String> populateCWSNList() {	
		return new AppUtility().populateCWSNHindiList();//populateCWSNList();
	}
	@ModelAttribute("casteList")
	public Map<Integer,String> populateCasteList() {
		Collection<Caste> castes = casteDao.findAllCastes();		
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();    	
    	String value;
    	for(Caste caste : castes){
//    		value = caste.getName()+"&&"+caste.getDescription();
    		value = caste.getDescription();
    		ret.put(caste.getCasteId(), value);
    	}
   	return ret;
	} 
	@ModelAttribute("schoolList")
	public Map<Integer,String> populateSchoolList() {	
    	Collection<School> schools = schoolDao.findAllSchools();
    	Map<Integer,String> ret = new LinkedHashMap<Integer,String>();
    	String value;
    	for(School school : schools){
    		value = school.getSchoolId()+" & "+school.getCode()+" & "+school.getName();
    		ret.put(school.getSchoolId(), value);
    	}
    	return ret;
	} 		
	@ModelAttribute("gradeList")
	public Map<Double,String> populateGradeList() {	
    	return new AppUtility().populateGradeList();
	}
	@ModelAttribute("classList")
	public Map<Integer,String> populateClassList() {
    	return new AppUtility().populateClassList();
	}	
	@ModelAttribute("classListA")
	public Map<Integer,String> populateClassListA() {
    	return new AppUtility().populateClassListA();
	}	
	@ModelAttribute("classListB")
	public Map<Integer,String> populateClassListB() {
    	return new AppUtility().populateClassListB();
	}	
	
}
