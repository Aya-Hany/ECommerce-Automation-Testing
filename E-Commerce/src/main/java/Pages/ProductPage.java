package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "text-center")
	public WebElement ProductConfermMessage;
	@FindBy(id = "search_product")
	WebElement searchFieldTxt;
	@FindBy(id = "submit_search")
	WebElement searchFieldBtn;
	@FindBy(className = "features_items")
	WebElement list;
	@FindBy(className = "col-sm-4")
	public List<WebElement> products;
	@FindBy(linkText = "View Product")
	WebElement viewProductBtn;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public void goTODetailsPage() {
		js.executeScript("arguments[0].click();", viewProductBtn);
	}
	
	@FindBy(xpath  = "/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a")
	public WebElement ViewConfermMessage;
	
	@FindBy(id = "search_product")
	WebElement searchTxt;
	@FindBy(id = "submit_search")
	WebElement searchBtn;
	
	public void search(String Data) {
		searchTxt.clear();
		searchTxt.sendKeys(Data);
		searchBtn.click();
	}
	@FindBy(className = "text-center")
	public WebElement searchConferm;
	
	public boolean resultOfSearch(String Data) {
		List <WebElement> results =list.findElements(By.cssSelector(".col-sm-4 .product-image-wrapper .single-products .productinfo.text-center p"));
		Data=Data.toLowerCase();
		for (WebElement result : results) {
			if(!result.getText().toLowerCase().contains(Data))
				return false;
		}
		return true;
	}
	List<String> addNames = new ArrayList<>();
	@FindBy(className = "close-modal")
	 WebElement continueBtn;
	@FindBy(linkText = "View Cart")
	public WebElement viewBtn;
	public void resultOfSearchToAdd() {
		List <WebElement> AddBtn =list.findElements(By.cssSelector(".col-sm-4 .product-image-wrapper .single-products .productinfo.text-center .add-to-cart "));
		List <WebElement> name =list.findElements(By.cssSelector(".col-sm-4 .product-image-wrapper .single-products .productinfo.text-center p"));
		
		int i = 0;
		for (WebElement Add : AddBtn) {
			if(i % 2==0) {
				js.executeScript("arguments[0].click();",Add);
				addNames.addLast(name.get(i).getText());
			}
			if(i!=AddBtn.size()-2) {
				continueBtn.click();
			}else {
				viewBtn.click();
			}
		}
	}
	
	@FindBy(tagName = "tbody")
	WebElement cartProducts;
	public boolean checkCart() {
		boolean test = false;
		List <WebElement> results2 =cartProducts.findElements(By.cssSelector("#product-1 .cart_description h4 a"));
		for (WebElement result : results2) {
			for(String res : addNames) {
				if(result.toString().equals(res)) {
					test=true;
				}
				continue;
			}
		}
		return test;
	}
	
	
	@FindBy(css = ".left-sidebar h2")
	 WebElement title1;
	@FindBy(css = ".brands_products h2")
	 WebElement title2;
	 public boolean check(String value) {
		 if(title1.equals(value)||title2.equals(value)) {
			 return true;
		 }
		 return false;
	 }
	 @FindBy(partialLinkText = "WOMEN")
	 WebElement Womenlistbtn;
	 @FindBy(partialLinkText = "DRESS")
	 WebElement Dresslistbtn;
	public void goToCategoryWomen() {
		Womenlistbtn.click();
		Dresslistbtn.click();
	}
	@FindBy(className =  "text-center")
	public WebElement categoryConferm;
	  
	@FindBy(linkText = "MEN")
	 WebElement Menlistbtn;
	@FindBy(partialLinkText = "JEANS")
	 WebElement Jeanslistbtn;
	
	public void goToCategoryMen() {
		Menlistbtn.click();
		Jeanslistbtn.click();
	}
	@FindBy(partialLinkText = "POLO")
	public WebElement poloBrandBtn;
	@FindBy(partialLinkText = "H&M")
	public WebElement HMBrandBtn;
	
	@FindBy(css = "[data-product-id='2']")
	public WebElement hoverAddBtn;
	@FindBy(className = "single-products")
	public WebElement hovercard;
	
	@FindBy(css = ".cart_price p")
	public WebElement cPice;
	@FindBy(className = "disabled")
	public WebElement cquantity;
	@FindBy(className = "cart_total_price")
	public WebElement cTotal;
	
	
}
