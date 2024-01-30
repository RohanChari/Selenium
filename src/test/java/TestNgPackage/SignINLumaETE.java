package TestNgPackage;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SignINLumaETE {
 
	 WebDriver driver;
	  @Test(dataProvider = "dp")
	  public void f(String email, String pass) throws Exception {
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  SignPOMLuma obj = new SignPOMLuma(driver);
		  long timestamp = new Date().getTime();
		  System.out.println("The time is: "+timestamp);
		  
		  ExtentReports extent=new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter(timestamp+"luma2.html");
			extent.attachReporter(spark);
			ExtentTest test=extent.createTest("Verify the Title of Luma");
			String title=driver.getTitle();
			System.out.println("Title: "+title);
		 
			if(title.equals("Create New Customer Account"))
			{
				test.pass("Luma title is displayed");
				
			}
			else
			{
				Thread.sleep(3000);
				File sfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile = new File("D:\\verifyimages\\verifysignin1.png");
				FileUtils.copyFile(sfile, dfile);
				String path = dfile.getAbsolutePath();
				test.fail("Luma title is not displayed"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
		  
			
			if(obj.verifyuserFname())
			{
				test.pass("Luma User first name is displayed");
				
			}
			
			else
			{
				Thread.sleep(3000);
				File sfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile1 = new File("UserFirstverify1.png");
				FileUtils.copyFile(sfile1, dfile1);
				String path1 = dfile1.getAbsolutePath();
				test.fail("Username is not displayed"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path1)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
			
			
			if(obj.verifyuserLname())
			{
				test.pass("Luma User Last name is displayed");
				
			}
			
			else
			{
				Thread.sleep(3000);
				File sfile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile1 = new File("UserLastverify1.png");
				FileUtils.copyFile(sfile1, dfile1);
				String path1 = dfile1.getAbsolutePath();
				test.fail("Username is not displayed"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path1)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
			
			
			
			if(obj.verifypassword())
			{
				test.pass("Password is displayed");
				
			}
			else
			{
				Thread.sleep(3000);
				File sfile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile2 = new File("D:\\verifyimages\\verify1.png");
				FileUtils.copyFile(sfile2, dfile2);
				String path2 = dfile2.getAbsolutePath();
				test.fail("password is not displayed"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path2)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
		
		  obj.SignIn();
		  obj.Email2(email);
		  obj.password1(pass);
		  obj.signin();
		  
		  if(obj.verifylogin())
			{
				test.pass("Login Successful");
				
			}
			else
			{
				Thread.sleep(3000);
				File sfile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile3 = new File("D:\\verifyimages\\verify1.png");
				FileUtils.copyFile(sfile3, dfile3);
				String path3 = dfile3.getAbsolutePath();
				test.fail("Login not Successful"
						,MediaEntityBuilder
						.createScreenCaptureFromPath(path3)
						.build());
				//test.addScreenCaptureFromPath(path);
			}
		  extent.flush();
		  
	  }
	 
	 // @Parameters("Browser")
	  @BeforeMethod
	  public void beforeMethod() throws Exception {
		  System.out.println("This is before method");
			 InputStream input1 = new FileInputStream("C:\\Users\\rohan.chari\\eclipse-workspace\\JAN2024_Selenium\\SignIN.properties");
				Properties prob = new Properties();
				prob.load(input1);
				String url = prob.getProperty("url");
				System.out.println("The URL is:" + url);
				//System.out.println("The Browser is:" + browsername);
				
				
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.get(url);
					driver.manage().window().maximize();
		  }
	  

	  @AfterMethod
	  public void afterMethod() {
	  }


	  @DataProvider
	  public Object[][] dp() throws Exception {
		  File f1 = new File("D:\\SignINDataLuma.xlsx");
	      FileInputStream fis = new FileInputStream(f1);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Row Count: "+rowCount);
			String[][] data = new String[2][2];
			
			for(int i=0;i<rowCount;i++) {
				data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
				data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
				
						
				String email = data[i][0];
				String password1 = data[i][1];
				
				System.out.println("Email: "+email);
				System.out.println("Password: "+password1);	
			
			}
			return data;
	  }
	 
   
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
