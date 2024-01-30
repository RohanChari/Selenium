package TestNgPackage;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationCasestudy1 {
	
	
WebDriver driver;
	
    By firstName =By.id("firstname");
    By Lastname =By.id("lastname");
	By Email=By.id("email_address");
	By Password=By.id("password");
	By ConfirmPassword=By.id("password-confirmation");
	By sign=By.id("Sign In");
	By email1=By.id("email");
	By password1=By.id("pass");
	By signin=By.id("send2");
	By dashboard = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");

	
	
	public RegistrationCasestudy1 (WebDriver driver2) {
		
		this.driver=driver2;
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
		boolean ispassword_displayed=driver.findElement(Password).isDisplayed();
		return ispassword_displayed;
	}
	

	public void FirstName(String Fname) {
		
		driver.findElement(firstName).sendKeys(Fname);
		
	}
	
	
    public void Lastname(String Lname) {
		
		driver.findElement(Lastname).sendKeys(Lname);
		
	}
	
	
    public void Email(String mail) {
		
  		driver.findElement(Email).sendKeys(mail);
  		
  	}
	
    
	
    public void Password(String Pword) {
		
  		driver.findElement(Password).sendKeys(Pword);
  		
  	}
	
    
    
     public void Cpassword(String Pword) {
		
  		driver.findElement(ConfirmPassword).sendKeys(Pword);
  		
  	}
	
    
	
	public void CreateAccount() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		
		//JavascriptExecutor js2 =(JavascriptExecutor)driver;
	    //js2.executeScript("window.scrollBy(0,100)");
		
		//Thread.sleep(1000);
		//Select s = new Select(driver.findElement(By.linkText("Sign Out")));
		//s.selectByVisibleText("Sign Out"); 
		
		//Select s= new Select(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")));
		//List<WebElement> l1=s.getOptions();	
	  } 
	} 
	  
	  
	  
	  
	  
	  
	  
	  
	  
  
	  
	  
	  
	  
	  
	  
	  
	  
	  
		
		
	
	
	
	
	
	
	

	




