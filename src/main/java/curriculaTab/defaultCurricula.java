package curriculaTab;

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

public class defaultCurricula {
	WebDriver dr;
	@Given("^navigate to curricula tab$")
	public void navigate_to_curriculate_tab() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		File chrome = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get(prop.getProperty("url"));    
	    dr.findElement(By.xpath(prop.getProperty("loginUser"))).sendKeys(prop.getProperty("trainerUser"));
	    dr.findElement(By.xpath(prop.getProperty("loginPass"))).sendKeys(prop.getProperty("trainerPass"));
	    dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();
	}

	@When("^curricula tab is clicked$")
	public void curricula_tab_is_clicked() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		try {
			TimeUnit.SECONDS.sleep(7);
			dr.findElement(By.xpath(prop.getProperty("curriculaTab"))).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^curricula default$")
	public void curricula_default() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
	       String realtimeCore = dr.findElement(By.xpath(prop.getProperty("curriculaExpand"))).getText();
	       String realtimeFocus = dr.findElement(By.xpath(prop.getProperty("focusExpand"))).getText();
	       if (realtimeCore.contains(prop.getProperty("wantedExpand")) & realtimeFocus.contains(prop.getProperty("wantedExpand"))) {
	    	  assertFalse(false);
	    	  dr.close();
	       } else {
	    	  assertFalse(true);
	    	  dr.close();
	       }
		}
	}
