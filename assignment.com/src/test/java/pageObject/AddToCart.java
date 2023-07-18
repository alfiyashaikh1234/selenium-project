package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddToCart {
	
	WebDriver ldriver;
	public AddToCart(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath ="//*[@data-component-type=\"s-search-result\"][10]/div/div//child::div[2]//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
	WebElement adCart;
	
	@FindBy(xpath="//select[@id=\"quantity\"]")
	WebElement drpDown;
	
	@FindBy(xpath="//input[@id=\"add-to-cart-button\"]")
	WebElement addingToCart;
	
	@FindBy(xpath="//span[@id=\"nav-cart-count\"]")
	WebElement CartProducts;
	
	@FindBy(xpath="//input[@value=\"Delete\"]")
	WebElement DeleteProduct;
	
	public void addCart()
	{
		adCart.click();
	}
	
	public void selectDrop() {
		Select drpQuantity = new Select(drpDown);
		drpQuantity.selectByValue("3");
	}
	
	public void addToCart() {
		addingToCart.click();
		CartProducts.click();
	}
	
	public void deleteProductFromCart() {
		DeleteProduct.click();
	}
	
}
