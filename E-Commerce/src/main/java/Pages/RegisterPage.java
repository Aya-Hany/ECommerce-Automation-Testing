package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath ="//*[@id=\"form\"]/div/div/div[3]/div/h2")
	public WebElement RegisterMessage;
	
	@FindBy(name = "name")
	WebElement nameTxt;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
	WebElement emailTxt;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
	WebElement Registerbtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div[1]/h2/b")
	public WebElement confirmRegister;
	

	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
	public WebElement errorRegister;
	
	public void fillRegisterField(String name,String Email) {
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(Email);
		Registerbtn.click();
	}
	
	
	
	

}
