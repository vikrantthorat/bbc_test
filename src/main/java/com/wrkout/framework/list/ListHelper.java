package com.wrkout.framework.list;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.wrkout.framework.helper.Generic.GenericHelper;
import com.wrkout.framework.helper.Logger.LoggerHelper;

public class ListHelper extends GenericHelper  {

	
	private static WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(ListHelper.class);

	public ListHelper(WebDriver driver) {
		super(driver);
		this.driver = driver;
		oLog.debug("ListHelper : " + this.driver.hashCode());
	}
	
	

	
	public  void locateRecordAndCLick(By List, String Text, By elementToClick) throws InterruptedException {
	
		

	//	System.out.println(Text +"  to match");
		List<WebElement> list = driver.findElements(List);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

			if (list.get(i).getText().contentEquals(Text)) {
		
				System.out.println("match");
		
				driver.findElement(elementToClick).click();
				
				
		//		Assert.assertEquals(Text, list.get(i).getText());

				break;

			}

		}
	}
	
	
	public static void goToDetailProspectScreen(String Name, By tableXpath ) {

		boolean ismatchfound = false;

		List<WebElement> list = driver.findElements(tableXpath);

		for (int i = 0; i < list.size(); i++)

		{

			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains(Name)) {

				driver.findElement(
						By.xpath("//td[contains(text()," + "'" + Name + "'" + ")]/following::i[position()=4]")).click();

			}
		}
	}

	public static void goToMOVRDetailScreen(String Name, By tableXpath ) {

		boolean ismatchfound = false;

		List<WebElement> list = driver.findElements(tableXpath);

		for (int i = 0; i < list.size(); i++)

		{

			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains(Name)) {

				driver.findElement(
						By.xpath("//p[contains(text()," + "'" + Name + "'" + ")]/following::i[position()=3]")).click();

			}
		}
	}
	
	
	
	
	
	public void clickByAction( By Xpath) {

		WebElement element = driver.findElement(Xpath);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);

	}

	
	

}
