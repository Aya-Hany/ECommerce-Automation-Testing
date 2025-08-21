package Tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductPage;

public class recomendedAdd extends TestBase{
	HomePage home;
	ProductPage product;
	@Test
	public void addFromRecomended() {
		home=new HomePage(driver);
		product=new ProductPage(driver);
		Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", home.recomended);
		 home.recomendedAdd.click();
		 product.viewBtn.click();
		 Assert.assertEquals("Rs. 500",product.cPice.getText());
		 Assert.assertEquals("1",product.cquantity.getText());
		 Assert.assertEquals("Rs. 500",product.cTotal.getText());
		 home.HomeBtn.click();
	}
}
