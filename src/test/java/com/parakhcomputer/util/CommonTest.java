package com.parakhcomputer.util;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CommonTest {

	    final Logger logger = LoggerFactory.getLogger(CommonTest.class);

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
	    @Test
	    public void testDataSource() throws SQLException {
	        
//	        Map<Integer, String> ret = populateSchoolList();
//	        System.out.println(ret);
	    	
	    	
//	    	System.out.println("************ Marks Sheet *********:"+4);
//	    	Person person = personDao.findPersonById(4);
//	    	Collection<StudentMarks> studentMarks = studentMarksDao.findStudentMarksByPersonId(4);
//	    	School school = getSchool(person.getSchoolId());
//	    	String caste = getCaste(person.getCasteId());
//	    	new MarksSheetPage1().createMarksSheet(person, studentMarks, school, caste);
	    	//	    	System.out.println("test");
	    }
	    
	    public String getCaste(int casteId){
	    	Caste caste = casteDao.findCasteById(casteId);
	    	return caste.getName()+" & "+caste.getDescription();
	    }
	    
	    public School getSchool(int schoolId){
	    	return  schoolDao.findSchoolById(schoolId);    	
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
	}
