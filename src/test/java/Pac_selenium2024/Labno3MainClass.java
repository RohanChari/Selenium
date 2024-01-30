package Pac_selenium2024;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Labno3MainClass {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		ORM_POM obj=new ORM_POM(driver);
		obj.ClickAccount();
		obj.enterusername("tst@gmail.com");
		obj.enterpassword("Vivanta");
		obj.Loginbutton();
		obj.ClickDesktopDrpdown();
		obj.ClickSortBy();
		//obj.AddToCart();

	}

}
