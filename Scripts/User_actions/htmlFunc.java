package User_actions;
//import static Config.BaseConfig.driver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import Config.BaseConfig;

public class htmlFunc extends BaseConfig
{
	//htmlFunc HF = new htmlFunc();
	static String strCurrentExecutionFolderPath;
	//public static String htmlreport="C:\\Users\\T0043920\\Desktop\\one.html";
       public boolean createNewHTMLFile(String htmlreport) throws Exception
       {
              //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
             // DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
             // Date date = new Date();
             // System.out.println(dateFormat.format(date));
              FileWriter fWriter = null;
              BufferedWriter writer = null;
              File file = new File(htmlreport);
              file.createNewFile();
              fWriter = new FileWriter(file);
              writer = new BufferedWriter(fWriter);
              writer.write("<html>");
              writer.write("<title>BMT AUTOMATION STEPWISE RESULT</title>");
              writer.write("<body bgcolor = \"WHITE\">");
              //writer.write("<h3 align = \"CENTER\" style = \"FONT-SIZE:20;COLOR:DARKBLUE\">BMT AUTOMATION SUITE EXECUTION</h3>");
              writer.write("<h3 align = \"CENTER\" style = \"FONT-SIZE:20;COLOR:DARKBLUE\">BMT AUTOMATION SUITE EXECUTION");
              
              writer.write("</h3>");
              writer.write("<h3 align = \"LEFT\" style = \"FONT-SIZE:20;COLOR:DARKBLUE\">DATE & TIME LAST EXECUTED: "+getdate());
              writer.write("<table border = \"1\" width = \"100%\" cellspacing=\"0\" cellpadding=\"12\" STYLE = \"BORDER-COLOR:BLACK\">");
              writer.write("<tr bgcolor = \"ORANGE\">");
              
              writer.write("</h3>");              
              writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"10%\" >MODULE</th>");
              writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"20%\" >TEST CONDITION</th>");
              //writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"10%\"  >PRIORITY</th>");
              writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"25%\" >EXPECTED RESULT</th>");
              writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"25%\" >ACTUAL RESULT</th>");
              writer.write("<th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"9%\" >STATUS</th>");
      		//objWriter.println("<th>SCREENSHOT</th>");
              writer.write("</tr>");
      		  writer.close();
      		return true;
       }
      
       public boolean addResultToHTMLFile(String scenario ,String TestCond, String ExpeResu, String ActuResu,String Status) throws Exception
       {
              FileWriter fWriter = null;
              BufferedWriter writer = null;
              File file1 = new File(htmlreport);
              fWriter = new FileWriter(file1,true);
              writer = new BufferedWriter(fWriter);
              writer.write("<table border=1 cellpadding=5>");
              writer.write("<tr>");
             // <th style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:14;COLOR:WHITE;WORD-BREAK:BREAK-ALL\" width = \"11%\"
             // writer.write("<td width = \"13%\">"+scenario+"</td>");
              //writer.write("<td width = \"21%\">"+TestCond+"</td>");
              writer.write("<td  width=100>"+scenario+"</td>");
              writer.write("<td  width=250>"+TestCond+"</td>");
              writer.write("<td  width=320>"+ExpeResu+"</td>");
              writer.write("<td  width=320>"+ActuResu+"</td>");
              writer.write("<td bgcolor = \"GREEN\" style = \"BORDER-COLOR:BLACK;FONT-FAMILY:VERDANA;FONT-SIZE:12;ALIGN:CENTER;width:100;WORD-BREAK:BREAK-ALL\"><b>"+Status+"</b></td>");
              writer.write("</tr>");
              writer.write("</table>");
              writer.write("</body>");
              writer.write("</head>");
              writer.write("</html>");
              writer.close();
              return true;
       }
       
   	public static void Screenshot(String scenario)
   	{
   		try {
   		System.out.println("Entered Screenshot method");
   		File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		File targetFile = new File(strResultsFolder+ scenario + ".png");
   		System.out.println("the path is:"+targetFile);
   		FileUtils.copyFile(scrnsht, targetFile);  
   		System.out.println("completed Screenshot method");
   		}
   		catch(Exception e)
   		{
   			e.printStackTrace();
   		}
   		//return strResultsFolder+ "scenario" + ".png";
   	}
   	
   	
   	public static void captureScreenShot(String name) throws Exception 
   	{
   		 File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		 FileUtils.copyFile(screenshot,new File(name) );
   		 Thread.sleep(2000);
   	}
   	public static String getdate()
   	{
   		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		Date date = new Date();   		
   		Calendar objCal = Calendar.getInstance();
		objCal.setTime(date);
		String strAppendDateTime = dateFormat.format(new Date());
		strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();	
		return strAppendDateTime;
   		//return dateFormat.format(date);
   	}
   	       
	public String getDateTimeStringWithSeconds()
	{
		SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
		Date objDate = new Date();
		Calendar objCal = Calendar.getInstance();
		objCal.setTime(objDate);
		String strAppendDateTime = objSimpleDtFormat.format(new Date());
		strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();	
		return strAppendDateTime;
	}
	
	
	public static boolean htmlReportFail(String scenario,String TestCond, String ExpeResu, String ActuResu,String Status) throws Exception
	{	
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
   		Date date = new Date();   		
   		Calendar objCal = Calendar.getInstance();
		objCal.setTime(date);
		String strAppendDateTime = dateFormat.format(new Date());
		strAppendDateTime = (strAppendDateTime.replace("/", "-").replace(":", "-")).trim();	
		
		FileWriter fWriter = null;
        BufferedWriter writer = null;
        File file1 = new File(htmlreport);
        fWriter = new FileWriter(file1,true);
        writer = new BufferedWriter(fWriter);
        writer.write("<table border=1 cellpadding=5>");
        writer.write("<tr>");
        writer.write("<td  width=100>"+scenario+"</td>");
        writer.write("<td  width=250>"+TestCond+"</td>");
        writer.write("<td  width=320>"+ExpeResu+"</td>");
        writer.write("<td  width=320>"+ActuResu+"</td>");
        //String strScreenshot = htmlTakeScreenshot(scenario);
        Screenshot(strAppendDateTime);   
      
        
        System.out.println("Navigated to screenshot method");
        String strScreenshot=strResultsFolder+ strAppendDateTime+".png";
   		writer.write("<td bgcolor = \"RED\" style = \"width:100;align:center;\" >" + "<a href=\"" + strScreenshot + "\" target=\"_blank\">"+Status+"</a></b></td>");
		
   		writer.write("</tr>");
        writer.write("</table>");
        writer.write("</body>");
        writer.write("</head>");
        writer.write("</html>");
        writer.close();
        return true;
		
	}
	
       @Test
       public void htmlfile() throws Exception
       {
    	   htmlFunc hf= new htmlFunc();
    	   hf.createNewHTMLFile(htmlreport);
       }
       
       
}
