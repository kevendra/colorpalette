package com.parakhcomputer.web.bean;

import java.util.Collection;
import java.util.Date;

import com.parakhcomputer.util.AppConstant;

public class Appendix6a {

 
    private Integer personId = null;
	private Integer srId;
	private Integer rollId;
	private Integer scholarId;    
    private String firstName;
    private String middleName;
    private String lastName;
    private String fatherFirstName;
    private String fatherMiddleName;
    private String fatherLastName;
    private String motherFirstName;
    private String motherMiddleName;
    private String motherLastName;
	private String session=AppConstant.SESSION;
	private int class_;
	private String section;    
    private Date doB;
//    private String poB;
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
    
    private Collection <Appendix6aSubject> appendix6aSubjects = null;

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}


	public Integer getSrId() {
		return srId;
	}

	public void setSrId(Integer srId) {
		this.srId = srId;
	}

	public Integer getRollId() {
		return rollId;
	}

	public void setRollId(Integer rollId) {
		this.rollId = rollId;
	}

	public Integer getScholarId() {
		return scholarId;
	}

	public void setScholarId(Integer scholarId) {
		this.scholarId = scholarId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public String getFatherMiddleName() {
		return fatherMiddleName;
	}

	public void setFatherMiddleName(String fatherMiddleName) {
		this.fatherMiddleName = fatherMiddleName;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getMotherFirstName() {
		return motherFirstName;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}

	public String getMotherMiddleName() {
		return motherMiddleName;
	}

	public void setMotherMiddleName(String motherMiddleName) {
		this.motherMiddleName = motherMiddleName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getClass_() {
		return class_;
	}

	public void setClass_(int class_) {
		this.class_ = class_;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getDoB() {
		return doB;
	}

	public void setDoB(Date doB) {
		this.doB = doB;
	}

//	public String getPoB() {
//		return poB;
//	}
//
//	public void setPoB(String poB) {
//		this.poB = poB;
//	}
    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

    public String getTeacherComment() {
		return teacherComment;
	}


	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}
    	
//	public String getStreet1() {
//		return street1;
//	}
//
//	public void setStreet1(String street1) {
//		this.street1 = street1;
//	}
//
//	public String getStreet2() {
//		return street2;
//	}
//
//	public void setStreet2(String street2) {
//		this.street2 = street2;
//	}
//
//	public String getCity() {
//		return city;
//	}
//
//	public void setCity(String city) {
//		this.city = city;
//	}
//
//	public int getZipPin() {
//		return zipPin;
//	}
//
//	public void setZipPin(int zipPin) {
//		this.zipPin = zipPin;
//	}
//
//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}
//
//	public String getCountry() {
//		return country;
//	}
//
//	public void setCountry(String country) {
//		this.country = country;
//	}
//
//	public int getPhone1() {
//		return phone1;
//	}
//
//	public void setPhone1(int phone1) {
//		this.phone1 = phone1;
//	}
//
//	public int getPhone2() {
//		return phone2;
//	}
//
//	public void setPhone2(int phone2) {
//		this.phone2 = phone2;
//	}
//
//	public String getEmailId() {
//		return emailId;
//	}
//
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getCasteId() {
		return casteId;
	}

	public void setCasteId(Integer casteId) {
		this.casteId = casteId;
	}

	
	public String getCwsnId() {
		return cwsnId;
	}


	public void setCwsnId(String cwsnId) {
		this.cwsnId = cwsnId;
	}


	public Collection<Appendix6aSubject> getAppendix6aSubjects() {
		return appendix6aSubjects;
	}

	public void setAppendix6aSubjects(
			Collection<Appendix6aSubject> appendix6aSubjects) {
		this.appendix6aSubjects = appendix6aSubjects;
	} 
    
    
}
