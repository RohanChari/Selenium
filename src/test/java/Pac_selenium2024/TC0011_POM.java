package Pac_selenium2024;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0011_POM {

	public static void main(String[] args) {
		
		   WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        System.out.println(driver.getTitle());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        ORM_POM obj=new ORM_POM(driver);
	        obj.enterusername("Admin");
	        obj.enterpassword("admin123");
	        obj.Loginbutton();
	        
	        /*driver.findElement(By.name("username")).sendKeys("Admin");
	        driver.findElement(By.name("password")).sendKeys("admin123");
	        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
*/
	
		
	}

}
