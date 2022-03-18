package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) { 
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath = "//input[@value='radio2']") 
	public WebElement radioButton2;
	
	@FindBy(xpath = "//input[@id='autocomplete']")
	public WebElement suggestionClass;
		
	@FindBy(xpath = "//div[contains(text(),'Mexico')]")
	public WebElement selectMexico;
	
	@FindBy(xpath = "//select[@id='dropdown-class-example']")
	public WebElement dropDownMenu;
	
	@FindBy(xpath = "//option[contains(text(),'Option1')]")
	public WebElement option1;
	
	@FindBy(xpath = "//option[contains(text(),'Option2')]")
	public WebElement option2;
	
	@FindBy(xpath = "//option[contains(text(),'Option3')]")
	public WebElement option3;
	
	@FindBy(xpath = "//input[@id='checkBoxOption1']")
	public WebElement selectCheckbox1;
	
	@FindBy(xpath = "//input[@id='checkBoxOption2']")
	public WebElement selectCheckbox2;
	
	@FindBy(xpath = "//button[@id='openwindow']")
	public WebElement openWindow;
	
	@FindBy(xpath = "//a[@id='opentab']")
	public WebElement openTab;
	
	@FindBy(xpath = "//input[@id='name']")
	public WebElement alert;
	
	@FindBy(xpath = "//input[@id='alertbtn']")
	public WebElement clickAlert;
	
	@FindBy(xpath = "//input[@id='confirmbtn']")
	public WebElement clickConfirm;
		
	@FindBy(xpath = "//table[@name=\"courses\"]/tbody/child::*" )
	public List<WebElement> rows;
	
	@FindBy(xpath = "//div[@class='tableFixHead']/table/tbody/child::*")
	public List<WebElement> fixRows;
	
	@FindBy(xpath = "//div[contains(text(),'Total Amount Collected: 296')]")
	public WebElement totalAmount;
	
	@FindBy(xpath = "//input[@id='displayed-text']")
	public WebElement inputDisplayedText;
	
	@FindBy(xpath = "//input[@id='hide-textbox']")
	public WebElement hideButton;
	
	@FindBy(xpath = "//input[@id='show-textbox']")
	public WebElement showButton;
	
	@FindBy(xpath = "//div[@class='mouse-hover']")
	public WebElement mouseHover;
	
	@FindBy(xpath = "//a[contains(text(),'Top')]")
	public WebElement topButton;
	
	@FindBy(xpath = "//a[contains(text(),'Reload')]")
	public WebElement reloadButton;
	
	@FindBy(tagName = "iframe")
	public WebElement iFrame;
	
		
}
