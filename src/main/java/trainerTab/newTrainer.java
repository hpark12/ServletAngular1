package trainerTab;

import static org.junit.Assert.assertFalse;

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

public class newTrainer {
	WebDriver dr;
	@Given("^navigate to vp trainer$")
	public void navigate_to_vp_trainer() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		dr = new ChromeDriver();
		dr.get(prop.getProperty("url"));
		dr.findElement(By.xpath(prop.getProperty("loginUser"))).sendKeys(prop.getProperty("vpUser"));
		dr.findElement(By.xpath(prop.getProperty("loginPass"))).sendKeys(prop.getProperty("vpPass"));
		dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();
	}

	@When("^add trainer button clicked$")
	public void trainer_tab_clicked() throws IOException, InterruptedException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(7);
		dr.findElement(By.xpath(prop.getProperty("trainerTab"))).click();
		TimeUnit.SECONDS.sleep(2);
		dr.findElement(By.xpath(prop.getProperty("trainerButton"))).click();
	}
	
	@And("^add trainer form filled$")
	public void trainer_form_filled() throws IOException, InterruptedException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(1);
		dr.findElement(By.xpath(prop.getProperty("trainerFirst"))).sendKeys(prop.getProperty("newTrainer1"));
		dr.findElement(By.xpath(prop.getProperty("trainerLast"))).sendKeys(prop.getProperty("newTrainer2"));
		dr.findElement(By.xpath(prop.getProperty("trainerSave"))).click();
		TimeUnit.SECONDS.sleep(1);
		
	}

	@Then("^new trainer added$")
	public void new_trainer_added() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		if (dr.getPageSource().contains(prop.getProperty("newTrainer1")) & dr.getPageSource().contains(prop.getProperty("newTrainer2"))) {
			assertFalse(false);
		} else {
			assertFalse(true);
		}
	}
}
