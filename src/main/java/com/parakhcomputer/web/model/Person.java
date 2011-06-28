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

package com.parakhcomputer.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Annotation configured person bean.
 * 
 * @author David Winterfeldt
 */
@Entity
@Table(name="person")
public class Person implements Serializable {

    private static final long serialVersionUID = -8712872385957386182L;

    private Integer personId = null;
	private int srId;
	private int rollId;
	private int scholarId;
    private String firstName;
    private String middleName= " ";
    private String lastName;
    private String fatherFirstName= " ";
    private String fatherMiddleName= " ";
    private String fatherLastName= " ";
    private String motherFirstName= " ";
    private String motherMiddleName= " ";
    private String motherLastName= " ";
	private String session;
	private int class_;
	private String section;    
    private Date doB;
//    private String poB= " ";
    private String gender;
    private String teacherComment;
//    private String street1;
//    private String street2;
//    private String city;
//    private int zipPin;
//    private String state;
//    private String country;
//    private int phone1;
//    private int phone2;
//    private String emailId;    

    private Integer schoolId;
    private Integer casteId;
    private String cwsnId;
//    private Set<Address> addresses = null;
    private Date created = null;
    

	public Person() {
		
	}


	/*
    public Person(String firstName, String middleName, String lastName, String fatherFirstName, String fatherMiddleName, String fatherLastName, String motherFirstName, String motherMiddleName, String motherLastName, String poB,
    String session, String class_,			String section) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.fatherFirstName = fatherFirstName;
        this.fatherMiddleName = fatherMiddleName;
        this.fatherLastName = fatherLastName;
        this.motherFirstName = motherFirstName;
        this.motherMiddleName = motherMiddleName;
        this.motherLastName = motherLastName;
        this.poB = poB;
        		this.session = session;
		this.class_ = class_;
		this.section = section;
    }
    public Person(String firstName, String middleName, String lastName, String fatherFirstName, String fatherMiddleName, String fatherLastName, String motherFirstName, String motherMiddleName, String motherLastName, Date doB, String poB, Integer addressId, Integer schoolId, Integer casteId) {
       this.firstName = firstName;
       this.middleName = middleName;
       this.lastName = lastName;
       this.fatherFirstName = fatherFirstName;
       this.fatherMiddleName = fatherMiddleName;
       this.fatherLastName = fatherLastName;
       this.motherFirstName = motherFirstName;
       this.motherMiddleName = motherMiddleName;
       this.motherLastName = motherLastName;
       this.doB = doB;
       this.poB = poB;
       this.schoolId = schoolId;
       this.casteId = casteId;
    }
*/
    /**
     * Gets personId (primary key).
     */
//    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="person_ID", unique=true, nullable=false)    
    public Integer getPersonId() {
        return personId;
    }

    /**
     * Sets personId (primary key).
     */
    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    
    @Column(name="Sr_ID", nullable=true)
    public int getSrId() {
		return srId;
	}


	public void setSrId(int srId) {
		this.srId = srId;
	}

	@Column(name="Roll_ID", nullable=true)
	public int getRollId() {
		return rollId;
	}


	public void setRollId(int rollId) {
		this.rollId = rollId;
	}

	@Column(name="Scholar_ID", nullable=true)
	public int getScholarId() {
		return scholarId;
	}


	public void setScholarId(int scholarId) {
		this.scholarId = scholarId;
	}


	/**
     * Gets first name.
     */
    @Column(name="First_Name", nullable=true, length=100)
    public String getFirstName() {
        return this.firstName;
    }
    /**
     * Sets first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
        
    @Column(name="Middle_Name", nullable=true, length=100)
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets last name.
     */
    @Column(name = "Last_Name", nullable=true, length=100)
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    @Column(name="Father_First_Name", nullable=true, length=100)
    public String getFatherFirstName() {
        return this.fatherFirstName;
    }
    
    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    
    @Column(name="Father_Middle_Name", nullable=true, length=100)
    public String getFatherMiddleName() {
        return this.fatherMiddleName;
    }
    
    public void setFatherMiddleName(String fatherMiddleName) {
        this.fatherMiddleName = fatherMiddleName;
    }

    
    @Column(name="Father_Last_Name", nullable=true, length=100)
    public String getFatherLastName() {
        return this.fatherLastName;
    }
    
    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    
    @Column(name="Mother_First_Name", nullable=true, length=100)
    public String getMotherFirstName() {
        return this.motherFirstName;
    }
    
    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    
    @Column(name="Mother_Middle_Name", nullable=true, length=100)
    public String getMotherMiddleName() {
        return this.motherMiddleName;
    }
    
