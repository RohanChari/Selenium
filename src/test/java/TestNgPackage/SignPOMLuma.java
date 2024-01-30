package TestNgPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SignPOMLuma {

   WebDriver driver;
   
    By firstName =By.id("firstname");
    By Lastname =By.id("lastname");
	By sign=By.id("Sign In");
	By email1=By.id("email");
	By password1=By.id("pass");
	By signin=By.id("send2");
	By dashboard = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");

   
    public SignPOMLuma (WebDriver driver2) {
		
		this.driver=driver2;
	}
	
	
	public void SignIn() {
			
	  		driver.findElement(sign).click();
	  	}
		
	  
	
	public void Email2(String emailenter) {
			
	  	   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");	
		   driver.findElement(email1).sendKeys(emailenter);
	  	
	  }
		
	  
	  public void password1(String passenter) {
			
	  		driver.findElement(password1).sendKeys(passenter);
	  		
	  	}
		
	  
	  public void signin() {
			
	  		driver.findElement(signin).click();
	  		
	  	}
	
	  
		public boolean verifyuserFname()
		{
			boolean isuserfirstname_displayed=driver.findElement(firstName).isDisplayed();
			return isuserfirstname_displayed;
				
		}
		
		public boolean verifyuserLname() {
			
			boolean isuserlastname_displayed=driver.findElement(Lastname).isDisplayed();
			return isuserlastname_displayed;	
		}

	  
		public boolean verifypassword()
		{
			boolean ispassword_displayed=driver.findElement(password1).isDisplayed();
			return ispassword_displayed;
		}
		
		
		
		
	  public boolean verifylogin()
		{
		  boolean isdashboard_displayed;
			try
			{
			 isdashboard_displayed=driver.findElement(dashboard).isDisplayed();
			}
			catch(Exception e)
			{
				isdashboard_displayed=false;
			}
			
			return isdashboard_displayed;
		}
	} 
	  
	
	
	
	
	
	

