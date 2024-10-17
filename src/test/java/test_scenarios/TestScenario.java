package test_scenarios;

import base.Base;
import data_driven.SafTestData;
import org.testng.annotations.Test;
import screens.CompleteProfileScreen;
import screens.LaunchScreen;
import screens.LoginScreen;
import screens.ProfileScreen;

import static data_driven.SafTestData.*;
import static screens.CompleteProfileScreen.getCompleteProfileScreen;
import static screens.LoginScreen.getLoginScreen;
import static screens.ProfileScreen.getProfileScreen;

public class TestScenario extends Base {

    LaunchScreen launchScreen = LaunchScreen.getLaunchScreen();
    LoginScreen loginScreen = getLoginScreen();
    CompleteProfileScreen completeProfileScreen = getCompleteProfileScreen();
    ProfileScreen profileScreen = getProfileScreen();

    @Test
    public void test() {
        launchScreen.clickOnNextButton()
                .clickOnNextButton()
                .clickOnNextButton()
                .clickOnGetStartedButton();
        loginScreen.chooseEmailLogin()
                .enterEmail(getEmail())
                .enterPassword(getPassword())
                .clickOnSignIn()
                .acceptTerms();
        completeProfileScreen.enterMobileNumber(getMobileNumber())
                .clickOnSaveButton();
        profileScreen.clickOnProfileScreen()
                .clickOnSettings()
                .switchLanguage();
    }
}
