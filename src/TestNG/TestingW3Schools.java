package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestingW3Schools {
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
			driver.get("https://www.w3schools.com");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = { "openBrowser" }, groups = { "Color" })
	public void viewColors() {
		try {

			driver.findElement(By.xpath("//div[7]/div/div/a[1]")).click();
			Thread.sleep(2000);
			jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0,700)");
			driver.findElement(By.linkText("COLOR PICKER")).click();
			driver.findElement(By.id("entercolor")).sendKeys("Blue");
			driver.findElement(By.xpath("//div[@id='entercolorDIV']/button")).click();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = { "openBrowser" }, groups = { "Tutorials" })
	public void viewTutorials() {
		try {
			driver.navigate().to("https://www.w3schools.com/html/default.asp");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='main']/div[2]/a[2]"))
					.click();
			driver.findElement(By.xpath("//div[@id='leftmenuinnerinner']/a[10]")).click(); // click styles
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@id='topnav']/div/div[1]/a[14]")).click(); // search icon
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@id='gs_tti50']/input"))
					.sendKeys("sql tutorials"); // search
			driver.findElement(
					By.xpath("//div[@id='___gcse_0']/div/div/form/table[1]/tbody/tr/td[2]/input"))
					.click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(1000);
			driver.quit();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
