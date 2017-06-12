package TestNG;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.Select;
public class TestingSitebeam {
	WebDriver driver;
	JavascriptExecutor jse;

	@Test
	public void openBrowser() {
		try {

			System.setProperty("webdriver.chrome.driver",
					"C:\\Selenium Jar\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://sitebeam.net/");
			Thread.sleep(2000);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	@Test(dependsOnMethods = { "openBrowser" })
	public void test(){
		driver.findElement(By.xpath("//li[@id='menu-item-10']/a")).click();	//Click "Tests"
		driver.findElement(By.xpath("//div[@id='featuredtestmenu']/a[1]/span")).click();	//Click "Speed"
		driver.findElement(By.linkText("Analytics")).click();	//click "Analytics"
		driver.findElement(By.linkText("Alternative text")).click();  //Click "Alternative text"
		driver.findElement(By.linkText("Popularity")).click();  //Click "Popularity"
		driver.findElement(By.linkText("Home")).click();  //Click "Home"
		
	}	
	@AfterMethod(alwaysRun = true)
	public void pricing(){
		try {
			
			driver.findElement(By.xpath("//li[@id='menu-item-466']/a")).click();	//Click "Currency"
			/*driver.findElement(By.id("selectcurrency")).click();	//Click "Currency"
			driver.findElement(By.xpath("//select[@id='selectcurrency']/option[1]")).click();	//Click "pound"
			*/
			Select droplist = new Select(driver.findElement(By.id("selectcurrency")));   //Click "Currency"
			droplist.selectByVisibleText("UK Pounds (£)");
			Thread.sleep(2000);
			jse = (JavascriptExecutor)driver;		
			jse.executeScript("scroll(0,900)");
			Thread.sleep(2000);
			driver.quit();
			} 
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}			
	}
	
}
