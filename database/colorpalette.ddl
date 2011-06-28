--CHARACTER SET utf8 
--create procedure identity()  begin end;

CREATE DATABASE `colorpalette` ;


CREATE TABLE Theme							
(							
	Theme_ID		int(10) 	NOT NULL auto_increment	COMMENT	'color Theme ID'	,
	Theme_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Theme Name'	,
	Description		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Theme Description'	,
	Created timestamp,
	CONSTRAINT Theme_PK PRIMARY KEY  (`Theme_ID`)
);


CREATE TABLE Palette							
(							
	Palette_ID		int(10) 	NOT NULL auto_increment	COMMENT	'color palette ID'	,
	Theme_ID		int(10) 	default NULL	COMMENT	'Theme ID'		,
	Name		varchar(100)		CHARACTER SET utf8	NOT NULL default ' '	COMMENT	'Name'	,
	value		varchar(6)		CHARACTER SET utf8	NOT NULL default ' '	COMMENT	'Name'	,
	Created timestamp,
	CONSTRAINT Palette_PK PRIMARY KEY  (`Palette_ID`),
	CONSTRAINT Palette_FK FOREIGN KEY (Theme_ID) REFERENCES Theme(Theme_ID) ON DELETE CASCADE
);




DROP TABLE Student_Marks;							


CREATE TABLE Student_Marks							
(							
	StudentMarks_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Student Marks ID'	,
	Student_ID		int(10) 	default NULL	COMMENT	'Subject ID'	,
	Marks_ID		int(10) 	default NULL	COMMENT	'Marks ID'	,
	Obtain		int(10) 	NOT NULL default '0'	COMMENT	'Obtain'	,
	Teacher_ID		int(10) 	default NULL	COMMENT	'Teacher ID'	,
	Teacher_Comments		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Teacher Comments'	,
	Created timestamp,
	CONSTRAINT Student_Marks_PK PRIMARY KEY  (`StudentMarks_ID`),
  CONSTRAINT Student_Marks_FK1  FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID) ON DELETE CASCADE	,
  CONSTRAINT Student_Marks_FK2  FOREIGN KEY (Marks_ID) REFERENCES Marks(Marks_ID) ON DELETE CASCADE);


DROP TABLE Marks;							

	
CREATE TABLE Marks							
(							
	Marks_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Marks ID'	,
	Subject_ID		int(10) 	NOT NULL default '0'	COMMENT	'Subject ID'	,
	Exam_ID		int(10) 	NOT NULL default '0'	COMMENT	'Exam ID'	,
	Max		int(10) 	NOT NULL default '0'	COMMENT	'Maximum'	,
	Min		int(10) 	NOT NULL default '0'	COMMENT	'Minimum'	,
	Created timestamp,
	CONSTRAINT Marks_PK PRIMARY KEY  (`Marks_ID`),
  CONSTRAINT Marks_FK1  FOREIGN KEY (Subject_ID) REFERENCES Subject_ID(Subject) ON DELETE CASCADE	,
  CONSTRAINT Marks_FK2  FOREIGN KEY (Exam_ID) REFERENCES Exam(Exam_ID) ON DELETE CASCADE);

DROP TABLE Person;							


CREATE TABLE  Person							
(							
	person_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Person ID'	,
	First_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'First Name'	,
	Middle_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Middle Name'	,
	Last_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Last Name'	,
	Father_First_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Father First Name'	,
	Father_Middle_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Father Middle Name'	,
	Father_Last_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Father Last Name'	,
	Mother_First_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Mother First Name'	,
	Mother_Middle_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Mother Middle Name'	,
	Mother_Last_Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Mother Last Name'	,
	DoB		datetime 	default NULL	COMMENT	'Date of Birth'	,
	PoB		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Place of birth'	,
	Student_ID		int(10) 	default NULL	COMMENT	'Student ID'	,
	Caste_ID		int(10) 	default NULL	COMMENT	'Caste ID'	,
	Created timestamp,
	CONSTRAINT Person_PK PRIMARY KEY  (`person_ID`),
    CONSTRAINT Person_FK1 FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID) ON DELETE CASCADE,
    CONSTRAINT Person_FK2 FOREIGN KEY (Caste_ID) REFERENCES Caste(Caste_ID) ON DELETE CASCADE);

