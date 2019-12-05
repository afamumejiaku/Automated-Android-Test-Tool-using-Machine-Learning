package AppiumDemo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.InputSource;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.MalformedURLException;
import java.util.List;
import java.util.logging.Level;

public class MyFirstAppiumTest {
	
	    private String reportDirectory = "reports";
	    private String reportFormat = "xml";
	    private String testName = "Untitled";
	    	
	    AndroidDriver<AndroidElement> driver = null;

	    DesiredCapabilities dc = DesiredCapabilities.android();

	    
	    @BeforeEach
	    public void setUp() throws MalformedURLException {
	        dc.setCapability("reportDirectory", reportDirectory);
	        dc.setCapability("reportFormat", reportFormat);
	        dc.setCapability("testName", testName);
	        dc.setCapability(MobileCapabilityType.UDID, "52b5900b");
	        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.linkedin.android");
	        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".authenticator.LaunchActivity");
	        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	        driver.setLogLevel(Level.INFO);
	    }	    



	    
	    @Test
	    public void testUntitled() {
	    	driver.findElement(By.xpath("//*[@id='growth_login_join_fragment_email_address']")).sendKeys("dhruvsm1322@gmail.com");
	        driver.findElement(By.xpath("//*[@id='growth_login_join_fragment_password']")).sendKeys("abcd1234");
	        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='SIGN IN']")));
	        driver.findElement(By.xpath("//*[@text='SIGN IN']")).click();
	        driver.findElement(By.xpath("//*[@text='OKAY']")).click();
	        driver.executeScript("seetest:client.deviceAction(\"BKSP\")");
	        driver.findElement(By.xpath("//*[@id='growth_login_join_fragment_password']")).sendKeys("draco_2213");
	        driver.findElement(By.xpath("//*[@text='SIGN IN']")).click();
	    }

	    @AfterEach
	    public void tearDown() {
	        driver.quit();
	    }

	}
