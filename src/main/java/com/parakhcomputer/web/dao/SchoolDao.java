package com.parakhcomputer.web.dao;

import java.util.Collection;

import com.parakhcomputer.web.model.School;

public interface SchoolDao  {

    /**
     * Find school by id.
     */
    public School findSchoolById(Integer schoolID);

    /**
     * Find schools.
     */
    public Collection<School> findAllSchools();

    /**
     * Find schools using a start index and max number of results.
     */
    public Collection<School> findSchools(final int startIndex, final int maxResults);

    /**
     * Find schools by last name.
     */
    //public Collection<School> findSchoolsByLastName(String lastName);

    /**
     * Saves school.
     */
    public School save(School school);

    /**
     * Deletes school.
     */
    public void delete(School school);
//	void update(School school);

    /**
     * Saves address to school by adding or updating record.
     */
//TODO    public School saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//TODO    public School deleteAddress(Integer id, Integer addressId);
	
}


