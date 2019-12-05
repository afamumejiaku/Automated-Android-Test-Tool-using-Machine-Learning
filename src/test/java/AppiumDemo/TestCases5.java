package AppiumDemo;

//package <set your test package>;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class TestCases5 {
	
	private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "Untitled";
	  protected AndroidDriver<AndroidElement> driver = null;

	  //"edu.texastech.enterprisemobile"
	  
	  DesiredCapabilities dc = new DesiredCapabilities();
	  
	   String packagename = driver.getCurrentPackage();
		
	   String activityname = driver.currentActivity();
	  
	  @BeforeEach
	  public void setUp() throws MalformedURLException {
	      dc.setCapability("reportDirectory", reportDirectory);
	      dc.setCapability("reportFormat", reportFormat);
	      dc.setCapability("testName", testName);
	      dc.setCapability(MobileCapabilityType.UDID, "52b5900b");
	      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, packagename);
	      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityname);
	      driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	      driver.setLogLevel(Level.INFO);
	  }

	  @Test
	  public void testUntitled() {
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='action_compose_send']")));
	      driver.findElement(By.xpath("//*[@id='action_compose_send']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Open Navigation Drawer']")).click();
	  }

	  @AfterEach
	  public void tearDown() {
	      driver.quit();
  
  }
}