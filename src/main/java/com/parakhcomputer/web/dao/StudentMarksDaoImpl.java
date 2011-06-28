package com.parakhcomputer.web.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.parakhcomputer.web.model.StudentMarks;

@Transactional(readOnly = true)
@Repository
public class StudentMarksDaoImpl implements StudentMarksDao {

    private EntityManager entityManager = null;

    /**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Find studentMarks.
     */
    public StudentMarks findStudentMarksById(Integer id) {
        return entityManager.find(StudentMarks.class, id);
    }
    /**
     * Find studentMarks.
     */
    @SuppressWarnings("unchecked")
    public Collection<StudentMarks> findAllStudentMarks() {
    	return entityManager.createQuery("select p from StudentMarks p").getResultList();
	}
    @SuppressWarnings("unchecked")
    public Collection<StudentMarks> findStudentMarksByPersonId(Integer id) {
        return entityManager.createQuery("select p from StudentMarks p where p.personId = :personId order by p.subjectId, p.examId")
        .setParameter("personId", id).getResultList();    	
	}
    /**
     * Find studentMarks using a start index and max number of results.
     */
    @SuppressWarnings("unchecked")    
	public Collection<StudentMarks> findStudentMarks(int startIndex, int maxResults) {
        return entityManager.createQuery("select p from StudentMarks p")
        .setFirstResult(startIndex).setMaxResults(maxResults).getResultList();
	}

    /**
     * Saves studentMarks.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public StudentMarks save(StudentMarks studentMarks) {
        return entityManager.merge(studentMarks);
    }

    /**
     * Deletes studentMarks.
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void delete(StudentMarks studentMarks) {
        entityManager.remove(entityManager.merge(studentMarks));
    }

    @SuppressWarnings("unchecked")
    public void deleteStudentMarksByPersonId(Integer id) {
/*
  String hql = "delete from Insurance insurance where id = 2";
      Query query = sess.createQuery(hql);
      int row = query.executeUpdate();    	
 */
//   	 String hql = "delete from StudentMarks p where p.personId = :personId ";
	 String hql = "delete from StudentMarks p where p.personId =  " +id;
    		       Query query = entityManager.createQuery(hql);
    		       query.executeUpdate();
//        return entityManager.createQuery("delete from StudentMarks p where p.personId = :personId ")        .setParameter("personId", id).getResultList();    	
	}
