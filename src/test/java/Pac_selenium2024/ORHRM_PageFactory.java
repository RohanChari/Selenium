package Pac_selenium2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ORHRM_PageFactory {

	
WebDriver driver;
	
	//By uname= By.name("username");
   @FindBy(name="username")
    WebElement uname;
   
	//By pword= By.name("password");
	@FindBy(name="password")
	WebElement pword;
	
  // By loginbutton=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
		

	public void enterusername(String username)
	{
		uname.sendKeys(username);
	}

	public void enterpassword(String password) {
		
		pword.sendKeys(password);
	}
	
	public void Loginbutton() {
		
		loginbutton.click();
	}
	

	
}
