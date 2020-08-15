package objectRepository;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.WebDriverFactory;

public class GetObj {
	
Properties prop;

    
    public WebDriver driver;
    WebDriverFactory webDriverFactory;
    
    @SuppressWarnings("static-access")
	
    	public GetObj (WebDriverFactory driverFactory ) throws Exception {
    	
        prop = new Properties();
        webDriverFactory = driverFactory;
        this.driver = webDriverFactory.getWebDriver();
        
         
        try {
        	File f = new File("src\\main\\java\\ObjectRepository");
        	
        	FileFilter f1 = new FileFilter() {   			
    			@Override
    			public boolean accept(File pathname) {
    				return pathname.getName().endsWith(".properties");
    			}
    		};
    		File[] flist = f.listFiles(f1);
    		    		
    		for (File temp:flist)
    		{
    			prop.load(new FileInputStream(temp));
    			
    		}
        	
        }catch (IOException e) {
            System.out.println(e.getMessage());
            
        }
        
        
    }
    
   
   
      public WebElement element(String strElement) throws Exception {
         
        // retrieve the specified object from the object list
        String locator = prop.getProperty(strElement);        
        // extract the locator type and value from the object
        String locatorType = locator.split(";")[0];
        String locatorValue = locator.split(";")[1];
     //   System.out.println(By.xpath("AppLogo"));
         
        // for testing and debugging purposes
        System.out.println("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the Object Repository");
     
   //     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='text3']")));
        try {


        	if(locatorType.equalsIgnoreCase("Id"))
        		return driver.findElement(By.id(locatorValue));           
        	else if(locatorType.equalsIgnoreCase("Xpath")) 
        			return driver.findElement(By.xpath(locatorValue)); 
//        		}catch(Exception e) {
//        			driver.navigate().refresh();
//
//        			@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
//        			Wait<WebDriver> wait = new FluentWait(driver)    
//        			.withTimeout(8, TimeUnit.SECONDS)    
//        			.pollingEvery(1, TimeUnit.SECONDS)   
//        			.ignoring(NoSuchElementException.class);
//        			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locatorValue))));
//        			return driver.findElement(By.xpath(locatorValue)); 
//        		}
        
        
        
        else if(locatorType.equalsIgnoreCase("Name"))
        	return driver.findElement(By.name(locatorValue));
        else if(locatorType.equalsIgnoreCase("Classname")) 
        	return driver.findElement(By.className(locatorValue));
        else if(locatorType.equalsIgnoreCase("Tagname"))
        	return driver.findElement(By.className(locatorValue));
        else if(locatorType.equalsIgnoreCase("Linktext"))
        	return driver.findElement(By.linkText(locatorValue));
        else if(locatorType.equalsIgnoreCase("Partiallinktext"))
        	return driver.findElement(By.partialLinkText(locatorValue));
        else if(locatorType.equalsIgnoreCase("Cssselector")) 
        	return driver.findElement(By.cssSelector(locatorValue));

       
       } catch (NoSuchElementException | StaleElementReferenceException e) {
    		
           if(locatorType.equalsIgnoreCase("Id"))
               return driver.findElement(By.id(locatorValue));        
           else if(locatorType.equalsIgnoreCase("Xpath")) 
             return driver.findElement(By.xpath(locatorValue)); 
           else if(locatorType.equalsIgnoreCase("Name"))
           	return driver.findElement(By.name(locatorValue));
           else if(locatorType.equalsIgnoreCase("Classname")) 
           	return driver.findElement(By.className(locatorValue));
           else if(locatorType.equalsIgnoreCase("Tagname"))
           	return driver.findElement(By.className(locatorValue));
           else if(locatorType.equalsIgnoreCase("Linktext"))
           	return driver.findElement(By.linkText(locatorValue));
           else if(locatorType.equalsIgnoreCase("Partiallinktext"))
           	return driver.findElement(By.partialLinkText(locatorValue));
           else if(locatorType.equalsIgnoreCase("Cssselector")) 
           	return driver.findElement(By.cssSelector(locatorValue));
       }
       throw new NoSuchElementException("Unknown locator type '" + locatorType + "'");   
   	}
	
    
      

      
      public List<WebElement> ListElemnet(String strElement) throws Exception {
    	      	  
          String locator = prop.getProperty(strElement);          
          // extract the locator type and value from the object
          String locatorType = locator.split(";")[0];
          String locatorValue = locator.split(";")[1];
       
           
          // for testing and debugging purposes
          System.out.println("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the Object Repository");
       
          
          if(locatorType.equalsIgnoreCase("Id"))        	    
              return  driver.findElements(By.id(locatorValue)); 
          else if(locatorType.equalsIgnoreCase("Xpath")) 
            return driver.findElements(By.xpath(locatorValue)); 
          else if(locatorType.equalsIgnoreCase("Name"))
          	return driver.findElements(By.name(locatorValue));
          else if(locatorType.equalsIgnoreCase("Classname")) 
          	return driver.findElements(By.className(locatorValue));
          else if(locatorType.equalsIgnoreCase("Tagname"))
          	return driver.findElements(By.className(locatorValue));
          else if(locatorType.equalsIgnoreCase("Linktext"))
          	return driver.findElements(By.linkText(locatorValue));
          else if(locatorType.equalsIgnoreCase("Partiallinktext"))
          	return driver.findElements(By.partialLinkText(locatorValue));
          else if(locatorType.equalsIgnoreCase("Cssselector")) 
          	return driver.findElements(By.cssSelector(locatorValue));
          else
              throw new Exception("Unknown locator type '" + locatorType + "'");
      }

}
