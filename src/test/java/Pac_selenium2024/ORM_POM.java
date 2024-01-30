package Pac_selenium2024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ORM_POM {

	WebDriver driver;
	
	By uname= By.name("email");
	By pword= By.name("password");
	By loginbutton=By.xpath("//*[@id=\"form-login\"]/button");
	
	
	public ORM_POM(WebDriver driver2) {
		
		this.driver=driver2;
	}	

	public void ClickAccount() {
		
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")).click();
	}
	
	
	
	
	public void enterusername(String username)
	{
		driver.findElement(uname).sendKeys(username);
	}

	public void enterpassword(String password) {
		
		driver.findElement(pword).sendKeys(password);
	}
	
	
	public void Loginbutton() {
		
		driver.findElement(loginbutton).click();
	}
	
	public void ClickDesktopDrpdown() {
		
		WebElement ele=driver.findElement(By.linkText("Desktops"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Mac (1)")).click();	
	}
	
	
	public void ClickSortBy() {
		
		JavascriptExecutor js2 =(JavascriptExecutor)driver;
	    js2.executeScript("window.scrollBy(0,100)");
	    driver.findElement(By.id("button-cart")).click();
	}
	
	
	public void AddToCart() {
		
		
		
		/*WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("iMac")));
		ele.click();*/	

	}
	

}
