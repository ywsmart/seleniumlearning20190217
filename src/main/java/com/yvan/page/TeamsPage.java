package com.yvan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Function：
 *
 * @author yawa1hz1
 * @date 2019/2/18
 * Created by yawa1hz1 on 2019/2/18 13:13.
 */
public class TeamsPage extends NavBarPage {
    @FindBy(xpath = "//a[contains(@href,\"/topics/\")][1]")
    public WebElement firstTopic;

    @FindBy(css = "a[data-name=\"霍格沃兹测试学院\"]")
    public WebElement hogwartsTeamButton;

    public TeamsPage(WebDriver driver) {
        super(driver);
    }

    public TeamsPage clickHogwartsTeam() {
        hogwartsTeamButton.click();
        return this;
    }

    public void clickFirstTopics() {
        firstTopic.click();
    }

}
