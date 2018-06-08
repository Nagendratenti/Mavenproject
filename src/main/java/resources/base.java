package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializedriver() throws IOException
{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\mypgms\\Project\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		System.out.println("browsername");
		
		if(browsername.equals("chrome"))
		{
			//execute chrome driver
			System.setProperty("webdriver.chrome.driver", "D:\\JARS\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			//execute firefox driver
			System.setProperty("webdriver.gecko.driver", "D:\\JARS\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			//execute IE driver
			System.setProperty("webdriver.ie.driver", "D:\\JARS\\IEdriverserver.exe");
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
}
	//to get screenshot
public void getScreenshot(String result)
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.copyFile(src, new File("D://mypgms//screesnshot//"+result+"screesnshot.png"));
		
}
}
