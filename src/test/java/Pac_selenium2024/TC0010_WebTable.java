package Pac_selenium2024;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC0010_WebTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
		WebElement table=driver.findElement(By.id("simpletable"));
		
		List<WebElement> headers=table.findElements(By.tagName("th"));
		
		for(WebElement header : headers)
		{
			System.out.println(header.getText());
		}

		
		List<WebElement> allows=table.findElements(By.tagName("tr"));
		System.out.println("rows:"+allows.size());
		
		
		/*for(WebElement row:allows)
		{
			List<WebElement> columns=row.findElements(By.tagName("td"));
			System.out.println(columns.get(0).getText());
				
		}*/
		
		for(int i=0;i<allows.size()-1;i++) {
			
			List<WebElement> rows=allows.get(i).findElements(By.tagName("td"));
			
			String text=rows.get(i).getText();
			System.out.println(text);
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
