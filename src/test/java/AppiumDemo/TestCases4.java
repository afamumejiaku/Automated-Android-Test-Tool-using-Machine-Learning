package AppiumDemo;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
//import io.appium.java_client.SwipeElementDirection;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class TestCases4 {
	
	 private String reportDirectory = "reports";
	  private String reportFormat = "xml";
	  private String testName = "Untitled";
	  protected AndroidDriver<AndroidElement> driver = null;

	  DesiredCapabilities dc = new DesiredCapabilities();
	  
	   String packagename = driver.getCurrentPackage();
		
	   String activityname = driver.currentActivity();
	   
	   // "com.microsoft.office.outlook"
	  
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
	      driver.findElement(By.xpath("//*[@id='me_launcher_container']")).click();
	      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='interests_panel_profile_info_container']")));
	      driver.findElement(By.xpath("//*[@id='interests_panel_profile_info_container']")).click();
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='My Network']")));
	      driver.findElement(By.xpath("//*[@text='My Network']")).click();
	      driver.findElement(By.xpath("//*[@id='mynetwork_cohorts_recycler_view']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Close']")).click();
	      driver.findElement(By.xpath("//*[@id='slim_notification_badge_icon' and ./parent::*[@id='tab_notifications']]")).click();
	      driver.findElement(By.xpath("//*[@text='Earlier']")).click();
	      driver.findElement(By.xpath("//*[@text='Earlier']")).click();
	      driver.findElement(By.xpath("//*[@id='slim_notification_badge_indeterminate_image']")).click();
	      driver.findElement(By.xpath("//*[@text='Search']")).sendKeys("Viola Patraaaa meh");
	      new WebDriverWait(driver, 60).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageButton']")));
	      driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
	      driver.findElement(By.xpath("//*[@id='search_qr_code_button']")).click();
	      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ENABLE CAMERA ACCESS']")));
	      driver.findElement(By.xpath("//*[@text='ENABLE CAMERA ACCESS']")).click();
	      driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
	      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.ImageButton']")));
	      driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
	      driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[@id='buddy_item']]")).click();
	      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='chat_item']")));
	      driver.findElement(By.xpath("//*[@id='chat_item']")).click();
	      driver.findElement(By.xpath("//*[@text='Connect']")).click();
	      driver.findElement(By.xpath("//*[@text='FILE TRANSFER']")).click();
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='More options']")));
	      driver.findElement(By.xpath("//*[@contentDescription='More options']")).click();
	      driver.findElement(By.xpath("//*[@text='Settings']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Navigate up']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='More options']")).click();
	      driver.findElement(By.xpath("//*[@text='Help']")).click();
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Continue']")));
	      driver.findElement(By.xpath("//*[@text='Continue']")).click();
	      driver.findElement(By.xpath("//*[@id='mainEnterID']")).click();
	      driver.findElement(By.xpath("//*[@id='mainEnterID']")).click();
	      driver.findElement(By.xpath("//*[@id='window_layout']")).click();
	      driver.findElement(By.xpath("//*[@id='mainEnterID']")).sendKeys("RR");
	      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@id='outgoingConnectionContainer']]")));
	      driver.findElement(By.xpath("//*[@class='android.widget.LinearLayout' and ./*[@id='outgoingConnectionContainer']]")).click();
	      driver.findElement(By.xpath("//*[@id='input_layout_back']")).click();
	      driver.findElement(By.xpath("//*[@id='input_layout_back']")).click();
	      driver.findElement(By.xpath("//*[@id='input_layout_back']")).click();
	      driver.findElement(By.xpath("//*[@id='input_layout_back']")).click();
	      driver.findElement(By.xpath("//*[@id='input_layout_back']")).click();
	      driver.findElement(By.xpath("//*[@id='keyboard']")).click();
	      driver.findElement(By.xpath("//*[@id='keyboard']")).click();
	      driver.findElement(By.xpath("//*[@class='android.view.View' and ./parent::*[@id='Keyboard']]")).click();
	      driver.findElement(By.xpath("//*[@text='REMOTE CONTROL']")).click();
	      driver.findElement(By.xpath("//*[@id='outgoingConnectionContainer']")).click();
	      driver.findElement(By.xpath("//*[@id='clearIdIcon']")).click();
	      driver.findElement(By.xpath("//*[@text='OPEN QUICKSUPPORT']")).click();
	      driver.findElement(By.xpath("//*[@id='task_completed' and ./parent::*[@contentDescription='SVV project report']]")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Switch task lists or account']")).click();
	      driver.findElement(By.xpath("//*[@id='og_botom_drawer_scrim']")).click();
	      driver.findElement(By.xpath("//*[@id='action_more_options']")).click();
	      driver.findElement(By.xpath("//*[@id='touch_outside']")).click();
	      driver.findElement(By.xpath("//*[@id='fab']")).sendKeys("SVV Project Report");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='add_task_change_details']")));
	      driver.findElement(By.xpath("//*[@id='add_task_change_details']")).sendKeys("Merge everyones part");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='add_task_pick_due_date']")));
	      driver.findElement(By.xpath("//*[@id='add_task_pick_due_date']")).click();
	      driver.findElement(By.xpath("//*[@text='5']")).click();
	      driver.findElement(By.xpath("//*[@text='Done']")).click();
	      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Save']")));
	      driver.findElement(By.xpath("//*[@text='Save']")).click();
	      /*
	      driver.swipe(946, 1303, 1276, 146, 294);
	      driver.swipe(923, 1292, 880, 919, 242);
	      driver.swipe(876, 1173, 900, 742, 217);
	      driver.swipe(903, 757, 876, 1161, 137);
	      driver.swipe(876, 826, 888, 1361, 194);
	      driver.swipe(850, 892, 842, 1553, 233);
	      driver.swipe(819, 769, 850, 1265, 395);
	      */
	      driver.findElement(By.xpath("//*[@id='task_completed' and ./parent::*[@contentDescription='SVV Project Report, Due date Tomorrow']]")).click();
	      driver.findElement(By.xpath("//*[@text='Undo']")).click();
	      driver.findElement(By.xpath("//*[@class='android.widget.ImageButton']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Open Navigation Drawer']")).click();
	      //driver.swipe(100, 200, 142, 750, 625);
	      //driver.swipe(861, 169, 438, 246, 264);
	      driver.findElement(By.xpath("//*[@id='toolbar']")).click();
	      driver.findElement(By.xpath("//*[@id='tabbar_messages_switch']")).click();
	      driver.findElement(By.xpath("//*[@id='tabbar_messages_switch']")).click();
	      driver.findElement(By.xpath("//*[@text='Theobald, Alex']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Close']")).click();
	      driver.findElement(By.xpath("//*[@text='Filters']")).click();
	      driver.findElement(By.xpath("//*[@id='radio' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Unread']]]")).click();
	      driver.findElement(By.xpath("//*[@id='tabbar_messages_cancel_filter']")).click();
	      driver.findElement(By.xpath("//*[@text='Filters']")).click();
	      driver.findElement(By.xpath("//*[@id='radio' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Flagged']]]")).click();
	      driver.findElement(By.xpath("//*[@id='tabbar_messages_cancel_filter']")).click();
	      driver.findElement(By.xpath("//*[@text='Filters']")).click();
	      driver.findElement(By.xpath("//*[@id='radio' and (./preceding-sibling::* | ./following-sibling::*)[./*[@text='Attachments']]]")).click();
	      driver.findElement(By.xpath("//*[@id='tabbar_messages_cancel_filter']")).click();
	      driver.findElement(By.xpath("//*[@id='action_search']")).click();
	      driver.findElement(By.xpath("//*[@id='action_calendar']")).click();
	      driver.findElement(By.xpath("//*[@id='action_search']")).click();
	      driver.findElement(By.xpath("//*[@text='Search']")).sendKeys("mert sid");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Search']")));
	      driver.findElement(By.xpath("//*[@text='Search']")).click();
	      driver.findElement(By.xpath("//*[@id='new_search_action_bar']")).click();
	      driver.findElement(By.xpath("//*[@id='recycler_view']")).click();
	      driver.findElement(By.xpath("//*[@id='new_search_action_bar']")).click();
	      driver.findElement(By.xpath("//*[@id='recycler_view']")).click();
	      driver.findElement(By.xpath("//*[@id='action_mail']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_fab']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_to_field']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_to_field']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_to_field']")).sendKeys("anu");
	      new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Anubhav.Tiwari@ttu.edu']")));
	      driver.findElement(By.xpath("//*[@text='Anubhav.Tiwari@ttu.edu']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_subject_field']")).sendKeys("Test mail");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ms-outlook-mobile-rooster-writer']")));
	      driver.findElement(By.xpath("//*[@id='ms-outlook-mobile-rooster-writer']")).sendKeys("This is a test mail");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='action_compose_send']")));
	      driver.findElement(By.xpath("//*[@id='action_compose_send']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Open Navigation Drawer']")).click();
	      driver.findElement(By.xpath("//*[@text='Sent']")).click();
	      driver.findElement(By.xpath("//*[@text='This is a test mail Get Outlook for Android']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Close']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Open Navigation Drawer']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Ejiade, Ayodeji, 14:43, has attachment, python, This message has no content.']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_fab']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_to_field']")).sendKeys("dhruvmehta@gail.com");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='SEARCH DIRECTORY']")));
	      driver.findElement(By.xpath("//*[@text='SEARCH DIRECTORY']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_to_field']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_to_field']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_subject_field']")).click();
	      driver.findElement(By.xpath("//*[@id='compose_subject_field']")).sendKeys("Test Mail");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='ms-outlook-mobile-rooster-writer']")));
	      driver.findElement(By.xpath("//*[@id='ms-outlook-mobile-rooster-writer']")).sendKeys("This is a test mail");
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='action_compose_send']")));
	      driver.findElement(By.xpath("//*[@id='action_compose_send']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Open Navigation Drawer']")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Theobald, Alex, 14:55, has attachment, Interested for the study, 36 messages in conversation, I could meet at 3:30pm on Wednesday. Does that work? Get Outlook for iOS From: Mehta, Dhruv C <Dhruv.C.Mehta@ttu.edu> Sent: Wednesday, December 4, 2019 2:22:09 PM To: Theobald, Alex <Alex.Theobald@ttu.edu> Subject:']")).click();
	      driver.findElement(By.xpath("//*[@text=concat('Your message to dhruvmehta@gail.com couldn', \"'\", 't be delivered. Security or policy settings at gail.com have rejected your message. Dhruv.C.Mehta Office 365 gail.com Sender Action Required Security or policy violation How to Fix It The')]")).click();
	      driver.findElement(By.xpath("//*[@contentDescription='Close']")).click();
	  }

	  @AfterEach
	  public void tearDown() {
	      driver.quit();
	  }

}