    public void setMotherMiddleName(String motherMiddleName) {
        this.motherMiddleName = motherMiddleName;
    }

    
    @Column(name="Mother_Last_Name", nullable=true, length=100)
    public String getMotherLastName() {
        return this.motherLastName;
    }
    
    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }



	@Column(name = "Session", nullable=true, length = 100)
	public String getSession() {
		return this.session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	@Column(name = "Class", nullable=true)
	public int getClass_() {
		return this.class_;
	}

	public void setClass_(int class_) {
		this.class_ = class_;
	}

	@Column(name = "Section", nullable=true, length = 100)
	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DoB", length=19)
    public Date getDoB() {
        return this.doB;
    }
    
    public void setDoB(Date doB) {
        this.doB = doB;
    }

    
//    @Column(name="PoB", nullable=true, length=100)
//    public String getPoB() {
//        return this.poB;
//    }
//    
//    public void setPoB(String poB) {
//        this.poB = poB;
//    }

    @Column(name="Gender", nullable=true, length=1)
    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Column(name="School_ID")
    public Integer getSchoolId() {
        return this.schoolId;
    }
    
    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    
    @Column(name="Caste_ID")
    public Integer getCasteId() {
        return this.casteId;
    }
    
    public void setCasteId(Integer casteId) {
        this.casteId = casteId;
    }
    
    @Column(name="Cwsn_ID")
	public String getCwsnId() {
		return cwsnId;
	}


	public void setCwsnId(String cwsnId) {
		this.cwsnId = cwsnId;
	}



	@Column(name="Teacher_Comment", nullable=true, length=100)
    public String getTeacherComment() {
		return teacherComment;
	}

	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}
    
//    @Column(name="Street1", nullable=true, length=100)
//    public String getStreet1() {
//        return this.street1;
//    }
//    
//
//	public void setStreet1(String street1) {
//        this.street1 = street1;
//    }
//
//    
//    @Column(name="Street2", nullable=true, length=100)
//    public String getStreet2() {
//        return this.street2;
//    }
//    
//    public void setStreet2(String street2) {
//        this.street2 = street2;
//    }
//
//    
//    @Column(name="City", nullable=true, length=100)
//    public String getCity() {
//        return this.city;
//    }
//    
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    /**
//     * Gets zip or postal code.
//     */   
//    @Column(name="ZIP_PIN", nullable=true)
//    public int getZipPin() {
//        return this.zipPin;
//    }
//    /**
//     * Sets zip or postal code.
//     */   
//    public void setZipPin(int zipPin) {
//        this.zipPin = zipPin;
//    }
//
//    
//    @Column(name="State", nullable=true, length=100)
//    public String getState() {
//        return this.state;
//    }
//    
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    /**
//     * Gets country.
//     */   
//    @Column(name="Country", nullable=true, length=100)
//    public String getCountry() {
//        return this.country;
//    }
//
//    /**
//     * Sets country.
//     */   
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    
//    @Column(name="Phone1", nullable=true)
//    public int getPhone1() {
//        return this.phone1;
//    }
//    
//    public void setPhone1(int phone1) {
//        this.phone1 = phone1;
//    }
//
//    
//    @Column(name="Phone2", nullable=true)
//    public int getPhone2() {
//        return this.phone2;
//    }
//    
//    public void setPhone2(int phone2) {
//        this.phone2 = phone2;
//    }
//
//    
//    @Column(name="eMail_ID", nullable=true, length=100)
//    public String getEmailId() {
//        return this.emailId;
//    }
//    
//    public void setEmailId(String emailId) {
//        this.emailId = emailId;
//    }
//    
    
    /**
     * Gets list of <code>Address</code>es.
     */
/*    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="PERSON_ID", nullable=true)
    public Set<Address> getAddresses() {
        return addresses;
    }

    *//**
     * Sets list of <code>Address</code>es.
     *//*
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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

/*    public Address findAddressById(Integer id) {
        Address result = null;

        if (addresses != null) {
            for (Address address : addresses) {
                if (address.getAddressId().equals(id)) {
                    result = address;

                    break;
                }
            }
        }

        return result;
    }*/

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getName() + "-");
        sb.append("  personId=" + personId);
        sb.append("  firstName=" + firstName);
        sb.append("  lastName=" + lastName);

        sb.append("  addresses=[");
/*
        if (addresses != null) {
            for (Address address : addresses) {
                sb.append(address.toString());
            }
        }
*/
        sb.append("]");

        sb.append("  created=" + created);

        return sb.toString();
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((personId == null) ? 0 : personId.hashCode());

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
        final Person other = (Person) obj;

        if (personId == null) {
            if (other.personId != null) {
                return false;
            }
        } else if (!personId.equals(other.personId)) {
            return false;
        }

        return true;
    }

}
