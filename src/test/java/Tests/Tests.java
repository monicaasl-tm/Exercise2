package Tests;

import static org.testng.Assert.assertNotNull;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;

public class Tests {

	public String baseURL = "https://rahulshettyacademy.com/AutomationPractice/";

	private String driverPath = "src/test/resources/drivers/chromedriver";
	private WebDriver driver;
	private HomePage home;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		this.driver = new ChromeDriver();
		this.home = new HomePage(this.driver);
		this.driver.get(baseURL);
		this.driver.manage().window().maximize();
	}

	// Radio Button Example
	@Test
	public void radioButton() {

		this.home.radioButton2.click();

		Assert.assertTrue(this.home.radioButton2.isSelected());
		System.out.println("Radio button is selected: " + home.radioButton2.isSelected());
	}

	// Suggestion Class Example
	@Test
	public void suggestionClass() {
		this.home.suggestionClass.click();
		this.home.suggestionClass.sendKeys("Mexico");
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(home.selectMexico));
		this.home.selectMexico.click();

	}

	// SDropdown Example
	@Test
	public void dropdownExample() {
		this.home.dropDownMenu.click();

		Assert.assertEquals(this.home.option1.getText(), "Option1");
		Assert.assertEquals(this.home.option2.getText(), "Option2");
		Assert.assertEquals(this.home.option3.getText(), "Option3");

		this.home.option2.click();
		Assert.assertTrue(this.home.option2.isDisplayed());

		this.home.selectCheckbox1.click();
		Assert.assertTrue(this.home.selectCheckbox1.isSelected());

		this.home.selectCheckbox2.click();
		Assert.assertTrue(this.home.selectCheckbox2.isSelected());

	}

	// Switch Window Example
	@Test
	public void switchWindow() {
		this.home.openWindow.click();

		String originalWindow = this.driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		Assert.assertEquals(this.driver.getTitle(),
				"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy");

		// after testing second window
		this.driver.close();
		this.driver.switchTo().window(originalWindow);
	}

	// Switch Tab Example
	@Test
	public void switchTab() {
		this.home.openTab.click();

		String originalWindow = this.driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		Assert.assertEquals(this.driver.getTitle(), "Rahul Shetty Academy");

		// after testing second window
		this.driver.close();
		this.driver.switchTo().window(originalWindow);
	}

	// Switch To Alert Example
	@Test
	public void alert() {
		this.home.alert.click();
		this.home.alert.sendKeys("Monica");
		this.home.clickAlert.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		this.home.alert.sendKeys("Monica");
		this.home.clickConfirm.click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();

	}

	// Web Table Example
	@Test
	public void webTable() {
		this.home.rows.forEach(row -> {
			List<WebElement> rowData = row.findElements(By.tagName("td"));
			if (rowData.size() > 0) {
				Assert.assertEquals("Rahul Shetty", rowData.get(0).getText());
			}

		});

	}

	// Web Table Fixed HeaderExample
	@Test
	public void webTableFixedHeader() {
		int totalAmount = 0;
		for (WebElement row : this.home.fixRows) {
			List<WebElement> rowData = row.findElements(By.tagName("td"));
			if (rowData.size() > 0) {
				int amount = Integer.parseInt(rowData.get(3).getText());
				Assert.assertTrue(amount > 0);
				totalAmount += amount;
			}
		}
		String totalString = String.valueOf(totalAmount);
		Assert.assertTrue(this.home.totalAmount.getText().contains(totalString));

	}

	// Element Displayed Example
	@Test
	public void elementDisplayed() {
		this.home.inputDisplayedText.sendKeys("Mexico");
		this.home.hideButton.click();
		Assert.assertFalse(this.home.inputDisplayedText.isDisplayed());
		this.home.showButton.click();
		Assert.assertTrue(this.home.inputDisplayedText.isDisplayed());

	}

	// Mouse Hover Example
	@Test
	public void mouseHover() {
		Actions actions = new Actions(this.driver);
		actions.moveToElement(this.home.mouseHover);
		actions.click().build().perform();

		Assert.assertTrue(this.home.topButton.isDisplayed());
		Assert.assertTrue(this.home.reloadButton.isDisplayed());
	}

	// iFrame Example
	@Test
		public void iFrame(){	
			Actions action = new Actions(this.driver);
			action.moveToElement(this.home.iFrame).perform();
			this.driver.switchTo().frame(this.home.iFrame);
			WebElement joinButton = this.home.iFrame.findElement(By.xpath("//a[contains(text(), 'JOIN NOW')]"));
			Assert.assertTrue(joinButton.isDisplayed());
		}

	@AfterTest
	public void tearDown() {
		this.driver.close();
	}

}
