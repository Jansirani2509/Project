package com.amazon.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;

public class BaseClass {
	
	public static	 WebDriver driver;
	Select select;
	
//1.
	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}
//2.
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}
//3.
	public void promptAlert(String data) {
		driver.switchTo().alert().sendKeys(data);
	}
//4.
	public List<String> getAllOptionsText(WebElement element) {
		List<String> lstText = new ArrayList<>();
		select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (WebElement webElement : options) {
			String text = webElement.getText();
			lstText.add(text);

		}
		return lstText;
	}
//5.
	public void switchToChildWindow() {
		String pWindow = driver.getWindowHandle();
		Set<String> allWindowsId = driver.getWindowHandles();

		for (String eachWindowId : allWindowsId) {
			if (!pWindow.equals(eachWindowId)) {
				driver.switchTo().window(eachWindowId);
			}
		}
	}
//6.

	public  String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;
	}
//7.
	public void screenshot(WebElement element, String sName) throws IOException {
		File s = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File(getProjectPath() + "\\images\\" + sName + ".png"));
	}
//8.
	public void screenshot(String sName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File s = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(s, new File(getProjectPath() + "\\images\\" + sName + ".png"));
	}
//9.
	public void elementClear(WebElement element) {
		elementVisibility(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.clear();
		}

	}
//10.
	public  void elementVisibility(WebElement element) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		driverWait.until(ExpectedConditions.visibilityOf(element));

	}
//11.
	public static void implicitWait(int secs) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
	}

	public  static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
//12.
	public static  void chromebrowserLaunch() {
		driver = new ChromeDriver();
	}
	public static  void firefoxbrowserLaunch() {
		driver = new FirefoxDriver();
	}
	public static  void edgebrowserLaunch() {
		driver = new EdgeDriver();
	}
//13.
	public  static void enterApplnUrl(String url) {
		driver.get(url);

	}
//14.
	public  static void maximizeWindow() {
		driver.manage().window().maximize();
	}
//15.
	public  void elementSendKeys(WebElement element, String data) {
		elementVisibility(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data);
		}
	}
//16.
	public void elementSendKeysJs(WebElement element, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + data + "')", element);
	}
//17.
	public  void elementClick(WebElement element) {
		elementVisibility(element);
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.click();
		}
	}
//18.
	public  String getApplnTitle() {
		String title = driver.getTitle();
		return title;
	}
//19.
	public  WebElement findLocatorById(String attributeValue) {
		WebElement findElement = driver.findElement(By.id(attributeValue));
		return findElement;
	}
//20.
	public WebElement findLocatorByName(String attributeValue) {
		WebElement findElement = driver.findElement(By.name(attributeValue));
		return findElement;
	}
//21.
	public WebElement findLocatorByClassName(String attributeValue) {
		WebElement findElement = driver.findElement(By.className(attributeValue));
		return findElement;
	}
//22.
	public  WebElement findLocatorByXpath(String attributeValue) {
		WebElement findElement = driver.findElement(By.xpath(attributeValue));
		return findElement;
	}
//23.
	public String getAppnUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
//24.
	public static void closeWindow() {
		driver.close();
	}
//25.
	public void quitWindow() {
		driver.quit();
	}
//26.
	public  boolean elementIsEnabled(WebElement element) {
		elementVisibility(element);
		boolean enabled = element.isEnabled();
		return enabled;
	}
//27.
	public  boolean elementIsDisplayed(WebElement element) {
		elementVisibility(element);
		boolean displayed = element.isDisplayed();
		return displayed;
	}
//28.
	public boolean elementIsSelected(WebElement element) {
		elementVisibility(element);
		boolean selected = element.isSelected();
		return selected;
	}
//29.
	public   String elementGetText(WebElement element) {
		elementVisibility(element);
		String text = element.getText();
		return text;
	}

//30.		// 99%--->value fixed
	public String elementGetAttributeValue(WebElement element) {
		elementVisibility(element);
		String attribute = null;
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			attribute = element.getAttribute("value");
		}
		return attribute;

	}

	// 1%--->value is NOT fixed
	public String elementGetAttributeValue(WebElement element, String attributeName) {
		elementVisibility(element);
		String attribute = null;
		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			attribute = element.getAttribute(attributeName);
		}
		return attribute;
	}
