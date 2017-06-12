package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestingFacebook {

	WebDriver driver;

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
			driver.get("https://www.facebook.com");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = { "openBrowser" })
	public void loginTOFacebook() {
		try {
			driver.findElement(By.id("email")).sendKeys("almahmud@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("password");
			driver.findElement(By.id("loginbutton")).submit();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Recover Your Account')]")).click();;
			driver.findElement(By.xpath("//div/label/input")).click();;
			Thread.sleep(3000);
			driver.quit();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}
}
