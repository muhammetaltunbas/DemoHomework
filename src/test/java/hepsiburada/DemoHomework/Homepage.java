package hepsiburada.DemoHomework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Landingpage;
import pageObjects.Loginpage;
import pageObjects.Products;

public class Homepage extends Base {
	public String loginExpectedUrl="https://www.hepsiburada.com/uyelik/giris?ReturnUrl=%2F";
	public String myBasketUrl="https://www.hepsiburada.com/ayagina-gelsin/sepetim";
	public String generalUrl;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		
	}

	@Test
	public void goAccount() throws IOException, InterruptedException {
		
		
		Landingpage l = new Landingpage(driver);
		Loginpage lp = new Loginpage(driver);
		l.openAccountTab();
		// For Firefox there is issue
		l.clickLogin().click();
		
		generalUrl=driver.getCurrentUrl();
		Assert.assertEquals(generalUrl, loginExpectedUrl);
		
		lp.getUsername().sendKeys(prop.getProperty("username"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.accessAccount().click();
		
	}
	@Test
	public void goAraundOnProducts() 
	{
		
		Products pr = new Products(driver);
		pr.seeProduct();
		pr.getProductInfo();

	}
	@Test
	public void goBasket()
	{
		Products pr = new Products(driver);
		pr.goToBasket().click();
		generalUrl=driver.getCurrentUrl();
		Assert.assertEquals(generalUrl, myBasketUrl);
		pr.checkHomeProducts();
	}
	@Test
	public void verifyProducts()
	{
		Products pr = new Products(driver);
		Assert.assertTrue(pr.verifyProducts());
		
	}
	
	@AfterTest
	public void teardown()
	{
		//driver.quit();
	}
	
}