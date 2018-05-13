package trainerTab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ptoTrainer {
	WebDriver dr;

	@Given("^navigate to trainer$")
	public void navigate_to_trainer() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		dr = new ChromeDriver();
		dr.get(prop.getProperty("url"));
		dr.findElement(By.xpath(prop.getProperty("loginUser"))).sendKeys(prop.getProperty("trainerUser"));
		dr.findElement(By.xpath(prop.getProperty("loginPass"))).sendKeys(prop.getProperty("trainerPass"));
		dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();
	}

	@When("^tab is clicked$")
	public void tab_is_clicked() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(7);
		dr.findElement(By.xpath(prop.getProperty("trainerTab"))).click();
	}

	@And("^calendar button clicked$")
	public void calendar_button_clicked() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(3);
		dr.findElement(By.xpath(prop.getProperty("calendarButton"))).click();
	}

	@Then("^Calender shows$")
	public void calender_shows() {
	}

}
