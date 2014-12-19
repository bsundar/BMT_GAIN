package UIWrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import static Config.BaseConfig.TIME_LIMIT;
import static Config.BaseConfig.driver;
//import static UIWrappers.UIobjects.clickOn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;




import org.testng.Reporter;



public class UIobjects
{
	static WebDriverWait wait;
	
	
	public static void radio(By locator, String waitForElementPresent) throws Exception
	{
	List<WebElement> select = driver.findElements(locator);

	for (WebElement getUIObject : select){
	if (getUIObject.getAttribute("waitForElementPresent") != null)
	//radio.clickOn();
	getUIObject(locator).click();
	}}
	
	
	public void UIObject()
	{
		wait = new WebDriverWait(driver, 10);
	}
	
	
	 //////////////////////////  Find UI Objects List  ////////////////////////
	
	public static List<WebElement> getUIObjects(By locator) throws Exception
	{
		return driver.findElements(locator);
   		
	}
	 //////////////////////////  Find UI Object with By locator ////////////////////////
	public static WebElement getUIObject(By locator) throws Exception
	{
		return waitForElementPresent(locator);
   		
	}
	
	  //////////////////////////  Read text from UI Object  ////////////////////////
	
    public static String getValue(By locator) throws Exception
	{

		return getUIObject(locator).getAttribute("value");
	}
	 //////////////////////////  Read text from UI Object  ////////////////////////
	


    public static String getText(By locator) throws Exception
	{

		return getUIObject(locator).getText();
	}




	//////////////////////////verify Equals  ////////////////////////
	public static void verifyEquals(String expected,String actual) throws Exception
	{
		try
		{
			assertEquals(expected,actual);



		}catch(Error err)
		{
			throw new Error("Verification Error: expected:<"+expected+"> but was:<"+actual+">");
		}

	}
	 //////////////////////////verify Equals  ////////////////////////
	public static void verifyNotEquals(String expected,String actual) throws Exception
	{
		if(expected.equals(actual))
        {
            throw new Exception("Verification Error:<"+expected+"> <"+actual+">");
        }


	}
	
	  //////////////////////////  Write Data to UI Object  ////////////////////////
	

	public static void enterData(By locator,String waitForElementPresent) throws Exception
	{
		
		getUIObject(locator).sendKeys(waitForElementPresent);
		
	}

	  //////////////////////////  Write Data to UI Object  ////////////////////////

	public static void pressKey(By locator,Keys key) throws Exception
	{
		
		getUIObject(locator).sendKeys(key);
		
	}



    public static void clear(By locator) throws Exception
	{

		getUIObject(locator).clear();

	}
   

	public static void clickOn(By locator) throws Exception
	{
		
		getUIObject(locator).click();
		
	}
	


    public static void click_Run_All(String table) throws Exception {
        driver.findElement(By.xpath("//table[2]/tbody/tr["+table+"]/td[2]/div/table/tbody/tr/td[2]/input")).click();
    
    }
    
    public static String titleVerification() throws Exception {
    	String text = driver.getTitle();
    	return text;
    }
	
	 //////////////////////////  Write Data to UI Object  ////////////////////////
	
	 //////////////////////////  Select Text from Combobox List  ////////////////////////
	
	 //////////////////////////  Select Text from Combobox List  ////////////////////////
	/*public static void select(WebElement element,String option) throws Exception 
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
		
	}*/
	public static void select(By locator,String option) throws Exception 
	{
		Select select=new Select(driver.findElement(locator));
		select.selectByVisibleText(option);
		
	}
	 //////////////////////////  Get Selected value from Combobox list  ////////////////////////
	
	
	public static String getSelectedValue(By locator) throws Exception 
	{
		return new Select(getUIObject(locator)).getFirstSelectedOption().getText();		
	}
	  
	
	
