package com.parakhcomputer.web.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.School;

@Transactional(readOnly = true)
@Repository
public class SchoolDaoImpl implements SchoolDao {

    private EntityManager entityManager = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find schools.
     */
    public School findSchoolById(Integer id) {
        return entityManager.find(School.class, id);
    }
    /**
     * Find schools.
     */
    @SuppressWarnings("unchecked")
    public Collection<School> findAllSchools() {
    	return entityManager.createQuery("select p from School p").getResultList();
	}

    /**
     * Find schools using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")    
	public Collection<School> findSchools(int startIndex, int maxResults) {
        return entityManager.createQuery("select p from School p")
        .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
	}

    /**
     * Saves school.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public School save(School school) {
        return entityManager.merge(school);
    }

    /**
     * Deletes school.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(School school) {
        entityManager.remove(entityManager.merge(school));
    }

    /**
     * Saves address to school.
     */
/*    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public School saveAddress(Integer id, Address address) {
        School school = findSchoolById(id);

        if (school.getAddresses().contains(address)) {
            school.getAddresses().remove(address);
        }

        school.getAddresses().add(address);        

        return save(school);
    }
*/
    /**
     * Deletes address from school.
     */
    /*
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public School deleteAddress(Integer id, Integer addressId) {
        School school = findSchoolById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (school.getAddresses().contains(address)) {
            for (Address a : school.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    entityManager.remove(a);
                    school.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return school;
    }
*/
}
