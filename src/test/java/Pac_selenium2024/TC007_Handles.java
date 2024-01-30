package Pac_selenium2024;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC007_Handles {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://letcode.in/windows");
		System.out.println(driver.getWindowHandle());
		
		
		
		//Conditional Wait
		Thread.sleep(1000);
		
		//Explicit wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.id("multi")));
		ele.click();
		
		
		//driver.findElement(By.id("multi")).click();
		
		List<String> l1= new ArrayList<String>(driver.getWindowHandles());
		System.out.println("size:" +l1.size());
		
		for(int i=0;i<l1.size();i++) {
			
			System.out.println(l1.get(i));
			
			//driver.switchTo().window(l1.get(i));
		}
		
		driver.switchTo().window(l1.get(0));
		System.out.println("the url is:"+driver.getCurrentUrl());
		
		driver.switchTo().window(l1.get(1));
		System.out.println("the url is:"+driver.getCurrentUrl());
		
		driver.switchTo().window(l1.get(2));
		System.out.println("the url is:"+driver.getCurrentUrl());
		
		}
		
	}


