package Tests;

import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Data.LoadPropertiesData;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Pages.CartPage;
import Pages.HomePage;
import Pages.NewAccount;
import Pages.ProductPage;
import Pages.RegisterPage;
import Pages.productDetailsPage;

public class Registerbeforecheckout extends TestBase {  
	HomePage home;
	CartPage Cart;
	NewAccount account;
	productDetailsPage detail;
	RegisterPage Register;
	@DataProvider(name="getAData")
	public Object[][] getData() throws IOException{
		Properties p =LoadPropertiesData.NewAccountData;
		Object[][] data = {
				{p.getProperty("title"),p.getProperty("email"),p.getProperty("name"),p.getProperty("password"),p.getProperty("day"),p.getProperty("month"),
				 p.getProperty("year"),p.getProperty("FName"),p.getProperty("LName"),p.getProperty("Company"),p.getProperty("Address"),
		         p.getProperty("Address2"),p.getProperty("Country"),p.getProperty("State"),p.getProperty("City"),p.getProperty("Zipcode"),
		         p.getProperty("Mobile_Number")}
		};
		return data;
	}
	@Test(dataProvider = "getAData")
	public void testPlaceOrderRegisterBeforeeCheckout(String title,String name,String email,String password,String day,String month,String year,String FName,String LName,String Company,String Address,
			String Address2,String Country,String State,String City,String Zipcode,String Mobile_Number) {
		home=new HomePage(driver);
		Cart=new CartPage(driver);
		Register = new RegisterPage(driver);
		detail=new productDetailsPage(driver);
		account = new NewAccount(driver);
		Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
	home.Signup_LoginBtn.click();
	 Register.fillRegisterField(email, name);
	  WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(Register.confirmRegister));
	  Assert.assertEquals("ENTER ACCOUNT INFORMATION", Register.confirmRegister.getText());
	  home.closeGoogleAdIfPresent();
	  account.fillTheAccountInformationFields(title,name,password,day,month,year);
    if(account.FirstCheckBox.getText().contains("Sign up for our newsletter!")&& (!account.FirstCheckBox.isSelected())) {
		 account.FirstCheckBox.click();
	  }
	  if(account.SecondCheckBox.getText().contains("Receive special offers from our partners!")&& (!account.SecondCheckBox.isSelected())) {
		  account.SecondCheckBox.click();
	 }
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].scrollIntoView(false);",home.subscriptionMessage);

    account.fillTheAddressInformationFields(FName, LName, Company, Address, Address2, Country, State, City, Zipcode, Mobile_Number);
   // Assert.assertTrue(account.createdMessage.isDisplayed(), "Account not created!");
    Assert.assertEquals( account.createdMessage.getText(),  "ACCOUNT CREATED!");
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement continueBtn = wait1.until(
        ExpectedConditions.elementToBeClickable(By.cssSelector(".btn-primary"))
    );

    account.continuebtn.click();
    Assert.assertTrue(home.verifyLoggedin.getText().contains("Logged in as"));
	  home.gotoCartPage();
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
    	      Cart.clickDeleteAccount();
    	      Assert.assertTrue(home.deletMessage.isDisplayed());

}
}
