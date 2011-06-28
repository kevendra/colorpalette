package com.parakhcomputer.web.dao;

import java.util.Collection;

import com.parakhcomputer.web.model.SubjectGroup;

public interface SubjectGroupDao  {
    /**
     * Find subjectGroup by id.
     */
    public SubjectGroup findSubjectGroupById(Integer subjectGroupID);

    /**
     * Find subjectGroups.
     */
    public Collection<SubjectGroup> findAllSubjectGroups();

    /**
     * Find subjectGroups using a start index and max number of results.
     */
    public Collection<SubjectGroup> findSubjectGroups(final int startIndex, final int maxResults);

    /**
     * Find subjectGroups by last name.
     */
    //////public Collection<SubjectGroup> findSubjectGroupsByLastName(String lastName);

    /**
     * Saves subjectGroup.
     */
    public SubjectGroup save(SubjectGroup subjectGroup);

    /**
     * Deletes subjectGroup.
     */
    public void delete(SubjectGroup subjectGroup);
//	void update(SubjectGroup subjectGroup);

    /**
     * Saves address to subjectGroup by adding or updating record.
     */
//TODO    public SubjectGroup saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//TODO    public SubjectGroup deleteAddress(Integer id, Integer addressId);
	
}

