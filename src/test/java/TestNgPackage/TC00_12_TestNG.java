package TestNgPackage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC00_12_TestNG {
	
  WebDriver driver;
  @Test(dataProvider = "dp")
  
  public void f(String username, String password) throws InterruptedException {
	  
	 
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		boolean dashboard=driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
		Assert.assertEquals(dashboard,true);
		
  }
  
  
  private void assertequals() {
	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
			Thread.sleep(3000);
  }

  
  
  @AfterMethod
  public void afterMethod() {
	
	  //driver.quit();
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "rohan", "admin123" },   
    };
  }
  
  
  
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("this is before class" ); 
	  
  }
  
  

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("this is after class" );  
	  
	  
  }

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("this is before test" );  
  }

  
  @AfterTest
  public void afterTest() {
	  
	  System.out.println("this is aftertest" );  
	  
	  
  }

  
  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("this is beforesuite" ); 
  }

  
  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println("this is afterSuite" ); 
  }

}
