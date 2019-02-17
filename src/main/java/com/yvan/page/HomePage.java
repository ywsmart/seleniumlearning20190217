package com.yvan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

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
    }

    public void clickBanner() {
        banner.click();
        Reporter.log("点击图片",true);
    }
}
