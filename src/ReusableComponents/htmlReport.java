package ReusableComponents;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Config.BaseConfig;

public class htmlReport extends BaseConfig
{
    //@SuppressWarnings("unused")
	@SuppressWarnings("unused")
	private static HSSFRow row;
	static int ExcelRows;
	static int Excelcols;    
	public static String localArray[][];
	public static String localArray1[][];
	public static String localArray2[][];	
	public static String ExpeActual[][];
	
	String osName = System.getProperty("os.name");
	String osArch = System.getProperty("os.arch");
	String osVers = System.getProperty("os.version");
	String javaVers = System.getProperty("java.version");
	
	
	static String strCurrentExecutionFolderPath;
	static String strModuleResultsFilePath;
	static String strResultsFolder; 
	static String strResultsFilePath;
	String strOLDModuleName;
	String strModuleStartDate;
	static String Screenshots;
	static String strStepResultsFileName;
	String strModulePageLoadingTimings;	
	Date dtTestSuiteStartTime;
	Date dtPrevStepExecTime;
	Date dtModuleStartDate;
	//static WebDriver driver=null;	
	int intModuleCount=0;	
	static Boolean blnModuleStatus;
	static String main_Location="C:\\Automation _Framework\\BMTNEW\\Test_Output\\";
	static String mdate = main_Location+"\\"+getdate()+"\\";
	static String mtimestamp=mdate+modifiedFile();
	//static String screenshot=mtimestamp+"\\"+"Screenshots"+"\\";
	static String screenshot=mtimestamp+"\\"+"Screenshots"+"\\";
	//static String screenshot=screens+"Screenshots";
	//static String mtimestamp1=mdate+"\\";
	static String htmlFile=mtimestamp+"\\"+"StepRunResult " + htmlFile() + ".html";	
	//static String strResultsFolderPath="C:\\Users\\t0043920\\Desktop\\";
	
	
	public boolean createResultFile(String strResultsFolderPath) throws Exception
	{
		//=======================CREATING A HTML REPORT FILE==================
		SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		Date objDate = new Date();
		Calendar objCal = Calendar.getInstance();
		objCal.setTime(objDate);
		String strAppendDateTime = objSimpleDtFormat.format(new Date());
		strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();
		String arrDateTime[] = strAppendDateTime.split(" ");
		
		//this.strResultsFolder = strResultsFolderPath + "\\" + arrDateTime[0];
		strResultsFolder = strResultsFolderPath + "\\" + strAppendDateTime.replace(" ", "_");
		File objFile = new File(strResultsFolderPath + "\\" + arrDateTime[0]);
		if (!objFile.exists()) 
		{
			if (objFile.mkdir()) 
			{
				System.out.println("Directory is created!");
			} else 
			{
				System.out.println("Failed to create directory!");
			}
		}
		
		strResultsFolderPath = strResultsFolderPath + "\\" + arrDateTime[0];
	    strCurrentExecutionFolderPath = strResultsFolderPath + "\\" + strAppendDateTime.replace(" ", "_");
		
		File objFile1 = new File(strResultsFolderPath + "\\" + strAppendDateTime.replace(" ", "_"));
		if (!objFile1.exists()) 
		{
			if (objFile1.mkdir()) 
			{
				System.out.println("Directory is created!");
			} else 
			{
				System.out.println("Failed to create directory!");
			}
		}
		
		//File objScreenshotFile = new File(strResultsFolderPath + "\\" + arrDateTime[0] + "\\Screenshots");
		File objScreenshotFile = new File(strResultsFolderPath + "\\" + strAppendDateTime.replace(" ", "_") + "\\Screenshots");
		if (!objScreenshotFile.exists()) 
		{
			if (objScreenshotFile.mkdir()) 
			{
				System.out.println("Screenshots directory is created!");
			} else 
			{
				System.out.println("Failed to create Screenshots directory!");
			}
		}			
		
			
		//String strResultsFilePath, strModuleResultsFilePath;
		strResultsFilePath = strResultsFolderPath + "\\" + strAppendDateTime.replace(" ", "_") + "\\StepRunResult " + strAppendDateTime + ".html";
		strStepResultsFileName = "StepRunResult " + strAppendDateTime + ".html";
		strModuleResultsFilePath = strResultsFolderPath + "\\" + strAppendDateTime.replace(" ", "_") + "\\ModuleRunResult " + strAppendDateTime + ".html";
		
		WebDriver driver = new FirefoxDriver();
	    Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
	    driver.quit();
	    String browserName = caps.getBrowserName();
        String browserVersion = caps.getVersion();
        System.out.println(browserName+" "+browserVersion);
		
		
		//PrintWriter objWriterModules = new PrintWriter(strModuleResultsFilePath, "UTF-8");
		PrintWriter objWriter = new PrintWriter(strResultsFilePath, "UTF-8");
		PrintWriter objWriterModules = new PrintWriter(strModuleResultsFilePath, "UTF-8");
		
		
		/*FileWriter fWriter = null;
        BufferedWriter writer = null;
        File file = new File(strResultsFolderPath);
        file.createNewFile();
        fWriter = new FileWriter(file);
        writer = new BufferedWriter(fWriter);*/
		objWriter.write("<html>");
		objWriter.write("<title>BMT AUTOMATION STEPWISE RESULT</title>");
		objWriter.write("<body bgcolor = \"WHITE\">");
        //writer.write("<h3 align = \"CENTER\" style = \"FONT-SIZE:20;COLOR:DARKBLUE\">BMT AUTOMATION SUITE EXECUTION</h3>");
		objWriter.write("<h3 align = \"CENTER\" style = \"FONT-SIZE:20;COLOR:DARKBLUE\">BMT AUTOMATION SUITE EXECUTION -");
		objWriter.write(""+getdate());
		objWriter.write("</h3>");
		
		/*objWriter.write("<br><table bordercolor=green align=center border=1 cellpadding=5 bgcolor=ORANGE></br>");
		objWriter.write("<br><table border = \"1\" width = \"100%\" cellspacing=\"0\" cellpadding=\"12\" STYLE = \"BORDER-COLOR:BLACK\"><br>");
		objWriter.write("<tr>");
		objWriter.write("<th align=center width=65><b>SI No</b></td>");
         //writer.write("<th align=center width=100><b>TC_Number</b></td>");
         //writer.write("<th align=center width=100><b>User_Story</b></td>");
		objWriter.write("<th align=center width=200><b>FORM TOOL QUESTION TYPES SCENARIOS</b></td>");
		objWriter.write("<th>OSNAME</th>");
		objWriter.write("<th>" +osName+ "</th>");
		objWriter.write("<th align=center width=100><b>Status</b></td>");
		objWriter.write("</tr>");*/
		objWriter.write("</h3>");		
		objWriter.write("<h3 align = \"CENTER\" style = \"FONT-SIZE:20;COLOR:DARKBLUE\">ENVIRONMENT EXECUTION DETAILS</h3>");
		objWriter.write("<table border = \"CENTER\" \"1\" width = \"20%\" cellspacing=\"0\" cellpadding=\"6\" align=center STYLE = \"BORDER-COLOR:BLACK\">");
		objWriter.write("<tr>");
		objWriter.write("<th>OSNAME</th>");
		objWriter.write("<th>" +osName+ "</th>");
		objWriter.write("</tr>");
		objWriter.write("<tr>");
		objWriter.write("<th>OS ARCHITECTURE</th>");
		objWriter.write("<th>" +osArch+ "</th>");
		objWriter.write("</tr>");
		objWriter.write("<tr>");
		objWriter.write("<th>OS VERSION</th>");
		objWriter.write("<th>" +osVers+ "</th>");
		objWriter.write("</tr>");
		objWriter.write("<tr>");
		objWriter.write("<th>JAVA VERSION</th>");
		objWriter.write("<th>"+javaVers+"</th>");
		objWriter.write("</tr>");	
		objWriter.write("<th>BROWSER VERSION</th>");
		objWriter.write("<th>"+browserName+" "+browserVersion+"</th>");
		objWriter.write("</tr>");
		objWriter.write("</table>");
		objWriter.write("<br>");
		
		objWriter.write("<table border = \"1\" width = \"100%\" cellspacing=\"0\" cellpadding=\"12\" STYLE = \"BORDER-COLOR:BLACK\">");
		objWriter.write("<tr bgcolor = \"ORANGE\">");
		objWriter.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"12%\">TEST CASE ID</th>");
		objWriter.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"15%\">MODULE NAME</th>");
		objWriter.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"8%\" >PRIORITY</th>");
		objWriter.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"27%\" >EXPECTED RESULT</th>");
		objWriter.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"27%\" >ACTUAL RESULT</th>");
		objWriter.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"10%\" >STATUS</th>");
		//objWriter.println("<th>SCREENSHOT</th>");
		objWriter.write("</tr>");
		objWriter.close();		
		
		
		objWriterModules.println("<html>");
		objWriterModules.println("<title>BMT AUTOMATION MODULEWISE RESULT " + strAppendDateTime + "</title>");
		objWriterModules.println("<head>");
		objWriterModules.println("<script>");
		objWriterModules.println("function displayHideElement(strButton,strID)");
		objWriterModules.println("{");
		objWriterModules.println("strDispText = (document.getElementById(strButton).innerText).trim();");
		objWriterModules.println("if(strDispText == \"+\")");
		objWriterModules.println("{");
		objWriterModules.println("document.getElementById(strID).style.display=\"block\";");
		objWriterModules.println("document.getElementById(strButton).innerText=\" - \";");
		objWriterModules.println("}");
		objWriterModules.println("else");
		objWriterModules.println("{");
		objWriterModules.println("document.getElementById(strID).style.display=\"none\";");
		objWriterModules.println("document.getElementById(strButton).innerText=\" + \";");
		objWriterModules.println("}");
		objWriterModules.println("}");
		objWriterModules.println("</script>");
		objWriterModules.println("</head>");
		objWriterModules.println("<body bgcolor = \"WHITE\">");
		objWriterModules.println("<h3 align = \"CENTER\" style = \"FONT-SIZE:20;COLOR:DARKBLUE\">BMT AUTOMATION MODULEWISE RESULT</h3>");
		objWriterModules.println("<center><table border = \"1\" width = \"75%\" cellspacing=\"0\" cellpadding=\"12\" STYLE = \"BORDER-COLOR:BLACK\">");
		objWriterModules.println("<tr bgcolor = \"#787878\">");
		objWriterModules.println("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"22%\" >TEST CASE ID</th>");
		objWriterModules.println("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"30%\" >MODULE NAME</th>");
		objWriterModules.println("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"35%\" >PRIORITY</th>");
		objWriterModules.println("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"12%\" >STATUS</th>");
		//objWriterModules.println("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"18%\" >TIME TAKEN</th>");
		objWriterModules.println("</tr>");	
		objWriterModules.close();
		return true;		
	}
	
		
	public boolean addResultToHTMLFile(String TestCaseID ,String ModuleName,String priority, String ExpeResu, String ActuResu,String Status) throws Exception
    {
		SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		Date objDate = new Date();
		Calendar objCal = Calendar.getInstance();
		objCal.setTime(objDate);
		String strAppendDateTime = objSimpleDtFormat.format(new Date());
		strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();
	 
		
		   FileWriter fWriter = null;
           BufferedWriter writer = null;
           File file1 = new File(htmlFile);
           fWriter = new FileWriter(file1,true);
           writer = new BufferedWriter(fWriter);
           writer.write("<table border=1 cellpadding=5>");
           writer.write("<tr>");
          // <th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"11%\"
          // writer.write("<td width = \"13%\">"+scenario+"</td>");
           //writer.write("<td width = \"21%\">"+TestCond+"</td>");
          
           writer.write("<td  width=150>"+TestCaseID+"</td>");
           writer.write("<td  width=190>"+ModuleName+"</td>");
           writer.write("<td  width=100>"+priority+"</td>");
           writer.write("<td  width=359>"+ExpeResu+"</td>");
           writer.write("<td  width=356>"+ActuResu+"</td>");
           
        //writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:BLACK;WORD-BREAK:BREAK-ALL\" width = \"20%\">"+TestCaseID+"</th>");
        //writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:BLACK;WORD-BREAK:BREAK-ALL\" width = \"20%\">"+ModuleName+"</th>");
        //writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:BLACK;WORD-BREAK:BREAK-ALL\" width = \"8%\" >"+priority+"</th>");
        //writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:BLACK;WORD-BREAK:BREAK-ALL\" width = \"35%\" >"+ExpeResu+"</th>");
        //writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:BLACK;WORD-BREAK:BREAK-ALL\" width = \"35%\" >"+ActuResu+"</th>");
        //writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:BLACK;WORD-BREAK:BREAK-ALL\" width = \"10%\" >"+Status+"</th>");
        writer.write("<td bgcolor = \"GREEN\" style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:12;ALIGN:CENTER;width:120;WORD-BREAK:BREAK-ALL\"><b>"+Status+"</b></td>");
        writer.write("</tr>");
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</head>");
           writer.write("</html>");
           writer.close();
           return true;
    }
	public static void Screenshot(String scenario) throws Exception,NullPointerException
   	{
   		try {
   		System.out.println("Entered Screenshot method");
   		File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		File targetFile = new File(screenshot+scenario+".png");
   		System.out.println("the path is:"+targetFile);
   		FileUtils.copyFile(scrnsht,targetFile); 
   		System.out.println("completed Screenshot method");
   		}
   		catch(Exception e)
   		{
   			e.printStackTrace();
   		}
   		//return screenshot+scenario+".png";
   	}
	
	
	
	//@SuppressWarnings("unused")
	public boolean htmlReportFail(String TestCaseID ,String ModuleName,String priority, String ExpeResu, String ActuResu,String Status) throws Exception
	{	
		SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		Date objDate = new Date();
		Calendar objCal = Calendar.getInstance();
		objCal.setTime(objDate);
		String strAppendDateTime = objSimpleDtFormat.format(new Date());
		strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();	 
		
		FileWriter fWriter = null;
        BufferedWriter writer = null;
        File file1 = new File(htmlFile);
        fWriter = new FileWriter(file1,true);
        writer = new BufferedWriter(fWriter);
        writer.write("<table border=1 cellpadding=5>");
        writer.write("<tr>");
        writer.write("<td  width=150>"+TestCaseID+"</td>");
        writer.write("<td  width=190>"+ModuleName+"</td>");
        writer.write("<td  width=100>"+priority+"</td>");
        writer.write("<td  width=359>"+ExpeResu+"</td>");
        writer.write("<td  width=356>"+ActuResu+"</td>");
        //writer.write("<td  width=320>"+Status+"</td>");
        //String strScreenshot = htmlTakeScreenshot(scenario);
        Screenshot(strAppendDateTime);        
        System.out.println("Entered Screenshot method");
        Thread.sleep(5000);
        
       /* File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		File targetFile = new File(screenshot+strAppendDateTime+".png");
   		System.out.println("the path is:"+targetFile);
   		FileUtils.copyFile(scrnsht,targetFile); 
   		System.out.println("completed Screenshot method");   		
        System.out.println("Navigated to screenshot method");*/
        
        String strScreenshot="file:///"+screenshot+strAppendDateTime+".png";
       
        writer.write("<td bgcolor = \"RED\" style = \"width:120;align:center;\" >" + "<a href=\"" + strScreenshot + "\" target=\"_blank\">"+Status+"</a></b></td>");
       	writer.write("</tr>");
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</head>");
        writer.write("</html>");
        writer.close();
        return true;
		
	}
	

	
	public static String getdate()
   	{
   		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
   		Date date = new Date();   		
   		Calendar objCal = Calendar.getInstance();
		objCal.setTime(date);
		String strAppendDateTime = dateFormat.format(new Date());
		strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();	
		return strAppendDateTime;
   		//return dateFormat.format(date);
   	}
	
	 public static String modifiedFile()
	    {	
		File file = new File(mdate);
	 
		System.out.println("Before Format : " + file.lastModified());
	 
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy_hh-mm_a");
		
		String modfile=sdf.format(file.lastModified());
	 
		//System.out.println("After Format : " + sdf.format(file.lastModified()));
		
		return modfile;
	    }
	 
	 public static String htmlFile()
	    {	
		File file = new File(mtimestamp);
	 
		System.out.println("Before Format : " + file.lastModified());
	 
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh-mm a");
		
		String modfile=sdf.format(file.lastModified());
	 
		System.out.println("After Format : " + sdf.format(file.lastModified()));
		
		return modfile;
	    }
	 
	 public static String getDateTimeStringWithSeconds()
		{
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date());
			strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();	
			return strAppendDateTime;
		}
	
	public static String html_TakeScreenshot() throws Exception
	{
		//@SuppressWarnings({ "unused"})
		System.out.println("Entered htmltakescreenshot");
		String  strAppendDateTimeUpdate;
		
		strAppendDateTimeUpdate =getDateTimeStringWithSeconds();
				
//		String strResultsFolder = this.strResultsFolder;
		
		//String strResultsFolder = strCurrentExecutionFolderPath;
		
       // try
        //{
            //WebDriver augmentedDriver = new Augmenter().augment(objWebDriver);

            File objScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);        	
        	FileUtils.copyFile(objScreenshot, new File(mtimestamp + "\\Screenshots\\" + strAppendDateTimeUpdate + ".png"));
        	//augmentedDriver.close();
        //}
        /*catch(Exception e)
        {
        	System.out.println("Exception occured while taking screenshot: " + e);
        }*/
        		
		return "Screenshots\\" + strAppendDateTimeUpdate + ".png";
	}
	
	public static void main(String args[]) throws Exception
	{
		
		System.out.println("the value of "+screenshot);
		//System.out.println("the value of "+strResultsFolder);
	}
}

