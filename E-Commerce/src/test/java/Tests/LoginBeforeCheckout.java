package Tests;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Data.LoadPropertiesData;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.CartPage;
import Pages.HomePage;
import Pages.NewAccount;
import Pages.ProductPage;
import Pages.LoginPage;
import Pages.productDetailsPage;


public class LoginBeforeCheckout extends TestBase {
	HomePage home;
	CartPage Cart;
	NewAccount account;
	productDetailsPage detail;
	LoginPage login;
	@DataProvider(name="getAData")
	public Object[][] getData() throws IOException{
		Properties p =LoadPropertiesData.validLogInData;
		Object[][] data = {
				{p.getProperty("email"),p.getProperty("password")}};
		return data;
 
	}
	@Test(dataProvider = "getAData")
	public void testPlaceOrderLoginBeforeeCheckout (String email,String password) {
		home=new HomePage(driver);
		Cart=new CartPage(driver);
		detail=new productDetailsPage(driver);
		login =new LoginPage(driver);
		
		Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
		home.Signup_LoginBtn.click();
		login.loginData(email, password);
		 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOf(login.logoutBtn));
	     Assert.assertTrue(home.verifyLoggedin.getText().contains("Logged in as"));
			ProductPage product = new ProductPage(driver);
			 home.goToProductPage();
		  	  Assert.assertEquals("ALL PRODUCTS",product.ProductConfermMessage.getText());
		  	  Assert.assertTrue(product.products.size()>0);
		  	  product.goTODetailsPage();
		  	  detail.detailAddBtn.click();
		     product.viewBtn.click();
		  	  product.checkCart();
		  	  Cart.cartBtn.click();
		  	  Assert.assertEquals( Cart.proceedToCheckoutBtn.getText(),"Proceed To Checkout","Cart page not displayed");
		         Cart.proceedToCheckoutBtn.click();
		         
		    	 	Assert.assertTrue(Cart.verifyAddressDetailsVisible()); 
		    	 	Assert.assertTrue(Cart.verifyReviewYourOrder());

		    	      Cart.enterComment("Please deliver quickly");
		    	      Cart.placeOrderBtn.click();
		    	      Cart.enterPaymentDetails("Test User", "4111111111111111", "123", "12", "2025");
		    	      Cart.clickPayAndConfirmOrder();
		    	      Assert.assertTrue(Cart.verifyOrderSuccess());
//		    	      Cart.clickDeleteAccount();
//		    	      Assert.assertTrue(home.deletMessage.isDisplayed());
	}
}