	//////////////////////////  Wait for Element Present with By locator////////////////////////
	public static WebElement waitForElementPresent(By locator) throws Exception
	{

		WebElement element=null;
		long end = System.currentTimeMillis() + TIME_LIMIT;
        while (true)
        { 
        	try
        	{
        		
        		element= driver.findElement(locator);
        		if (element.isDisplayed())break;
        	}catch(Exception e)
        	{
        		if(System.currentTimeMillis() >= end)
        		{
        			System.out.println("\n***"+locator+" Not Found..***"); throw e;
        		}
        	}
        	
        	
           
            
        }
        return element;
	}
	 //////////////////////////  Wait for Elements  Present ////////////////////////
	public  static List<WebElement>  waitForElementsIn(WebElement element) throws Exception
	{

		List<WebElement> elements=null;
		long end = System.currentTimeMillis() + TIME_LIMIT;
        while (elements.isEmpty())
        {
        	try
        	{
        		elements=element.findElements((By.tagName("option")));
        		if (elements.isEmpty())break;
        	}catch(Exception e)
        	{
        		if(System.currentTimeMillis() >= end) throw e;
        	}
        	
           
           
        }
        return elements;
        
        
	}
	
	public  static List<WebElement>  waitForElementsIn(WebElement element,By by) throws Exception
	{

		List<WebElement> elements=null;
		long end = System.currentTimeMillis() + TIME_LIMIT;
        while (elements.isEmpty())
        {
        	try
        	{
        		elements=element.findElements(by);
        		if (elements.isEmpty())break;
        	}catch(Exception e)
        	{
        		if(System.currentTimeMillis() >= end) throw e;
        	}
        	
           

        }
        return elements;
         
	}
	public static void pause(final int iTimeInMillis)
	{
	    try
	    {
	      Thread.sleep(iTimeInMillis);
	    }
	    catch(InterruptedException ex)
	    {
	      System.out.println(ex.getMessage());
	    }
	}
	
	public static boolean isElementPresent(By locator)
	{
	    try
	    {
	      getUIObject(locator);
	      
	    }
	    catch(Exception ex)
	    {
	      //System.out.println(locator+" Not Found");
	      return false;
	    }
	    return true;
	}
	//////////////////////////verify Equals  ////////////////////////
	public static void verifyTrue(boolean actual) throws Exception
	{
		   try{
			assertTrue(actual);
			}catch(Error err)
			{
				throw new Error("Verification Error: expected:<true> but was:<false>");
			}
		
		
	}
	//////////////////////////verify Equals  ////////////////////////
	public static void verifyFalse(boolean actual) throws Exception
	{
			try{
			assertTrue(!actual);
			}catch(Error err)
			{
				throw new Error("Verification Error: expected:<false> but was:<true>");
			}
	}
	
	public static void acceptAlert() throws Exception
	{
		try{
		driver.switchTo().alert().accept();
		}catch(Exception e)
		{
			throw new Exception("No Alert Present");
		}
	}

    public static boolean acceptAlertknown(String text) throws Exception {

        try{
          if(text == driver.switchTo().alert().getText()){
            driver.switchTo().alert().accept();
          }

		}catch(Exception e)
		{
			throw new Exception("No Alert Present");
		}
       return false;
    }
	public static void cancelAlert() throws Exception
	{
		
		try{
			
		driver.switchTo().alert().dismiss();
		}catch(Exception e)
		{
		throw new Exception("No Alert Present");
		}
	}
	public static String getAlertText() throws Exception
	{
		String text;
		try{
			
		text=driver.switchTo().alert().getText();
		}catch(Exception e)
		{
		throw new Exception("No Alert Present");
		}
		return text;
	}

   


     public static boolean testEqual(ArrayList<Object> array1)
	 {
		 for(Object a:array1)
	 	{
		 if(!array1.get(0).equals(a.toString()))
		 	 return false;
	 	}
	 return true;
	 }
	 public static boolean testEqual(ArrayList<Object> array1,String aa)
	 {
		 for(Object a:array1)
	 	{
		 if(!aa.equals(a))
		 	 return false;
	 	}
	 return true;
	 }

    public static String getdate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

    public static String getdate_YYYYMMDD()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
//////////////////////////verify Element Present  ////////////////////////
	
