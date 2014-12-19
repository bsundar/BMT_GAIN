package User_actions;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.List;
import org.testng.annotations.Listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import UIWrappers.Page;
import static ReusableComponents.commonmethods.*;
import static UIWrappers.UIobjects.log;
import static Config.XlsReader.localArray1;

@Listeners({ReportsUtils.CustomReport.class,ReportsUtils.ReportSetup.class})

public class mixedItems extends Page {

	public static void mcresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String responsenum = localArray1[0][2];
			Integer response =Integer.parseInt(responsenum);
			Thread.sleep(3000);
			
			WebElement sranswer = driver.findElement(By.xpath("//*[@id='img_mc"+response+"_item_area_0_multiple_choices']"));
			//.//*[@id='img_mc1_item_area_0_multiple_choices']
			sranswer.click();
			log("Option "+response+" is checked");
			blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);
			
			Thread.sleep(3000);
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	
	public static void ebsrmcresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String responsenum = localArray1[0][2];
			Integer response =Integer.parseInt(responsenum);
			Thread.sleep(3000);
			
			WebElement sranswer = driver.findElement(By.xpath("//*[@id='img_mc"+response+"_item_area_0_multiple_choices']"));
			sranswer.click();
			log("Option "+response+" is checked");
						
			Thread.sleep(3000);
			
			String responsenum2 = localArray1[0][3];
			Integer response2 =Integer.parseInt(responsenum2);
			Thread.sleep(3000);
			
			WebElement sranswer2 = driver.findElement(By.xpath("//*[@id='img_mc"+response2+"_item_area_1_multiple_choices']"));
			sranswer2.click();
			log("Option "+response+" is checked");
			blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);
			
			Thread.sleep(3000);
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	public static void mcresponses1(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String responsenum = localArray1[0][2];
			Integer response =Integer.parseInt(responsenum);
			Thread.sleep(3000);
			
			WebElement sranswer = driver.findElement(By.xpath("//*[@id='img_"+response+"']"));
			sranswer.click();
			log("Option "+response+" is checked");
			blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);
			
			Thread.sleep(3000);
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	public static void ddresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String response = localArray1[0][2];
		    String responses[] = response.split(",");
		    
		   	Thread.sleep(3000);
			int select=1;
			WebElement dropdown = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p"));
			List<WebElement> noofdropdowns = dropdown.findElements(By.tagName("select"));
			
			if(noofdropdowns.size()==0)
			{
							
				WebElement vselect = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p["+responses[0]+"]/span/select"));
				vselect.click();
				Thread.sleep(1000);
				
				blueballyes(driver, intitem);
				answerstatusyes(driver, intitem);
			}
			for(WebElement onedropdown : noofdropdowns)
			{
				if(noofdropdowns.size()==0)
					{
						WebElement vselect = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p["+responses[0]+"]/span/select"));
						vselect.click();
						Thread.sleep(1000);
					}
					else
					{
						
					WebElement vselect = driver.findElement(By.xpath("//*[@id='options_table']/tbody/tr/td[2]/span/p["+responses[select-1]+"]/span/select["+select+"]"));
					vselect.click();
					Thread.sleep(1000);
					}
				
				select++;
				blueballyes(driver, intitem);
				answerstatusyes(driver, intitem);
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	
	public static void miresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String pxoffset1 = localArray1[0][2];
			Integer pxoffset =Integer.parseInt(pxoffset1);
			String rxoffset1 = localArray1[0][3];
			Integer rxoffset =Integer.parseInt(rxoffset1);
			String response = localArray1[0][4];
		    String[] responses = response.split(",");
		    int count = responses.length;
		    
		    for(int yoffset=0;yoffset<count;yoffset++)
		    {
		    	String pyoffset1 = responses[yoffset];
		    	Integer pyoffset =Integer.parseInt(pyoffset1);
		    	yoffset = yoffset+1;
		    	String ryoffset1 = responses[yoffset];
		    	Integer ryoffset =Integer.parseInt(ryoffset1);
		    	WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_match_line_canvas']"));
		    	Thread.sleep(1000);
		    	
		    	new Actions(driver).moveToElement(table_element,0,0).moveByOffset(pxoffset,pyoffset).click().build().perform();
		    	Thread.sleep(1000);
		    	
		    	new Actions(driver).moveToElement(table_element,0,0).moveByOffset(rxoffset,ryoffset).click().build().perform();
		    	Thread.sleep(1000);
		    	
		    }
		    blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);	
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	
	public static void scresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String pxoffset1 = localArray1[0][2];
			Integer pxoffset =Integer.parseInt(pxoffset1);
			String rxoffset1 = localArray1[0][3];
			Integer rxoffset =Integer.parseInt(rxoffset1);
			String pyoffset1 = localArray1[0][4];
			Integer pyoffset =Integer.parseInt(pyoffset1);
			String ryoffset1 = localArray1[0][5];
			Integer ryoffset =Integer.parseInt(ryoffset1);
		    
			WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_foreground_canvas']"));
			Thread.sleep(1000);
			new Actions(driver).moveToElement(table_element,0,0).moveByOffset(pxoffset,rxoffset).click().build().perform();
			Thread.sleep(1000);
			new Actions(driver).moveToElement(table_element,0,0).moveByOffset(pyoffset,ryoffset).click().build().perform();
			Thread.sleep(1000);
			blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	public static void ppresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String noofpoint = localArray1[0][2];
			Integer noofpoints =Integer.parseInt(noofpoint);
			int colno=3;
			for(int i=0;i<noofpoints;i++)
			{
				
				String pxoffset1 = localArray1[0][colno];
				Integer pxoffset =Integer.parseInt(pxoffset1);
				colno=colno+1;
				String rxoffset1 = localArray1[0][colno];
				Integer rxoffset =Integer.parseInt(rxoffset1);
				System.out.println("Co-ordinates: "+pxoffset+","+rxoffset);
				WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_foreground_canvas']"));
				Thread.sleep(1000);
				new Actions(driver).moveToElement(table_element,0,0).moveByOffset(pxoffset,rxoffset).click().build().perform();
				Thread.sleep(1000);
				blueballyes(driver, intitem);
				answerstatusyes(driver, intitem);
				colno++;
			}
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	public static void spresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			String orientation = localArray1[0][2];
			String xoffset1 = localArray1[0][3];
			Integer xoffset =Integer.parseInt(xoffset1);
			String yoffset1 = localArray1[0][4];
			Integer yoffset =Integer.parseInt(yoffset1);
			
			WebElement table_element = driver.findElement(By.xpath("//*[@id='item_area_0_foreground_canvas']"));
			Thread.sleep(1000);
			WebElement table_orientationup = driver.findElement(By.xpath("//*[@id='"+orientation+"item_area_0_grid_canvas']"));
			table_orientationup.click();
			new Actions(driver).moveToElement(table_element,0,0).moveByOffset(xoffset,yoffset).click().build().perform();
			Thread.sleep(1000);
			blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	public static void soresponses(WebDriver driver, int introw, int intitem) throws Exception {
	     try{
	    	String response = localArray1[0][2];
           String responses[]=response.split(",");
           int count = responses.length;
           System.out.println("The number of responses is: "+count);
                                  
       for(int i=0;i<count;i++)
           {
    	   int j=i;
			j++;
			int var=j;
    	   System.out.println("In for loop: "+i);
       	   System.out.println("Response "+var+": "+responses[i]);
              String responses1[]=responses[i].split("-");
              System.out.println("The responses are:"+responses1[0]);
              System.out.println("The responses are:"+responses1[1]);
              System.out.println("The responses are:"+responses1[2]);
              System.out.println("The responses are:"+responses1[3]);
              Integer y =Integer.parseInt(responses1[0]);
              Integer z =Integer.parseInt(responses1[1]);
              Integer var1 =Integer.parseInt(responses1[2]);
              Integer var2 =Integer.parseInt(responses1[3]);
              dragandDro(5, y, z, var1, var2);    
              
                                                                
                           }
       }
       catch (Exception e) {
              System.out.println(e);
              Thread.sleep(5000);
              //driver.quit();
              }
	}
	
	public static void dragandDro(int x,int y, int z, int res1, int res2) throws Exception {
		{
		       //First col checkbox selection
			
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("javascript:window.scrollBy(0,8000)");
			
		        //commonmethods multiplecorrect = new commonmethods();
		       //res++;
		       System.out.println("Res:"+res1);
		        Actions builder = new Actions(driver);
		        Thread.sleep(10000);         
		        WebElement sourceElement = driver.findElement(By.xpath(".//*[@id='src_div']/div["+res1+"]/img"));
		        //WebElement sourceElement = driver.findElement(By.xpath(".//*[@id='src_div']/div[1]/img"));
		        Action drag = builder.clickAndHold(sourceElement).build();
		        drag.perform();
		                    
		        WebElement element = driver.findElement(By.xpath(".//*[@id='a"+res2+"']"));
		       // WebElement element = driver.findElement(By.xpath(".//*[@id='a1']"));
		        Point objPoint = ((Locatable)element).getCoordinates().inViewPort();
		        Robot objRobot = new Robot();
		        int intWbEltX = objPoint.x;
		        System.out.print(intWbEltX);
		        int intWbEltY = objPoint.y;
		        System.out.print("\n"+intWbEltY);
		        int intBRWToolbarHeight = x;
		        System.out.print("\n"+intBRWToolbarHeight+"\n");
		        Thread.sleep(1000);
		        objRobot.mouseMove(y, z);
		        objRobot.mousePress(InputEvent.BUTTON1_MASK);
		        
		        Thread.sleep(200);
		        objRobot.mouseRelease(InputEvent.BUTTON1_MASK);
		           Thread.sleep(8000);
		           		           
		       }
	}
	
	public static void mcrresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			String response = localArray1[0][2];
			String responses[]=response.split(",");
			int count = responses.length;
			System.out.println("The number of responses is: "+count);
					
			for(int i=0;i<count;i++)
			{
				int j=i;
				j++;
				int var=j;
				System.out.println("Response "+var+": "+responses[i]);
				driver.findElement(By.xpath(".//*[@id='img_ms"+responses[i]+"_item_area_0_multiple_selections']")).click();
			//	.//*[@id='img_ms1_item_area_0_multiple_selections']
				blueballyes(driver, intitem);
				answerstatusyes(driver,intitem);
				Thread.sleep(1000);
							
			}
						
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	public static void ebsrmcrresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			String response = localArray1[0][2];
			String responses[]=response.split(",");
			int count = responses.length;
					
			for(int i=0;i<=count-1;i++)
			{
				driver.findElement(By.xpath("//input[@id='ms"+responses[i]+"_item_area_0_multiple_selections']")).click();
								Thread.sleep(1000);
							
			}
			String response2 = localArray1[0][3];
			String responses2[]=response2.split(",");
			int count2 = responses2.length;
					
			for(int i=0;i<=count2-1;i++)
			{
				driver.findElement(By.xpath("//input[@id='ms"+responses2[i]+"_item_area_1_multiple_selections']")).click();
				blueballyes(driver, intitem);
				answerstatusyes(driver,intitem);
				Thread.sleep(1000);
							
			}
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	public static void ebsrmcmcrresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			String responsenum = localArray1[0][2];
			Integer response =Integer.parseInt(responsenum);
			Thread.sleep(3000);
			
			WebElement sranswer = driver.findElement(By.xpath("//*[@id='img_mc"+response+"_item_area_0_multiple_choices']"));
			sranswer.click();
			log("Option "+response+" is checked");
			
			
			Thread.sleep(3000);
			
			String response2 = localArray1[0][3];
			String responses2[]=response2.split(",");
			int count2 = responses2.length;
					
			for(int i=0;i<=count2-1;i++)
			{
				driver.findElement(By.xpath("//input[@id='ms"+responses2[i]+"_item_area_1_multiple_selections']")).click();
				blueballyes(driver, intitem);
				answerstatusyes(driver,intitem);
				Thread.sleep(1000);
							
			}
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	
	public static void ebsrmcrmcresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			String response2 = localArray1[0][2];
			String responses2[]=response2.split(",");
			int count2 = responses2.length;
					
			for(int i=0;i<=count2-1;i++)
			{
				driver.findElement(By.xpath("//input[@id='ms"+responses2[i]+"_item_area_0_multiple_selections']")).click();
				Thread.sleep(1000);
							
			}
			
			String responsenum = localArray1[0][3];
			Integer response =Integer.parseInt(responsenum);
			Thread.sleep(3000);
			
			WebElement sranswer = driver.findElement(By.xpath("//*[@id='img_mc"+response+"_item_area_1_multiple_choices']"));
			sranswer.click();
			log("Option "+response+" is checked");
			blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);
			
			Thread.sleep(3000);
								
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	
	public static void stresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String response = localArray1[0][2];
			String responses[]=response.split(",");
			int count = responses.length;
			for(int i=1;i<count-1;i++)
			{
			WebElement selecttestrespopnse = driver.findElement(By.xpath("//*[@id='T"+responses[i]+"']"));
			selecttestrespopnse.click();
			}
			blueballyes(driver, intitem);
			answerstatusyes(driver, intitem);
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	
	public static void mtresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String response = localArray1[0][2];
			String responses[]=response.split(",");
			
			int count = responses.length;
			System.out.println("The number of responses is: "+count);
			
			for(int i=0;i<count;i++)
			{
				int j=i;
				j++;
				int var=j;
				System.out.println("Response "+var+": "+responses[i]);
				String responses1[]=responses[i].split("-");
                /*System.out.println("The response is:"+responses1[0]);
                System.out.println("The response is:"+responses1[1]);*/
              
               

                WebElement select = driver.findElement(By.xpath(".//*[@id='img_0_itemseq_P"+responses1[0]+"-R"+responses1[1]+"']"));
                if(select.isDisplayed())
                {
					select.click();
                }
                else
                {
                JavascriptExecutor js = (JavascriptExecutor) driver;
            	js.executeScript("javascript:window.scrollBy(0,8000)");
            	select.click();
                }
            	
					/*img_0_itemseq_p"+responses[i++]+"-r"+responses[i]+"'*/
					
			}
			
			blueballyes(driver,intitem);
			answerstatusyes(driver,intitem);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
	
	
	public static void erasemtresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String response = localArray1[0][2];
			String responses[]=response.split(",");
			
			int count = responses.length;
			System.out.println("The number of responses is: "+count);
			
			for(int i=0;i<count;i++)
			{
				int j=i;
				j++;
				int var=j;
				System.out.println("Response "+var+": "+responses[i]);
				String responses1[]=responses[i].split("-");
                /*System.out.println("The response is:"+responses1[0]);
                System.out.println("The response is:"+responses1[1]);*/
              
				WebElement erasebt=driver.findElement(By.xpath(".//*[@id='erase-btn']"));
				 if(erasebt.isDisplayed())
	                {
					  erasebt.click();
					  System.out.println("Erase button is selected and clicked");
	                }
            
				 
                Actions builder = new Actions(driver);
                WebElement select = driver.findElement(By.xpath(".//*[@id='img_0_itemseq_P"+responses1[0]+"-R"+responses1[1]+"']"));
				builder.moveToElement(select).click().perform();
               /* if(select.isDisplayed())
                {
					select.click();
                }
                else
                {
                JavascriptExecutor js = (JavascriptExecutor) driver;
            	js.executeScript("javascript:window.scrollBy(0,8000)");
            	select.click();
                }
            	
					/*img_0_itemseq_p"+responses[i++]+"-r"+responses[i]+"'*/
					
			}
			
			blueballyes(driver,intitem);
			answerstatusyes(driver,intitem);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}

	public static void eeeresponses(WebDriver driver, int introw, int intitem) throws Exception {
		try{
			
			String response = localArray1[0][2];
			String eeeresponse[] = response.split(",");
			Integer count = eeeresponse.length;
			Thread.sleep(3000);
			WebElement container = driver.findElement(By.xpath("//*[@id='Controls_Content_equation_container_0']"));
			List<WebElement> buttons = container.findElements(By.tagName("Button"));
			System.out.println("Response is:");

		for(int j=0;j<count;j++)
		{
			System.out.println(eeeresponse[j]);
			for(WebElement button:buttons)
		{
			String buttonname = button.getText();
			
			if(eeeresponse[j].equals(buttonname))
			{
				String buttonpath = button.getAttribute("id");
				WebElement buttonclick = driver.findElement(By.xpath("//*[@id='"+buttonpath+"']"));
				buttonclick.click();
				Thread.sleep(1000);
				break;
			}
		}
		}
		WebElement value = driver.findElement(By.xpath("//*[@id='dynamic_item_json_text_0']"));
			blueballyes(driver,intitem);
			answerstatusyes(driver,intitem);
			
			
		}
		catch (Exception e) {
			System.out.println(e);
			Thread.sleep(5000);
			driver.quit();
			}
		}
}


