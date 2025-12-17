package bulidVersionOne;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class CredentialsCheck {
	
	
	
	public  ChromeDriver driver;
	@Test(priority = 1)
	public void runBuildBhuvanesh() throws InterruptedException {

		driver = new ChromeDriver();
		Wait<ChromeDriver> wait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(300))   // hibernation can take time
		        .pollingEvery(Duration.ofSeconds(10))
		        .ignoring(NoSuchElementException.class)
		        .ignoring(StaleElementReferenceException.class);
		driver.manage().window().maximize();
		driver.get("https://dev300891.service-now.com/");
		try {
			
			driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("03-xMN$nqSmU");
			WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));
			login.click();
			 driver.quit();
		} catch (Exception e) {
			Shadow sh = new Shadow(driver);
			
			if (driver.getPageSource().contains("Instance Hibernating page")) {
			   
			    wait.until(ExpectedConditions
			            .elementToBeClickable(By.xpath("//button[contains(text(),'Sign in')]")))
			            .click();

			    sh.setImplicitWait(15);
			    sh.findElementByXPath("//span[text()='Sign in']").click();

			    wait.until(ExpectedConditions.visibilityOfElementLocated(
			            By.xpath("//input[@name='username']")))
			            .sendKeys("bhuvanesh.moorthy@testleaf.com");

			    wait.until(ExpectedConditions.elementToBeClickable(
			            By.xpath("//button[@type='submit']")))
			            .click();

			    wait.until(ExpectedConditions.visibilityOfElementLocated(
			            By.xpath("//input[@name='password']")))
			            .sendKeys("Qeagle@2025");

			    driver.findElement(By.xpath("//button[@type='submit']")).click();
			    
			    WebElement onlineStatus = wait.until(driver -> {
			        WebElement el = sh.findElementByXPath("//span[text()='Online']");
			        return el.isDisplayed() ? el : null;
			    });
			    Assert.assertTrue(onlineStatus.isDisplayed());
			    
			    driver.quit();
			} else {
			    // Normal login flow
			    wait.until(ExpectedConditions.visibilityOfElementLocated(
			            By.id("user_name"))).sendKeys("admin");

			    driver.findElement(By.id("user_password"))
			            .sendKeys("03-xMN$nqSmU");

			    driver.findElement(By.xpath("//button[text()='Log in']")).click();
			    
			    driver.quit();
			}

			}
	}
	
	@Test(priority = 2)
	public void runBuildSeeni() {

	     driver = new ChromeDriver();
		driver.get("https://dev181504.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("F/*jyM6Q6pHh");
		WebElement login = driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();
		driver.quit();

	}

}
