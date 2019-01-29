package jenkinpackage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class New1 {
	
	WebDriver wd;
	String url = "http://facebook.com";
	String actualTitle = "Facebook – log in or sign up";
	
	@Test
	public void landingpage() {
		String expectedTitle = wd.getTitle();
		System.out.println(expectedTitle);
		assertEquals(actualTitle, expectedTitle);	
	}
	
	@BeforeMethod
	public void browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "D:\\FreshSeleniumSetup\\chromedriver_win32\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get(url);		
	}
	
	@AfterMethod
	public void browserexit() {
		wd.close();  
	}
}
