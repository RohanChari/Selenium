package Pac_selenium2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LabPageObject {

	
WebDriver driver;
	
	By emailenter= By.name("input-email");
	By pword= By.name("password");
	By loginbutton=By.tagName("button");
	
	
	public LabPageObject(WebDriver driver2) {
		
		this.driver=driver2;
	}	

	
	public void email(String email)
	{
		driver.findElement(emailenter).sendKeys(email);
	}

	public void password(String password) {
		
		driver.findElement(pword).sendKeys(password);
	}
	
	
	public void Loginbutton() {
		
		driver.findElement(loginbutton).click();
	}

	
}