/*    public void finalMarksPerSubject(){
    	
    		      Query query=entityManager.createQuery("select personId, subjectId, Sum(obtain) from StudentMarks"
+" where  personId = 5"
+" group by personId, subjectId");
    		      List list=query.getResultList();
    		      Iterator iterator=list.iterator();
    		      while(iterator.hasNext()){    		    	 
    		    	  Object[] row = (Object[]) iterator.next();
  					System.out.println("Invested Amount: " + row[0] + " : "+ row[1] + " : "+ row[2]);
//    		    	StudentMarks studentMarks=iterator.next();
//					System.out.print("PersonId Name:"+studentMarks.getPersonId());
//					System.out.print("SubjectId Name:"+studentMarks.getSubjectId());
//					System.out.print("Obtain Name:"+studentMarks.getObtain());
					System.out.println();
    		      }*/
    
    /*

-- total appendix8[0]
select count(a.person_ID) from person a
where a.School_ID = 2
and a.Class = 4

-- total appendix8[1]
select count(b.StudentMarks_ID) from person a, student_marks b
where a.person_ID = b.Person_ID
and a.School_ID = 2
and a.Class = 4
and b.Subject_ID in(1, 24) 
and b.Exam_ID = 12
and b.Obtain != 0     
     */
    		public Long studentRegistered(int schoolId, int classId){
    			Query query=entityManager.createQuery("" +
    					" select count(a.personId) from Person a " +
    					" where a.schoolId = :schoolId " +
    					" and a.class_ = :class_ ")
    			        .setParameter("class_", classId)
    					.setParameter("schoolId", schoolId); 
    			return (Long) query.getSingleResult();			
    					
    		}
    		/**
    					" select count(b.studentMarksId) from Person a, StudentMarks b " +
    					" where a.personId = b.personId " +
    					" and b.subjectId in(1, 24) " +
    					" and b.examId = 12 " +
    					" and b.obtain != 0  " +
    					" and a.schoolId = :schoolId " +
    					" and a.class_ = :class_ ")    		 
    		 * same as school8
    		 */
    		public Long studentAppeared (int schoolId, int classId){
//	      		" /* total appear in class  */ " +
		    	  StringBuffer stringBuffer = new StringBuffer();
	    		  stringBuffer.append(" select count(personId)   from Person ");
	    		  stringBuffer.append(" where personId not in ");
	    		  stringBuffer.append(" ( select distinct  a.personId from Person a, StudentMarks b ");
	    		  stringBuffer.append(" where a.personId = b.personId ");
	    		  stringBuffer.append(" and a.schoolId = :schoolId ");
	    		  stringBuffer.append(" and b.subjectId in(1, 2, 3, 24,25,26,27,28,29)  ");  //TODO add 4 to b.subjectId but for 1st and 2ed 4 not require 
	    		  stringBuffer.append(" and b.examId = 12 ");
	    		  stringBuffer.append(" and a.class_ = :class_  ");
	    		  stringBuffer.append(" and b.obtain = 0 )  ");
	    		  stringBuffer.append(" and schoolId = :schoolId ");
	    		  stringBuffer.append(" and class_ = :class_  ");

	    		  Query query=entityManager.createQuery("" + stringBuffer.toString())
    			        .setParameter("class_", classId)
    					.setParameter("schoolId", schoolId); 
    			return (Long) query.getSingleResult();    			
    		}
     
    
    		   	/*
-- column 11-30 and 33
select b.person_ID, b.Subject_ID, Sum(b.obtain) from person a,  student_marks b
where a.person_ID = b.Person_ID
and a.School_ID = 2
and a.Class = 4
group by b.Person_ID, b.Subject_ID
order by a.Sr_ID, b.Person_ID, b.Subject_ID
    		   	 
    		   	 */
    		      public List finalTotalMarksPerSubject(int schoolId, int classId){
    		      	
        		      Query query=entityManager.createQuery("" +
        		      		" select b.personId, b.subjectId, Sum(b.obtain) from Person a,  StudentMarks b " +
        					" where a.personId = b.personId " +
	    					" and a.schoolId = :schoolId " +
        		      		" and a.class_ = :class_ " +
						    " group by b.personId, b.subjectId "+
						    " order by b.personId, b.subjectId ")
		  			        .setParameter("class_", classId)
		  					.setParameter("schoolId", schoolId); 
						    
        		      
//        		      List list=query.getResultList();
//        		      Iterator iterator=list.iterator();
//        		      while(iterator.hasNext()){    		    	 
//        		    	  Object[] row = (Object[]) iterator.next();
//      					System.out.println("Invested Amount: " + row[0] + " : "+ row[1] + " : "+ row[2]);
//        		      }  
        		      return query.getResultList();
    }

    		      public List finalTotalMarksPerSubjectPlusProject(int schoolId, int classId){
      		      	
        		      Query query=entityManager.createQuery("" +
        		      		" select b.personId, b.subjectId, (Sum(b.obtain)- c.obtain), c.obtain, Sum(b.obtain) " +
        		      		" from Person a,  StudentMarks b ,  StudentMarks c " +
        					" where a.personId = b.personId " +
	    					" and b.personId = c.personId " +
	    					" and b.subjectId = c.subjectId " +
	    					" and c.examId = 13 " +
	    					" and a.schoolId = :schoolId " +
        		      		" and a.class_ = :class_ " +
						    " group by b.personId, b.subjectId "+
						    " order by b.personId, b.subjectId ")
		  			        .setParameter("class_", classId)
		  					.setParameter("schoolId", schoolId); 
						    
        		      return query.getResultList();
    }
    	    		      
    		      
