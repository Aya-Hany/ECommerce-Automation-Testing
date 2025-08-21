package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productDetailsPage extends PageBase{

	public productDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//*[@id=\"review-section\"]/div/div/span")
	public WebElement reviewConfermMessage;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
	public WebElement name;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	public WebElement category;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
	public WebElement price;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b")
	public WebElement Availability;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b")
	public WebElement Condition;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b")
	public WebElement Brand;
	@FindBy(id = "name")
	WebElement nameTxt;
	@FindBy(id = "email")
	WebElement emailTxt;
	@FindBy(id = "review")
	WebElement messageTxt;
	@FindBy(id = "button-review")
	WebElement submitBtn;
	
	public void reviewData(String name,String email,String message) {
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		messageTxt.sendKeys(message);
		submitBtn.click();
	}
	@FindBy(linkText = "View Cart")
	public WebElement viewBtn;
	@FindBy(id = "quantity")
	WebElement quantitytxt;
	@FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button")
	public
	WebElement detailAddBtn;
	public void quantityEnter(String num) {
		quantitytxt.clear();
		quantitytxt.sendKeys(num);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].blur();", quantitytxt);//stop focuse
		detailAddBtn.click();
		viewBtn.click();
	}
	
}
