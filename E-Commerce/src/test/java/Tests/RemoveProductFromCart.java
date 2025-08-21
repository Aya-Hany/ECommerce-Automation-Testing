package Tests;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.productDetailsPage;

@Test
public class RemoveProductFromCart extends TestBase{
	HomePage home;
	CartPage Cart;
	productDetailsPage detail;
	public void  RemoveProductFromCart() {
		home=new HomePage(driver);
		Cart=new CartPage(driver);
		detail=new productDetailsPage(driver);
		Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
		ProductPage product = new ProductPage(driver);
		 home.goToProductPage();
	  	  Assert.assertEquals("ALL PRODUCTS",product.ProductConfermMessage.getText());
	  	  Assert.assertTrue(product.products.size()>0);
	  	  product.goTODetailsPage();
	  	  detail.detailAddBtn.click();
	     product.viewBtn.click();
	  	  product.checkCart();
	  	  Cart.cartBtn.click();
	  	 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOf(Cart.cartBtn));
	  	  Cart.RemoveBtn.click();
	  	 WebDriverWait wait1 =new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait1.until(ExpectedConditions.visibilityOf(Cart.epmtyMsg));
	  	 Assert.assertTrue(Cart.verifyEmptyCart()); 
	
 
}
}
