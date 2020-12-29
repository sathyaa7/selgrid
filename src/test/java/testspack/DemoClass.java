package testspack;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DemoClass extends DriverFactory {

    private static WebDriver driver;

    @Test
    public void test1()
    {
        driver=getDriver();
        driver.get("https://www.demoqa.com/");
        Assert.assertTrue("Banner is visible",driver.findElement(By.xpath("//img[@class=\"banner-image\"]")).isDisplayed());
        driver.findElement(By.xpath("//div[@class=\"card-up\"]")).click();
    }
}
