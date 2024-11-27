package com.dropdown;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.baseclass.BaseClass;

public class DynamicDropDown extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		enterApplnUrl("https://www.makemytrip.com");
		maximizeWindow();
		implicitWait(10);
		
		String OptionToSelect = "Benin City";
		int count=0;
		driver.findElement(By.id("fromcity")).sendKeys("ben");
		List<WebElement> optionList = driver.findElements(By.xpath("//u1[@class='react-autosuggest_suggestions-list']//li"));
		Thread.sleep(30000);
		for (WebElement ele : optionList) {
			
			String currentOption=ele.getText();
			if(currentOption.contains(OptionToSelect)) {
				ele.click();
				break;
			}
		}
		
		
		
	}

}
