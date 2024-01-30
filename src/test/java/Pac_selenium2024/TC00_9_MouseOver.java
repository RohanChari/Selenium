package Pac_selenium2024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC00_9_MouseOver {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		
		WebElement ele=driver.findElement(By.linkText("Components"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Monitors (2)")).click();	
		
	}

}
