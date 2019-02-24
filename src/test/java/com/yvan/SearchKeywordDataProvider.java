package com.yvan;

import com.yvan.page.HomePage;
import com.yvan.page.SearchResultPage;
import com.yvan.utils.FileUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 16:10.
 */
public class SearchKeywordDataProvider {
    WebDriver driver = null;
    String url = "";

    @BeforeMethod
    private void setup() throws Exception {
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        // 设置最大化参数
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        url = FileUtils.readYmlFile(FileUtils.getPath("/config.yml"), "url");
    }

    @DataProvider
    public Iterator<Object[]> getData() throws Exception {
        String filePath = SearchKeywordDataProvider.class.getResource("/2.csv").getPath();
        System.out.println(filePath);
        return FileUtils.readCsvFile(filePath);
    }

    @Test(dataProvider = "getData")
    public void test(String value) throws Exception {
        driver.get("https://testerhome.com");
        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = homePage.gotoSearchResult(value);
    }

    @AfterMethod
    private void teardown() {
        driver.quit();
    }
}
