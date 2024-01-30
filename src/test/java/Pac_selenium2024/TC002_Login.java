package Pac_selenium2024;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_Login {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
     InputStream input1= new FileInputStream("C:\\Users\\rohan.chari\\eclipse-workspace\\JAN2024_Selenium\\OpencartLab12.properties");
			
	 Properties prob= new Properties();
	 prob.load(input1);
	 String url=prob.getProperty("url");
	 String eml=prob.getProperty("email");
	 String pass=prob.getProperty("password");
	 
	 System.out.println("the url is:"+url);
	 System.out.println("the email is:"+eml);
	 System.out.println("the password is:"+pass);
		
	/* Properties prob1= new Properties();
	 prob.load(input1);
	 String email=prob1.getProperty("email");
	 System.out.println("the email is:"+email);*/
	 
	 /*Properties prob2= new Properties();
	 prob.load(input1);
	 String password=prob2.getProperty("password");
	 System.out.println("the password is:"+password);*/
	 
	 	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		
		
		OpencartObjectfile obj =new OpencartObjectfile(driver);
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		obj.email(eml);
		obj.password(pass);
		obj.Loginbutton();
		
		driver.quit();
		//System.out.println("Verify myaccount:"+driver.findElement(By.linkText("MyAccount")).isDisplayed());
		//driver.findElement(By.linkText("My Account")).getText());
		//driver.findElement(By.linkText("Login")).click();
		//driver.findElement(By.id("input-email")).click();
		
	
		
		
		/*driver.findElement(By.id("input-email")).sendKeys("tst@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Vivanta");
		driver.findElement(By.tagName("button")).click();*/

		/*Actions act=new Actions(driver);
		act.sendKeys("tst@gmail");
		act.sendKeys(Keys.TAB);
		act.sendKeys("Welcome");
		act.sendKeys(Keys.TAB);
		act.sendKeys(Keys.TAB);
		act.sendKeys(Keys.ENTER);
		
		act.perform();	
		driver.quit();*/
	}
}
