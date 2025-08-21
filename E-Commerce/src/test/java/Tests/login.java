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

public class login extends TestBase{
	HomePage home;
	ProductPage product;
	productDetailsPage details;
	LoginPage login;
	@DataProvider(name="LogInData")
	  public Object[][] LogInData(){
		Properties p =LoadPropertiesData.validlogData;
		Object[][] data = {
				{p.getProperty("email"),p.getProperty("password")}
		};
		return data;
	  }
	

	  @Test(dataProvider = "LogInData")
	  public void loginValid(String email,String pass) {
		  home=new HomePage(driver);
		  login = new LoginPage(driver);
		  login.clear();
		  Assert.assertEquals("Login to your account",login.loginConfermMessage.getText());
		  login.loginData(email, pass);
		  WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));;
		  wait.until(ExpectedConditions.visibilityOf(home.verifyLoggedin));
		  Assert.assertTrue(home.verifyLoggedin.getText().contains("Logged in as"));
//		  home.deletAccount();
//		  wait.until(ExpectedConditions.visibilityOf(home.deletMessage));
//		  Assert.assertEquals("ACCOUNT DELETED!",home.deletMessage.getText());
//		  home.backToHomePage();
	  }
	  
	  
}

