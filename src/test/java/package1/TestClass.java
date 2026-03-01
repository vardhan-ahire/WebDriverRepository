package package1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Webdriver initialized");
		
	}
	@Test
	public void doLogin()
	{
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("pieter.parker2020@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Spiderman1!");
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		System.out.println("Clicking on the login button");
	}
	@AfterTest
	public void tearDown() throws Exception
	{
		
		Thread.sleep(10000);
		driver.close();
		System.out.println("The browser has been closed");
	}
}