//
//    		      select A1.class, A1.total,  A2.total,  A3.total,  A4.total,  A5.total,
//    		       A6.total,  A7.total,  A8.total,  A9.total,  A10.total 
//    		       from
//    		      /* Male student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total  from Person a
//    		      where schoolId = 2
//    		      and gender = 'M'
//    		      group by a.class_
//    		      )A1,
//    		      /* Female student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a
//    		      where a.schoolId = 2
//    		      and a.gender = 'F'
//    		      group by a.class_
//    		      )A2,
//    		      /* total in class  */
//    		      (
//    		      select a.class_ as class, count(personId) as total from Person a
//    		      where a.schoolId = 2
//    		      group by a.class_
//    		      )A3,
//    		      /* SC aaja student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a
//    		      where a.schoolId = 2
//    		      and a.casteId = 3
//    		      group by a.class_
//    		      )A4,
//    		      /* ST Ajajaa student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a
//    		      where a.schoolId = 2
//    		      and a.casteId = 2
//    		      group by a.class_
//    		      )A5,
//    		      /* total appear Male student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b
//    		      where a.personId = b.personId
//    		      and a.gender = 'M'
//    		      and a.schoolId = 2
//    		      and b.subjectId in(1, 24) 
//    		      and b.examId = 12
//    		      and b.obtain != 0
//    		      group by a.class_
//    		      )A6,
//    		      /* total appear Female student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b
//    		      where a.personId = b.personId
//    		      and a.gender = 'F'
//    		      and a.schoolId = 2
//    		      and b.subjectId in(1, 24) 
//    		      and b.examId = 12
//    		      and b.obtain != 0
//    		      group by a.class_
//    		      )A7,
//    		      /* total appear in class  */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b
//    		      where a.personId = b.personId
//    		      and a.schoolId = 2
//    		      and b.subjectId in(1, 24) 
//    		      and b.examId = 12
//    		      and b.obtain != 0
//    		      group by a.class_
//    		      )A8,
//    		      /* total appear SC aaja student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b
//    		      where a.personId = b.personId
//    		      and a.casteId = 3
//    		      and a.schoolId = 2
//    		      and b.subjectId in(1, 24) 
//    		      and b.examId = 12
//    		      and b.obtain != 0
//    		      group by a.class_
//    		      )A9,
//    		      /* total appear ST Ajajaa student */
//    		      (
//    		      select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b
//    		      where a.personId = b.personId
//    		      and a.casteId = 2
//    		      and a.schoolId = 2
//    		      and b.subjectId in(1, 24) 
//    		      and b.examId = 12
//    		      and b.obtain != 0
//    		      group by a.class_
//    		      )A10
//    		      where
//    		      A1.Class =A2.Class
//    		      and A2.Class = A3.Class
//    		      and A3.Class = A4.Class
//    		      and A4.Class = A5.Class
//    		      and A5.Class = A6.Class
//    		      and A6.Class = A7.Class
//    		      and A7.Class = A8.Class
//    		      and A8.Class = A9.Class
//    		      and A9.Class = A10.Class
//    		      order by A1.Class
//    		      
    		      
