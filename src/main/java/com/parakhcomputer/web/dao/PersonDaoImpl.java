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

package com.parakhcomputer.web.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.Person;


/**
 * Person DAO implementation.
 * 
 * @author David Winterfeldt
 */
@Repository
@Transactional(readOnly = true)
public class PersonDaoImpl implements PersonDao {

    private EntityManager em = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Find persons.
     */
    public Person findPersonById(Integer id) {
        return em.find(Person.class, id);
    }

    /**
     * Find persons using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")
    public Collection<Person> findPersons(final int startIndex, final int maxResults) {
        return em.createQuery("select p from Person p order by p.class_, p.srId")
            .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
    }

    /**
     * Find persons.
     */
    @SuppressWarnings("unchecked")
    public Collection<Person> findPersons() {
        return em.createQuery("select p from Person p order by p.class_, p.srId").getResultList();
    }

    /**
     * Find persons by last name.
     */
    @SuppressWarnings("unchecked")
    public Collection<Person> findPersonsByLastName(String lastName) {
        return em.createQuery("select p from Person p where p.lastName = :lastName order by p.lastName, p.firstName")
            .setParameter("lastName", lastName).getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<Person> findPersonsBySchoolIdAndClass(int schoolId, int class_){
    	return em.createQuery("" +
    			" select p from Person p " +
    			" where p.schoolId = :schoolId " +
    			" and p.class_ = :class_ " +
    			" order by p.srId")
        .setParameter("schoolId", schoolId)
        .setParameter("class_", class_)
        .getResultList();
    }
    @SuppressWarnings("unchecked")
    public List findPersonsBySchoolId(int schoolId){
//    	Query query=em.createQuery("" +
//    			" select distinct p.class_ from Palette p " +
//    			" where p.schoolId = :schoolId " +
//    			" order by p.class_")
//        .setParameter("schoolId", schoolId);
//    	
//    	return query.getResultList();
    	return em.createQuery("" +
    			" select distinct p.class_ from Palette p " +
    			" where p.schoolId = :schoolId " +
    			" order by p.class_")
        .setParameter("schoolId", schoolId)
        .getResultList();
    }   
    /**
     * Saves person.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Person save(Person person) {
        return em.merge(person);
    }

    /**
     * Deletes person.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Person person) {
        em.remove(em.merge(person));
    }

    /**
     * Saves address to person.
     */
/*    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Person saveAddress(Integer id, Address address) {
        Person person = findPersonById(id);

        if (person.getAddresses().contains(address)) {
            person.getAddresses().remove(address);
        }

        person.getAddresses().add(address);        

        return save(person);
    }*/

    /**
     * Deletes address from person.
     */
/*    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Person deleteAddress(Integer id, Integer addressId) {
        Person person = findPersonById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (person.getAddresses().contains(address)) {
            for (Address a : person.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    em.remove(a);
                    person.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return person;
    }
*/
}
