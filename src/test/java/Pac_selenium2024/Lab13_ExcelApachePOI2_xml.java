package Pac_selenium2024;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab13_ExcelApachePOI2_xml {

	public static void main(String[] args) throws InterruptedException, IOException, SAXException, ParserConfigurationException, DOMException {
		// TODO Auto-generated method stub
//		File f1 = new File("C:\\Users\\parag.watve\\eclipse-workspace\\JAN2024_Selenium\\exceldata.xlsx");
//		FileInputStream fis = new FileInputStream(f1);
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//		
//		int rowcount = sheet.getPhysicalNumberOfRows();
//		System.out.println("Row count:"+rowcount);
//		
//		String[][] data =new String[2][4];
//		for(int i=0;i<rowcount;i++)
//		{
//			data [i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
//			data [i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
//			data [i][2]=sheet.getRow(i).getCell(2).getStringCellValue();
//			data [i][3]=sheet.getRow(i).getCell(3).getStringCellValue();
//	
//			String fname=data[i][0];
//			String lname=data[i][1];
//			String email=data[i][2];
//			String pword=data[i][3];
//			
//			System.out.println("firstname:"+fname);
//			System.out.println("lastname:"+lname);
//			System.out.println("email:"+email);
//			System.out.println("password:"+pword);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		System.out.println(driver.getTitle());
		File xmlfile = new File("C:\\Users\\rohan.chari\\eclipse-workspace\\JAN2024_Selenium\\OpencartData.xml");
        DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder=DBFactory.newDocumentBuilder();
        Document doc = dbuilder.parse(xmlfile);
        NodeList n1 =doc.getChildNodes();
        Node n =n1.item(0);
        Element ele=(Element)n;
        String url=ele.getElementsByTagName("url").item(0).getTextContent();
        String email=ele.getElementsByTagName("email").item(0).getTextContent();
        String pword=ele.getElementsByTagName("password").item(0).getTextContent();
        
        ORHM1_POM2 obj = new ORHM1_POM2(driver);
    	driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		obj.enteremail(email);
		obj.enterpassword(pword);
		obj.clickonlogin();
		//Thread.sleep(2000);
		//driver.findElement(By.linkText("My Account")).click();
		//driver.findElement(By.linkText("Register")).click();
		//driver.findElement(By.name("firstname")).sendKeys(fname);
		//driver.findElement(By.name("lastname")).sendKeys(lname);
		//driver.findElement(By.name("email")).sendKeys(email);
		//driver.findElement(By.name("password")).sendKeys(pword);
		//driver.findElement(By.tagName("button")).click();
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)");
		//Thread.sleep(2000);
		//driver.findElement(By.id("input-newsletter-yes")).click();
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(2000);
		driver.quit();

	}

 }