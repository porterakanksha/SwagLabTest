package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabPage {

	WebDriver pagedriver;

	// ==============================Objects============================================
	@FindBy(id = "user-name")
	WebElement user;

	@FindBy(id = "password")
	WebElement pass;

	@FindBy(name = "login-button")
	WebElement login;

	// ================================Methods===============================================

	public void LoginSwag(String Name, String Password) throws InterruptedException

	{
		Thread.sleep(2000);
		user.sendKeys(Name);
		pass.sendKeys(Password);
		login.click();
	}

	// ============================= PageFactory for element initialization  =====================

	public SwagLabPage(WebDriver driver) {
		pagedriver = driver;
		PageFactory.initElements(pagedriver, this);
	}

}
