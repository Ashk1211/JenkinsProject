package brokenLinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utility.SeleniumUtility;

public class BrokenLinks extends SeleniumUtility {

	@Test()

	public void testCase1() throws IOException, InterruptedException {
		WebDriver driver = setUp("chrome", "https://www.zlti.com/");

//		first capture all the links
//		links will be present with <a>

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links present : " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");

			URL link = new URL(url);

//			create connection using URL object
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();

//			wait for some time to establish the connection
			Thread.sleep(3000);

			httpConn.connect();

			int responseCode = httpConn.getResponseCode();
			if (responseCode >= 400)
				System.out.println(url + " : " + "is a broken link");

//			else
//				System.out.println(url + " : " + "is a valid link");

		}

	}
}
