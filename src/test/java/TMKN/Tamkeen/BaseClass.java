package TMKN.Tamkeen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	public XSSFWorkbook wbook;
	public XSSFSheet sheet;
	public WebDriver driver ;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	@DataProvider
	public void DataSetup() throws IOException  {
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		report = new ExtentReports("ExtentReport.html");
		
	}
	
	@AfterTest
	public void Dataclean() throws IOException {
		wbook.close();
		report.flush();
		report.close();
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		test = report.startTest(method.getName());
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.simplilearn.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
	}
	@AfterMethod
	public void tearDown() {
		report.endTest(test);
		driver.close();
		 
	}

}
