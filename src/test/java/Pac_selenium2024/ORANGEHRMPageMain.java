package Pac_selenium2024;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ORANGEHRMPageMain {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		 File xmlFile=new File("C:\\Users\\rohan.chari\\eclipse-workspace\\JAN2024_Selenium\\logindata2.xml");
	     DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
	     DocumentBuilder dbuilder=DBFactory.newDocumentBuilder();
	     Document doc=dbuilder.parse(xmlFile);
	     NodeList nl=doc.getChildNodes();
	     Node n=nl.item(0);
	     Element ele=(Element)n;
	     String url=ele.getElementsByTagName("url").item(0).getTextContent();
	     String uname=ele.getElementsByTagName("username").item(0).getTextContent();
	     String pword=ele.getElementsByTagName("password").item(0).getTextContent();
	     
	     
	  
		    WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get(url);
	        System.out.println(driver.getTitle());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        ORHRM_PageFactory obj= PageFactory.initElements(driver,ORHRM_PageFactory.class);
	        obj.enterusername("Admin");
	        obj.enterpassword("admin123");
	        obj.Loginbutton();
	        
	}

}