//    		      public List finalTotalStudentPerSchool(int schoolId){    		    	  
//        		      
//        		      Query query=entityManager.createQuery("" +
//          		      		" select A1.class, A1.total,  A2.total,  A3.total,  A4.total,  A5.total, " +
//        		      		"  A6.total,  A7.total,  A8.total,  A9.total,  A10.total  " +
//        		      		"  from " +
////        		      		" /* Male student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total  from Person a " +
//        		      		" where schoolId = :schoolId " +
//        		      		" and gender = 'M' " +
//        		      		" group by a.class_ " +
//        		      		" )A1, " +
////        		      		" /* Female student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a " +
//        		      		" where a.schoolId = :schoolId " +
//        		      		" and a.gender = 'F' " +
//        		      		" group by a.class_ " +
//        		      		" )A2, " +
////        		      		" /* total in class  */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(personId) as total from Person a " +
//        		      		" where a.schoolId = :schoolId " +
//        		      		" group by a.class_ " +
//        		      		" )A3, " +
////        		      		" /* SC aaja student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a " +
//        		      		" where a.schoolId = :schoolId " +
//        		      		" and a.casteId = 3 " +
//        		      		" group by a.class_ " +
//        		      		" )A4, " +
////        		      		" /* ST Ajajaa student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a " +
//        		      		" where a.schoolId = :schoolId " +
//        		      		" and a.casteId = 2 " +
//        		      		" group by a.class_ " +
//        		      		" )A5, " +
////        		      		" /* total appear Male student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b " +
//        		      		" where a.personId = b.personId " +
//        		      		" and a.gender = 'M' " +
//        		      		" and a.schoolId = :schoolId " +
//        		      		" and b.subjectId in(1, 24)  " +
//        		      		" and b.examId = 12 " +
//        		      		" and b.obtain != 0 " +
//        		      		" group by a.class_ " +
//        		      		" )A6, " +
////        		      		" /* total appear Female student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b " +
//        		      		" where a.personId = b.personId " +
//        		      		" and a.gender = 'F' " +
//        		      		" and a.schoolId = :schoolId " +
//        		      		" and b.subjectId in(1, 24)  " +
//        		      		" and b.examId = 12 " +
//        		      		" and b.obtain != 0 " +
//        		      		" group by a.class_ " +
//        		      		" )A7, " +
////        		      		" /* total appear in class  */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b " +
//        		      		" where a.personId = b.personId " +
//        		      		" and a.schoolId = :schoolId " +
//        		      		" and b.subjectId in(1, 24)  " +
//        		      		" and b.examId = 12 " +
//        		      		" and b.obtain != 0 " +
//        		      		" group by a.class_ " +
//        		      		" )A8, " +
////        		      		" /* total appear SC aaja student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b " +
//        		      		" where a.personId = b.personId " +
//        		      		" and a.casteId = 3 " +
//        		      		" and a.schoolId = :schoolId " +
//        		      		" and b.subjectId in(1, 24)  " +
//        		      		" and b.examId = 12 " +
//        		      		" and b.obtain != 0 " +
//        		      		" group by a.class_ " +
//        		      		" )A9, " +
////        		      		" /* total appear ST Ajajaa student */ " +
//        		      		" ( " +
//        		      		" select a.class_ as class, count(a.personId) as total from Person a, StudentMarks b " +
//        		      		" where a.personId = b.personId " +
//        		      		" and a.casteId = 2 " +
//        		      		" and a.schoolId = :schoolId " +
//        		      		" and b.subjectId in(1, 24)  " +
//        		      		" and b.examId = 12 " +
//        		      		" and b.obtain != 0 " +
//        		      		" group by a.class_ " +
//        		      		" )A10 " +
//        		      		" where " +
//        		      		" A1.Class =A2.Class " +
//        		      		" and A2.Class = A3.Class " +
//        		      		" and A3.Class = A4.Class " +
//        		      		" and A4.Class = A5.Class " +
//        		      		" and A5.Class = A6.Class " +
//        		      		" and A6.Class = A7.Class " +
//        		      		" and A7.Class = A8.Class " +
//        		      		" and A8.Class = A9.Class " +
//        		      		" and A9.Class = A10.Class " +
//        		      		" order by A1.Class " )
//		  					.setParameter("schoolId", schoolId); 
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
////		  					.setParameter("schoolId", schoolId)
//						    
// 
//        		      return query.getResultList();
//    }
    		      
