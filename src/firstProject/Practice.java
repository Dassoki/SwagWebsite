package firstProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice {
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
	public void AddItemtothecart() {

		// driver.findElement(By.className("inventory_item_name"));
		driver.findElements(By.className(".btn.btn_primary.btn_small.btn_inventory"));
		List<WebElement> AllThePrices = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> NamesOfItems = driver.findElements(By.className("inventory_item_name"));
		List<WebElement> AllAddbuttons = driver.findElements(By.className("btn_primary"));

		
		for (int i = 0; i < AllThePrices.size(); i = i + 2) {
			if (i == 1 || i == 3 || i == 5) {
				
				continue;
			}
			AllAddbuttons.get(i).click();
			
			System.out.println(NamesOfItems.get(i).getText());
			System.out.println(AllThePrices.get(i).getText());
			System.out.println("this item has been skipped");

		}

	}
}
