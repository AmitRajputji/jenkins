package jenkinpackage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoubleClick {

	WebDriver wd;
	String url = "http://demo.guru99.com/test/simple_context_menu.html";
	String actualTitle = "You double clicked me.. Thank You..";

	@Test
	public void doubleclick() {
		WebElement link = wd.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
		Actions action = new Actions(wd);
		action.doubleClick(link).perform();
		Alert alert = wd.switchTo().alert();
		System.out.println("Alert Text :\t" + alert.getText());
		String expectedTitle = alert.getText();
		alert.accept();
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
