package Pac_selenium2024;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab14Parameterizationwithexcel {

	
public static void main(String[] args) throws IOException, InterruptedException  {
		
		File f1=new File("");
		FileInputStream fis= new FileInputStream(f1);
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
	
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		System.out.println("Row Count:"+rowcount);
		
		String[][] data=new String[3][2];
		
		for(int i=0;i<rowcount;i++) {
			
			data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			
			String uname=data[i][0];
			String pword=data[i][1];
			//System.out.println("username:"+uname);
			//System.out.println("password:"+pword);
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://demo.opencart.com/");
			
			POMFileofOpencart obj =new POMFileofOpencart(driver);
			//obj.enterusername(uname);
			//obj.enterpassword(pword);
			//obj.clicklogin();		
			
		}
		
	}
}

	
	
	
	
	

