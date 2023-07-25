package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class CrossBrowserScript {

	WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		
		}
		
				
		else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void testParameterWithXML() throws InterruptedException{
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		driver.findElement(By.xpath("//h5[contains(text(),'Book Store Application')]")).click();
		
		js.executeScript("window.scrollBy(0,350)", "");
		
		WebElement Login = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
		Login.click();
		Thread.sleep(2000);
		WebElement userName = driver.findElement(By.id("userName"));
		userName.sendKeys("Anc1kr1st");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("Heslo**159");
		Thread.sleep(3000);
		
	WebElement Next = driver.findElement(By.xpath("//button[@id='login']"));
	Next.click();
	Thread.sleep(2000);
	WebElement search = driver.findElement((By.cssSelector("#searchBox")));
	search.sendKeys("Selenium");
	Thread.sleep(2000);
	
	WebElement searchbtn = driver.findElement(By.xpath("//button[@id='gotoStore']"));
	searchbtn.click();
	}
}
