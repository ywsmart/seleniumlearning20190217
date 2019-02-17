package com.yvan;

import com.yvan.page.EventPage;
import com.yvan.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 9:55.
 */
public class ClickBanner {

    private WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        driver = new ChromeDriver();
    }

    @Test
    private void test() throws InterruptedException {
        driver.get("https://testerhome.com");
        HomePage homePage = new HomePage(driver);
        String handle1 = driver.getWindowHandle();
        Reporter.log("原窗口"+handle1,true);
        homePage.clickBanner();
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String handle:driver.getWindowHandles()){
            if (!handle.equalsIgnoreCase(handle1)){
                driver.switchTo().window(handle);
                Reporter.log("切换到窗口"+handle,true);
            }
        }
        String expectTitle = "大会";
//        String actualTitle = new EventPage(driver).getPageTitle();
//        Assert.assertTrue(actualTitle.contains(expectTitle),"期待网页标题包含"+expectTitle+"实际的标题是"+actualTitle);
        wait.until(ExpectedConditions.titleContains(expectTitle));
        Thread.sleep(2000);
    }

    @AfterMethod
    private void teardown() {
        driver.quit();
    }
}
