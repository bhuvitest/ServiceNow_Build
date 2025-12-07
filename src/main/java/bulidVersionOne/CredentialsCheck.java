package bulidVersionOne;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CredentialsCheck {
	@Test(priority = 1)
	public void runBuildBhuvanesh() {

		ChromeDriver driver = new ChromeDriver();
		//1. Launch ServiceNow application
		driver.get("https://dev300891.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //2. Login with valid credentials username as admin and password
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("03-xMN$nqSmU");
		WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();
		driver.quit();
	}
	
	@Test(priority = 2)
	public void runBuildSeeni() {

		ChromeDriver driver = new ChromeDriver();
		//1. Launch ServiceNow application
		driver.get("https://dev181504.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //2. Login with valid credentials username as admin and password
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("F/*jyM6Q6pHh");
		WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();
		driver.quit();

	}

}
