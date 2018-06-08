package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.Landingpage;
import pageobjects.Loggingpage;
import resources.base;

public class Homepage extends base{
public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilaize() throws IOException
	{
		driver=initializedriver();	
		log.info("driver intialized");
	}
	
	@Test(dataProvider="getData")
	public void basepagenavigation(String email,String password,String login) throws IOException
	{
		//one is inheritance
		//creating objects to that class & invoke methods in it
		driver.get(prop.getProperty("url"));
		Landingpage l=new Landingpage(driver);
		l.getlogin().click();//equals to driver.findelement(By,Xpath))
		Loggingpage lp=new Loggingpage(driver);
		lp.getemail().sendKeys(email);
		lp.getpassword().sendKeys(password);
		log.info(login);
	
		lp.getlogin().click();	
	}
	
	@AfterTest
	public void teadown()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many diff data types should run
		//col stands for how many values for each test
	
		//array size is 2
		//0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricted@qa.com";
		data[0][1]="sdad";
		data[0][2]="restricted user";
	
		//1st row
	
		data[1][0]="restricted@qa.com";
		data[1][1]="sdaf";
		data[1][2]="non restricted user";
		
		return data;
	}
	
	
	

}
