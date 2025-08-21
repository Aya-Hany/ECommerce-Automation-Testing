package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.Select;


public class NewAccount extends PageBase{

	public NewAccount(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[1]/label")
	WebElement MrRbtn;
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/div[1]/div[2]/label")
	WebElement MrsRbtn;
	
	@FindBy(id = "name")
	WebElement nameTxt;
	
	@FindBy(name="password")
	WebElement passwordTxt;
	
	@FindBy(name = "days")
	WebElement dayTxt;
	
	@FindBy(name = "months")
	WebElement monthTxt;
	
	@FindBy(name = "years")
	WebElement yearTxt;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/div[6]/label")
	public WebElement FirstCheckBox;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/form/div[7]/label")
	public WebElement SecondCheckBox;
	
	@FindBy(id = "first_name")
	WebElement firstNameTxt;
	
	@FindBy(id = "last_name")
	WebElement LastNameTxt;
	
	@FindBy(id = "company")
	WebElement companyTxt;
	
	@FindBy(id = "address1")
	WebElement address1Txt;
	
	@FindBy(id = "address2")
	WebElement address2Txt;
	
	@FindBy(id = "country")
	WebElement CountryDL;
	
	@FindBy(id = "state")
	WebElement stateTxt;
	
	@FindBy(id = "city")
	WebElement cityTxt;
	
	@FindBy(id = "zipcode")
	WebElement zipcodeTxt;
	
	@FindBy(id = "mobile_number")
	WebElement mobileTxt;
	
	@FindBy(className = "btn-default")
	public
	WebElement submitTxt;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement createdMessage;
	
	@FindBy(className = "btn-primary")
	public
	WebElement continuebtn;
	
	public void fillTheAccountInformationFields(String title,String name,String password,String day,String month,String year) {
		if("Mrs".equalsIgnoreCase(title)) {
			MrsRbtn.click();
		}else {
			MrRbtn.click();
		}
		
		nameTxt.sendKeys(name);
		passwordTxt.sendKeys(password);
		Select Sday = new Select(dayTxt);
		Sday.selectByValue(day);
		Select Smonth = new Select(monthTxt);
		Smonth.selectByVisibleText(month);
		Select Syear = new Select(yearTxt);
		Syear.selectByValue(year);
	}
	public void fillTheAddressInformationFields(String FName,String LName,String Company,String Address,
			String Address2,String Country,String State,String City,String Zipcode,String Mobile_Number) {
			firstNameTxt.sendKeys(FName);
			LastNameTxt.sendKeys(LName);
			companyTxt.sendKeys(Company);
			address1Txt.sendKeys(Address);
			address2Txt.sendKeys(Address2);
			Select SCountry = new Select(CountryDL);
			SCountry.selectByVisibleText(Country);
			stateTxt.sendKeys(State);
			cityTxt.sendKeys(City);
			zipcodeTxt.sendKeys(Zipcode);
			mobileTxt.sendKeys(Mobile_Number);
			submitTxt.click();
			
	}
	public void goToHomePage() {
		continuebtn.click();
	}
	
}
