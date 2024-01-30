package TestNgPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Pac_selenium2024.OrangeHRMLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGproPerties {
	WebDriver driver;
 
	@Test(dataProvider = "dp")
  
  public void f(String username, String password) throws InterruptedException, IOException {
	  
		long  timestamp= new Date().getTime();
		System.out.println("Time is:"+timestamp);
		System.out.println("this is test: your credentials are:"+username+":and:"+password);
		
		System.out.println("this is the test:credential:+"+username+": and:"+password);	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	    
		OrangeHRMLogin obj =new OrangeHRMLogin(driver);
		String title=driver.getTitle();
		Assert.assertEquals(title,"OrangeHRM");
		ExtentReports extent=new  ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter(timestamp+"23jan2024.html");
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the title of OrangeHRM");
		
		if(title.equals("OrangeHRM"))
		{
			test.pass("OrangeHRM title is dislayed");	
		}
		else
 		{   
			Thread.sleep(5000);
			File sfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dfile=new File("p1.png");
			FileUtils.copyFile(sfile, dfile);
			String path= dfile.getAbsolutePath();
			test.fail("OrangeHRM title is dislayed" ,MediaEntityBuilder
					                               .createScreenCaptureFromPath("img1.jpeg")
			                                      .build()
			                                       );
			//test.addScreenCaptureFromPath(path);
		}
		
	
		if(obj.verifyusername())
		{
			
			test.pass("username is displayed");
		}
		
		else
		{
			
				Thread.sleep(5000);
				File sfile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile1=new File("p2.png");
				FileUtils.copyFile(sfile1, dfile1);
				String path1= dfile1.getAbsolutePath();
				test.fail("username is not  displayed" ,MediaEntityBuilder
						                               .createScreenCaptureFromPath("img2.jpeg")
				                                      .build()
				                                       );
				test.addScreenCaptureFromPath(path1);	
		}
		
		
		if(obj.verifypassword())
		{
			
			test.pass("password is displayed");
		}
		else
		{
			
			   
				Thread.sleep(5000);
				File sfile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile2=new File("p3.png");
				FileUtils.copyFile(sfile2, dfile2);
				String path2= dfile2.getAbsolutePath();
				test.fail("password is not  displayed" ,MediaEntityBuilder
						                               .createScreenCaptureFromPath("img3.jpeg")
				                                      .build()
				                                       );
				test.addScreenCaptureFromPath(path2);
			
					
		}
		
		if(obj.verifylogin())
		{
			
			test.pass("login successful");
		}
		else
		{
			
			   
				Thread.sleep(5000);
				File sfile3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dfile3=new File("p4.png");
				FileUtils.copyFile(sfile3, dfile3);
				String path3= dfile3.getAbsolutePath();
				test.fail("login  not successful" ,MediaEntityBuilder
						                               .createScreenCaptureFromPath("img3.jpeg")
				                                      .build()
				                                       );
				test.addScreenCaptureFromPath(path3);	
					
		}
		
	    obj.enterusername(username);
		obj.enterpassword(password);
		obj.clicklogin();
		extent.flush();
		
		//boolean dashboard=driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
		//Assert.assertEquals(dashboard,true);
	  
  }
  
  @Parameters("Browser")
  @BeforeMethod
  public void beforeMethod(String browser) throws IOException {
	  
	  InputStream input1= new FileInputStream("C:\\Users\\rohan.chari\\eclipse-workspace\\JAN2024_Selenium\\loginData.properties");
		
		Properties prob= new Properties();
		prob.load(input1);
		String url=prob.getProperty("url");
		System.out.println("the url is:"+url);
		System.out.println("browser is:"+browser);
		
		/*WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.get(url);*/
	  
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(url);
		}
		
		else if(browser.equalsIgnoreCase("edge")) {	
	
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get(url);
			
		}	
		
		
		else if(browser.equalsIgnoreCase("firefox")) {	
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(url);
			
		}	
  }

  
  @AfterMethod
  public void afterMethod() {
	  
	  System.out.println("aftermethod");
	 // driver.quit();
  }
  
  @DataProvider
  public Object[][] dp() throws IOException {
    
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
			
			
			
		
		// private void assertEquals() {
		  
		  
	  //}
		
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
