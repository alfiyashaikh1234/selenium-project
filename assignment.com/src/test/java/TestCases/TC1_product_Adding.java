package TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageObject.AddToCart;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.SearchPage1;

public class TC1_product_Adding extends BaseClass {

	String p1 = "creeper";

	@Test
	public void loginTest() throws InterruptedException {
		driver.get(baseurl);
		LoginPage lp = new LoginPage(driver);
		lp.setsign();
		// Thread.sleep(5000);

		lp.setusername(username);
		lp.setcontinue();
		lp.setpassword(password);
		lp.clicksubmit();

		SearchPage1 sp = new SearchPage1(driver);
		sp.txtbox();
		sp.submitbtn();

		List<String> newproductList = new ArrayList<String>();
		List<WebElement> ProductList = driver.findElements(By.xpath("//*[@data-component-type=\"s-search-result\"]"));

		for (int i = 1; i <= ProductList.size(); i++) {

			String allProducts = driver.findElement(By.xpath("//*[@data-component-type=\"s-search-result\"][" + i
					+ "]/div/div//child::div[2]//span[@class=\"a-size-base-plus a-color-base\"]")).getText();
			System.out.println("The Product Names: " + allProducts);

			newproductList.add(allProducts);

		}
		int totalProduct = ProductList.size();
		System.out.println("Total Product: " + totalProduct);

		AddToCart ac = new AddToCart(driver);
		List<String> product = newproductList;

		if (product.contains(p1)) {

			ac.addCart();

		}
		String parentWindow = driver.getWindowHandle();

		// Perform an action that opens a new child window (e.g., clicking a link)
		// ...

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Loop through the window handles and switch to the child window
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		
		System.out.println(driver.findElement(By.xpath("//h1[@id=\"title\"]/span[@id=\"productTitle\"]")).getText());
		System.out.println("Selecting the quanity by 3");
		ac.selectDrop();
		ac.addToCart();
		System.out.println("Delete the product from the Cart");
		ac.deleteProductFromCart();

		System.out.println("logging out from Amazon");
		lp.LogoutPage();

	}

}