//								finalTotalMaleStudentPerSchool
    		      public List finalTotalStudentPerSchool1(int schoolId, String appendix8Type){    		    	  
//  		      		" /* Male student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select a.class_, count(a.personId)  from Person a ");
		    		  stringBuffer.append(" where a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and a.gender = 'M' ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by a.class_ ");
		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 

		    		  return query.getResultList();
    		      }
    		      public List finalTotalStudentPerSchool2(int schoolId, String appendix8Type){    		    	  
//  		      		" /* Female student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select a.class_, count(a.personId)  from Person a ");
		    		  stringBuffer.append(" where a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and a.gender = 'F' ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by a.class_ ");
		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }
    		      public List finalTotalStudentPerSchool3(int schoolId, String appendix8Type){    		    	  
//  		      		" /* total in class  */ " +
    		    	  
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select a.class_, count(personId) from Person a ");
		    		  stringBuffer.append(" where a.schoolId = :schoolId ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by a.class_ ");
		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 

		      		return query.getResultList();
    		      }
    		      public List finalTotalStudentPerSchool4(int schoolId, String appendix8Type){    		    	  
//		      		" /* SC aaja student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select a.class_, count(a.personId) from Person a ");
		    		  stringBuffer.append(" where a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and a.casteId = 3 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by a.class_ ");
		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }
    		      public List finalTotalStudentPerSchool5(int schoolId, String appendix8Type){    		    	  
//		      		" /* ST Ajajaa student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select a.class_, count(a.personId) from Person a ");
		    		  stringBuffer.append(" where a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and a.casteId = 2 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by a.class_ ");
		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }
