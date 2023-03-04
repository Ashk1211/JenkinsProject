package autoitPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.SeleniumUtility;

public class FileUploadPractice1 extends SeleniumUtility {

//	@Test
	public void testCase1() throws InterruptedException {

		WebDriver driver = setUp("chrome", "http://omayo.blogspot.com/2013/05/page-one.html");
//		driver.findElement(By.xpath("//body")).sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN); // Scroll to bottom of the page
		driver.findElement(By.xpath("//body")).sendKeys(Keys.END); // Scroll to bottom of the page

		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#uploadfile")).sendKeys("‪D:\\AutoIt\\Profile Pic.JPG");

	}

	@Test
	public void testCase2() throws InterruptedException, IOException {
		WebDriver driver = setUp("chrome", "http://omayo.blogspot.com/2013/05/page-one.html");
		driver.findElement(By.xpath("//body")).sendKeys(Keys.END); // Scroll to bottom of the page
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement uploadBtn = driver.findElement(By.xpath("//input[@id='uploadfile']"));

		js.executeScript("arguments[0].click()", uploadBtn);

		Thread.sleep(3000);

		Runtime.getRuntime().exec("‪‪D:\\AutoIt\\fileUpload.exe");

		Thread.sleep(3000);

		driver.close();

	}
}
