package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LandingPage;
import resources.Base;

public class LandingPageTest extends Base{

	@Test
	public void verifyLandingPageLoadTest() throws IOException
	{
		String URL = Base.getPropertiesData("URL");
		Base.initializeDriver(URL);
		LandingPage.verifyTitle();
		LandingPage.verifyHomePageMenuBarNames();
		LandingPage.verifyHomePageMenuBarElementsEnabled();
		LandingPage.verifyHomePageElementNames();
		LandingPage.verifyElementsHomePageEnabled();
		LandingPage.verifyNavigationButtonsHomePage();
	}
}
