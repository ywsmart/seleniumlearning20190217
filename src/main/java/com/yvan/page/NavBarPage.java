package com.yvan.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

/**
 * Function：导航PO类
 *
 * @author yawa1hz1
 * @date 2019/2/17
 * Created by yawa1hz1 on 2019/2/17 14:14.
 */
public class NavBarPage {
    WebDriver driver;

    /**
     * 搜索输入框
     */
    @FindBy(tagName = "input")
    private
    WebElement searchWebElement;
    /**
     * 社团按钮
     */
    @FindBy(css = "a[href='/teams']")
    private
    WebElement teamsButton;

    public NavBarPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void searchKeyWord(String value) {
        searchWebElement.clear();
        searchWebElement.sendKeys(value);
        Reporter.log("搜索关键词-" + value, true);
    }

    public SearchResultPage gotoSearchResult(String value){
        searchKeyWord(value);
        // 执行键盘回车
        Actions action =new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        return new SearchResultPage(driver);
    }

    public TeamsPage gotoTeamsPage(){
        teamsButton.click();
        System.out.println("点击社团");
        return new TeamsPage(driver);
    }
}
