package com.CRM.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.CRM.util.WebEventListener;

public class basetest {
	
	public static WebDriver driver;
	public static Properties properties;
	static EventFiringWebDriver e_driver;
	static WebEventListener eventlistener;
	public basetest(){
		FileInputStream fis;
		try {
			fis = new FileInputStream("E:\\selenium_projects\\FreeCRMTest\\src\\main\\java\\com\\CRM\\config\\config.properties");
			properties=new Properties();
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialization(){
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\selenium_projects\\chromedriver_win32\\chromedriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("test-type");
			//capabilities.setCapability("chrome.binary", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver();
		}
		if(properties.getProperty("browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\selenium_projects\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		if(properties.getProperty("browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "E:\\selenium_projects\\MicrosoftWebDriver.exe");
			driver=new InternetExplorerDriver();
		}
		
		//System.setProperty("webdriver.gecko.driver", "C:\\eclipse\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		//driver=new FirefoxDriver();
		e_driver=new EventFiringWebDriver(driver);
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
	}
	
	public static void takesscreenshotTest() throws IOException{
		String currentdir=System.getProperty("user.dir");
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(currentdir+"/Screenshot/"+System.currentTimeMillis()+".png"));
	}
}
