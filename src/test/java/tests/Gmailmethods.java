package tests;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import pages.Loginpage;
import pages.Mailboxpage;

public class Gmailmethods
{ 
	public WebDriver driver;
	public Homepage hp;
	public Loginpage lp;
	public Mailboxpage mp;
	public Scenario s;
	public Properties pro;
	@Before
	public void method1(Scenario x) throws Exception
	{
		//use Scenario object for current Scenario 
		this.s=x;
		//load properties file for current scenario
		pro=new Properties();
		FileInputStream fip=new FileInputStream("E:\\eclipse2\\eclipse1\\gmailcucumber\\src\\test\\resources\\gmailresources\\property.properties");
		pro.load(fip);
		//System.setProperty("webdriver.chrome.driver", pro.getProperty("gdpath"));
		driver=new ChromeDriver();
		//create page objects for current scenario
		hp=new Homepage(driver);
		lp=new Loginpage(driver);
		mp=new Mailboxpage(driver);
	}
	
	@Given("^launch gmail site$")                                    
		public void method2(String x) throws Exception
		{
			driver.get(pro.getProperty("url"));
			Thread.sleep(5000);
		}
	@Then("^title is \"(.*)\" value$")
	public void method3(String x)
	{
		String t=driver.getTitle();
		if(t.equals(x))
		{
			s.write("title test passed");
			
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b, "Title is failed");
		}
	}
	@And("^close site$")
	public void method4()
	{
		driver.close();
	}
	@When("^enter userid with \"(.*)\" value$")
	public void method5(String u) throws Exception
	{
		hp.filluid(u);
		Thread.sleep(5000);
			
	}
	@And("^click next button$")
	public void method6() throws Exception
	{
		hp.clickuidnext();
	}
	@Then("^validate Userid field with \"(.*)\" criteria$")
	public void method7(String c)
	{
		if(c.equalsIgnoreCase("valid")&&lp.pwd.isDisplayed())
		{
			s.write("valid userid test was passed");
			
		}
		else if(c.equalsIgnoreCase("invalid")&&lp.invalidpwderr.isDisplayed())
		{
			s.write("invalid test was passed");
		}
		else if(c.equalsIgnoreCase("blank")&& lp.blankpwderr.isDisplayed())
		{
			s.write("blank test was passed");
		}
		else
		{
			byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(b, "usedid is failed");
		}
	}
		
		@And("^enter password with \"(.*)\" criteria$")
		public void  method8(String p)throws Exception
		{
			lp.fillpwd(p);
			Thread.sleep(5000);
		}
		@And("^click password next button$")
		public void method9() throws Exception
		{
			lp.clickpwdnext();
			Thread.sleep(5000);
		}
		@Then("^validate password with \"(.*)\" criteria$")
		public void method9(String c)
		{
           if(c.equalsIgnoreCase("valid")&&lp.pwd.isDisplayed())
           {
        	   s.write("valid uid test was passed");
           }
           else if(c.equalsIgnoreCase("invalid")&&hp.invaliduiderr.isDisplayed())
           {
        	   s.write("invalid uid test was passed");
           }
           else if(c.equalsIgnoreCase("blank")&&hp.blankuiderr.isDisplayed())
           {
        	   byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
   			s.embed(b, "password is failed");
           }
		}
  		
		
	}
		
	
	


