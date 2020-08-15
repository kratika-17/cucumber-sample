package stepDefinitions;

import static Libraries.CommonLibrary.dataObj;
import static Libraries.CommonLibrary.getEachExcelRowDataIntoHashMapObj;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import Libraries.ExcelSheet;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.GetObj;
import utility.WebDriverFactory;



public class Testcase1 extends GetObj {
	
	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	
	@SuppressWarnings("static-access")
	public Testcase1(WebDriverFactory DriverFactory) throws Exception
	{
		super(DriverFactory);
		webDriverFactory = DriverFactory;
		this.driver = webDriverFactory.getWebDriver();	
	}
	
	@Before()
	public void beforeScenario(Scenario scenario) throws InterruptedException {
		try {
		ExcelSheet exl = new ExcelSheet();
        int noOfRows = exl.totalrows("NDTV", "TestCase_Configuration");
        int RowNumber = exl.getRowNumber("NDTV", "TestCase_Configuration", scenario.getName());
        dataObj = getEachExcelRowDataIntoHashMapObj(exl, "TestCase_Configuration", RowNumber, "NDTV");
        
		}
		
		catch (Exception e) {
            
        }
		
		
	}
	
	
	@Given("^Open Browser and enter url \"([^\"]*)\"$")
	
			public void Open_Browser_and_enter_url(String url) throws Throwable {
		    	
		          driver.get(url);
		    }
	@Then("^Click on horizontal ellpsis menu$")
	public void click_on_horizontal_ellpsis_menu() throws Throwable {
    	
          element("EllpsisMenu").click();
          
    }
	
	@And("^Click on Weather option from menu$")
	public void click_on_weather_option_from_menu() throws Throwable {
    	
          element("WeatherOption").click();
          Thread.sleep(1000);
          
    }

	@When("^Enter the name of the city$")
	public void Enter_the_name_of_the_city() throws Throwable {
          element("PinYourCitySelectBox").sendKeys(dataObj.get("City Name"));
          Thread.sleep(1000);
          
    }
	

}
