package com.yvan;

import com.yvan.page.HomePage;
import com.yvan.page.TeamsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/18
 * Created by yawa1hz1 on 2019/2/18 13:38.
 */
public class GotoTeam {
    WebDriver driver = null;

    @BeforeMethod
    private void setup() {
        ChromeOptions options = new ChromeOptions();
        // 设置最大化参数
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test() throws Exception {
        driver.get("https://testerhome.com");
        TeamsPage teamsPage = new TeamsPage(driver);
        teamsPage.gotoTeamsPage().clickHogwartsTeam().clickFirstTopics();
        String value = "\"期待的标题不包含\"+value+\"实际为\"+actualMsg";
        Assert.assertTrue(driver.getPageSource().contains("访问被拒绝，你可能没有权限或未登录。"),"期待的提示不包含"+value);
        Thread.sleep(10000);
    }

    @AfterMethod
    private void teardown() {
        driver.quit();
        driver.close();
    }
}
