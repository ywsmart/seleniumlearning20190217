package com.yvan;

import com.yvan.page.HomePage;
import com.yvan.page.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 9:55.
 */
public class SearchKeyWord {

    private WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        // 设置最大化参数
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
    }

    @Test
    private void searchTest() throws InterruptedException {
        driver.get("https://testerhome.com");
        String value = "selenium";
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.gotoSearchResult(value);
        String keyword = "selenium";
        int i = 0;
        List<String> assertMsg = new ArrayList<>();
        for (String topic : searchResultPage.returnTopicsTitle()) {
            System.err.println("正在校验"+i+++ "条数据");
            if (!topic.contains(keyword)){
                assertMsg.add("期待的标题不包含" + value + "实际为" + topic);
            }
        }
        if (assertMsg.isEmpty())
        Assert.assertTrue(false, assertMsg.toString());
        Thread.sleep(2000);
    }

    @AfterMethod
    private void teardown() {
        driver.quit();
    }
}
