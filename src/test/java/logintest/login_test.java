package logintest;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.parabank.library_files.baseclass;
import com.parabank.library_files.utilityclass;

import junit.framework.Assert;
import module1_login.loginpage_POM_class;
import module2_profile.homepage;

public class login_test extends baseclass
{

	loginpage_POM_class login;
	homepage home;
	@BeforeClass
	public void loginobjects()
	{
		 login=new loginpage_POM_class(driver);
		 home=new homepage(driver);
	}
	
	@Test
	public void verifyusername() throws IOException
	{
		login.inpbankusername(utilityclass.propertyfiledata("username"));
		login.inpbankpassword(utilityclass.propertyfiledata("password"));
		login.clickbankloginbtn();
		String actresult=home.gethomepageusername();
		String expresult="Welcome Tariq Hussain";
		test=reports.createTest("vrify username");
		Assert.assertEquals(actresult, expresult);
	}
}
