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

import com.parakhcomputer.web.model.Palette;


/**
 * Palette DAO implementation.
 * 
 * @author David Winterfeldt
 */
@Repository
@Transactional(readOnly = true)
public class PaletteDaoImpl implements PaletteDao {

    private EntityManager em = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    /**
     * Find palettes.
     */
    public Palette findPaletteById(Integer id) {
        return em.find(Palette.class, id);
    }

    /**
     * Find palettes using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")
    public Collection<Palette> findPalettes(final int startIndex, final int maxResults) {
        return em.createQuery("select p from Palette p order by p.themeId, p.name")
            .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
    }

    /**
     * Find palettes.
     */
    @SuppressWarnings("unchecked")
    public Collection<Palette> findPalettes() {
        return em.createQuery("select p from Palette p order by p.themeId, p.name").getResultList();
    }

    /**
     * Find palettes by last name.
     */
    @SuppressWarnings("unchecked")
    public Collection<Palette> findPalettesByLastName(String lastName) {
        return em.createQuery("select p from Palette p where p.lastName = :lastName order by p.lastName, p.firstName")
            .setParameter("lastName", lastName).getResultList();
    }

    @SuppressWarnings("unchecked")
    public Collection<Palette> findPalettesBySchoolIdAndClass(int schoolId, int class_){
    	return em.createQuery("" +
    			" select p from Palette p " +
    			" where p.schoolId = :schoolId " +
    			" and p.class_ = :class_ " +
    			" order by p.srId")
        .setParameter("schoolId", schoolId)
        .setParameter("class_", class_)
        .getResultList();
    }
  
    @SuppressWarnings("unchecked")
    public List findPalettesByThemeId(int themeId){
    	return em.createQuery("" +
    			" select p from Palette p " +
    			" where p.themeId = :themeId " +
    			" order by p.name")
        .setParameter("themeId", themeId)
        .getResultList();
    }     
    /**
     * Saves palette.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Palette save(Palette palette) {
        return em.merge(palette);
    }

    /**
     * Deletes palette.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Palette palette) {
        em.remove(em.merge(palette));
    }

    /**
     * Saves address to palette.
     */
/*    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Palette saveAddress(Integer id, Address address) {
        Palette palette = findPaletteById(id);

        if (palette.getAddresses().contains(address)) {
            palette.getAddresses().remove(address);
        }

        palette.getAddresses().add(address);        

        return save(palette);
    }*/

    /**
     * Deletes address from palette.
     */
/*    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Palette deleteAddress(Integer id, Integer addressId) {
        Palette palette = findPaletteById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (palette.getAddresses().contains(address)) {
            for (Address a : palette.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    em.remove(a);
                    palette.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return palette;
    }
*/
}
