package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class TestDDT {

	@Test(dataProvider="testdata")
	public void TestFireFox(String uname,String password) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/login");
		
		driver.findElement(By.id("userName")).clear();
		
		driver.findElement(By.id("userName")).sendKeys(uname);
		
		driver.findElement(By.id("password")).clear();
		
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
		@DataProvider(name="testdata")
		public Object[][] TestDataFeed(){
			
		Object [][] facebookdata = new Object[2][2];
		
		facebookdata[0][0]="username1@gmail.com";
		
		facebookdata[0][1]="Password1";
		
		
		facebookdata[1][0]="username2@gmail.com";
		
		facebookdata[1][1]="Password2";
		
		return facebookdata;
		
	}
}
