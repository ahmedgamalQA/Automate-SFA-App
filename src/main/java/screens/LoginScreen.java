package screens;

import org.openqa.selenium.By;

import static utils.SharedSteps.*;

public class LoginScreen {

    private final By emailLoginTapLocator = By.xpath("//android.view.View[@content-desc=\"Email Login\n" +
            "Tab 2 of 2\"]");
    private final By emailFieldLocator = By.xpath("//android.view.View[@content-desc=\"Welcome to Sfa!\n" +
            "Discover amazing things around you\"]/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[1]");
    private final By passwordFieldLocator = By.xpath("//android.view.View[@content-desc=\"Welcome to Sfa!\n" +
            "Discover amazing things around you\"]/android.view.View[3]/android.view.View/android.view.View/android.widget.EditText[2]");
    private final By signInButtonLocator = By.xpath("//android.widget.Button[@content-desc=\"Sign In\"]");
    private final By acceptTermButtonLocator = By.xpath("//android.widget.Button[@content-desc=\"Accept\"]");

    private LoginScreen() {
    }

    public static LoginScreen getLoginScreen() {
        return new LoginScreen();
    }

    public LoginScreen chooseEmailLogin(){
        clickOnElement(emailLoginTapLocator);
        return this;
    }
    public LoginScreen enterEmail(String emailAddress){
        clickOnElement(emailFieldLocator);
        sendTextToElement(emailFieldLocator,emailAddress);
        return this;
    }
    public LoginScreen enterPassword(String password){
        clickOnElement(passwordFieldLocator);
        sendTextToElement(passwordFieldLocator,password);
        return this;
    }
    public LoginScreen clickOnSignIn(){
        clickOkOnKeyboard();
        clickOnElement(signInButtonLocator);
        return this;
    }

    public void acceptTerms(){
        clickOnElement(acceptTermButtonLocator);
    }
}
