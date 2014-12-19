package User_actions;


import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;

import static ReusableComponents.commonmethods.*;
import static UIWrappers.UIobjects.log;
import static Config.XlsReader.*;
import ReusableComponents.*;
import UIWrappers.Page;
import static UIWrappers.UIobjects.*;



@Listeners({ReportsUtils.CustomReport.class,ReportsUtils.ReportSetup.class})

public class Useractions extends Page{
	
	htmlReport HF = new htmlReport();
 
		
    @Test(enabled=false)
	//@Test
	public void answeredstatus() throws Exception
		{
		try{
		System.out.print("entered answeredstatus");
		Fetchmethod("Sheet2");
	    int rowno = FindRowno("answeredstatus");
	    FetchExceldata(rowno);
		String uname = localArray1[0][0];
		String pwd = localArray1[0][1];
		String acccode = localArray1[0][2];
		Integer accesscode =Integer.parseInt(acccode);
		String Testname = localArray1[0][3];
		String noofitem1 = localArray1[0][4];
		Integer intitem =Integer.parseInt(noofitem1);
		String response1 = localArray1[0][5];
		Integer  response =Integer.parseInt(response1);	
		System.out.println("The uname is:"+uname);
		System.out.println("The pwd is:"+pwd);
		System.out.println("The accesscode is:"+accesscode);
		System.out.println("The Testname is:"+Testname);
		System.out.println("The Testname is:"+intitem);
		System.out.println("The noofitem is:"+response);
			
	
		//Login with Username, Password, Accesscode
		//superAdminLogin(String Username, String Password, String Accesscode);
		HF.addResultToHTMLFile(""+fetchCell(0,14,0),""+fetchCell(0,14,1),""+fetchCell(0,14,2),""+fetchCell(0,14,3),""+fetchCell(0,14,4), "Pass");
		
	
		select_test(Testname, driver);
		pause(5000);
		HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,15,3),""+fetchCell(0,15,4),"Pass");
		
	
	    //Clicking on Login button
	    BMTLogin(driver); 
	    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,16,3),""+fetchCell(0,16,4),"Pass");
	    
	    
	    //Clicking on Start in welcome screen
	    Welcomestart(driver);
	    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,17,3),""+fetchCell(0,17,4),"Pass");
	    	
		 
	   //Navigating to item number
		
		for(int i=1;i<intitem+1;i++)
		{   
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(0,8000)");
			itemnavigation(driver, i);	
			//
			
			verifyitemnumber(driver, i);
			blueballno(driver, i);
			answerstatusno(driver, i);
			

		}
		HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,18,3),""+fetchCell(0,18,4),"Pass");
		HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,19,3),""+fetchCell(0,19,4),"Pass");
		}
		
		catch(Exception e)
		 {
		
			HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
		 }
		}
	

		//@Test(enabled=false)
		@Test
		public void itemNavigation() throws Exception
		{
		 try
		 {
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("itemNavigation");
		    FetchExceldata(rowno);		    		
			String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
			Integer accesscode =Integer.parseInt(acccode);
			String Testname = localArray1[0][3];
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);	
			System.out.println("The uname is:"+uname);
			System.out.println("The pwd is:"+pwd);
			System.out.println("The accesscode is:"+accesscode);
			System.out.println("The Testname is:"+Testname);
			System.out.println("The Testname is:"+noofitem);
			System.out.println("The noofitem is:"+response);
						
			
			//Login with Username, Password, Accesscode
			//superAdminLogin(String Username, String Password, String Accesscode);
			HF.addResultToHTMLFile(""+fetchCell(0,1,0),""+fetchCell(0,1,1),""+fetchCell(0,1,2),""+fetchCell(0,1,3),""+fetchCell(0,1,4), "Pass");
			
			
			select_test(Testname, driver);
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,2,3),""+fetchCell(0,2,4),"Pass");
			
			   //Clicking on Login button
		    BMTLogin(driver); 
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,3,3),""+fetchCell(0,3,4),"Pass");
		   
		    
		    log("Step 7: Clicking start in welcome screen.");
		    //Clicking on Start in welcome screen
		    Welcomestart(driver);
		    log("Actual Result : Clicked start in welcome screen.");
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,4,3),""+fetchCell(0,4,4),"Pass");
		   
		   log("Step 8: checking for Item navigation ");	
		
		
		
			//Item navigation is verified in below step
			for(int noofitems=2;noofitems<noofitem+1;noofitems++)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
				
			}
			
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,5,3),""+fetchCell(0,5,4),"Pass");
			//Item navigation is verified in below step
			for(int noofitems=noofitem-1;noofitems>0;noofitems--)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
				
			}
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,6,3),""+fetchCell(0,6,4),"Pass");
			log("Actual Result : Item navigation is completed");
			
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,7,3),""+fetchCell(0,7,4),"Pass");
			
		 			
		 }
		 
		 catch(Exception e)
		 {
			 
			 HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
			 
		 }
		}
	 
	//@Test(enabled=true)
		@Test
		public void pauseTest() throws Exception
			{
		 try
		    {
		    
			 //Reading Data From Excel
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("pauseTest");
		    FetchExceldata(rowno);
		    String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
			Integer accesscode =Integer.parseInt(acccode);
			String Testname = localArray1[0][3];
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);	
			System.out.println("The uname is:"+uname);
			System.out.println("The pwd is:"+pwd);
			System.out.println("The accesscode is:"+accesscode);
			System.out.println("The Testname is:"+Testname);
			System.out.println("The Testname is:"+noofitem);
			System.out.println("The noofitem is:"+response);
			
			
			
			//Login with Username, Password, Accesscode
			//superAdminLogin(String Username, String Password, String Accesscode);
			HF.addResultToHTMLFile(""+fetchCell(0,8,0),""+fetchCell(0,8,1),""+fetchCell(0,8,2),""+fetchCell(0,8,3),""+fetchCell(0,8,4), "Pass");
			
			
			select_test(Testname, driver);
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,9,3),""+fetchCell(0,9,4),"Pass");
			
		    //Clicking on Login button
		    BMTLogin(driver); 
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,10,3),""+fetchCell(0,10,4),"Pass");
		    
		    
		    //Clicking on Start in welcome screen
		    pause(10000);
		    Welcomestart(driver);		    
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,11,3),""+fetchCell(0,11,4),"Pass");
		   
		   	//We are verifying Pause test button
				for(int noofitems=1;noofitems<noofitem+1;noofitems++)
				{
					verifyitemnumber(driver, noofitems);
					pausetest(driver);
					pauselogin(driver);
					verifyitemnumber(driver, noofitems);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("javascript:window.scrollBy(0,8000)");
					
					if (noofitems<noofitem)
					{
						clickgoon(driver);
					}
					else
						
						finishtest(driver);
										
				}				
				HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,12,3),""+fetchCell(0,12,4),"Pass");
				HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,13,3),""+fetchCell(0,13,4),"Pass");
			
		    }
			 catch(Exception e)
			 {
				 
				 HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
				 
			 }

		}
	 
	//@SuppressWarnings("static-access")
	//@Test(enabled=false)
		@Test
		public void StopTest() throws Exception
		{			
		    try{	
		    System.out.println("Entered stoptest");
		    Fetchmethod("Sheet2");
		    int rowno = FindRowno("StopTest");
		    FetchExceldata(rowno);		       
			String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
			Integer accesscode =Integer.parseInt(acccode);
			String Testname = localArray1[0][3];
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);	
			System.out.println("The uname is:"+uname);
			System.out.println("The pwd is:"+pwd);
			System.out.println("The accesscode is:"+accesscode);
			System.out.println("The Testname is:"+Testname);
			System.out.println("The Testname is:"+noofitem);
			System.out.println("The noofitem is:"+response);
						
			
			//Login with Username, Password, Accesscode
			//superAdminLogin(String Username, String Password, String Accesscode);
			HF.addResultToHTMLFile(""+fetchCell(0,20,0),""+fetchCell(0,20,1),""+fetchCell(0,20,2),""+fetchCell(0,20,3),""+fetchCell(0,20,4), "Pass");
			
			
			select_test(Testname, driver);
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,21,3),""+fetchCell(0,21,4),"Pass");
			
			
		    //Clicking on Login button
		    BMTLogin(driver); 
		    
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,22,3),""+fetchCell(0,22,4),"Pass");
		    
		    log("Step 7: Clicking start in welcome screen.");
		    //Clicking on Start in welcome screen
		    Welcomestart(driver);
		    log("Actual Result : Clicked start in welcome screen.");
		    HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,23,3),""+fetchCell(0,23,4),"Pass");
		   
		   log("Step 8: Checking for StopTest functioanlity");	
		   
			for(int noofitems=1;noofitems<noofitem+1;noofitems++)
			{
				verifyitemnumber(driver, noofitems);
				stoptest(driver);
				stopno(driver);
				verifyitemnumber(driver, noofitems);
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				
				if (noofitems<noofitem)
				{
					clickgoon(driver);
				}
				else
					
					finishtest(driver);
				

			}
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,24,3),""+fetchCell(0,24,4),"Pass");
		 
			HF.addResultToHTMLFile("''","''","''",""+fetchCell(0,25,3),""+fetchCell(0,25,4),"Pass");
		    }
		    catch(Exception e)
			 {
				
		    	HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail");
				
				 
			 }    

	}
	 
	 //@Test(enabled=false)
		@Test
		public void highlightEraser() throws Exception
		{
		    log("Step 1:Test Case name: highlighter");
			log("Started reading reference from Excel, sheet1");
			Fetchmethod("Sheet2");
		    int rowno = FindRowno("itemNavigation");
		    FetchExceldata(rowno);
		    log("Actual Result: Identified the item Navigation in sheet 1");
		    
			log("Step 2: Hitting the BMT URL");	
			log("Actual Result: Browser Intialized and navigated to target URL");
			
			log("Step 3: Fetching UserName, Password, Access Code,TestName,noofItems,responses");
			String uname = localArray1[0][0];
			String pwd = localArray1[0][1];
			String acccode = localArray1[0][2];
			Integer accesscode =Integer.parseInt(acccode);
			String Testname = localArray1[0][3];
			String noofitem1 = localArray1[0][4];
			Integer noofitem =Integer.parseInt(noofitem1);
			String response1 = localArray1[0][5];
			Integer  response =Integer.parseInt(response1);	
			System.out.println("The uname is:"+uname);
			System.out.println("The pwd is:"+pwd);
			System.out.println("The accesscode is:"+accesscode);
			System.out.println("The Testname is:"+Testname);
			System.out.println("The Testname is:"+noofitem);
			System.out.println("The noofitem is:"+response);
			log("Actual Result: Fetching UserName,Password,Access Code,TestName,noofItems,responses");
			
			log("Step 4: Entering Username,password,Accesscode");
			//Login with Username, Password, Accesscode
			//superAdminLogin(String Username, String Password, String Accesscode);
			log("Actual Result: Entered Username,password,Accesscode");
			
			log("Step 5: Selecting TestName");
			select_test(Testname, driver);
			log("Actual Result: Selected TestName");
			
			log("Step 6: Clicking Login Button.");
		    //Clicking on Login button
		    BMTLogin(driver); 
		    log("Actual Result: Clicked Login button");
		    
		    log("Step 7: Clicking start in welcome screen.");
		    //Clicking on Start in welcome screen
		    Welcomestart(driver);
		    log("Actual Result : Clicked start in welcome screen.");
		   
		   log("Step 8: checking for Item navigation ");	
		
		
		
			//Item navigation is verified in below step
			for(int noofitems=2;noofitems<noofitem+1;noofitems++)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
				highlight();
				eraser();
				

			}
			//Item navigation is verified in below step
			/*for(int noofitems=noofitem-1;noofitems>0;noofitems--)
			{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");
				itemnavigation(driver, noofitems);
				verifyitemnumber(driver, noofitems);
				
			}*/
			log("Actual Result : Item navigation is completed");
			driver.quit();
		}
	 
	//@SuppressWarnings("static-access")
	//@Test(enabled=false)
		@Test
	  public void screenshot() throws Exception
	  {
		  
		/*System.out.println("Entered Screenshot method");
   		File scrnsht =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
   		String scenario = "C:\\Users\\t0043920\\Desktop\\one";
		File targetFile = new File(scenario+".png");
   		System.out.println("the path is:"+targetFile);
   		FileUtils.copyFile(scrnsht, targetFile);  
   		System.out.println("completed Screenshot method");*/
   		HF.htmlReportFail("''","''","''","''","Aborted Execution","Fail"); 
	  }
	 
	 
}
