package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
	static public WebDriver driver;
	public Logger logger;
	public Properties propfile;
	

	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String browser) throws IOException {
		
		
		//loading properties file
		FileReader file = new FileReader("C:\\Users\\Rohith\\eclipse-workspace\\FrameworkUprise\\src\\test\\resources\\config.properties");
		propfile = new Properties();
		propfile.load(file);
		
		
		
		
		
		
		//loading loggers
		
		logger = LogManager.getLogger(this.getClass());
		
		//launching browser based on conditions from xml file
		switch (browser.toLowerCase()) {
		case "chrome": driver = new ChromeDriver();
		break;
		case "edge": driver = new EdgeDriver();
		break;
		case "firefox" : driver = new FirefoxDriver();
		break;
		default: System.out.println("No matching browser");
		return;
		}
		
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(propfile.getProperty("url"));
	}
	
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String randomAlphabets= RandomStringUtils.randomAlphabetic(10);
		return randomAlphabets;
	}
	public String randomNumeric() {
		String randomNumeric= RandomStringUtils.randomNumeric(10);
		return randomNumeric;
	}
	public String alphaNumeric() {
		String str= RandomStringUtils.randomAlphabetic(3);
		String num= RandomStringUtils.randomNumeric(3);
	return (str+"@"+num);
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File SrcFile=  takesScreenshot.getScreenshotAs(OutputType.FILE);
		String TargetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File TargetFile = new File(TargetFilePath);
		
		SrcFile.renameTo(TargetFile);
		return TargetFilePath;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
