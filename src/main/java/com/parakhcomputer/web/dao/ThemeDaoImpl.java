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

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.Theme;


/**
 * Theme DAO implementation.
 * 
 * @author David Winterfeldt
 */
@Repository
@Transactional(readOnly = true)
public class ThemeDaoImpl implements ThemeDao {

    private EntityManager em = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Find themes.
     */
    public Theme findThemeById(Integer id) {
        return em.find(Theme.class, id);
    }

    /**
     * Find themes using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")
    public Collection<Theme> findThemes(final int startIndex, final int maxResults) {
        return em.createQuery("select p from Theme p order by p.themeName")
            .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
    }

    /**
     * Find themes.
     */
    @SuppressWarnings("unchecked")
    public Collection<Theme> findThemes() {
        return em.createQuery("select p from Theme p order by p.themeName").getResultList();
    }

    /**
     * Find themes by last name.
     */
    @SuppressWarnings("unchecked")
    public Collection<Theme> findThemesByLastName(String lastName) {
        return em.createQuery("select p from Theme p where p.lastName = :lastName order by p.lastName, p.firstName")
            .setParameter("lastName", lastName).getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<Theme> findThemesBySchoolIdAndClass(int schoolId, int class_){
    	return em.createQuery("" +
    			" select p from Theme p " +
    			" where p.schoolId = :schoolId " +
    			" and p.class_ = :class_ " +
    			" order by p.srId")
        .setParameter("schoolId", schoolId)
        .setParameter("class_", class_)
        .getResultList();
    }
    @SuppressWarnings("unchecked")
    public List findThemesBySchoolId(int schoolId){
//    	Query query=em.createQuery("" +
//    			" select distinct p.class_ from Theme p " +
//    			" where p.schoolId = :schoolId " +
//    			" order by p.class_")
//        .setParameter("schoolId", schoolId);
//    	
//    	return query.getResultList();
    	return em.createQuery("" +
    			" select distinct p.class_ from Theme p " +
    			" where p.schoolId = :schoolId " +
    			" order by p.class_")
        .setParameter("schoolId", schoolId)
        .getResultList();
    }    
    /**
     * Saves theme.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Theme save(Theme theme) {
        return em.merge(theme);
    }

    /**
     * Deletes theme.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Theme theme) {
        em.remove(em.merge(theme));
    }

    /**
     * Saves address to theme.
     */
/*    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Theme saveAddress(Integer id, Address address) {
        Theme theme = findThemeById(id);

        if (theme.getAddresses().contains(address)) {
            theme.getAddresses().remove(address);
        }

        theme.getAddresses().add(address);        

        return save(theme);
    }*/

    /**
     * Deletes address from theme.
     */
/*    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Theme deleteAddress(Integer id, Integer addressId) {
        Theme theme = findThemeById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (theme.getAddresses().contains(address)) {
            for (Address a : theme.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    em.remove(a);
                    theme.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return theme;
    }
*/
}
