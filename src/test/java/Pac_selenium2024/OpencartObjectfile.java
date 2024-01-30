package Pac_selenium2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpencartObjectfile {

	
	WebDriver driver;
	
	By emailenter= By.name("email");
	By pword= By.name("password");
	By loginbutton=By.tagName("button");
	
	
	public OpencartObjectfile(WebDriver driver2) {
		
		this.driver=driver2;
	}	

	
	public void email(String email1)
	{
		driver.findElement(emailenter).sendKeys(email1);
	}


	public void password(String password1) {
		
		driver.findElement(pword).sendKeys(password1);
	}
	
	
	public void Loginbutton() {
		
		driver.findElement(loginbutton).click();
	}

	
}
	
	
	
	

