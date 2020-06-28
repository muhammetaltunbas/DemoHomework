package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Landingpage {

	public WebDriver driver;

	By openLoginArea = By.id("myAccount");
	By logIn = By.id("login");

	public Landingpage(WebDriver driver) {//Constructor
		this.driver = driver;
	}

	public void openAccountTab() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(openLoginArea)).build().perform();

	}

	public WebElement clickLogin() {
		return driver.findElement(logIn);
	}

}
