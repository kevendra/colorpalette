package com.parakhcomputer.web.dao;

import java.util.Collection;

import com.parakhcomputer.web.model.Subject;

public interface SubjectDao  {

    /**
     * Find subject by id.
     */
    public Subject findSubjectById(Integer subjectID);

    /**
     * Find subjects.
     */
    public Collection<Subject> findAllSubjects();

    public Collection<Subject> findAllSubjectsByClassId(Integer classId);
    /**
     * Find subjects using a start index and max number of results.
     */
    public Collection<Subject> findSubjects(final int startIndex, final int maxResults);

    /**
     * Find subjects by last name.
     */
    //public Collection<Subject> findSubjectsByLastName(String lastName);

    /**
     * Saves subject.
     */
    public Subject save(Subject subject);

    /**
     * Deletes subject.
     */
    public void delete(Subject subject);
//	void update(Subject subject);

    /**
     * Saves address to subject by adding or updating record.
     */
//TODO    public Subject saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//TODO    public Subject deleteAddress(Integer id, Integer addressId);
	
}



