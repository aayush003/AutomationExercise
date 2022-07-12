package utility;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import resources.Base;

public class CommonMethods {

	public static boolean compareString(String text, String word)
	{
		boolean flag = false;
		if(text.contains(word))
			flag = true;
		return flag;
	}

	public static boolean selectValueFromList(List<WebElement> elements, String value)
	{
		boolean flag = false;
		for(WebElement element : elements)
		{
			if(element.getText().equals(value))
			{
				flag = true;
				break;
			}	
		}
		return flag;
	}

	public static void scrollDownWindowDown()
	{
		JavascriptExecutor js = (JavascriptExecutor)Base.getDriver();
		js.executeScript("window.scrollBy(0,500)");
	}

	public static void scrollUpWindowTop()
	{
		JavascriptExecutor js = (JavascriptExecutor)Base.getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollTop)");
	}

	public static void scrollToCertainElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)Base.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
}
