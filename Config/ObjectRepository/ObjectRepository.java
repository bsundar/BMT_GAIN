//All Xpath of BMT application fields should be Maintained below Object Repository
package ObjectRepository;

import org.openqa.selenium.By;

public class ObjectRepository {
	
	public static By userName = By.xpath("//input[@id='idField']");
	public static By password = By.xpath("//input[@id='idPword']");
	public static By accesscode = By.xpath("//input[@id='idaccess']");
	public static By loginButton = By.xpath("//button[@type='button']");

}
