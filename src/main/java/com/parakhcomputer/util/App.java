package com.parakhcomputer.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.parakhcomputer.pdf.Appendix8;
import com.parakhcomputer.web.dao.PersonDao;

public class App 
{

    @Autowired
    protected static PersonDao personDao = null;
    
    public static void main( String[] args ) throws Exception
    {
    	
    	System.out.println("class 1"+findGradeBand(1));
    	System.out.println("class 2"+findGradeBand(2));
    	System.out.println("class 3"+findGradeBand(3));
    	System.out.println("class 4"+findGradeBand(4));
    	System.out.println("class 5"+findGradeBand(5));
    	System.out.println("class 6"+findGradeBand(6));
    	System.out.println("class 7"+findGradeBand(7));
    	System.out.println("class 8"+findGradeBand(8));
/*    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
    	webapp/
    	  */  	
    //	ApplicationContext context =     	  new ClassPathXmlApplicationContext(new String[] {"spring/web-application-context.xml"});
    	

//    	new MarksSheetPage1().page1();
//    	new MarksSheetPage2().page2(6);
//    	Appendix8 appendix7 = new Appendix8();
//    	appendix7.setRealPath("C:\\workspaceEclipse\\evaluation\\src\\main\\resources");
//    	appendix7.appendix8(2);
    	
//    	AppUtility appUtility = new AppUtility();
    	
    }
    
    public static int findGradeBand(int classId){
    	int gradeBand =0;
    	if(classId>=1 && classId<=2){
    		return 990;
    	}else if(classId>=3 && classId<=5){
    		return 1220;
    	}else if(classId>=6 && classId<=8){
    		return 1800;
    	}
    	return gradeBand;
    }
    
//    public static void main(String[] args) {
//        GregorianCalendar liftOffApollo11 = new GregorianCalendar(1969, Calendar.JULY, 16, 9, 32);
//        Date d = liftOffApollo11.getTime();
//        DateFormat df1 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
//        DateFormat df2 = DateFormat.getTimeInstance(DateFormat.SHORT);
//        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL);
//        
//        String s1 = df1.format(d);
//        String s2 = df2.format(d);
//        String s3 = df3.format(d);
//        String s4 =  new SimpleDateFormat("EEE, dd MMM yyyy").format(d);
//        System.out.println(s1);
//        System.out.println(s4);
//        System.out.println(s3);
//     }    
}