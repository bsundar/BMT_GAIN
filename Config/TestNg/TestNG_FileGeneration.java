package TestNg;

import java.io.PrintWriter;
import ReusableComponents.*;
import static Config.XlsReader.*;

public class TestNG_FileGeneration{
	
	public static void main (String args[]) throws Exception
	{
		String yuseractions= xmlStatus(0,1,1);
		System.out.println("The Value of yuseractions :"+yuseractions);
		String yansweredstatus= xmlStatus(0,2,1);
		System.out.println("The Value of yansweredstatus :"+yansweredstatus);
		String yitemNavigation= xmlStatus(0,3,1);
		System.out.println("The Value of yitemNavigation :"+yitemNavigation);
		String ypauseTest= xmlStatus(0,4,1);
		System.out.println("The Value of ypauseTest:"+ypauseTest);
		String ystopTest= xmlStatus(0,5,1);
		System.out.println("The Value of ystopTest:"+ystopTest);	
		String TNuseractions= xmlStatus(0,1,0);
		System.out.println("The Value of TNuseractions:"+TNuseractions);
		String TNansweredstatus= xmlStatus(0,2,0);
		System.out.println("The Value of TNansweredstatus:"+TNansweredstatus);
		String TNitemNavigation= xmlStatus(0,3,0);
		System.out.println("The Value of TNitemNavigation :"+TNitemNavigation);
		String TNpauseTest= xmlStatus(0,4,0);
		System.out.println("The Value of TNpauseTest:"+TNpauseTest);
		String TNstopTest= xmlStatus(0,5,0);
		System.out.println("The Value of TNstopTest:"+TNstopTest);
				
		PrintWriter writer = new PrintWriter(TestNgXml,"UTF-8");
		writer.println("<suite name ="+'"'+"BMT REGRESSION SUITE"+'"'+">");
		writer.println("<test name ="+'"'+"BMT"+'"'+ ">");
		writer.println("<classes>");
		if(yuseractions.equals("Y"))				
		{
	   	writer.println("<class name="+'"'+"User_actions."+TNuseractions+'"'+"/>");
		}
		writer.println("<methods>");
		if(yitemNavigation.endsWith("Y"))
				{
			writer.println("<include name='"+TNitemNavigation+"'/>");
				}
		if(ypauseTest.endsWith("Y"))
		 {
	      writer.println("<include name='"+TNpauseTest+"'/>");
	    }
		if(yansweredstatus.endsWith("Y"))
		{
	    writer.println("<include name='"+TNansweredstatus+"'/>");
		}
       if(ystopTest.endsWith("Y"))
       {
        writer.println("<include name='"+TNstopTest+"'/>");
       }
		writer.println("</methods>");
		writer.println("</classes>");
		writer.println("</test>");
		writer.println("</suite>");
		writer.close();
		
		htmlReport hf= new htmlReport();
		hf.createResultFile("C:\\Automation _Framework\\BMTNEW\\Test_Output");	
		
	}

}
