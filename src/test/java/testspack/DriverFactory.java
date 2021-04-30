package testspack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

private ThreadLocal<RemoteWebDriver> rwd=new ThreadLocal<RemoteWebDriver>();

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setDriver(String browserType) {
        System.out.println("startss");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("browserName", browserType);

        if (browserType.equalsIgnoreCase("Chrome"))
            WebDriverManager.chromedriver().setup();


        else
            WebDriverManager.firefoxdriver().setup();

        try {
            System.out.println("intttttt");
            rwd.set(new RemoteWebDriver(new URL(("http://localhost:4444/wd/hub").trim()), dc));
            System.out.println("after set get driverrr-------"+rwd.get());
            System.out.println("doneee");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    public RemoteWebDriver getDriver() {
        System.out.println("get driverrr"+rwd.get());
        return rwd.get();
    }

    @AfterMethod
    public void rmDriver() {
        rwd.get().quit();
        rwd.remove();
    }


}
