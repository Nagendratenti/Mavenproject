package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.Landingpage;
import resources.base;

public class validatetitle extends base{
public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilaize() throws IOException
	{
		driver=initializedriver();
		log.info("driver intialized");
		
		driver.get(prop.getProperty("url"));
		log.info("Navigated to homepage");
	}
	
	@Test()
	public void basepagenavigation() throws IOException
	{
		//one is inheritance
		//creating objects to that class & invoke methods in it
		Landingpage l=new Landingpage(driver);
		//compare the text from the browser with actual text
		Assert.assertEquals(l.gettitle().getText(), "FEATURED COURSES");
	    log.info("successfully validated");
			
	}
	
	@AfterTest
	public void teadown()
	{
		driver.close();
		driver=null;
	}
	}
	
	
	

