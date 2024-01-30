package Pac_selenium2024;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5CreatenewAccount {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demo.opencart.com/");
		System.out.println(driver.getTitle());
		Thread.sleep(1000);
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Rohan");
		driver.findElement(By.id("input-lastname")).sendKeys("chary");  
		driver.findElement(By.id("input-email")).sendKeys("kk@gmail.com"); 
		driver.findElement(By.id("input-password")).sendKeys("Vivanta"); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
		
		driver.findElement(By.id("input-newsletter-no")).click();          //agree
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("/html/body/main/div[2]/div/div/form/div/div/button")).click(); 
		System.out.println("Register successful");
        driver.quit();
        
        // JavascriptExecutor js = (JavascriptExecutor) driver;
		                   //js.executeScript("window.scrollBy(0,350)", "");
		                   //driver.findElement(By.xpath("//input[@id='input-newsletter-yes']")).click();
                          //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        
        
	}

}
