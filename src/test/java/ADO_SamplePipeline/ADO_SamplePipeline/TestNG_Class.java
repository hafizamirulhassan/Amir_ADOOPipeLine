package ADO_SamplePipeline.ADO_SamplePipeline;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Class {

	WebDriver driver = null;

	@Test
	public void VerifyTitle() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("http://www.inviul.com");
		String actualTitle = driver.getTitle();
		driver.manage().window().maximize();
		String expectedTitle = "Free Selenium Tutorials | TestNG Tutorials | Cucumber Tutorials | Inviul";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched");
		else
			System.out.println("Title didn't match");

		WebElement logo = driver.findElement(By.xpath("//*[@id=\"logo\"]/a/img"));
		if (logo.isDisplayed()) {
			System.out.println("showing logo");
		} else {
			System.out.println("not");
		}

	}

	@BeforeMethod
	public void beforeMethod() {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();

	}

}
