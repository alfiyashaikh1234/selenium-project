package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public  String baseurl = "https://www.amazon.in";
	public String username = "alfiyashaikh349@gmail.com";
	public String password = "Abc123@";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver", )
		driver = new ChromeDriver();
	}
/*	@AfterClass
	public void End() {
		driver.quit();
	}
*/
}
