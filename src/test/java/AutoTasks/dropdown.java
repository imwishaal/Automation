package AutoTasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement drp= driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select s=new Select(drp);
		System.out.println(s.getFirstSelectedOption().getText());
		System.out.println(s.getOptions().size());
		s.selectByIndex(2);
		Thread.sleep(2000);
		
		WebElement chkbx=driver.findElement(By.id("checkBoxOption1"));
		chkbx.click();
		Thread.sleep(2000);
		
		
		WebElement rediobtn=driver.findElement(By.xpath("(//input[@name='radioButton'])[1]"));
		System.out.println(rediobtn.getText());
		rediobtn.click();
		Thread.sleep(2000);
		
		WebElement alert=driver.findElement(By.id("name"));
		alert.sendKeys("abcd");
		Thread.sleep(2000);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		
		
		
		
		driver.quit();	
		

	}

	
	
	
}
