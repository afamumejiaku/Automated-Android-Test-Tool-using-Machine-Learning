package AppiumDemo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.InputSource;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class FeatureExtraction2 {
	
	    /*private String reportDirectory = "reports";
	    private String reportFormat = "xml";
	    private String testName = "Untitled";*/
	    
	    public static void main(String []args) throws Exception{
	    	
	    AndroidDriver<AndroidElement> driver = null;
	    
	    AndroidDriver<AndroidElement> driver1 = null;
	    int TopScrollable = 0;
	    
	    int MiddleScrollable = 0;
	     
	    int BottomScrollable = 0;
	    
	    int TopClickable = 0;
	    
	    int MiddleClickable = 0;
	    
	    int BottomClickable = 0;
	    
	    int TopLongClickable = 0;
	    
	    int TopTextOrPw = 0;
	    
	    int MiddleTextOrPw = 0;
	    
	    int BottomTextOrPw = 0;
	    
	    int GeneralElements = 0;
	    
	    String ScrollableAttr ;
	    
	    String ClickableAttr;
	    
	    String LongClickableAttr;
	    
	    String TextAttr1;
	    
	    String TextAttr2;
	    
	    Boolean GeneralElementAttr1;
	    
	    Boolean GeneralElementAttr2;
	    
	    boolean Scrollable = false ;
	    
	    boolean Clickable = false;
	    
	    boolean LongClickable = false;
	    
	    boolean Text = false;
	    
	    boolean GeneralElement = false;
	    
	    boolean NavigationBar = false;
	    
	    int NavigationValue = 0;
	    
	    String packagename = null;
	    
	    String activityname = null;
	    
	    String s = null;
	    
	    int prevlength = 0;
	    
	    int currentlength = 0;

	    DesiredCapabilities dc = DesiredCapabilities.android();
	    
	    DesiredCapabilities dc1 = DesiredCapabilities.android();
	    
	    dc1.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	    dc1.setCapability(MobileCapabilityType.UDID, "52b5900b");
	    dc1.setCapability(MobileCapabilityType.NO_RESET,false);
	    
        driver1 = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc1);
        
        packagename = driver1.getCurrentPackage();
        		
        activityname = driver1.currentActivity();
        
        //driver1.close();
	    
	    dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	    dc.setCapability(MobileCapabilityType.UDID, "52b5900b");
	    dc.setCapability(MobileCapabilityType.NO_RESET,false);
	    dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, packagename);
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, activityname);
        
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
	    
	    //driver.resetApp();
	    
	    List<AndroidElement> PgSrc = driver.findElementsByXPath(".//*");
	    
	    org.openqa.selenium.Dimension ScreenDimension = driver.manage().window().getSize();
	    
	    //driver.manage().window().maximize();
	    
	    int ScreenHeight = ScreenDimension.getHeight();
	    
	    int topsize = (int) Math.round(ScreenHeight * 0.20);
	    
	    int middlesize = (int) Math.round((ScreenHeight - topsize) * 0.60) ;
	    
	    int bottomsize = (int) Math.round((ScreenHeight - topsize - middlesize) * 0.20);
	    
	    System.out.println(ScreenHeight);
	    System.out.println(topsize);
	    System.out.println(middlesize);
	    System.out.println(bottomsize);
	    
	    
	    try (PrintWriter writer = new PrintWriter(new File("test.csv"))) {

	        StringBuilder sb = new StringBuilder();
	        sb.append("TagName");
	        sb.append(',');
	        sb.append("Checkable");
	        sb.append(',');
	        sb.append("Hidden");
	        sb.append(',');
	        sb.append("Clickable");
	        sb.append(',');
	        sb.append("Long Clickable");
	        sb.append(',');
	        sb.append("Text Field");
	        sb.append(',');
	        sb.append("Password");
	        sb.append(',');
	        sb.append("Scrollable");
	        sb.append(',');
	        sb.append("OnScreen");
	        sb.append(',');
	        sb.append("X-Position");  
	        sb.append(',');
	        sb.append("Y-Position");
	        sb.append(',');
	        sb.append("Width");
	        sb.append(',');
	        sb.append("Height");
	        sb.append('\n');

	        for (int i = 0; i < PgSrc.size();i++) {
	        	//System.out.print(i);
	  		  String tagName = PgSrc.get(i).getTagName();
	  		  String pckg = PgSrc.get(i).getAttribute("package");
	  		  
	  		if((tagName.contains("android.widget.FrameLayout")||tagName.contains("android.widget.ImageView")||tagName.contains("android.widget.ImageButton")) && ((PgSrc.get(i).getAttribute("clickable")).equals("true")) || ((PgSrc.get(i).getAttribute("long-clickable")).equals("false")) || ((PgSrc.get(i).getAttribute("longClickable")).equals("false"))|| ((PgSrc.get(i).getAttribute("longClickable")).equals("false")))
	  		{
	  			NavigationBar = true;
	  		}
	  		else
	  		{
	  			NavigationBar = false;
	  		}
	  		if (tagName.contains("android.widget.FrameLayout")|| tagName.contains("android.widget.LinearLayout")||(pckg.contains("systemui") == true))
	  		{
	  			continue;
	  		}
	  		else
	  		{
	  		sb.append(tagName);
	  		sb.append(',');
	  		sb.append(PgSrc.get(i).getAttribute("checkable"));
	  		sb.append(',');
	  		sb.append(PgSrc.get(i).getAttribute("hidden"));
	  		sb.append(',');
	  		sb.append(PgSrc.get(i).getAttribute("clickable"));
	  		sb.append(',');
	  		sb.append(PgSrc.get(i).getAttribute("long-clickable"));
	  		sb.append(',');
	  		sb.append(PgSrc.get(i).getAttribute("longClickable"));
	  		sb.append(',');
	  		sb.append(PgSrc.get(i).getAttribute("password"));
	  		sb.append(',');
	        sb.append(PgSrc.get(i).getAttribute("scrollable"));
	        sb.append(',');
	        sb.append(PgSrc.get(i).getAttribute("OnScreen"));
	        sb.append(',');
	        sb.append(PgSrc.get(i).getAttribute("x"));
	        sb.append(',');
	        sb.append(PgSrc.get(i).getAttribute("y"));
	        sb.append(',');
	        sb.append(PgSrc.get(i).getAttribute("width"));
	        sb.append(',');
	        sb.append(PgSrc.get(i).getAttribute("height"));
	        sb.append('\n');
	       
	        /*
	        System.out.println(PgSrc.get(i).getAttribute("scrollable"));
	        System.out.println(PgSrc.get(i).getAttribute("clickable"));
	        System.out.println(PgSrc.get(i).getAttribute("long-clickable"));
	        System.out.println(PgSrc.get(i).getAttribute("longClickable"));
	        System.out.println(PgSrc.get(i).getAttribute("password"));*/
	        
	        
	        ScrollableAttr = (String) PgSrc.get(i).getAttribute("scrollable");
	        if (ScrollableAttr.equals("true") == true)
	        {
	        	Scrollable = true;
	        }
	        else {
	        	Scrollable = false;
	        }
	        
	        ClickableAttr = (String) PgSrc.get(i).getAttribute("clickable");
	        if (ClickableAttr.equals("true") == true)
	        { 
	        	Clickable = true;
	        }
	        else {
	        	Clickable = false;
	        }
	        
	        LongClickableAttr = (String) PgSrc.get(i).getAttribute("long-clickable");
	        if (LongClickableAttr.equals("true") == true)
	        { 
	        	LongClickable = true;
	        }
	        else {
	        	LongClickable = false;
	        }
	        
	        TextAttr1 = (String) PgSrc.get(i).getAttribute("longClickable");
	        TextAttr2 = (String) (PgSrc.get(i).getAttribute("password"));
	        if ((TextAttr1.equals("true") == true) || (TextAttr2.equals("true") == true))
	        { 
	        	Text = true;
	        }
	        else {
	        	Text = false;
	        }
	        
	        GeneralElementAttr1 = (Boolean) tagName.contains("android.widget.ImageView");
	        GeneralElementAttr2 = (Boolean) tagName.contains("android.widget.TextView");
	        if ((GeneralElementAttr1.equals(true) == true || GeneralElementAttr2.equals(true) == true) && (TextAttr1.equals("false") == true)  && (TextAttr2.equals("false") == true))
	        { 
	        	GeneralElement = true;
	        }
	        else{
	        	GeneralElement = false;
	        }
	        
	       
	        /*
	        System.out.println(ScrollableAttr);
	        System.out.println(ClickableAttr);
	        System.out.println(LongClickableAttr);
	        System.out.println(TextAttr1);
	        System.out.println(TextAttr2);*/
	        
	        int Location = Integer.parseInt(PgSrc.get(i).getAttribute("y"));
	        
	        /*
	        System.out.println(Location);
	        System.out.println(Scrollable);
	        System.out.println(Clickable);
	        System.out.println(LongClickable);
	        System.out.println(Text);
	        System.out.println(GeneralElement);*/
	        
	        
	        if (Scrollable == true)
	        {
	        	if(Location <= topsize)
	        	{
	        		TopScrollable += 1;
	        	}
	        	else if((Location <= middlesize) && (Location > topsize))
	        	{
	        		MiddleScrollable += 1;
	        	}
	        	else if((Location <= bottomsize) && (Location > middlesize))
	        	{
	        		BottomScrollable += 1;
	        	}
	        }
	        
	        if (Clickable == true)
	        {
	        	if(Location <= topsize)
	        	{
	        		TopClickable += 1;
	        	}
	        	else if((Location <= middlesize) && (Location > topsize))
	        	{
	        		MiddleClickable += 1;
	        	}
	        	else
	        	{
	        		BottomClickable += 1;
	        	}
	        }
	        
	        if (LongClickable == true)
	        {
	        		TopLongClickable += 1;
	        	
	        }
	        
	        if (Text == true)
	        {
	        	if(Location <= topsize)
	        	{
	        		TopTextOrPw += 1;
	        	}
	        	else if((Location <= middlesize) && (Location > topsize))
	        	{
	        		MiddleTextOrPw += 1;
	        	}
	        	else if((Location <= bottomsize) && (Location > middlesize))
	        	{
	        		BottomTextOrPw += 1;
	        	}
	        }
	        
	        if (GeneralElement == true)
	        {
	        	GeneralElements += 1;
	        }
	        if (NavigationBar == true)
	        {
	        	NavigationValue = 1;
	        }
	        else
	        {
	        	NavigationValue = 0;
	        }
	        
	        
	  		/*System.out.println(TopScrollable);
	  		System.out.println(MiddleScrollable);
	  		System.out.println(BottomScrollable);
	  		System.out.println(TopClickable);
	  		System.out.println(MiddleClickable);
	  		System.out.println(BottomClickable);
	  		System.out.println(TopLongClickable);
	  		System.out.println(TopTextOrPw);
	  		System.out.println(MiddleTextOrPw);
	  		System.out.println(BottomTextOrPw);
	  		System.out.println(GeneralElements);
	  		System.out.println("-------------------------------------");*/
	        }
	        }
	        
	        writer.write(sb.toString());
	        

	        try
	        {
	        StringBuilder sb1 = new StringBuilder();
	        sb1.append("Number of clickable elements in top section");
	        sb1.append(',');
	        sb1.append("Number of clickable elements in middle section");
	        sb1.append(',');
	        sb1.append("Number of clickable elements in bottom section");
	        sb1.append(',');
	        sb1.append("Number of swipeable elements in top section");
	        sb1.append(',');
	        sb1.append("Number of swipeable elements in middle section");
	        sb1.append(',');
	        sb1.append("Number of swipeable elements in bottom section");
	        sb1.append(',');
	        sb1.append("Number of text field elements in top section");
	        sb1.append(',');
	        sb1.append("Number of text field elements in middle section");
	        sb1.append(',');
	        sb1.append("Number of text field elements in bottom section");
	        sb1.append(',');
	        sb1.append("Number of general elements");  
	        sb1.append(',');
	        sb1.append("Number of long-clickable elements");
	        sb1.append(',');
	        sb1.append("Navigation Drawer");
	        sb1.append(',');
	        sb1.append("Activity_Type");
	        sb1.append('\n');
	        
	        sb1.append(TopClickable);
	  		sb1.append(',');
	  		sb1.append(MiddleClickable);
	  		sb1.append(',');
	  		sb1.append(BottomClickable);
	  		sb1.append(',');
	  		sb1.append(TopScrollable);
	  		sb1.append(',');
	  		sb1.append(MiddleScrollable);
	  		sb1.append(',');
	  		sb1.append(BottomScrollable);
	  		sb1.append(',');
	  		sb1.append(TopTextOrPw);
	  		sb1.append(',');
	        sb1.append(MiddleTextOrPw);
	        sb1.append(',');
	        sb1.append(BottomTextOrPw);
	        sb1.append(',');
	        sb1.append(GeneralElements);
	        sb1.append(',');
	        sb1.append(TopLongClickable);
	        sb1.append(',');
	        sb1.append(NavigationValue); 
	        sb1.append(',');
	        sb1.append(' ');
	        sb1.append('\n');
	        
	        
	        try(PrintWriter writer1 = new PrintWriter(new File("test1.csv"))) 
	        {
	        	writer1.write(sb1.toString());
	        }
	        catch(FileNotFoundException e)
	        {
	        	System.out.println(e.getMessage());
	        }
	        
	        Process p = Runtime.getRuntime().exec("python C:\\Users\\dhruv\\eclipse-workspace\\AppiumDemo\\KNN_Program.py");
	        
	        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        
	       System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            
            System.exit(0);
	        }
	        
	        catch (FileNotFoundException e) {
		        System.out.println(e.getMessage());
	        
	        String packagename1 = null;
	        
	        if (packagename1 == "com.linkedin.android")
	        {
	        	TestCases t1 = new TestCases();
	        	t1.testUntitled();
	        }
	        
	        if (packagename1 == "com.teamviewer.teamviewer.market.mobile")
	        {
	        	TestCases2 t2 = new TestCases2();
	        	t2.testUntitled();
	        }
	        
	        
	        
	        if (packagename1 == "com.google.android.apps.tasks")
	        {
	        	TestCases3 t3 = new TestCases3();
	        	t3.testUntitled();
	        	
	        }
	        
	        
	        if (packagename1 == "com.microsoft.office.outlook")
	        {
	        	TestCases4 t4 = new TestCases4();
	        	t4.testUntitled();
	        }
	        
	        if (packagename1 == "edu.texastech.enterprisemobile")
	        {
	        	TestCases5 t5 = new TestCases5();
	        	t5.testUntitled();
	        }

	        System.out.println("done!");

	      }
	        
	        /*catch (FileNotFoundException e) {
	        System.out.println(e.getMessage());*/
	      }
		  
		 
	    //System.out.print(PgSrc.get(0).getTagName());
	    
	    //driver.resetApp();
	    
	    driver.quit();
	    
	    
	    /*
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
	    */
	    
	    
	}
}
