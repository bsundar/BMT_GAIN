package ReusableComponents;

//import static Config.BaseConfig.driver;
//import static UIWrappers.UIobjects.*;

import static ObjectRepository.ObjectRepository.loginButton;
import static ObjectRepository.ObjectRepository.password;
import static ObjectRepository.ObjectRepository.userName;
import static ObjectRepository.ObjectRepository.accesscode;
import static UIWrappers.UIobjects.clickOn;
import static UIWrappers.UIobjects.enterData;
import static UIWrappers.UIobjects.pause;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import java.awt.Robot;
import java.awt.event.InputEvent;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.testng.annotations.Listeners;
import UIWrappers.Page;
import User_actions.htmlFunc;

@Listeners({ReportsUtils.CustomReport.class,ReportsUtils.ReportSetup.class})

public class commonmethods extends Page {
	static htmlFunc HF = new htmlFunc();
	
	public static void superAdminLogin(String Username, String Password, String Accesscode) throws Exception
	{
		//driver.switchTo().frame("mainFrame");
	    enterData(userName,Username);
	    enterData(password,Password);
	    enterData(accesscode,Accesscode);
	    clickOn(loginButton);
	    pause(4000);
	}	

			/*--------------------------------------------------------------------------------------*
			 *----------------This file contains all common methods used in BMT project-------------*
			*/
			/*--------------------------------------------------------------------------------------*
	 		*----------------McGraw-Hill CTB Automation Team ---------------------------------------*
	 		*/
			/*--------------------------------------------------------------------------------------*
			 *This method "select_test" is used to select test in launch page and verifies login page is displayed* 
			 *-----------------------Test name reads it from the excel file-------------------------*
			 */
		//@SuppressWarnings("static-access")
	
		public static void select_test(String Testname, WebDriver driver) throws Exception {
			try{
				String[] folder = Testname.split(",");
				String parentfolder = folder[0];
				String testName = folder[1];
				System.out.println("Selecting the test "+testName);
				WebElement table = driver.findElement(By.xpath("/html/body/div[2]/section[1]/div"));
				//WebElement table = driver.findElement(By.xpath("html/body/div[2]/section/div/div[1]"));
			    List<WebElement> rows = table.findElements(By.tagName("h3"));
			    int i=1;
			    for(WebElement row:rows) {
			    	if(row.getText().contains(parentfolder))
			    	{
			    		break;
			    	}
			    	else
			    	{
			    		i++;
			    	}
			    	
			    }
			    
			    
			    WebElement testfolder = driver.findElement(By.xpath("/html/body/div[2]/section[1]/div/div["+i+"]"));
			    List<WebElement> tests = testfolder.findElements(By.tagName("li"));
			    	    
			    for (WebElement test : tests) {
			    	
			    	if(test.getText().contains(testName))
			    	{	
			    		String id = test.getAttribute("id");
			    		WebElement testname = driver.findElement(By.xpath("//*[@id='"+id+"']"));//INDIANA CCRA QA Test 01
						testname.click();
						System.out.println(testName+" is selected");
						Thread.sleep(20000);
						break;
			    	}
			    
			    }
				for(String winHandle : driver.getWindowHandles()){
				    driver.switchTo().window(winHandle);
				}
				String browsertitle = driver.getTitle();
				if(browsertitle.startsWith("Login"))
				{
					System.out.println("Login page is displayed");
				}
				else
				{
					System.out.println("Error: Login page is not displayed");
				}
				}
				catch (Exception e) {
					htmlFunc.htmlReportFail("''","Select TestName","TestName Selected","TestName not selected","Fail");
					System.out.println(e);
					Thread.sleep(5000);					
					//driver.quit();
					}
				}
		
