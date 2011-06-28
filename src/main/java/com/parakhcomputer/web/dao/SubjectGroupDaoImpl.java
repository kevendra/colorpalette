package com.parakhcomputer.web.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.SubjectGroup;

@Transactional(readOnly = true)
@Repository
public class SubjectGroupDaoImpl implements SubjectGroupDao {

    private EntityManager entityManager = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find subjectGroups.
     */
    public SubjectGroup findSubjectGroupById(Integer id) {
        return entityManager.find(SubjectGroup.class, id);
    }
    /**
     * Find subjectGroups.
     */
    @SuppressWarnings("unchecked")
    public Collection<SubjectGroup> findAllSubjectGroups() {
    	return entityManager.createQuery("select p from SubjectGroup p").getResultList();
	}

    /**
     * Find subjectGroups using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")    
	public Collection<SubjectGroup> findSubjectGroups(int startIndex, int maxResults) {
        return entityManager.createQuery("select p from SubjectGroup p")
        .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
	}

    /**
     * Saves subjectGroup.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public SubjectGroup save(SubjectGroup subjectGroup) {
        return entityManager.merge(subjectGroup);
    }

    /**
     * Deletes subjectGroup.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(SubjectGroup subjectGroup) {
        entityManager.remove(entityManager.merge(subjectGroup));
    }

    /**
     * Saves address to subjectGroup.
     */
/*    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public SubjectGroup saveAddress(Integer id, Address address) {
        SubjectGroup subjectGroup = findSubjectGroupById(id);

        if (subjectGroup.getAddresses().contains(address)) {
            subjectGroup.getAddresses().remove(address);
        }

        subjectGroup.getAddresses().add(address);        

        return save(subjectGroup);
    }
*/
    /**
     * Deletes address from subjectGroup.
     */
    /*
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public SubjectGroup deleteAddress(Integer id, Integer addressId) {
        SubjectGroup subjectGroup = findSubjectGroupById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (subjectGroup.getAddresses().contains(address)) {
            for (Address a : subjectGroup.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    entityManager.remove(a);
                    subjectGroup.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return subjectGroup;
    }
*/
}
