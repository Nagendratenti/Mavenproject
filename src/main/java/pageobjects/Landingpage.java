package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	
	public WebDriver driver;
	By signin=By.xpath("//*[@class='pull-right']/ul/li[4]/a");
	By title=By.xpath("//*[@id='content']/div/div/h2");
	By Navbar=By.xpath("//*[@id='homepage']/header/div[2]/div/nav/ul/li[7]/a");
	
	public Landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getlogin()
	{
		return driver.findElement(signin);
	}
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	public WebElement getnavigationbar()
	{
		return driver.findElement(Navbar);
	}

}
