package base;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.DriverFactory.getAppiumDriver;

public class Base {

    private AppiumDriver appiumDriver;

    @BeforeMethod
    public void setUp() {
        appiumDriver = getAppiumDriver();
    }

//    @AfterMethod
//    public void tearDown() {
//        if (null != appiumDriver) {
//            appiumDriver.quit();
//        }
//    }

}
