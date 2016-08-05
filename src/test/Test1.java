package test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterClass;

public class Test1 {
	
	private static WebDriver driver;
	private String URL;

  @Test
  public void f() {
	  driver.get(URL);
	  driver.manage().window().maximize();
	  Sleeper.sleepTightInSeconds(10);
  }
  public void TestGoogle() {
	// TODO Auto-generated method stub
	
}
@BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  URL = "http:www.google.com";
  }

  @AfterClass
  public void afterClass() {
  }

}
