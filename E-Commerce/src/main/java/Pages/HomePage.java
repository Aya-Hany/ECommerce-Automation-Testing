package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{
	public HomePage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "scrollUp")
	public WebElement upArrow;
	@FindBy(xpath = "//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2")
	public WebElement subscriptionMessage;
	@FindBy(xpath = "//*[@id=\"slider-carousel\"]/div/div[3]/div[1]/h2")
	public WebElement bannerMessage;
	@FindBy(linkText = "Home")
	public WebElement HomeBtn;
	@FindBy(linkText = "Signup / Login")
	public WebElement Signup_LoginBtn;
	
	public void closeGoogleAdIfPresent() {
	    try {
	        List<WebElement> ads = driver.findElements(By.id("aswift_1"));
	        if (!ads.isEmpty()) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", ads.get(0));
	        }
	    } catch (Exception e) {
	        System.out.println("No ad found or unable to hide it: " + e.getMessage());
	    }
	}

	@FindBy(xpath = "//*[@id=\"slider-carousel\"]/a[1]/i")
	WebElement leftArrow;
	
	@FindBy(partialLinkText  = "Products")
	WebElement ProductBtn;
	public void goToProductPage() {
		ProductBtn.click();
	}
	
	
	@FindBy(partialLinkText  = "Cart")
	public WebElement cartBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
	public WebElement verifyLoggedin;
	
	@FindBy(linkText = "Delete Account")
	 WebElement Deletbtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	public WebElement deletMessage;
	
	@FindBy(className = "btn-primary")
	WebElement continuebtn;
	
	public void goToRegisterPage() {
		Signup_LoginBtn.click();
	}
	public void deletAccount() {
		Deletbtn.click();
	}
	public void backToHomePage() {
		continuebtn.click();
	}
	@FindBy(id = "susbscribe_email")
	 WebElement subscribtionTxt;
	@FindBy(id = "subscribe")
	 WebElement subscribtionBtn;
	@FindBy(id = "success-subscribe")
	public WebElement subscribtionSuccess;
	public void subscribtion(String email) {
		subscribtionTxt.sendKeys(email);
		subscribtionBtn.click();
	}
	@FindBy(partialLinkText = "Test Cases")
	public WebElement testCase;
	@FindBy(partialLinkText = "API Testing")
	public WebElement APICase;
	@FindBy(partialLinkText = "Contact")
	public WebElement Contact;
	
	@FindBy(id = "recommended-item-carousel")
	public WebElement recomended;
	@FindBy(css = "a[data-product-id='1']")
	public WebElement recomendedAdd;
	
	public void gotoCartPage() {
		cartBtn.click();
	}
}
