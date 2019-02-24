package com.yvan;

import com.yvan.page.EventPage;
import com.yvan.page.HomePage;
import com.yvan.utils.FileUtils;
import com.yvan.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

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
    private void clickBannerTest() throws Exception {
        driver.get("https://testerhome.com");

//        HomePage homePage = new HomePage(driver);
//        EventPage eventPage =homePage.clickBannerAndReturnPage();
//        String expectTitle = "大会";
//        eventPage.waitTitleContains(5,expectTitle);

//        String expectTitle = "大会";
        String expectTitle = FileUtils.readYmlFile(FileUtils.getPath("/clickBanner.yml"),"expectTitle");
        // 简单的写
        new HomePage(driver).clickBannerAndReturnPage().waitTitleContains(5,expectTitle);
        Thread.sleep(2000);
    }

    @AfterMethod
    private void teardown() {
        driver.quit();
    }
}
