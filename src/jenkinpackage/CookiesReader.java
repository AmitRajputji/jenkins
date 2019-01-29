package jenkinpackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesReader {

	public static void main(String[] args) {

		String url = "http://demo.guru99.com/test/cookie/selenium_aut.php";
		System.setProperty("webdriver.chrome.driver", "D:\\FreshSeleniumSetup\\chromedriver_win32\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		wd.manage().window().maximize();
//		wd.manage().deleteAllCookies();
		wd.get(url);

// 		input e-mail id and password and click on submit
		wd.findElement(By.name("username")).sendKeys("abc123");
		wd.findElement(By.name("password")).sendKeys("123xyz");
		wd.findElement(By.name("submit")).click();

// 		create file named cookies to store login information
		File file = new File("Cookies.data");
		try {
			file.delete(); // Delete old file if exists
			file.createNewFile();
			FileWriter fileWrite = new FileWriter(file);
			BufferedWriter BWrite = new BufferedWriter(fileWrite);

			// loop for getting the cookie information
			for (Cookie ck : wd.manage().getCookies()) {
				BWrite.write((ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure()));
				BWrite.newLine();
			}

			BWrite.close();
			fileWrite.close();
			System.out.println("Work Done");
		} catch (Exception ex) {
			ex.getStackTrace();
			System.out.println(ex.getMessage());
		}
	}
}
