package com.parakhcomputer.web.model;

// Generated Mar 2, 2011 10:24:17 PM by Hibernate Tools 3.3.0.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Exam generated by hbm2java
 */
@Entity
@Table(name = "exam")
public class Exam implements java.io.Serializable {

	private static final long serialVersionUID = -3659633557452217134L;
	private Integer examId;
	private String name;
	private Date date;
//	private Set<Marks> marks = new HashSet<Marks>(0);
	private Date created = null;

	public Exam() {
	}

	public Exam(String name) {
		this.name = name;
	}

	public Exam(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Exam_ID", unique = true, nullable = false)
	public Integer getExamId() {
		return this.examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	@Column(name = "Name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date", length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "exam")
	   /**
	    * Gets list of <code>Marks</code>es.
	    */
/*	   @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	   @JoinColumn(name="EXAM_ID", nullable=false)	
	public Set<Marks> getMarks() {
		return this.marks;
	}

	public void setMarks(Set<Marks> marks) {
		this.marks = marks;
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

        result = prime * result + ((this.examId == null) ? 0 : this.examId.hashCode());

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
/*
 * TODO
        final Caste other = (Caste) obj;

        if (this.casteId == null) {
            if (other.casteId != null)
                return false;
        } else if (!this.casteId.equals(other.casteId)) {
            return false;
        }

*/
        return true;
    }

}

