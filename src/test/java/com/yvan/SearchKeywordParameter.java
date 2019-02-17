package com.yvan;

import com.yvan.page.HomePage;
import com.yvan.page.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 16:10.
 */
public class SearchKeywordParameter {
    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        // 设置最大化参数
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] o = {
                {"selenium"},
                {"testng"}
        };
        return o;
    }

    @Test(dataProvider = "getData")
    private void test(String value) throws Exception{
        driver.get("https://testerhome.com");
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage =homePage.gotoSearchResult(value);
    }
    @AfterMethod
    private void teardown() {
        driver.quit();
    }
}
