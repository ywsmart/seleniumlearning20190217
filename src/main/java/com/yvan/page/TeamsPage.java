package com.yvan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/18
 * Created by yawa1hz1 on 2019/2/18 13:13.
 */
public class TeamsPage extends NavBarPage {
    /**
     * 第一个帖子
     */
    @FindBy(xpath = "//*[@class=\"title media-heading\"]/a")
    public List<WebElement> firstTopics;

    @FindBy(css = ".media-body .media-heading a")
    List<WebElement> topicsElement;
    /**
     * 霍格沃兹社团按钮
     */
    @FindBy(css = "a[data-name=\"霍格沃兹测试学院\"]")
    public WebElement hogwartsTeamButton;

    public TeamsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
//        wait.until(ExpectedConditions.titleContains("社团"));
    }

    public TeamsPage clickHogwartsTeam() {
        hogwartsTeamButton.click();
        System.out.println("点击霍格沃兹社团");
        wait.until(ExpectedConditions.titleIs("TesterHome"));
        return new TeamsPage(driver);
    }

    public void clickFirstTopics() {
//        firstTopics.get(0).click();
        topicsElement.get(0).click();
        System.out.println("点击第一个帖子");
        wait.until(ExpectedConditions.titleContains("登录"));
    }

}
