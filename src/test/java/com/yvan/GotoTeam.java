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
 * Function：未登录状态下
 * 1、打开testerhome主页
 * 2、点击社团
 * 3、点击霍格沃兹测试学院
 * 4、点击话题列表中的第一个
 * 5、验证 访问被拒绝 字符串出现
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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test() throws Exception {
        // 1、打开testerhome主页
        driver.get("https://testerhome.com");
        HomePage homePage = new HomePage(driver);
        // 2、点击社团
        TeamsPage teamsPage = homePage.gotoTeamsPage();
        // 3、点击霍格沃兹测试学院
        teamsPage.clickHogwartsTeam();
        Thread.sleep(2000);
        // 4、点击话题列表中的第一个
        teamsPage.clickFirstTopics();
        Thread.sleep(2000);
        String value = "\"期待的标题不包含\"+value+\"实际为\"+actualMsg";
        // 5、验证 访问被拒绝 字符串出现
        Assert.assertTrue(driver.getPageSource().contains("访问被拒绝，你可能没有权限或未登录。"), "期待的提示不包含" + value);
    }

    @AfterMethod
    private void teardown() {
        driver.quit();
    }
}
