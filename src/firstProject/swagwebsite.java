package firstProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class swagwebsite {

	WebDriver driver = new ChromeDriver();

	@BeforeTest

	public void mySetup() {

		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void login() {

		// Elements
		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));

		WebElement LoginButton = driver.findElement(By.id("login-button"));

		// actions

		UserNameInputField.sendKeys("standard_user");

		PasswordInputField.sendKeys("secret_sauce");

		LoginButton.click();

	}

	@Test(priority = 2)
	public void addToCart() throws InterruptedException {

		Thread.sleep(2000);

		// elements

		WebElement FirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement SecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

		// actions
		FirstItem.click();
		SecondItem.click();
	}

	@Test(priority = 3)

	public void CheckoutProcess() {

		// driver.navigate().to("https://www.saucedemo.com/cart.html");
		driver.findElement(By.className("shopping_cart_link")).click();
		WebElement CheckoutButton = driver.findElement(By.id("checkout"));

		CheckoutButton.click();

		// elements
		WebElement FirstName = driver.findElement(By.id("first-name"));
		WebElement LastName = driver.findElement(By.id("last-name"));
		WebElement PostalCode = driver.findElement(By.id("postal-code"));

		// actions

		FirstName.sendKeys("Abdulrahman");
		LastName.sendKeys("Dassoki");
		PostalCode.sendKeys("1010");

		WebElement ContinueButton = driver.findElement(By.name("continue"));

		ContinueButton.click();

		WebElement FinishButton = driver.findElement(By.name("finish"));

		FinishButton.click();
	}

	@Test(priority = 3, enabled = false)
	public void removeFromCart() throws InterruptedException {

		Thread.sleep(2000);
		// elements

		WebElement firstItem = driver.findElement(By.id("remove-sauce-labs-backpack"));
		WebElement SecondItem = driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));

		// actions
		firstItem.click();
		SecondItem.click();
	}

	@Test(priority = 4, enabled = false)
	public void addToCartAfterTheRemove() throws InterruptedException {

		Thread.sleep(2000);

		// elements

		WebElement firstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		WebElement SecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));

		// actions
		firstItem.click();
		SecondItem.click();
	}

	@Test(priority = 5, enabled = false)

	public void logout() throws InterruptedException {

		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));

		BurgerMenu.click();

		Thread.sleep(1000);

		WebElement LogoutButton = driver.findElement(By.id("logout_sidebar_link"));

		LogoutButton.click();

	}

	@AfterTest
	public void AfterThetestIsDone() {
		// driver.close();
	}

}