package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import objectRepository.ObjectLandingPage;
import resources.Base;
import utility.CommonMethods;

public class LandingPage {

	public static List<WebElement> menuBarList = ObjectLandingPage.menuBarList;
	public static List<WebElement> categoryList = ObjectLandingPage.categoryList;
	public static List<WebElement> featuresItemList = ObjectLandingPage.featuresItemsList;
	public static List<WebElement> brandsList = ObjectLandingPage.brandsList;

	//verify home page
	public static void verifyTitle() throws IOException
	{
		//String URL = Base.getPropertiesData("URL");
		//Base.initializeDriver(URL);
		String title = Base.getDriver().getTitle();
		try {
			if(CommonMethods.compareString(Base.getPropertiesData("title"), title))
			{
				System.out.println("------------Successfully verified Home Page title-----------");
				Assert.assertEquals(true, true);
			}
			else
			{
				System.out.println("------------Failed to Verify Home Page title-----------");
				Assert.assertEquals(false, true);
			}
		} catch (IOException e) {
			System.out.println("------------Unable to get title page details please check your script-----------");
			Assert.assertEquals(false, true);
			e.printStackTrace();
		}
	}

	public static void verifyHomePageMenuBarNames()
	{
		//verify menu bar elements name
		String Home = null;
		String Products = null;
		String SignUpLogin = null;
		String TestCases = null;
		String APITesting = null;
		String ContactUs = null;
		try {
			Home = Base.getPropertiesData("Home");
			Products = Base.getPropertiesData("Products");
			SignUpLogin = Base.getPropertiesData("SignUpLogin");
			TestCases = Base.getPropertiesData("TestCases");
			APITesting = Base.getPropertiesData("APITesting");
			ContactUs = Base.getPropertiesData("ContactUs");

			Assert.assertEquals(CommonMethods.selectValueFromList(menuBarList, Home), Home);
			Assert.assertEquals(CommonMethods.selectValueFromList(menuBarList, Products), Products);
			Assert.assertEquals(CommonMethods.selectValueFromList(menuBarList, SignUpLogin), SignUpLogin);
			Assert.assertEquals(CommonMethods.selectValueFromList(menuBarList, TestCases), TestCases);
			Assert.assertEquals(CommonMethods.selectValueFromList(menuBarList, APITesting), APITesting);
			Assert.assertEquals(CommonMethods.selectValueFromList(menuBarList, ContactUs), ContactUs);

			System.out.println("------------------Successfully Validated Menu Bar Names-----------------");

		} catch (IOException e) {
			System.out.println("------------Unable to fetch names of menu bar-----------");
			Assert.assertEquals(false, true);
			e.printStackTrace();
		}

	}

	public static void verifyHomePageElementNames()
	{

		// verify page item names are displayed
		try {
			String Category = Base.getPropertiesData("Category");
			String FeaturesItems = Base.getPropertiesData("FeaturesItems");
			String Brands = Base.getPropertiesData("Brands");
			String RecommendedItems = Base.getPropertiesData("RecommendedItems");

			CommonMethods.scrollDownWindowDown();

			Assert.assertEquals(Base.getDriver().findElement(ObjectLandingPage.Category).getText(), Category);
			Assert.assertEquals(Base.getDriver().findElement(ObjectLandingPage.FeaturesItems).getText(), FeaturesItems);

			CommonMethods.scrollDownWindowDown();

			Assert.assertEquals(Base.getDriver().findElement(ObjectLandingPage.Brands).getText(), Brands);

			CommonMethods.scrollToCertainElement(Base.getDriver().findElement(ObjectLandingPage.RecommendedItems));

			Assert.assertEquals(Base.getDriver().findElement(ObjectLandingPage.RecommendedItems).getText(), RecommendedItems);

			System.out.println("------------------Successfully Validated Landing Page Element Names-----------------");

		} catch (IOException e) {
			System.out.println("------------Unable to fetch names of Page items-----------");
			Assert.assertEquals(false, true);
			e.printStackTrace();
		}

	}

