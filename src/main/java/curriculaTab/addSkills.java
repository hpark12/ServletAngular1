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

public class addSkills {
	WebDriver dr;
	@Given("^navigate to curricula as vp$")
	public void navigate_to_curricula_as_vp() throws InterruptedException, IOException {
		File chrome = new File("src/main/resources/chromedriver.exe");
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
	    dr=new ChromeDriver();
	    dr.get(prop.getProperty("url"));    
	    dr.findElement(By.xpath(prop.getProperty("loginUser"))).sendKeys(prop.getProperty("vpUser"));
	    dr.findElement(By.xpath(prop.getProperty("loginPass"))).sendKeys(prop.getProperty("vpPass"));
	    dr.findElement(By.xpath(prop.getProperty("loginButton"))).click();
		TimeUnit.SECONDS.sleep(7);
		dr.findElement(By.xpath(prop.getProperty("curriculaTab"))).click();
		TimeUnit.SECONDS.sleep(2);
	}

	@When("^new skill filled out$")
	public void new_skill_filled_out() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		dr.findElement(By.xpath(prop.getProperty("skillForm"))).sendKeys(prop.getProperty("newSkill"));
		dr.findElement(By.xpath(prop.getProperty("skillButton"))).click();
	}

	@Then("^add new skills$")
	public void add_new_skills() throws IOException {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("src/test/resources/cuong.properties");
		prop.load(input);
		if (dr.getPageSource().contains(prop.getProperty("newSkill")))
		{
			assertFalse(false);
		}
		else assertFalse(true);
		dr.close();
	}
}
