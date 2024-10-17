package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import static utils.SharedSteps.clickOnElement;

public class ProfileScreen {

    private final By profileScreenLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(17)");
    private final By settingsLocator = AppiumBy.androidUIAutomator("new UiSelector().description(\"Settings\")");
    private final By switchLanguageLocator = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Switch\")");
    private ProfileScreen() {
    }

    public static ProfileScreen getProfileScreen() {
        return new ProfileScreen();
    }

    public ProfileScreen clickOnProfileScreen(){
        clickOnElement(profileScreenLocator);
        return this;
    }

    public ProfileScreen clickOnSettings(){
        clickOnElement(settingsLocator);
        return this;
    }

    public void switchLanguage() {
        clickOnElement(switchLanguageLocator);
    }
}
