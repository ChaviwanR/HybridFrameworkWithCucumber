package utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends PageInitializer {

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public static void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickRadioOrChkbox(List<WebElement> radioOrChkBox, String value) {
		String actualValue;
		for (WebElement eachElement : radioOrChkBox) {
			actualValue = eachElement.getAttribute("value").trim();
			if (eachElement.isEnabled() && actualValue.equals(value)) {
				eachElement.click();
				break;

			}
		}
	}

	public static void ClickOnNavigationBar(List<WebElement> listofitem, String TopMenuName) {
		List<WebElement> listItem = listofitem;
		for (WebElement top : listItem) {
			if (top.getText().contains(TopMenuName)) {
				top.click();
				break;
			}
		}
	}

	public static void clickOnSubMenu(List<WebElement> listofitem, String TopMenuName, List<WebElement> subMenu,
			String SubMenuName) {
		CommonMethods.ClickOnNavigationBar(listofitem, TopMenuName);
		if (subMenu != null) {
			CommonMethods.ClickOnNavigationBar(subMenu, SubMenuName);
		}
	}

	public void clickRadioOrChkboxText(List<WebElement> radioOrChkBox, String value) {
		String actualValue;
		for (WebElement eachElement : radioOrChkBox) {
			actualValue = eachElement.getText();
			if (eachElement.isEnabled() && actualValue.equals(value)) {
				eachElement.click();
				break;

			}
		}
	}

	public static void selectDropdownByVisibilityText(WebElement element, String textToBeSelected) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement eachoption : options) {
				if (eachoption.getText().equalsIgnoreCase(textToBeSelected)) {
					select.selectByVisibleText(textToBeSelected);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void selectDropdownByIndex(WebElement element, int indexValue) {

		Select select = new Select(element);
		int optionSize = select.getOptions().size();
		if (optionSize > indexValue) {
			select.selectByIndex(indexValue);
		}

	}

	public static void selectDropdownByValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement eachoption : options) {
				if (eachoption.getAttribute("Value").equalsIgnoreCase(value)) {
					select.selectByValue(value);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void accetAlert() {
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	public static String getTextAlert() {
		String alertText = null;
		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertText;
	}

	public static void sendTextAlert(String textToBeSend) {

		try {
			Alert alert = BaseClass.getDriver().switchTo().alert();
			alert.sendKeys(textToBeSend);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	public static void switchToIframeByIndex(int iframeIndex) {
		try {
			BaseClass.getDriver().switchTo().frame(iframeIndex);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	public static void switchToIframeByElement(WebElement iframeElement) {
		try {
			BaseClass.getDriver().switchTo().frame(iframeElement);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	public static void switchToIframeByName(String iframeName) {
		try {
			BaseClass.getDriver().switchTo().frame(iframeName);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	public static void switchToChildWindow(String parentWindowName) {

		try {
			Set<String> windowHandles = BaseClass.getDriver().getWindowHandles();
			for (String eachWindow : windowHandles) {
				if (!eachWindow.equalsIgnoreCase(parentWindowName)) {
					BaseClass.getDriver().switchTo().window(eachWindow);
					break;
				}
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Exception occured while swithching to child window: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Constants.explicit_wait_time);
		return wait;
	}

	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));

	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));

	}

	public static void waitForClick(WebElement element) {
		waitForVisibility(element).click();
	}

	public static void waitForSendKey(WebElement element, String Keyword) {
		waitForVisibility(element).sendKeys(Keyword);
	}

	// action class

	public static void hoverOverMouse(WebElement element) {
		Actions act = new Actions(BaseClass.getDriver());
		act.moveToElement(element).build().perform();
	}

	public static void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Actions act = new Actions(BaseClass.getDriver());
		act.dragAndDrop(sourceElement, targetElement).build().perform();
	}

	public static void takeScreenShot(WebDriver driver) {
		// create object to SimpleDataFormat class and decide the format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM-dd_HH_mm_ss");
		// get the current date time with local time
		LocalDateTime now = LocalDateTime.now();
		// convert the date into the String
		String dateString = now.format(formatter);

		// casting webDriver to taking Screenshot

		TakesScreenshot screenshot = (TakesScreenshot) driver;
		// get the screenshot as an outputFile
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		// define the destination path with the unique name

		String desFilePath = "src/test/resources/screenShots/Testing_" + dateString + ".png";
		File desFile = new File(desFilePath);

		// use FileUtils to copy the screenshot to the destination
		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}// end of the class