DROP TABLE Student;							


CREATE TABLE Student							
(							
	Student_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Student ID'	,
	School_ID		int(10) 	NOT NULL default '0'	COMMENT	'School ID'	,
	Scholar_ID		int(10) 	NOT NULL default '0'	COMMENT	'Scholar ID'	,
	Session		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Session'	,
	Class		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Class'	,
	Section		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Section'	,
	Created timestamp,
	CONSTRAINT Student_PK PRIMARY KEY  (`Student_ID`),
  CONSTRAINT Student_FK1 FOREIGN KEY (School_ID) REFERENCES School(School_ID) ON DELETE CASCADE	);


DROP TABLE School;							

CREATE TABLE School							
(							
	School_ID		int(10) 	NOT NULL auto_increment	COMMENT	'School ID'	,
	Code		varchar(20)	NOT NULL default ''	COMMENT	'Code dice'	,
	Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'School Name'	,
	Created timestamp,
	CONSTRAINT School_PK PRIMARY KEY  (`School_ID`));
  
DROP TABLE Subject;							

CREATE TABLE Subject							
(							
	Subject_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Subject ID'	,
	Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Subject Name'	,
	Description		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Subject Description'	,
	Group_ID		int(10) 	default NULL	COMMENT	'Subject Group ID'	,
	seq		int(10) 	NOT NULL default '0'	COMMENT	'Subject Order'	,
	Created timestamp,
	  CONSTRAINT Subject_PK PRIMARY KEY  (`Subject_ID`),
    CONSTRAINT Subject_FK FOREIGN KEY (Group_ID) REFERENCES Subject_Group(Group_ID) ON DELETE CASCADE	);
		
    
DROP TABLE Address;

CREATE TABLE Address							
(							
	Address_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Address ID'	,
	Street1		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Street 1'	,
	Street2		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Street 2'	,
	City		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'City'	,
	ZIP_PIN		int(10) 	NOT NULL default '0'	COMMENT	'ZIP PIN'	,
	State		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'State'	,
	Country		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Country'	,
	Phone1		int(10) 	NOT NULL default '0'	COMMENT	'Phone 1'	,
	Phone2		int(10) 	NOT NULL default '0'	COMMENT	'Phone 2'	,
	eMail_ID		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'e Mail id'	,
	Person_ID		int(10) 	default NULL	COMMENT	'For Person Address'	,
	School_ID		int(10) 	default NULL	COMMENT	'For School Address'	,
	Created timestamp,
	CONSTRAINT Address_PK1 PRIMARY KEY  (`Address_ID`),
	CONSTRAINT Address_FK1 FOREIGN KEY (Person_ID) REFERENCES Person(Person_ID) ON DELETE CASCADE,
	CONSTRAINT Address_FK2 FOREIGN KEY (School_ID) REFERENCES School(School_ID) ON DELETE CASCADE	);
  
DROP TABLE Exam;

CREATE TABLE Exam							
(							
	Exam_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Exam ID'	,
	Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Exam Name'	,
	Date		datetime 	default NULL	COMMENT	'Exam Date'	,
	Created timestamp,
	CONSTRAINT Exam_FK1 PRIMARY KEY  (`Exam_ID`));

DROP TABLE Subject_Group;	

CREATE TABLE Subject_Group							
(							
	Group_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Subject Group ID'	,
	Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Name'	,
	Description		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Description'	,
	Created timestamp,
	CONSTRAINT Subject_Group_FK1 PRIMARY KEY  (`Group_ID`));

DROP TABLE Caste;

CREATE TABLE Caste							
(							
	Caste_ID		int(10) 	NOT NULL auto_increment	COMMENT	'Caste ID'	,
	Name		varchar(100)	CHARACTER SET utf8	NOT NULL default ''	COMMENT	'Caste Name'	 ,
	Description		varchar(100)	CHARACTER SET utf8 NOT NULL default ''	COMMENT	'Caste Description'	 ,
	Created timestamp,
	CONSTRAINT Caste_FK1 PRIMARY KEY  (`Caste_ID`));
          
          