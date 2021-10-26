package org.example;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.net.MalformedURLException;


import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.*;

public class AppTest {

    public String username = System.getenv("BROWSERSTACK_USERNAME");
    public String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    public static String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
    public static String browserstackLocal = System.getenv("BROWSERSTACK_LOCAL");
    public static String browserstackLocalIdentifier = System.getenv("BROWSERSTACK_LOCAL_IDENTIFIER");
    public String URL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
    String app = System.getenv("BROWSERSTACK_APP_ID");
 /*   public String appURL;

  @BeforeTest
    public void setup() {
        String url = "https://api.browserstack.com/app-automate/upload";

        HttpResponse<JsonNode> response = Unirest.post(url)
                .header("Authorization", "Basic bGVldmFyZGFyb19zcWlGMlk6WE5SMTdhUFhQcDZOYU5aTnZ5RDI=")
                .field("file", new File("/Users/leevardaro/Downloads/WikipediaSample.apk"))
                .asJson();

        JSONObject myObj = response.getBody().getObject();
        appURL = myObj.getString("app_url");
        System.out.println(appURL);
    }
*/
    @Test
    public void test1() throws InterruptedException, MalformedURLException {
           long id = Thread.currentThread().getId();

           System.out.println("Simple test-method One. Thread id is: " + id);
           String device = "Samsung Galaxy S8 Plus";
           DesiredCapabilities caps = new DesiredCapabilities();

           caps.setCapability("device", device);
           caps.setCapability("os_version", "7.0");
           caps.setCapability("real_mobile", "true");
           caps.setCapability("project", "ParallelApp");
           caps.setCapability("name", device);
           caps.setCapability("build", buildName);
           caps.setCapability("browserstack.local", browserstackLocal);
           caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
           caps.setCapability("app", app);


           AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

           AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                   ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
           searchElement.click();
           AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                   ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
           insertTextElement.sendKeys("BrowserStack");
           Thread.sleep(5000);

           List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
           assert (allProductsName.size() > 0);

           SessionId session = ((RemoteWebDriver) driver).getSessionId();
           String sID = session.toString();
           System.out.println(sID);
           String putEndpoint = "https://api-cloud.browserstack.com/app-automate/sessions/" + sID + ".json";

           driver.quit();
           String test = Unirest.put(putEndpoint)
                   .header("Content-Type", "application/json")
                   .header("Authorization", "Basic bGVldmFyZGFyb19zcWlGMlk6WE5SMTdhUFhQcDZOYU5aTnZ5RDI=")
                   .body("{\n    \"status\":\"passed\",\n    \"reason\":\"it's done\"\n}")
                   .asString()
                   .getBody();
           System.out.println(test);
       

    }
    @Test
    public void test2() throws InterruptedException, MalformedURLException {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two. Thread id is: " + id);
        String device = "Samsung Galaxy S21 Ultra";
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", device);
        caps.setCapability("os_version", "11.0");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("project", "ParallelApp");
        caps.setCapability("name", device);
        caps.setCapability("build", buildName);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        caps.setCapability("app", app);



        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert (allProductsName.size() > 0);

        SessionId session = ((RemoteWebDriver) driver).getSessionId();
        String sID = session.toString();
        System.out.println(sID);
        String putEndpoint = "https://api-cloud.browserstack.com/app-automate/sessions/" + sID + ".json";

        driver.quit();
        String test = Unirest.put(putEndpoint)
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic bGVldmFyZGFyb19zcWlGMlk6WE5SMTdhUFhQcDZOYU5aTnZ5RDI=")
                .body("{\n    \"status\":\"passed\",\n    \"reason\":\"it's done\"\n}")
                .asString()
                .getBody();
        System.out.println(test);
    }
    @Test
    public void test3() throws InterruptedException, MalformedURLException {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three. Thread id is: " + id);
        String device = "OnePlus 9";
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", device);
        caps.setCapability("os_version", "11.0");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("project", "ParallelApp");
        caps.setCapability("name", device);
        caps.setCapability("build", buildName);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        caps.setCapability("app", app);



        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert (allProductsName.size() > 0);

        SessionId session = ((RemoteWebDriver) driver).getSessionId();
        String sID = session.toString();
        System.out.println(sID);
        String putEndpoint = "https://api-cloud.browserstack.com/app-automate/sessions/" + sID + ".json";

        driver.quit();
        String test = Unirest.put(putEndpoint)
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic bGVldmFyZGFyb19zcWlGMlk6WE5SMTdhUFhQcDZOYU5aTnZ5RDI=")
                .body("{\n    \"status\":\"passed\",\n    \"reason\":\"it's done\"\n}")
                .asString()
                .getBody();
        System.out.println(test);
    }
    @Test
    public void test4() throws InterruptedException, MalformedURLException {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Four. Thread id is: " + id);
        String device = "Google Pixel 5";
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", device);
        caps.setCapability("os_version", "12 Beta");
        caps.setCapability("real_mobile", "true");
        caps.setCapability("project", "ParallelApp");
        caps.setCapability("name", device);
        caps.setCapability("build", buildName);
        caps.setCapability("browserstack.local", browserstackLocal);
        caps.setCapability("browserstack.localIdentifier", browserstackLocalIdentifier);
        caps.setCapability("app", app);



        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

        AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
        searchElement.click();
        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
                ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
        insertTextElement.sendKeys("BrowserStack");
        Thread.sleep(5000);

        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
        assert (allProductsName.size() > 0);

        SessionId session = ((RemoteWebDriver) driver).getSessionId();
        String sID = session.toString();
        System.out.println(sID);
        String putEndpoint = "https://api-cloud.browserstack.com/app-automate/sessions/" + sID + ".json";

        driver.quit();
        String test = Unirest.put(putEndpoint)
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic bGVldmFyZGFyb19zcWlGMlk6WE5SMTdhUFhQcDZOYU5aTnZ5RDI=")
                .body("{\n    \"status\":\"passed\",\n    \"reason\":\"it's done\"\n}")
                .asString()
                .getBody();
        System.out.println(test);
    }
}