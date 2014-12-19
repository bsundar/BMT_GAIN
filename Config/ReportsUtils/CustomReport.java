package ReportsUtils;


import static Config.BaseConfig.driver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class CustomReport extends TestListenerAdapter
{
	static String newScreenShotPath=null;
	static String screenShotFile=null;
	@Override
	public void onTestFailure(ITestResult arg0)
	{
		
		try {
			 File location=new File(".");
			
			 newScreenShotPath=location.getCanonicalPath()+"\\Test_Output\\ScreenShots\\"+arg0.getName()+getdate()+"";
			 screenShotFile=newScreenShotPath+"_Report"+".png";
			captureScreenShot(screenShotFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Reporter.log("<a href=" + screenShotFile + " target='_blank' >" + arg0.getName()+"_ErrorLogScreenShot</a>");
	}

	/*@Override
	public void onTestSkipped(ITestResult arg0)
	{
		
	}*/
	public static void captureScreenShot(String name) throws Exception 
	{
		 File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(screenshot,new File(name) );
		 Thread.sleep(2000);
	}
	public static String getdate()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	
}