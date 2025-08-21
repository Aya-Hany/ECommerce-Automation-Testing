package Tests;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.HomePage;
import Pages.RegisterPage;

public class RegisterNegativeSenario extends TestBase{
	HomePage home;
	RegisterPage Register;
	@DataProvider(name="getNData")
	public Object[][] getPositiveData() throws IOException{
		Properties p =LoadPropertiesData.RegisterNData;
		Object[][] data = {
				{p.getProperty("name"),p.getProperty("email")}
		};
		return data;
	}
  @Test(dataProvider = "getNData")
  public void RegisterWithExistEmail(String name,String email) {
	   home = new HomePage(driver);
	   Register = new RegisterPage(driver);
		  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
		  home.goToRegisterPage();
		  
		  Assert.assertEquals("New User Signup!",Register.RegisterMessage.getText());
		  Register.fillRegisterField(name, email);
		  
		  Assert.assertEquals("Email Address already exist!", Register.errorRegister.getText());
  }
}
