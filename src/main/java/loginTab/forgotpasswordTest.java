package loginTab;

import static org.junit.Assert.assertFalse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class forgotpasswordTest {

	WebDriver dr;

	@Given("^navigate to login$")
	public void navigate_to_login() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		dr = new ChromeDriver();
		dr.get(prop.getProperty("url"));
		input.close();
	}

	@When("^user click forgot password button$")
	public void user_click_forgot_password_button() throws InterruptedException {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("src/test/resources/cuong.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dr.findElement(By.xpath(prop.getProperty("forgotButton"))).click();
		TimeUnit.SECONDS.sleep(2);
	}

	@Then("^redirects to forgot password page$")
	public void redirects_to_forgot_password_page() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("src/test/resources/cuong.properties");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String actual = dr.findElement(By.xpath(prop.getProperty("forgotText"))).getText();
		if (actual.contains(prop.getProperty("forgotMessage"))) {
			assertFalse(false);
		} else
			assertFalse(true);
		dr.close();
	}
}
