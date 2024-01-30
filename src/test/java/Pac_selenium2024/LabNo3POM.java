package Pac_selenium2024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LabNo3POM {
	
	public static void main(String[] args) throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demo.opencart.com/");
	driver.manage().window().maximize();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.partialLinkText("Login")).click();
	driver.findElement(By.id("input-email")).sendKeys("tst@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("Vivanta");
	
	driver.findElement(By.tagName("button")).click();
	
	//driver.findElement(By.linkText("Desktops")).click();    
	WebElement ele=driver.findElement(By.linkText("Desktops"));
	Actions act= new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.linkText("Mac (1)")).click();
	
	Select show = new Select(driver.findElement(By.xpath("//select[@id='input-sort']")));
    show.selectByIndex(1);
    JavascriptExecutor js1 =(JavascriptExecutor)driver;
    js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    driver.findElement(By.linkText("iMac")).click();
    
    JavascriptExecutor js2 =(JavascriptExecutor)driver;
    js2.executeScript("window.scrollBy(0,100)");
    driver.findElement(By.id("button-cart")).click();
	
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,1000)");
     driver.findElement(By.linkText("iMac")).click();
	
	
	
  }
}












	/*By clickDesktop=By.linkText("Desktops");
	By myaccount=By.linkText("My Account"));
	By username=By.id("input-email"));
    By password=By.id("input-password"));			
	Select show = new Select(driver.findElement(By.xpath("//select[@id=\"input-limit\"]")));
	show.selectByIndex(1);*/

	
	

