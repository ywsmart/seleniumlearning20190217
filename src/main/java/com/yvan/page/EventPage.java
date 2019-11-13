package com.yvan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 15:15.
 */
public class EventPage {
    WebDriver driver;

    public EventPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void waitTitleContains(long time, String partTitle) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.titleContains(partTitle));
    }
}
