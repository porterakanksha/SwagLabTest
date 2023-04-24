package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	Fillo fillo;
	Connection connect;
	
	@BeforeTest
	public void ReportSetup() throws FilloException
	{
		//reports = new ExtentReports("ExtentReport.html");
		fillo = new Fillo();
		connect = fillo.getConnection("DataSheet1.xlsx");
	}
	@BeforeMethod
	public void Setup()
	{
		
			//Driver setup and Launch the Browser 
			WebDriverManager.chromedriver().setup();
			this.driver =  new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			
			//Maximizing the browser 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
			System.out.println("The title of the page is " + driver.getTitle());
	}
		
		@AfterMethod
		public void Teardown()
		{
			
			driver.quit();
		}
	}


