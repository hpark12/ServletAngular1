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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class defaultTrainer {
	WebDriver dr;
	@Given("^navigate to trainer tab$")
	public void navigate_to_trainer_tab() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get(prop.getProperty("https://dev.assignforce.revaturelabs.com"));    
	    dr.findElement(By.xpath(prop.getProperty("loginUser"))).sendKeys(prop.getProperty("trainerUser"));
	    dr.findElement(By.xpath(prop.getProperty("loginPass"))).sendKeys(prop.getProperty("trainerPass"));
	    dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();
	}

	@When("^trainer tab is clicked$")
	public void trainer_tab_is_clicked() throws InterruptedException, IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		TimeUnit.SECONDS.sleep(7);
		dr.findElement(By.xpath(prop.getProperty("trainerTab"))).click();
		
	}

	@Then("^trainer tables should show$")
	public void trainer_tables_should_show() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		String realTable1 = dr.findElement(By.xpath(prop.getProperty("actualTable1"))).getText();
		String realTable2 = dr.findElement(By.xpath(prop.getProperty("actualTable2"))).getText();
		if (realTable1.contains(prop.getProperty("wantTable1")) & realTable2.contains(prop.getProperty("wantTable2")))
		{
			assertFalse(false);
			dr.close();
		}
		else {
			assertFalse(true);
			dr.close();
		}
		
	}
}
