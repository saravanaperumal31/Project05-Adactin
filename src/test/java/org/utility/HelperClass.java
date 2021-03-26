package org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
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
import org.openqa.selenium.support.ui.Select;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	static DataTable dataTable;
	public static WebDriver driver;

	public static WebDriver browserLaunch() {
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		return driver;
	}

	public static WebDriver browserChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static void urlLaunch(String url) {
		driver.get(url);
	}

	public static String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static String urlTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static void closeWindow() {
		driver.close();
	}

	public static void quitwindow() {
		driver.quit();
	}

	public static void filltext(WebElement e, String value) {
		e.sendKeys(value);
	}

	public static void buttonClick(WebElement e) {
		e.click();
	}

	public static String getAttribute(WebElement e) {
		String atvalue = e.getAttribute("value");
		System.out.println(atvalue);
		return atvalue;
	}

	public static String getText(WebElement e) {
		String attext = e.getText();
		return attext;
	}

	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public static void dragAndDrop(WebElement src, WebElement des) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, des);
	}

	public static void rightClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	public static void clickAndHoldRelease(WebElement e, WebElement e1) {
		Actions a = new Actions(driver);
		a.clickAndHold(e).release(e1);
	}

	public static String simpleAlert() {
		Alert sa = driver.switchTo().alert();
		String text = sa.getText();
		System.out.println(text);
		sa.accept();
		return text;
	}

	public static String confirmAlert() {
		Alert ca = driver.switchTo().alert();
		String text = ca.getText();
		System.out.println(text);
		ca.accept();
		return text;
	}

	public static String promptAlert() {
		Alert pa = driver.switchTo().alert();
		String text = pa.getText();
		pa.accept();
		return text;
	}

	public static void swFrameBynameid(String i) {
		driver.switchTo().frame(i);
	}

	public static void swFrameByInd(int i) {
		driver.switchTo().frame(i);
	}

	public static void swFrameByWbEmnt(WebElement i) {
		driver.switchTo().frame(i);
	}

	public static void swToMainFrameWindow() {
		driver.switchTo().defaultContent();
	}

	public static void swToParentWindow() {
		driver.switchTo().parentFrame();
	}

	public static void jsExecutorSetAttribute(String input, WebElement e) {
		JavascriptExecutor a = (JavascriptExecutor) driver;
		a.executeScript("arguments[0].setAttribute('value','" + input + "')", e);
	}

	public static String jsExecutorGetAttribute(WebElement e) {
		JavascriptExecutor a = (JavascriptExecutor) driver;
		Object obj = a.executeScript("return.arguments[0].getAttribute('value')", e);
		String text = (String) obj;
		return text;
	}

	public static void jsExecutorClick(WebElement e) {
		JavascriptExecutor a = (JavascriptExecutor) driver;
		a.executeScript("arguments[0].click()", e);
	}

	public static void jsExecutorScldown(WebElement e) {
		JavascriptExecutor a = (JavascriptExecutor) driver;
		a.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public static void jsExecutorSclup(WebElement e) {
		JavascriptExecutor a = (JavascriptExecutor) driver;
		a.executeScript("arguments[0].scrollIntoView(false)", e);
	}

	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	public static void selectByVisibleText(WebElement e, String a) {
		Select s = new Select(e);
		s.selectByVisibleText(a);
	}

	public static void selectByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.selectByValue(value);
	}

	public static String getFirstSelected(WebElement e) {
		Select s = new Select(e);
		WebElement firstSelect = s.getFirstSelectedOption();
		String text = firstSelect.getText();
		return text;
	}

	public static void deselectindex(WebElement e, int index) {
		Select s = new Select(e);
		s.deselectByIndex(index);
	}

	public static void deselectvalue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);
	}

	public static void deselectVisibleTxt(WebElement e, String text) {
		Select s = new Select(e);
		s.deselectByVisibleText(text);
	}

	public static void deSelectAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}

	public static void screenShot(String filename) {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\New folder\\Maven\\src\\test\\resources\\ScreenShot\\" + filename + ".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	public static void navigateTo(String s) {
		driver.navigate().to(s);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void implicitWait(int s) {
		driver.manage().timeouts().implicitlyWait(s, TimeUnit.SECONDS);
	}

	public static String currentWindowId() {
		String currentWindow = driver.getWindowHandle();
		return currentWindow;
	}

	public static void scrolldown(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public static Set<String> allWindowId() {
		Set<String> allWindowId = driver.getWindowHandles();
		return allWindowId;
	}

	public static void switchToWindowId() {
		String currentWindow = driver.getWindowHandle();
		Set<String> parentId = driver.getWindowHandles();
		for (String each : parentId) {
			if (!currentWindow.equals(each)) {
				driver.switchTo().window(each);
			}

		}
	}

	public static String getExcelData(int rowno, int cellno) throws IOException {
		File path = new File("D:\\New folder\\JUnit\\src\\test\\resources\\Excel\\Details.xlsx");

		FileInputStream ip = new FileInputStream(path);

		Workbook w = new XSSFWorkbook(ip);
		Sheet sheet = w.getSheet("UserPass");
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);

		int cellType = cell.getCellType();

		String value = null;
		{
			if (cellType == 1) {
				value = cell.getStringCellValue();
			} else {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
					value = s.format(dateCellValue);
				} else {
					double db = cell.getNumericCellValue();
					long lg = (long) db;
					value = String.valueOf(lg);

				}
			}
			return value;
		}
	}

	public static void asMapString(int index) {
		List<Map<String, String>> emp = dataTable.asMaps();
		Map<String, String> m = emp.get(index);

	}

	public static void clear(WebElement e) {
		e.clear();
	}

	public static void submit(WebElement e, String a) {
		e.sendKeys(a, Keys.ENTER);
	}

}
