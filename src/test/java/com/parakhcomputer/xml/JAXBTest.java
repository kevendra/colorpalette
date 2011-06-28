package com.parakhcomputer.xml;


import generated.Colors;
import generated.ObjectFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.EventFilter;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;


public class JAXBTest {
/**
<purchaseOrder>
    <comment>comment</comment>
    <items>
        <item partNum="test">
            <productName>productname</productName>
            <quantity>2</quantity>
            <comment>part comment</comment>
        </item>
    </items>
</purchaseOrder>	
 * @throws JAXBException
 */
/*	@Test
	public void testMarshall() throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance("generated");
		generated.ObjectFactory factory = new generated.ObjectFactory();
		generated.PurchaseOrderType type = factory.createPurchaseOrderType();
		type.setComment("comment");
		generated.Items items = factory.createItems();
		generated.Items.Item o = factory.createItemsItem();
		o.setPartNum("test");
		o.setComment("part comment");
		o.setProductName("productname");
		o.setQuantity(2);
		 
		items.getItem().add(o);
		items.getItem().add(o);
		type.setItems(items);
		 
		JAXBElement<generated.PurchaseOrderType> element = factory.createPurchaseOrder(type);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(element, System.out);
		}
	*/
	@Test
	public void testColorMarshall() throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance("generated");
		ObjectFactory factory = new ObjectFactory();
		Colors colors = factory.createColors();
		Colors.Color color = factory.createColorsColor();
		color.setName("n1");
		color.setValue("v1");
		colors.getColor().add(color);
		 
		color.setName("n2");
		color.setValue("v2");
		colors.getColor().add(color);
		 
		JAXBElement<Colors> element = factory.createColors(colors);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		m.marshal(element, System.out);
		
		
		try {
		    File file = new File("palette.xml");

		    // Create file if it does not exist
		    boolean success = file.createNewFile();
		    if (success) {
		    	m.marshal(element,file);
		        // File did not exist and was created
		    } else {
		        // File already exists
		    }
		} catch (IOException e) {
		}		
		
	}
	
	@Test
	//@Ignore
    public void parseEntireDocument() throws JAXBException {
		//beginning and the end of the test methods:
		System.gc(); System.gc();
        long memstart = Runtime.getRuntime().freeMemory();
        // Parsing code ...
        System.gc(); System.gc();
        long memend = Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + (memstart - memend)); 
        		
		JAXBContext ctx = JAXBContext.newInstance("generated");
//      JAXBContext ctx = JAXBContext.newInstance(new Class[] {Colors.class});
        Unmarshaller um = ctx.createUnmarshaller();
        Object o = um.unmarshal(new File("palette.xml"));
//        JAXBElement<Colors>  colors =  um.unmarshal(new File("palette.xml"));
  //      Assert.assertEquals(2, colors.getColor().size());
        
        
        
        

 try{
       JAXBContext jc = JAXBContext.newInstance( "generated" );
       Unmarshaller u = jc.createUnmarshaller();
 
       DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
       dbf.setNamespaceAware(true);
       DocumentBuilder db = dbf.newDocumentBuilder();
       Document doc = db.parse(new File( "palette.xml"));
  //     Element  fooSubtree = ...; // traverse DOM till reach xml element foo, constrained by a 
                                  // local element declaration in schema.
 
       // FooType is the JAXB mapping of the type of local element declaration foo.
//       JAXBElement<Colors> colors = u.unmarshal( fooSubtree, Colors.class); 
       System.out.println("tets");
 }catch(Exception e){
	 
 }
        
        
    	//beginning and the end of the test methods:
        
        System.gc(); System.gc();
        memstart = Runtime.getRuntime().freeMemory();
        // Parsing code ...
        System.gc(); System.gc();
        memend = Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + (memstart - memend));         
   }
	
	@Test
	//@Ignore
	 public void parseEfficiently() throws FileNotFoundException, XMLStreamException, JAXBException, IOException {
		
		
		//beginning and the end of the test methods:
		System.gc(); System.gc();
        long memstart = Runtime.getRuntime().freeMemory();
        // Parsing code ...
        System.gc(); System.gc();
        long memend = Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + (memstart - memend)); 
        
		
        // Parse the data, filtering out the start elements
        XMLInputFactory xmlif = XMLInputFactory.newInstance();
        FileReader fr = new FileReader("pallete.xml");
        XMLEventReader xmler = xmlif.createXMLEventReader(fr);
        
        EventFilter filter = new EventFilter() {
            public boolean accept(XMLEvent event) {
                return event.isStartElement();
            }
        };
        
        XMLEventReader xmlfer = xmlif.createFilteredReader(xmler, filter);
        // Jump to the first element in the document, the enclosing BugCollection
        StartElement e = (StartElement) xmlfer.nextEvent();
        Assert.assertEquals("colors", e.getName().getLocalPart()); 
        // Parse into typed objects
        JAXBContext ctx = JAXBContext.newInstance("generated");
        Unmarshaller um = ctx.createUnmarshaller();
        int colorCount = 0;
        while (xmlfer.peek() != null) {
             Object o = um.unmarshal(xmler);
             if (o instanceof Colors) {
                 Colors bi = (Colors) o;
                 // process the color instance
                 colorCount++;
             }
        }
        Assert.assertEquals(2, colorCount);
        fr.close();
        
        
    	//beginning and the end of the test methods:
        
        System.gc(); System.gc();
        memstart = Runtime.getRuntime().freeMemory();
        // Parsing code ...
        System.gc(); System.gc();
        memend = Runtime.getRuntime().freeMemory();
        System.out.println("Memory used: " + (memstart - memend));         
     }         
	
}
