package Tests;

import org.testng.annotations.Test;

import Data.LoadPropertiesData;
import Pages.ContactUsRobotway;
import Pages.HomePage;
import org.testng.annotations.DataProvider;

import java.awt.AWTException;
import java.util.Properties;

import org.testng.Assert;



public class NegativeScenario extends TestBase{
	ContactUsRobotway contact;
	HomePage home;
	
	@DataProvider(name="ContactInvalidDate")
	  public Object[][] ContactInvalidDate(){
		Properties p =LoadPropertiesData.ContactInvalidDate;
		Object[][] data = {
				 {p.getProperty("name"), p.getProperty("email")}
		};
		return data;
	  }
		@Test(dataProvider = "ContactInvalidDate")
		public void testValidNameAndValidEmail(String name,String email) throws AWTException {
			
		 contact=new ContactUsRobotway(driver);
		  home=new HomePage(driver);
		  home.Contact.click();
		  contact=new ContactUsRobotway(driver);
		
		  contact.userCanFillTheField(name,email);
		 
	  	  Assert.assertEquals("Press OK to proceed!",contact.alert.getText());
	  	  contact.continueContactUs();
	  	  
		  Assert.assertTrue(contact.successMessage.getText().contains("Success! Your details have been submitted successfully."));
		  contact.userCanGoToHomePage();
		  
		  Assert.assertEquals("rgba(255, 165, 0, 1)", home.HomeBtn.getCssValue("color"));
			
			
	  }

}
