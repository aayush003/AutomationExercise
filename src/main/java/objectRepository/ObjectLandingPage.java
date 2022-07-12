package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class ObjectLandingPage {

	public static By Category = By.xpath("//div[@class='left-sidebar']/h2");
	public static By FeaturesItems = By.xpath("//div[@class='features_items']/h2");
	public static By Brands = By.xpath("//div[@class='brands_products']/h2");
	public static By RecommendedItems = By.xpath("//div[@class='recommended_items']/h2");
	public static By leftNavigateRecommendedItems = By.xpath("//div[@id='recommended-item-carousel']//a[@class='left recommended-item-control']");
	public static By rightNavigateRecommendedItems = By.xpath("//div[@id='recommended-item-carousel']//a[@class='right recommended-item-control']");
	public static By navigateUp = By.xpath("//a[@id='scrollUp']//i");

	public static List<WebElement> menuBarList = Base.getDriver().findElements(By.xpath("//div[@class='shop-menu pull-right']//li/a"));
	public static List<WebElement> featuresItemsList = Base.getDriver().findElements(By.xpath("//div[@class='features_items']//div[@class='single-products']"));
	public static List<WebElement> categoryList = Base.getDriver().findElements(By.xpath("//div[@class='panel-group category-products']//span[@class='badge pull-right']"));
	public static List<WebElement> brandsList = Base.getDriver().findElements(By.xpath("//div[@class='brands-name']//li"));

	public static By getMenuItemXpath(int number)
	{
		return By.xpath("//div[@class='shop-menu pull-right']//li["+number+"]/a");
	}
}
