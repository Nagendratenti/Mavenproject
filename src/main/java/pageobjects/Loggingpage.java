package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loggingpage {
	
	public WebDriver driver;
	By email=By.xpath("//input[@type='email']");
	By password=By.xpath("//input[@id='user_password']");
	By login=By.xpath("//input[@name='commit']");
	
	
	
	public Loggingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	

}
