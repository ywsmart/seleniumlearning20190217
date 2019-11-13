package com.yvan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-02-25
 * Created by YangWang on 2019-02-25 22:45.
 */
public class SignInPage {
    WebDriverWait wait;
    @FindBy(css = ".alert")
    WebElement alertMsg;

    public SignInPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.titleContains("登录"));
    }

    public String getAlertMsg() {
        return alertMsg.getText().trim();
    }
}
