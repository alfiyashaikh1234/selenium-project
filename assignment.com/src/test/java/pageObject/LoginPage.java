package pageObject;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement txtsign;

	@FindBy(id = "ap_email")
	WebElement txtusername;

	@FindBy(id = "continue")
	WebElement txtcontinue;

	@FindBy(id = "ap_password")
	WebElement txtpassword;

	@FindBy(id = "signInSubmit")
	WebElement txtsubmit;

	@FindBy(xpath = "//span[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement element;

	public void setsign() {
		txtsign.click();
		;
	}

	public void setusername(String uname) {
		txtusername.sendKeys(uname);
	}

	public void setcontinue() throws InterruptedException {
		txtcontinue.click();
		Thread.sleep(5000);
	}

	public void setpassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}

	public void clicksubmit() {
		txtsubmit.click();
	}

	public void LogoutPage() {

		Actions actions = new Actions(ldriver);

		actions.moveToElement(element).build().perform();

		ldriver.findElement(By.xpath("//span[contains(text(),\"Sign Out\")]"));
	}
}
