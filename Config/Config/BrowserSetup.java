package Config;
//import static Config.XlsReader.configDetails;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import ReusableComponents.htmlReport;
import static Config.XlsReader.*;

public class BrowserSetup extends BaseConfig
{
	//String yuseractions= xmlStatus(0,1,1);
	//System.out.println("The Value of a :="+yuseractions);
	//static htmlReport htr=new htmlReport();
	//@SuppressWarnings("static-access")
	
	public  BrowserSetup() throws Exception
	{
	
		//String BROWSER=configDetails(0,2,1);
		String BROWSER=configDetails(0,2,1);
	try{
		if (BROWSER.equals("FF"))
		{

			driver = new FirefoxDriver();			
			
		}
		else if (BROWSER.equals("IE"))
		{
			
			@SuppressWarnings("unused")
			File IEDriver = new File("C:\\Automation _Framework\\IEDriverServer.exe");   
			System.setProperty("webdriver.ie.driver", "C:\\Automation _Framework\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver = new InternetExplorerDriver();
			
		} 
		
		else if (BROWSER.equals("CH"))
		{

			System.setProperty("webdriver.chrome.driver", "C:\\Automation _Framework\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Browser Selection","Error", JOptionPane.ERROR_MESSAGE);
		}
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		((JavascriptExecutor)driver).executeScript("window.moveTo(0, 0);window.resizeTo(window.screen.availWidth,window.screen.availHeight);");
		((JavascriptExecutor)driver).executeScript("window.resizeTo(1024, 768);");
		}
	catch(Exception ee)
		{
			JOptionPane.showMessageDialog(null, BROWSER+" Driver Not Available","Driver Initialization Eception", JOptionPane.WARNING_MESSAGE);
		
		}
      }
	
}