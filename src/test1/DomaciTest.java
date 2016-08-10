package test1;

import org.testng.annotations.Test;

import libary.data.Property;
import libary.pages.HomePage;
import libary.pages.LoginPage;
import libary.pages.MyProfilePage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class DomaciTest {

	private WebDriver driver;
	LoginPage loginPage;
	HomePage homepage;
	MyProfilePage myProfilePage;
	String message;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Enter in before class");
		driver = new FirefoxDriver();
		loginPage = new LoginPage(driver);
		driver.manage().window().maximize();

		loginPage.typeUsername(Property.username);
		loginPage.typePassword(Property.password);
		homepage = loginPage.clickOnLoginButton();

		message = homepage.getTextFromLogInfoLabel();
		System.out.println(message);

		assert message.contains("You are logged in as") : "You are not logged in. Test Failed.";

		homepage.clickOnMyAccount();
		myProfilePage = homepage.clickOnMyProfile();

		System.out.println("Test passed");
	}

	@Test(dependsOnMethods = "f1")
	public void f() {
		System.out.println("Enter in test My Profile");

		message = myProfilePage.getEmailAddress();

		assert message.contains(Property.email) : "You are not logged in";
		System.out.println("Test passed");

	}

	@Test()
	public void f1() {
		System.out.println("Enter in career test");

		message = myProfilePage.getTextFromCareerLable();

		assert message.contains(Property.textCareer) : "Test failed";
		System.out.println("Test passed");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Enter in after class");
		myProfilePage.clickLogout();
		System.out.println("Test passed");
		driver.quit();
	}

}