		/*--------------------------------------------------------------------------------------*
		 *This method "BMTLogin" is used to click on Login button in Login page and verifies Welcome page is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		//@SuppressWarnings("static-access")
		public static void BMTLogin(WebDriver driver) throws Exception {
			try{
			WebElement Submit = driver.findElement(By.xpath(".//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[2]"));
			//WebElement Submit = driver.findElement(By.xpath("//html/body/div[2]/div[1]/div/div/div[1]/div/center/div[2]/button[2]"));
			System.out.println("Clicking on Login button in Login Screen");
			Submit.click();
			Thread.sleep(15000);
			String browsertitle = driver.getTitle();
			if(browsertitle.startsWith("Test Welcome"))
			{
				System.out.println("Welcome page is displayed");
			}
			else
			{
				System.out.println("Error: Welcome page is not displayed");
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","BMT Login","Login","Login Failed","Fail");
				System.out.println(e);
				Thread.sleep(5000);
				
				//driver.quit();
			}
		
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "Welcomestart" is used to click on start button in Welcome page and verifies Item#1 is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		/*--------------------------------------------------------------------------------------*
		 *This method "BMTLogin" is used to click on Login button in Login page and verifies Welcome page is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void BMTcancel(WebDriver driver) throws Exception {
			try{
			WebElement cancellogin = driver.findElement(By.xpath(".//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[1]"));
			System.out.println("Clicking on cancel button in Login Screen");
			cancellogin.click();
			Thread.sleep(15000);
			String browsertitle = driver.getTitle();
			if(browsertitle.startsWith("Login - OK"))
			{
				System.out.println("Cancel page is displayed");
			}
			else
			{
				System.out.println("Error: Cancel page is not displayed");
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","BMTCancel","BMTCancel Fail", "BMTCancel Fail","Fail");
				System.out.println(e);
				Thread.sleep(5000);
				
			}
		
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "Welcomestart" is used to click on start button in Welcome page and verifies Item#1 is displayed* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		//@SuppressWarnings("static-access")
		public static void Welcomestart(WebDriver driver) throws Exception {
			try{
			WebElement Submit = driver.findElement(By.xpath(".//*[@id='welcome_start_button']"));
			System.out.println("Clicking on Start button in Welcome screen");
			Submit.click();
			Thread.sleep(10000);
			String browsertitle = driver.getTitle();
			//HF.htmlReportFail("+","WelcomeStart Click","Start button click","Start button clicked","Pass");
			if(browsertitle.startsWith("Test"))
			{
				System.out.println("Item #1 is displayed");
			}
			else
			{
				System.out.println("Error: Item #1 is not displayed");
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","Welcome page display","Page display","Page Not display","Fail");				
				System.out.println(e);
				Thread.sleep(5000);
				//driver.quit();
			}
		}
		
		/*--------------------------------------------------------------------------------------*
		 *This method "Welcomestop" is used to click on stop button in Welcome page * 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void Welcomestop(WebDriver driver) throws Exception {
			try{
			WebElement stop = driver.findElement(By.xpath(".//*[@id='welcome_stop_button']"));
			System.out.println("Clicking on Start button in Welcome screen");
			stop.click();
			Thread.sleep(10000);
			String browsertitle = driver.getTitle();
			if(browsertitle.startsWith("Test"))
			{
				System.out.println("Good bye Message is displayed");
			}
			else
			{
				System.out.println("Error: Good bye Message is not displayed");
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","Welcomestop Failed","Welcomestop error","WelcomeStop Error","Fail");	
				System.out.println(e);
				Thread.sleep(5000);
				
			}
		}
		
		
		/*--------------------------------------------------------------------------------------*
		 *This method "clickgoon" is used to click on Go On button in item page ----------------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void clickgoon(WebDriver driver) throws Exception {
			try{
			WebElement goon = driver.findElement(By.xpath("//*[@id='oas-go-on-button']"));
			goon.click();
			System.out.println("Go On button is clicked");
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","GoonClick Error","GoonClick Error","GoonClick Error","Fail");	
				System.out.println(e);
				Thread.sleep(5000);
				
			}
		}
		
		/*--------------------------------------------------------------------------------------*
		 *This method "FinishTest" is used to click on Go On button in item page ----------------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void finishtest(WebDriver driver) throws Exception {
			try{
			WebElement goon = driver.findElement(By.xpath("//*[@id='oas-finish-button']"));
			goon.click();
			System.out.println("Finish test is clicked");
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","FinishTest Error","FinishTest Error","FinishTest Error","Fail");
				System.out.println(e);
				Thread.sleep(5000);
							}
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "verifyitemnumber" is used to verify which item is displayed after clicking Go On* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void verifyitemnumber(WebDriver driver, int item) throws Exception {
			try{
			WebElement itemnumber = driver.findElement(By.xpath("//*[@id='view_container']/div/table[1]/tbody/tr[2]/td[1]"));
			String itemnum=itemnumber.getText();
			if(itemnum.startsWith("QUESTION "+item+" OF"))
			{
				System.out.println("Item #"+item+" is displayed");
			}
			else
			{
				htmlFunc.htmlReportFail("''","Item Navigation","Navigation Error", "Navigation Error","Fail");
				System.out.println("Error: Item #"+item+"is not displayed");
			}
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","Item Navigation","Navigation Error", "Navigation Error","Fail");
				System.out.println(e);
				Thread.sleep(5000);
				
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "clickgoback" is used to click on Go Back button in item page ------------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void clickgoback(WebDriver driver) throws Exception {
			try{
			WebElement goback = driver.findElement(By.xpath("//*[@id='oas-go-back-button']"));
			goback.click();
			System.out.println("Go back button is clicked");
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","clickgoBack","GoBack Error", "GoBack Error","Fail");
				System.out.println(e);
				Thread.sleep(5000);
				
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *This method "itemnavigation"is used to click on itemnumbers at the bottom of the screen* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void itemnavigation(WebDriver driver, int item) throws Exception {
			try{
				
			WebElement itemnum = driver.findElement(By.xpath("//*[@id='oas_goto_"+item+"']"));
			System.out.println("Navigating to Item #"+item);
			itemnum.click();
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","Item Number Error","Item Number Error", "Item Number Error","Fail");
				System.out.println(e);
				Thread.sleep(5000);
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *----------This method "pausetest"is used to click on pause button in item page--------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void pausetest(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='oas_testing_header_button_pause']"));
			System.out.println("Pause Test button is clicked");
			pause.click();
			Thread.sleep(1000);
			WebElement pausetest = driver.findElement(By.xpath("//*[@id='login_container']/div/div/div[1]/h1"));
			String pausetext = pausetest.getText();
			if(pausetext.contains("Log in to resume your paused test"))
			{
				System.out.println("Pause Test Page is displayed");
			}
			else
			{
				System.out.println("Error: Pause test page is not displayed");
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","PauseTest","PauseTest Error", "PauseTest Error","Fail");
				System.out.println(e);
				Thread.sleep(5000);
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *------This method "pauselogin"is used to click on Login button in pause screen--------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void pauselogin(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='login_container']/div/div/div[1]/div/center/div[2]/button[2]"));
			pause.click();
			System.out.println("Login button is clicked");
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","PauseLogin","PauseLogin Failed", "PauseLogin Failed","Fail");
				System.out.println(e);
				Thread.sleep(5000);
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *-----------This method "stoptest"is used to click on stop button in item page---------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void stoptest(WebDriver driver) throws Exception {
			try{
			WebElement stop = driver.findElement(By.xpath("//*[@id='oas_testing_header_button_stop']"));
			System.out.println("Stop Test button is clicked");
			stop.click();
			Thread.sleep(1000);
			WebElement stoptest = driver.findElement(By.xpath("//*[@id='testing_finish_div']/div[1]/div[1]/center/b"));
			String pausetext = stoptest.getText();
			if(pausetext.contains("Have you finished"))
			{
				System.out.println("Stop Test Page is displayed");
			}
			else
			{
				System.out.println("Error: Stop test page is not displayed");
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","StopTest","StopTest Failed", "StopTest Failed","Fail");				
				System.out.println(e);
				Thread.sleep(5000);
				
		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *------This method "stopno"is used to click on No, go back to the test in stop page----* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void stopno(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='oas-test-finish-go-back']"));
			pause.click();
			System.out.println("No, go back to test button is clicked");
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","StopNo","StopNo Failed", "StopNo Failed","Fail");
				System.out.println(e);
				Thread.sleep(5000);
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *----This method "stopyes"is used to click on Yes, I have finished test in stop page---* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void stopyes(WebDriver driver) throws Exception {
			try{
			WebElement pause = driver.findElement(By.xpath("//*[@id='oas-test-finish-finish']"));
			pause.click();
			System.out.println("Yes, I have finished button is clicked");
			Thread.sleep(1000);
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","StopYes","StopYes Failed", "StopYes Failed","Fail");
				System.out.println(e);
				Thread.sleep(5000);		
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *--------This method "blueball"is used to verify blueball is displayed or not----------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void blueballyes(WebDriver driver, int item) throws Exception {
			try{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");

			WebElement blueball = driver.findElement(By.xpath("//*[@id='oas_goto_answered_"+item+"']"));
			Thread.sleep(1000);
			if(blueball.isDisplayed())
			{
				
			}
			else
			{
				System.out.println("Error : Blue ball is not displayed for the item"+item);
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","blueballyes","blueballyes", "blueballyes","Fail");
				System.out.println(e);
				Thread.sleep(5000);		
			}
		}
		public static void blueballno(WebDriver driver, int item) throws Exception {
			try{
			WebElement blueball = driver.findElement(By.xpath("//*[@id='oas_goto_answered_"+item+"']"));
			Thread.sleep(1000);
			if(blueball.isDisplayed())
			{
				System.out.println("Error: Blueball is displayed for the item"+item);
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","blueballno","blueballno", "blueballno","Fail");
				System.out.println(e);
				Thread.sleep(5000);
			}
		}
		/*--------------------------------------------------------------------------------------*
		 *--------This method "answerstatus"is used to verify answer status for each item----------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		public static void answerstatusyes(WebDriver driver, int item) throws Exception {
			try{
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("javascript:window.scrollBy(0,8000)");

			WebElement answerstatus = driver.findElement(By.xpath("//*[@id='testing_footer_bmt']/table/tbody/tr/td[3]/table/tbody/tr[1]/td/center"));
			String answertext = answerstatus.getText();
			Thread.sleep(1000);
			if(answertext.equals("- NOT ANSWERED -"))
			{
				System.out.println("Error: Answer status is  Not Answered for item #"+item);
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","answerstatusyes","answerstatusyes", "answerstatusyes","Fail");
				System.out.println(e);
				Thread.sleep(5000);		
			}
		}
		public static void answerstatusno(WebDriver driver, int item) throws Exception {
			try{
			WebElement answerstatus = driver.findElement(By.xpath("//*[@id='testing_footer_bmt']/table/tbody/tr/td[3]/table/tbody/tr[1]/td/center"));
			String answertext = answerstatus.getText();
			Thread.sleep(1000);
			if(answertext.equals("- ANSWERED -"))
			{
				System.out.println("Error: Answer status is  Answered for item #"+item);
			}
			}
			catch (Exception e) {
				htmlFunc.htmlReportFail("''","answerstatusno","answerstatusno", "answerstatusno","Fail");
				System.out.println(e);
				Thread.sleep(5000);
		
			}
		}
		
				
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to create log files----------* 
		 *--------------------------------------------------------------------------------------*  
		 */
		
