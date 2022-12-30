package AutoTasks;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class childwindowhndl {

	WebDriver driver;
	@BeforeMethod
	public void BM() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void TC_100 () throws InterruptedException{
		String per_add= driver.getWindowHandle();
		System.out.println(per_add);
		WebElement link= driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
		link.click();
		Thread.sleep(2000);
		Set<String> alladd=driver.getWindowHandles();
		System.out.println(alladd);
		Iterator<String>it=alladd.iterator();
		
		while(it.hasNext()){
			String childadd=it.next();
			if(!per_add.equalsIgnoreCase(childadd)) {
				
				driver.switchTo().window(childadd);
				driver.findElement(By.name("emailid")).sendKeys("imwishaal@gmail.com");
				Thread.sleep(2000);
				driver.findElement(By.name("btnLogin")).click();
				Thread.sleep(2000);
			}
			//driver.switchTo().window(per_add);
			driver.navigate().back();
			Thread.sleep(2000);
		}
	
	}
	
	@AfterMethod
	
	public void AM() {
		driver.quit();
		
		
	}
	
	
}
