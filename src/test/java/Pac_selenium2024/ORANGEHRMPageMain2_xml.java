package Pac_selenium2024;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ORANGEHRMPageMain2_xml {

	public static void main(String[] args) {
		
		    WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        System.out.println(driver.getTitle());
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
	        
	        ORHRM_PageFactory obj= PageFactory.initElements(driver,ORHRM_PageFactory.class);
	        obj.enterusername("Admin");
	        obj.enterpassword("admin123");
	        obj.Loginbutton();
	        
	}

}
