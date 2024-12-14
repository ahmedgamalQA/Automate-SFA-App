# SFA - Appium Automation framework
## Table of contents
* [About The Project](#about-the-project)
* [Built With](#built-with)
* [Prerequisites](#prerequisites)
* [Installation and Run](#installation-and-run)
* [Design Patterns & Concepts](#design-patterns-and-concepts)
* [Project Structure](#project-structure)
* [Test Scenarios](#test-scenarios)
## About The Project

This project is part of the Mobile Test Automation Challenge, Task. The objective is to automate a specific scenario on the App using Appium. 
This challenge tests the functionality, design patterns, code structure, and overall cleanliness and documentation of the automation code.
This project involves creating an automated test script to ensure the correct functionality of the features within the app.

## Built With

This section should list any major dependencies/libraries used to bootstrap this project.

* [![Java][Java]][Java-url]
* [![Selenium][Selenium]][Selenium-url]
* [![Appium][Appium]][Appium-url]
* [![TestNG][TestNG]][TestNG-url]
* [![JsonSimple][JsonSimple]][JsonSimple-url]

## Prerequisites

Before running the automation script for the 4Sale App using Appium, ensure the following prerequisites are met:
1. **Java Development Kit (JDK):**
   - Ensure JDK is installed on your system. You can download it from the [Java SE Downloads page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
2. **Development Environment - IntelliJ IDEA:**
   - Download and install IntelliJ IDEA from [jetbrains.com/idea/](https://www.jetbrains.com/idea/).
3. **Node.js Installation:**
   - Install Node.js from [nodejs.org](https://nodejs.org/). Node.js is required to run Appium server.
4. **Appium Installation:**
   - Install Appium by following the instructions on the [Appium Installation Guide](https://appium.io/docs/en/2.0/quickstart/install/).
5. **UiAutomator2 Installation:**
   - Install UiAutomator2 driver for Android testing following the instructions on the [UiAutomator2 Installation Guide](https://appium.io/docs/en/2.3/quickstart/uiauto2-driver/)
6. **4Sale App Installation:**
   - Install the 4Sale App on your mobile device or emulator where the automation will be executed from Google Play store [4saleApp](https://play.google.com/store/apps/details?id=com.forsale.forsale&hl=en)
7. **Environment Variables (Optional):**
    - Set up any necessary environment variables for Appium or your project configuration, such as paths or specific configurations.

## Installation and Run

Below is an example of how you can install and set up the project.

1. Clone the repo
   ```sh
   git clone https://github.com/ahmedgamalQA/Automate-SFA-App.git
   ```
3. Update the `desiredCapabilities.json` file with your `deviceName`, `deviceID` and `platformVersion` in the project structure found at `src/main/resources/desiredCapabilities.json`
  ```json
{
  "deviceName": "yourDeviceName",
  "udid": "yourDeviceID",
  "platformName": "Android",
  "platformVersion": "yourAndroidVersion",
  "automationName": "uiAutomator2",
  "appPackage": "com.forsale.forsale",
  "appActivity": "com.forsale.app.features.maincontainer.LauncherActivity"
}
```
3. Run the scenarios from `TestScenario` class found at `src/test/java/test_scenarios/TestScenario.java`
   

## Design Patterns and Concepts
* [Page-Object-Model Pattern **POM**](#pom)
* [Singleton Design Pattern](#singleton-design-pattern)
* [Method Chaining Concept](#method-chaining-concept)
* [Static Factory Method](#static-factory-method)
* [Data Driven Techniques](#data-driven-techniques)
## Project Structure
* **Consists of two part**
  - Main part which contains our framework
  - Test part which contains our test scenarios
## POM
* Page Object Model (POM) is a design pattern, popularly used in test automation that creates Object Repository for UI elements.
* The advantage of the model is that it reduces code duplication and improves test maintenance.
* We separate the framework (coding part) from the testing part.
* We represent each screen in our application by Class in the framework.
* You can read more about POM structure on:
  - [Guru99](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/page-object-model-pom/)
  - [Official Selenium](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
  - [BrowserStack](https://www.browserstack.com/guide/page-object-model-in-selenium)
## Singleton Design Pattern
* Singleton design pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the jvm
* So in our case we want to ensure that we have only one instance of AppiumDriver
 ```java
private static AppiumDriver driver;

public static AppiumDriver getAppiumDriver() {
    if (driver == null) {
        driver = new AppiumDriver(getAppiumServerUrl(), getCapabilities());
        return driver;
    }
    return driver;
}
```
* You can read more about singleton design pattern on:
  - [TutorialsPoint](https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/)
  - [Medium](https://medium.com/geekculture/introduction-to-design-patterns-understanding-singleton-design-pattern-5a4d49960444#:~:text=The%20Singleton%20Design%20Pattern%20is,%3B%20in%20case%20of%20Java)
## Method Chaining Concept
* Method Chaining is the practice of calling different methods in a single line instead of calling other methods with the same object reference separately. Under this procedure, we have to write the object reference once and then call the methods by separating them with a (dot.).
* Syntax -> `obj.method1().method2().method3();`
* So in our case we made those methods return `this` which refers to the current object.
```java
    public ProfileScreen clickOnProfileScreen(){
    clickOnElement(profileScreenLocator);
    return this;
}

public ProfileScreen clickOnSettings(){
    clickOnElement(settingsLocator);
    return this;
}
```
* So in our Test part instead of calling methods like this:
```java
public void test() {
    profileScreen.clickOnProfileScreen();
    profileScreen.clickOnSettings();
    profileScreen.switchLanguage();
}
```
* We do this:
```java
public void test() {
    profileScreen.clickOnProfileScreen()
            .clickOnSettings()
            .switchLanguage();
}
```
## Static Factory Method
* The most widely used technique to allow other parts of our Java programs, to get objects of a certain type, is to create public constructors.
* There is also another technique which is that provides various advantages and it would be highly recommendable for every programmer to know. Classes can provide static factory methods. This methods are another way of returning instances.
* #### Advantages of static factory method
  - The static factory method can have a meaningful name.
  - Static factory methods can return the same type that implements the method, a subtype, and also primitives.
  - Inside static factory method other than initialization if we want to perform any activity for every object creation like increasing count value for every object creation we can do this in the static factory method.
  - Encapsulate the construction logic.
* So How we will benefit from this in our framework ?
  - If we are testing the UI of application , we might have 50 screen or more 
  - And we had 50 test classes , we would have this new login screen called 50 times:
  ```java 
   public class LoginScreen {

    public  LoginScreen{
        
    }
  }
  ```
  - Imagine if we decide to change the constructor of this class , we will have to change it in 50 different places
  - But with this, it's only one place:
  ```java 
    public class LoginScreen {

    //Prevent instance
    private LoginScreen() {

    }

    public static LoginScreen getLoginScreen() {
        return new LoginScreen();
    }
   ```
* You can read more about Static Factory Method on:
  - [Medium](https://medium.com/javarevisited/static-factory-methods-an-alternative-to-public-constructors-73cbe8b9fda)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/difference-between-constructor-and-static-factory-method-in-java/#:~:text=The%20static%20factory%20methods%20are,cached%20and%20reused%20if%20required)
  - [Baeldung](https://www.baeldung.com/java-constructors-vs-static-factory-methods)
  - [StackOverFlow](https://stackoverflow.com/questions/929021/what-are-static-factory-methods)
## Data Driven Techniques
* Data Driven Testing is a software testing method in which test data is stored in table or spreadsheet format.
* Data Driven Framework is an automation testing framework in which input values are read from data files and stored into variables in test scripts.
* Data Driven Testing is important because testers frequently have multiple data sets for a single test and creating individual tests for each data set can be time-consuming.
* In our case we will use JSON files for data driven.
#### Why JSON over Excel?
 - Most of data driven testing framework we have used Excel – Apache POI But there is other medium as well to store data into files such as csv, xml, json, text file, etc.
 - Excel is good to manage data and to use but it comes with its own limitations. Like MS Office needs to be installed on the system where the tests are being executed. 
 - As the test servers has never bound to have such dependencies.
 - If test is run on Mac, then again there is a different problem.
## Read Write From JSON File
* This function for reading JSON file can be found at ```src/main/java/utils/Helper.java```:
  ```java
   public static JSONObject readJsonFile(String filePath) {
        JSONObject obj = null;
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
  ```
## Test Scenarios
**Test Scenario 1**
  * Launch screens
  * Login
  * navigate to profile page
  * update mobile number
  * switch Language to arabic

     
[stars-shield]: https://img.shields.io/github/stars/othneildrew/Best-README-Template.svg?style=for-the-badge
[stars-url]: https://github.com/othneildrew/Best-README-Template/stargazers
[issues-shield]: https://img.shields.io/github/issues/othneildrew/Best-README-Template.svg?style=for-the-badge
[issues-url]: https://github.com/othneildrew/Best-README-Template/issues
[license-shield]: https://img.shields.io/github/license/othneildrew/Best-README-Template.svg?style=for-the-badge
[license-url]: https://github.com/othneildrew/Best-README-Template/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/othneildrew
[product-screenshot]: images/screenshot.png
[Java]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://docs.oracle.com/en/java/
[Selenium]: https://img.shields.io/badge/selenium-webdriver-43B02A?style=for-the-badge&logo=selenium&logoColor=white
[Selenium-url]: https://www.selenium.dev/documentation/webdriver/
[Appium]: https://img.shields.io/badge/Appium-41BDF5?style=for-the-badge&logo=appium&logoColor=white
[Appium-url]: https://appium.io/docs/en/latest/
[TestNG]: https://img.shields.io/badge/TestNg-FF7F00?style=for-the-badge&logo=testng&logoColor=white
[TestNG-url]: https://testng.org/
[JsonSimple]: https://img.shields.io/badge/JSON_Simple-000000?style=for-the-badge&logo=json&logoColor=white
[JsonSimple-url]: https://www.digitalocean.com/community/tutorials/json-simple-example
