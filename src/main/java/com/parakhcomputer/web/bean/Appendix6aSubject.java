package com.parakhcomputer.web.bean;

import java.util.Collection;


public class Appendix6aSubject {

 
	private Integer subjectId;
	private String name;
//	private String description;
	private Integer groupId;
//	private int seq;
//	private int max;
//	private int min;
	
	private Collection<Appendix6aExam> appendix6aExams = null;

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Collection<Appendix6aExam> getAppendix6aExams() {
		return appendix6aExams;
	}

	public void setAppendix6aExams(Collection<Appendix6aExam> appendix6aExams) {
		this.appendix6aExams = appendix6aExams;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	} 
	
	
}
