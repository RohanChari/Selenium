package Pac_selenium2024;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_OrangeHRM {

	public static void main(String[] args) throws IOException, InterruptedException  {
		
		File f1=new File("C:\\Users\\rohan.chari\\eclipse-workspace\\JAN2024_Selenium\\InputData.xlsx");
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
			System.out.println("username:"+uname);
			System.out.println("password:"+pword);
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			OrangeHRMLogin obj =new OrangeHRMLogin(driver);
			obj.enterusername(uname);
			obj.enterpassword(pword);
			obj.clicklogin();		
			
		}
		
	}
}
		
		
		
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();*/



