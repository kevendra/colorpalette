package com.parakhcomputer.web.dao;

import java.util.Collection;

import com.parakhcomputer.web.model.Caste;



public interface CasteDao  {

    /**
     * Find caste by id.
     */
    public Caste findCasteById(Integer casteID);

    /**
     * Find castes.
     */
    public Collection<Caste> findAllCastes();

    /**
     * Find castes using a start index and max number of results.
     */
    public Collection<Caste> findCastes(final int startIndex, final int maxResults);

    /**
     * Find castes by last name.
     */
    //public Collection<Caste> findCastesByLastName(String lastName);

    /**
     * Saves caste.
     */
    public Caste save(Caste caste);

    /**
     * Deletes caste.
     */
    public void delete(Caste caste);
//	void update(Caste caste);

    /**
     * Saves address to caste by adding or updating record.
     */
//TODO    public Caste saveAddress(Integer id, Address address);

    /**
     * Deletes address.
     */
//TODO    public Caste deleteAddress(Integer id, Integer addressId);
	
}
