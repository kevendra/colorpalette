package com.parakhcomputer.web.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.Subject;

@Transactional(readOnly = true)
@Repository
public class SubjectDaoImpl implements SubjectDao {

    private EntityManager entityManager = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find subjects.
     */
    public Subject findSubjectById(Integer id) {
        return entityManager.find(Subject.class, id);
    }
    /**
     * Find subjects.
     */
    @SuppressWarnings("unchecked")
    public Collection<Subject> findAllSubjects() {
    	return entityManager.createQuery("select p from Subject p").getResultList();
	}

    @SuppressWarnings("unchecked")
    public Collection<Subject> findAllSubjectsByClassId(Integer classId) {
    	return entityManager.createQuery("select p from Subject p where p.class_ = :class_ order by p.groupId, p.subjectId")
    	.setParameter("class_", classId).getResultList();
	}
    /**
     * Find subjects using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")    
	public Collection<Subject> findSubjects(int startIndex, int maxResults) {
        return entityManager.createQuery("select p from Subject p")
        .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
	}

    /**
     * Saves subject.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Subject save(Subject subject) {
        return entityManager.merge(subject);
    }

    /**
     * Deletes subject.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Subject subject) {
        entityManager.remove(entityManager.merge(subject));
    }

    /**
     * Saves address to subject.
     */
/*    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Subject saveAddress(Integer id, Address address) {
        Subject subject = findSubjectById(id);

        if (subject.getAddresses().contains(address)) {
            subject.getAddresses().remove(address);
        }

        subject.getAddresses().add(address);        

        return save(subject);
    }
*/
    /**
     * Deletes address from subject.
     */
    /*
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Subject deleteAddress(Integer id, Integer addressId) {
        Subject subject = findSubjectById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (subject.getAddresses().contains(address)) {
            for (Address a : subject.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    entityManager.remove(a);
                    subject.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return subject;
    }
*/
}
