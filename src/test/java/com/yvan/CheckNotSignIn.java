package com.yvan;

import com.yvan.page.HomePage;
import com.yvan.utils.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/24
 * Created by yawa1hz1 on 2019/2/24 14:09.
 */
public class CheckNotSignIn {
    WebDriver driver = null;
    @BeforeMethod
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void notSIngnInTest() throws Exception{
        driver.get(FileUtils.readYmlFile(FileUtils.getPath("/config.yml"),"url"));
        HomePage homePage = new HomePage(driver);
        homePage.clickNavByTest(FileUtils.readYmlFile(FileUtils.getPath("/notSignIn.yml"),"menu"));
    }

}
