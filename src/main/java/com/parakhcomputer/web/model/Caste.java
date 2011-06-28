package com.parakhcomputer.web.model;

// Generated Mar 2, 2011 10:24:17 PM by Hibernate Tools 3.3.0.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Caste generated by hbm2java
 */
@Entity
//@Table(name = "caste", catalog = "marks_sheet")
@Table(name = "caste")
public class Caste implements java.io.Serializable {


	private static final long serialVersionUID = -4873318315387784687L;
	private Integer casteId;
	private String name;
	private String description;
//	private Set<Person> person = new HashSet<Person>(0);
    private Date created = null;
	
	public Caste() {
	}

	public Caste(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Caste_ID", unique = true, nullable = false)
	public Integer getCasteId() {
		return this.casteId;
	}

	public void setCasteId(Integer casteId) {
		this.casteId = casteId;
	}

	@Column(name = "Name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description", nullable = false, length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caste")
	   /**
	    * Gets list of <code>School</code>es.
	    */
/*	   @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	   @JoinColumn(name="CASTE_ID", nullable=false)	
	public Set<Person> getPerson() {
		return this.person;
	}

	public void setPerson(Set<Person> person) {
		this.person = person;
	}*/


    /**
     * Gets date created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets date created.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getName() + "-");
//TODO        sb.append("  addressId=" + addressId);
        
        return sb.toString();
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((this.casteId == null) ? 0 : this.casteId.hashCode());

        return result;
    }

    /**
     * Indicates whether some other object is equal to this one.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Caste other = (Caste) obj;

        if (this.casteId == null) {
            if (other.casteId != null)
                return false;
        } else if (!this.casteId.equals(other.casteId)) {
            return false;
        }

        return true;
    }

}

