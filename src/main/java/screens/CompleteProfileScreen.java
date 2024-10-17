package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static utils.SharedSteps.*;

public class CompleteProfileScreen {
    private final By mobileFiledLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)");
    private final By saveButtonLocator = By.xpath("//android.widget.Button[@content-desc=\"Save\"]");

    private CompleteProfileScreen() {
    }

    public static CompleteProfileScreen getCompleteProfileScreen() {
        return new CompleteProfileScreen();
    }

    public CompleteProfileScreen enterMobileNumber(String mobileNumber) {
        clickOnElement(mobileFiledLocator);
        sendTextToElement(mobileFiledLocator, mobileNumber);
        clickOkOnKeyboard();
        return this;
    }

    public void clickOnSaveButton(){
        clickOnElement(saveButtonLocator);
    }
}
