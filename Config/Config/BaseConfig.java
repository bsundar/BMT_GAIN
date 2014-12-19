package Config;

//import static Config.XlsReader.*;
import org.openqa.selenium.WebDriver;

 public class BaseConfig
{	
	//String sample=fetchCell(0,1,0);
	 
	//protected static String url="fetchCell(0,1,0)";//FF:Firefox,IE:Internet Explorer,CH:Chorme Driver 
	//public static String url="https://s3-us-west-1.amazonaws.com/okstudent.ctb.com.s3/launch.html";
	public static WebDriver driver=null;	
	public static XlsReader excel;
	
	public static long TIME_LIMIT=15000;
	//public static String BROWSER="FF";//FF:Firefox,IE:Internet Explorer,CH:Chorme Driver
	
	public static String ExcelPath="C:\\Automation _Framework\\BMTNEW\\Test_Data\\TestData.xls";
	public static String TestCases="C:\\Automation _Framework\\BMTNEW\\TestConditions\\Test_Cases.xls";
	public static String ScreenshotsPath="C:\\Automation _Framework\\BMTNEW\\Error_Log_Screenshots\\";
	public static String testOutputPath="C:\\Automation _Framework\\BMTNEW\\Test-Output";
	public static String testReportPath="C:\\Automation _Framework\\BMTNEW\\Test_Reports\\";
	public static String strResultsFolderPath="C:\\Automation _Framework\\BMTNEW\\";
	public static String htmlreport="C:\\Automation _Framework\\BMTNEW\\StepWiseResult11262014.html";
	public static String strResultsFolder="C:\\Automation _Framework\\BMTNEW\\Screenshots\\";
	public static String testSuiteName="Acuity_TestSuite";
	
	//Test cases Fetching data
	public static String Path_TestData = "C:\\Automation _Framework\\BMTNEW\\TestConditions\\";
	public static String File_TestData = "Test_Cases.xls";
 
	public static String TestNGPath = "C:\\Automation _Framework\\BMTNEW\\Test_Data\\TestControl.xls"; 
	public static String TestNgXml="C:\\Automation _Framework\\BMTNEW\\TestNG.xml";
    
    
}
 
