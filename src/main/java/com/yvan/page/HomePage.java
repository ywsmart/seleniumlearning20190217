package com.yvan.page;

import com.yvan.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.Set;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 14:18.
 */
public class HomePage extends NavBarPage {
    @FindBy(css = ".content img")
    WebElement banner;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void clickBanner() {
        banner.click();
        Reporter.log("点击图片",true);
    }

    public EventPage clickBannerAndReturnPage(){
        String handle1 = driver.getWindowHandle();
        Set<String> handes = driver.getWindowHandles();
        Reporter.log("原窗口是"+handle1,true);
        clickBanner();
        SeleniumUtils.switchWindow(driver,5,handes);
        return new EventPage(driver);
    }
}
