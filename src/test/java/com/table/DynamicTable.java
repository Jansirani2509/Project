package com.table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.baseclass.BaseClass;

public class DynamicTable extends BaseClass{
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		enterApplnUrl("https://practice.expandtesting.com/dynamic-table");
		maximizeWindow();
		implicitWait(10);
		
		 List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr"));
		 System.out.println("Number of rows:"+rows.size());
		 for(int r=1;r<=rows.size();r++) {
			 WebElement name = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[r]//td[1]"));
			 if(name.getText().equals("Chrome")) {
				 
				String cpuLoad= driver.findElement(By.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
				 String value = driver.findElement(By.xpath("//p{@id='chrome-cpu']")).getText();
				 
				 if(cpuLoad.equals(value)) {
					 System.out.println("Cpu load of chrome is equal");
				 }
				 else {
					 
					 System.out.println("Cpu load of chrome is not  equal");
					 
				 }
				 break;
			 }
			 
			 
		 }
		
	}

}
