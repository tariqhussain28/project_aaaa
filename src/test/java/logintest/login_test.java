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
		logs.info("entering username");
		login.inpbankusername(utilityclass.propertyfiledata("username"));
		logs.info("entering password");
		login.inpbankpassword(utilityclass.propertyfiledata("password"));
		logs.info("clicking login button");
		login.clickbankloginbtn();
		String actresult=home.gethomepageusername();
		logs.info("getting home page username");
		String expresult="Welcome Amber Heard";
		test=reports.createTest("vrify username");
		logs.info("checking expected and actual username");
		Assert.assertEquals(actresult, expresult);
	}
}
