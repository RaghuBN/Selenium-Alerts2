package AleartConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class DemoAlarts {
	WebDriver driver;

	@Test
	public void selectDDValues() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\Selenium Browsers Jars\\Chrome 84\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("login")).sendKeys("xyz123@gmail.com");
		driver.findElement(By.name("proceed")).click();

		Alert alert = driver.switchTo().alert();
		Thread.sleep(10000);
		System.out.println(alert.getText());
		String text = alert.getText();
		if (text.equals("Please enter a valid user name")) {
			System.out.println("Correct Alert Message");
		} else {
			System.out.println("Incorrect Alert Message");
		}

		alert.accept();
		// alert.dismiss();

		System.out.println(driver.getTitle());

		/*----------------------------------------Demo.Ksrtc.in---------------------------------------------------------------------*/

		driver.get("https://ksrtc.in/oprs-web/ticket/waitlist.do");
		driver.findElement(By.id("pnrPrefixWithTktNo")).sendKeys("124578563");
		Thread.sleep(10000);
		driver.findElement(By.name("searchBtn")).click();

		Alert alert1 = driver.switchTo().alert();
		
		System.out.println(alert1.getText());
		String text1 = alert.getText();
		Assert.assertEquals(alert.getText(), text1);
		System.out.println("Correct Alert Message");

		// if(text1.equals("Please enter valid ticket number to continue."))
		// {
		// System.out.println("Correct Alert Message");
		// }
		// else
		// {
		// System.out.println("Incorrect Alert Message");
		// }

		alert1.accept();
		// alert.dismiss();

	}

	@AfterTest
	public void testafte() {

		System.out.println(driver.getTitle());
		driver.quit();

	}
}
