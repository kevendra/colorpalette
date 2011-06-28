package com.parakhcomputer.web.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.Exam;

@Transactional(readOnly = true)
@Repository
public class ExamDaoImpl implements ExamDao {

    private EntityManager entityManager = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find exams.
     */
    public Exam findExamById(Integer id) {
        return entityManager.find(Exam.class, id);
    }
    /**
     * Find exams.
     */
    @SuppressWarnings("unchecked")
    public Collection<Exam> findAllExams() {
    	return entityManager.createQuery("select p from Exam p").getResultList();
	}

    /**
     * Find exams using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")    
	public Collection<Exam> findExams(int startIndex, int maxResults) {
        return entityManager.createQuery("select p from Exam p")
        .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
	}

    /**
     * Saves exam.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Exam save(Exam exam) {
        return entityManager.merge(exam);
    }

    /**
     * Deletes exam.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Exam exam) {
        entityManager.remove(entityManager.merge(exam));
    }

    /**
     * Saves address to exam.
     */
/*    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Exam saveAddress(Integer id, Address address) {
        Exam exam = findExamById(id);

        if (exam.getAddresses().contains(address)) {
            exam.getAddresses().remove(address);
        }

        exam.getAddresses().add(address);        

        return save(exam);
    }
*/
    /**
     * Deletes address from exam.
     */
    /*
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Exam deleteAddress(Integer id, Integer addressId) {
        Exam exam = findExamById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (exam.getAddresses().contains(address)) {
            for (Address a : exam.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    entityManager.remove(a);
                    exam.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return exam;
    }
*/
}