	//////////////////////////verify Element Not Present  ////////////////////////
	
	//////////////////////////verify Element Present  ////////////////////////
	public static void verifyElementPresent(By locator) throws Exception
	{
			try{
				getUIObject(locator);
			
			}catch(Exception ex)
			{
				throw new Error("Verification Error: <expected>Element should Present <actual> Element<"+locator+"> Not Found");
			}
	}
	//////////////////////////verify Element Not Present  ////////////////////////
	public static void verifyElementNotPresent(By locator) throws Exception
	{
			try{
				getUIObject(locator);
				throw new Error("Verification Error: <expected>Element should not be Found <actual> Element<"+locator+"> Found");
					
			}catch(Exception ex)
			{
				
			}
	}

	public static boolean isAlertPresent()
	{
		try{
		driver.switchTo().alert().getText();
		}catch(Exception e)
		{
			return false;
		}
		return true;
	}
	

		//////////////////////////verify Contant Equals in List ////////////////////////
		public static void verifyContentEquals(List<Object> expected,List<Object> actual) throws Exception
		{
				for(Object obj:expected)
				{
					if(!actual.contains(obj))
					throw new Error("Verification Error: <expected>"+expected+" <actual> <"+actual+"> Found");
						
				}
		
		}
			//////////////////////////verify Contant Equals in List ////////////////////////
		public static void verifyEquals(List<Object> expected,List<Object> actual) throws Exception
		{
					if(!expected.equals(actual))
					throw new Error("Verification Error: <expected>"+expected+" <actual> <"+actual+"> Found");
			
		}
		
		
		//////////////////To refresh the page/////////////////////////////////////////////
		
		 public static void refresh()
		 {
			   driver.navigate().refresh();
			   
		 }
		 
		 ////////////////////To Navigate to another page////////////////////////////////////////
		 
		 public static void navpath(String text)
		 {
			 driver.navigate().to(text);
			   
		 }
		 /*public static void verifyTextPresent(String text)
		 {
			 if(!driver.getPageSource().contains(text))
					throw new Error("Verification Error: <Text>"+text+" Not Found");
				
		 }*/
		 public static void verifyTextPresent(String text)
		 {
			 try
			 {
				 getUIObject(By.xpath("//*[contains(.,'"+text+"')]"));
			 }catch (Exception e) 
			 {
				 throw new Error("Verification Error:"+text+" Not Found");
			}
		 }
		 public static void quitBrowser() throws Exception
		 {
			 driver.quit();
		 }
		 
						 
		public static void compareArray(ArrayList<Object> array1,ArrayList<Object> array2)
		{
			 for (int i=0;i<array1.size();i++) 
			 {
		            for (int j=0;j<array2.size(); j++)
		            {
		                if(array2.get(i).equals(array1.get(j)))
		                	System.out.println("equal"+array2.get(j));
		            }
			 }
}
		
		///////////////////////////////logging the logs in console////////////////////////
		
		public static void log(String text)
		{
			Reporter.log(text);
			System.out.println(text);
		}
		
		///////////////////////////////////////open the url//////////////////////////////
				
		public static void open(String url) throws Exception
		{
			driver.get(url);
		}
        ///////////////////////////////drop down select/////////////////////////////////
		
		public static void selectSearchDropdown(WebDriver driver, By locator, String value)
		{
			driver.findElement(locator).click();
			driver.findElement(locator).sendKeys(value);
			driver.findElement(locator).sendKeys(Keys.TAB);
			}			
	
////////////////////////////////Radio button//////////////////////////
		

public static void selectRadioButton(By locator, String value)
{
	List<WebElement> select = driver.findElements(locator);

for (WebElement element : select)
{
if (element.getAttribute("value").equalsIgnoreCase(value))
{
element.click();
 }
}
}

public static boolean isEnable(By locator)
{
try{
        if(((WebElement) locator).isEnabled())
        {
            System.out.println("is enabled");
            return true;
        }
    }
 
catch(NoSuchElementException nsee){
            System.out.println(nsee.toString());
          
 }
return false;
}
}



