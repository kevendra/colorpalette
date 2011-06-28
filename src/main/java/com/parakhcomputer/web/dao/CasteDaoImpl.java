package com.parakhcomputer.web.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.Caste;


@Transactional(readOnly = true)
@Repository
public class CasteDaoImpl implements CasteDao {

    private EntityManager entityManager = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find castes.
     */
    public Caste findCasteById(Integer id) {
        return entityManager.find(Caste.class, id);
    }
    /**
     * Find castes.
     */
    @SuppressWarnings("unchecked")
    public Collection<Caste> findAllCastes() {
    	return entityManager.createQuery("select p from Caste p").getResultList();
	}

    /**
     * Find castes using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")    
	public Collection<Caste> findCastes(int startIndex, int maxResults) {
        return entityManager.createQuery("select p from Caste p")
        .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
	}

    /**
     * Saves caste.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Caste save(Caste caste) {
        return entityManager.merge(caste);
    }

    /**
     * Deletes caste.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(Caste caste) {
        entityManager.remove(entityManager.merge(caste));
    }

    /**
     * Saves address to caste.
     */
/*    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Caste saveAddress(Integer id, Address address) {
        Caste caste = findCasteById(id);

        if (caste.getAddresses().contains(address)) {
            caste.getAddresses().remove(address);
        }

        caste.getAddresses().add(address);        

        return save(caste);
    }
*/
    /**
     * Deletes address from caste.
     */
    /*
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public Caste deleteAddress(Integer id, Integer addressId) {
        Caste caste = findCasteById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (caste.getAddresses().contains(address)) {
            for (Address a : caste.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    entityManager.remove(a);
                    caste.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return caste;
    }
*/
}
