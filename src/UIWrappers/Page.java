package UIWrappers;

import static UIWrappers.UIobjects.*;
import Config.*;
//import ReusableComponents.htmlReport;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static Config.XlsReader.*;

public class Page extends BaseConfig 
{	
	//static htmlReport htr=new htmlReport(); 	
	public static void testLogout() throws Exception
{
driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
}
//@SuppressWarnings("static-access")
public static void startTest() throws Exception
{ 
new BrowserSetup();
String url=configDetails(0,1,1);
open(url);
pause(10000);
driver.manage().window().maximize(); 
}
public static void stopTest() throws Exception
{
quitBrowser();
  
}
   
@BeforeMethod(alwaysRun=true)
public void beforeClass()
{
try {
startTest();
} 

catch (Exception e) { 
log(e.getMessage());
}
} 
 
@AfterMethod(alwaysRun=true)
public void afterClass() throws Exception
{
stopTest();
}
  
}