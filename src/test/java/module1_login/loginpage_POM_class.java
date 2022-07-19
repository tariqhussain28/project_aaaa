package module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage_POM_class 
{

	@FindBy(xpath="(//input[@class='input'])[1]") private WebElement username;
	@FindBy(xpath="(//input[@class='input'])[2]") private WebElement password;
	@FindBy(xpath="//input[@value='Log In']") private WebElement loginbutton;
	
	public loginpage_POM_class(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void inpbankusername(String un)
	{
		username.sendKeys(un);
	}
	
	public void inpbankpassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickbankloginbtn()
	{
		loginbutton.click();
	}
}
