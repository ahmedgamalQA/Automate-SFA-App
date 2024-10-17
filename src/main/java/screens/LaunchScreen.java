package screens;

import org.openqa.selenium.By;

import static utils.SharedSteps.clickOnElement;

public class LaunchScreen {

    private final By nextButtonLocator = By.xpath("//android.widget.Button[@content-desc=\"Next\"]");
    private final By getStartedButtonLocator = By.xpath("//android.widget.Button[@content-desc=\"Get Started\"]");
    private LaunchScreen() {
    }

    public static LaunchScreen getLaunchScreen() {
        return new LaunchScreen();
    }

    public LaunchScreen clickOnNextButton(){
        clickOnElement(nextButtonLocator);
        return this;
    }

    public void clickOnGetStartedButton(){
        clickOnElement(getStartedButtonLocator);
    }
}
