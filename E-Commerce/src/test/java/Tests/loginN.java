package Tests;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.productDetailsPage;

public class loginN extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	LoginPage login;
	
	@DataProvider(name="LogInNData")
	  public Object[][] LogInNData(){
		Properties p =LoadPropertiesData.invalidLogInData;
		Object[][] data = {
				{p.getProperty("email"),p.getProperty("password")}
		};
		return data;
	  }

	 @Test(dataProvider = "LogInNData")
	  public void loginInValid(String email,String pass) {
		  home=new HomePage(driver);
		  login = new LoginPage(driver);
		  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
		  home.Signup_LoginBtn.click();
		  Assert.assertEquals("Login to your account",login.loginConfermMessage.getText());
		  login.loginData(email, pass);
		  Assert.assertTrue(login.loginfailMessage.getText().contains("Your email or password is incorrect!"));
	  }

	  
}

