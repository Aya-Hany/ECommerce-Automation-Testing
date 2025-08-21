package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
	public WebElement loginConfermMessage;
	
	@FindBy(name = "email")
	WebElement emailBtn;
	@FindBy(name = "password")
	WebElement passBtn;
	@FindBy(className = "btn-default")
	WebElement loginBtn;
	public void loginData(String email,String pass) {
		emailBtn.sendKeys(email);
		passBtn.sendKeys(pass);
		loginBtn.click();
	}
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
	public WebElement loginfailMessage;
	@FindBy(xpath =  "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
	public WebElement logoutBtn;
	
	public void clear() {
		emailBtn.clear();
		passBtn.clear();
	}

}
