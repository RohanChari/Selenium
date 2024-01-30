package StepDefination;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TC00LoginCucumber {

	WebDriver driver;
	@Given("Launch the chrome  browser")
	public void launch_the_chrome_browser() {
	  
	  
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}

	@When("User opens the url")
	public void user_opens_the_url() throws InterruptedException {
	   
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		
	}

	
	
	@And("User enter the username and password")
	public void user_enter_the_username_and_password() throws InterruptedException {
	    
		Thread.sleep(1000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

	
	
	@And("Click on login button")
	public void click_on_login_button() {
	   
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	
	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() throws InterruptedException {
		//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6
		Thread.sleep(5000);
		boolean dashboard=driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).isDisplayed();
		Thread.sleep(5000);
		
		if(dashboard)
		{
			System.out.println("Login succesful");
		}
		
		else
		{
			System.out.println("Login unsuccessful");
		}
		
	}	
}