		public static void creatLog(String filepath) throws Exception {
			File file = new File(filepath);  
			FileOutputStream fis = new FileOutputStream(file);  
			PrintStream out = new PrintStream(fis);  
			System.setOut(out); 
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to DropDown Box Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		public static void dropDownResetOk(int intitem) throws Exception{
			
		try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_options']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[1]"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
	    }
		catch(Exception e){	
			htmlFunc.htmlReportFail("''","dropDownResetOk","dropDownResetOk", "dropDownResetOk","Fail");
			e.printStackTrace();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to DropDown Box Reset and Click cancel on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		public static void dropDownResetCancel() throws Exception{
		try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_options']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement cancelButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[2]"));
		System.out.println("Clicked the reset's cancel button");
		cancelButton.click();
		}
		catch(Exception e){			
			htmlFunc.htmlReportFail("''","dropDownResetCancel","dropDownResetCancel", "dropDownResetCancel","Fail");
			e.printStackTrace();
		}
			
		}
		
	
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Match Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		public static void matchResetOk(int intitem) throws Exception{
	    try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='match_line_resetitem_area_0_match_line_canvas']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[1]"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
		
	}
		catch(Exception e){			
			htmlFunc.htmlReportFail("''","matchResetOk","matchResetOk", "matchResetOk","Fail");
			e.printStackTrace();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Match Reset and Click cancel on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		public static void matchResetCancel() throws Exception{
			
		  try{			
				WebElement reset=driver.findElement(By.xpath(".//*[@id='match_line_resetitem_area_0_match_line_canvas']"));
				reset.click();
				System.out.println("Clicked the reset button");
				WebElement okButton=driver.findElement(By.xpath("//html/body/div[7]/div[3]/div/button[2]"));
				System.out.println("Clicked the reset's cancel button");
				okButton.click();
				
			}
				catch(Exception e){	
					htmlFunc.htmlReportFail("''","matchResetCancel","matchResetCancel", "matchResetCancel","Fail");
					e.printStackTrace();
				}
					
				}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Select Text Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		public static void selecttextResetOk(int intitem) throws Exception{
	    try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_select']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("//html/body/div[9]/div[3]/div/button[1]/span"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
		
	}
		catch(Exception e){	
			htmlFunc.htmlReportFail("''","selecttextResetOk","selecttextResetOk", "selecttextResetOk","Fail");
			e.printStackTrace();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Match Reset and Click cancel on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		public static void selecttextResetCancel() throws Exception{
			
		  try{			
				WebElement reset=driver.findElement(By.xpath(".//*[@id='reset_select']"));
				reset.click();
				System.out.println("Clicked the reset button");
				WebElement okButton=driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/button[2]/span"));
				System.out.println("Clicked the reset's cancel button");
				okButton.click();
				
			}
				catch(Exception e){	
					htmlFunc.htmlReportFail("''","selecttextResetCancel","selecttextResetCancel", "selecttextResetCancel","Fail");
					e.printStackTrace();
				}
					
				}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Graph Reset and Click Ok on confirmation----------* 
		 *--------------------------------------------------------------------------------------*  
		 */		
		public static void graphResetOk(int intitem) throws Exception{
	    try{			
		WebElement reset=driver.findElement(By.xpath(".//*[@id='item_area_0_grid_reset']"));
		reset.click();
		System.out.println("Clicked the reset button");
		WebElement okButton=driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/button[1]/span"));
		okButton.click();
		System.out.println("Clicked the reset's OK button");
		verifyitemnumber(driver, intitem);
		blueballno(driver,intitem);
		answerstatusno(driver,intitem);
		
	}
		catch(Exception e){			
			htmlFunc.htmlReportFail("''","graphResetOk","graphResetOk", "graphResetOk","Fail");
			e.printStackTrace();
		}
			
		}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Graph-----------------------------------------------**/		
		public static void graphResetCancel() throws Exception{
			
		  try{			
				WebElement reset=driver.findElement(By.xpath(".//*[@id='item_area_0_grid_reset']"));
				reset.click();
				System.out.println("Clicked the reset button");
				WebElement okButton=driver.findElement(By.xpath("/html/body/div[9]/div[3]/div/button[2]/span"));
				System.out.println("Clicked the reset's cancel button");
				okButton.click();
			}
				catch(Exception e){	
			htmlFunc.htmlReportFail("''","graphResetCancel","graphResetCancel", "graphResetCancel","Fail");
					e.printStackTrace();
				}
				}
		
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to Highlighter-----------------------------------------------**/		
		public static void highlight() throws Exception{
			
		  try{
			  List<WebElement> elements = driver.findElements(By.cssSelector("[display=none]"));
			  int count = elements.size();
			  System.out.println("The size of display:none is:"+count);
			 WebElement canvasArea=driver.findElement(By.xpath(".//*[@id='item_area_0']"));
				//String BeforebgColor = ((WebElement) canvasArea).getCssValue("background-color");
			  String BeforebgColor=driver.findElement(By.xpath(".//*[@id='item_area_0']")).getCssValue("background-color");
		        System.out.println("Before hover: " + BeforebgColor); 
				WebElement highlight=driver.findElement(By.xpath(".//*[@id='highlight-btn']"));
				highlight.click();
				System.out.println("selected highlighter button");
				pause(10000);
			
				
				     
				Actions builder= new Actions(driver);
				Action allactions= builder
						.moveToElement(canvasArea)
						.moveByOffset(130,450)
						.click()
						.dragAndDropBy(canvasArea,155,405)
						//.release(canvasArea)
						.build();
				allactions.perform();
				
				//String bgColor = ((WebElement) allactions).getCssValue("background-color");
		        //System.out.println("Before hover: " + bgColor);   
				//dragandDro(0,300,500);				
			}
				catch(Exception e){			
					e.printStackTrace();
				}
					
				}
		
		/*--------------------------------------------------------------------------------------*
		 *--------This method is used to eraser-----------------------------------------------**/		
		public static void eraser() throws Exception{
			
		  try{			
				WebElement erase=driver.findElement(By.xpath(".//*[@id='erase-btn']"));
				erase.click();
				System.out.println("selected Eraser button");
				pause(10000);	
				WebElement canvasArea=driver.findElement(By.xpath(".//*[@id='item_area_0']"));
			//	String BeforebgColor = ((WebElement) canvasArea).getCssValue("background-color");
		    //    System.out.println("Before hover: " + BeforebgColor); 			
				
				eraserClick(0,940,640);
				String AfterbgColor = ((WebElement) canvasArea).getCssValue("background-color");
		        System.out.println("After hover with eraser clicked: " + AfterbgColor);   
				
			}
				catch(Exception e){			
					e.printStackTrace();
				}
				}
		
		public static void eraserClick(int x,int y, int z) throws Exception {
			{
			  
				WebElement canvasArea=driver.findElement(By.xpath(".//*[@id='item_area_0']"));
		        Point objPoint = ((Locatable)canvasArea).getCoordinates().inViewPort();
		        Robot objRobot = new Robot();
		        int intWbEltX = objPoint.x;
		        System.out.print(intWbEltX);
		        int intWbEltY = objPoint.y;
		        System.out.print("\n"+intWbEltY);
		        int intBRWToolbarHeight = x;
		        System.out.print("\n"+intBRWToolbarHeight+"\n");
		        Thread.sleep(1000);
		        objRobot.mouseMove(y, z);
		        //canvasArea.click();
		        objRobot.mousePress(InputEvent.BUTTON1_MASK);
		        Thread.sleep(2000);
		        objRobot.mouseRelease(InputEvent.BUTTON1_MASK);
		        Thread.sleep(8000);
			       }
		}

			
		}
		
