package module2_profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage 
{
	@FindBy(xpath = "//p[@class='smallText']")
	private WebElement homepageusername;

	public homepage(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);

	}
	
	public String gethomepageusername()
	{
		String hpusername=homepageusername.getText();
		return hpusername;
	}

}
