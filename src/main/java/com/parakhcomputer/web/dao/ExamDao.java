package com.parakhcomputer.web.dao;

import java.util.Collection;

import com.parakhcomputer.web.model.Exam;

public interface ExamDao  {

    /**
     * Find exam by id.
     */
    public Exam findExamById(Integer examID);

    /**
     * Find exams.
     */
    public Collection<Exam> findAllExams();

    /**
     * Find exams using a start index and max number of results.
     */
    public Collection<Exam> findExams(final int startIndex, final int maxResults);

    /**
     * Find exams by last name.
     */
   // public Collection<Exam> findExamsByLastName(String lastName);

    /**
     * Saves exam.
     */
    public Exam save(Exam exam);

    /**
     * Deletes exam.
     */
    public void delete(Exam exam);
//	void update(Exam exam);

    /**
     * Saves address to exam by adding or updating record.
     */
//TODO    public Exam saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//TODO    public Exam deleteAddress(Integer id, Integer addressId);
	
}
