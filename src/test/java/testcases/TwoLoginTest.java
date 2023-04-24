package testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.SwagLabPage;

public class TwoLoginTest extends BaseClass {

	// Positive Case
	@Test
	public void Positive() throws InterruptedException {
		SwagLabPage login1 = new SwagLabPage(driver);
		login1.LoginSwag("standard_user", "secret_sauce");

	}

	/*
	 * //Negative Case
	 * 
	 * @Test public void Negative() throws InterruptedException { SwagLabPage login1
	 * = new SwagLabPage(driver); login1.LoginSwag("akanksha","secret_sauce");
	 * Thread.sleep(2000); WebElement error =
	 * driver.findElement(By.xpath("//button[@class='error-button']")); String
	 * ActError = error.getText(); String ExpError =
	 * "Epic sadface: Username and password do not match any user in this service";
	 * 
	 * //Epic sadface: Username and password do not match any user in this service
	 * AssertJUnit.assertEquals(ActError, ExpError);
	 * 
	 * }
	 */
	@Test
	public void Datafromsheet() throws FilloException, InterruptedException {

		Recordset recordset = connect.executeQuery("select * from data where TestName='Datafromsheet'");
		recordset.next();

		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		SwagLabPage login = new SwagLabPage(driver);
		login.LoginSwag(UserName, Password);
		Thread.sleep(1000);

	}
}
