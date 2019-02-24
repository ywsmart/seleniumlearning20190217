package com.yvan.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    @FindBy(xpath = "//a[contains(@href,\"/topics/\")][1]")
    public WebElement firstTopic;

    /**
     * 霍格沃兹社团按钮
     */
    @FindBy(css = "a[data-name=\"霍格沃兹测试学院\"]")
    public WebElement hogwartsTeamButton;

    public TeamsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        wait.until(ExpectedConditions.titleContains("社团"));
    }

    public TeamsPage clickHogwartsTeam() {
        hogwartsTeamButton.click();
        System.out.println("点击霍格沃兹社团");
        return new TeamsPage(driver);
    }

    public void clickFirstTopics() {
        firstTopic.click();
        System.out.println("点击第一个帖子");
    }

}