/*
select class, count(person_ID)   from person
where (class , person_ID) in
(select distinct a.class as class, a.person_ID from person a, student_marks b
where a.person_ID = b.Person_ID
and b.Subject_ID in(1, 2, 3,4, 24,25,26,27,28,29) 
and b.Exam_ID = 12
and b.Obtain != 0) 
group by class

		    		  
 */	
    		      /**
    		       * return no of total student appear 
    		       * if student obtain 0 in any subject final Exam then it considered as absence 
    		       */
    		      public List finalTotalStudentPerSchool6(int schoolId, String appendix8Type){    		    	  
//		      		" /* total appear Male student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select class_, count(personId)   from Person ");
		    		  stringBuffer.append(" where personId not in ");
		    		  stringBuffer.append(" ( select distinct  a.personId from Person a, StudentMarks b ");
		    		  stringBuffer.append(" where a.personId = b.personId ");
		    		  stringBuffer.append(" and a.gender = 'M' ");
		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and b.subjectId in(1, 2, 3, 24,25,26,27,28,29)  ");  //TODO add 4 to b.subjectId but for 1st and 2ed 4 not require 
		    		  stringBuffer.append(" and b.examId = 12 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" and b.obtain = 0 )  ");
		    		  stringBuffer.append(" and schoolId = :schoolId ");
		    		  stringBuffer.append(" and gender = 'M' ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by class_ ");
		    		  stringBuffer.append(" order by class_ ");
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }
    		      /**
    		       * return no of total student appear 
    		       * if student obtain 0 in first language in final exam then it considered as absence 
    		       */
    		      public List finalTotalStudentPerSchool6X(int schoolId, String appendix8Type){    		    	  
//		      		" /* total appear Male student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select a.class_, count(a.personId) from Person a, StudentMarks b ");
		    		  stringBuffer.append(" where a.personId = b.personId ");
		    		  stringBuffer.append(" and a.gender = 'M' ");
		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and b.subjectId in(1, 24)  ");
		    		  stringBuffer.append(" and b.examId = 12 ");
		    		  stringBuffer.append(" and b.obtain != 0 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by a.class_ ");
		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }
    		      public List finalTotalStudentPerSchool7(int schoolId, String appendix8Type){    		    	  
//		      		" /* total appear Female student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select class_, count(personId)   from Person ");
		    		  stringBuffer.append(" where personId not in ");
		    		  stringBuffer.append(" ( select distinct  a.personId from Person a, StudentMarks b ");
		    		  stringBuffer.append(" where a.personId = b.personId ");
		    		  stringBuffer.append(" and a.gender = 'F' ");
		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and b.subjectId in(1, 2, 3, 24,25,26,27,28,29)  ");  //TODO add 4 to b.subjectId but for 1st and 2ed 4 not require 
		    		  stringBuffer.append(" and b.examId = 12 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" and b.obtain = 0 )  ");
		    		  stringBuffer.append(" and schoolId = :schoolId ");
		    		  stringBuffer.append(" and gender = 'F' ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by class_ ");
		    		  stringBuffer.append(" order by class_ ");
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }
    		      public List finalTotalStudentPerSchool8(int schoolId, String appendix8Type){    		    	  
//		      		" /* total appear in class  */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select class_, count(personId)   from Person ");
		    		  stringBuffer.append(" where personId not in ");
		    		  stringBuffer.append(" ( select distinct  a.personId from Person a, StudentMarks b ");
		    		  stringBuffer.append(" where a.personId = b.personId ");
		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and b.subjectId in(1, 2, 3, 24,25,26,27,28,29)  ");  //TODO add 4 to b.subjectId but for 1st and 2ed 4 not require 
		    		  stringBuffer.append(" and b.examId = 12 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" and b.obtain = 0 )  ");
		    		  stringBuffer.append(" and schoolId = :schoolId ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by class_ ");
		    		  stringBuffer.append(" order by class_ ");
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }    		    	  
    		      public List finalTotalStudentPerSchool9(int schoolId, String appendix8Type){    		    	  
//		      		" /* total appear SC aaja student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select class_, count(personId)   from Person ");
		    		  stringBuffer.append(" where personId not in ");
		    		  stringBuffer.append(" ( select distinct  a.personId from Person a, StudentMarks b ");
		    		  stringBuffer.append(" where a.personId = b.personId ");
		    		  stringBuffer.append(" and a.casteId = 3 ");
		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and b.subjectId in(1, 2, 3, 24,25,26,27,28,29)  ");  //TODO add 4 to b.subjectId but for 1st and 2ed 4 not require 
		    		  stringBuffer.append(" and b.examId = 12 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" and b.obtain = 0 )  ");
		    		  stringBuffer.append(" and schoolId = :schoolId ");
		    		  stringBuffer.append(" and casteId = 3 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by class_ ");
		    		  stringBuffer.append(" order by class_ ");
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }    		    	  
    		      public List finalTotalStudentPerSchool10(int schoolId, String appendix8Type){    		    	  
//		      		" /* total appear ST Ajajaa student */ " +
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select class_, count(personId)   from Person ");
		    		  stringBuffer.append(" where personId not in ");
		    		  stringBuffer.append(" ( select distinct  a.personId from Person a, StudentMarks b ");
		    		  stringBuffer.append(" where a.personId = b.personId ");
		    		  stringBuffer.append(" and a.casteId = 2 ");
		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
		    		  stringBuffer.append(" and b.subjectId in(1, 2, 3, 24,25,26,27,28,29)  ");  //TODO add 4 to b.subjectId but for 1st and 2ed 4 not require 
		    		  stringBuffer.append(" and b.examId = 12 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" and b.obtain = 0 )  ");
		    		  stringBuffer.append(" and schoolId = :schoolId ");
		    		  stringBuffer.append(" and casteId = 2 ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and class_ in (6,7,8) ");
    		    	  }
		    		  stringBuffer.append(" group by class_ ");
		    		  stringBuffer.append(" order by class_ ");
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }    		    	  
    		      
