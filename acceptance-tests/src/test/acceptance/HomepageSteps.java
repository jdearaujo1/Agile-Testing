package test.acceptance;

import java.util.concurrent.TimeUnit;

import java.lang.*;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class HomepageSteps {

	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^je suis sur la homepage$")
	public void je_suis_sur_la_homepage() throws Throwable {
		driver.get("https://www.meetup.com/fr-FR/");
	}

	@Then("^le titre doit être \"([^\"]*)\"$")
	public void le_titre_doit_être(String arg1) throws Throwable {
	    assertEquals(driver.getTitle(), arg1);
	}

	@Then("^la description contient \"([^\"]*)\"$")
	public void la_description_doit_être(String arg1) throws Throwable {
		// By CSS Selector
		assertTrue(driver.findElement(By.cssSelector("meta[name='description']")).getAttribute("content").contains(arg1));
		// By XPATH, si vous préférez...
	    // assertEquals(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"), arg1);
	}


	@Given("^le bloc des meetups près de chez soi est présent$")
	public void le_bloc_des_meetups_près_de_chez_soi_est_présent() throws Throwable {
		assertTrue(driver.findElement(By.cssSelector("h2[class='text--sectionTitle']")).getText().contains("Événements à proximité"));
		//throw new PendingException();
	}

    @Then("^le h doit être \"([^\"]*)\"$")
    public void le_h_doit_être(String arg1) throws Throwable {
        assertThat(driver.findElement(By.cssSelector("h1")).getText(), is ("Le monde vous tend les bras"));
        //throw new PendingException();
    }
	@After
	public void afterScenario() {
		driver.quit();
	}

}
