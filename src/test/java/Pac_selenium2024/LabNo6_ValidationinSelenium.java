package Pac_selenium2024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LabNo6_ValidationinSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/div[2]/div[2]/ul/li[2]/div/ul/li[2]/a")).click();
		driver.findElement(By.id("input-email")).sendKeys("tst@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Vivanta");
		driver.findElement(By.partialLinkText("Login")).click();
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("Components")).click();
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		Select show = new Select(driver.findElement(By.xpath("//select[@id=\"input-limit\"]")));
		show.selectByIndex(1);
		
       JavascriptExecutor js=(JavascriptExecutor)driver;
	  //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,900)");
        Thread.sleep(1000);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-list\"]/div[1]/form/div/div[2]/div[1]/h4/a")));
		ele.click();
	    
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		//js1.executeScript("window.scrollBy(0,900)");
        //js1.executeScript("window.scrollBy(0,2000)");
		js.executeScript("window.scrollBy(0,1000)");
		
		WebElement radioButton=driver.findElement(By.id("input-option-value-5"));
		radioButton.click();
		
		//js.executeScript("window.scrollBy(0,1000)");
	
		 WebElement CheckBox=driver.findElement(By.id("input-option-value-8"));
		 CheckBox.click();
		
		 driver.findElement(By.id("input-option-208")).sendKeys("Text");
		 //driver.findElement(By.id("input-option-209")).sendKeys("Text");
		
	
	}

}