/*
        		      		" select a.class_,  a.casteId, a.Gender, b.personId, sum(b.Obtain) from Person a, StudentMarks b " +
        		      		" where a.personId = b.personId " +
        		      		" and a.schoolId = :schoolId " +
        		      		" group by a.class_, a.casteId, a.Gender, b.personId " +
		
        		      		" select a.class_,  a.casteId, a.Gender, b.personId, b.subjectId, sum(b.Obtain) from Person a, StudentMarks b " +
        		      		" where a.personId = b.personId " +
        		      		" and a.schoolId = :schoolId " +
        		      		" and b.subjectId in( 1,2,3,4,5,24,25,26,27,28,29,30) " +
        		      		" group by a.class_, a.casteId, a.Gender, b.personId, b.subjectId " +
     		      
 */
    		      /**
    		       *  total obtain marks per student
    		       */
    		      public List finalTotalMarksPerClassPerSchool(int schoolId, String appendix8Type){
      		      	System.out.println("Appendix 8 col 5 to col 8 grade A,B,C,D");
    		    	  StringBuffer stringBuffer = new StringBuffer();
		    		  stringBuffer.append(" select a.class_,  a.casteId, a.gender, b.personId, sum(b.obtain) from Person a, StudentMarks b ");
  		    		  stringBuffer.append(" where a.personId = b.personId ");
  		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
  		    		  stringBuffer.append(" and b.subjectId not in (21, 22, 46, 47)");
  		    		  
  		    		  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
  		    		  stringBuffer.append(" group by a.class_, a.casteId, a.gender, b.personId ");
  		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 

           		      return query.getResultList();
    		      }
    		      /**
    		       * total marks per student per subject	        		    		  
    		       */
    		      public List finalTotalMarksPerSubjectPerClassPerSchool(int schoolId, String appendix8Type){
        		      	
    		    	  StringBuffer stringBuffer = new StringBuffer();
    		    	  stringBuffer.append(" select a.class_,  a.casteId, a.gender, b.personId, b.subjectId, sum(b.obtain) from Person a, StudentMarks b ");
  		    		  stringBuffer.append(" where a.personId = b.personId ");
  		    		  stringBuffer.append(" and a.schoolId = :schoolId ");
  		    		  stringBuffer.append(" and b.subjectId in( 1,2,3,4,5,24,25,26,27,28,29,30) ");
    		    	  if(appendix8Type.equals("A")){
    		    		  stringBuffer.append(" and a.class_ in (1,2,3,4,5) ");
    		    	  }else{
    		    		  stringBuffer.append(" and a.class_ in (6,7,8) ");
    		    	  }
  		    		  stringBuffer.append(" group by a.class_, a.casteId, a.gender, b.personId, b.subjectId ");
		    		  stringBuffer.append(" order by a.class_ " );
		    		  
		    		  Query query=entityManager.createQuery(stringBuffer.toString())
  		      							.setParameter("schoolId", schoolId); 
		    		  return query.getResultList();
    		      }    		    	  

   /**
     * Saves address to studentMarks.
     */
/*    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public StudentMarks saveAddress(Integer id, Address address) {
        StudentMarks studentMarks = findStudentMarksById(id);

        if (studentMarks.getAddresses().contains(address)) {
            studentMarks.getAddresses().remove(address);
        }

        studentMarks.getAddresses().add(address);        

        return save(studentMarks);
    }
*/
    /**
     * Deletes address from studentMarks.
     */
    /*
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public StudentMarks deleteAddress(Integer id, Integer addressId) {
        StudentMarks studentMarks = findStudentMarksById(id);

        Address address = new Address();
        address.setAddressId(addressId);

        if (studentMarks.getAddresses().contains(address)) {
            for (Address a : studentMarks.getAddresses()) {
                if (a.getAddressId().equals(addressId)) {
                    entityManager.remove(a);
                    studentMarks.getAddresses().remove(address);
                    
                    break;
                }
            }
        }

        return studentMarks;
    }
*/
}
