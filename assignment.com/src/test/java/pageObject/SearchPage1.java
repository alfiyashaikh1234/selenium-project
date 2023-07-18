package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage1 {
	
	WebDriver ldriver;
	
	public SearchPage1(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(id="twotabsearchtextbox")
	WebElement searchbox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement submit;
	
	public void txtbox()
	{
		searchbox.sendKeys("hand bags");	
	}
	public void submitbtn()
	{
		submit.click();	
	}
	
	
	
	
	
	
	

}
