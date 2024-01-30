package Pac_selenium2024;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

  /*public class TC001_Selenium {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		WebElement search=driver.findElement(By.name("q"));
		
		search.sendKeys("Automation Testing Tools");
		search.submit();
	    
		System.out.println(driver.getTitle());
		
		driver.close();
	}
	
}*/


public class TC001_Selenium {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Automation Testing Tools");
        search.submit();
        System.out.println(driver.getTitle());
        
        driver.navigate().to("https://www.amazon.com/");
        
        System.out.println(driver.getTitle());
        driver.navigate().back();
        System.out.println("After Backward"+driver.getTitle());
        System.out.println("After Backward"+driver.getCurrentUrl());
        System.out.println("After Backward"+driver.getPageSource().contains("Automation"));
        
        driver.navigate().forward();
        System.out.println("After Forward"+driver.getTitle());
        System.out.println("After Backward"+driver.getCurrentUrl());
        driver.quit();

    }

}

