	public static void verifyHomePageMenuBarElementsEnabled()
	{
		try {

			int totalMenuItems = menuBarList.size();
			for(int i = 1; i <= totalMenuItems; i++)
			{
				if(Base.getDriver().findElement(ObjectLandingPage.getMenuItemXpath(i)).isEnabled())
				{
					System.out.println("-----------Validated button "
							+Base.getDriver().findElement(ObjectLandingPage.getMenuItemXpath(i)).getText()+
							"-----------------------");
					Assert.assertEquals(true, true);
				}

				else
				{
					System.out.println("------------Menu Bar button "
							+Base.getDriver().findElement(ObjectLandingPage.getMenuItemXpath(i)).getText()+
							" is not enabled-----------");
					Assert.assertEquals(false, true);
				}
			}

		}catch (Exception e) {
			System.out.println("------------Unable to get Enabled Menu bar elements-----------");
			Assert.assertEquals(false, true);
			e.printStackTrace();
		}
	}

	public static void verifyElementsHomePageEnabled()
	{
		CommonMethods.scrollUpWindowTop();

		//Scroll down to vertical grid features Item
		CommonMethods.scrollToCertainElement(Base.getDriver().findElement(ObjectLandingPage.Category));

		//verify elements in category grid
		for(WebElement element : categoryList)
		{
			if(element.isEnabled())
			{
				System.out.println("------Successfully Validated Element "+element.getText()+" on Home Page------");
				Assert.assertEquals(true, true);
			}
			else
			{
				System.out.println("------Failed to Validate Element "+element.getText()+" on Home Page------");
				Assert.assertEquals(false, true);
			}
		}
		CommonMethods.scrollToCertainElement(Base.getDriver().findElement(ObjectLandingPage.Brands));

		//verify elements in category grid
		for(WebElement element : brandsList)
		{
			if(element.isEnabled())
			{
				System.out.println("------Successfully Validated Element "+element.getText()+" on Home Page------");
				Assert.assertEquals(true, true);
			}
			else
			{
				System.out.println("------Failed to Validate Element "+element.getText()+" on Home Page------");
				Assert.assertEquals(false, true);
			}
		}

		CommonMethods.scrollUpWindowTop();

		//Scroll down to vertical grid features Item
		CommonMethods.scrollToCertainElement(Base.getDriver().findElement(ObjectLandingPage.FeaturesItems));

		//verify elements in featuresItem grid
		for(WebElement element : featuresItemList)
		{
			if(element.isEnabled())
			{
				System.out.println("------Successfully Validated Element "+element.getText()+" on Home Page------");
				Assert.assertEquals(true, true);
			}
			else
			{
				System.out.println("------Failed to Validate Element "+element.getText()+" on Home Page------");
				Assert.assertEquals(false, true);
			}
		}
	}

	public static void verifyNavigationButtonsHomePage()
	{
		CommonMethods.scrollToCertainElement(Base.getDriver().findElement(ObjectLandingPage.RecommendedItems));
		//verify left navigation button
		if(Base.getDriver().findElement(ObjectLandingPage.leftNavigateRecommendedItems).isEnabled())
		{
			System.out.println("------Successfully Validated Left Navigation on Home Page------");
			Assert.assertEquals(true, true);
		}
		else
		{
			System.out.println("------Failed to Validate Element Left Navigation on Home Page------");
			Assert.assertEquals(false, true);
		}
		//verify right navigation button
		if(Base.getDriver().findElement(ObjectLandingPage.rightNavigateRecommendedItems).isEnabled())
		{
			System.out.println("------Successfully Validated Right Navigation on Home Page------");
			Assert.assertEquals(true, true);
		}
		else
		{
			System.out.println("------Failed to Validate Element Right Navigation on Home Page------");
			Assert.assertEquals(false, true);
		}
		//verify top navigation button
		if(Base.getDriver().findElement(ObjectLandingPage.navigateUp).isEnabled())
		{
			System.out.println("------Successfully Validated Top Navigation on Home Page------");
			Assert.assertEquals(true, true);
		}
		else
		{
			System.out.println("------Failed to Validate Element Top Navigation on Home Page------");
			Assert.assertEquals(false, true);
		}
	}
}