//31.
	public void selectOptionByText(WebElement element, String text) {

		elementVisibility(element);
		select = new Select(element);
		select.selectByVisibleText(text);
	}
//32.
	public void selectOptionByValue(WebElement element, String text) {
		elementVisibility(element);
		select = new Select(element);
		select.selectByValue(text);
	}
//33.
	public void selectOptionByIndex(WebElement element, int index) {
		elementVisibility(element);
		select = new Select(element);
		select.selectByIndex(index);
	}
//34.		
	public void pressEnter( ) throws AWTException {
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
//35.		
	public  String getCellData(String sheetName,int rownum,int cellnum) throws IOException {
		String res = null;
		File file = new File(getProjectPath()+"\\Excel\\TestData.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet   sheet     = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		CellType type = cell.getCellType();
		
		switch (type) {
		
		case STRING:
			res = cell.getStringCellValue();
			
			break;
			
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell))  {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
				res = dateFormat.format(dateCellValue);
			}else {
				double numericCellValue = cell.getNumericCellValue();
				long round = Math.round(numericCellValue);
				if (numericCellValue == round) {
					res = String.valueOf(round);
				}else {
					res = String.valueOf(numericCellValue);
				}
				}
			break;
			
			default:
				
				break;
		}
		return res;
	}				

//36.
	public void updateCellData(String sheetName,int rownum,int cellnum,String oldData,String newData) throws IOException {
		File file = new File(getProjectPath()+"\\Excel\\TestData.xlsx");
		FileInputStream fileInputStream= new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet   sheet     = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value= cell.getStringCellValue();
		if(value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileoutputStream = new FileOutputStream(file);
		workbook.write(fileoutputStream);
		}
	
//37.
	
 public void createCellAndSetCellData(String sheetName,int rownum,int cellnum,String data) throws IOException {
File file = new File(getProjectPath()+"\\Excel\\TestData.xlsx");
FileInputStream fileInputStream= new FileInputStream(file);
Workbook workbook = new XSSFWorkbook(fileInputStream);
Sheet   sheet     = workbook.getSheet(sheetName);
Row row = sheet.getRow(rownum);
Cell cell = row.getCell(cellnum);
String value= cell.getStringCellValue();
FileOutputStream fileoutputStream = new FileOutputStream(file);
workbook.write(fileoutputStream);
}
 
//38.
 public void mousehoverAction(WebElement element) {
	 Actions action = new Actions(driver);
	 action.moveToElement(element).perform();
 }
 //39.
 public void elementSendKeysEnter(WebElement element, String data) {
		elementVisibility(element);

		if (elementIsDisplayed(element) && elementIsEnabled(element)) {
			element.sendKeys(data,Keys.ENTER);
		}
 }
 //40.
 public void elementClickjs(WebElement element) {
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	 executor.executeScript("arguments[0].click()", element);
 }
 
 public void pressPageDown( ) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		
		
 }	
 
 public void switchToFramebyname(String names) {
	 driver.switchTo().frame(names);
	
 }
 
 public void switchToDefaultContent() {
	 driver.switchTo().defaultContent();
 }
 
 public String getPropertyFileValue(String key) throws FileNotFoundException, IOException  {
	 Properties properties = new Properties();
	 properties.load(new FileInputStream(getProjectPath()+"\\config\\config.properties"));
	 Object object = properties.get(key);
	 String value = (String)object;
	 return value;
	 	 
 }
 
 public static void browserLaunch(String browserType) {
	 switch (browserType) {
	 
	case "CHROME":
		driver = new ChromeDriver();
		break;
	case "IE":
		driver = new InternetExplorerDriver();
		break;
	case "FIREFOX":
		driver = new FirefoxDriver();
		break;
	case "EDGE":
		driver=new EdgeDriver();
		break;
		default:
			break;
	 }
	}
 
public byte[] takeScreenshot() {
	TakesScreenshot ts = (TakesScreenshot)driver;
	byte[] bs = ts.getScreenshotAs(OutputType.BYTES);
	return bs;
}
public void deleteCookies() {
	driver.manage().deleteAllCookies();

}


}



