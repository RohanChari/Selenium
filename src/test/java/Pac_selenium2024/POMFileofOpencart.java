package Pac_selenium2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POMFileofOpencart {

	
	   WebDriver driver;
	   By firstname=By.id("input-firstname");
	   By lastname=By.id("input-lastname");
	   By email=By.id("input-email");
	   By password=By.id("input-password");
	   By Newsletter=By.id("input-newsletter-yes");
	   By privacy=By.name("agree");
	   By cntinue=By.tagName("button");
	   
	   
	   public POMFileofOpencart(WebDriver driver2) {
	       this.driver=driver2;
	   }
	   
	   
	   public void AccountClick() {
		  
		   System.out.println(driver.getTitle());
		   driver.findElement(By.linkText("My Account")).click();
	      
	   }
	   
	   
	   public void RegisterClick() {
			  
		   driver.findElement(By.linkText("Register")).click();   
	   }
	   
	   
	   public void firstname(String username) {
	       driver.findElement(firstname);
	   }
	   
	   
	   public void lastname(String password) {
	       driver.findElement(lastname);                     //.sendKeys(password);
	   }
	   
	   
	   public void email(String mail) {
	       driver.findElement(email).sendKeys(mail);
	   }
	   
	   
	   public void password(String pword) {
	       driver.findElement(password).sendKeys(pword);
	   }
	   
	   
	   public void Newsletter() {
	       driver.findElement(Newsletter).click();
	   }
	   
	   
	   public void privacy() {
	       driver.findElement(privacy).click();
	   }
	   
	   
	   
	   public void cntinue() {
	       driver.findElement(cntinue).click();
	   }
	   
	 }
	
	
	
	
	
	

