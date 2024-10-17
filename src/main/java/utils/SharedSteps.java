package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileCommand;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverFactory.getAppiumDriver;

public final class SharedSteps {
    private static final AppiumDriver appiumDriver = getAppiumDriver();
    private static final Wait<WebDriver> wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));

    public static void clickOnElement(By elementLocator) {
        try {
            final WebElement element = findElement(elementLocator);
            wait.until(d -> element.isDisplayed());
            element.click();
        } catch (StaleElementReferenceException e) {
            final WebElement element = findElement(elementLocator);
            wait.until(d -> element.isDisplayed());
            element.click();
        }
    }

    public static void clickOkOnKeyboard() {
        RemoteExecuteMethod executeMethod = new RemoteExecuteMethod(appiumDriver);
        KeyEvent enterKeyEvent = new KeyEvent(AndroidKey.ENTER);
        executeMethod.execute(MobileCommand.PRESS_KEY_CODE, enterKeyEvent.build());
    }

    public static void sendTextToElement(By elementLocator, String text) {
        try {
            final WebElement element = findElement(elementLocator);
            wait.until(d -> element.isDisplayed());
            element.sendKeys(text);
        } catch (StaleElementReferenceException e) {
            final WebElement element = findElement(elementLocator);
            wait.until(d -> element.isDisplayed());
            element.sendKeys(text);
        }
    }

    public static WebElement findElement(By elementLocator) {
        return wait.until(d -> appiumDriver.findElement(elementLocator));
    }

}
