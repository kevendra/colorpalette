package com.parakhcomputer.web.dao;

import java.util.Collection;
import java.util.List;

import com.parakhcomputer.web.model.StudentMarks;

public interface StudentMarksDao  {

    /**
     * Find studentMark by id.
     */
    public StudentMarks findStudentMarksById(Integer studentMarkID);

    /**
     * Find StudentMarks.
     */
    public Collection<StudentMarks> findAllStudentMarks();

    public Collection<StudentMarks> findStudentMarksByPersonId(Integer id);

    /**
     * Find StudentMarks using a start index and max number of results.
     */
    public Collection<StudentMarks> findStudentMarks(final int startIndex, final int maxResults);

    /**
     * Find StudentMarks by last name.
     */
    //public Collection<StudentMarks> findStudentMarksByLastName(String lastName);

    /**
     * Saves studentMark.
     */
    public StudentMarks save(StudentMarks studentMark);

    /**
     * Deletes studentMark.
     */
    public void delete(StudentMarks studentMark);
    public void deleteStudentMarksByPersonId(Integer id);
    
    public List finalTotalMarksPerSubject(int schoolId, int classId);
    public List finalTotalMarksPerSubjectPlusProject(int schoolId, int classId);    
    public Long studentRegistered(int schoolId, int classId);
    public Long studentAppeared (int schoolId, int classId);
//    public List finalTotalStudentPerSchool(int schoolId);
    public List finalTotalStudentPerSchool1(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool2(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool3(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool4(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool5(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool6(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool7(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool8(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool9(int schoolId, String appendix8Type);
    public List finalTotalStudentPerSchool10(int schoolId, String appendix8Type);
    public List finalTotalMarksPerClassPerSchool(int schoolId, String appendix8Type);
    public List finalTotalMarksPerSubjectPerClassPerSchool(int schoolId, String appendix8Type);
//	void update(StudentMark studentMark);

    /**
     * Saves address to studentMark by adding or updating record.
     */
//TODO    public StudentMarks saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//TODO    public StudentMarks deleteAddress(Integer id, Integer addressId);
	
}


